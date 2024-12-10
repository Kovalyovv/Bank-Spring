package tech.reliab.course.kova.bank.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = true)
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    protected Long id = 0L;
    protected String name = "-";
    protected LocalDate birthdayDate = null;

    public Person() {}

    public Person(Person person) {
        id = person.id;
        name = person.name;
        birthdayDate = person.birthdayDate;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, LocalDate birthdayDate) {
        this.name = name;
        this.birthdayDate = birthdayDate;
    }
}
