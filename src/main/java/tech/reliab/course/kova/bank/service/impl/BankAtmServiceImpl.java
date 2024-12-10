package tech.reliab.course.kova.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tech.reliab.course.kova.bank.entity.BankAtm;
import tech.reliab.course.kova.bank.repository.BankAtmRepository;
import tech.reliab.course.kova.bank.service.BankAtmService;

import java.util.List;

public class BankAtmServiceImpl implements BankAtmService {
    private final BankAtmRepository bankAtmRepository;

    public BankAtmServiceImpl(BankAtmRepository bankAtmRepository) {
        this.bankAtmRepository = bankAtmRepository;
    }

    public BankAtm create(BankAtm bankAtm) {
        return bankAtmRepository.save(bankAtm);
    }

    public void delete(Long id) {
        bankAtmRepository.deleteById(id);
    }

    public BankAtm getBankAtmById(Long id) {
        return bankAtmRepository.findById(id).orElse(null);
    }

    public List<BankAtm> getAllBankAtms() {
        return bankAtmRepository.findAll();
    }

    public boolean inputMoney(BankAtm bankAtm, int money) {
        if (bankAtm == null) {
            System.err.println("[ERROR] BankAtm can not deposit money - non existing ATM");
            return false;
        }
        if (money <= 0) {
            System.err.println("[ERROR] BankAtm can not deposit money - amount is not positive");
            return false;
        }
        if (!bankAtm.isCashOutputAvailable()) {
            System.err.println("[ERROR] BankAtm can not deposit money - deposit is not allowed");
            return false;
        }
        bankAtm.setTotalMoney(bankAtm.getTotalMoney() + money);
        bankAtmRepository.save(bankAtm);
        return true;
    }

    public boolean outputMoney(BankAtm bankAtm, int money) {
        if (bankAtm == null) {
            System.err.println("[ERROR] BankAtm can not withdraw money - non existing ATM");
            return false;
        }
        if (money <= 0) {
            System.err.println("[ERROR] BankAtm can not withdraw money - amount is not positive");
            return false;
        }
        if (!bankAtm.isCashOutputAvailable()) {
            System.err.println("[ERROR] BankAtm can not withdraw money - deposit is not allowed");
            return false;
        }
        if (bankAtm.getTotalMoney() - money < 0) {
            System.err.println("[ERROR] BankAtm can not withdraw money - ATM does not have enough money");
            return false;
        }
        bankAtm.setTotalMoney(bankAtm.getTotalMoney() - money);
        bankAtmRepository.save(bankAtm);
        return true;
    }
}
