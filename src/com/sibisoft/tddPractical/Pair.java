package com.sibisoft.tddPractical;

public class Pair {
	// class representing pair of currencies;
 private String fromCurrency;
 private String toCurrency;
 
 public Pair(String fromCurrency , String toCurrency){
	 this.fromCurrency = fromCurrency;
	 this.toCurrency = toCurrency;
 }
 public String getFromCurrency() {
		return fromCurrency;
 }

 public void setFromCurrency(String fromCurrency) {
 	this.fromCurrency = fromCurrency;
 }

 public String getToCurrency() {
 	return toCurrency;
 }

 public void setToCurrency(String toCurrency) {
 	this.toCurrency = toCurrency;
 }
 public boolean equals(Object obj){
	 Pair pair = (Pair) obj;
	 return this.getFromCurrency().equals(pair.getFromCurrency()) && this.getToCurrency().equals(pair.getToCurrency());
 }
 
 public int hashCode(){
	 return 0;
 }
 
}
