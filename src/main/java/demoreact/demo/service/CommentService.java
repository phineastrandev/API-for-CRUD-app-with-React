package demoreact.demo.service;

import demoreact.demo.entity.CommentBlogEntity;
import demoreact.demo.handleexeption.RecordNotFoundException;
import demoreact.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CommentService
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
public class CommentService {

    @Autowired
    CommentRepository repository;

    /**
     * @param id
     * @return
     */
    public List<CommentBlogEntity> getAllComments(int id) {
        List<CommentBlogEntity> blogList = repository.getAllByIdBlogOrderByIdCommentDesc(id);
        if (blogList.size() > 0) {
            System.out.println("OK");
            return blogList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * @param entity
     * @return
     * @throws RecordNotFoundException
     */
    public CommentBlogEntity postComment(CommentBlogEntity entity) throws RecordNotFoundException {
        Date now = new Date();
        java.sql.Date Create_date = new java.sql.Date(now.getTime());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime time_now = LocalDateTime.now();
        entity.setDateComment(Create_date);
        entity.setTimeComment(dtf.format(time_now));
        return repository.save(entity);
    }


}
