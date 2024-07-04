package com.example.splitwise.repository;

import com.example.splitwise.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByGroupId(Long groupId);


    @Query(
            " select t from Transaction t where t.userId= :userId "
    )
    List<Transaction> findCustom(Long userId);
}
