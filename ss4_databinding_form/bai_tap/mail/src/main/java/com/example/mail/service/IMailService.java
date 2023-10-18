package com.example.mail.service;

import com.example.mail.model.Mail;

public interface IMailService {
    Mail showMail();
    void updateMail (Mail mailUpdate);
}
