package com.sxt.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.utils.ActivierUser;
import com.sxt.utils.ResultObj;

/**
 * 用户登陆控制器
 * @author LJH
 *
 */
@RequestMapping("login")
@RestController
public class LoginController {
	/**
	 * 做登陆
	 */
	@RequestMapping("login")  //http://127.0.0.1:8080/login/login?username=admin&pwd=123456
	public ResultObj login(String username,String pwd,HttpSession session) {
		//得到主体
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username, pwd);
		try {
			subject.login(token);
			System.out.println("登陆成功");
			ActivierUser activierUser = (ActivierUser) subject.getPrincipal();
			session.setAttribute("user", activierUser.getUser());
			return ResultObj.LOGIN_SUCCESS;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResultObj.LOGIN_ERROR;
		}
	}
}
