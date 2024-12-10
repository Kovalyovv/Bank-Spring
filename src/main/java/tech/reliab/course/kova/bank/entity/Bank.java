package tech.reliab.course.kova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = true)
@Entity
public class Bank {
    public final double MAX_INTEREST_RATE = 20.0;
    public final int MAX_BANK_RATING = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id = 0L;
    private String name = "-";
    private int officesAmount = 0;
    private int atmsAmount = 0;
    private int employeesAmount = 0;
    private int clientsAmount = 0;
    private byte rating = (byte) (1 + Math.random() * 100);
    private long totalMoney = 0;
    private double interestRate = 0;

    public Bank() {}

    public Bank(Bank bank) {
        id = bank.id;
        name = bank.name;
        officesAmount = bank.officesAmount;
        atmsAmount = bank.atmsAmount;
        employeesAmount = bank.employeesAmount;
        clientsAmount = bank.clientsAmount;
        rating = bank.rating;
        totalMoney = bank.totalMoney;
        interestRate = bank.interestRate;
    }

    public Bank(String name) {
        this.name = name;
    }
}
