package demoreact.demo.controlleruser;

import demoreact.demo.entity.ContactEntity;
import demoreact.demo.handleexeption.MessageCommon;
import demoreact.demo.service.ContactServices;
import demoreact.demo.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ContactController
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
 * 06-07-2021          Anhtp8           View Information at user interface
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user/api/")
public class ContactController {

    @Autowired
    ContactServices services;

    @Autowired
    SendMailService sendMailService;

    MessageCommon messageCommon;
    /**
     *
     * @param contactEntity
     * @return contact
     */
    @PostMapping("contactes")
    public ContactEntity createContactEntity(@RequestBody ContactEntity contactEntity) {
        sendMailService.sendEmail(contactEntity.getEmail(),
                "Thanks for your contact ! We will try contact with you early!",
                "Web Blog Tran Phi Anh"
        );
        return services.createContactThread(contactEntity);
    }
}
