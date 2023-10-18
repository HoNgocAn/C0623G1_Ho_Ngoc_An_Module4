package com.example.mail.service;

import com.example.mail.model.Mail;
import com.example.mail.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService implements IMailService{

    @Autowired
    private IMailRepository mailRepository;
    @Override
    public Mail showMail() {
        return mailRepository.showMail();
    }

    @Override
    public void updateMail(Mail mailUpdate) {
        mailRepository.updateMail(mailUpdate);
    }
}
