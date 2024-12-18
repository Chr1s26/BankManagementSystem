package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Dao.CardDaoImpl;
import Model.Account;
import Model.Card;
import Model.CurrencyType;

public class CardTransferMoneyWindow extends BaseWindow {
	
	 	private JLabel sourceCardLabel;
	    private JComboBox<Card> sourceCardTextField;
	    private JLabel targetCardLabel;
	    private JComboBox<Card> targetCardField;
	    private JLabel amountLabel;
	    private JTextField amountField;
	    private JLabel descLabel;
	    private JTextField descField;
	    private JLabel currencyLabel;
	    private JComboBox<CurrencyType> currencyField;
	    private JButton transferButton;
	    private JButton cancelButton;
	    private CardDaoImpl cardDao;

		public CardTransferMoneyWindow() {
			
			this.cardDao = new CardDaoImpl();
	        
	        setTitle("Transfer Money");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new GridBagLayout()); 

	       
	        sourceCardLabel = new JLabel("Source Card Number:");
	        sourceCardTextField = new JComboBox<>(cardDao.getAll().toArray(new Card[0]));

	        targetCardLabel = new JLabel("Target Card Number:");
	        targetCardField = new JComboBox<>(cardDao.getAll().toArray(new Card[0]));

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
	        add(sourceCardLabel, gbc);

	        gbc.gridx = 1;
	        add(sourceCardTextField, gbc);

	        
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        add(targetCardLabel, gbc);

	        gbc.gridx = 1;
	        add(targetCardField, gbc);

	       
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

		public JLabel getSourceCardLabel() {
			return sourceCardLabel;
		}

		public void setSourceCardLabel(JLabel sourceCardLabel) {
			this.sourceCardLabel = sourceCardLabel;
		}

		public Card getSourceCard() {
			Card card = (Card)this.sourceCardTextField.getSelectedItem();
			return card;
		}

		public void setSourceCardTextField(JComboBox<Card> sourceCardTextField) {
			this.sourceCardTextField = sourceCardTextField;
		}

		public JLabel getTargetCardLabel() {
			return targetCardLabel;
		}

		public void setTargetCardLabel(JLabel targetCardLabel) {
			this.targetCardLabel = targetCardLabel;
		}

		public Card getTargetCard() {
			Card card = (Card)this.targetCardField.getSelectedItem();
			return card;
		}

		public void setTargetCardField(JComboBox<Card> targetCardField) {
			this.targetCardField = targetCardField;
		}

		public JLabel getAmountLabel() {
			return amountLabel;
		}

		public void setAmountLabel(JLabel amountLabel) {
			this.amountLabel = amountLabel;
		}

		public JTextField getAmountField() {
			return amountField;
		}

		public void setAmountField(JTextField amountField) {
			this.amountField = amountField;
		}

		public JLabel getDescLabel() {
			return descLabel;
		}

		public void setDescLabel(JLabel descLabel) {
			this.descLabel = descLabel;
		}

		public JTextField getDescField() {
			return descField;
		}

		public void setDescField(JTextField descField) {
			this.descField = descField;
		}

		public JLabel getCurrencyLabel() {
			return currencyLabel;
		}

		public void setCurrencyLabel(JLabel currencyLabel) {
			this.currencyLabel = currencyLabel;
		}

		public JComboBox<CurrencyType> getCurrencyField() {
			return currencyField;
		}
		
		public CurrencyType getCurrencyType() {
			return (CurrencyType)this.currencyField.getSelectedItem();
		}

		public void setCurrencyField(JComboBox<CurrencyType> currencyField) {
			this.currencyField = currencyField;
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
