package com.haidi.haidimasterdata.domain.errors;

import org.springframework.http.HttpStatus;

public record HaidiExceptionBodyResponse(HttpStatus httpResponseStatus, String errorMessage, String errorOrigin) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HaidiExceptionBodyResponse that = (HaidiExceptionBodyResponse) o;

        if (httpResponseStatus != that.httpResponseStatus) return false;
        if (!errorMessage.equals(that.errorMessage)) return false;
        return errorOrigin.equals(that.errorOrigin);
    }

    @Override
    public String toString() {
        return "CleanCodeBodyResponse{" +
                "responseStatus=" + httpResponseStatus +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorOrigin='" + errorOrigin + '\'' +
                '}';
    }
}
