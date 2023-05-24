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
import net.proteanit.sql.DbUtils;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMarks extends JFrame {
	JButton btnNewButton;
    JComboBox<String> courses;
    JComboBox<Integer> semester;
    JComboBox<Integer> year;
	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField search;
	private JTextField full;
	private JTextField obtained;
	private JTextField pass;
	private JTextField studentid;
	private JTextField textField;
	private JTextField module;
	private JTextField sn;
	private Connection connection;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarks frame = new AddMarks();
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
	
	public AddMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1282, 851);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		public static void showUpdateDataInJtableFromDb() {
//			Statement statement = DbUtil.getStatement();

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
					Statement statement = connection.createStatement();
					String selectQuery = "SELECT * FROM `Marks`";
					
					ResultSet rs = statement.executeQuery(selectQuery);
					
				//	System.out.println(rs.toString());
					String[][] data = null;
					try {
					      rs.last();
					      int rowCount = rs.getRow();
					      rs.beforeFirst();
					      data = new String[rowCount][10];
					      int i = 0;
					      while (rs.next()) {
					    	data[i][0] = rs.getString("SN");
					        data[i][1] = rs.getString("Name");
					        data[i][2] = Integer.toString(rs.getInt("Student Id"));
					        data[i][3] = rs.getString("Full Marks");
					        data[i][4] = rs.getString("Pass Marks");
					        data[i][5] = rs.getString("Obtained Marks");
					        data[i][6] = rs.getString("Course");
					        data[i][7] = rs.getString("Module");
					        data[i][8] =Integer.toString(rs.getInt("Year"));
					        data[i][9]=Integer.toString(rs.getInt("Semester"));
					        i++;
					      }
					    } catch (SQLException e) {
					      System.out.println(e);
					    }
					String[] columnNames = {"SN", "Name", "Student Id", "Full Marks", "Pass Marks", "Obtained Marks", "Course", "Module", "Semester","Year"};
					DefaultTableModel model = new DefaultTableModel(data, columnNames);
					 
				    // Table Created
				    JTable table = new JTable(model);
					
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						}
					});
					scrollPane.setBackground(new Color(192, 192, 192));
					scrollPane.setBounds(331, 133, 945, 357);
					contentPane.add(scrollPane);
					table.setBackground(new Color(192, 192, 192));
				//	table.setModel(DbUtils.resultSetToTableModel(rs));
				//	model.fireTableDataChanged();    //notify the table that the data has changed
//		      }
			
			JButton btnNewButton = new JButton("ADD");
			btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton.setBounds(362, 564, 139, 43);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
	        		try {
	        			String insertQuery = "INSERT INTO `Marks`(`SN`, `Name`, `Student Id`, `Full Marks`, `Pass Marks`, `Obtained Marks`, `Course`, `Module`, `Year`, `Semester`) VALUES (?,?,?,?,?,?,?,?,?,?)";
	        		     
	        		      try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertQuery)) {
	        		        
	        		    	preparedStatement.setInt(1,Integer.parseInt(sn.getText()));
	        		        preparedStatement.setString(2, name.getText());
	        		        preparedStatement.setInt(3,Integer.parseInt(studentid.getText()));
	        		        preparedStatement.setInt(4,Integer.parseInt(full.getText()));
	        		        preparedStatement.setInt(5,Integer.parseInt(pass.getText()));
	        		        preparedStatement.setInt(6,Integer.parseInt(obtained.getText()));
	        		        preparedStatement.setString(7, courses.getSelectedItem().toString());
	        		        preparedStatement.setString(8, module.getText());
	        		        preparedStatement.setInt(9, Integer.parseInt(year.getSelectedItem().toString()));
	        		        preparedStatement.setInt(10, Integer.parseInt(semester.getSelectedItem().toString()));
	        		        
	        		        
	        		        preparedStatement.executeUpdate();

	        		      
	        		      } catch (SQLException e1) {
	        		
	        			e1.printStackTrace();
	        		}
	        		}catch(Exception e3) {
	        			e3.printStackTrace();
	        		}
	        		
	        		try {
	        			
	        		
	        		
	        		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
					Statement statement = connection.createStatement();
					String selectQuery = "SELECT * FROM `Marks`";
					
					ResultSet rs = statement.executeQuery(selectQuery);
	        		}catch (Exception e1) {
	        			
	        		}
					
				//	System.out.println(rs.toString());
					String[][] data = null;
					try {
					      rs.last();
					      int rowCount = rs.getRow();
					      rs.beforeFirst();
					      data = new String[rowCount][10];
					      int i = 0;
					      while (rs.next()) {
					    	data[i][0] = rs.getString("SN");
					        data[i][1] = rs.getString("Name");
					        data[i][2] = Integer.toString(rs.getInt("Student Id"));
					        data[i][3] = rs.getString("Full Marks");
					        data[i][4] = rs.getString("Pass Marks");
					        data[i][5] = rs.getString("Obtained Marks");
					        data[i][6] = rs.getString("Course");
					        data[i][7] = rs.getString("Module");
					        data[i][8] =Integer.toString(rs.getInt("Year"));
					        data[i][9]=Integer.toString(rs.getInt("Semester"));
					        i++;
					      }
					    } catch (SQLException e1) {
					      System.out.println(e1);
					    }
					String[] columnNames = {"SN", "Name", "Student Id", "Full Marks", "Pass Marks", "Obtained Marks", "Course", "Module", "Semester","Year"};
					DefaultTableModel model = new DefaultTableModel(data, columnNames);
					 
				    // Table Created
				    JTable table = new JTable(model);
					
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						}
					});
					scrollPane.setBackground(new Color(192, 192, 192));
					scrollPane.setBounds(331, 133, 945, 357);
					contentPane.add(scrollPane);
					table.setBackground(new Color(192, 192, 192));
	        		
	        		
	        		
	        	
	        }});
			
			
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
			
			JLabel lblNewLabel = new JLabel("Add Marks");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(696, 18, 244, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO INSTRUCTOR DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(6, 6, 445, 33);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					InstructorDashboard adddd= new InstructorDashboard();
					dispose();
					adddd.setVisible(true);
				}
			});
			
			
			search = new JTextField();
			search.setBounds(696, 564, 231, 33);
			contentPane.add(search);
			search.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Search Student Id to be Remove");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblNewLabel_1.setForeground(new Color(255, 255, 0));
			lblNewLabel_1.setBounds(696, 533, 286, 19);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton_1 = new JButton("DELETE");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nam=search.getText();
					try (Connection conn = DriverManager.getConnection(
	                        "jdbc:mysql://localhost:3306/CMS", "root", "")) {
						String insertQuery ="delete from Marks where `Student Id`='"+nam+"'";
						
	      		      
	      		      try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {	     
	      		        preparedStatement.executeUpdate();
	                
	               
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e2) {
				
				e2.printStackTrace();
			}}});
			
			btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton_1.setBounds(940, 554, 169, 43);
			contentPane.add(btnNewButton_1);
			
		
			
			JLabel lblNewLabel_3 = new JLabel("Courses");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3.setForeground(new Color(0, 255, 0));
			lblNewLabel_3.setBounds(19, 474, 79, 16);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_6 = new JLabel("Semester");
			lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_6.setForeground(new Color(0, 255, 0));
			lblNewLabel_6.setBounds(162, 569, 92, 33);
			contentPane.add(lblNewLabel_6);
			
			JLabel lblNewLabel_3_1 = new JLabel("Pass Marks");
			lblNewLabel_3_1.setForeground(Color.GREEN);
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_1.setBounds(19, 365, 92, 20);
			contentPane.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_3_2 = new JLabel("Name");
			lblNewLabel_3_2.setForeground(Color.GREEN);
			lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_2.setBounds(19, 200, 79, 16);
			contentPane.add(lblNewLabel_3_2);
			
			full = new JTextField();
			full.setColumns(10);
			full.setBounds(156, 300, 173, 43);
			contentPane.add(full);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("Std Id");
			lblNewLabel_3_1_1.setForeground(Color.GREEN);
			lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_1_1.setBounds(19, 255, 79, 16);
			contentPane.add(lblNewLabel_3_1_1);
			
			obtained = new JTextField();
			obtained.setColumns(10);
			obtained.setBounds(156, 414, 173, 43);
			contentPane.add(obtained);
			
			pass = new JTextField();
			pass.setColumns(10);
			pass.setBounds(156, 355, 173, 43);
			contentPane.add(pass);
			

			studentid = new JTextField();
			studentid.setColumns(10);
			studentid.setBounds(110, 243, 219, 43);
			contentPane.add(studentid);
			
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(110, 188, 219, 43);
			contentPane.add(name);
			
			JLabel lblNewLabel_3_4 = new JLabel("Obtained Marks");
			lblNewLabel_3_4.setForeground(Color.GREEN);
			lblNewLabel_3_4.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_4.setBounds(19, 424, 130, 20);
			contentPane.add(lblNewLabel_3_4);
			
			JLabel lblNewLabel_3_5 = new JLabel("Full Marks");
			lblNewLabel_3_5.setForeground(Color.GREEN);
			lblNewLabel_3_5.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_5.setBounds(19, 310, 85, 20);
			contentPane.add(lblNewLabel_3_5);
			
	        courses = new JComboBox<String>();
			courses.setForeground(new Color(0, 0, 255));
			courses.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			courses.setModel(new DefaultComboBoxModel(new String[] {"Select a Course", "BSc (Hons) in CS", "International Master in BA", "BBA", "BIBM"}));
			courses.setBounds(110, 469, 219, 33);
			contentPane.add(courses);
			
			JLabel yearr = new JLabel("Year");
			yearr.setForeground(Color.GREEN);
			yearr.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			yearr.setBounds(19, 569, 92, 33);
			contentPane.add(yearr);
			
			semester = new JComboBox<>();
			semester.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			semester.addItem(1);
			semester.addItem(2);
			semester.addItem(3);
			semester.addItem(4);
			semester.addItem(5);
			semester.addItem(6);
			semester.addItem(7);
			semester.addItem(8);
			semester.setForeground(Color.BLUE);
			semester.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			semester.setBounds(243, 571, 86, 33);
			contentPane.add(semester);
			
			year = new JComboBox<>();
			year.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			year.addItem(1);
			year.addItem(2);
			year.addItem(3);
			year.addItem(4);
			year.setForeground(Color.BLUE);
			year.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			year.setBounds(64, 571, 86, 33);
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
					String insertQuery = "update `Marks` set `SN`=?, `Name`=?, `Student Id`=?, `Full Marks`=?, `Pass Marks`=?, `Obtained Marks`=?, `Course`=?, `Module`=?, `Year`=?, `Semester`=? where `SN`='"+Integer.parseInt(sn.getText())+"'";
      		      																																	
      		      try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {
      		       
      		    	preparedStatement.setInt(1,Integer.parseInt(sn.getText()));
    		        preparedStatement.setString(2, name.getText());
    		        preparedStatement.setInt(3,Integer.parseInt(studentid.getText()));
    		        preparedStatement.setInt(4,Integer.parseInt(full.getText()));
    		        preparedStatement.setInt(5,Integer.parseInt(pass.getText()));
    		        preparedStatement.setInt(6,Integer.parseInt(obtained.getText()));
    		        preparedStatement.setString(7, courses.getSelectedItem().toString());
    		        preparedStatement.setString(8, module.getText());
    		        preparedStatement.setInt(9, Integer.parseInt(year.getSelectedItem().toString()));
    		        preparedStatement.setInt(10, Integer.parseInt(semester.getSelectedItem().toString()));
    		        
      		        
      		       
      		        preparedStatement.executeUpdate();
                
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}}});
		btnNewButton_3.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
		btnNewButton_3.setBounds(532, 564, 139, 43);
		contentPane.add(btnNewButton_3);
		
		module = new JTextField();
		module.setColumns(10);
		module.setBounds(110, 514, 219, 43);
		contentPane.add(module);
		
		JLabel lblNewLabel_3 = new JLabel("Module");
		lblNewLabel_3.setForeground(Color.GREEN);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_3.setBounds(19, 526, 79, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("SN");
		lblNewLabel_3_2.setForeground(Color.GREEN);
		lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(19, 145, 79, 16);
		contentPane.add(lblNewLabel_3_2);
		
		sn = new JTextField();
		sn.setColumns(10);
		sn.setBounds(110, 133, 219, 43);
		contentPane.add(sn);
		
//		JButton load = new JButton("LOAD");
//		load.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
//		load.setBounds(728, 89, 139, 43);
//		contentPane.add(load);
//		load.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		
//		AddMarks.showUpdateDataInJtableFromDb();
		
	}

	public void addActionListener1() {
		btnNewButton.addActionListener((ActionListener) this);
    }
}
