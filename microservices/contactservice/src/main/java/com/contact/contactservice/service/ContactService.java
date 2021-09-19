package com.contact.contactservice.service;

import com.contact.contactservice.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getContactsOfUser(Long userId);
}
