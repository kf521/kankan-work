package com.kankan.service.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kankan.service.exception.ResponseEnum;
import com.kankan.service.exception.SystemResponseEnum;
import java.io.Serializable;
import java.util.Date;

public class ApiResponse<T> implements Serializable {
    private Boolean success;
    private String code;
    private String message;
    private String timestamp;
    @JsonInclude(Include.NON_NULL)
    private T result;

    public ApiResponse() {
        this.timestamp = "" + (new Date()).getTime();
    }

    public ApiResponse(Boolean success, String code, String message, T result) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.result = result;
        this.timestamp = "" + (new Date()).getTime();
    }

    public static <T> ApiResponse success(String code, String message, T result) {
        return new ApiResponse(true, code, message, result);
    }

    public static <T> ApiResponse fail(String code, String message, T result) {
        return new ApiResponse(false, code, message, result);
    }

    public static <T> ApiResponse success() {
        return new ApiResponse(true, SystemResponseEnum.SUCCESS.getCode(), SystemResponseEnum.SUCCESS.getMessage(), (Object)null);
    }

    public static ApiResponse fail() {
        return new ApiResponse(false, SystemResponseEnum.SYSTEM_ERROR.getCode(), SystemResponseEnum.SYSTEM_ERROR.getMessage(), (Object)null);
    }

    public static <T> ApiResponse success(String message) {
        return new ApiResponse(true, SystemResponseEnum.SUCCESS.getCode(), message, (Object)null);
    }

    public static ApiResponse fail(String message) {
        return fail(SystemResponseEnum.SYSTEM_ERROR.getCode(), message, (Object)null);
    }


    public static ApiResponse fail(Exception e) {
        e.printStackTrace();
        return fail(SystemResponseEnum.SYSTEM_ERROR.getCode(), e.getMessage(), (Object)null);
    }

    public static <T> ApiResponse success(T result) {
        return new ApiResponse(true, SystemResponseEnum.SUCCESS.getCode(), SystemResponseEnum.SUCCESS.getMessage(), result);
    }

    public static <T> ApiResponse success(T result, String message) {
        return new ApiResponse(true, SystemResponseEnum.SUCCESS.getCode(), message, result);
    }

    public static ApiResponse fail(ResponseEnum responseEnum) {
        return fail(responseEnum, (Object)null);
    }

    public static <T> ApiResponse fail(ResponseEnum responseEnum, T result) {
        return fail(responseEnum.getCode(), responseEnum.getMessage(), result);
    }

    public static ApiResponse syserror() {
        return new ApiResponse(false, SystemResponseEnum.SYSTEM_ERROR.getCode(), SystemResponseEnum.SYSTEM_ERROR.getMessage(), (Object)null);
    }

    public static ApiResponse refresh_token() {
        return new ApiResponse(false, SystemResponseEnum.REFRESH_TOKEN.getCode(), SystemResponseEnum.REFRESH_TOKEN.getMessage(), (Object)null);
    }

    public String toString() {
        return "ApiResponse{success=" + this.success + ", code='" + this.code + '\'' + ", message='" + this.message + '\'' + ", timestamp='" + this.timestamp + '\'' + ", result=" + this.result + '}';
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public T getResult() {
        return this.result;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiResponse)) {
            return false;
        } else {
            ApiResponse<?> other = (ApiResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$success = this.getSuccess();
                    Object other$success = other.getSuccess();
                    if (this$success == null) {
                        if (other$success == null) {
                            break label71;
                        }
                    } else if (this$success.equals(other$success)) {
                        break label71;
                    }

                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                label57: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label57;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label57;
                    }

                    return false;
                }

                Object this$timestamp = this.getTimestamp();
                Object other$timestamp = other.getTimestamp();
                if (this$timestamp == null) {
                    if (other$timestamp != null) {
                        return false;
                    }
                } else if (!this$timestamp.equals(other$timestamp)) {
                    return false;
                }

                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result == null) {
                        return true;
                    }
                } else if (this$result.equals(other$result)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApiResponse;
    }


}
