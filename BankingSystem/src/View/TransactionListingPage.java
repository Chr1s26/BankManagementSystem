package View;

import javax.swing.JFrame;


public class TransactionListingPage extends BaseWindow {
	
	private String[] columns = {"Id","Transaction Type","Created at","To Account"," Amount","Note"};
	
	public TransactionListingPage() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		prepareBaseWindow();
	}
	
	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Account Information");
		this.setSize(1000,400);
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}
}
