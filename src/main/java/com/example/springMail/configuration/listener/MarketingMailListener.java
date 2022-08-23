package com.example.springMail.configuration.listener;

import java.io.InputStream;

import com.example.springMail.services.EmailContentService;

public class MarketingMailListener {

	private static final String MARKETING_DOMAIN = "@marketing.company.com";
    private final EmailContentService emailContentService;


    public MarketingMailListener(EmailContentService emailContentService) {
        this.emailContentService = emailContentService;
    }

    /**
     * Check if the received email is for this listener based on business logic (recipient email address)
     *
     * @param from is a the sender email address.
     * @param recipient is a the recipient email address.
     *
     * @return true if the recipient is an address of MARKETING department.
     */
    public boolean accept(String from, String recipient) {
        System.out.println("Recipient : "+recipient);
        return recipient != null && recipient.endsWith(MARKETING_DOMAIN);
    }

    public void deliver(String from, String recipient, InputStream data) {
        System.out.println("From : "+from);
        System.out.println("Recipient : "+recipient);
        try {
            emailContentService.extractReceivedEmail(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
