package demoreact.demo.service;


import demoreact.demo.entity.CountryDataEntity;
import demoreact.demo.repository.ContryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * CountrySerivce
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
public class CountrySerivce {
    @Autowired
    ContryRepository repository;

    /**
     * @return
     */
    public List<CountryDataEntity> getAlls() {

        List<CountryDataEntity> list = repository.findAll();
        if (list.size() > 0) {
            System.out.println("OK");
            return list;
        } else {
            return new ArrayList<>();
        }
    }


}
