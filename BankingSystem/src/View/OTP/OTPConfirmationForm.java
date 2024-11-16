package View.OTP;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import View.BaseWindow;

public class OTPConfirmationForm extends BaseWindow {
	
	private JPanel panel;
	private JLabel instructionLabel;
	private JLabel messageLabel ;
	private JTextField otpField;
	private JButton confirmButton;
	private JButton resentButton;
	
	public OTPConfirmationForm() {
		this.initializeComponent();
	}
	
	public void initializeComponent() {
		this.panel = new JPanel(new GridLayout(4,1));
		
		 this.instructionLabel = new JLabel("Enter the OTP sent to your email ;", JLabel.CENTER);
		 this.messageLabel = new JLabel("",JLabel.CENTER);
		
		 this.otpField = new JTextField();
		 this.confirmButton = new JButton("Confirm OTP");
		 this.resentButton = new JButton("Resent OTP");
		 
		 panel.add(instructionLabel);
		 panel.add(otpField);
		 panel.add(confirmButton);
		 panel.add(resentButton);
		 
		 this.add(panel,BorderLayout.CENTER);
		 this.add(messageLabel,BorderLayout.SOUTH);
		 this.setVisible(true);
		 
	}

	public JLabel getInstructionLabel() {
		return instructionLabel;
	}

	public void setInstructionLabel(JLabel instructionLabel) {
		this.instructionLabel = instructionLabel;
	}

	public JLabel getMessageLabel() {
		return messageLabel;
	}

	public void setMessageLabel(JLabel messageLabel) {
		this.messageLabel = messageLabel;
	}

	public JTextField getOtpField() {
		return otpField;
	}

	public void setOtpField(JTextField otpField) {
		this.otpField = otpField;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}

	public void setConfirmButton(JButton confirmButton) {
		this.confirmButton = confirmButton;
	}

	public JButton getResentButton() {
		return resentButton;
	}

	public void setResentButton(JButton resentButton) {
		this.resentButton = resentButton;
	}
}
