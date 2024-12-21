package zerobase.projectfintech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.projectfintech.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
