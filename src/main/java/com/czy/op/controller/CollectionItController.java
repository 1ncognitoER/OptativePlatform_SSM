package com.czy.op.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.czy.op.model.CollectionIt;
import com.czy.op.model.User;
import com.czy.op.service.CollectionItService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CollectionItController {
	/*属性*/
	@Resource
	private CollectionItService collectionItService;
	/**
	 * 添加关注
	 * @param carid
	 * @param request
	 * @param response
	 */
	@RequestMapping("collection")
	public void collection(String carid, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		int carId = Integer.parseInt(carid);
		try {
			PrintWriter pw = response.getWriter();
			User user = (User) session.getAttribute("userInformation");
			if (user != null) {//用户已登录，添加收藏
				CollectionIt collectionIt = new CollectionIt(user.getUserId(), carId);
				collectionItService.addCollection(collectionIt);//添加关注
				pw.write("1");
			} else {//用户没有登录
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
	 * 获取用户收藏信息
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("searchUserCollection")
	@ResponseBody
	public Object searchUserCollection(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User user = (User) session.getAttribute("userInformation");
		if (user != null) {//用户已登录，查询收藏
			CollectionIt collections = collectionItService.searchAllCollection(new CollectionIt(user.getUserId(), 0));//查询用户id关注
			if (collections!=null) {//存在收藏数据，直接返回收藏数据
				return collections;
			} else {//不存在收藏数据,新建一个userId为0的对象返回Ajax
				CollectionIt col = new CollectionIt(0, 0, null);
				return col;
			}
		} else {//未登录，新建一个userId为-1的对象返回Ajax
			CollectionIt coll = new CollectionIt(-1, 0, null);
			return coll;
		}
	}
	/**
	 * 取消关注
	 * @param carid
	 * @param request
	 * @param response
	 * @param session
	 */
	@RequestMapping("unsubscribe")
	public void unsubscribe(String carid, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int carId = Integer.parseInt(carid);//获取汽车id
		User user = (User) session.getAttribute("userInformation");//从session中获得用户id
		CollectionIt collectionIt = new CollectionIt(user.getUserId(), carId);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			collectionItService.unsubscribe(collectionIt);
			pw.write("1");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			pw.write("0");
			pw.flush();
			pw.close();
		}
	}
	
}
