package com.iflow.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iflow.model.Items;
import com.iflow.model.Mail;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RestController
@RequestMapping("user")
public class MailController {

	@Autowired
	private JavaMailSender sender;
	
	
	 @PostMapping("sendmail") 
	 public ResponseEntity<String>sendMail(@RequestBody String mail ){ 
		 
		 try 
		 { 			
	 		// sendEmail(mail.getReceiver(),mail.getSubject(), "Demo");
			 
			 sendEmail("jaydeepfaldu1989@gmail.com","Demo", "Demo");
	  
	 		 return new  ResponseEntity<String>(" { \"msg\" : \"Successfully Send\"}",HttpStatus.OK); 
	 	}
		 catch(Exception ex) { 
			 return new ResponseEntity<String>(" { \"msg\" : \"Error in SendMail\"}",HttpStatus.CONFLICT); 
			}
		 }
	
	
	
	public void sendEmail(String rec, String sub, String msg) throws Exception {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setTo(rec);
		helper.setSubject(sub);
		helper.setText(msg);

		sender.send(message);
	}
	
	
}
