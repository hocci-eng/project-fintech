package zerobase.projectfintech.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private String accountPw;
    private Long balance;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
