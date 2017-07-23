package pers.linxi.shop.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import pers.linxi.shop.entity.User;
import pers.linxi.shop.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �û�ģ���Action��
 * 
 * @author ����
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;
	private String securityCode; //��֤��

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
	 * ��ת��ע��ҳ��ķ���
	 */
	public String registerPage() {
		return "registerPage";
	}

	/**
	 * Ajax�����첽У���û����ķ���
	 * @throws IOException 
	 */
	public String findByName() throws IOException {
		User exisUser = userService.findByUser(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exisUser != null){
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		}
		else{
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}
	
	/**
	 * �û�ע��ķ���
	 */
	public String register() {
		//�ж��û��������֤���Ƿ���ȷ
		String checkcode = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(securityCode)) {
			this.addActionMessage("��֤�����벻��ȷ");
			return "registerPage";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�����ȥ���伤�");
		return "msg";
	}
	
	/**
	 * �û�����ķ���
	 */
	public String userActive() {
		User existUser = userService.findByUser(user.getCode());
		if(existUser == null) {
			//�����벻��ȷ���û�Ϊ��
			this.addActionMessage("����ʧ�ܣ������벻��ȷ��");
		}
		else {
			//����ɹ�,�û�״̬Ϊ1��������Ϊ��
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("����ɹ������¼");
		}
		return "msg";
	}
	
	/**
	 * ��ת����¼ҳ��
	 */
	
	public String loginPage() {
		return "loginPage";
	}
	
	/**
	 * �û���¼
	 */
	public String login(){
		User existUser = userService.login(user);
		if (existUser != null) {
			//��¼�ɹ�,���û�����Ϣ���뵽session��
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess"; 
		}
		else{
			//��¼ʧ��
			this.addActionMessage("�û���������������ʧ�ܻ����û�δ����");
 			return "loginPage";
		}
	}
	
	/**
	 * �û��˳��ķ���
	 * @return
	 */
	public String exit() {
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}
}
