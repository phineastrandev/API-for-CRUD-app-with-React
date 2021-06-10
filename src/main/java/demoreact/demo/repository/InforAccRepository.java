package demoreact.demo.repository;

import demoreact.demo.entity.InforAccEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * InforAccRepository
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
public interface InforAccRepository extends JpaRepository<InforAccEntity, Long> {

    @Query("SELECT u FROM InforAccEntity u WHERE u.username =:username and u.password =:password ")
    public Optional<InforAccEntity> checkLogin(String username, String password);

    InforAccEntity findByUsername(String username);

    @Query("UPDATE InforAccEntity  SET avatar = :avatar WHERE id = 1")
    public void updateAvatar(String avatar);

    InforAccEntity findInforAccEntitiesById(int id);



    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
