package net.revature.casestudymjh.Services;

import lombok.RequiredArgsConstructor;
import net.revature.casestudymjh.Models.DTO.LoginDTO;
import net.revature.casestudymjh.Models.DTO.RegDTO;
import net.revature.casestudymjh.Models.User;
import net.revature.casestudymjh.Repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public boolean register(RegDTO regDTO) {
        User ret = getByEmail(regDTO.getEmail());
        if (ret!=null) return false;
        User newUser = new User();
        newUser.setName(regDTO.getName());
        newUser.setEmail(regDTO.getEmail());
        newUser.setPassword(regDTO.getPassword());
        userRepo.save(newUser);
        return true;
    }

    public User getByEmail(String email){
        return userRepo.findByEmail(email).orElse(null);
    }

    public User login(LoginDTO loginDTO) {
        User ret = getByEmail(loginDTO.getEmail());
        if (ret==null) return new User();
        if (!ret.getPassword().equals(loginDTO.getPassword())) return new User();
        ret.setPassword("");
        return ret;
    }
}
