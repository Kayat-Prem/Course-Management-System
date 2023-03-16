package Frontend;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThirdYear extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThirdYear frame = new ThirdYear();
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
	public ThirdYear() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Third Year / Level 6 Modules");
		btnNewButton.setBounds(186, 19, 296, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("6CS007: Project and Professionalism (20 Credit)");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(131, 213, 604, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("6CS030: Big Data (20 Credit)");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(131, 151, 564, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("6CS005: High Performance Computing (20 Credit)");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(131, 180, 554, 29);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("5th Semester");
		btnNewButton_1.setBounds(55, 110, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("6th Semester");
		btnNewButton_1_1.setBounds(55, 254, 117, 29);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("6CS012: Artificial Intelligence and Machine Learning (20 Credit)");
		lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(131, 295, 564, 29);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("6CS014: Complex System (20 Credit)");
		lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(131, 325, 564, 29);
		contentPane.add(lblNewLabel_2_3);
		
		JButton btnNewButton_1_1_1 = new JButton("Return");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewModule FYB = new ViewModule();
				dispose();
				FYB.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setBounds(317, 427, 117, 29);
		contentPane.add(btnNewButton_1_1_1);
	}
}
