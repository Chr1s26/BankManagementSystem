package Model;

public enum AccountType {
	
	SAVING(1),
	LOAN(2),
	INVESTMENT(3);
	
	private final int value;
	
	AccountType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static AccountType fromValue(int value) {
		for(AccountType type : AccountType.values()) {
			if(type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException();                
	}
}
