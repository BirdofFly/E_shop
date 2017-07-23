package pers.linxi.shop.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 	发送邮件的工具类
 * @author 林曦
 *
 */
public class EmailUtil {
	/**
	 * 发送邮件的方法
	 */
	public static void sendMail(String to,String code){
		//1.获得一个Session对象
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jihuo@shop.com", "123456");
			}
			
		});
		//2.创建一个代表邮件的对象Message
		Message message = new MimeMessage(session);
		//2.1设置发件人
		try {
			message.setFrom(new InternetAddress("jihuo@shop.com"));
			//2.2设置收件人
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//2.3设置标题
			message.setSubject("网上商城账号注册激活邮件");
			//2.4设置邮件的正文
			message.setContent("点以下链接完成账号激活<br /><a href='http://192.168.0.7:6060/E-shop/user_userActive.action"
					+ "?code="+code+"'>http://192.168.0.7:6060/E-shop/user_userActive.action"
					+ "?code="+code+"</a>", "text/html;charset=UTF-8");
			//3.发送邮件
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
