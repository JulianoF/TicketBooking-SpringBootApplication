package net.group18.TicketApplication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import net.group18.TicketApplication.controller.LoginController;
import net.group18.TicketApplication.service.RegisterService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegisterService registerService;

 /*    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("Login"));
    }
    @Test
    public void getLoginPage() throws Exception {
        this.mvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(view().name("login"))
            .andExpect(model().attribute("loginForm", notNullValue()))
            .andExpect(content().string(containsString("Login")));
    }
    @Test
    public void ValidLogin() throws Exception {
        this.mvc.perform(post("/login").param("username", "JohnDoe123").param("password", "SecurePW456"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(model().attribute("message", "Welcome, JohnDoe123!"))
            .andExpect(content().string(containsString("Welcome, JohnDoe123!")));
    }
    @Test
    public void InvalidLogin() throws Exception {
        this.mvc.perform(post("/login").param("username", "invalidusername").param("password", "invalidPassword"))
            .andExpect(status().isOk())
            .andExpect(view().name("login"))
            .andExpect(model().attributeHasFieldErrors("loginForm", "username"))
            .andExpect(model().attributeHasFieldErrors("loginForm", "password"))
            .andExpect(content().string(containsString("Invalid username or password. Please Enter A Valid Login Entry Or Try Signing Up.")));
    } 

    @Test
    public void testLoginUser_Success() {
        // Arrange
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        LoginController controller = new LoginController();
        Model model = mock(Model.class);

        // Act
        String result = controller.loginUser("test@example.com", "password", model);

        // Assert
        assertEquals("pastbooking", result);
        verify(SecurityContextHolder.getContext()).setAuthentication(authentication);
    }

    @Test
    public void testLoginUser_Failure() {
        // Arrange
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenThrow(new RuntimeException("Authentication failed"));
        LoginController controller = new LoginController();
        Model model = mock(Model.class);

        // Act
        String result = controller.loginUser("test@example.com", "password", model);

        // Assert
        assertEquals("login", result);
        verify(model).addAttribute("error", true);
    }

    @Test
    public void testSignupUser() {
        // Arrange
        RegisterService registerService = mock(RegisterService.class);
        LoginController controller = new LoginController();
        Model model = mock(Model.class);

        // Act
        String result = controller.signupUser("John", "Doe", "john@example.com", "password", model);

        // Assert
        assertEquals("redirect:/login", result);
        ArgumentCaptor<String> firstNameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> lastNameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> passwordCaptor = ArgumentCaptor.forClass(String.class);
        verify(registerService).registerUser(firstNameCaptor.capture(), lastNameCaptor.capture(), emailCaptor.capture(), passwordCaptor.capture());
        assertEquals("John", firstNameCaptor.getValue());
        assertEquals("Doe", lastNameCaptor.getValue());
        assertEquals("john@example.com", emailCaptor.getValue());
        assertEquals("password", passwordCaptor.getValue());
    } */
}
