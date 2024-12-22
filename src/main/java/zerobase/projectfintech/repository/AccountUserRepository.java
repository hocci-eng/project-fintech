package zerobase.projectfintech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.projectfintech.domain.AccountUser;

import java.util.Optional;

public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {

    Optional<AccountUser> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
