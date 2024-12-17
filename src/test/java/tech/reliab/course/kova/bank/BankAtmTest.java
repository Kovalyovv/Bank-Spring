package tech.reliab.course.kova.bank.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BankAtmTest {

    @Test
    public void testBankAtmDefaultConstructor() {
        BankAtm bankAtm = new BankAtm();

        assertThat(bankAtm.getId()).isEqualTo(0L);
        assertThat(bankAtm.getName()).isEqualTo("-");
        assertThat(bankAtm.getAddress()).isEqualTo("-");
        assertThat(bankAtm.getStatus()).isEqualTo(BankAtm.Status.NOT_WORKING);
        assertThat(bankAtm.getBank()).isNull();
        assertThat(bankAtm.getBankOffice()).isNull();
        assertThat(bankAtm.getEmployee()).isNull();
        assertThat(bankAtm.isCashOutputAvailable()).isFalse();
        assertThat(bankAtm.isCashInputAvailable()).isFalse();
        assertThat(bankAtm.getTotalMoney()).isEqualTo(0L);
        assertThat(bankAtm.getMaintenancePrice()).isEqualTo(0);
    }

    @Test
    public void testBankAtmParameterizedConstructor() {
        BankAtm bankAtm = new BankAtm("ATM1", "123 Street");

        assertThat(bankAtm.getName()).isEqualTo("ATM1");
        assertThat(bankAtm.getAddress()).isEqualTo("123 Street");
        assertThat(bankAtm.getStatus()).isEqualTo(BankAtm.Status.NOT_WORKING);
    }

    @Test
    public void testBankAtmFullConstructor() {
        Bank bank = new Bank("My Bank", "456 Bank Street");
        BankOffice bankOffice = new BankOffice("Office1", "456 Bank Street");
        Employee employee = new Employee("John Doe", "Manager");

        BankAtm bankAtm = new BankAtm(
                "ATM2",
                "789 Street",
                BankAtm.Status.WORKING,
                bank,
                bankOffice,
                employee,
                true,
                false,
                50000L,
                1000
        );

        assertThat(bankAtm.getName()).isEqualTo("ATM2");
        assertThat(bankAtm.getAddress()).isEqualTo("789 Street");
        assertThat(bankAtm.getStatus()).isEqualTo(BankAtm.Status.WORKING);
        assertThat(bankAtm.getBank()).isEqualTo(bank);
        assertThat(bankAtm.getBankOffice()).isEqualTo(bankOffice);
        assertThat(bankAtm.getEmployee()).isEqualTo(employee);
        assertThat(bankAtm.isCashOutputAvailable()).isTrue();
        assertThat(bankAtm.isCashInputAvailable()).isFalse();
        assertThat(bankAtm.getTotalMoney()).isEqualTo(50000L);
        assertThat(bankAtm.getMaintenancePrice()).isEqualTo(1000);
    }

    @Test
    public void testBankAtmCopyConstructor() {
        Bank bank = new Bank("My Bank", "456 Bank Street");
        BankOffice bankOffice = new BankOffice("Office1", "456 Bank Street");
        Employee employee = new Employee("John Doe", "Manager");

        BankAtm originalAtm = new BankAtm(
                "ATM3",
                "101 Main St",
                BankAtm.Status.NO_MONEY,
                bank,
                bankOffice,
                employee,
                false,
                true,
                0L,
                500
        );

        BankAtm copiedAtm = new BankAtm(originalAtm);

        assertThat(copiedAtm).isNotSameAs(originalAtm);
        assertThat(copiedAtm.getName()).isEqualTo(originalAtm.getName());
        assertThat(copiedAtm.getAddress()).isEqualTo(originalAtm.getAddress());
        assertThat(copiedAtm.getStatus()).isEqualTo(originalAtm.getStatus());
        assertThat(copiedAtm.getBank()).isNotSameAs(originalAtm.getBank());
        assertThat(copiedAtm.getBankOffice()).isNotSameAs(originalAtm.getBankOffice());
        assertThat(copiedAtm.getEmployee()).isNotSameAs(originalAtm.getEmployee());
        assertThat(copiedAtm.isCashOutputAvailable()).isEqualTo(originalAtm.isCashOutputAvailable());
        assertThat(copiedAtm.isCashInputAvailable()).isEqualTo(originalAtm.isCashInputAvailable());
        assertThat(copiedAtm.getTotalMoney()).isEqualTo(originalAtm.getTotalMoney());
        assertThat(copiedAtm.getMaintenancePrice()).isEqualTo(originalAtm.getMaintenancePrice());
    }
}
