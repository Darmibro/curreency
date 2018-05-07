package telran.dto;

import java.util.HashMap;


public class CurrencyData {
public String date;
public HashMap<String, Double> rates;


public HashMap<String, Double> getRates() {
	return rates;
}

public String getDate() {
	return date;
}

}
