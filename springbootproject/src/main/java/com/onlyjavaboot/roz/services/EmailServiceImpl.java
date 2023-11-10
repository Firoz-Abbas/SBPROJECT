package com.onlyjavaboot.roz.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailServices {

    @Override
    public boolean sendEmail(String subject, String messaage, String to) {
        //rest of code

        boolean f=false;

        String from="92786110firoz@gmail.com";

        //variable of Email
        String host="smtp.gmail.com";

        //get the system properties
        Properties properties=System.getProperties();
        System.out.println("properties" +properties);

        //host set
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",465);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");


        //Step 1- to get the session object

        Session session=Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("92786110firoz@gmail.com","9235645720".);
            }


        });
                session.setDebug(true);

                //Step-2 Compose the message[test, multimedia]

        MimeMessage m=new MimeMessage(session);

        try {


            //from email
            m.setFrom(from);

            //adding reciept to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);

            //adding text to message
            m.setText(messaage);

            //Step-3 : send the message using Transport class

            Transport.send(m);

            System.out.println("sent mail successfully...............");
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }
}
