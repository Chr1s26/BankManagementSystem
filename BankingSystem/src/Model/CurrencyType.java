package Model;

public enum CurrencyType {
	
	USD(1),
	CAD(2),
	KYAT(3),
	AUD(4);
	
	private final int value;
	
	CurrencyType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static CurrencyType fromValue(int value) {
		for(CurrencyType type : CurrencyType.values()) {
			if(type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException();                
	}
}
