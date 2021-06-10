package demoreact.demo.controlleruser;

import demoreact.demo.entity.CommentBlogEntity;
import demoreact.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CommentController
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
 * 06-07-2021          Anhtp8           Comment at blogs
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user/api/")
public class CommentController {

    @Autowired
    CommentService service;

    /**
     * @param id
     * @return list comment
     */
    @GetMapping("getComment/{id}")
    public ResponseEntity<List<CommentBlogEntity>> getAllCommentsById(@PathVariable int id) {
        List<CommentBlogEntity> list = service.getAllComments(id);
        return new ResponseEntity<List<CommentBlogEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * @param entity
     * @return comment
     */
    @PostMapping("comment")
    public CommentBlogEntity postComment(@RequestBody CommentBlogEntity entity) {
        return service.postComment(entity);
    }
}