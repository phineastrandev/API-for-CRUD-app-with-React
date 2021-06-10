package demoreact.demo.repository;

import demoreact.demo.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * BlogRepository
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
 * 06-07-2021          Anhtp8           Config Security
 */

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {

    @Query("Select b from BlogEntity b where b.title like %:title% AND b.isDeleted = 1")
    List<BlogEntity> findBlogByTitle(String title);

    @Query("SELECT p FROM BlogEntity p WHERE (p.title LIKE %:keyword%"
            + " OR p.tag LIKE %:keyword%) AND p.isDeleted =1")
    List<BlogEntity> searchAnyThing(String keyword);

    List<BlogEntity> findAllByIsDeletedOrderByIdDesc(int isDeleted);

    Optional<BlogEntity> findTopByOrderByIdDesc();

    BlogEntity findBlogEntitiesById(int id);

    BlogEntity findBlogEntitiesByIdAndIsDeleted(int id, int isDeleted);

    @Query("SELECT p FROM BlogEntity p WHERE p.id=:id and p.isDeleted=1")
    BlogEntity finBlogByIdAndDeleted(int id);




}
