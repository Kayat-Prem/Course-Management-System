package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
import javax.swing.JToolBar;
import javax.swing.JScrollPane;

public class StudentDashboard {

	private JFrame frmStudentDashboard;
	private JSplitPane mainSplitPane;
	private JButton btnNewButton;
	private CardLayout cl_cardPanel = new CardLayout(0, 0);
	private JPanel cardPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard window = new StudentDashboard();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentDashboard = new JFrame();
		frmStudentDashboard.setVisible(true);
		frmStudentDashboard.setForeground(new Color(0, 255, 0));
		frmStudentDashboard.setFont(new Font("Dialog", Font.BOLD, 20));
		frmStudentDashboard.setBackground(Color.LIGHT_GRAY);
		frmStudentDashboard.setTitle("Herald College Kathmandu    &    The University Partner ~  University of Wolverhampton\n");
		frmStudentDashboard.setBounds(100, 100, 1198, 718);
		mainSplitPane = new JSplitPane();
		mainSplitPane.setDividerSize(0);
		frmStudentDashboard.setContentPane(mainSplitPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(106, 90, 205));
		mainSplitPane.setLeftComponent(panel_1);

		btnNewButton = new JButton("Student");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_6865940377300");
			
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StudentDashboard.class.getResource("/Images/Student.png")));
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(259)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(222, Short.MAX_VALUE))
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
		
		JPanel StudentPanel = new JPanel();
		StudentPanel.setBackground(new Color(192, 192, 192));
		cardPanel.add(StudentPanel, "name_6865940377300");
		StudentPanel.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Student View");
		btnNewButton_4.setBounds(327, 27, 302, 39);
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		StudentPanel.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(106, 90, 205));
		panel_2.setBounds(109, 164, 774, 430);
		StudentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_3_11 = new JButton("Check Assignment");
		btnNewButton_3_11.setBounds(471, 138, 179, 50);
		panel_2.add(btnNewButton_3_11);
		btnNewButton_3_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAssignment VA=new ViewAssignment();
				frmStudentDashboard.setVisible(false);
				VA.setVisible(true);
			}
		});
		btnNewButton_3_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(526, 62, 64, 64);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(StudentDashboard.class.getResource("/Images/assignment.png")));
		
		
		JButton btnNewButton_3_11_1 = new JButton("Modules");
		btnNewButton_3_11_1.setBounds(127, 138, 179, 50);
		panel_2.add(btnNewButton_3_11_1);
		btnNewButton_3_11_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewModule vm=new ViewModule();
				frmStudentDashboard.setVisible(false);
				vm.setVisible(true);
			}
		});
		btnNewButton_3_11_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(181, 76, 62, 50);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(StudentDashboard.class.getResource("/Images/module.png")));
		
		
		JButton btnNewButton_3_11_1_1 = new JButton("View Result");
		btnNewButton_3_11_1_1.setBounds(137, 306, 181, 50);
		panel_2.add(btnNewButton_3_11_1_1);
		btnNewButton_3_11_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewReport vr = new ViewReport();
				frmStudentDashboard.setVisible(false);
				vr.setVisible(true);
			}
		});
		btnNewButton_3_11_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(194, 220, 72, 74);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(StudentDashboard.class.getResource("/Images/report.png")));
		
		JButton btnNewButton_3_11_1_1_1 = new JButton("Class Schedule\n");
		btnNewButton_3_11_1_1_1.setBounds(471, 306, 179, 50);
		panel_2.add(btnNewButton_3_11_1_1_1);
		btnNewButton_3_11_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassSchedule CS = new ClassSchedule();
				frmStudentDashboard.setVisible(false);
				CS.setVisible(true);
			}
		});
		btnNewButton_3_11_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(540, 247, 50, 50);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(StudentDashboard.class.getResource("/Images/class.png")));
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setBounds(442, 618, 117, 39);
		StudentPanel.add(btnNewButton_2);

		frmStudentDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
