package net.revature.casestudymjh.Services;

import net.revature.casestudymjh.Models.DTO.LoginDTO;
import net.revature.casestudymjh.Models.DTO.RegDTO;
import net.revature.casestudymjh.Models.User;
import net.revature.casestudymjh.Repositories.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserServiceTesting {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepo userRepo;

    private User dbUser = new User();
    private RegDTO incDTO = new RegDTO();
    private LoginDTO loginDTO = new LoginDTO();
    private LoginDTO wpLoginDTO = new LoginDTO();
    private Optional<User> nullOptUser = Optional.ofNullable(null);
    private Optional<User> optionalUser;
    private String email = "test@test.com";
    private String name = "Test User";
    private String password = "password";
    private String password2 = "password2";
    @BeforeEach
    private void populateObjects(){

        incDTO.setPassword(password);
        incDTO.setEmail(email);
        incDTO.setName(name);

        dbUser.setId(1);
        dbUser.setEmail(email);
        dbUser.setName(name);
        dbUser.setPassword(password);

        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        wpLoginDTO.setEmail(email);
        wpLoginDTO.setPassword(password2);

        optionalUser = Optional.of(dbUser);
    }

    @Test
    public void givenValidCredentials_register_returnsTrue(){
        Mockito.when(userRepo.findByEmail(email)).thenReturn(nullOptUser);

        boolean resp = userService.register(incDTO);

        Assertions.assertEquals(resp, true);
    }

    @Test
    public void givenInvalidCredentials_register_returnsFalse(){
        Mockito.when(userRepo.findByEmail(email)).thenReturn(optionalUser);

        boolean resp = userService.register(incDTO);

        Assertions.assertEquals(resp, false);
    }

    @Test
    public void givenValidCredentials_login_returnsDBUser(){
        Mockito.when(userRepo.findByEmail(email)).thenReturn(optionalUser);

        User resp = userService.login(loginDTO);

        Assertions.assertEquals(resp.getId(), dbUser.getId());
        Assertions.assertEquals(resp.getName(), dbUser.getName());
        Assertions.assertEquals(resp.getPassword(), "");
    }

    @Test
    public void givenWrongPassword_login_returnsBlankUser(){
        Mockito.when(userRepo.findByEmail(email)).thenReturn(optionalUser);

        User resp = userService.login(wpLoginDTO);

        Assertions.assertNotEquals(resp.getId(), dbUser.getId());
        Assertions.assertNotEquals(resp.getName(), dbUser.getName());
    }

    @Test
    public void givenWrongEmail_login_returnsBlankUser(){
        Mockito.when(userRepo.findByEmail(email)).thenReturn(nullOptUser);

        User resp = userService.login(loginDTO);

        Assertions.assertNotEquals(resp.getId(), dbUser.getId());
        Assertions.assertNotEquals(resp.getName(), dbUser.getName());
    }
}
