package pers.linxi.shop.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import pers.linxi.shop.entity.User;
import pers.linxi.shop.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户模块的Action类
 * 
 * @author 林曦
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;
	private String securityCode; //验证码

	public User getModel() {
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	/**
	 * 跳转到注册页面的方法
	 */
	public String registerPage() {
		return "registerPage";
	}

	/**
	 * Ajax进行异步校验用户名的方法
	 * @throws IOException 
	 */
	public String findByName() throws IOException {
		User exisUser = userService.findByUser(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exisUser != null){
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}
		else{
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	/**
	 * 用户注册的方法
	 */
	public String register() {
		//判断用户输入的验证码是否正确
		String checkcode = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(securityCode)) {
			this.addActionMessage("验证码输入不正确");
			return "registerPage";
		}
		userService.save(user);
		this.addActionMessage("注册成功，请去邮箱激活！");
		return "msg";
	}
	
	/**
	 * 用户激活的方法
	 */
	public String userActive() {
		User existUser = userService.findByUser(user.getCode());
		if(existUser == null) {
			//激活码不正确，用户为空
			this.addActionMessage("激活失败，激活码不正确！");
		}
		else {
			//激活成功,用户状态为1，激活码为空
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功，请登录");
		}
		return "msg";
	}
	
	/**
	 * 跳转到登录页面
	 */
	
	public String loginPage() {
		return "loginPage";
	}
	
	/**
	 * 用户登录
	 */
	public String login(){
		User existUser = userService.login(user);
		if (existUser != null) {
			//登录成功,将用户的信息存入到session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess"; 
		}
		else{
			//登录失败
			this.addActionMessage("用户名或者密码输入失败或者用户未激活");
 			return "loginPage";
		}
	}
	
	/**
	 * 用户退出的方法
	 * @return
	 */
	public String exit() {
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}
}
