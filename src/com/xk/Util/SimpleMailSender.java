package com.xk.Util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.aspectj.util.FileUtil;

//第三个类：SimpleMailSender.java，用来发送邮件类。
public class SimpleMailSender {
	 public boolean sendAttahchMail(MailSenderInfo mailInfo){
		  
		 // 判断是否需要身份认证
		  MyAuthenticator authenticator = null;
		  Properties pro = mailInfo.getProperties();
		  
		  if (mailInfo.isValidate()) {
			  // 如果需要身份认证，则创建一个密码验证器
			  authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		  }
		  // 根据邮件会话属性和密码验证器构造一个发送邮件的session
		  Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		  
		  try {
			   // 根据session创建一个邮件消息
			   Message mailMessage = new MimeMessage(sendMailSession);
			   // 创建邮件发送者地址
			   Address from = new InternetAddress(mailInfo.getFromAddress());
			   // 设置邮件消息的发送者
			   mailMessage.setFrom(from);
			   // 创建邮件的接收者地址，并设置到邮件消息中
			   Address to = new InternetAddress(mailInfo.getToAddress());
			   mailMessage.setRecipient(Message.RecipientType.TO, to);
			   // 设置邮件消息的主题
			   mailMessage.setSubject(mailInfo.getSubject());
			   // 设置邮件消息发送的时间
			   mailMessage.setSentDate(new Date());

			   Multipart multipart = new MimeMultipart();   

			   //邮件正文  
	           BodyPart contentPart = new MimeBodyPart();  
	           contentPart.setText(mailInfo.getContent());
	            
	           multipart.addBodyPart(contentPart);  
	           
		//	   MimeMultipart msgMultipart = new MimeMultipart("mixed");// 指定为混合关系  
			   
	           String filename=mailInfo.getAttachFileNames();

	           if(filename!=null){
	                   BodyPart attachmentPart = new MimeBodyPart();  
	                   DataSource source = new FileDataSource(filename);  
	                   attachmentPart.setDataHandler(new DataHandler(source));  
	                   //避免中文乱码的处理  
	                   try {
					  	attachmentPart.setFileName(MimeUtility.encodeWord(filename));
				       } catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			           }  
	                   multipart.addBodyPart(attachmentPart);  
	           }  
	           
	           mailMessage.setContent(multipart);  
	           mailMessage.saveChanges(); 
	           
			   // 发送邮件
			   Transport.send(mailMessage);
			   return true;
		  } catch (MessagingException ex) {
			  ex.printStackTrace();
		  }
		  return false;
	}
 public boolean sendTextMail(MailSenderInfo mailInfo) {
	  
	 // 判断是否需要身份认证
	  MyAuthenticator authenticator = null;
	  Properties pro = mailInfo.getProperties();
	  
	  if (mailInfo.isValidate()) {
		  // 如果需要身份认证，则创建一个密码验证器
		  authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
	  }
	  // 根据邮件会话属性和密码验证器构造一个发送邮件的session
	  Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
	  
	  try {
		   // 根据session创建一个邮件消息
		   Message mailMessage = new MimeMessage(sendMailSession);
		   // 创建邮件发送者地址
		   Address from = new InternetAddress(mailInfo.getFromAddress());
		   // 设置邮件消息的发送者
		   mailMessage.setFrom(from);
		   // 创建邮件的接收者地址，并设置到邮件消息中
		   Address to = new InternetAddress(mailInfo.getToAddress());
		   mailMessage.setRecipient(Message.RecipientType.TO, to);
		   // 设置邮件消息的主题
		   mailMessage.setSubject(mailInfo.getSubject());
		   // 设置邮件消息发送的时间
		   mailMessage.setSentDate(new Date());
		   // 设置邮件消息的主要内容
		   String mailContent = mailInfo.getContent();
		   mailMessage.setText(mailContent);
		   // 发送邮件
		   Transport.send(mailMessage);
		   return true;
	  } catch (MessagingException ex) {
		  ex.printStackTrace();
	  }
	  return false;
}

 
 public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
  
	  // 判断是否需要身份认证
	  MyAuthenticator authenticator = null;
	  Properties pro = mailInfo.getProperties();
	  
	  // 如果需要身份认证，则创建一个密码验证器
	  if (mailInfo.isValidate()) {
		  authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
	  }
	  
	  // 根据邮件会话属性和密码验证器构造一个发送邮件的session
	  Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
	  
	  try {
		   // 根据session创建一个邮件消息
		   Message mailMessage = new MimeMessage(sendMailSession);
		   // 创建邮件发送者地址
		   Address from = new InternetAddress(mailInfo.getFromAddress());
		   // 设置邮件消息的发送者
		   mailMessage.setFrom(from);
		   // 创建邮件的接收者地址，并设置到邮件消息中
		   Address to = new InternetAddress(mailInfo.getToAddress());
		   // Message.RecipientType.TO属性表示接收者的类型为TO
		   mailMessage.setRecipient(Message.RecipientType.TO, to);
		   // 设置邮件消息的主题
		   mailMessage.setSubject(mailInfo.getSubject());
		   // 设置邮件消息发送的时间
		   mailMessage.setSentDate(new Date());
		   // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
		   Multipart mainPart = new MimeMultipart();
		   // 创建一个包含HTML内容的MimeBodyPart
		   BodyPart html = new MimeBodyPart();
		   // 设置HTML内容
		   html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
		   mainPart.addBodyPart(html);
		   // 将MiniMultipart对象设置为邮件内容
		   mailMessage.setContent(mainPart);
		   // 发送邮件
		   Transport.send(mailMessage);
		   return true;
	  } catch (MessagingException ex) {
		  ex.printStackTrace();
	  }
	  return false;
 	}

} 
