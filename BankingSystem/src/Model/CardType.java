package Model;

public enum CardType {
	
	Debit_Card(1),
	Credit_Card(2),
	Prepaid_Card(3),
	ATM_Card(4);
	
	private final int value;
	
	CardType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static CardType fromValue(int value) {
		for(CardType type : CardType.values()) {
			if(type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException();                
	}
}
