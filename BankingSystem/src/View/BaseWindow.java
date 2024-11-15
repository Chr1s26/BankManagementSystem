package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Exception.InvalidTokenException;

public class BaseWindow extends JFrame {
	
	private String title;
	private String[][] tableData;
	private String[] columns;
	private JTable dataTableTemplate;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	
	public BaseWindow() {
		initializeBaseFrame();
	}
	
	private void initializeBaseFrame() {
		this.setLayout(new BorderLayout());
		this.setLocation(200,300);
		this.setSize(453,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createDataTable(String[][] data,String[] column) {
		this.tableData = data;
		this.columns = column;
		this.tableModel = new DefaultTableModel(null,columns);
		this.dataTableTemplate = new JTable(this.tableModel);
		this.scrollPane = new JScrollPane(this.dataTableTemplate);
		this.add(this.scrollPane,BorderLayout.CENTER);
		loadDataTable();
	}
	
	public void refreshDataTable(String[][] updatedData) {
		this.tableData = updatedData;
		this.tableModel.setRowCount(0);
		loadDataTable();
	}
	
	public void loadDataTable() {
		for(String[] dataArr : this.tableData) {
			this.tableModel.addRow(dataArr);
		}
	}
	
	public JTable getDataTableTemplate() {
		return dataTableTemplate;
	}
	
	public void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	public void showSuccessMessage(String string) {
		JOptionPane.showMessageDialog(this, string);
	}

}
