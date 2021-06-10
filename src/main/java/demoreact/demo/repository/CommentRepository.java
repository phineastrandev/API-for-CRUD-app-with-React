package demoreact.demo.repository;

import demoreact.demo.entity.CommentBlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CommentRepository
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
@Repository
public interface CommentRepository extends JpaRepository<CommentBlogEntity, Integer> {

    List<CommentBlogEntity> getAllByIdBlog(int idBlog);

    List<CommentBlogEntity> getAllByIdBlogOrderByIdCommentDesc(int idBlog);

    List<CommentBlogEntity> deleteAllByIdBlog(int idBlog);


}
