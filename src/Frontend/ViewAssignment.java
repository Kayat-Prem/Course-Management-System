package Frontend;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;

import java.io.File;
import javax.swing.JFileChooser;

public class ViewAssignment extends JFrame {
	JButton btnNewButton;
	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	private File selectedFile;


	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAssignment frame = new ViewAssignment();
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
	
	public ViewAssignment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 853);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
			Statement statement = connection.createStatement();
			String selectQuery = "SELECT * FROM `Assignment`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
			
			String[][] data = null;
			try {
			      rs.last();
			      int rowCount = rs.getRow();
			      rs.beforeFirst();
			      data = new String[rowCount][6];
			      int i = 0;
			      while (rs.next()) {
			        data[i][0] = rs.getString("Course");
			        data[i][1] = rs.getString("Module");
			        data[i][2] = rs.getString("Day");
			        data[i][3] = rs.getString("Due Date");
			        data[i][4] = rs.getString("Time");
			        data[i][5] = rs.getString("Description");
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
			String[] columnNames = {"Course", "Module", "Day", "Due Date", "Time", "Description"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
		    
		    // Table Created
		    JTable table = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBackground(new Color(192, 192, 192));
			scrollPane.setBounds(19, 145, 1243, 282);
			contentPane.add(scrollPane);

		
			table.setBackground(new Color(192, 192, 192));
	
			
			JButton open = new JButton("Open File");
			open.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			open.setBounds(524, 491, 133, 43);
			contentPane.add(open);
			open.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
				        JFileChooser fileChooser = new JFileChooser();
				        int returnValue = fileChooser.showOpenDialog(null);
				        if (returnValue == JFileChooser.APPROVE_OPTION) {
				          selectedFile = fileChooser.getSelectedFile();
				        }
				      }
				    });	
			
			JButton submit = new JButton("SUBMIT FILE");
			submit.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			submit.setBounds(804, 491, 153, 43);
			contentPane.add(submit);
			submit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (selectedFile == null) {
				          JOptionPane.showMessageDialog(null, "Please select a file first.");
				        } else {
				          JOptionPane.showMessageDialog(null, "Submitting file: " + selectedFile.getName());
				          
				    
//				          InstructorDashboard st = new InstructorDashboard();
//				          st.setVisible(true);
//				          setVisible(false);
				        }	
				}
			});
			
			
			JButton btnNewButton_2 = new JButton("EXIT");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2.setForeground(new Color(0, 0, 255));
			btnNewButton_2.setBounds(678, 589, 117, 33);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("ASSIGNMENT UPDATE");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(563, 12, 335, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO STUDENT DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(19, 18, 409, 33);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					StudentDashboard iddd= new StudentDashboard();
					dispose();
					iddd.setVisible(true);
				}
			});
			
		
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	class NextJFrame extends JFrame {
		  private static final long serialVersionUID = 1L;
		  private File submittedFile;

		  public NextJFrame(File file) {
		    this.submittedFile = file;
		    JOptionPane.showMessageDialog(null, "Submitting file: " + submittedFile.getName());
		  }
		}
	
	
	public void addActionListener1() {
		btnNewButton.addActionListener((ActionListener) this);
    }
}
