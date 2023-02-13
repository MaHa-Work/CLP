package net.revature.casestudymjh.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.revature.casestudymjh.Models.TransactionItem;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransDTO {
    private List<TransItemDTO> items;
    private Integer userId;
    private String date;
}
