package com.tim3.backendPSW.services;

import java.util.Collection;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.Pregled;
import com.tim3.backendPSW.models.User;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;

	@Async
	public void sendLink(User u) throws MailException, InterruptedException, MessagingException{
	
		String htmlView = "<html>"
						+ "<body>"
						+ "<div style=\"width:100%\">"
						+ "<div style=\"background:#3f51b5;text-align: center;height:50px;margin-bottom:50px\">"
						+ "<h1 style=\"color:white;margin-top:15px;\">"
						+ "Klinicki Centar Podrska"
						+ "</h1>"
						+ "</div>"
						+ "<p style=\"padding-left:10px\">Dobro dosli, " + u.getFirstname() + " " + u.getLastname() + ",</p>"
								+ "<hr>"
						+ "<p style=\"padding-left:10px\">Da bi ste aktivirali nalog, kliknite na dugme ispod</p>"
						+ "<p style=\"padding-left:10px\">Vas email je: " + u.getEmail() + "</p>"
								+ "<hr>"
						+ "<form action=\"http://localhost:4200/accountActivated/" + u.getId()+"\">\r\n" + 
						"    <input style=\"height: 35px;\r\n" + 
						"    width: 30%;\r\n" + 
						"    margin-left: 35%;\r\n" + 
						"    background: #3f51b5;\r\n" + 
						"    border: 1px solid;\r\n" + 
						"    color: white;\r\n" + 
						"    border-radius: 5px;\" type=\"submit\" value=\"Aktiviraj Nalog\" />\r\n" + 
						"</form>"
						+ "</div>"
						+ "</body>"
						+ "</html>";
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(u.getEmail());
		helper.setSubject("Klinicki Centar");
		helper.setText(htmlView, true);
		
		javaMailSender.send(message);
	}
	
	@Async
	public void rejectRequest(User u) throws MailException, InterruptedException, MessagingException{
	
		String htmlView = "<html>"
						+ "<body>"
						+ "<div style=\"width:100%\">"
						+ "<div style=\"background:#3f51b5;text-align: center;height:50px;margin-bottom:50px\">"
						+ "<h1 style=\"color:white;margin-top:15px;\">"
						+ "Klinicki Centar Podrska"
						+ "</h1>"
						+ "</div>"
						+ "<p style=\"padding-left:10px\">Postovani/na, " + u.getFirstname() + " " + u.getLastname() + ",</p>"
								+ "<hr>"
						+ "<p style=\"padding-left:10px\">Vas zahtev za kreiranje naloga je odbijen.</p>"
						+ "<p style=\"padding-left:10px\">Razlog odbijanja: "
						+ "<p style=\"padding-left:10px; font-style: italic;\">\"" + u.getRole() + "\"</p>"
								+ "<hr>"
						+ "</div>"
						+ "</body>"
						+ "</html>";
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(u.getEmail());
		helper.setSubject("Klinicki Centar");
		helper.setText(htmlView, true);
		
		javaMailSender.send(message);
	}
	
	@Async
	public void sendNotificationToAK(User u, Pregled p) throws MailException, InterruptedException, MessagingException{
	
		String htmlView = "<html>"
						+ "<body>"
						+ "<div style=\"width:100%\">"
						+ "<div style=\"background:#3f51b5;text-align: center;height:50px;margin-bottom:50px\">"
						+ "<h1 style=\"color:white;margin-top:15px;\">"
						+ "Klinicki Centar Podrska"
						+ "</h1>"
						+ "</div>"
						+ "<p style=\"padding-left:10px\">Postovani/na, " + u.getFirstname() + " " + u.getLastname() + ",</p>"
								+ "<hr>"
						+ "<p style=\"padding-left:10px\">Pristigao je novi zahtev za zakazivanje pregleda.</p>"
						+ "<h3 style=\"padding-left:40px\">Zahtev: </h3>"
						+ "<p style=\"padding-left:20px; font-style: italic;\">\"<strong style=\"color:#3f51b5\">Pacijent:</strong> " + p.getPacijent().getUser().getFirstname() + " " + p.getPacijent().getUser().getLastname() + "\"</p>"
						+ "<p style=\"padding-left:20px; font-style: italic;\">\"<strong style=\"color:#3f51b5\">Tip pregleda:</strong> " + p.getTipPregleda().getNaziv() + "\"</p>"
						+ "<p style=\"padding-left:20px; font-style: italic;\">\"<strong style=\"color:#3f51b5\">Lekar:</strong> " + p.getLekar().getUser().getFirstname() + " " + p.getLekar().getUser().getLastname() + "\"</p>"
						+ "<p style=\"padding-left:20px; font-style: italic;\">\"<strong style=\"color:#3f51b5\">Datum:</strong> " + p.getTermin().getDatum() + "\"</p>"
								+ "<hr>"
						+ "</div>"
						+ "</body>"
						+ "</html>";
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(u.getEmail());
		helper.setSubject("Klinicki Centar");
		helper.setText(htmlView, true);
		
		javaMailSender.send(message);
	}
	
	@Async
	public void sendQuickReservNotification(Pregled p) throws MailException, InterruptedException, MessagingException{
	
		String htmlView = "<html>"
						+ "<body>"
						+ "<div style=\"width:100%\">"
						+ "<div style=\"background:#3f51b5;text-align: center;height:50px;margin-bottom:50px\">"
						+ "<h1 style=\"color:white;margin-top:15px;\">"
						+ "Klinicki Centar Podrska"
						+ "</h1>"
						+ "</div>"
						+ "<p style=\"padding-left:10px\">Postovani/na, " + p.getPacijent().getUser().getFirstname() + " " + p.getPacijent().getUser().getLastname() + ",</p>"
								+ "<hr>"
						+ "<p style=\"padding-left:10px\">Uspesno ste rezervisali pregled.</p>"
						+ "<h3 style=\"padding-left:40px\">Pregled: </h3>"
						+ "<p style=\"padding-left:20px; font-style: italic;\">\"<strong style=\"color:#3f51b5\">Tip pregleda:</strong> " + p.getTipPregleda().getNaziv() + "\"</p>"
						+ "<p style=\"padding-left:20px; font-style: italic;\">\"<strong style=\"color:#3f51b5\">Sala:</strong> " + p.getSala().getNaziv() +", " +p.getSala().getBrojsale() + "\"</p>"
						+ "<p style=\"padding-left:20px; font-style: italic;\">\"<strong style=\"color:#3f51b5\">Lekar:</strong> " + p.getLekar().getUser().getFirstname() + " " + p.getLekar().getUser().getLastname() + "\"</p>"
						+ "<p style=\"padding-left:20px; font-style: italic;\">\"<strong style=\"color:#3f51b5\">Datum:</strong> " + p.getTermin().getDatum() + "\"</p>"
								+ "<hr>"
						+ "</div>"
						+ "</body>"
						+ "</html>";
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(p.getPacijent().getUser().getEmail());
		helper.setSubject("Klinicki Centar");
		helper.setText(htmlView, true);
		
		javaMailSender.send(message);
	}
}
