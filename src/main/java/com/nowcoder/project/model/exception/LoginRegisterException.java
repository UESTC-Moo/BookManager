package com.nowcoder.project.model.exception;

/**
 * 注册和登陆异常
 */
public class LoginRegisterException extends Exception {
    public LoginRegisterException() {
        super();
    }

    public LoginRegisterException(String message) {
        super(message);
    }

    public LoginRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginRegisterException(Throwable cause) {
        super(cause);
    }
}
