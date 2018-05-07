package telran.controller;

import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.dto.ConvertCurrencyData;
import telran.model.Currency;

@SpringBootApplication
@RestController
public class ServerCurrncyTestAppl {
	Currency currency = new Currency();

	@RequestMapping(value = "currencies")
	Set<String> GetAllCurrencyCode() {
		return currency.getCurrencyCode();
	}

	@RequestMapping(value = "date")
	String getLastDate() {
		return currency.getData();
	}

	@PostMapping(value = "convert")
	double resultConverCurrency(@RequestBody ConvertCurrencyData conv) {
		return currency.converCurrency(conv.currencyFrom, conv.currencyTo, conv.date, conv.amount);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerCurrncyTestAppl.class, args);

	}

}
