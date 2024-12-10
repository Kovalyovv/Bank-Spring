package tech.reliab.course.kova.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.kova.bank.entity.Bank;
import tech.reliab.course.kova.bank.entity.BankOffice;
import tech.reliab.course.kova.bank.entity.User;
import tech.reliab.course.kova.bank.entity.*;
import tech.reliab.course.kova.bank.repository.BankOfficeRepository;
import tech.reliab.course.kova.bank.repository.BankRepository;
import tech.reliab.course.kova.bank.repository.EmployeeRepository;
import tech.reliab.course.kova.bank.repository.UserRepository;
import tech.reliab.course.kova.bank.service.BankService;

import java.util.*;

@Service
public class BankServiceImpl implements BankService {
    private final BankOfficeRepository bankOfficeRepository;
    private final BankRepository bankRepository;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public BankServiceImpl(BankOfficeRepository bankOfficeRepository,
                           BankRepository bankRepository,
                           EmployeeRepository employeeRepository,
                           UserRepository userRepository) {
        this.bankOfficeRepository = bankOfficeRepository;
        this.bankRepository = bankRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    public Bank create(Bank bank) {
        if (bank == null) {
            return null;
        }
        return bankRepository.save(bank);
    }

    public Bank getBankById(Long id) {
        return bankRepository.findById(id).orElse(null);
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public List<BankOffice> getAllBankOfficesByBankId(Long id) {
        Bank bank = getBankById(id);
        if (bank != null) {
            return bankOfficeRepository.findAllBankOfficesByBankId(id);
        }
        return null;
    }

    public boolean addOffice(Long id, BankOffice bankOffice) {
        Bank bank = getBankById(id);
        if (bank != null && bankOffice != null) {
            bankOffice.setBank(bank);
            bank.setOfficesAmount(bank.getOfficesAmount() + 1);
            bank.setAtmsAmount(bank.getAtmsAmount() + bankOffice.getAtmsAmount());
            inputMoney(id, bankOffice.getTotalMoney());
            bankRepository.save(bank);
            bankOfficeRepository.save(bankOffice);
            return true;
        }
        return false;
    }

    public boolean deleteOffice(Long id, BankOffice bankOffice) {
        Bank bank = getBankById(id);
        int officeId = bankOfficeRepository.findAllBankOfficesByBankId(id).indexOf(bankOffice);
        if (bank != null && bankOffice != null) {
            if (bank.getOfficesAmount() - 1 < 0) {
                System.err.println("[ERROR] Bank " + bank.getName() + " | Can't delete office. Already zero");
                return false;
            }

            bank.setOfficesAmount(bank.getOfficesAmount() - 1);
            bankOfficeRepository.deleteById(bankOffice.getId());
            bankRepository.save(bank);
            return true;
        }
        return false;
    }

    public boolean addUser(Long id, User user) {
        Bank bank = getBankById(id);
        if (bank != null && user != null) {
            user.setBank(bank);
            bank.setClientsAmount(bank.getClientsAmount() + 1);
            userRepository.save(user);
            bankRepository.save(bank);
            return true;
        }
        return false;
    }

    public boolean deleteUser(Long id, User user) {
        Bank bank = getBankById(id);
        if (bank != null && user != null) {
            if (bank.getClientsAmount() - 1 < 0) {
                System.err.println("[ERROR] Bank " + bank.getName() + " | Can't delete clients. Already zero");
                return false;
            }

            bank.setClientsAmount(bank.getClientsAmount() - 1);
            userRepository.deleteById(user.getId());
            bankRepository.save(bank);
            return true;
        }
        return false;
    }

    public double calculateInterestRate(Bank bank) {
        if (bank != null) {
            double reductionFactor = (bank.MAX_BANK_RATING - bank.getRating() + 1) / (double) bank.MAX_BANK_RATING;

            Random random = new Random();
            double baseRate = random.nextDouble() * bank.MAX_INTEREST_RATE;
            double interestRate = baseRate * reductionFactor;

            return Math.round(interestRate * 100.0) / 100.0;
        }

        return 0.0;
    }

    public boolean inputMoney(Long id, long money) {
        Bank bank = getBankById(id);
        if (bank == null) {
            System.err.println("[ERROR] Bank | Can not deposit money to uninitialized bank");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] Bank | Can not deposit money. Deposit amount must be positive");
            return false;
        }

        bank.setTotalMoney(bank.getTotalMoney() + money);
        bankRepository.save(bank);
        return true;
    }

    public boolean outputMoney(Long id, long money) {
        Bank bank = getBankById(id);
        if (bank == null) {
            System.err.println("[ERROR] Bank | Can not withdraw money from uninitialized bank");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] Bank | Can not withdraw money. Withdraw amount must be positive");
            return false;
        }

        if (bank.getTotalMoney() - money < 0) {
            System.err.println("[ERROR] Bank | Can not withdraw money. Bank does not have enough money");
            return false;
        }

        bank.setTotalMoney(bank.getTotalMoney() - money);
        bankRepository.save(bank);
        return true;
    }

}
