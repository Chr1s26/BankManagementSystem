package View;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.AccountDaoImpl;
import Model.Account;
import Model.CurrencyType;

public class TransferMoneyWindow extends BaseWindow{
	
    private JLabel sourceAccLabel;
    private JComboBox<Account> sourceAccTextField;
    private JLabel targetAccLabel;
    private JComboBox<Account> targetAccField;
    private JLabel amountLabel;
    private JTextField amountField;
    private JLabel descLabel;
    private JTextField descField;
    private JLabel currencyLabel;
    private JComboBox<CurrencyType> currencyField;
    private JButton transferButton;
    private JButton cancelButton;
    private AccountDaoImpl accountDao;

	public TransferMoneyWindow() {
		
		this.accountDao = new AccountDaoImpl();
        
        setTitle("Transfer Money");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); 

       
        sourceAccLabel = new JLabel("Source Account:");
        sourceAccTextField = new JComboBox<>(accountDao.getAll().toArray(new Account[0]));

        targetAccLabel = new JLabel("Target Account:");
        targetAccField = new JComboBox<>(accountDao.getAll().toArray(new Account[0]));

        amountLabel = new JLabel("Amount:");
        amountField = new JTextField(15);

        descLabel = new JLabel("Description:");
        descField = new JTextField(15);
        
        currencyLabel = new JLabel("Currency");
        currencyField = new JComboBox<>(CurrencyType.values());

        transferButton = new JButton("Transfer");
        cancelButton = new JButton("Cancel");

        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.fill = GridBagConstraints.HORIZONTAL;

      
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(sourceAccLabel, gbc);

        gbc.gridx = 1;
        add(sourceAccTextField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(targetAccLabel, gbc);

        gbc.gridx = 1;
        add(targetAccField, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(amountLabel, gbc);

        gbc.gridx = 1;
        add(amountField, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(descLabel, gbc);

        gbc.gridx = 1;
        add(descField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(currencyLabel, gbc);

        gbc.gridx = 1;
        add(currencyField, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1; 
        add(transferButton, gbc);

        gbc.gridx = 1;
        add(cancelButton, gbc);

  
    }
	
	public CurrencyType getCurrencyType() {
		return (CurrencyType)this.currencyField.getSelectedItem();
	}
	
	public Account getSourceAccount() {
		Account account = (Account) this.sourceAccTextField.getSelectedItem();
		return account;
	}

	public void setSourceAccTextField(JComboBox<Account> sourceAccTextField) {
		this.sourceAccTextField = sourceAccTextField;
	}
	
	public Account getTargetAccount() {
		Account account = (Account) this.targetAccField.getSelectedItem();
		return account;
	}

	public void setTargetAccField(JComboBox<Account> targetAccField) {
		this.targetAccField = targetAccField;
	}

	public JTextField getAmountField() {
		return amountField;
	}

	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}

	public JTextField getDescField() {
		return descField;
	}

	public void setDescField(JTextField descField) {
		this.descField = descField;
	}

	public JButton getTransferButton() {
		return transferButton;
	}

	public void setTransferButton(JButton transferButton) {
		this.transferButton = transferButton;
	}


	public JButton getCancelButton() {
		return cancelButton;
	}


	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

}
