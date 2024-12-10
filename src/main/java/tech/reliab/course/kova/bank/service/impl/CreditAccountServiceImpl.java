package tech.reliab.course.kova.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.kova.bank.entity.CreditAccount;
import tech.reliab.course.kova.bank.repository.CreditAccountRepository;
import tech.reliab.course.kova.bank.service.CreditAccountService;

import java.util.List;

@Service
public class CreditAccountServiceImpl implements CreditAccountService {
    private final CreditAccountRepository creditAccountRepository;

    public CreditAccountServiceImpl(CreditAccountRepository creditAccountRepository) {
        this.creditAccountRepository = creditAccountRepository;
    }

    public CreditAccount create(CreditAccount creditAccount) {
        if (creditAccount == null) {
            return null;
        }

        if (creditAccount.getMonthsAmount() < 1) {
            System.err.println("[ERROR] | CreditAccount - monthCount must be at least 1");
            return null;
        }

        if (creditAccount.getCreditSum() <= 0) {
            System.err.println("[ERROR] | CreditAccount - creditAmount must be positive");
            return null;
        }

        if (creditAccount.getBank() == null) {
            System.err.println("[ERROR] | CreditAccount - no bank");
            return null;
        }

        return creditAccountRepository.save(creditAccount);
    }

    public CreditAccount getCreditAccountById(Long id) {
        return creditAccountRepository.findById(id).orElse(null);
    }

    public List<CreditAccount> getAllCreditAccounts() {
        return creditAccountRepository.findAll();
    }

    public boolean doMonthlyPayment(CreditAccount creditAccount) {
        if (creditAccount == null || creditAccount.getPaymentAccount() == null) {
            System.err.println("[ERROR] | CreditAccount - no account to take money from");
            return false;
        }

        final int monthlyPayment = creditAccount.getMonthlyPayment();
        final int paymentAccountBalance = creditAccount.getPaymentAccount().getBalance();

        if (paymentAccountBalance - monthlyPayment < 0) {
            System.err.println("[ERROR] | CreditAccount - not enough balance for monthly payment");
            return false;
        }

        creditAccount.getPaymentAccount().setBalance(paymentAccountBalance - monthlyPayment);
        creditAccount.setCreditSum(creditAccount.getCreditSum() - monthlyPayment);
        creditAccountRepository.save(creditAccount);
        return true;
    }
}
