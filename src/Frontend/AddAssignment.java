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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;

public class AddAssignment extends JFrame {
	JButton btnNewButton;
    JComboBox<String> courses;
	private JPanel contentPane;
	private JTextField search;
	private JTextField time;
	private JTextField date;
	private JTextField module;
	private JTextField day;
	private JTextField description;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAssignment frame = new AddAssignment();
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
	
	public AddAssignment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 853);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
			Statement statement = connection.createStatement();
			String selectQuery = "SELECT * FROM `Assignment`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
//			System.out.println(rs.toString());
			String[][] data = null;
			try {
			      rs.last();
			      int rowCount = rs.getRow();
			      rs.beforeFirst();
			      data = new String[rowCount][6];
			      int i = 0;
			      while (rs.next()) {
			        data[i][0] = rs.getString("Course");
			        data[i][1] = rs.getString("Module");
			        data[i][2] = rs.getString("Day");
			        data[i][3] = rs.getString("Due Date");
			        data[i][4] = rs.getString("Time");
			        data[i][5] = rs.getString("Description");
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
			String[] columnNames = {"Course", "Module", "Day", "Due Date", "Time", "Description"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
		    
		    // Table Created
		    JTable table = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBackground(new Color(192, 192, 192));
			scrollPane.setBounds(19, 93, 1243, 282);
			contentPane.add(scrollPane);

		
			table.setBackground(new Color(192, 192, 192));
	
			
			JButton btnNewButton = new JButton("ADD");
			btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton.setBounds(581, 576, 133, 43);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//		            if(JTextField == 0) {
//						JOptionPane.showMessageDialog(registerButton, "Please!!! Filled all the TextBox", "Inane error", JOptionPane.ERROR_MESSAGE);
//		            }
//		            else {
//					    JOptionPane.showMessageDialog(registerButton, "Successfully Register a new Student");
//		            }  
		                Connection con=null;
	        		try {
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
	        		try {
	        			String insertQuery = "INSERT INTO `Assignment`(`Course`, `Module`, `Due Date`, `Time`, `Day`, `Description`) VALUES (?,?,?,?,?,?)";
	        		      //Create a PreparedStatement
	        		      try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertQuery)) {
	        		        
	        		    	preparedStatement.setString(1, courses.getSelectedItem().toString());
	        		        preparedStatement.setString(2, module.getText());
	        		        preparedStatement.setString(3, date.getText());
	        		        preparedStatement.setString(4, time.getText());
	        		        preparedStatement.setString(5, day.getText());
	        		        preparedStatement.setString(6, description.getText());
	        		        
	        		        
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
			btnNewButton_2.setBounds(684, 732, 117, 33);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Add Assignment");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(623, 15, 257, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO INSTRUCTOR DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(19, 18, 445, 33);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					InstructorDashboard iddd= new InstructorDashboard();
					dispose();
					iddd.setVisible(true);
				}
			});
			
			
			search = new JTextField();
			search.setBounds(755, 631, 231, 33);
			contentPane.add(search);
			search.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Search Date for deleting Assignment");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblNewLabel_1.setForeground(new Color(255, 255, 0));
			lblNewLabel_1.setBounds(755, 600, 412, 19);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton_1 = new JButton("DELETE");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nam=search.getText();
					try (Connection conn = DriverManager.getConnection(
	                        "jdbc:mysql://localhost:3306/CMS", "root", "")) {
						String insertQuery ="delete from Assignment where `Due Date`='"+nam+"'";
	      		     
	      		      try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {
	      		        
	      		        
	      		      
	      		        preparedStatement.executeUpdate();
	                
	        
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e2) {
				
				e2.printStackTrace();
			}}});
			
			btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton_1.setBounds(998, 625, 169, 43);
			contentPane.add(btnNewButton_1);
			
		
			
			JLabel lblNewLabel_3 = new JLabel("Courses");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3.setForeground(new Color(0, 255, 0));
			lblNewLabel_3.setBounds(169, 408, 79, 16);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_3_1 = new JLabel("Date");
			lblNewLabel_3_1.setForeground(Color.GREEN);
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_1.setBounds(169, 486, 79, 16);
			contentPane.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_3_4 = new JLabel("Module");
			lblNewLabel_3_4.setForeground(Color.GREEN);
			lblNewLabel_3_4.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_4.setBounds(551, 408, 79, 16);
			contentPane.add(lblNewLabel_3_4);
			
			JLabel lblNewLabel_3_5 = new JLabel("Time");
			lblNewLabel_3_5.setForeground(Color.GREEN);
			lblNewLabel_3_5.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_5.setBounds(385, 486, 79, 16);
			contentPane.add(lblNewLabel_3_5);
			
	        courses = new JComboBox<String>();
			courses.setForeground(new Color(0, 0, 255));
			courses.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			courses.setModel(new DefaultComboBoxModel(new String[] {"Select a Course", "BSc (Hons) in CS", "International Master in BA", "BBA", "BIBM"}));
			courses.setBounds(102, 441, 283, 33);
			contentPane.add(courses);
		
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/CMS", "root", "")) {
					String insertQuery = "update `Assignment` set `Course`=?, `Module`=?, `Day`=?, `Due Date`=?, `time`=?, `Description`=? where `Module`='"+module.getText()+"'";;
      		     
      		      try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {
      		       
      		    	  
      		    	preparedStatement.setString(1, courses.getSelectedItem().toString());
    		        preparedStatement.setString(2, module.getText());
    		        preparedStatement.setString(3, day.getText());
    		        preparedStatement.setString(4, date.getText());
    		        preparedStatement.setString(5, time.getText());
    		        preparedStatement.setString(6, description.getText());
    		        
      		       
      		        preparedStatement.executeUpdate();
                
               
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}}});
		btnNewButton_3.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
		btnNewButton_3.setBounds(336, 625, 169, 43);
		contentPane.add(btnNewButton_3);
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(319, 502, 203, 43);
		contentPane.add(time);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(104, 502, 203, 43);
		contentPane.add(date);
		
		module = new JTextField();
		module.setColumns(10);
		module.setBounds(443, 436, 293, 43);
		contentPane.add(module);
		
		day = new JTextField();
		day.setColumns(10);
		day.setBounds(534, 502, 203, 43);
		contentPane.add(day);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(786, 437, 418, 116);
		contentPane.add(description);
		
		JLabel lblNewLabel_3_5 = new JLabel("Day");
		lblNewLabel_3_5.setForeground(Color.GREEN);
		lblNewLabel_3_5.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_3_5.setBounds(600, 486, 79, 16);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("Description");
		lblNewLabel_3_5_1.setForeground(Color.GREEN);
		lblNewLabel_3_5_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_3_5_1.setBounds(967, 406, 95, 20);
		contentPane.add(lblNewLabel_3_5_1);
		
	}

	public void addActionListener1() {
		btnNewButton.addActionListener((ActionListener) this);
    }
}
