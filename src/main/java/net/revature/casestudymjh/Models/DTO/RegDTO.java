package net.revature.casestudymjh.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegDTO {
    private String name;
    private String email;
    private String password;
}
