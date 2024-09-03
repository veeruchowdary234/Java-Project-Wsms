package wsms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainInterface frame = new mainInterface();
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
	public mainInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200,600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 27, 545, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WATER SUPLY MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(92, 10, 364, 34);
		panel.add(lblNewLabel);
		
		JRadioButton AdminLogin = new JRadioButton("ADMIN LOGIN\r\n");
		AdminLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		AdminLogin.setBounds(197, 143, 214, 29);
		contentPane.add(AdminLogin);
		
		JRadioButton UserLogin = new JRadioButton("USER LOGIN");
		UserLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		UserLogin.setBounds(197, 194, 230, 29);
		contentPane.add(UserLogin);
		
		JRadioButton UserRegistration = new JRadioButton("USER REGISTRATION");
		UserRegistration.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		UserRegistration.setBounds(197, 241, 167, 34);
		contentPane.add(UserRegistration);
		
		JRadioButton ReportUs = new JRadioButton("REPORT US");
		ReportUs.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		ReportUs.setBounds(197, 293, 214, 34);
		contentPane.add(ReportUs);
		
		JButton exit = new JButton("EXIT\r\n");
		exit.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		exit.setBounds(138, 360, 113, 34);
		contentPane.add(exit);
		ButtonGroup s=new ButtonGroup();
		s.add(AdminLogin);
		s.add(UserRegistration);
		s.add(UserLogin);
		s.add(ReportUs);
		
		
		JButton submit = new JButton("SUBMIT\r\n");
		submit.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdminLogin.isSelected()) {
					try {
						AdminLogin s=new AdminLogin();
						s.setVisible(true);
						dispose();
					}
					catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
					
				}
				if(UserLogin.isSelected()) {
					try {
						UserLogin s=new UserLogin();
						s.setVisible(true);
						dispose();
					}
					catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				if(UserRegistration.isSelected()) {
					try {
						UserRegistration s=new UserRegistration();
						s.setVisible(true);
						dispose();
					}
					catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				if(ReportUs.isSelected()) {
					try {
						ReportUs s=new ReportUs();
						s.setVisible(true);
						dispose();
					}
					catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				
			}
		});
		submit.setBounds(273, 360, 126, 34);
		contentPane.add(submit);

		
		JLabel lblNewLabel_1 = new JLabel("DONE BY ARJUN AND HIS GROUP ");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(346, 441, 240, 22);
		contentPane.add(lblNewLabel_1);
	}
}
