package Frontend;

import java.awt.EventQueue;




import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class login {

    private JFrame frame;
    private JTextField Username;
    private JPasswordField password;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Herald Login Page");
        frame.setBackground(Color.WHITE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 248, 220));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/Images/login.png")));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setBounds(119, 151, 50, 50);
        panel.add(lblNewLabel);

        Username = new JTextField();
        Username.setText("Enter your Username...");
        Username.setHorizontalAlignment(SwingConstants.LEFT);
        Username.setBounds(186, 151, 280, 41);
        panel.add(Username);
        Username.setColumns(10);
        Username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Username.getText().equals("Enter your Username...")){
                    Username.setText("");
                    Username.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Username.getText().isEmpty()){
                    Username.setText("Enter your Username...");
                    Username.setForeground(Color.GRAY);
                }
            }
        });


        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/Images/password.png")));
        lblNewLabel_1.setBounds(119, 228, 50, 50);
        panel.add(lblNewLabel_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select User Mode ", "Admin", "Instructor", "Student"}));
        comboBox.setBounds(186, 290, 280, 41);
        panel.add(comboBox);


        JButton btnNewButton = new JButton("LogIn");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username = Username.getText();
            	char[] pass = password.getPassword();
            	String pa = new String(pass);
            	String usermode = (String)comboBox.getSelectedItem();
            	
            	try {
            		Class.forName("com.mysql.cj.jdbc.Driver");  
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
                    java.sql.Statement state = con.createStatement();
                   if(usermode.equals("Admin")) { 
                	   String query=("SELECT * FROM Admin");
                	   ResultSet rs = state.executeQuery(query);
                	   int x =0;
                	   while(rs.next()) {
                		   String user = rs.getString("Username");
//                		   String email = rs.getString("Email");
                		   String pword = rs.getString("Password");
//                		   boolean errorShown = 
                		   if(user.equalsIgnoreCase(username) && pword.equals(pa)) {
                			   JOptionPane.showMessageDialog(btnNewButton, "Welcome"+ " " +user);
                			   frame.setVisible(false);
                			   AdminDashboard dashboard = new AdminDashboard();
//                			   frame.setVisible(false);
                			   dashboard.setVisible(true);
                			   x++;
                			   break;
                    		   
                    	   }
                		   
                	   }
                	   if(x==0) {
                		   JOptionPane.showMessageDialog(btnNewButton, "Error!!! Wrong Username or Password!");
                	   }
                   }
             
                   if (usermode.equals("Student")) {
               		String query = ("Select * from Student");
               		ResultSet rs = state.executeQuery(query);
               		int x =0;
               		while(rs.next()) {
               			String user = rs.getString("Username");
               			String password = rs.getString("Password");
               			if(user.equalsIgnoreCase(username) && password.equals(pa))
               			{
               				JOptionPane.showMessageDialog(btnNewButton, "Welcome" + " " +user);
               				frame.setVisible(false);
               				StudentDashboard studentDashboard = new StudentDashboard();
//               				frame.setVisible(false);
               				studentDashboard.setVisible(true);
               				x++;
               				break;
               			}
               		}
               		if(x == 0) {
                   		JOptionPane.showMessageDialog(btnNewButton, "Error!!! Wrong Username or Password!");
               			
               		}
               		
               		
               		}     		
                   
                   if(usermode.equals("Instructor")) {
                	   String query = ("Select * from Instructor");
                	   ResultSet rs = state.executeQuery(query);
                	   int x =0;
                	   while (rs.next()) {
                		   String user = rs.getString("Username");
                		   String password = rs.getString("Password");
                		   if(user.equalsIgnoreCase(username) && password.equals(pa)) {
                			   JOptionPane.showMessageDialog(btnNewButton, "Welcome" + " " + user);
                			   frame.setVisible(false);
                			   InstructorDashboard tutorDashboard = new InstructorDashboard();
                			   tutorDashboard.setVisible(true);
                			   x++;
                			   break;
                		   }
                		   
                	   }
                	   if(x == 0) {
                		   JOptionPane.showMessageDialog(btnNewButton, "Error!!! Wrong Username or Password!");
                	   }
                   }
            		
            	}catch(Exception ex) {
            		System.out.println(e);
            	}
            	
            }
        });
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(100, 149, 237));
        btnNewButton.setBounds(254, 354, 142, 47);
        panel.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("OR");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(300, 413, 61, 22);
        panel.add(lblNewLabel_2);

        JButton btnCreateANew = new JButton("Create a new account");
        btnCreateANew.setForeground(Color.BLACK);
        btnCreateANew.setBackground(new Color(0, 0, 255));
        btnCreateANew.setBounds(186, 447, 280, 47);
        panel.add(btnCreateANew);
        btnCreateANew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp signUp=new SignUp();
                frame.setVisible(false);
                signUp.setVisible(true);
            }
        });

        password = new JPasswordField();
        password.setBounds(186, 237, 280, 41);
        panel.add(password);
        
        JLabel lblNewLabel_2_1_1_2 = new JLabel("");
        lblNewLabel_2_1_1_2.setBounds(147, 140, 27, 52);
        panel.add(lblNewLabel_2_1_1_2);
        
        JLabel lblNewLabel_2_1_1_2_1 = new JLabel("");
        lblNewLabel_2_1_1_2_1.setBounds(147, 221, 27, 52);
        panel.add(lblNewLabel_2_1_1_2_1);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(254, 16, 0, 0);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(login.class.getResource("/Images/degree.png")));
        lblNewLabel_4.setBounds(417, 49, 90, 90);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Welcome to HCK");
        lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblNewLabel_5.setBounds(193, 85, 198, 31);
        panel.add(lblNewLabel_5);
        
      
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
	}
}
