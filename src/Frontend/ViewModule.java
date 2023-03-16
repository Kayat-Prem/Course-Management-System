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

public class ViewModule extends JFrame {

	private JPanel contentPane;
	private Container cardPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewModule frame = new ViewModule();
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
	public ViewModule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 

		
		JButton btnNewButton1 = new JButton("Year 1 / Level 4");
		btnNewButton1.setBounds(216, 366, 142, 29);
		contentPane.add(btnNewButton1);btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FirstYear FY=new FirstYear();
			dispose();
			FY.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Year 2 / Level 5");
		btnNewButton_1.setBounds(493, 366, 142, 29);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SecondYear SY = new SecondYear();
			dispose();
			SY.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Year 3 / Level 6");
		btnNewButton_2.setBounds(766, 366, 142, 29);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ThirdYear TY = new ThirdYear();
			dispose();
			TY.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.setForeground(new Color(0, 0, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				StudentDashboard back = new StudentDashboard();
				dispose();
//				back.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(493, 507, 142, 29);
		contentPane.add(btnNewButton_3);
		
		
		JButton btnNewButton = new JButton("Modules According to the Year");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnNewButton.setBounds(335, 87, 512, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewModule.class.getResource("/Images/icons8-knowledge-sharing-50.png")));
		lblNewLabel.setBounds(250, 290, 61, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewModule.class.getResource("/Images/icons8-knowledge-sharing-50.png")));
		lblNewLabel_1.setBounds(532, 290, 61, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ViewModule.class.getResource("/Images/icons8-knowledge-sharing-50.png")));
		lblNewLabel_2.setBounds(805, 290, 61, 64);
		contentPane.add(lblNewLabel_2);
	
		
	}
}
