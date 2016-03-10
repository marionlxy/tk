package com.taikang.udp.sys.shiro.security;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码异常处理类
 * @author Johnny
 */
public class CaptchaException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public CaptchaException() {
		super();
	}

	public CaptchaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CaptchaException(String message) {
		super(message);
	}

	public CaptchaException(Throwable cause) {
		super(cause);
	}

}
