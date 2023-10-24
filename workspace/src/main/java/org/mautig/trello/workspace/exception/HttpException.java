package org.mautig.trello.workspace.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HttpException extends RuntimeException {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<HttpSubError> subErrors;

    private HttpException() {
        this.timestamp = LocalDateTime.now();
    }

    public HttpException(HttpStatus status) {
        this();
        this.status = status;
    }

    public HttpException(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected exception";
        this.debugMessage = ex.getMessage();
    }

    public HttpException(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<HttpSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<HttpSubError> subErrors) {
        this.subErrors = subErrors;
    }

}
