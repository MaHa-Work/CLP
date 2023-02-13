package net.revature.casestudymjh.Controllers;

import lombok.RequiredArgsConstructor;
import net.revature.casestudymjh.Models.DTO.TransDTO;
import net.revature.casestudymjh.Models.Trans;
import net.revature.casestudymjh.Services.TransService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trans")
public class TransController {
    private final TransService transService;

    @PostMapping()
    public Trans newTransaction (@RequestBody TransDTO transDTO){
        return transService.newTrans(transDTO);
    }

    @GetMapping("/userId/{id}")
    public List<Trans> getAllTransByUser(@PathVariable Integer id){
        return transService.findAllTransByUserId(id);
    }

}
