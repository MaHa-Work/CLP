package net.revature.casestudymjh.Services;

import lombok.RequiredArgsConstructor;
import net.revature.casestudymjh.Models.DTO.TransDTO;
import net.revature.casestudymjh.Models.Trans;
import net.revature.casestudymjh.Models.TransactionItem;
import net.revature.casestudymjh.Repositories.TransRepo;
import net.revature.casestudymjh.Repositories.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransService {
    private final TransRepo transRepo;
    private final TransactionRepo transactionRepo;

    public Trans newTrans(TransDTO transDTO) {
        Trans newTrans = new Trans();
        newTrans.setDate(transDTO.getDate());
        newTrans.setUserId(transDTO.getUserId());
        newTrans = transRepo.save(newTrans);

        final Integer transId = newTrans.getId();
        newTrans = setAndSaveItems(transDTO, newTrans, transId);
        newTrans = transRepo.save(newTrans);

        return newTrans;
    }

    public List<Trans> findAllTransByUserId(Integer id) {
        return transRepo.findAllByUserId(id);
    }

    private Trans setAndSaveItems(TransDTO dto, Trans trans, Integer transId){
        List<TransactionItem> toAdd =  dto.getItems().stream()
                .map(dtoItem->{TransactionItem out = new TransactionItem();
                        out.setAmount(dtoItem.getAmount());
                        out.setProduct(out.getProduct());
                        out.setLinkedTo(transId);
                        return out;})
                .collect(Collectors.toList());
        toAdd = transactionRepo.saveAll(toAdd);
        trans.setItems(toAdd);
        return trans;
    }

}
