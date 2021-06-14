package demoreact.demo.controlleruser;

import demoreact.demo.entity.ContactEntity;
import demoreact.demo.handleexeption.MessageCommon;
import demoreact.demo.service.ContactServices;
import demoreact.demo.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ContactController
 * <p>
 * Version 1.0
 * <p>
 * Date: 06-07-2021
 * <p>
 * Copyright
 * <p>
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


    /**
     * @param contactEntity
     * @return contact
     */
    @PostMapping("contactes")
    public String createContactEntity(@RequestBody ContactEntity contactEntity) {

        return services.createContactThread(contactEntity);
    }
}
