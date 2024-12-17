package tech.reliab.course.kova.bank.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void testPersonDefaultConstructor() {
        Person person = new Person();

        assertThat(person.getId()).isEqualTo(0L);
        assertThat(person.getName()).isEqualTo("-");
        assertThat(person.getBirthdayDate()).isNull();
    }

    @Test
    public void testPersonParameterizedConstructorNameOnly() {
        Person person = new Person("John Doe");

        assertThat(person.getName()).isEqualTo("John Doe");
        assertThat(person.getBirthdayDate()).isNull();
    }

    @Test
    public void testPersonParameterizedConstructorNameAndBirthday() {
        LocalDate birthday = LocalDate.of(1990, 1, 1);
        Person person = new Person("John Doe", birthday);

        assertThat(person.getName()).isEqualTo("John Doe");
        assertThat(person.getBirthdayDate()).isEqualTo(birthday);
    }

    @Test
    public void testPersonCopyConstructor() {
        LocalDate birthday = LocalDate.of(1990, 1, 1);
        Person originalPerson = new Person("Jane Doe", birthday);

        Person copiedPerson = new Person(originalPerson);

        assertThat(copiedPerson).isNotSameAs(originalPerson);
        assertThat(copiedPerson.getId()).isEqualTo(originalPerson.getId());
        assertThat(copiedPerson.getName()).isEqualTo(originalPerson.getName());
        assertThat(copiedPerson.getBirthdayDate()).isEqualTo(originalPerson.getBirthdayDate());
    }

    @Test
    public void testSettersAndGetters() {
        Person person = new Person();

        person.setName("Alice");
        LocalDate birthday = LocalDate.of(2000, 5, 20);
        person.setBirthdayDate(birthday);

        assertThat(person.getName()).isEqualTo("Alice");
        assertThat(person.getBirthdayDate()).isEqualTo(birthday);
    }
}
