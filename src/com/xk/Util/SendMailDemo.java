package com.xk.Util;

import com.xk.ActivitiUtil.EnumData;
import com.xk.orm.HistoryEmail;


public class SendMailDemo {
	
	
	 public void run(HistoryEmail historyEmail) {
		  // 设置邮件服务器信息
		  MailSenderInfo mailInfo = new MailSenderInfo();
		  mailInfo.setMailServerHost(EnumData.serverHost);
		  mailInfo.setMailServerPort(EnumData.serverPort);
		  mailInfo.setValidate(true);
		 // String email = new ComSiteBean().getEmail(acompany, asite);
		  
		  // 邮箱用户名
		  mailInfo.setUserName(EnumData.serverName);
		  // 邮箱密码
		  mailInfo.setPassword(EnumData.serverPwd);
		  // 发件人邮箱
		  mailInfo.setFromAddress(historyEmail.getSendaddress());
		  // 收件人邮箱
		  mailInfo.setToAddress(historyEmail.getToaddress());
		  // 邮件标题
		  mailInfo.setSubject(historyEmail.getSubject());
		  // 邮件内容
		  //StringBuffer buffer = new StringBuffer();
		  //buffer.append("报警公司名: " + acompany + "\n报警主机名: " + asite + "\n报警类型: " + type);
		  mailInfo.setContent(historyEmail.getContext());
		  //附件
		  mailInfo.setAttachFileNames(historyEmail.getSenddocpath());
	      // 发送邮件
	 	 SimpleMailSender sms = new SimpleMailSender();
	 	 sms.sendAttahchMail(mailInfo);
	 	 // 发送文体格式
	 	// sms.sendTextMail(mailInfo);
		  // 发送html格式
//		  SimpleMailSender.sendHtmlMail(mailInfo);
	 	 System.out.println("邮件已发送");
	 }
	 public static void main(String[] args) {
		HistoryEmail email=new HistoryEmail();
		email.setSendaddress(EnumData.SendAddress);
		email.setToaddress(EnumData.SendAddress);
		email.setSubject("test");
		email.setContext("qqqqq");
		email.setSenddocpath("E:\\myeclipse 2015\\workspace\\.metadata\\.me_tcat7\\webapps\\SXDGMS2\\EmailFile\\artifacts.xml");
		System.out.println();
		new SendMailDemo().run(email);
	}
	} 
