package Frontend;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.mysql.cj.jdbc.PreparedStatement;


import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;

public class ViewReport extends JFrame {
  JButton searchButton;
  private JPanel contentPane;
  private JTextField searchName;
  private JTextField searchStudentId;
  private JTable table;
  private DefaultTableModel tableModel;

  /**
   * Launch the application.
   */

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ViewReport frame = new ViewReport();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
	
	/**
	 * Create the frame.
	 */
	
	public ViewReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1282, 851);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//			System.out.println(rs.toString());
			
			JButton btnNewButton_2 = new JButton("EXIT");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2.setForeground(new Color(0, 0, 255));
			btnNewButton_2.setBounds(585, 667, 117, 33);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Result Sheet");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(512, 18, 244, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO STUDENT DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(6, 6, 445, 33);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					StudentDashboard adddd= new StudentDashboard();
					dispose();
					adddd.setVisible(true);
				}
			});
			
			
			JButton searchButton;

			// Add search button and text fields to capture inputs for name and student id
			searchButton = new JButton("SEARCH");
			searchButton.setForeground(new Color(106, 90, 205));
			searchButton.setBounds(512, 126, 100, 33);
			contentPane.add(searchButton);

			searchName = new JTextField();
			searchName.setBounds(84, 126, 190, 31);
			contentPane.add(searchName);

			searchStudentId = new JTextField();
			searchStudentId.setBounds(301, 126, 169, 33);
			contentPane.add(searchStudentId);

			
			// Add action listener for search button to retrieve and display data based on name and student id inputs
			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String StudentId = searchStudentId.getText();
					String Name = searchName.getText();
					
//					// Clear the table
//					tableModel.setRowCount(0);

					try {
						// Connect to the database
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

						// Build the query
						String query = "SELECT * FROM Marks WHERE";
						boolean whereClauseAdded = false;
						if (!StudentId.isEmpty()) {
						    query += "`Student Id` = " + Integer.parseInt(searchStudentId.getText());
						    whereClauseAdded = true;
						}
						if (!Name.isEmpty()) {
						    if (whereClauseAdded) {
						        query += " AND";
						    }
						    query += " `Name` = '" + searchName.getText() + "'";
						    whereClauseAdded = true;
						}
						if (!whereClauseAdded) {
						    query = "SELECT * FROM Marks";
						}

						// Execute the query
						Statement statement = connection.createStatement();
						ResultSet rs = statement.executeQuery(query);

						// Populate the table with the results
						String[][] data = null;
						try {
						      rs.last();
						      int rowCount = rs.getRow();
						      rs.beforeFirst();
						      data = new String[rowCount][7];
						      int i = 0;
						      while (rs.next()) {
						    	data[i][0] = rs.getString("SN");
						        data[i][1] = rs.getString("Name");
						        data[i][2] = Integer.toString(rs.getInt("Student Id"));
						        data[i][3] = rs.getString("Obtained Marks");
						        data[i][4] = rs.getString("Course");
						        data[i][5] = rs.getString("Module");
						        data[i][6] = Integer.toString(rs.getInt("Year"));
						        i++;
						      }
						    } catch (SQLException e1) {
						      System.out.println(e1);
						    }
						String[] columnNames = {"SN", "Name", "Student Id", "Obtained Marks", "Course", "Module", "Year"};
						DefaultTableModel model = new DefaultTableModel(data, columnNames);
						
					    // Table Created
					    JTable table = new JTable(model);
						
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBackground(new Color(192, 192, 192));
						scrollPane.setBounds(40, 160, 1209, 339);
						contentPane.add(scrollPane);
						table.setBackground(new Color(192, 192, 192));

					
						try {
							Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
							Statement statement1 = connection1.createStatement();
							String selectQuery1 = "SELECT * FROM `Publish_Result`";
							
							boolean whereClauseAdded1 = false;
							if (!StudentId.isEmpty()) {
								selectQuery1 += "`Student Id` = " + Integer.parseInt(searchStudentId.getText());
							    whereClauseAdded1 = true;
							}
							if (!Name.isEmpty()) {
							    if (whereClauseAdded1) {
							    	selectQuery1 += " AND";
							    }
							    selectQuery1 += " `Name` = '" + searchName.getText() + "'";
							    whereClauseAdded1 = true;
							}
							if (!whereClauseAdded1) {
								selectQuery1 = "SELECT * FROM Publish_Result";
							}
							
							
							ResultSet rs1 = statement1.executeQuery(selectQuery1);
							String[][] data1 = null;
						try {
						      rs1.last();
						      int rowCount = rs1.getRow();
						      rs1.beforeFirst();
						      data1 = new String[rowCount][4];
						      int i = 0;
						      while (rs1.next()) {
						        data1[i][0] = rs1.getString("Name");
						        data1[i][1] = Integer.toString(rs1.getInt("Student Id"));
						        data1[i][2] = rs1.getString("Grade");
						        data1[i][3] = rs1.getString("Remarks");
						        i++;
						      }
						    } catch (SQLException e2) {
						      System.out.println(e2);
						    }
					String[] columnNames1 = {"Name", "Student Id", "Grade", "Remarks"};
					DefaultTableModel model1 = new DefaultTableModel(data1, columnNames1);
					// Table Created
				    JTable table1 = new JTable(model1);
					
					JScrollPane scrollPane1 = new JScrollPane(table1);
					scrollPane1.setBackground(new Color(192, 192, 192));
					scrollPane1.setBounds(40, 500, 1209, 71);
					contentPane.add(scrollPane1);
					table1.setBackground(new Color(192, 192, 192));
					
						

						// Close the connection
						connection1.close();
						}catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// Close the connection
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					
	
			}});   // search button actionListener and actionperformed

			
			JLabel lblNewLabel_3_2 = new JLabel("Name");
			lblNewLabel_3_2.setForeground(Color.GREEN);
			lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_2.setBounds(153, 98, 79, 16);
			contentPane.add(lblNewLabel_3_2);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("Std Id");
			lblNewLabel_3_1_1.setForeground(Color.GREEN);
			lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_1_1.setBounds(354, 98, 79, 16);
			contentPane.add(lblNewLabel_3_1_1);
		
	}

	public void addActionListener1() {
		searchButton.addActionListener((ActionListener) this);
    }
}
