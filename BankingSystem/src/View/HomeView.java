package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HomeView extends BaseWindow {
	
	private JMenuBar homeMenu;
	
	private JMenu employeeMenu;
	private JMenuItem employeeListing;
	
	private JMenu branchMenu;
	private JMenuItem branchListing;
	
	private JMenu customerMenu;
	private JMenuItem customerListing;
	
	private JMenu accountMenu;
	private JMenuItem accountListing;
	
	private JMenu loanMenu;
	private JMenuItem loanListing;
	
	private JMenu transactionMenu;
	private JMenuItem transactionListing;
	
	private JMenu cardMenu;
	private JMenuItem cardListing;
	
	private JMenu cardTransactionMenu;
	private JMenuItem cardTransactionListing;
	
	public HomeView() {
		this.initializeComponent();
	}
	
	public void initializeComponent() {
		
		this.homeMenu = new JMenuBar();
		
		this.employeeMenu.add(employeeListing);
		this.customerMenu.add(customerListing);
		this.branchMenu.add(branchListing);
		this.accountMenu.add(accountListing);
		this.loanMenu.add(loanListing);
		this.cardMenu.add(cardListing);
		this.transactionMenu.add(transactionListing);
		this.cardTransactionMenu.add(cardTransactionMenu);
		
		this.homeMenu.add(employeeMenu);
		this.homeMenu.add(customerMenu);
		this.homeMenu.add(branchMenu);
		this.homeMenu.add(accountMenu);
		this.homeMenu.add(loanMenu);
		this.homeMenu.add(cardMenu);
		this.homeMenu.add(transactionMenu);
		this.homeMenu.add(cardTransactionMenu);
		
		this.setJMenuBar(homeMenu);
	}
	
	public void addActionOnEmployeeMenu() {
		this.employeeListing.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
	}

	
}
