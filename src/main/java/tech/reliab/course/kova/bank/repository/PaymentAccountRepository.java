package tech.reliab.course.kova.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.kova.bank.entity.PaymentAccount;

import java.util.List;

@Repository
public interface PaymentAccountRepository extends JpaRepository<PaymentAccount,Long> {
    List<PaymentAccount> findAllPaymentAccountsByUserId(Long id);
}
