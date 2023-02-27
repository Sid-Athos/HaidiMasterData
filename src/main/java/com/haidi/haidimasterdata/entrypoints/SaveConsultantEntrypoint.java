package com.haidi.haidimasterdata.entrypoints;

import com.haidi.haidimasterdata.api.mappers.AvailabilityMapper;
import com.haidi.haidimasterdata.api.mappers.SpecialtyMapper;
import com.haidi.haidimasterdata.api.requests.SaveConsultantRequest;
import com.haidi.haidimasterdata.domain.pojo.CreateConsultantCommand;
import com.haidi.haidimasterdata.domain.ports.in.ConsultantCreator;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultants")
public class SaveConsultantEntrypoint {

    private final ConsultantCreator consultantCreator;

    public SaveConsultantEntrypoint(ConsultantCreator consultantCreator) {
        this.consultantCreator = consultantCreator;
    }


    @ApiResponse(responseCode = "200", description = "Created product database Identifier")
    @PostMapping(value = "/addConsultant", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long addConsultant(@RequestBody SaveConsultantRequest consultantRequest){

        final var command = CreateConsultantCommand.createOne(
                consultantRequest.userName,
                consultantRequest.description,
                SpecialtyMapper.INSTANCE.toDomain(consultantRequest.specialtyRequest),
                AvailabilityMapper.INSTANCE.toDomain(consultantRequest.availabilities),
                consultantRequest.dailyRate);

       return consultantCreator.saveConsultant(command);
    }

    @PutMapping(value = "/updateConsultant", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "204", description = "Successfully updated product")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void saveConsultant(@RequestBody SaveConsultantRequest consultantRequest){
        final var command = CreateConsultantCommand.createOne(
                consultantRequest.userName,
                consultantRequest.description,
                SpecialtyMapper.INSTANCE.toDomain(consultantRequest.specialtyRequest),
                AvailabilityMapper.INSTANCE.toDomain(consultantRequest.availabilities),
                consultantRequest.dailyRate);
        consultantCreator.saveConsultant(command);
    }

}
