package tech.reliab.course.kova.bank.service;

import tech.reliab.course.kova.bank.entity.CreditAccount;
import tech.reliab.course.kova.bank.entity.PaymentAccount;
import tech.reliab.course.kova.bank.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    boolean addPaymentAccount(Long id, PaymentAccount account);

    boolean addCreditAccount(Long id, CreditAccount account);

    List<PaymentAccount> getAllPaymentAccountsByUserId(Long id);

    List<CreditAccount> getAllCreditAccountsByUserId(Long id);

    int calculateCreditRating(User user);
}
