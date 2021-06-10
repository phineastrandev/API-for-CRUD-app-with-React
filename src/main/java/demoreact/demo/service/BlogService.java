package demoreact.demo.service;

import demoreact.demo.entity.BlogEntity;
import demoreact.demo.entity.CommentBlogEntity;
import demoreact.demo.handleexeption.MessageCommon;
import demoreact.demo.handleexeption.RecordNotFoundException;
import demoreact.demo.repository.BlogRepository;
import demoreact.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * BlogService
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
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;

    MessageCommon messageErrror;


    /**
     * @return
     */
    public List<BlogEntity> getAllBlogs() {
        // Sort By Id DESC
        List<BlogEntity> blogList = blogRepository.findAllByIsDeletedOrderByIdDesc(1);
        if (blogList.size() > 0) {
            System.out.println("OK");
            return blogList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * @param title
     * @return
     */

    public List<BlogEntity> getBlogByTitle(String title) {
        //Find by title
        List<BlogEntity> blogList = blogRepository.findBlogByTitle(title);
        if (blogList.size() > 0) {
            System.out.println("OK");
            return blogList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * @param title
     * @return
     */
    public List<BlogEntity> searchAny(String title) {
        List<BlogEntity> blogList = blogRepository.searchAnyThing(title);
        if (blogList.size() > 0) {
            System.out.println("OK");
            return blogList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    // get blog for admin
    public BlogEntity getBlog(int id) throws RecordNotFoundException {
        Optional<BlogEntity> blog = blogRepository.findById(id);
        if (blog.get().getIsDeleted() != 0) {
            if (blog.isPresent()) {
                return blog.get();
            } else
                throw new RecordNotFoundException(messageErrror.resourceNotFound);
        }
        throw new RecordNotFoundException(messageErrror.resourceNotFound);
    }


    /**
     * @param id
     * @param count
     */
    public void updateViewer(int id, int count) {
        BlogEntity blog = blogRepository.findBlogEntitiesById(id);
        if (blog != null) {
            blog.setViewer(blog.getViewer() + count);
            blogRepository.save(blog);
        }
    }

    /**
     * @return
     * @throws RecordNotFoundException
     */
    public BlogEntity getLastBlog() throws RecordNotFoundException {
        Optional<BlogEntity> blog = blogRepository.findTopByOrderByIdDesc();

        if (blog.isPresent()) {
            return blog.get();
        } else {
            throw new RecordNotFoundException(messageErrror.resourceNotFound);
        }
    }

    /**
     * @param entity
     * @return
     * @throws RecordNotFoundException
     */
    public BlogEntity createBlog(BlogEntity entity) throws RecordNotFoundException {
        Date now = new Date();
        java.sql.Date Create_date = new java.sql.Date(now.getTime());
        entity.setIsDeleted(1);
        entity.setCreateDate(Create_date);
        return blogRepository.save(entity);
    }

    /**
     * @param entity
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    public BlogEntity updateBlog(BlogEntity entity, int id) throws RecordNotFoundException {
        Optional<BlogEntity> blog = Optional.ofNullable(blogRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Employee not exist with id :" + id)));
        Date now = new Date();
        java.sql.Date Create_date = new java.sql.Date(now.getTime());
        if (blog.isPresent()) {
            BlogEntity newEntity = blog.get();
            newEntity.setContent(entity.getContent());
            newEntity.setCreateDate(Create_date);
            newEntity.setImgFront(entity.getImgFront());
            newEntity.setTag(entity.getTag());
            newEntity.setTitle(entity.getTitle());
            newEntity = blogRepository.save(newEntity);
            return newEntity;
        } else {
            entity = blogRepository.save(entity);

            return entity;
        }
    }

    /**
     * @param id
     * @return
     */
    @Transactional
    public String deleteBlog(int id) {
        BlogEntity newEntity = blogRepository.finBlogByIdAndDeleted(id);
        List<CommentBlogEntity> commentBlogEntity = commentRepository.getAllByIdBlog(id);
        if (newEntity != null) {
            if (!commentBlogEntity.isEmpty()) {
                commentRepository.deleteAllByIdBlog(id);
                newEntity.setIsDeleted(0);
                System.out.println("Tko tim thay " + id);
                blogRepository.save(newEntity);
                return "ok";
            } else {
                newEntity.setIsDeleted(0);
                System.out.println("Tim thay ID: " + id);
                blogRepository.save(newEntity);
                return "ok";
            }
        } else
            System.out.println("Ko tim thay ID");
        return "notok";

    }

    /**
     *
     * @param id
     * @param blogDetail
     * @return
     */

    public ResponseEntity<BlogEntity> updateBlog(int id, BlogEntity blogDetail) {
        BlogEntity newEntity = blogRepository.finBlogByIdAndDeleted(id);
        if (newEntity != null) {
            Date now = new Date();
            java.sql.Date Create_date = new java.sql.Date(now.getTime());
            newEntity.setContent(blogDetail.getContent());
            newEntity.setCreateDate(Create_date);
            newEntity.setImgFront(blogDetail.getImgFront());
            newEntity.setTag(blogDetail.getTag());
            newEntity.setTitle(blogDetail.getTitle());
            BlogEntity updatedBlog = blogRepository.save(newEntity);
            return ResponseEntity.ok(updatedBlog);
        }
        return (ResponseEntity<BlogEntity>) ResponseEntity.notFound();

    }
}
