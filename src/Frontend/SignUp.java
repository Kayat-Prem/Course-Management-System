package Frontend;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.InputVerifier;
//import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import javax.swing.ImageIcon;
import java.awt.Font;



public class SignUp {

    private JFrame frmWelcomeToHck;
    private JTextField TxtUsername;
    private JTextField TxtPhone;
    private JPasswordField TxtNewPassword;
    private JPasswordField TxtConfirmPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUp window = new SignUp();
                    window.frmWelcomeToHck.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SignUp() {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmWelcomeToHck = new JFrame();
        frmWelcomeToHck.setTitle("WELCOME TO HCK SIGN-UP PAGE");
        frmWelcomeToHck.setBackground(Color.WHITE);
        frmWelcomeToHck.getContentPane().setBackground(Color.WHITE);

        JPanel confirmPassword = new JPanel();
        confirmPassword.setBackground(new Color(255, 250, 205));
        frmWelcomeToHck.getContentPane().add(confirmPassword, BorderLayout.CENTER);
        confirmPassword.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(82, 166, 62, 16);
        confirmPassword.add(lblNewLabel);

        TxtUsername = new JTextField();
        TxtUsername.setText("Enter your username...");
        TxtUsername.setBounds(243, 155, 233, 38);
        confirmPassword.add(TxtUsername);
        TxtUsername.setColumns(10);
        TxtUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TxtUsername.getText().equals("Enter your username...")){
                    TxtUsername.setText("");
                    TxtUsername.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TxtUsername.getText().isEmpty()){
                    TxtUsername.setText("Enter your username...");
                    TxtUsername.setForeground(Color.GRAY);
                }
            }
        });

//        TxtUsername.setInputVerifier(new InputVerifier() {
//            @Override
//            public boolean verify(JComponent input) {
//                if (TxtUsername.getText().length()< 6) {
//                    JOptionPane.showMessageDialog(frmWelcomeToHck,"Error : Username must be atleast of 6 character","Alert",JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//                return true;
//            }
//        });

        JLabel Password = new JLabel("Phone or Email");
        Password.setBounds(82, 231, 93, 16);
        confirmPassword.add(Password);

        TxtPhone = new JTextField();
        TxtPhone.setText("Enter your Email or Phone");
        TxtPhone.setColumns(10);
        TxtPhone.setBounds(243, 220, 233, 38);
        confirmPassword.add(TxtPhone);
        TxtPhone.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                if(TxtPhone.getText().length() >= 10 || TxtPhone.getText().matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                    return true;
                }
                JOptionPane.showMessageDialog(frmWelcomeToHck,"Invalid number or email");
                return false;
            }
        });


        TxtPhone.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(TxtPhone.getText().equals("Enter your Email or Phone")){
                    TxtPhone.setText("");
                    TxtPhone.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(TxtPhone.getText().isEmpty()){
                    TxtPhone.setText("Enter your Email or Phone");
                    TxtPhone.setForeground(Color.GRAY);
                }
            }
        });


        JLabel lblNewPassword = new JLabel("New Password ");
        lblNewPassword.setBounds(82, 299, 94, 16);
        confirmPassword.add(lblNewPassword);


        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(83, 357, 114, 16);
        confirmPassword.add(lblConfirmPassword);


        JComboBox ComboCourse = new JComboBox();
        ComboCourse.setModel(new DefaultComboBoxModel(new String[] {"Select your course", "BSc(Hons) in Computer Science", "IMBA","BIBM", "BBA"}));
        ComboCourse.setBounds(243, 468, 233, 27);
        confirmPassword.add(ComboCourse);

        JComboBox ComboUserMode = new JComboBox();
        ComboUserMode.setModel(new DefaultComboBoxModel(new String[] {"Select user mode", "Admin", "Student", "Instructor"}));
        ComboUserMode.setBounds(243, 408, 233, 27);
        confirmPassword.add(ComboUserMode);
        
        TxtNewPassword = new JPasswordField();
        TxtNewPassword.setBounds(243, 288, 233, 38);
        confirmPassword.add(TxtNewPassword);
        
        TxtConfirmPassword = new JPasswordField();
        TxtConfirmPassword.setBounds(243, 346, 233, 38);
        confirmPassword.add(TxtConfirmPassword);
        
        
        JButton btnNewButton = new JButton("Sign UP");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int x = 0;
            	String Username = TxtUsername.getText();
            	String PhoneOrEmail = TxtPhone.getText();
            	char[] newPassword = TxtNewPassword.getPassword();
            	char[] confirmPassword = TxtConfirmPassword.getPassword();
            	String s5 = new String(newPassword);
            	String s6 = new String(confirmPassword);
            	String Usermode = (String)ComboUserMode.getSelectedItem();
            	String Course = (String)ComboCourse.getSelectedItem();
            	if(s5.equals(s6)){
            		if(Usermode.equals("Admin")) {
            			try {
                			
                			Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
                            PreparedStatement ps = con.prepareStatement("insert into Admin values(default,?,?,?)");  
                            ps.setString(1, Username);  
                            ps.setString(2, PhoneOrEmail);
                            ps.setString(3, s5);
                            ps.executeUpdate();  
                            x++;
                            
                            
                            if(x>0) {
                            	JOptionPane.showMessageDialog(btnNewButton, "Sucessfully signed ");
                            }else {
                        		JOptionPane.showMessageDialog(btnNewButton, "Password does not match");
                        		
                			}
                	
                			
                		}
                		catch(Exception ex){
                			System.out.println(ex);
                			
                		}
            		}
            		
            		if(Usermode.equals("Student")) {
            		
            			try {
            			
            			Class.forName("com.mysql.cj.jdbc.Driver");  
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
                        PreparedStatement ps = con.prepareStatement("insert into Student values(default,?,?,?,?)");
                        ps.setString(1, Username);  
                        ps.setString(2, PhoneOrEmail);  
                        ps.setString(3, Course);
                        ps.setString(4, s5);
            
                        ps.executeUpdate();  
                        x++;
                        
                        if(x>0) {
                        	JOptionPane.showMessageDialog(btnNewButton, "Sucessfully Signed In");
                        }else {
            		JOptionPane.showMessageDialog(btnNewButton, "Password does not match");
            		
            			}
            	
            			
            			}
            			catch(Exception ex){
            			System.out.println(ex);
            			
            				}
            		
            		
            		}
            		
            		if(Usermode.equals("Instructor")) {
            			try {
                			
                			Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
//                            PreparedStatement dataInsert = con.prepareStatement("create table Details(Username varchar(50) NOT NULL, Email varchar(100) NOT NULL, Password varchar(100) NOT NULL)");
                            PreparedStatement ps = con.prepareStatement("insert into Instructor values(default,?,?,?)");  
//                            ps.setInt(1,1); 
                            ps.setString(1, Username);  
                            ps.setString(2, PhoneOrEmail);
                            ps.setString(3, s5);
ps.executeUpdate();  
                            x++;
                            
                            if(x>0) {
                            	JOptionPane.showMessageDialog(btnNewButton, "Sucessfully Signed In");
                            }else {
                        		JOptionPane.showMessageDialog(btnNewButton, "Password does not match");
                        		
                			}
                	
                			
                			}
                			catch(Exception ex){
                			System.out.println(ex);
                			
                		}
            		}
            		
            		
//            	else {
//            		JOptionPane.showMessageDialog(btnNewButton, "Password does not match");
//            		
//            			}
//            	
            		}
            	
            }
            
        });
        
        btnNewButton.setBounds(293, 520, 117, 38);
        confirmPassword.add(btnNewButton);

        JLabel lblOr = new JLabel("OR");
        lblOr.setHorizontalAlignment(SwingConstants.CENTER);
        lblOr.setBounds(303, 570, 105, 29);
        confirmPassword.add(lblOr);

        JButton btnNewButton_1 = new JButton("<- Back LogIn");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				login lo=new login();
				frmWelcomeToHck.setVisible(false);
				lo.setVisible(true);
            }
        });
        
        
        btnNewButton_1.setBounds(295, 613, 117, 29);
        confirmPassword.add(btnNewButton_1);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("");
        lblNewLabel_2_1_1.setBounds(138, 268, 27, 52);
        confirmPassword.add(lblNewLabel_2_1_1);
        
        JLabel lblNewLabel_2_1_1_1 = new JLabel("");
        lblNewLabel_2_1_1_1.setBounds(138, 189, 27, 52);
        confirmPassword.add(lblNewLabel_2_1_1_1);
        
        JLabel lblNewLabel_2_1_1_2 = new JLabel("");
        lblNewLabel_2_1_1_2.setBounds(138, 346, 27, 52);
        confirmPassword.add(lblNewLabel_2_1_1_2);
        
        JLabel lblNewLabel_2_1_1_2_1 = new JLabel("");
        
        lblNewLabel_2_1_1_2_1.setBounds(138, 435, 27, 52);
        confirmPassword.add(lblNewLabel_2_1_1_2_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(SignUp.class.getResource("/Images/degree.png")));
        lblNewLabel_2.setBounds(404, 20, 90, 90);
        confirmPassword.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("WELCOME TO HCK");
        lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
        lblNewLabel_3.setBounds(152, 68, 240, 31);
        confirmPassword.add(lblNewLabel_3);
        
        JLabel lblMode = new JLabel("Mode");
        lblMode.setBounds(83, 419, 114, 16);
        confirmPassword.add(lblMode);
        
        JLabel lblCourse = new JLabel("Course  ");
        lblCourse.setBounds(83, 472, 114, 16);
        confirmPassword.add(lblCourse);


        
        


        frmWelcomeToHck.setBounds(100, 100, 585, 719);
        frmWelcomeToHck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frmWelcomeToHck.setVisible(true);
		
	}
}
