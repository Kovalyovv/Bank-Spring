package tech.reliab.course.kova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class User extends Person {
    private String workPlace = "-";
    private int monthlyIncome = (int) (1 + Math.random() * 10000);
    @ManyToOne
    private Bank bank;
    private PaymentAccount paymentAccount = null;
    private CreditAccount creditAccount = null;
    private int creditRating = (int) (1 + Math.random() * 1000);

    public User(String name, LocalDate birthdayDate, String workPlace,
                int monthlyIncome, Bank bank, int creditRating) {
        super(name, birthdayDate);
        this.workPlace = workPlace;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.creditRating = creditRating;
    }

    public User(String name, LocalDate birthdayDate, String workPlace, int monthlyIncome, Bank bank,
                PaymentAccount paymentAccount, CreditAccount creditAccount, int creditRating) {
        super(name, birthdayDate);
        this.workPlace = workPlace;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.paymentAccount = paymentAccount;
        this.creditAccount = creditAccount;
        this.creditRating = creditRating;
    }
}
