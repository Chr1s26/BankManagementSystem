package Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import background_job.PerformSentMail;

public class EmailSenderService extends PerformSentMail {
	
	private  String smtpHost;
	private  String smtpPort;
	private  String username;
	private  String password;
	
	private String toEmail;
	private String subject;
	private String body;
	
	public EmailSenderService(String toEmail,String subject,String body) {
		this.toEmail = toEmail;
		this.subject = subject;
		this.body = body;
		Properties properties = new Properties();
		try {
			FileInputStream input = new FileInputStream("src/resources/application.properties");
			properties.load(input);
			this.smtpHost = properties.getProperty("smtp.host");
			this.smtpPort = properties.getProperty("smtp.port");
			this.username = properties.getProperty("smtp.username");
			this.password = properties.getProperty("smtp.password");
			}
		catch(IOException e) {
			System.out.print("Error  loading properties file : "+e.getMessage());
		}
	}
	
	public void sendEmail() {
		
		Properties props = new Properties();
		
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.starttls.enable",true);
			props.put("mail.smtp.starttls.required", true);
			props.put("mail.smtp.ssl.protocols","TLSv1.2");
			props.put("mail.smtp.host", this.smtpHost);
			props.put("mail.smtp.port", this.smtpPort);
			sentEmailAction( props);
	}
		

	public void sentEmailAction(Properties props) {

		Session session = Session.getInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));
			message.setSubject(subject);
			message.setContent(body,"text/html; charset=utf-8");
			Transport.send(message);
			System.out.print("Email sent successfully to "+toEmail);
		}catch(MessagingException e) {
			e.printStackTrace();
			System.out.print("Error sending email : "+e.getMessage());
		}
	}

	@Override
	public void sentEmailThread() {

		this.sendEmail();
	}
	
}
