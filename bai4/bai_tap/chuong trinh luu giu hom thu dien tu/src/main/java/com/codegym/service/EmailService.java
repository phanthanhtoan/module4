package com.codegym.service;

import com.codegym.model.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailService implements IEmailService {

    @Override
    public void saveEmail(Email email) {

//        email.add(email);
    }

    @Override
    public void updateEmail(Email email) {

    }

    @Override
    public void editEmail(Email email) {
        email.setPageSize(email.getPageSize());
        email.setLanguage(email.getLanguage());
        email.setSignature(email.getSignature());
        email.setSpamsFilter(email.isSpamsFilter());

    }


}
