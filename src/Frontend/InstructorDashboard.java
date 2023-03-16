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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RootPaneContainer;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

public class InstructorDashboard {

	protected static final Window frameToClose = null;
	private JFrame frmInstructorDashboard;
	private JSplitPane mainSplitPane;
	private JButton btnNewButton_2;
	private CardLayout cl_cardPanel = new CardLayout(0, 0);
	private JPanel cardPanel;
	private Component btnNewButton_3_111;
	private Object button_exit;
	private static String itemNameFromComboxBox ="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorDashboard window = new InstructorDashboard();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InstructorDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInstructorDashboard = new JFrame();
		frmInstructorDashboard.setVisible(true);
		frmInstructorDashboard.setForeground(new Color(0, 255, 0));
		frmInstructorDashboard.setFont(new Font("Dialog", Font.BOLD, 20));
		frmInstructorDashboard.setBackground(Color.LIGHT_GRAY);
		frmInstructorDashboard.setTitle("Herald College Kathmandu    &    The University Partner ~  University of Wolverhampton\n");
		frmInstructorDashboard.setBounds(100, 100, 1280, 852);
		mainSplitPane = new JSplitPane();
		mainSplitPane.setDividerSize(0);
		frmInstructorDashboard.setContentPane(mainSplitPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(106, 90, 205));
		mainSplitPane.setLeftComponent(panel_1);

		btnNewButton_2 = new JButton("Instructor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_6885489673700");
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/Images/instructor.png")));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(21)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(258, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(365))
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
		
		JPanel InstructorPanel = new JPanel();
		InstructorPanel.setBackground(new Color(192, 192, 192));
		cardPanel.add(InstructorPanel, "name_6885489673700");
		SpringLayout sl_InstructorPanel = new SpringLayout();
		InstructorPanel.setLayout(sl_InstructorPanel);
		
		JButton btnNewButton_6 = new JButton("Instructor View");
		sl_InstructorPanel.putConstraint(SpringLayout.NORTH, btnNewButton_6, 10, SpringLayout.NORTH, InstructorPanel);
		sl_InstructorPanel.putConstraint(SpringLayout.WEST, btnNewButton_6, 399, SpringLayout.WEST, InstructorPanel);
		sl_InstructorPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_6, -714, SpringLayout.SOUTH, InstructorPanel);
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnNewButton_6.setForeground(new Color(0, 0, 255));
		btnNewButton_6.setBackground(new Color(0, 255, 0));
		
		InstructorPanel.add(btnNewButton_6);
		
		JPanel panel_2 = new JPanel();
		sl_InstructorPanel.putConstraint(SpringLayout.NORTH, panel_2, 100, SpringLayout.SOUTH, btnNewButton_6);
		sl_InstructorPanel.putConstraint(SpringLayout.WEST, panel_2, 115, SpringLayout.WEST, InstructorPanel);
		sl_InstructorPanel.putConstraint(SpringLayout.SOUTH, panel_2, 475, SpringLayout.SOUTH, btnNewButton_6);
		sl_InstructorPanel.putConstraint(SpringLayout.EAST, panel_2, -112, SpringLayout.EAST, InstructorPanel);
		panel_2.setBackground(new Color(106, 90, 205));
		InstructorPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(117, 157, 48, 48);
		sl_InstructorPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 80, SpringLayout.NORTH, panel_2);
		sl_InstructorPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 33, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/Images/icons8-ours-48.png")));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(368, 141, 64, 64);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/Images/assignment.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(623, 155, 50, 50);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/Images/icons8-add-properties-50.png")));
		sl_InstructorPanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -245, SpringLayout.WEST, lblNewLabel_2);
		
		
		JButton btnStudents = new JButton("Students List");
		btnStudents.setBackground(new Color(0, 0, 255));
		btnStudents.setBounds(85, 217, 117, 45);
		panel_2.add(btnStudents);
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentsList ss = new ViewStudentsList();
				frmInstructorDashboard.setVisible(false);
				ss.setVisible(true);
			}
		});
		
		JButton btnStudents_1 = new JButton("Add Assignments");
		btnStudents_1.setBounds(324, 217, 144, 45);
		panel_2.add(btnStudents_1);
		btnStudents_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAssignment aa = new AddAssignment();
				frmInstructorDashboard.setVisible(false);
				aa.setVisible(true);
			}
		});
		
		JButton btnStudents_2 = new JButton("Add Marks");
		btnStudents_2.setBounds(587, 217, 117, 45);
		panel_2.add(btnStudents_2);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInstructorDashboard.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnNewButton_1.setForeground(new Color(106, 90, 205));
		sl_InstructorPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 42, SpringLayout.SOUTH, panel_2);
		sl_InstructorPanel.putConstraint(SpringLayout.EAST, btnNewButton_1, -443, SpringLayout.EAST, InstructorPanel);
		InstructorPanel.add(btnNewButton_1);
		btnStudents_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMarks aa = new AddMarks();
				frmInstructorDashboard.setVisible(false);
				aa.setVisible(true);
			}
		});
		

		frmInstructorDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		
	}
}
