package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import utils.DBConnection;

public class View extends JFrame implements ActionListener {
	
	private JFrame jframe;
	private JTextField ssn = new JTextField();
	private JTextField bDate = new JTextField();
	private JTextField name = new JTextField();
	private JTextField address = new JTextField();
	private JTextField salary = new JTextField();
	private JTextField sex = new JTextField();
	
	private JButton add = new JButton("Add");
	private JButton delete = new JButton("Delete");
	private JButton next = new JButton("Next");
	private JButton previous = new JButton("Previous");
	private JButton clear = new JButton("Clear");
	private JButton update = new JButton("Update");
	
	private JLabel ssnLabel = new JLabel("SSn");
	private JLabel bDateLabel = new JLabel("DOB");
	private JLabel nameLabel = new JLabel("Name");
	private JLabel addressLabel = new JLabel("Address");
	private JLabel salaryLabel = new JLabel("Salary");
	private JLabel sexLabel = new JLabel("Gender");
	private JLabel detailsLabel = new JLabel("Employee Details");
	
	
	private DBConnection conn = new DBConnection();
	private ResultSet rs;
	
	public View() {
		//initialize frame
		JFrame jframe = new JFrame();
		jframe.setBounds(100,100,600,313);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.getContentPane().setLayout(null);
		
		//set position of text fields and add them to frame
		sex.setBounds(126, 185, 288, 20);
		sex.setColumns(10);
		jframe.getContentPane().add(sex);
		
		salary.setBounds(126, 160, 288, 20);
		salary.setColumns(10);
		jframe.getContentPane().add(salary);
		
		ssn.setBounds(126, 60, 288, 20);
		ssn.setColumns(10);
		jframe.getContentPane().add(ssn);
		
		bDate.setBounds(126, 85, 288, 20);
		bDate.setColumns(10);
		jframe.getContentPane().add(bDate);
		
		name.setBounds(126, 110, 288, 20);
		name.setColumns(10);
		jframe.getContentPane().add(name);
		
		address.setBounds(126, 135, 288, 20);
		address.setColumns(10);
		jframe.getContentPane().add(address);
		
		//set position of each label and add them to frame
		detailsLabel.setBounds(241, 11, 81, 14);
		jframe.getContentPane().add(detailsLabel);
		
		ssnLabel.setBounds(70, 63, 71, 14);
		jframe.getContentPane().add(ssnLabel);
		
		bDateLabel.setBounds(70, 88, 46, 14);
		jframe.getContentPane().add(bDateLabel);
		
		nameLabel.setBounds(70, 113, 46, 14);
		jframe.getContentPane().add(nameLabel);
		
		addressLabel.setBounds(70, 138, 46, 14);
		jframe.getContentPane().add(addressLabel);
		
		salaryLabel.setBounds(70, 163, 46, 14);
		jframe.getContentPane().add(salaryLabel);
		
		sexLabel.setBounds(70, 188, 46, 14);
		jframe.getContentPane().add(sexLabel);
		
		//set position of each button and add them to frame
		add.setBounds(463, 59, 89, 23);
		jframe.getContentPane().add(add);
		
		update.setBounds(463, 109, 89, 23);
		jframe.getContentPane().add(update);
		
		delete.setBounds(463, 159, 89, 23);
		jframe.getContentPane().add(delete);
		
		previous.setBounds(126, 231, 89, 23);
		jframe.getContentPane().add(previous);
		
		next.setBounds(325, 231, 89, 23);
		jframe.getContentPane().add(next);
		
		clear.setBounds(463, 208, 89, 23);
		jframe.getContentPane().add(clear);
		
		//add action listeners
		add.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		next.addActionListener(this);
		previous.addActionListener(this);
		clear.addActionListener(this);
		
		jframe.setVisible(true);
		//get ResultSet from DB
		searchDB();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		switch(action) {
		case "Next":
			getNext();
			break;
		case "Previous":
			getPrevious();
			break;
		case "Add":
			add();
			break;
		case "Update":
			update();
			break;
		case "Clear":
			clear();
			break;
		case "Delete":
			delete();
			break;
		}
	}

	/*
	 *Fetches records from the DB and populates the TextFields
	 */
	private void searchDB() {
		rs = conn.getResult();
		try {
			if(rs.next()) {
				populateFields(rs.getInt("SSN"),rs.getString("Bdate"),rs.getString("Name"),rs.getString("Address"),
						rs.getInt("Salary"),rs.getString("Sex").charAt(0));
			}
		} catch (SQLException e) {
			System.out.println("Exception occured in method 'searchDB' in class 'View'");
			e.printStackTrace();
		}
	}
	
	/*
	 * Helper method to set text fields
	 */
	private void populateFields(int ssn, String bDate, String name, String address, int salary, char sex) {
		this.ssn.setText(Integer.toString(ssn));
		this.bDate.setText(bDate);
		this.name.setText(name);
		this.address.setText(address);
		this.salary.setText(Integer.toString(salary));
		this.sex.setText(String.valueOf(sex));
	}
	
	/*
	 * Gets next item in the ResultSet
	 */
	private void getNext() {
		try {
			if (rs.next()) {
				populateFields(rs.getInt("SSN"),rs.getString("Bdate"),rs.getString("Name"),rs.getString("Address"),
						rs.getInt("Salary"),rs.getString("Sex").charAt(0));
			}
		} catch (SQLException e) {
			System.out.println("Exception occured in method 'getNext' in class 'View'");
			e.printStackTrace();
		}
	}
	
	/*
	 * Gets previous item in the ResultSet
	 */
	private void getPrevious() {
		try {
			if (rs.previous()) {
				populateFields(rs.getInt("SSN"),rs.getString("Bdate"),rs.getString("Name"),rs.getString("Address"),
						rs.getInt("Salary"),rs.getString("Sex").charAt(0));
			}
		} catch (SQLException e) {
			System.out.println("Exception occured in method 'getNext' in class 'View'");
			e.printStackTrace();
		}
	}
	
	/*
	 * Updates a record after checking primary keys are equal
	 */
	private void update() {
		try {
			if (ssn.getText().toLowerCase().equals(rs.getString("SSN").toLowerCase())) {
				rs.updateInt("SSN", Integer.parseInt(ssn.getText()));
				rs.updateString("Bdate", bDate.getText());
				rs.updateString("Name", name.getText());
				rs.updateString("Address", address.getText());
				rs.updateInt("Salary", Integer.parseInt(salary.getText()));
				rs.updateString("Sex", sex.getText());
				rs.updateRow();
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred in method 'update' in class 'View'");
			e.printStackTrace();
		}
	}
	
	/*
	 * Deletes current record and refreshes ResultSet
	 */
	private void  delete() {
		try {
			rs.deleteRow();
			searchDB();
		} catch (SQLException e) {
			System.out.println("Exception occurred in method 'delete' in class 'View'");
			e.printStackTrace();
		}
	}
	
	/*
	 * Insert a new entry
	 */
	private void add() {
		try {
			if (!ssn.getText().toLowerCase().equals(rs.getString("SSN").toLowerCase())) {
				rs.moveToInsertRow();
				rs.updateInt("SSN", Integer.parseInt(ssn.getText()));
				rs.updateString("Bdate", bDate.getText());
				rs.updateString("Name", name.getText());
				rs.updateString("Address", address.getText());
				rs.updateInt("Salary", Integer.parseInt(salary.getText()));
				rs.updateString("Sex", sex.getText());
				rs.insertRow();
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred in method 'add' in class 'View'");
			System.out.println("Cannot add new user because primary key 'SSn' already exists");
			e.printStackTrace();
		}
	}
	
	/*
	 * clear text fields
	 */
	private void clear() {
		try {
			rs.beforeFirst();
			ssn.setText("");
			bDate.setText("");
			name.setText("");
			address.setText("");
			salary.setText("");
			sex.setText("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
