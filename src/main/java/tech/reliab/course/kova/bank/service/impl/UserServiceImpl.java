package tech.reliab.course.kova.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.kova.bank.entity.CreditAccount;
import tech.reliab.course.kova.bank.entity.PaymentAccount;
import tech.reliab.course.kova.bank.entity.User;
import tech.reliab.course.kova.bank.repository.CreditAccountRepository;
import tech.reliab.course.kova.bank.repository.PaymentAccountRepository;
import tech.reliab.course.kova.bank.repository.UserRepository;
import tech.reliab.course.kova.bank.service.UserService;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CreditAccountRepository creditAccountRepository;
    private final PaymentAccountRepository paymentAccountRepository;

    public UserServiceImpl(UserRepository userRepository, CreditAccountRepository creditAccountRepository,
                           PaymentAccountRepository paymentAccountRepository) {
        this.userRepository = userRepository;
        this.creditAccountRepository = creditAccountRepository;
        this.paymentAccountRepository = paymentAccountRepository;
    }

    public User create(User user) {
        if (user == null) {
            return null;
        }

        if (user.getBank() == null) {
            System.err.println("[ERROR] User must have bank");
            return null;
        }


        Random random = new Random();
        final int monthlyIncome = random.nextInt() * 10000;
        user.setMonthlyIncome(monthlyIncome);
        calculateCreditRating(user);

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            System.err.println("[ERROR] User with id -> " + id + " is not found");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean addPaymentAccount(Long id, PaymentAccount account) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            account.setUser(user);
            paymentAccountRepository.save(account);
            return true;
        }
        return false;
    }

    public boolean addCreditAccount(Long id, CreditAccount account) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            account.setUser(user);
            creditAccountRepository.save(account);
            return true;
        }
        return false;
    }

    public List<PaymentAccount> getAllPaymentAccountsByUserId(Long id) {
        return paymentAccountRepository.findAllPaymentAccountsByUserId(id);
    }

    public List<CreditAccount> getAllCreditAccountsByUserId(Long id) {
        return creditAccountRepository.findAllCreditAccountsByUserId(id);
    }

    public int calculateCreditRating(User user) {
        user.setCreditRating(user.getMonthlyIncome() / 10);
        userRepository.save(user);
        return user.getCreditRating();
    }

}
