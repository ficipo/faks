package com.faks.faks.model.dto.base.base;

public enum ErrorInfo {
    GENERAL_ERROR("general", "An error has occurred. Please try again."),
    USER_DISABLED("userDisabled", "User is disabled!"),
    NO_IMAGE_TYPE("noImageType", "Passed image type does not exist!"),
    IMAGE_NOT_FOUND("imageNotFound", "Image with that url does not exist!");

    private String messageKey;
    private String message;

    ErrorInfo(String messageKey, String message) {
        this.messageKey = messageKey;
        this.message = message;
    }

    public String getMessageKey() {
        return this.messageKey;
    }

    public String getMessage() {
        return this.message;
    }
}

