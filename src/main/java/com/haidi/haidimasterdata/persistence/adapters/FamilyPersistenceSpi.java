package com.haidi.haidimasterdata.persistence.adapters;

import com.haidi.haidimasterdata.domain.pojo.Family;
import com.haidi.haidimasterdata.domain.ports.out.FamilyPersistencePort;
import com.haidi.haidimasterdata.persistence.entities.HaidiFamily;
import com.haidi.haidimasterdata.persistence.repositories.FamilyRepository;
import com.jnape.palatable.lambda.adt.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FamilyPersistenceSpi implements FamilyPersistencePort {

    private final FamilyRepository familyRepository;

    @Autowired
    public FamilyPersistenceSpi(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public Long save(Family family) {
        HaidiFamily toSave = new HaidiFamily();
        setFamilyData(family, toSave);
        return familyRepository.save(toSave).getId();
    }

    @Override
    public void update(Family family) {
        HaidiFamily toSave = new HaidiFamily();
        toSave.setId(family.getId());
        setFamilyData(family, toSave);
        familyRepository.save(toSave);
    }

    @Override
    public Maybe<Family> findByCode(String code) {
        final var toReturn = familyRepository.findByDescription(code);
        if(toReturn != null ){
            Family foundFamily = Family.createFamilyToUpdate(toReturn.getId(), toReturn.getDescription(), toReturn.getParentId());
            return Maybe.maybe(foundFamily);
        }
        return Maybe.nothing();
    }

    @Override
    public Maybe<Family> findById(Long id) {
        final var toReturn = familyRepository.findById(id);
        if(toReturn.isPresent()){
            var found = toReturn.get();
            Family foundFamily = Family.createFamilyToUpdate(found.getId(), found.getDescription(), found.getParentId());
            return Maybe.maybe(foundFamily);
        }
        return Maybe.nothing();
    }

    @Override
    public List<Family> getAllFamiliesFromDb() {
        return familyRepository
                .findAll()
                .stream()
                .map(item -> Family.createFamilyToUpdate(
                        item.getId(),
                        item.getDescription(),
                        item.getParentId()))
                .collect(Collectors.toList());
    }

    private void setFamilyData(Family family, HaidiFamily toSave) {
        toSave.setDescription(family.getDescription());
        toSave.setParentId(family.getParentId());
    }
}
