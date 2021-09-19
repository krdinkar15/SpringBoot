package com.contact.contactservice.service;

import com.contact.contactservice.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {

    List<Contact> list = List.of(
            new Contact(1001L, "amit@gmail.com", "Amit", 101L),
            new Contact(1002L, "amit1@gmail.com", "Amit", 101L),
            new Contact(1003L, "amit2@gmail.com", "Amit", 102L)
    );

    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserId().equals(userId))
                contacts.add(list.get(i));
        }
        return contacts;
    }
}
