package telran.model;

import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.dto.CurrencyData;

public class Currency {

	protected static final String LATEST = "latest";
	static protected String url = "http://api.fixer.io/";
	static protected RestTemplate restTemplate = new RestTemplate();
	static protected HttpHeaders headers = new HttpHeaders();
	static protected CurrencyData currencyData = getRates(LATEST);

	protected static CurrencyData getRates(String date) {
		ResponseEntity<CurrencyData> response = restTemplate.exchange(url + date, HttpMethod.GET,
				new HttpEntity<String>(headers), CurrencyData.class);
		CurrencyData rates = response.getBody();
		rates.rates.put("EUR", 1.0);
		return rates;
	}

	public Set<String> getCurrencyCode() {
		return currencyData.getRates().keySet();
	}

	public String getData() {
		return currencyData.getDate();
	}

	public double converCurrency(String currencyFrom, String currencyTo, String date, int amount) {
		if (date != null) {
			currencyData = getRates(date);
		}
		return currencyData.getRates().get(currencyTo) / currencyData.getRates().get(currencyFrom) * amount;
	}
}
