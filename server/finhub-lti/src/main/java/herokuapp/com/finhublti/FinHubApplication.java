package herokuapp.com.finhublti;

import herokuapp.com.finhublti.util.CardType;
import herokuapp.com.finhublti.util.PaymentCardGenerator;
import herokuapp.com.finhublti.util.PaymentCardGeneratorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class FinHubApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinHubApplication.class, args);
	}
}
