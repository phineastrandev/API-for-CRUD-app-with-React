package demoreact.demo.controlleradmin;


import demoreact.demo.entity.ContactEntity;
import demoreact.demo.handleexeption.MessageCommon;
import demoreact.demo.handleexeption.MessageResponse;
import demoreact.demo.service.ContactServices;
import demoreact.demo.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ManageContactController
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
 * 06-07-2021          Anhtp8           Manage Contact Blog
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/api/")
public class ManageContactController {

    @Autowired
    ContactServices services;

    @Autowired
    SendMailService sendMailService;

    MessageCommon messageCommon;

    /**
     *
     * @return status
     */
    @GetMapping("contactes")
    public ResponseEntity<List<ContactEntity>> getAllContactes() {
        List<ContactEntity> list = services.getContactes();
        return new ResponseEntity<List<ContactEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @return status
     */
    //get all contact who you have been contacted
    @GetMapping("contacted")
    public ResponseEntity<List<ContactEntity>> getAllContacted() {
        List<ContactEntity> list = services.getAllContacted();
        return new ResponseEntity<List<ContactEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param contactEntity
     * @return entity contact
     */
    @PostMapping("contactes")
    public ContactEntity createBlog(@RequestBody ContactEntity contactEntity) {
        sendMailService.sendEmail(contactEntity.getEmail()
                ,messageCommon.messageEmailBody,
                messageCommon.getMessageEmailTitle
                );
        return services.createContactThread(contactEntity);
    }


    /**
     *
     * @param id
     * @return string ok or not
     */
    @PutMapping("deleteContact/{id}")
    public String deleteContact(@PathVariable("id") int id) {
       return services.deleteContact(id);
    }
}
