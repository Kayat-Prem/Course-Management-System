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
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class courses extends JFrame {

	private JPanel contentPane;
	private Container cardPanel;

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
		btnNewButton_1.setBounds(445, 536, 427, 43);
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
		btnNewButton_3.setBounds(598, 656, 142, 35);
		contentPane.add(btnNewButton_3);
		
		
		JButton btnNewButton = new JButton("Our Courses");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		btnNewButton.setBounds(464, 6, 360, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(courses.class.getResource("/Images/Bussiness.jpeg")));
		lblNewLabel.setBounds(509, 355, 299, 169);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(courses.class.getResource("/Images/Computer_1_299x169.jpg")));
		lblNewLabel_1.setBounds(137, 124, 299, 169);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(courses.class.getResource("/Images/MBA_299x169.jpg")));
		lblNewLabel_2.setBounds(859, 124, 299, 169);
		contentPane.add(lblNewLabel_2);
	
		
	}
}
