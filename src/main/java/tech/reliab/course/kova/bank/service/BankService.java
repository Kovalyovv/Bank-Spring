package tech.reliab.course.kova.bank.service;

import tech.reliab.course.kova.bank.entity.Bank;
import tech.reliab.course.kova.bank.entity.BankOffice;
import tech.reliab.course.kova.bank.entity.User;


import java.util.List;

public interface BankService {
    // create bank
    Bank create(Bank bank);

    Bank getBankById(Long id);

    List<Bank> getAllBanks();

    List<BankOffice> getAllBankOfficesByBankId(Long id);

    // add office
    boolean addOffice(Long id, BankOffice bankOffice);

    // delete office from bank
    boolean deleteOffice(Long id, BankOffice bankOffice);

    // add user
    boolean addUser(Long id, User user);

    // delete user from bank
    boolean deleteUser(Long id, User user);

    // calculate interest rate
    double calculateInterestRate(Bank bank);

    // input money
    boolean inputMoney(Long id, long money);

    // output money
    boolean outputMoney(Long id, long money);
}
