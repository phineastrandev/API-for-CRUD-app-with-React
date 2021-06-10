package demoreact.demo;

import demoreact.demo.entity.InforAccEntity;
import demoreact.demo.repository.InforAccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication
     //  implements CommandLineRunner
{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Autowired
//    InforAccRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Khi chương trình chạy
//        // Insert vào csdl một user.
//        InforAccEntity user = new InforAccEntity();
//       user.setUsername("tranphianh");
//         user.setPassword(passwordEncoder.encode("anhanh11"));
//        userRepository.save(user);
//        System.out.println(user);
//    }
}
