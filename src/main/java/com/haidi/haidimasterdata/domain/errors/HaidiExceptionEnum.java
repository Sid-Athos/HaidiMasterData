package com.haidi.haidimasterdata.domain.errors;

import org.springframework.http.HttpStatus;

public enum HaidiExceptionEnum {
    DB_COMPONENT_CONNEXION_TIMEOUT(
            "DB",
            "An error occurred while performing the action",
            HttpStatus.REQUEST_TIMEOUT),
    DOMAIN_COMPONENT_ITEM_NOT_FOUND(
            "Domain",
            "Product code is already used",
            HttpStatus.BAD_REQUEST),
    DOMAIN_COMPONENT_INVALID_CARD_VALUE(
            "Domain",
            "An error occurred while performing the action",
            HttpStatus.BAD_REQUEST);


    private final String component;
    private final String userMessageToDisplay;
    private final HttpStatus httpResponseStatus;
    HaidiExceptionEnum(String component, String userMessageToDisplay
            , HttpStatus httpResponseStatus) {
        this.component = component;
        this.userMessageToDisplay = userMessageToDisplay;
        this.httpResponseStatus = httpResponseStatus;
    }

    public String getUserMessageToDisplay() { return userMessageToDisplay; }

    public String getComponent(){
        return component;
    }

    public HttpStatus getHttpResponseStatus() {
        return httpResponseStatus;
    }
}
