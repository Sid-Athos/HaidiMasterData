package com.haidi.haidimasterdata.domain.errors;

public class HaidiException extends RuntimeException{
    private final HaidiExceptionBodyResponse exceptionEnum;
    public HaidiExceptionBodyResponse getResponse() {
        return exceptionEnum;
    }

    public HaidiException(HaidiExceptionEnum exception) {
        super(exception.getUserMessageToDisplay());
        exceptionEnum = new HaidiExceptionBodyResponse(exception.getHttpResponseStatus(), exception.getUserMessageToDisplay(), exception.getComponent());
    }
}
