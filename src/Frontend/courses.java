package Frontend;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class courses extends JFrame {

	private JPanel contentPane;
	private Container cardPanel;
	private JTextField coursename;
	private JTextField sn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courses frame = new courses();
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
	public courses() {
		setTitle("Courses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 851);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 

		
		JButton btnNewButton1 = new JButton("BSc (Hons) in Computer Science");
		btnNewButton1.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		btnNewButton1.setBounds(137, 295, 299, 43);
		contentPane.add(btnNewButton1);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewModule v = new ViewModule();
			dispose();
			v.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("BSc (Hons) in International Business Management");
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		btnNewButton_1.setBounds(449, 441, 411, 43);
		contentPane.add(btnNewButton_1);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewModule v = new ViewModule();
			dispose();
			v.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("International MBA");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		btnNewButton_2.setBounds(872, 295, 278, 43);
		contentPane.add(btnNewButton_2);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewModule v = new ViewModule();
			dispose();
			v.setVisible(true);
			}
		});
		 
		JButton btnNewButton_3 = new JButton("Return Home");
		btnNewButton_3.setForeground(new Color(0, 0, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard back = new AdminDashboard() ;
				dispose();
				back.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(6, 22, 142, 35);
		contentPane.add(btnNewButton_3);
		
		
		JButton btnNewButton = new JButton("Our Courses");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		btnNewButton.setBounds(464, 6, 360, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(courses.class.getResource("/Images/Bussiness.jpeg")));
		lblNewLabel.setBounds(501, 269, 299, 169);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(courses.class.getResource("/Images/Computer_1_299x169.jpg")));
		lblNewLabel_1.setBounds(137, 124, 299, 169);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(courses.class.getResource("/Images/MBA_299x169.jpg")));
		lblNewLabel_2.setBounds(859, 124, 299, 169);
		contentPane.add(lblNewLabel_2);
	
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
			Statement statement = connection.createStatement();
			String selectQuery = "SELECT * FROM `Course`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
//			System.out.println(rs.toString());
			String[][] data = null;
			try {
			      rs.last();
			      int rowCount = rs.getRow();
			      rs.beforeFirst();
			      data = new String[rowCount][4];
			      int i = 0;
			      while (rs.next()) {
			        data[i][0] = Integer.toString(rs.getInt("SN"));
			        data[i][1] = rs.getString("Course Name");
			        
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
			String[] columnNames = {"SN", "Course Name"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
		    
		    // Table Created
		    JTable table = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBackground(new Color(192, 192, 192));
			scrollPane.setBounds(896, 441, 308, 329);
			contentPane.add(scrollPane);	
			table.setBackground(new Color(192, 192, 192));
			
			JButton update = new JButton("UPDATE");
			update.setFont(new Font("Lucida Grande", Font.BOLD, 17));
			update.setBounds(137, 668, 117, 35);
			contentPane.add(update);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try (Connection conn = DriverManager.getConnection(
	                        "jdbc:mysql://localhost:3306/CMS", "root", "")) {
						String insertQuery = "update `Course` set `SN`=?, `Course Name`=? where `SN`='"+sn.getText()+"'";
	      		      
	      		      try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {
	      		    
	      		    	preparedStatement.setInt(1, Integer.parseInt(sn.getText()));
	      		        preparedStatement.setString(2, coursename.getText());
	      		      
	      		        preparedStatement.executeUpdate();
	                
	            
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e2) {
				
				e2.printStackTrace();
			}}});
			
			
			
			coursename = new JTextField();
			coursename.setBounds(137, 545, 232, 43);
			contentPane.add(coursename);
			coursename.setColumns(10);
			
			sn = new JTextField();
			sn.setColumns(10);
			sn.setBounds(137, 481, 232, 43);
			contentPane.add(sn);
			
			JLabel lblNewLabel_3 = new JLabel("SN");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 17));
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setBounds(37, 492, 61, 16);
			contentPane.add(lblNewLabel_3);
			
			JLabel course = new JLabel("COURSE");
			course.setFont(new Font("Lucida Grande", Font.BOLD, 17));
			course.setForeground(new Color(255, 255, 255));
			course.setBounds(37, 554, 71, 21);
			contentPane.add(course);
			
			JButton btnAdd = new JButton("ADD");
			btnAdd.setFont(new Font("Lucida Grande", Font.BOLD, 17));
			btnAdd.setBounds(137, 608, 117, 35);
			contentPane.add(btnAdd);
			btnAdd.addActionListener(new ActionListener() {
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
	        			String insertQuery = "INSERT INTO `Course`(`SN`,`Course Name`) VALUES (?,?)";
	        		      
	        		      try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertQuery)) {
	        		       
		        		    preparedStatement.setInt(1, Integer.parseInt(sn.getText()));
	        		        preparedStatement.setString(2, coursename.getText());
	        		        
	        		      
	        		        preparedStatement.executeUpdate();
	        		        
	        		} catch (SQLException e1) {
	        			
	        			e1.printStackTrace();
	        		}
	        		}catch(Exception e3) {
	        			e3.printStackTrace();
	        		}
	        	
	        }});
			
			
			JButton delete = new JButton("DELETE");
			delete.setFont(new Font("Lucida Grande", Font.BOLD, 17));
			delete.setBounds(549, 668, 117, 35);
			contentPane.add(delete);
			
			JTextField search = new JTextField();
			search.setBounds(315, 668, 222, 36);
			contentPane.add(search);
			search.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("Search Courses to be Remove");
			lblNewLabel_1_1.setForeground(Color.YELLOW);
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(315, 651, 249, 19);
			contentPane.add(lblNewLabel_1_1);
			
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "Do you want to Delete a COURSE?", "DELETE", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
//						System.exit(0);
					    // User clicked Yes, handle the .....
					} else {
					    // User clicked No, do nothing or handle accordingly
					}
					String nam=search.getText();
					try (Connection conn = DriverManager.getConnection(
	                        "jdbc:mysql://localhost:3306/CMS", "root", "")) {
						String insertQuery ="delete from Course where `SN`='"+nam+"'";
	      		     
	      		      try (PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(insertQuery)) {
	      		   
	      		        preparedStatement.executeUpdate();
	                
//	                
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}}});
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

