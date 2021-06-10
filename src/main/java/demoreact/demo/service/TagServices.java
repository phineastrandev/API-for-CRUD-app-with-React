package demoreact.demo.service;


import demoreact.demo.entity.TagEntity;
import demoreact.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * SendMailService
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
public class TagServices {

    @Autowired
    TagRepository repository;

    /**
     *
     * @return
     */
    public List<TagEntity> getAllTags() {
        List<TagEntity> tagEntityList = repository.findAll();
        if (tagEntityList.size() > 0) {
            System.out.println("OK");
            return tagEntityList;
        } else {
            return new ArrayList<>();
        }
    }
}
