package org.example.qff.common.result;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/6 8:14
 **/
public class ResultUtils {
    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> QffResponse<T> success(T data) {
        return new QffResponse<>(200, data, "ok");
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static QffResponse success(int data) {
        return new QffResponse(200, data, "ok");
    }
    /**
     * 成功
     * @param message
     * @return
     */
    public static QffResponse success(String message) {
        return new QffResponse(200, null, message);
    }

    /**
     * 失败
     * @param errorCode
     * @return
     */
    public static QffResponse error(ErrorCode errorCode){
        return new QffResponse<>(errorCode.getCode(),null,errorCode.getMessage(),errorCode.getDescription())   ;
    }

    /**
     * 失败
     * @param errorCode
     * @return
     */
    public static QffResponse error(ErrorCode errorCode, String message, String description){
        return new QffResponse<>(errorCode.getCode(),description)   ;
    }

    /**
     * 失败
     * @param code
     * @return
     */
    public static QffResponse error(int code, String message, String description){
        return new QffResponse<>(code,null,message,description)   ;
    }
    /**
     * 失败
     * @param errorCode
     * @return
     */
    public static QffResponse error(ErrorCode errorCode, String description){
        return new QffResponse<>(errorCode.getCode(),null,errorCode.getMessage(),description)   ;
    }

}
