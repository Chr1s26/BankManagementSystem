package Controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Exception.InvalidTokenException;
import Model.Employee;
import Service.AuthenticationService;

public abstract class BaseController {
	
	public Employee currentUser;
	private JFrame view;
	
	public abstract void initController();
	
	public BaseController(JFrame view) {
		this.view = view;
	}
	
	public JFrame getView() {
		return this.view;
	}
	
	public void authenticate() {
		try {
			this.currentUser = AuthenticationService.authenticate();
			this.initController();
			this.view.setVisible(true);
			
		}catch(InvalidTokenException e){
			JOptionPane.showMessageDialog(this.view, e.getMessage());
			this.view.dispose();
			new LoginController();
		}
	}
	
}
