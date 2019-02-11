package com.czy.op.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czy.op.model.User;
import com.czy.op.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	/*属性*/
	@Resource
	private UserService userService;
	/**
	 * 用户名检测
	 * @param username	方法一：直接从前台获取参数
	 * @param request	方法二：通过请求（request）获取参数
	 * @param response
	 */
	@RequestMapping("searchUserByName")
	public void searchUserByName(String username, HttpServletResponse response){
		User user = new User(username, null);
		User userinf = userService.searchUserByName(user);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userinf == null) {//没有匹配数据
			pw.write("0");//Ajax返回数据
		} else {//有匹配用户，用户已存在
			pw.write("1");//Ajax返回数据
		}
		pw.flush();
		pw.close();
	}
	/**
	 * 用户注册
	 * @param account
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("register")
	public String register(String account, String password, HttpServletRequest request, HttpServletResponse response){
		User user = new User(account, password, 1);
		userService.register(user);
		return "redirect:login.jsp";
	}
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 */
	@RequestMapping("login")
	public void login(String username, String password, int userclass, HttpServletRequest request, HttpServletResponse response){
		User user = userService.userLogin(new User(username, password, userclass));
		try {
			PrintWriter pw = response.getWriter();
			if (user != null) {
				pw.write("1");
				request.getSession().setAttribute("userInformation", user);
			} else {
				pw.write("0");
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 用户表注销
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("logout")
	public String userLogout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
		return "redirect:index.jsp";
	}
	
}
