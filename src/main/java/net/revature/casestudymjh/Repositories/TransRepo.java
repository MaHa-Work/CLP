package net.revature.casestudymjh.Repositories;

import net.revature.casestudymjh.Models.Trans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransRepo extends JpaRepository <Trans, Integer> {
    List<Trans> findAllByUserId(Integer id);
}
