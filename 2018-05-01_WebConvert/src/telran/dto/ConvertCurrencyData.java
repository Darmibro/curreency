package telran.dto;

public class ConvertCurrencyData {
public String currencyFrom;
public String currencyTo;
public String date;
public int amount;

public ConvertCurrencyData() {
}

public ConvertCurrencyData(String currencyFrom, String currencyTo, String date, int amount) {
	this.currencyFrom = currencyFrom;
	this.currencyTo = currencyTo;
	this.date = date;
	this.amount = amount;
}
public String getCurrencyFrom() {
	return currencyFrom;
}
public String getCurrencyTo() {
	return currencyTo;
}
public String getDate() {
	return date;
}
public int getAmount() {
	return amount;
}

}
