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



public class EmailSenderService extends Thread {
	
	private  String smtpHost;
	private  String smtpPort;
	private  String username;
	private  String password;
	
	private String toEmail;
	private String subject;
	private String body;
	
	@Override
	public void run() {
		this.sendEmail(this.toEmail, this.subject, this.body);
	}

	public EmailSenderService() {
		Properties properties = new Properties();
		try {
			FileInputStream input = new FileInputStream("src/application.properties");
			properties.load(input);
			this.smtpHost = properties.getProperty(smtpHost);
			this.smtpPort = properties.getProperty(smtpPort);
			this.username = properties.getProperty(username);
			this.password = properties.getProperty(password);
			}
		catch(IOException e) {
			System.out.print("Error  loading properties file : "+e.getMessage());
		}
	}
	
	public void sendEmail(String toEmail,String subject,String body) {
		Properties props = new Properties();
		
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.starttls.enable",true);
			props.put("mail.smtp.startttls.required", true);
			props.put("mail.smtp.ssl.protocols","TLSv1.2");
			props.put("mail.smtp.host", this.smtpHost);
			props.put("mail.smtp.port", this.smtpPort);
			sentEmailAction( props, toEmail, subject, body);
	}
		
	

	public void sentEmailAction(Properties props,String toEmail,String subject,String body) {

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
			message.setText(body);
			Transport.send(message);
			System.out.print("Email sent successfully to "+toEmail);
		}catch(MessagingException e) {
			e.printStackTrace();
			System.out.print("Error sending email : "+e.getMessage());
		}
	}
	
}
