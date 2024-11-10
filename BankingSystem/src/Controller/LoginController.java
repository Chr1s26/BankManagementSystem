package Controller;

import javax.swing.JOptionPane;

import Exception.IncorrectEmailException;
import Exception.IncorrectPasswordException;
import Exception.IncorrectUserNameException;
import Service.AuthenticationService;
import View.LoginWindow;
import View.BranchListingPage;

public class LoginController {
	
	private LoginWindow view;
	
	public LoginController(LoginWindow view) {
		this.view = view;
		handleEmployeeLogin();
	}
	
	public void handleEmployeeLogin() {
		this.view.getLoginButton().addActionListener(e -> loginBtnAction());
	}

	private void loginBtnAction()  {
		String email = this.view.getEmailField().getText();
		String password = new String(this.view.getPasswordField().getPassword());
		try {
			AuthenticationService.login(email, password);
			BranchListingPage branchListingPage= new BranchListingPage();
		}	
		catch (IncorrectPasswordException e2) {
			JOptionPane.showMessageDialog(this.view, e2.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		catch (IncorrectEmailException e3) {
			JOptionPane.showMessageDialog(this.view, e3.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
