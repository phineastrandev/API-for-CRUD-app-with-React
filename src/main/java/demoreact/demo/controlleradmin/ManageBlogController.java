package demoreact.demo.controlleradmin;

import demoreact.demo.entity.BlogEntity;
import demoreact.demo.entity.TagEntity;
import demoreact.demo.handleexeption.RecordNotFoundException;
import demoreact.demo.repository.BlogRepository;
import demoreact.demo.service.BlogService;
import demoreact.demo.service.TagServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * ManageBlogController
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
 * 06-07-2021          Anhtp8           Manage Blog
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/api/")
public class ManageBlogController {

    @Autowired
    BlogService service;

    @Autowired
    TagServices tagServices;

    /**
     *
     * @return list
     */

    @GetMapping("blogs")
    public ResponseEntity<List<BlogEntity>> getAllBlogs() {
        List<BlogEntity> list = service.getAllBlogs();
        return new ResponseEntity<List<BlogEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param title
     * @return status
     */

    @GetMapping("blogs/search/{title}")
    public ResponseEntity<List<BlogEntity>> getBlogByTitle(@PathVariable("title") String title) {
        List<BlogEntity> list = service.getBlogByTitle(title);
        return new ResponseEntity<List<BlogEntity>>(list, new HttpHeaders(), HttpStatus.OK);
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
        return new ResponseEntity<BlogEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param blogEntity
     * @return Blog entity
     */
    @PostMapping("blogs")
    public BlogEntity createBlog(@RequestBody BlogEntity blogEntity) {
        return service.createBlog(blogEntity);
    }

    /**
     *
     * @param id
     * @return string ok or not
     */

    @PutMapping("blogsDelete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
        System.out.println("ID: "+ id);
        return service.deleteBlog(id);

    }

    /**
     *
     * @return List
     */
    @GetMapping("tags")
    public ResponseEntity<List<TagEntity>> getAllTags() {
        List<TagEntity> list = tagServices.getAllTags();
        return new ResponseEntity<List<TagEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @Autowired
    BlogRepository repository;

    /**
     *
     * @param id
     * @param blogDetail
     * @return status
     */
    @PutMapping("blogs/{id}")
    public ResponseEntity<BlogEntity> updateBlog(@PathVariable int id, @RequestBody BlogEntity blogDetail) {
       return service.updateBlog(id, blogDetail);
    }


}
