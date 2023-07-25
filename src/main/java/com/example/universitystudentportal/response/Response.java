package com.example.universitystudentportal.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.ComponentScan;

import java.io.Serializable;

@JsonDeserialize
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ComponentScan
public class Response <T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "statusCode")
    private int statusCode;
    private boolean success;
    private String message;
    @JsonProperty(value = "responseBody")
    private T responseBody;

    public Response(int statusCode, String message) {
        this.statusCode = (statusCode == 200 || statusCode == 0) ? statusCode : 500;
        this.success = statusCode == 200 || statusCode == 0;
        this.message = message;
        this.responseBody = null;

    }

    public Response(int statusCode, boolean success, String message) {
        this.statusCode = (statusCode == 200 || statusCode == 0) ? statusCode : 500;
        this.success = statusCode == 200 || statusCode == 0;
        this.message = message;
        this.responseBody = null;

    }

    public Response(int statusCode, boolean success, String message, T responseBody) {
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.responseBody = responseBody;
    }

    @JsonIgnore
    public Response<T> buildErrorResponse(String message) {
        this.message = message;
        this.success = false;
        this.success = false;
        this.responseBody = null;
        this.statusCode = 500;
        return this;
    }

    /**
     *
     * @param data
     * @return
     */
    @JsonIgnore
    public Response<T> buildSuccessResponse(final T data) {
        this.message = "Success";
        this.responseBody = data;
        this.success = true;
        this.statusCode = 0;
        return this;
    }

    /**
     *
     * @param message
     * @param data
     * @return
     */
    @JsonIgnore
    public Response<T> buildSuccessResponse(String message, final T data) {
        this.message = message;
        this.responseBody = data;

        this.success = true;
        this.statusCode = 201;
        return this;
    }

    /**
     *
     * @return
     */
    @JsonIgnore
    public Response<T> buildErrorResponse() {
        this.message = "fail";
        this.responseBody = null;
        this.success = false;
        this.statusCode = 500;
        return this;
    }

    /**
     *
     * @param code
     * @param message
     * @return
     */
    @JsonIgnore
    public Response<T> buildErrorResponse(int code, String message) {
        this.message = message;
        this.responseBody = null;
        this.success = false;
        this.statusCode = code;
        return this;
    }

    /**
     *
     * @param message
     * @param data
     * @return
     */
    @JsonIgnore
    public Response<T> buildErrorResponse(String message, final T data) {
        this.message = message;
        this.responseBody = data;
        this.success = false;
        this.statusCode = 500;
        return this;
    }
}
