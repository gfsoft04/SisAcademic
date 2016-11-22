package br.com.gfsoft.sisacademic.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EnvioEmail {

	private Properties properties;
	private Session session;
	private Message message;

	public EnvioEmail() {
		properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "587");
		properties.put("mail.smtp.socketFactory.fallback", "false");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");

		session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("gfsoft04@gmail.com", "pfj201602");
			}
		});
	}

	public boolean enviar(String destinatario, String assunto, String mensagem) {
		/** Desativa Debug para sessão */
		session.setDebug(false);

		try {

			message = new MimeMessage(session);
			message.setFrom(new InternetAddress("gfsoft04@gmail.com")); // Remetente

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario)); // Destinatário(s)
			message.setSubject(assunto);// Assunto
			message.setText(mensagem);
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			return true;

		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "Falha ao enviar email!", "Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}

		//return false;
	}

}
