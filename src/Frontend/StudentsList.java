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

public class StudentsList extends JFrame {
	JButton btnNewButton;
    JComboBox<String> courses;
    JComboBox<Integer> semester;
    JComboBox<Integer> year;
	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField search;
	private JTextField gender;
	private JTextField number;
	private JTextField password;
	private JTextField mailid;
	private JTextField studentid;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsList frame = new StudentsList();
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
	
	public StudentsList() {
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
			String selectQuery = "SELECT * FROM `StudentList`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
			
			String[][] data = null;
			try {
			      rs.last();
			      int rowCount = rs.getRow();
			      rs.beforeFirst();
			      data = new String[rowCount][9];
			      int i = 0;
			      while (rs.next()) {
			        data[i][0] = rs.getString("Name");
			        data[i][1] = Integer.toString(rs.getInt("Student Id"));
			        data[i][2] = rs.getString("Number");
			        data[i][3] = rs.getString("Mail Id");
			        data[i][4] = rs.getString("Password");
			        data[i][5] = rs.getString("Gender");
			        data[i][6] = rs.getString("Course");
			        data[i][7] =Integer.toString(rs.getInt("Semester"));
			        data[i][8]=Integer.toString(rs.getInt("Year"));
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
			String[] columnNames = {"Name", "Student Id", "Number", "Mail Id", "Password", "Gender", "Course", "Semester","Year"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
		    
		    // Table Created
		    JTable table = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBackground(new Color(192, 192, 192));
			scrollPane.setBounds(386, 133, 876, 357);
			contentPane.add(scrollPane);

		
			table.setBackground(new Color(192, 192, 192));
	
			
			JButton btnNewButton = new JButton("ADD");
			btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton.setBounds(125, 590, 169, 43);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "Do you want to Add New Student?", "Add Student", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
//						System.exit(0);
					    // User clicked Yes, handle the logout
					} else {
					    // User clicked No, do nothing or handle accordingly
					}
//		            if(textField == null) {
//						JOptionPane.showMessageDialog(btnNewButton, "Please!!! Filled all the TextBox", "Inane error", JOptionPane.ERROR_MESSAGE);
//		            }
//		            else {
//					    JOptionPane.showMessageDialog(btnNewButton, "Successfully Register a new Student");
//		            }  
					
		                Connection con=null;
	        		try {
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
	        		try {
	        			String insertQuery = "INSERT INTO `StudentList`(`Name`, `Student Id`, `Number`, `Mail Id`, `Password`, `Gender`, `Course`, `Year`, `Semester`) VALUES (?,?,?,?,?,?,?,?,?)";
	        		     
	        		      try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertQuery)) {
	        		      
	        		        preparedStatement.setString(1, name.getText());
	        		        preparedStatement.setInt(2,Integer.parseInt(studentid.getText()));
	        		        preparedStatement.setString(3, number.getText());
	        		        preparedStatement.setString(4, mailid.getText());
	        		        preparedStatement.setString(5, password.getText());
	        		        preparedStatement.setString(6, gender.getText());
	        		        preparedStatement.setString(7, courses.getSelectedItem().toString());
	        		        preparedStatement.setInt(8, Integer.parseInt(year.getSelectedItem().toString()));
	        		        preparedStatement.setInt(9, Integer.parseInt(semester.getSelectedItem().toString()));
	        		        
	        		        
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
					int result = JOptionPane.showConfirmDialog(null, "Do you want to EXIT?", "EXIT", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						System.exit(0);
					    // User clicked Yes, handle the logout
					} else {
					    // User clicked No, do nothing or handle accordingly
					}
				}
			});
			btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2.setForeground(new Color(0, 0, 255));
			btnNewButton_2.setBounds(585, 667, 117, 33);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Students Detail");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(696, 18, 244, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO ADMIN DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(19, 18, 365, 33);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AdminDashboard adddd= new AdminDashboard();
					dispose();
					adddd.setVisible(true);
				}
			});
			
			
			search = new JTextField();
			search.setBounds(696, 549, 231, 33);
			contentPane.add(search);
			search.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Search Student to be Remove");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblNewLabel_1.setForeground(new Color(255, 255, 0));
			lblNewLabel_1.setBounds(696, 518, 231, 19);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton_1 = new JButton("DELETE");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "Do you want to Delete a Student?", "DELETE STUDENT", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
//						System.exit(0);
					    // User clicked Yes, handle the ...
					} else {
					    // User clicked No, do nothing or handle accordingly
					}
					String nam=search.getText();
					try (Connection conn = DriverManager.getConnection(
	                        "jdbc:mysql://localhost:3306/CMS", "root", "")) {
						String insertQuery ="delete from StudentList where Name='"+nam+"'";
	      		      
	      		      try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {
	      		        preparedStatement.executeUpdate();
	                
	               
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e2) {
				
				e2.printStackTrace();
			}}});
			
			btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton_1.setBounds(939, 542, 169, 43);
			contentPane.add(btnNewButton_1);
			
		
			
			JLabel lblNewLabel_3 = new JLabel("Courses");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3.setForeground(new Color(0, 255, 0));
			lblNewLabel_3.setBounds(19, 474, 79, 16);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_6 = new JLabel("Semester");
			lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_6.setForeground(new Color(0, 255, 0));
			lblNewLabel_6.setBounds(177, 517, 92, 33);
			contentPane.add(lblNewLabel_6);
			
			JLabel lblNewLabel_3_1 = new JLabel("Mail Id");
			lblNewLabel_3_1.setForeground(Color.GREEN);
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_1.setBounds(19, 310, 79, 16);
			contentPane.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_3_2 = new JLabel("Name");
			lblNewLabel_3_2.setForeground(Color.GREEN);
			lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_2.setBounds(19, 145, 79, 16);
			contentPane.add(lblNewLabel_3_2);
			
			gender = new JTextField();
			gender.setColumns(10);
			gender.setBounds(110, 410, 238, 40);
			contentPane.add(gender);
			
			number = new JTextField();
			number.setColumns(10);
			number.setBounds(110, 243, 238, 43);
			contentPane.add(number);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("Std Id");
			lblNewLabel_3_1_1.setForeground(Color.GREEN);
			lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_1_1.setBounds(19, 200, 79, 16);
			contentPane.add(lblNewLabel_3_1_1);
			
			password = new JTextField();
			password.setColumns(10);
			password.setBounds(110, 353, 238, 43);
			contentPane.add(password);
			
			mailid = new JTextField();
			mailid.setColumns(10);
			mailid.setBounds(110, 298, 238, 43);
			contentPane.add(mailid);
			

			studentid = new JTextField();
			studentid.setColumns(10);
			studentid.setBounds(110, 188, 238, 43);
			contentPane.add(studentid);
			
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(110, 133, 238, 43);
			contentPane.add(name);
			
			JLabel lblNewLabel_3_3 = new JLabel("Gender");
			lblNewLabel_3_3.setForeground(Color.GREEN);
			lblNewLabel_3_3.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_3.setBounds(19, 421, 79, 16);
			contentPane.add(lblNewLabel_3_3);
			
			JLabel lblNewLabel_3_4 = new JLabel("Password");
			lblNewLabel_3_4.setForeground(Color.GREEN);
			lblNewLabel_3_4.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_4.setBounds(19, 365, 79, 16);
			contentPane.add(lblNewLabel_3_4);
			
			JLabel lblNewLabel_3_5 = new JLabel("Number");
			lblNewLabel_3_5.setForeground(Color.GREEN);
			lblNewLabel_3_5.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_5.setBounds(19, 255, 79, 16);
			contentPane.add(lblNewLabel_3_5);
			
	        courses = new JComboBox<String>();
			courses.setForeground(new Color(0, 0, 255));
			courses.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			courses.setModel(new DefaultComboBoxModel(new String[] {"Select a Course", "BSc (Hons) in CS", "International Master in BA", "BBA", "BIBM"}));
			courses.setBounds(110, 462, 238, 33);
			contentPane.add(courses);
			
			JLabel yearr = new JLabel("Year");
			yearr.setForeground(Color.GREEN);
			yearr.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			yearr.setBounds(19, 517, 92, 33);
			contentPane.add(yearr);
			
			semester = new JComboBox<>();
			semester.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			semester.addItem(1);
			semester.addItem(2);
			semester.addItem(3);
			semester.addItem(4);
			semester.addItem(5);
			semester.addItem(6);
			semester.setForeground(Color.BLUE);
			semester.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			semester.setBounds(267, 519, 86, 33);
			contentPane.add(semester);
			
			year = new JComboBox<>();
			year.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			year.addItem(1);
			year.addItem(2);
			year.addItem(3);
			year.setForeground(Color.BLUE);
			year.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			year.setBounds(71, 519, 86, 33);
			contentPane.add(year);
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/CMS", "root", "")) {
					String insertQuery = "update `StudentList` set `Name`=?, `Student Id`=?, `Number`=?, `Mail Id`=?, `Password`=?, `Gender`=?, `Course`=?, `Year`=?, `Semester`=? where `Student Id`="+Integer.parseInt(studentid.getText());
      		     
      		      try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {
      		        
      		        preparedStatement.setString(1, name.getText());
      		        preparedStatement.setInt(2,Integer.parseInt(studentid.getText()));
      		        preparedStatement.setString(3, number.getText());
      		        preparedStatement.setString(4, mailid.getText());
      		        preparedStatement.setString(5, password.getText());
      		        preparedStatement.setString(6, gender.getText());
      		        preparedStatement.setString(7, courses.getSelectedItem().toString());
      		        preparedStatement.setInt(8, Integer.parseInt(year.getSelectedItem().toString()));
      		        preparedStatement.setInt(9, Integer.parseInt(semester.getSelectedItem().toString()));
      		        
      		       
      		        preparedStatement.executeUpdate();
                
             
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}}});
		btnNewButton_3.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
		btnNewButton_3.setBounds(441, 542, 169, 43);
		contentPane.add(btnNewButton_3);
		
	}

	public void addActionListener1() {
		btnNewButton.addActionListener((ActionListener) this);
    }
}
