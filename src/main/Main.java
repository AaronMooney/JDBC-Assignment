package main;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.View;
import utils.DBConnection;

public class Main {

	public static void main(String[] args) {
		View view = new View();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
