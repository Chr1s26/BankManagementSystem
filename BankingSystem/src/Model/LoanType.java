package Model;

public enum LoanType {
	
	Personal_Loan(1),
	Mortgage_Loan(2),
	Car_Loan(3);
	
	private final int value;
	
	LoanType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static LoanType fromValue(int value) {
		for(LoanType type : LoanType.values()) {
			if(type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException();                
	}
}


