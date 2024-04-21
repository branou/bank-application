package dev.himbra.bankapplication;

import dev.himbra.bankapplication.entity.Account;
import dev.himbra.bankapplication.entity.AccountType;
import dev.himbra.bankapplication.entity.Client;
import dev.himbra.bankapplication.entity.Role;
import dev.himbra.bankapplication.repository.AccountRepository;
import dev.himbra.bankapplication.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class BankApplication {
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ClientRepository clientRepo, AccountRepository accountRepo){
		return args -> {
			List<Client> clients = clientRepo.findAll();
			if(clients.isEmpty()) {
				Client c1 = clientRepo.save(new Client(null, "brahim", "angmar", "himbra", passwordEncoder.encode("123"), "brahim@gmail.com", new ArrayList<>(), Role.ADMIN));
				Client c2 = clientRepo.save(new Client(null, "karim", "angmar", "karimo", passwordEncoder.encode("456"), "karim@gmail.com", new ArrayList<>(), Role.USER));
				Client c3 = clientRepo.save(new Client(null, "hamza", "angmar", "lganar", passwordEncoder.encode("123456"), "hamza@gmail.com", new ArrayList<>(), Role.USER));
				accountRepo.save(new Account(null, 1000, Math.random() * 100000, AccountType.CHECKING, c1));
				accountRepo.save(new Account(null, 10000, Math.random() * 100000, AccountType.SAVINGS, c1));
				accountRepo.save(new Account(null, 22000, Math.random() * 100000, AccountType.CHECKING, c2));
				accountRepo.save(new Account(null, 8000, Math.random() * 100000, AccountType.CHECKING, c3));
				accountRepo.save(new Account(null, 110000, Math.random() * 100000, AccountType.SAVINGS, c3));
			}
		};
	}

}
