package tech.reliab.course.kova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
@Entity
public class Employee extends Person {
    private String jobTitle = "-";
    @ManyToOne
    private Bank bank = null;
    private boolean isRemoteWork = false;
    @ManyToOne
    private BankOffice bankOffice = null;
    private boolean isGiveCreditAvailable = false;
    private int salary = 0;

    public Employee(String name, LocalDate birthdayDate, String jobTitle, Bank bank, boolean isRemoteWork, BankOffice bankOffice,
                    boolean isGiveCreditAvailable, int salary) {
        super(name, birthdayDate);
        this.jobTitle = jobTitle;
        this.bank = bank;
        this.isRemoteWork = isRemoteWork;
        this.bankOffice = bankOffice;
        this.isGiveCreditAvailable = isGiveCreditAvailable;
        this.salary = salary;
    }

    public Employee(Employee employee) {
        super(employee.id, employee.name, employee.birthdayDate);
        jobTitle = employee.jobTitle;
        bank = new Bank(employee.bank);
        isRemoteWork = employee.isRemoteWork;
        bankOffice = new BankOffice(employee.bankOffice);
        isGiveCreditAvailable = employee.isGiveCreditAvailable;
        salary = employee.salary;
    }
}
