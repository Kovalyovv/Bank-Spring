package tech.reliab.course.tutovda.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.reliab.course.tutovda.bank.entity.*;
import tech.reliab.course.tutovda.bank.repository.*;
import tech.reliab.course.tutovda.bank.service.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(BankService bankService, BankOfficeService bankOfficeService,
							   EmployeeService employeeService, BankAtmService bankAtmService) {
		return args -> {
			// Create Banks
			for (int i = 1; i <= 5; i++) {
				bankService.create(new Bank("Blatnoy Bank #" + i));
			}

			List<Bank> bankList = bankService.getAllBanks();

			// Create Bank Offices
			for (Bank bank : bankList) {
				for (int i = 1; i <= 2; i++) {
					bankOfficeService.create(new BankOffice(
							"Office #" + i + " of " + bank.getName(),
							"Street Dorojnaya, #" + i,
							bank,
							true,
							true,
							0,
							true,
							true,
							true,
							14000,
							100 * i
					));
				}
			}

			List<BankOffice> officeList = bankOfficeService.getAllBankOffices();

			// Create Employees
			for (BankOffice office : officeList) {
				for (int i = 1; i <= 3; i++) {
					employeeService.create(new Employee(
							"Kovalev Dima #" + i,
							LocalDate.of(2003, 12, 9),
							"Cleaner",
							office.getBank(),
							false,
							office,
							false,
							7000
					));
				}
			}

			// Create ATMs
			for (BankOffice office : officeList) {
				for (int i = 1; i <= 3; i++) {
					bankAtmService.create(new BankAtm(
							"Super ATM #" + i + " of " + office.getBank().getName(),
							office.getAddress(),
							BankAtm.Status.WORKING,
							office.getBank(),
							office,
							null, // Assign default employee or leave null
							true,
							true,
							0,
							17
					));
				}
			}

			bankList.forEach(System.out::println);
			officeList.forEach(System.out::println);
		};
	}
}
