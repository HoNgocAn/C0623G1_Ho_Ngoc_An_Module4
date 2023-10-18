package com.example.mail.repository;

import com.example.mail.model.Mail;
import org.springframework.stereotype.Repository;

@Repository
public class MailRepository implements IMailRepository {
    private static Mail mail;
    static {
        mail = new Mail();
    }

    @Override
    public Mail showMail() {
        return mail;
    }

    @Override
    public void updateMail(Mail mailUpdate) {
        mail.setLanguage(mailUpdate.getLanguage());
        mail.setPageSize(mailUpdate.getPageSize());
        mail.setSpamsFilter(mailUpdate.getSpamsFilter());
        mail.setSignature(mailUpdate.getSignature());
    }
}
