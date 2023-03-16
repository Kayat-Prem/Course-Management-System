package Frontend;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.JButton;

public class ClassSchedule extends JFrame {

	private JPanel contentPane;
	private Container cardPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassSchedule frame = new ClassSchedule();
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
	public ClassSchedule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 140, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 

		
		JButton btnNewButton_3 = new JButton("Return Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDashboard cls = new StudentDashboard();
				dispose();
				cls.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 128));
		btnNewButton_3.setBounds(501, 529, 142, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Subject");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(118, 155, 84, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Class Type");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(620, 151, 102, 36);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Time");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(503, 151, 102, 36);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Teacher");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(746, 151, 102, 36);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("5CS019: Object Oriented Design and Programming");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(118, 206, 377, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Workshop");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(620, 206, 102, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("7Am - 9Am");
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(502, 206, 92, 16);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Raj Shrestha");
		lblNewLabel_11.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(746, 206, 102, 16);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_2 = new JButton("Class Schedule");
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnNewButton_2.setBounds(523, 18, 224, 51);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_41 = new JLabel("5CS021: Numerical Methods and Concurrency\n");
		lblNewLabel_41.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_41.setBounds(118, 234, 377, 16);
		contentPane.add(lblNewLabel_41);
		
		JButton btnUniversityId = new JButton("Second Year / Level 5");
		btnUniversityId.setHorizontalAlignment(SwingConstants.LEFT);
		btnUniversityId.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnUniversityId.setBounds(6, 6, 275, 44);
		contentPane.add(btnUniversityId);
		
		JLabel lblNewLabel_111 = new JLabel("5CS021: Numerical Methods and Concurrency\n");
		lblNewLabel_111.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_111.setBounds(118, 427, 377, 16);
		contentPane.add(lblNewLabel_111);
		
		JLabel lblNewLabel_12 = new JLabel("5CS021: Numerical Methods and Concurrency\n");
		lblNewLabel_12.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(118, 328, 377, 16);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_10_1 = new JLabel("Sunday");
		lblNewLabel_10_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_1.setBounds(17, 206, 61, 16);
		contentPane.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Day");
		lblNewLabel_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(17, 155, 38, 29);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("Monday");
		lblNewLabel_10_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_1_1.setBounds(17, 234, 61, 16);
		contentPane.add(lblNewLabel_10_1_1);
		
		JLabel lblNewLabel_10_1_2 = new JLabel("Tuesday");
		lblNewLabel_10_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_1_2.setBounds(17, 266, 61, 16);
		contentPane.add(lblNewLabel_10_1_2);
		
		JLabel lblNewLabel_10_1_3 = new JLabel("Wednesday");
		lblNewLabel_10_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_1_3.setBounds(17, 328, 89, 16);
		contentPane.add(lblNewLabel_10_1_3);
		
		JLabel lblNewLabel_10_1_4 = new JLabel("Thursday");
		lblNewLabel_10_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_1_4.setBounds(17, 391, 89, 16);
		contentPane.add(lblNewLabel_10_1_4);
		
		JLabel lblNewLabel_10_1_5 = new JLabel("Friday");
		lblNewLabel_10_1_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_1_5.setBounds(17, 427, 61, 16);
		contentPane.add(lblNewLabel_10_1_5);
		
		JLabel lblNewLabel_10_2 = new JLabel("7Am - 9Am");
		lblNewLabel_10_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_2.setBounds(502, 234, 92, 16);
		contentPane.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_3 = new JLabel("7Am - 9Am");
		lblNewLabel_10_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_3.setBounds(502, 266, 92, 16);
		contentPane.add(lblNewLabel_10_3);
		
		JLabel lblNewLabel_10_4 = new JLabel("10Am - 12Am");
		lblNewLabel_10_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_4.setBounds(502, 294, 103, 16);
		contentPane.add(lblNewLabel_10_4);
		
		JLabel lblNewLabel_10_5 = new JLabel("7Am - 9Am");
		lblNewLabel_10_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_5.setBounds(502, 329, 92, 16);
		contentPane.add(lblNewLabel_10_5);
		
		JLabel lblNewLabel_10_6 = new JLabel("7Am - 9Am");
		lblNewLabel_10_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_6.setBounds(502, 391, 92, 16);
		contentPane.add(lblNewLabel_10_6);
		
		JLabel lblNewLabel_9_1 = new JLabel("Workshop");
		lblNewLabel_9_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9_1.setBounds(620, 234, 102, 16);
		contentPane.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("Lecture");
		lblNewLabel_9_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9_2.setBounds(620, 266, 102, 16);
		contentPane.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("Lecture");
		lblNewLabel_9_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9_2_1.setBounds(620, 294, 102, 16);
		contentPane.add(lblNewLabel_9_2_1);
		
		JLabel lblNewLabel_9_2_2 = new JLabel("Lecture");
		lblNewLabel_9_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9_2_2.setBounds(620, 328, 102, 16);
		contentPane.add(lblNewLabel_9_2_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("5CS037: Concepts and Technology of AI\n");
		lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(118, 266, 377, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("5CS019: Object Oriented Design and Programming");
		lblNewLabel_8_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_8_1.setBounds(118, 295, 377, 16);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_10_4_1 = new JLabel("10Am - 12Am");
		lblNewLabel_10_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_4_1.setBounds(502, 362, 103, 16);
		contentPane.add(lblNewLabel_10_4_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("5CS037: Concepts and Technology of AI\n");
		lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(118, 363, 377, 16);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Tutorial");
		lblNewLabel_9_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9_1_1.setBounds(620, 363, 102, 16);
		contentPane.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_1_2 = new JLabel("Workshop");
		lblNewLabel_9_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9_1_2.setBounds(620, 428, 102, 16);
		contentPane.add(lblNewLabel_9_1_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("5CS019: Object Oriented Design and Programming");
		lblNewLabel_8_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_8_2.setBounds(118, 392, 377, 16);
		contentPane.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("Tutorial");
		lblNewLabel_9_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9_1_1_1.setBounds(620, 392, 102, 16);
		contentPane.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_1_1_2 = new JLabel("Tutorial");
		lblNewLabel_9_1_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9_1_1_2.setBounds(620, 455, 102, 16);
		contentPane.add(lblNewLabel_9_1_1_2);
		
		JLabel lblNewLabel_10_6_1 = new JLabel("7Am - 9Am");
		lblNewLabel_10_6_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_6_1.setBounds(502, 428, 92, 16);
		contentPane.add(lblNewLabel_10_6_1);
		
		JLabel lblNewLabel_10_4_1_1 = new JLabel("10Am - 12Am");
		lblNewLabel_10_4_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_10_4_1_1.setBounds(502, 455, 103, 16);
		contentPane.add(lblNewLabel_10_4_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("5CS037: Concepts and Technology of AI\n");
		lblNewLabel_3_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1.setBounds(118, 455, 377, 16);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_11_1 = new JLabel("Raj Shrestha");
		lblNewLabel_11_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_1.setBounds(746, 295, 102, 16);
		contentPane.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("Raj Shrestha");
		lblNewLabel_11_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_2.setBounds(746, 392, 102, 16);
		contentPane.add(lblNewLabel_11_2);
		
		JLabel lblNewLabel_11_3 = new JLabel("Basudeo Shrestha");
		lblNewLabel_11_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3.setBounds(746, 235, 142, 16);
		contentPane.add(lblNewLabel_11_3);
		
		JLabel lblNewLabel_11_3_1 = new JLabel("Basudeo Shrestha");
		lblNewLabel_11_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_1.setBounds(746, 329, 142, 16);
		contentPane.add(lblNewLabel_11_3_1);
		
		JLabel lblNewLabel_11_3_2 = new JLabel("Basudeo Shrestha");
		lblNewLabel_11_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_2.setBounds(746, 428, 142, 16);
		contentPane.add(lblNewLabel_11_3_2);
		
		JLabel lblNewLabel_11_3_3 = new JLabel("Rohit Parajuli");
		lblNewLabel_11_3_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_3.setBounds(746, 267, 142, 16);
		contentPane.add(lblNewLabel_11_3_3);
		
		JLabel lblNewLabel_11_3_4 = new JLabel("Rohit Parajuli");
		lblNewLabel_11_3_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_4.setBounds(746, 363, 142, 16);
		contentPane.add(lblNewLabel_11_3_4);
		
		JLabel lblNewLabel_11_3_5 = new JLabel("Rohit Parajuli");
		lblNewLabel_11_3_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_5.setBounds(746, 456, 142, 16);
		contentPane.add(lblNewLabel_11_3_5);
		
		JLabel lblNewLabel_7_1 = new JLabel("Class Room");
		lblNewLabel_7_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_7_1.setBounds(920, 148, 102, 36);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_11_3_6 = new JLabel("Lab-1");
		lblNewLabel_11_3_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_6.setBounds(919, 207, 142, 16);
		contentPane.add(lblNewLabel_11_3_6);
		
		JLabel lblNewLabel_11_3_7 = new JLabel("Lab-2");
		lblNewLabel_11_3_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_7.setBounds(920, 235, 142, 16);
		contentPane.add(lblNewLabel_11_3_7);
		
		JLabel lblNewLabel_11_3_8 = new JLabel("Lecture Hall-1");
		lblNewLabel_11_3_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_8.setBounds(919, 267, 142, 16);
		contentPane.add(lblNewLabel_11_3_8);
		
		JLabel lblNewLabel_11_3_9 = new JLabel("Lecture Hall-2");
		lblNewLabel_11_3_9.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_9.setBounds(920, 295, 142, 16);
		contentPane.add(lblNewLabel_11_3_9);
		
		JLabel lblNewLabel_11_3_10 = new JLabel("Lecture Hall-3");
		lblNewLabel_11_3_10.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_10.setBounds(920, 329, 142, 16);
		contentPane.add(lblNewLabel_11_3_10);
		
		JLabel lblNewLabel_11_3_11 = new JLabel("TR-1");
		lblNewLabel_11_3_11.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_11.setBounds(920, 363, 142, 16);
		contentPane.add(lblNewLabel_11_3_11);
		
		JLabel lblNewLabel_11_3_12 = new JLabel("TR-2");
		lblNewLabel_11_3_12.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_12.setBounds(919, 392, 142, 16);
		contentPane.add(lblNewLabel_11_3_12);
		
		JLabel lblNewLabel_11_3_13 = new JLabel("Lab-3");
		lblNewLabel_11_3_13.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_13.setBounds(919, 428, 142, 16);
		contentPane.add(lblNewLabel_11_3_13);
		
		JLabel lblNewLabel_11_3_14 = new JLabel("TR-3");
		lblNewLabel_11_3_14.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_11_3_14.setBounds(920, 456, 142, 16);
		contentPane.add(lblNewLabel_11_3_14);
		
	}
}
