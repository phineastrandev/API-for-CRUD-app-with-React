package demoreact.demo.controlleradmin;

import demoreact.demo.entity.*;
import demoreact.demo.handleexeption.MessageResponse;
import demoreact.demo.handleexeption.RecordNotFoundException;
import demoreact.demo.repository.InforAccRepository;
import demoreact.demo.service.AccService;
import demoreact.demo.service.CountrySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ManageAccController
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
 * 06-07-2021          Anhtp8           Manage Profile - Account
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/api/")
public class ManageAccController {
    @Autowired
    AccService service;

    @Autowired
    CountrySerivce countrySerivce;

    /**
     * @return Account
     * @throws RecordNotFoundException
     */

    @GetMapping("profile")
    public ResponseEntity<InforAccEntity> getAcc() throws RecordNotFoundException {
        InforAccEntity acc = service.getAccByID();
        return new ResponseEntity<InforAccEntity>(acc, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * @return List country data
     */

    @GetMapping("profile/country")
    public ResponseEntity<List<CountryDataEntity>> getAlls() {
        List<CountryDataEntity> list = countrySerivce.getAlls();
        return new ResponseEntity<List<CountryDataEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * @param id
     * @param avatar
     * @return Message ok or not
     */

    @PutMapping("updateAvatar/{id}")
    public MessageResponse deleteContact(@PathVariable("id") int id, @RequestParam String avatar) {
        return service.updateAvatar(id, avatar);
    }


    @Autowired
    InforAccRepository repository;

    /**
     *
     * @param id
     * @param entity
     * @return status
     */

    @PutMapping("profile/{id}")
    public ResponseEntity<InforAccEntity> updataAcc(@PathVariable Long id, @RequestBody InforAccEntity entity) {
        return service.updataAcc(id, entity);
    }


}
