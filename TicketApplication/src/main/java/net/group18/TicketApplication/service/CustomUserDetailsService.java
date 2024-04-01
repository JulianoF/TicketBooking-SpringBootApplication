package net.group18.TicketApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.group18.TicketApplication.entity.CustomUserDetails;
import net.group18.TicketApplication.entity.User;
import net.group18.TicketApplication.repository.UserRepository;
 
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepo;
     
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);

        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        CustomUserDetails test = new CustomUserDetails(user);
        System.out.println(test.getUsername());
        System.out.println(test.getPassword());

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
 
}