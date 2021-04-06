package com.faks.faks.model.dto.base.base;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ApiBasePageDTO<T> {
    private List<T> response = new ArrayList<>();
    private PageDTO page;
    private boolean success;
    private ErrorInfo error;

    public static <T> ApiBasePageDTO<T> setApiPageResponse(List<T> response, PageDTO page) {
       ApiBasePageDTO<T> apiBasePageDTO = new ApiBasePageDTO<>();
        apiBasePageDTO.setPage(page);
        apiBasePageDTO.setResponse(response);
        apiBasePageDTO.setSuccess(!response.isEmpty());
        return apiBasePageDTO;
    }

    public static <T>ApiBasePageDTO<T> generateErrorResponse(ErrorInfo errorInfo) {
       ApiBasePageDTO<T> apiBaseDTO = new  ApiBasePageDTO<>();
        apiBaseDTO.setError(errorInfo);
        apiBaseDTO.setSuccess(false);
        return apiBaseDTO;
    }
}
