package com.onlyjavaboot.roz.services;

import org.springframework.stereotype.Service;


public interface EmailServices {
    public boolean sendEmail(String subject, String messaage, String to);

    }
