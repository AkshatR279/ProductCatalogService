package com.pratice.productcatalogservice.model.general;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class APIResponse {
    private Boolean success;
    private String message;
    private String internalMessage;
    private HttpStatus status;
    private Object data;

    public APIResponse(){
        success = false;
        message = "Failed to perform task.";
        internalMessage = "Failed to perform task.";
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        data = null;
    }
}
