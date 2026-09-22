package com.onlinelearning.config;
import com.onlinelearning.model.*; import com.onlinelearning.repository.UserRepository; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration public class DataInitializer {
 @Bean CommandLineRunner seed(UserRepository users, PasswordEncoder enc){return args->{if(!users.existsByUsername("instructor")) users.save(new User("instructor","instructor@learnhub.com",enc.encode("Instructor@123"),Role.INSTRUCTOR));};}
}
