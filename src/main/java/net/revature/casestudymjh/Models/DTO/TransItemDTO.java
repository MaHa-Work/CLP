package net.revature.casestudymjh.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.revature.casestudymjh.Models.Product;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransItemDTO {
    @ManyToOne
    private Product product;
    private int amount;
}
