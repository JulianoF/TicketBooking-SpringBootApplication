package net.group18.TicketApplication;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import net.group18.TicketApplication.controller.LoginController;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

/*     @Test
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
    } */
    
}