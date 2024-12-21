package zerobase.projectfintech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.projectfintech.domain.AccountUser;

public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {

    boolean existsByUserId(String userId);
}
