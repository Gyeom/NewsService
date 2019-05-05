package com.example.spring02.service.email;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.inject.Inject;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.spring02.model.email.EmailDTO;

@Service 
public class EmailServiceImpl implements EmailService {

	@Inject
	JavaMailSender mailSender; 
	
	@Override
	public void sendMail(EmailDTO dto) {
		try {
			MimeMessage msg=mailSender.createMimeMessage();
			msg.addRecipient(RecipientType.TO, 
					new InternetAddress(dto.getReceiveMail()));
			/* 발신자는 생략해도 됨.
			 * msg.addFrom(new InternetAddress[] { new
			 * InternetAddress(dto.getSenderMail(),dto.getSenderName()) });
			 */
			/*
			 * msg.setSubject(dto.getSubject(),"utf-8"); msg.setText(dto.getMessage(),
			 * "utf-8");
			 */
			 BodyPart messageBodyPart = new MimeBodyPart();
			 
			  // Fill the message
			  messageBodyPart.setText("요청하신 첨부파일입니다.");
			  Multipart multipart = new MimeMultipart();
			  multipart.addBodyPart(messageBodyPart);
			 
			  // Part two is attachment
			  messageBodyPart = new MimeBodyPart();
			  File file = new File("C:/sample/sample.pdf");
			  FileDataSource fds = new FileDataSource(file);
			  messageBodyPart.setDataHandler(new DataHandler(fds));
			  messageBodyPart.setFileName(fds.getName());
			  multipart.addBodyPart(messageBodyPart);
			 
			  // Put parts in message
			  msg.setContent(multipart);
			 
			mailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}






