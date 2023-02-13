package net.revature.casestudymjh.Controllers;

import lombok.RequiredArgsConstructor;
import net.revature.casestudymjh.Services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
}
