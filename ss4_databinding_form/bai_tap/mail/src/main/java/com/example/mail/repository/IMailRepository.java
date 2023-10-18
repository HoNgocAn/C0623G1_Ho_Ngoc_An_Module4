package com.example.mail.repository;

import com.example.mail.model.Mail;

public interface IMailRepository {
    Mail showMail();
    void updateMail (Mail mailUpdate);
}
