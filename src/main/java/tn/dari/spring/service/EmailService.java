package tn.dari.spring.service;

import tn.dari.spring.entity.Mail;


public interface EmailService {

    public void sendCodeByMail(Mail mail);
}