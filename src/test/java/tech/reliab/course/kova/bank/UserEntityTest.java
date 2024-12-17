package tech.reliab.course.kova.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;
import tech.reliab.course.kova.bank.entity.*;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataJpaTest
@Import(TestDatabaseConfig.class)
public class UserEntityTest {

    @Autowired
    private EntityManager entityManager;

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15-alpine");

    @Test
    void testUserEntityPersistence() {

        Bank bank = new Bank("Test Bank");
        entityManager.persist(bank);

        User user = new User("Ivan Ivanov", LocalDate.of(1990, 5, 20),
                "Google", 5000, bank, 750);
        entityManager.persist(user);


        User foundUser = entityManager.find(User.class, user.getId());
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo("Ivan Ivanov");
        assertThat(foundUser.getBank().getName()).isEqualTo("Test Bank");
    }

    @Test
    void testBankOfficeAndATM() {

        Bank bank = new Bank("Test Bank 2");
        BankOffice office = new BankOffice("Office1", "Street 123", bank, true, true, 5, true, true, true, 500000, 10000);

        entityManager.persist(bank);
        entityManager.persist(office);


        BankAtm atm = new BankAtm("ATM1", "Street 123", BankAtm.Status.WORKING, bank, office, null, true, true, 100000, 500);
        entityManager.persist(atm);


        BankAtm foundAtm = entityManager.find(BankAtm.class, atm.getId());
        assertThat(foundAtm).isNotNull();
        assertThat(foundAtm.getName()).isEqualTo("ATM1");
        assertThat(foundAtm.getBank().getName()).isEqualTo("Test Bank 2");
        assertThat(foundAtm.getBankOffice().getName()).isEqualTo("Office1");
    }
}
