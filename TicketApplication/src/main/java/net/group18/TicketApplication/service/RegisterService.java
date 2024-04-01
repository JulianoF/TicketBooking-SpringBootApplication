package net.group18.TicketApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.group18.TicketApplication.entity.User;
import net.group18.TicketApplication.repository.UserRepository;

@Service
public class RegisterService {
    
    @Autowired
    private UserRepository userRepository;
    
   /*  @Autowired
    private PasswordEncoder passwordEncoder; */

    public void registerUser(String firstName, String lastName, String email, String password) {

        //String encodedPassword = passwordEncoder.encode(password);

        // Create a new User object
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password); 

        userRepository.save(user);
    }



}
