package app.api.base.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by taesu at : 2019-03-07
 *
 * 여기에 ApiResponse 클래스에 대한 설명을 기술해주세요
 *
 * @author taesu
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
public final class ApiResponse {
    private Object result;
    private String message;

    private ApiResponse(Object result, String message) {
        this.result = result;
        this.message = message;
    }

    public static ApiResponse fromSuccessResult(Object result) {
        return new ApiResponse(result, "Success");
    }

    public static ApiResponse fromAll(Object result, String message) {
        return new ApiResponse(result, message);
    }
}
