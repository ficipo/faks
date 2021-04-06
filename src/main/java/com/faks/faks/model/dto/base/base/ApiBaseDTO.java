package com.faks.faks.model.dto.base.base;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiBaseDTO<T> {
    private boolean success;
    private ApiErrorDTO error;
    private T response;


    public static <T> ApiBaseDTO<T> generateSuccessResponse(T response) {
        return ApiBaseDTO.<T>builder()
                .error(null)
                .success(true)
                .response(response)
                .build();
    }


    public static <T> ApiBaseDTO<T> generateErrorResponse(ErrorInfo errorInfo) {
        return ApiBaseDTO.<T>builder()
                .error(new ApiErrorDTO(errorInfo.getMessageKey(), errorInfo.getMessage()))
                .success(false)
                .build();
    }

}
