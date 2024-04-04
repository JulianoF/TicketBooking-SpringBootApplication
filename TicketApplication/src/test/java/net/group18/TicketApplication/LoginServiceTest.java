package net.group18.TicketApplication;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.springframework.boot.test.context.SpringBootTest;

import net.group18.TicketApplication.entity.User;
import net.group18.TicketApplication.repository.UserRepository;



@SpringBootTest
public class LoginServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @Test
    void testFindEmail(){
        String email = "johndoe@exmaple.com";
        User expectedUser = new User();

        when(userRepository.findByEmail(eq(email))).thenReturn(expectedUser);

        User realUser = userRepository.findByEmail(email);

        assertEquals(expectedUser, realUser);
    }

}