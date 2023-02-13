package net.revature.casestudymjh.Repositories;

import net.revature.casestudymjh.Models.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionItem, Integer> {
}
