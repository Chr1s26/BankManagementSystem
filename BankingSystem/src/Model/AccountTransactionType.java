package Model;

public enum AccountTransactionType {
	
	PENDING(1),
	COMPLETED(2),
	FAILED(3);
	
	private final int value;
	
	AccountTransactionType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static AccountTransactionType fromValue(int value) {
		for(AccountTransactionType type : AccountTransactionType.values()) {
			if(type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException();                
	}
}