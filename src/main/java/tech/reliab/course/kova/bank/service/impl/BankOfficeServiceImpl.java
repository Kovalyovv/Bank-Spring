package tech.reliab.course.kova.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.kova.bank.entity.BankAtm;
import tech.reliab.course.kova.bank.entity.BankOffice;
import tech.reliab.course.kova.bank.entity.Employee;
import tech.reliab.course.kova.bank.repository.BankAtmRepository;
import tech.reliab.course.kova.bank.repository.BankOfficeRepository;
import tech.reliab.course.kova.bank.repository.EmployeeRepository;
import tech.reliab.course.kova.bank.service.BankOfficeService;

import java.util.List;

@Service
public class BankOfficeServiceImpl implements BankOfficeService {
    private final BankOfficeRepository bankOfficeRepository;
    private final EmployeeRepository employeeRepository;
    private final BankAtmRepository bankAtmRepository;

    public BankOfficeServiceImpl(BankOfficeRepository bankOfficeRepository,
                                 EmployeeRepository employeeRepository,
                                 BankAtmRepository bankAtmRepository) {
        this.bankOfficeRepository = bankOfficeRepository;
        this.employeeRepository = employeeRepository;
        this.bankAtmRepository = bankAtmRepository;
    }

    public BankOffice create(BankOffice bankOffice) {
        if (bankOffice == null) {
            return null;
        }

        if (bankOffice.getTotalMoney() < 0) {
            System.err.println("[ERROR] | BankOffice -> total money must be non-negative");
            return null;
        }

        if (bankOffice.getBank() == null) {
            System.err.println("[ERROR] | BankOffice -> must have bank");
            return null;
        }

        if (bankOffice.getRentPrice() < 0) {
            System.err.println("[ERROR] | BankOffice -> rentPrice must be non-negative");
            return null;
        }

        return bankOfficeRepository.save(bankOffice);
    }

    public BankOffice getBankOfficeById(Long id) {
        return bankOfficeRepository.findById(id).orElse(null);
    }

    public List<BankOffice> getAllBankOffices() {
        return bankOfficeRepository.findAll();
    }

    public List<Employee> getAllEmployeesByOfficeId(Long id) {
        return employeeRepository.findAllByBankOfficeId(id);
    }

    public boolean inputMoney(BankOffice bankOffice, int money) {
        if (bankOffice == null) {
            System.err.println("[ERROR] | BankOffice -> can not deposit money to not existing office");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] | BankOffice -> can not deposit money -> deposit amount must be positive");
            return false;
        }

        if (!bankOffice.isCashOutputAvailable()) {
            System.err.println("[ERROR] | BankOffice -> can not deposit money -> office can not accept deposit");
            return false;
        }

        bankOffice.setTotalMoney(bankOffice.getTotalMoney() + money);
        bankOfficeRepository.save(bankOffice);
        return true;
    }

    public boolean outputMoney(BankOffice bankOffice, int money) {
        if (bankOffice == null) {
            System.err.println("[ERROR] | BankOffice -> can not withdraw money from not existing office");
            return false;
        }

        if (money <= 0) {
            System.err.println("[ERROR] | BankOffice -> can not withdraw money -> withdraw amount must be positive");
            return false;
        }

        if (!bankOffice.isCashOutputAvailable()) {
            System.err.println("[ERROR] | BankOffice -> can not withdraw money -> office can not give withdrawal");
            return false;
        }

        if (bankOffice.getTotalMoney() - money < 0) {
            System.err.println("[ERROR] | BankOffice -> can not withdraw money -> office does not have enough money");
            return false;
        }

        bankOffice.setTotalMoney(bankOffice.getTotalMoney() - money);
        bankOfficeRepository.save(bankOffice);
        return true;
    }

    public boolean installAtm(Long id, BankAtm bankAtm) {
        BankOffice bankOffice = getBankOfficeById(id);
        if (bankOffice != null && bankAtm != null) {
            if (!bankOffice.isAtmPlaceable()) {
                System.err.println("[ERROR] | BankOffice -> can not install atm");
                return false;
            }

            bankOffice.setAtmsAmount(bankOffice.getAtmsAmount() + 1);
            bankOffice.getBank().setAtmsAmount(bankOffice.getBank().getAtmsAmount() + 1);
            bankAtm.setBankOffice(bankOffice);
            bankAtm.setAddress(bankOffice.getAddress());
            bankAtm.setBank(bankOffice.getBank());
            bankAtmRepository.save(bankAtm);
            bankOfficeRepository.save(bankOffice);
            return true;
        }
        return false;
    }

    public boolean removeAtm(BankOffice bankOffice, BankAtm bankAtm) {
        if (bankOffice != null && bankAtm != null) {
            if (bankOffice.getAtmsAmount() - 1 < 0) {
                System.err.println("[ERROR] | BankOffice -> can not remove ATM, no ATMs");
                return false;
            }

            bankOffice.setAtmsAmount(bankOffice.getAtmsAmount() - 1);
            bankAtmRepository.deleteById(bankAtm.getId());
            bankOfficeRepository.save(bankOffice);
            return true;
        }
        return false;
    }

    public boolean addEmployee(Long id, Employee employee) {
        BankOffice bankOffice = getBankOfficeById(id);
        if (bankOffice != null && employee != null) {
            employee.setBankOffice(bankOffice);
            employee.setBank(bankOffice.getBank());
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    public boolean removeEmployee(BankOffice bankOffice, Employee employee) {
        if (bankOffice != null && employee != null){
            employeeRepository.deleteById(employee.getId());
            return true;
        }
        return false;
    }
}
