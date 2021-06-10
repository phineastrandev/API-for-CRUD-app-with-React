package demoreact.demo.service;

import demoreact.demo.entity.CustomAccDetails;
import demoreact.demo.entity.InforAccEntity;
import demoreact.demo.entity.LoginDto;
import demoreact.demo.handleexeption.ApiResponse;
import demoreact.demo.handleexeption.MessageResponse;
import demoreact.demo.handleexeption.RecordNotFoundException;
import demoreact.demo.repository.InforAccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * AccService
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
public class AccService implements UserDetailsService {

    @Autowired
    InforAccRepository inforAccRepository;

    /**
     * @return
     */
    public InforAccEntity getAcc() {
        InforAccEntity acc = inforAccRepository.getOne((long) 1);
        if (acc != null) {
            System.out.println("OK");
            return acc;
        } else {
            return acc;
        }
    }

    /**
     * @param entity
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    public InforAccEntity updateAcc(InforAccEntity entity, Long id) throws RecordNotFoundException {
        Optional<InforAccEntity> acc = Optional.ofNullable(inforAccRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Employee not exist with id :" + id)));
        if (acc.isPresent()) {
            InforAccEntity newEntity = acc.get();
            newEntity.setName(entity.getName());
            newEntity.setAge(entity.getAge());
            newEntity.setBirthday(entity.getBirthday());
            newEntity.setEmail(entity.getEmail());
            return newEntity;
        } else {
            entity = inforAccRepository.save(entity);

            return entity;
        }
    }

    /**
     * @return
     * @throws RecordNotFoundException
     */
    public InforAccEntity getAccByID() throws RecordNotFoundException {
        Optional<InforAccEntity> acc = inforAccRepository.findById((long) 1);

        if (acc.isPresent()) {
            return acc.get();
        } else {
            throw new RecordNotFoundException("No account record exist for given id");
        }
    }

    /**
     * @param loginDto
     * @return
     */
    public ApiResponse login(LoginDto loginDto) {
        InforAccEntity user = inforAccRepository.findByUsername(loginDto.getUsername());
        if (user == null) {
            throw new RuntimeException();
        }
        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", null);

    }

    /**
     * @param avatar
     * @return
     */
    public ApiResponse updateAvatar(String avatar) {
        inforAccRepository.updateAvatar(avatar);
        return new ApiResponse(200, "Login success", null);

    }

    /**
     * @param id
     * @param avatar
     * @return
     */
    public MessageResponse updateAvatar(int id, String avatar) {   // kiem tra xem có trong data hay ko?
        InforAccEntity newEntity = inforAccRepository.findInforAccEntitiesById(id);
        if (newEntity != null) {
            newEntity.setAvatar(avatar);
            inforAccRepository.save(newEntity);
            return new MessageResponse("Update Successful!");
        }
        return new MessageResponse("This record may be has been deleted!");

    }

    /**
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        InforAccEntity user = inforAccRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        System.out.println("Username ok");
        return new CustomAccDetails(user);
    }

    public ResponseEntity<InforAccEntity> updataAcc( Long id, InforAccEntity entity) {
        InforAccEntity newEntity = inforAccRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Account not exist with id :" + id));
        newEntity.setName(entity.getName());
        newEntity.setAge(entity.getAge());
        newEntity.setBirthday(entity.getBirthday());
        newEntity.setCountry(entity.getCountry());
        newEntity.setEmail(entity.getEmail());
        newEntity.setPhone(entity.getPhone());
        newEntity.setAvatar(entity.getAvatar());
        InforAccEntity updateAcc = inforAccRepository.save(newEntity);
        return ResponseEntity.ok(updateAcc);
    }

    /**
     * @param id
     * @return
     */
    @Transactional
    public UserDetails loadUserById(Long id) {
        InforAccEntity user = inforAccRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        System.out.println("OK ID");
        return new CustomAccDetails(user);
    }
}
