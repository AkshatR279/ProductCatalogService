package com.pratice.productcatalogservice.model.general;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class APIResponse {
    @Builder.Default
    private Boolean success = false;

    @Builder.Default
    private String message = "Failed to perform task.";

    @Builder.Default
    private String internalMessage = "Failed to perform task.";

    @Builder.Default
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    private Object data;
}
