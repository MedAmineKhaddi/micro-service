package ma.Atelier.bank_account_service;

import ma.Atelier.bank_account_service.entities.BankAccount;
import ma.Atelier.bank_account_service.enums.AccountType;
import ma.Atelier.bank_account_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository BankAccountRepository)
	{
		return args -> {
				for(int i = 0 ; i<10 ; i++)
				{
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.accounttype(Math.random()>0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
							.balance(10000+Math.random()*90000)
							.creatdate(new Date())
							.currency("MAD")
							.build();

					BankAccountRepository.save(bankAccount);

				}
		};
	}

}
