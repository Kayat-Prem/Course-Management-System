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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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

public class publishResult extends JFrame {
	JButton btnNewButton;
	private JPanel contentPane;
	private JTextField address;
	private JTextField textField;
	
	private StudentDashboard mstudent;
	private JTextField grade;
	private JTextField remarks;
	private JTextField studentid;
	private JTextField name;
	private JTextField sn;
	private JTextField search;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					publishResult frame = new publishResult();
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
	
	public publishResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1282, 851);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	

		try {
	
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
			Statement statement = connection.createStatement();
			String selectQuery = "SELECT * FROM `Marks`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
			
			String[][] data = null;
			try {
			      rs.last();
			      int rowCount = rs.getRow();
			      rs.beforeFirst();
			      data = new String[rowCount][7];
			      int i = 0;
			      while (rs.next()) {
			    	data[i][0] = Integer.toString(rs.getInt("SN"));
			        data[i][1] = rs.getString("Name");
			        data[i][2] = Integer.toString(rs.getInt("Student Id"));
			        data[i][3] = rs.getString("Obtained Marks");
			        data[i][4] = rs.getString("Course");
			        data[i][5] = rs.getString("Module");
			        data[i][6] =Integer.toString(rs.getInt("Year"));
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
			String[] columnNames = {"SN", "Name", "Student Id", "Obtained Marks", "Course", "Module", "Year"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
		    
		    // Table Created
		    JTable table = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBackground(new Color(192, 192, 192));
			scrollPane.setBounds(40, 141, 1209, 339);
			contentPane.add(scrollPane);
			table.setBackground(new Color(192, 192, 192));
			
				
			try {
				
				Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
				Statement statement1 = connection1.createStatement();
				String selectQuery1 = "SELECT * FROM `Publish_Result`";
				
				ResultSet rs1 = statement1.executeQuery(selectQuery1);
				
				
				String[][] data1 = null;
	
			try {
			      rs1.last();
			      int rowCount = rs1.getRow();
			      rs1.beforeFirst();
			      data1 = new String[rowCount][5];
			      int i = 0;
			      while (rs1.next()) {
			        data1[i][0] = Integer.toString(rs1.getInt("SN"));
			        data1[i][1] = rs1.getString("Name");
			        data1[i][2] = Integer.toString(rs1.getInt("Student Id"));
			        data1[i][3] = rs1.getString("Grade");
			        data1[i][4] = rs1.getString("Remarks");
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
		String[] columnNames1 = {"SN", "Name", "Student Id", "Grade", "Remarks"};
		DefaultTableModel model1 = new DefaultTableModel(data1, columnNames1);
		// Table Created
	    JTable table1 = new JTable(model1);
		
		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBackground(new Color(192, 192, 192));
		scrollPane1.setBounds(40, 477, 1209, 88);
		contentPane.add(scrollPane1);
		table1.setBackground(new Color(192, 192, 192));
		// Reload the JTable to reflect the updated data
		model1.fireTableDataChanged();
		
			
			JButton btnNewButton = new JButton("PUBLISH");
			btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton.setBounds(953, 656, 157, 43);
			contentPane.add(btnNewButton);
			getContentPane().add(btnNewButton, BorderLayout.CENTER);
			btnNewButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "Do you want to Publish The Result?", "PUBLISH REPORT", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
//						System.exit(0);
					    // User clicked Yes, handle the ...
					} else {
					    // User clicked No, do nothing or handle accordingly
					}
					
		                Connection con=null;
	        		try {
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
	        		try {
	        			String insertQuery = "INSERT INTO `Publish_Result`(`SN`, `Name`, `Student Id`, `Grade`, `Remarks`) VALUES (?,?,?,?,?)";
	        		     
	        		      try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertQuery)) {
	        		      
	        		    	preparedStatement.setInt(1,Integer.parseInt(sn.getText()));
	        		        preparedStatement.setString(2, name.getText());
	        		        preparedStatement.setInt(3,Integer.parseInt(studentid.getText()));
	        		    	preparedStatement.setString(4, grade.getText());
	        		        preparedStatement.setString(5, remarks.getText());
	        		        
	        		        preparedStatement.executeUpdate();

	        		      
	        		      } catch (SQLException e1) {
	        			
	        			e1.printStackTrace();
	        		}
	        		}catch(Exception e3) {
	        			e3.printStackTrace();
	        		}
				}});
	      
			
			JButton btnNewButton_2 = new JButton("EXIT");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2.setForeground(new Color(0, 0, 255));
			btnNewButton_2.setBounds(586, 720, 117, 33);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Publish Result");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(586, 6, 244, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO ADMIN DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(6, 6, 445, 33);
			contentPane.add(btnNewButton_2_1);
			
			grade = new JTextField();
			grade.setBounds(782, 601, 130, 43);
			contentPane.add(grade);
			grade.setColumns(10);
			
			remarks = new JTextField();
			remarks.setColumns(10);
			remarks.setBounds(943, 601, 306, 43);
			contentPane.add(remarks);
			
			JLabel lblNewLabel_1 = new JLabel("Total Grade");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblNewLabel_1.setForeground(new Color(0, 255, 0));
			lblNewLabel_1.setBounds(782, 577, 124, 25);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Remarks");
			lblNewLabel_1_1.setForeground(Color.GREEN);
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblNewLabel_1_1.setBounds(1036, 577, 124, 25);
			contentPane.add(lblNewLabel_1_1);
			
			studentid = new JTextField();
			studentid.setColumns(10);
			studentid.setBounds(603, 601, 157, 43);
			contentPane.add(studentid);
			
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(262, 601, 314, 43);
			contentPane.add(name);
			
			sn = new JTextField();
			sn.setColumns(10);
			sn.setBounds(76, 601, 157, 43);
			contentPane.add(sn);
			
			JLabel lblNewLabel_1_2 = new JLabel("SN");
			lblNewLabel_1_2.setForeground(Color.GREEN);
			lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblNewLabel_1_2.setBounds(95, 577, 124, 25);
			contentPane.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Student Name");
			lblNewLabel_1_3.setForeground(Color.GREEN);
			lblNewLabel_1_3.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblNewLabel_1_3.setBounds(356, 577, 143, 25);
			contentPane.add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_1_4 = new JLabel("Student Id");
			lblNewLabel_1_4.setForeground(Color.GREEN);
			lblNewLabel_1_4.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblNewLabel_1_4.setBounds(620, 577, 124, 25);
			contentPane.add(lblNewLabel_1_4);
			
			search = new JTextField();
			search.setBounds(143, 662, 228, 33);
			contentPane.add(search);
			search.setColumns(10);
			
			JButton delete = new JButton("DELETE");
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nam=search.getText();
					try (Connection conn = DriverManager.getConnection(
	                        "jdbc:mysql://localhost:3306/CMS", "root", "")) {
						String insertQuery ="delete from Marks where Name='"+nam+"'";
						
	      		         try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {
	      		              preparedStatement.executeUpdate();
	                     }catch(Exception e1) {
					          e1.printStackTrace();
				         }	
	 				try (Connection con = DriverManager.getConnection(
		                   "jdbc:mysql://localhost:3306/CMS", "root", "")) {
	      		             String insertQuery1 ="delete from Publish_Result where Name='"+nam+"'";
	      		             try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertQuery1)) {
	      		                  preparedStatement.executeUpdate();
							  } catch (SQLException e2) {
							         e2.printStackTrace();
						       }
			        } catch (SQLException e3) {
				         e3.printStackTrace();
			        }
					} catch (SQLException e3) {
				         e3.printStackTrace();
			        }
			}});
				
			
			delete.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			delete.setBounds(381, 656, 157, 43);
			contentPane.add(delete);
			
			JLabel lblNewLabel_2 = new JLabel("Search Student to Delete from list");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_2.setForeground(new Color(0, 255, 0));
			lblNewLabel_2.setBounds(139, 642, 244, 19);
			contentPane.add(lblNewLabel_2);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AdminDashboard adddd= new AdminDashboard();
					dispose();
					adddd.setVisible(true);
				}
			});
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	
		
	
	public void addActionListener1() {
		btnNewButton.addActionListener((ActionListener) this);
    }
}

