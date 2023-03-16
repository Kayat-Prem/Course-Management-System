package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.CompoundBorder;

import java.awt.SystemColor;
import javax.swing.DropMode;

public class AdminDashboard {

	private JFrame frmAdminDashboard;
	private JSplitPane mainSplitPane;
	private JButton btnNewButton_1;
	private CardLayout cl_cardPanel = new CardLayout(0, 0);
	private JPanel cardPanel;
	private Component btnNewButton_3_111;
	private JMenu jMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public AdminDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminDashboard = new JFrame();
		frmAdminDashboard.setVisible(true);
		frmAdminDashboard.setForeground(new Color(0, 255, 0));
		frmAdminDashboard.setFont(new Font("Dialog", Font.BOLD, 20));
		frmAdminDashboard.setBackground(Color.LIGHT_GRAY);
		frmAdminDashboard.setTitle("Herald College Kathmandu    &    The University Partner ~  University of Wolverhampton\n");
		frmAdminDashboard.setBounds(100, 100, 1280, 814);
		mainSplitPane = new JSplitPane();
		mainSplitPane.setDividerSize(0);
		frmAdminDashboard.setContentPane(mainSplitPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(106, 90, 205));
		mainSplitPane.setLeftComponent(panel_1);

		btnNewButton_1 = new JButton("Course Admin");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_6884456073600");
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/admin.png")));
		
		JButton btnNewButton_2_1_1 = new JButton("Return to DASHBOARD");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainDashboard md = new MainDashboard();
				frmAdminDashboard.setVisible(false);
				md.setVisible(true);
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(80, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(58))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2_1_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(39)
					.addComponent(btnNewButton_2_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(346))
		);
		panel_1.setLayout(gl_panel_1);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainSplitPane.setRightComponent(splitPane);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		splitPane.setLeftComponent(panel);
		
		cardPanel = new JPanel();
		splitPane.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);
		
		
		JPanel CourseAdminPanel = new JPanel();
		CourseAdminPanel.setBackground(new Color(192, 192, 192));
		cardPanel.add(CourseAdminPanel, "name_6884456073600");
		SpringLayout sl_CourseAdminPanel = new SpringLayout();
		CourseAdminPanel.setLayout(sl_CourseAdminPanel);
		
		JButton btnNewButton_5 = new JButton("Course-Admin View");
		sl_CourseAdminPanel.putConstraint(SpringLayout.NORTH, btnNewButton_5, 44, SpringLayout.NORTH, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, btnNewButton_5, 337, SpringLayout.WEST, CourseAdminPanel);
		btnNewButton_5.setForeground(new Color(0, 0, 255));
		btnNewButton_5.setBackground(new Color(0, 255, 0));
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CourseAdminPanel.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Courses");
		btnNewButton_3.setBackground(Color.BLUE);
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, btnNewButton_3, 153, SpringLayout.WEST, CourseAdminPanel);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courses c =new courses();
				frmAdminDashboard.setVisible(false);
				c.setVisible(true);
			}
		});
		CourseAdminPanel.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("Set Exam");
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, btnNewButton_7, 434, SpringLayout.WEST, CourseAdminPanel);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetExam SE=new SetExam();
				frmAdminDashboard.setVisible(false);
				SE.setVisible(true);
			}
		});
		CourseAdminPanel.add(btnNewButton_7);
		
		JLabel lblNewLabel_1 = new JLabel("");
		sl_CourseAdminPanel.putConstraint(SpringLayout.NORTH, btnNewButton_3, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 204, SpringLayout.WEST, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -520, SpringLayout.SOUTH, CourseAdminPanel);
		lblNewLabel_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/courses.png")));
		CourseAdminPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_CourseAdminPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 745, SpringLayout.WEST, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -520, SpringLayout.SOUTH, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, lblNewLabel_2, -205, SpringLayout.EAST, CourseAdminPanel);
		lblNewLabel_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/report.png")));
		CourseAdminPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -393, SpringLayout.SOUTH, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.NORTH, btnNewButton_7, 6, SpringLayout.SOUTH, lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/icons8-exam-64.png")));
		CourseAdminPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -119, SpringLayout.NORTH, lblNewLabel_3);
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/teacher.png")));
		CourseAdminPanel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("EXIT");
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_7, -204, SpringLayout.NORTH, btnNewButton);
		sl_CourseAdminPanel.putConstraint(SpringLayout.NORTH, btnNewButton, 642, SpringLayout.NORTH, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, btnNewButton, 452, SpringLayout.WEST, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, btnNewButton, -76, SpringLayout.SOUTH, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, btnNewButton, -442, SpringLayout.EAST, CourseAdminPanel);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(106, 90, 205));
		CourseAdminPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, btnNewButton_7, -141, SpringLayout.WEST, lblNewLabel_5);
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 477, SpringLayout.EAST, lblNewLabel_3);
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Images/icons8-ours-48.png")));
		CourseAdminPanel.add(lblNewLabel_5);
     
		
		JButton btnNewButton_9 = new JButton("Publish Result");
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, lblNewLabel_4, -132, SpringLayout.WEST, btnNewButton_9);
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, btnNewButton_3, -365, SpringLayout.WEST, btnNewButton_9);
		sl_CourseAdminPanel.putConstraint(SpringLayout.NORTH, btnNewButton_9, 0, SpringLayout.NORTH, btnNewButton_3);
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_9, 0, SpringLayout.SOUTH, btnNewButton_3);
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, btnNewButton_9, 682, SpringLayout.WEST, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, btnNewButton_9, -165, SpringLayout.EAST, CourseAdminPanel);
		CourseAdminPanel.add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				publishResult pr = new publishResult();
				frmAdminDashboard.setVisible(false);
				pr.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("View Students List");
		sl_CourseAdminPanel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 502, SpringLayout.NORTH, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -216, SpringLayout.SOUTH, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, btnNewButton_2, -165, SpringLayout.EAST, CourseAdminPanel);
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -6, SpringLayout.NORTH, btnNewButton_2);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		CourseAdminPanel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsList SL = new StudentsList();
				frmAdminDashboard.setVisible(false);
				SL.setVisible(true);
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("View Teachers List");
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, btnNewButton_2, 319, SpringLayout.EAST, btnNewButton_2_1);
		sl_CourseAdminPanel.putConstraint(SpringLayout.EAST, btnNewButton_2_1, 187, SpringLayout.WEST, btnNewButton_3);
		sl_CourseAdminPanel.putConstraint(SpringLayout.WEST, btnNewButton_2_1, 0, SpringLayout.WEST, btnNewButton_3);
		sl_CourseAdminPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_2_1, 0, SpringLayout.SOUTH, btnNewButton_2);
		sl_CourseAdminPanel.putConstraint(SpringLayout.NORTH, btnNewButton_2_1, 6, SpringLayout.SOUTH, lblNewLabel_3);
		btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		CourseAdminPanel.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersList tl = new TeachersList();
				frmAdminDashboard.setVisible(false);
				tl.setVisible(true);
			}
		});
		
		    
		frmAdminDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
