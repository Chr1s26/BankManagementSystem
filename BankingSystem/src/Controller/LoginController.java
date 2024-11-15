package Controller;

import javax.swing.JOptionPane;

import Exception.IncorrectEmailException;
import Exception.IncorrectPasswordException;
import Exception.IncorrectUserNameException;
import Service.AuthenticationService;
import View.LoginWindow;
import View.BranchListingPage;

public class LoginController extends BaseController {
	
	private LoginWindow view;
	
	public LoginController() {
		super(new LoginWindow());
		this.initController();
	}
	
	public void handleEmployeeLogin() {
		this.view.getLoginButton().addActionListener(e -> loginBtnAction());
	}

	private void loginBtnAction()  {
		String email = this.view.getEmailField().getText();
		String password = new String(this.view.getPasswordField().getPassword());
		try {
			AuthenticationService.login(email, password);
			new BranchListingController();
			this.view.dispose();
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

	@Override
	public void initController() {
		this.view =(LoginWindow) this.getView();
		this.view.setVisible(true);
		handleEmployeeLogin();
	}
	
}
