package com.keboda.eomsback.email.receiver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.util.Properties;

public class TeamsReceiver {

    public static void receiveEmails(String host, int port, String username, String password) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imap");
        props.setProperty("mail.imap.host", host);
        props.setProperty("mail.imap.port", String.valueOf(port));
        props.setProperty("mail.imap.starttls.enable", "true");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Store store = session.getStore("imap");
            store.connect(host, port, username, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);


            Message[] messages = inbox.getMessages();
            for (Message message : messages) {

                System.out.println("From: " + ((InternetAddress) message.getFrom()[0]).getAddress());
                System.out.println("Subject: " + message.getSubject());

                Object messagePart = message.getContent();
                if (messagePart instanceof String) {
                    String content = messagePart.toString();
                    Document doc = Jsoup.parse(content);
                    System.out.println("Body: " + doc.body().text());
                    // 这里可以进一步解析HTML文档
                }

            }

            inbox.close(false);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        receiveEmails("172.17.200.72",143, "teams_admin@keboda.com", "kbd123456*");
    }
}
