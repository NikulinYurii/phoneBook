package app.controller;

import app.model.User;
import app.service.UserService;
import app.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LoginControllerTest {

    @Configuration
    static class LoginControllerConfig{

        @Bean
        public UserService userService(){
            return Mockito.mock(UserService.class);
        }

        @Bean
        public LoginController loginController(){
            return new LoginController();
        }
    }

    @Autowired
    private LoginController loginController;

    @Autowired
    private UserService userService;

    /*@Before
    public void setup() throws Exception{
        User user = new User("yurii@mail.ru","qwe123","Yurii","Nikulin");
        Mockito.when(userService.chek("yurii@mail.ru","qwe123")).thenReturn(user);
    }*/
//todo
}