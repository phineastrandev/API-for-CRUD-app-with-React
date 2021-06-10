package demoreact.demo.controlleruser;


import demoreact.demo.entity.BlogEntity;
import demoreact.demo.handleexeption.RecordNotFoundException;
import demoreact.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * BlogController
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
 * 06-07-2021          Anhtp8           View Blog at user interface
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user/api/")
public class BlogController {

    @Autowired
    BlogService service;

    /**
     *
     * @return
     */
    @GetMapping("blogs")
    public ResponseEntity<List<BlogEntity>> getAllBlogs() {
        List<BlogEntity> list = service.getAllBlogs();
        return new ResponseEntity<List<BlogEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *
     *
     * @return Blog entity
     * @throws RecordNotFoundException
     */

    @GetMapping("getLastBlog")
    public ResponseEntity<BlogEntity> getLastBlog()
            throws RecordNotFoundException {
        BlogEntity entity = service.getLastBlog();
        return new ResponseEntity<BlogEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return status
     * @throws RecordNotFoundException
     */
    @GetMapping("blogs/{id}")
    public ResponseEntity<BlogEntity> getBlogById(@PathVariable("id") int id)
            throws RecordNotFoundException {

        BlogEntity entity = service.getBlog(id);
        service.updateViewer(id,1);
        return new ResponseEntity<BlogEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return status
     * @throws RecordNotFoundException
     */
    @GetMapping("blogDetail/{id}")
    public ResponseEntity<BlogEntity> getDetailsBlogById(@PathVariable("id") int id)
            throws RecordNotFoundException {
        BlogEntity entity = service.getBlog(id);
        return new ResponseEntity<BlogEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param keyword
     * @return
     */
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<BlogEntity>> search(@PathVariable("keyword") String keyword) {

        List<BlogEntity> list = service.searchAny(keyword);

        return new ResponseEntity<List<BlogEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

}
