package tech.reliab.course.kova.bank.service;

import tech.reliab.course.kova.bank.entity.CreditAccount;

import java.util.List;

public interface CreditAccountService {
    CreditAccount create(CreditAccount creditAccount);

    CreditAccount getCreditAccountById(Long id);

    List<CreditAccount> getAllCreditAccounts();

    boolean doMonthlyPayment(CreditAccount creditAccount);
}
