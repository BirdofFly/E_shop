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
 * 	�����ʼ��Ĺ�����
 * @author ����
 *
 */
public class EmailUtil {
	/**
	 * �����ʼ��ķ���
	 */
	public static void sendMail(String to,String code){
		//1.���һ��Session����
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jihuo@shop.com", "123456");
			}
			
		});
		//2.����һ�������ʼ��Ķ���Message
		Message message = new MimeMessage(session);
		//2.1���÷�����
		try {
			message.setFrom(new InternetAddress("jihuo@shop.com"));
			//2.2�����ռ���
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//2.3���ñ���
			message.setSubject("�����̳��˺�ע�ἤ���ʼ�");
			//2.4�����ʼ�������
			message.setContent("��������������˺ż���<br /><a href='http://192.168.0.7:6060/E-shop/user_userActive.action"
					+ "?code="+code+"'>http://192.168.0.7:6060/E-shop/user_userActive.action"
					+ "?code="+code+"</a>", "text/html;charset=UTF-8");
			//3.�����ʼ�
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
