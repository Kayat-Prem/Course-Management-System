package Frontend;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;

public class MainDashboard {

	private JFrame frmDashboard;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDashboard window = new MainDashboard();
					window.frmDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDashboard = new JFrame();
		frmDashboard.setTitle("Herald College Kathmandu & The University Partner ~ University of Wolverhampton");
		frmDashboard.getContentPane().setBackground(Color.WHITE);
		frmDashboard.setBackground(Color.WHITE);
		frmDashboard.setBounds(100, 100, 1280, 814);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboard.getContentPane().setLayout(null);
		frmDashboard.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(106, 90, 205));
		panel.setBounds(0, 0, 156, 800);
		frmDashboard.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				layeredPane.removeAll()
			}
		});
		btnNewButton.setBounds(19, 113, 117, 45);
		panel.add(btnNewButton);
		
		JButton adminPanel = new JButton("Course Admin");
		adminPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard ad = new AdminDashboard();
				frmDashboard.setVisible(false);
				ad.setVisible(true);
			}
		});
		adminPanel.setBounds(19, 187, 117, 45);
		panel.add(adminPanel);
		
		JButton btnTutor = new JButton("Instructor");
		btnTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructorDashboard idd = new InstructorDashboard();
				frmDashboard.setVisible(false);
				idd.setVisible(true);
			}
		});
		
		btnTutor.setBounds(19, 270, 117, 45);
		panel.add(btnTutor);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setBounds(19, 358, 117, 45);
		panel.add(btnStudents);
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDashboard sdd = new StudentDashboard();
				frmDashboard.setVisible(false);
				sdd.setVisible(true);
			}
		});
		
		JButton btnMail = new JButton("Mail");
		btnMail.setBounds(19, 448, 117, 45);
		panel.add(btnMail);
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.setBounds(19, 527, 117, 45);
		panel.add(btnSetting);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				    // User clicked Yes, handle the logout
				} else {
				    // User clicked No, do nothing or handle accordingly
					frmDashboard.setVisible(true);
				}
//				login lg = new login();
//				lg.setVisible(true);
			}
		});
		btnLogOut.setBounds(31, 596, 90, 45);
		panel.add(btnLogOut);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(168, 6, -12, 669);
		frmDashboard.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel DashboardPanel = new JPanel();
		DashboardPanel.setBounds(168, 0, 1106, 800);
		frmDashboard.getContentPane().add(DashboardPanel);
		DashboardPanel.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(106, 90, 205));
		panel_7.setBounds(919, 6, 181, 788);
		DashboardPanel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Notifications");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(6, 6, 169, 34);
		panel_7.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("TO DO LIST");
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_6_1_1_1.setBounds(16, 287, 159, 47);
		panel_7.add(lblNewLabel_6_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1.setBackground(SystemColor.windowBorder);
		panel_1.setBounds(16, 52, 159, 53);
		panel_7.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("New Student Registered...");
		lblNewLabel_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2.setBounds(6, 21, 150, 15);
		panel_1.add(lblNewLabel_3_2_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_3.setBackground(SystemColor.windowBorder);
		panel_1_3.setBounds(16, 117, 159, 53);
		panel_7.add(panel_1_3);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("New Student Registered...");
		lblNewLabel_3_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_1.setBounds(6, 19, 150, 15);
		panel_1_3.add(lblNewLabel_3_2_2_1);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4.setBackground(SystemColor.windowBorder);
		panel_1_4.setBounds(16, 186, 159, 53);
		panel_7.add(panel_1_4);
		
		JLabel lblNewLabel_3_2_2_2 = new JLabel("New Student Registered...");
		lblNewLabel_3_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_2.setBounds(6, 19, 150, 15);
		panel_1_4.add(lblNewLabel_3_2_2_2);
		
		JPanel panel_1_4_1 = new JPanel();
		panel_1_4_1.setName("");
		panel_1_4_1.setLayout(null);
		panel_1_4_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_1.setBackground(SystemColor.windowBorder);
		panel_1_4_1.setBounds(16, 346, 159, 53);
		panel_7.add(panel_1_4_1);
		
		JLabel lblNewLabel_3_2_2_3 = new JLabel("Assignement Week-2");
		lblNewLabel_3_2_2_3.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_3.setBounds(6, 18, 150, 15);
		panel_1_4_1.add(lblNewLabel_3_2_2_3);
		
		JPanel panel_1_4_2 = new JPanel();
		panel_1_4_2.setLayout(null);
		panel_1_4_2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_2.setBackground(SystemColor.windowBorder);
		panel_1_4_2.setBounds(16, 428, 159, 53);
		panel_7.add(panel_1_4_2);
		
		JLabel lblNewLabel_3_2_2_3_1 = new JLabel("Assignement Week-8\n");
		lblNewLabel_3_2_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_3_1.setBounds(6, 20, 150, 15);
		panel_1_4_2.add(lblNewLabel_3_2_2_3_1);
		
		JPanel panel_1_4_3 = new JPanel();
		panel_1_4_3.setLayout(null);
		panel_1_4_3.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_3.setBackground(SystemColor.windowBorder);
		panel_1_4_3.setBounds(16, 504, 159, 53);
		panel_7.add(panel_1_4_3);
		
		JLabel lblNewLabel_3_2_2_3_2 = new JLabel("Assignement Week-10\n");
		lblNewLabel_3_2_2_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_3_2.setBounds(6, 19, 150, 15);
		panel_1_4_3.add(lblNewLabel_3_2_2_3_2);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(6, 6, 221, 41);
		DashboardPanel.add(lblNewLabel);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(106, 90, 205));
		panel_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_2.setBounds(624, 37, 148, 125);
		DashboardPanel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		textField_11 = new JTextField();
		textField_11.setText("               4");
		textField_11.setColumns(10);
		textField_11.setBounds(6, 38, 136, 62);
		panel_1_2.add(textField_11);
		
		JLabel lblNewLabel_2_2 = new JLabel("Total Courses");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setBounds(24, 10, 107, 16);
		panel_1_2.add(lblNewLabel_2_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(106, 90, 205));
		panel_1_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaptionBorder, null, null));
		panel_1_1_1.setBounds(108, 37, 148, 125);
		DashboardPanel.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Students");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(24, 6, 107, 16);
		panel_1_1_1.add(lblNewLabel_2);
		
		textField_9 = new JTextField();
		textField_9.setText("            1000");
		textField_9.setBounds(6, 34, 136, 62);
		panel_1_1_1.add(textField_9);
		textField_9.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(106, 90, 205));
		panel_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaptionBorder, null, null));
		panel_1_1.setBounds(360, 37, 148, 125);
		DashboardPanel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		textField_10 = new JTextField();
		textField_10.setText("              50");
		textField_10.setColumns(10);
		textField_10.setBounds(6, 37, 136, 62);
		panel_1_1.add(textField_10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Teachers");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(23, 9, 107, 16);
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_6 = new JLabel("Activity List");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(16, 243, 148, 33);
		DashboardPanel.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(106, 90, 205));
		panel_2.setBounds(16, 302, 891, 461);
		DashboardPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(870, 6, 15, 459);
		panel_2.add(scrollBar);
		

		JButton btnNewButton1 = new JButton("BSc (Hons) in Computer Science");
		btnNewButton1.setBounds(18, 236, 250, 43);
		btnNewButton1.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		panel_2.add(btnNewButton1);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("BSc (Hons) in International Business Management");
		btnNewButton_1.setBounds(240, 368, 399, 29);
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		panel_2.add(btnNewButton_1);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		JButton btnNewButton_2 = new JButton("International MBA");
		btnNewButton_2.setBounds(608, 236, 250, 43);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		panel_2.add(btnNewButton_2);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		JButton btnNewButton11 = new JButton("Our Courses");
		btnNewButton11.setBounds(254, 6, 360, 54);
		btnNewButton11.setForeground(new Color(0, 0, 128));
		btnNewButton11.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		panel_2.add(btnNewButton11);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBounds(308, 207, 255, 149);
		lblNewLabel1.setIcon(new ImageIcon(courses.class.getResource("/Images/Bussiness.jpeg")));
		panel_2.add(lblNewLabel1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(18, 87, 249, 149);
		lblNewLabel_1.setIcon(new ImageIcon(courses.class.getResource("/Images/Computer_1_299x169.jpg")));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBounds(609, 87, 249, 149);
		lblNewLabel_21.setIcon(new ImageIcon(courses.class.getResource("/Images/MBA_299x169.jpg")));
		panel_2.add(lblNewLabel_21);
	
		
		JPanel CoursePanel = new JPanel();
		CoursePanel.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Courses");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_11.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_11.setBounds(6, 6, 150, 39);
		CoursePanel.add(lblNewLabel_11);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBackground(SystemColor.windowBorder);
		panel_7_1.setBounds(619, 6, 181, 657);
		CoursePanel.add(panel_7_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Notifications");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_5_1.setBounds(6, 6, 169, 34);
		panel_7_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1_1_1_1 = new JLabel("TO DO LIST");
		lblNewLabel_6_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_6_1_1_1_1.setBounds(16, 287, 159, 47);
		panel_7_1.add(lblNewLabel_6_1_1_1_1);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_5.setBackground(SystemColor.windowBorder);
		panel_1_5.setBounds(16, 52, 159, 53);
		panel_7_1.add(panel_1_5);
		
		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setLayout(null);
		panel_1_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_3_1.setBackground(SystemColor.windowBorder);
		panel_1_3_1.setBounds(16, 117, 159, 53);
		panel_7_1.add(panel_1_3_1);
		
		JPanel panel_1_4_4 = new JPanel();
		panel_1_4_4.setLayout(null);
		panel_1_4_4.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_4.setBackground(SystemColor.windowBorder);
		panel_1_4_4.setBounds(16, 186, 159, 53);
		panel_7_1.add(panel_1_4_4);
		
		JPanel panel_1_4_1_1 = new JPanel();
		panel_1_4_1_1.setLayout(null);
		panel_1_4_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_1_1.setBackground(SystemColor.windowBorder);
		panel_1_4_1_1.setBounds(16, 346, 159, 53);
		panel_7_1.add(panel_1_4_1_1);
		
		JPanel panel_1_4_2_1 = new JPanel();
		panel_1_4_2_1.setLayout(null);
		panel_1_4_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_2_1.setBackground(SystemColor.windowBorder);
		panel_1_4_2_1.setBounds(16, 428, 159, 53);
		panel_7_1.add(panel_1_4_2_1);
		
		JPanel panel_1_4_3_1 = new JPanel();
		panel_1_4_3_1.setLayout(null);
		panel_1_4_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_3_1.setBackground(SystemColor.windowBorder);
		panel_1_4_3_1.setBounds(16, 504, 159, 53);
		panel_7_1.add(panel_1_4_3_1);
		
		textField = new JTextField();
		textField.setBounds(6, 43, 241, 42);
		CoursePanel.add(textField);
		textField.setColumns(10);
		
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	}