package com.example.springMail.services;

import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.example.springMail.model.ReceivedEmail;

public interface EmailContentService {

	MimeMessage convertToMimeMessage(InputStream data) throws MessagingException;
    ReceivedEmail extractReceivedEmail(InputStream data) throws Exception;
}
