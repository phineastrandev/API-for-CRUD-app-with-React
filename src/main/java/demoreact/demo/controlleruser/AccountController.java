package demoreact.demo.controlleruser;

import demoreact.demo.entity.InforAccEntity;
import demoreact.demo.handleexeption.RecordNotFoundException;
import demoreact.demo.service.AccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AccountController
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
@RequestMapping("/user/api/profile")
public class AccountController {
    @Autowired
    AccService service;

    /**
     *
     * @return status
     * @throws RecordNotFoundException
     */

    @GetMapping()
    public ResponseEntity<InforAccEntity> getAcc() throws RecordNotFoundException {
        InforAccEntity acc = service.getAccByID();
        return new ResponseEntity<InforAccEntity>(acc, new HttpHeaders(), HttpStatus.OK);
    }
}
