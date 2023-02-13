package net.revature.casestudymjh.Controllers;

import lombok.RequiredArgsConstructor;
import net.revature.casestudymjh.Models.DTO.LoginDTO;
import net.revature.casestudymjh.Models.DTO.RegDTO;
import net.revature.casestudymjh.Models.User;
import net.revature.casestudymjh.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public boolean registration(@RequestBody RegDTO regDTO){
        return userService.register(regDTO);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDTO loginDTO){
        return  userService.login(loginDTO);
    }
}
