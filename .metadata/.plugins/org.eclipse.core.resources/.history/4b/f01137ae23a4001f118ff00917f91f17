package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Dao.BranchDaoImpl;

public class BranchListingPage extends BaseWindow {
	
	private BranchDaoImpl branchDao;
	private String[] columns = {"id","name","address","phone number"};
	private JButton createButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JPanel panel;
	private String[][] branchData = new String[1][4];
	
	public BranchListingPage() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		branchDao = new BranchDaoImpl();
		
		this.createDataTable(branchData,this.columns);
		
		this.createButton = new JButton("Create");
		this.updateButton = new JButton("Update");
		this.deleteButton = new JButton("Delete");
		
		panel.add(createButton);
		panel.add(updateButton);
		panel.add(deleteButton);
		
		this.add(panel,BorderLayout.SOUTH);
		prepareBaseWindow();
	}

	
	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Branch Information");
		this.setSize(800,400);
	}

	public JButton getCreateButton() {
		return createButton;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}
}
