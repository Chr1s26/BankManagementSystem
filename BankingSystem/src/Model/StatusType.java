package Model;

public enum StatusType {
	
	COMPLETE(1),
	PENDING(2),
	FAILED(3);
	
	private final int value;
	
	StatusType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static StatusType fromValue(int value) {
		for(StatusType type : StatusType.values()) {
			if(type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException();                
	}
	
}
