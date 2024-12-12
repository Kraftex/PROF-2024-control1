package es.upm.grise.prof.curso2024.control1;

public class Transaction {
	
	String concept;
	float amount;
	
	public Transaction(String concept, float amount) {
		
		this.concept = concept;
		this.amount = amount;
		
	}
	
	
	
	public float getAmount() {
		return amount;
	}
	
}
