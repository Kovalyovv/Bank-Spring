package tech.reliab.course.kova.bank.entity;

import lombok.*;
import jakarta.persistence.*;

@Setter
@Getter
@MappedSuperclass
@ToString(includeFieldNames = true)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    protected Long id;
    @ManyToOne
    protected User user;
    @ManyToOne
    protected Bank bank;

    public Account() {}

    public Account(User user, Bank bank) {
        this.user = user;
        this.bank = bank;
    }
}
