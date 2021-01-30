package com.sxt.handler;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sxt.utils.ResultObj;

/**
 * 全局异常监控
 * @author LJH
 *
 */
@RestControllerAdvice
public class GlobalExceptionHanderAdvise {
	/**
	 * 未授权
	 * 只要当前项目的代码抛出UnauthorizedException就会回调
	 */
	@ExceptionHandler(value= {UnauthorizedException.class})
	public ResultObj unauthorized() {
		return ResultObj.UNAUTHORIZED;
	}
}
