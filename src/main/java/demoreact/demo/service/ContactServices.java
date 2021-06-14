package demoreact.demo.service;


import demoreact.demo.entity.ContactEntity;
import demoreact.demo.handleexeption.MessageCommon;
import demoreact.demo.handleexeption.MessageResponse;
import demoreact.demo.handleexeption.RecordNotFoundException;
import demoreact.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactServices
 *
 * Version 1.0
 *
 * Date: 06-07-2021
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 06-07-2021          Anhtp8
 */
@Service
public class ContactServices {


    @Autowired
    ContactRepository contactRepository;

    MessageCommon messageCommon;

    @Autowired
    SendMailService sendMailService;


    /**
     * @return
     */
    public List<ContactEntity> getContactes() {
        List<ContactEntity> contactList = contactRepository.findAllByIsContacted(1);
        if (contactList.size() > 0) {
            System.out.println("OK");
            return contactList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * @return
     */
    public List<ContactEntity> getAllContacted() {
        List<ContactEntity> contactList = contactRepository.findAllByIsContacted(0);
        if (contactList.size() > 0) {
            System.out.println("OK");
            return contactList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * @param entity
     * @return
     * @throws RecordNotFoundException
     */
    public String createContactThread(ContactEntity entity) throws RecordNotFoundException {
        ContactEntity newContact = contactRepository.findContactEntityByEmailAndIsContacted(entity.getEmail(), 1);
        if(newContact == null){
            sendMailService.sendEmail(entity.getEmail(),
                    "Thanks for your contact ! We will try contact with you early!",
                    "Web Blog Tran Phi Anh"
            );
            entity.setIsContacted(1);
            contactRepository.save(entity);
            return "ok";
        } else {
            return "notok";
        }
    }

    /**
     * @param id
     * @return
     */
    public String deleteContact(int id) {
        ContactEntity newEntity = contactRepository.findContactEntityByIdAndIsContacted(id, 1);
        if (newEntity != null) {
            newEntity.setIsContacted(0);
            contactRepository.save(newEntity);
            return "ok";
        }
        return "notok";

    }
}
