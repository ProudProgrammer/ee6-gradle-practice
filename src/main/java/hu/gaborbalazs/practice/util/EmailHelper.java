package hu.gaborbalazs.practice.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailHelper {

	public void sendTestEmail() {

		System.out.println(">> sendTestEmail()");

		final String username = "proudprogrammer.dev@gmail.com";
		final String password = "proudprogrammer";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("gbazsi82@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("gbazsi82@gmail.com"));
			message.setSubject("Testing Subject");

			// message.setText("Hello World!");

			Multipart multipart = new MimeMultipart();
			String filename = "src/main/resources/text.txt";
			DataSource source = new FileDataSource(filename);
			
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Hello World!");
			
			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		System.out.println("<< sendTestEmail()");
	}
}
