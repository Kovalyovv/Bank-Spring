package tech.reliab.course.kova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class CreditAccount extends Account implements Serializable {
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int monthsAmount = 0;
    private int creditSum = 0;
    private int monthlyPayment = 0;
    private int interestRate = 0;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private PaymentAccount paymentAccount;

    public CreditAccount() {}

    public CreditAccount(User user, Bank bank, LocalDate dateStart, LocalDate dateEnd,
                         int monthAmount, int creditSum, int monthlyPayment, int interestRate,
                         Employee employee, PaymentAccount paymentAccount) {
        super(user, bank);
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.monthsAmount = monthAmount;
        this.creditSum = creditSum;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }
}
