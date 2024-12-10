package tech.reliab.course.kova.bank.entity;


import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class PaymentAccount extends Account implements Serializable {
    private int balance = 0;

    public PaymentAccount() {}

    public PaymentAccount(User user, Bank bank, int balance) {
        super(user, bank);
        this.balance = balance;
    }
}
