package tech.reliab.course.kova.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import tech.reliab.course.kova.bank.entity.*;
import tech.reliab.course.kova.bank.repository.*;
import tech.reliab.course.kova.bank.service.*;
import tech.reliab.course.kova.bank.service.impl.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	public void run(String... args) throws Exception {
		BankAtmRepository bankAtmRepository = new BankAtmRepository() {
			@Override
			public List<BankAtm> findAllBankAtmsByBankOfficeId(Long id) {
				return List.of();
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends BankAtm> S saveAndFlush(S entity) {
				return null;
			}

			@Override
			public <S extends BankAtm> List<S> saveAllAndFlush(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public void deleteAllInBatch(Iterable<BankAtm> entities) {

			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Long> longs) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public BankAtm getOne(Long aLong) {
				return null;
			}

			@Override
			public BankAtm getById(Long aLong) {
				return null;
			}

			@Override
			public BankAtm getReferenceById(Long aLong) {
				return null;
			}

			@Override
			public <S extends BankAtm> List<S> findAll(Example<S> example) {
				return List.of();
			}

			@Override
			public <S extends BankAtm> List<S> findAll(Example<S> example, Sort sort) {
				return List.of();
			}

			@Override
			public <S extends BankAtm> List<S> saveAll(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public List<BankAtm> findAll() {
				return List.of();
			}

			@Override
			public List<BankAtm> findAllById(Iterable<Long> longs) {
				return List.of();
			}

			@Override
			public <S extends BankAtm> S save(S entity) {
				return null;
			}

			@Override
			public Optional<BankAtm> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(BankAtm entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Long> longs) {

			}

			@Override
			public void deleteAll(Iterable<? extends BankAtm> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public List<BankAtm> findAll(Sort sort) {
				return List.of();
			}

			@Override
			public Page<BankAtm> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends BankAtm> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends BankAtm> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends BankAtm> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends BankAtm> boolean exists(Example<S> example) {
				return false;
			}

			@Override
			public <S extends BankAtm, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				return null;
			}
		};

		BankOfficeRepository bankOfficeRepository = new BankOfficeRepository() {
			@Override
			public List<BankOffice> findAllBankOfficesByBankId(Long id) {
				return List.of();
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends BankOffice> S saveAndFlush(S entity) {
				return null;
			}

			@Override
			public <S extends BankOffice> List<S> saveAllAndFlush(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public void deleteAllInBatch(Iterable<BankOffice> entities) {

			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Long> longs) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public BankOffice getOne(Long aLong) {
				return null;
			}

			@Override
			public BankOffice getById(Long aLong) {
				return null;
			}

			@Override
			public BankOffice getReferenceById(Long aLong) {
				return null;
			}

			@Override
			public <S extends BankOffice> List<S> findAll(Example<S> example) {
				return List.of();
			}

			@Override
			public <S extends BankOffice> List<S> findAll(Example<S> example, Sort sort) {
				return List.of();
			}

			@Override
			public <S extends BankOffice> List<S> saveAll(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public List<BankOffice> findAll() {
				return List.of();
			}

			@Override
			public List<BankOffice> findAllById(Iterable<Long> longs) {
				return List.of();
			}

			@Override
			public <S extends BankOffice> S save(S entity) {
				return null;
			}

			@Override
			public Optional<BankOffice> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(BankOffice entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Long> longs) {

			}

			@Override
			public void deleteAll(Iterable<? extends BankOffice> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public List<BankOffice> findAll(Sort sort) {
				return List.of();
			}

			@Override
			public Page<BankOffice> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends BankOffice> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends BankOffice> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends BankOffice> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends BankOffice> boolean exists(Example<S> example) {
				return false;
			}

			@Override
			public <S extends BankOffice, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				return null;
			}
		};

		BankRepository bankRepository = new BankRepository() {
			@Override
			public void flush() {

			}

			@Override
			public <S extends Bank> S saveAndFlush(S entity) {
				return null;
			}

			@Override
			public <S extends Bank> List<S> saveAllAndFlush(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public void deleteAllInBatch(Iterable<Bank> entities) {

			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Long> longs) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public Bank getOne(Long aLong) {
				return null;
			}

			@Override
			public Bank getById(Long aLong) {
				return null;
			}

			@Override
			public Bank getReferenceById(Long aLong) {
				return null;
			}

			@Override
			public <S extends Bank> List<S> findAll(Example<S> example) {
				return List.of();
			}

			@Override
			public <S extends Bank> List<S> findAll(Example<S> example, Sort sort) {
				return List.of();
			}

			@Override
			public <S extends Bank> List<S> saveAll(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public List<Bank> findAll() {
				return List.of();
			}

			@Override
			public List<Bank> findAllById(Iterable<Long> longs) {
				return List.of();
			}

			@Override
			public <S extends Bank> S save(S entity) {
				return null;
			}

			@Override
			public Optional<Bank> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(Bank entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Long> longs) {

			}

			@Override
			public void deleteAll(Iterable<? extends Bank> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public List<Bank> findAll(Sort sort) {
				return List.of();
			}

			@Override
			public Page<Bank> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Bank> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends Bank> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Bank> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends Bank> boolean exists(Example<S> example) {
				return false;
			}

			@Override
			public <S extends Bank, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				return null;
			}
		};

		EmployeeRepository employeeRepository = new EmployeeRepository() {
			@Override
			public List<Employee> findAllByBankOfficeId(Long id) {
				return List.of();
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends Employee> S saveAndFlush(S entity) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public void deleteAllInBatch(Iterable<Employee> entities) {

			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Long> longs) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public Employee getOne(Long aLong) {
				return null;
			}

			@Override
			public Employee getById(Long aLong) {
				return null;
			}

			@Override
			public Employee getReferenceById(Long aLong) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> findAll(Example<S> example) {
				return List.of();
			}

			@Override
			public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
				return List.of();
			}

			@Override
			public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public List<Employee> findAll() {
				return List.of();
			}

			@Override
			public List<Employee> findAllById(Iterable<Long> longs) {
				return List.of();
			}

			@Override
			public <S extends Employee> S save(S entity) {
				return null;
			}

			@Override
			public Optional<Employee> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(Employee entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Long> longs) {

			}

			@Override
			public void deleteAll(Iterable<? extends Employee> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public List<Employee> findAll(Sort sort) {
				return List.of();
			}

			@Override
			public Page<Employee> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Employee> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Employee> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends Employee> boolean exists(Example<S> example) {
				return false;
			}

			@Override
			public <S extends Employee, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				return null;
			}
		};

		UserRepository userRepository = new UserRepository() {
			@Override
			public List<User> findAllUsersByBankId(Long id) {
				return List.of();
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends User> S saveAndFlush(S entity) {
				return null;
			}

			@Override
			public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public void deleteAllInBatch(Iterable<User> entities) {

			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Long> longs) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public User getOne(Long aLong) {
				return null;
			}

			@Override
			public User getById(Long aLong) {
				return null;
			}

			@Override
			public User getReferenceById(Long aLong) {
				return null;
			}

			@Override
			public <S extends User> List<S> findAll(Example<S> example) {
				return List.of();
			}

			@Override
			public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
				return List.of();
			}

			@Override
			public <S extends User> List<S> saveAll(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public List<User> findAll() {
				return List.of();
			}

			@Override
			public List<User> findAllById(Iterable<Long> longs) {
				return List.of();
			}

			@Override
			public <S extends User> S save(S entity) {
				return null;
			}

			@Override
			public Optional<User> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(User entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Long> longs) {

			}

			@Override
			public void deleteAll(Iterable<? extends User> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public List<User> findAll(Sort sort) {
				return List.of();
			}

			@Override
			public Page<User> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends User> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends User> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends User> boolean exists(Example<S> example) {
				return false;
			}

			@Override
			public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				return null;
			}
		};

		CreditAccountRepository creditAccountRepository = new CreditAccountRepository() {
			@Override
			public List<CreditAccount> findAllCreditAccountsByUserId(Long id) {
				return List.of();
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends CreditAccount> S saveAndFlush(S entity) {
				return null;
			}

			@Override
			public <S extends CreditAccount> List<S> saveAllAndFlush(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public void deleteAllInBatch(Iterable<CreditAccount> entities) {

			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Long> longs) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public CreditAccount getOne(Long aLong) {
				return null;
			}

			@Override
			public CreditAccount getById(Long aLong) {
				return null;
			}

			@Override
			public CreditAccount getReferenceById(Long aLong) {
				return null;
			}

			@Override
			public <S extends CreditAccount> List<S> findAll(Example<S> example) {
				return List.of();
			}

			@Override
			public <S extends CreditAccount> List<S> findAll(Example<S> example, Sort sort) {
				return List.of();
			}

			@Override
			public <S extends CreditAccount> List<S> saveAll(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public List<CreditAccount> findAll() {
				return List.of();
			}

			@Override
			public List<CreditAccount> findAllById(Iterable<Long> longs) {
				return List.of();
			}

			@Override
			public <S extends CreditAccount> S save(S entity) {
				return null;
			}

			@Override
			public Optional<CreditAccount> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(CreditAccount entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Long> longs) {

			}

			@Override
			public void deleteAll(Iterable<? extends CreditAccount> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public List<CreditAccount> findAll(Sort sort) {
				return List.of();
			}

			@Override
			public Page<CreditAccount> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends CreditAccount> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends CreditAccount> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends CreditAccount> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends CreditAccount> boolean exists(Example<S> example) {
				return false;
			}

			@Override
			public <S extends CreditAccount, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				return null;
			}
		};

		PaymentAccountRepository paymentAccountRepository = new PaymentAccountRepository() {
			@Override
			public List<PaymentAccount> findAllPaymentAccountsByUserId(Long id) {
				return List.of();
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends PaymentAccount> S saveAndFlush(S entity) {
				return null;
			}

			@Override
			public <S extends PaymentAccount> List<S> saveAllAndFlush(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public void deleteAllInBatch(Iterable<PaymentAccount> entities) {

			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Long> longs) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public PaymentAccount getOne(Long aLong) {
				return null;
			}

			@Override
			public PaymentAccount getById(Long aLong) {
				return null;
			}

			@Override
			public PaymentAccount getReferenceById(Long aLong) {
				return null;
			}

			@Override
			public <S extends PaymentAccount> List<S> findAll(Example<S> example) {
				return List.of();
			}

			@Override
			public <S extends PaymentAccount> List<S> findAll(Example<S> example, Sort sort) {
				return List.of();
			}

			@Override
			public <S extends PaymentAccount> List<S> saveAll(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public List<PaymentAccount> findAll() {
				return List.of();
			}

			@Override
			public List<PaymentAccount> findAllById(Iterable<Long> longs) {
				return List.of();
			}

			@Override
			public <S extends PaymentAccount> S save(S entity) {
				return null;
			}

			@Override
			public Optional<PaymentAccount> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(PaymentAccount entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Long> longs) {

			}

			@Override
			public void deleteAll(Iterable<? extends PaymentAccount> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public List<PaymentAccount> findAll(Sort sort) {
				return List.of();
			}

			@Override
			public Page<PaymentAccount> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends PaymentAccount> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends PaymentAccount> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends PaymentAccount> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends PaymentAccount> boolean exists(Example<S> example) {
				return false;
			}

			@Override
			public <S extends PaymentAccount, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				return null;
			}
		};

		BankService bankService = new BankServiceImpl(bankOfficeRepository, bankRepository, employeeRepository, userRepository);
		BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankOfficeRepository, employeeRepository, bankAtmRepository);
		EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
		BankAtmService bankAtmService = new BankAtmServiceImpl(bankAtmRepository);
		UserService userService = new UserServiceImpl(userRepository, creditAccountRepository, paymentAccountRepository);
		PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl(paymentAccountRepository);
		CreditAccountService creditAccountService = new CreditAccountServiceImpl(creditAccountRepository);

		for (int i = 1; i < 6; i++) {
			String name = "Blatnoy Bank #" + i;
			bankService.create(new Bank(name));
		}

		List<Bank> bankList = bankService.getAllBanks();
		for (Bank bank: bankList) {
			for (int i = 1; i < 3; i++) {
				bankOfficeService.create(new BankOffice(
						"Office #" + i + " of " + bank.getName(),
						"street Pushkina, house Kolotyshkina #" + i,
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
		for (BankOffice office: officeList) {
			for (int i = 1; i < 4; i++) {
				employeeService.create(new Employee(
						"Ruslan Polivaniy Version #" + i,
						LocalDate.of(2003, 12, 9),
						"Cleaner",
						office.getBank(),
						false,
						office,
						false,
						7000));
			}
		}

		// adding Atms
		for (BankOffice office: officeList) {
			for (int i = 1; i < 4; i++) {
				bankAtmService.create(new BankAtm(
						"Super ATM #" + i + " of 'Blatnoy bank'",
						office.getAddress(),
						BankAtm.Status.WORKING,
						office.getBank(),
						office,
						bankOfficeService.getAllEmployeesByOfficeId(office.getId())
								.getFirst(),
						true,
						true,
						0,
						17));
			}
		}

		for (Bank bank: bankList) {
			System.out.println(bank.toString());
		}

		System.out.print('\n');

		for (BankOffice office: officeList) {
			System.out.println(office.toString());
		}
	}
}
