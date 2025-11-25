package org.example.order.repository;

import org.example.order.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author LXZ 2025/11/25 11:45
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccountNo(String accountNo);
}
