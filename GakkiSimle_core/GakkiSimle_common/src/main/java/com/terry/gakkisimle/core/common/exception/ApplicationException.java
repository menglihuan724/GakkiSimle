package com.terry.gakkisimle.core.common.exception;

/**
 * 应用异常.
 * <p>
 * Created by terrymeng
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
