package wsms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200,600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(99, 69, 396, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN ");
		lblNewLabel.setBounds(138, 0, 185, 31);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 40, 376, 163);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 27, 99, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_2.setBounds(51, 91, 99, 30);
		panel_1.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(160, 27, 165, 30);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(160, 91, 165, 30);
		panel_1.add(password);
		
		JButton submit = new JButton("submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkUser f;
				try {
					f = new checkUser(new File("E:\\eclipse\\wsms\\src\\wsms\\Admins"),username.getText(),new String(password.getPassword()));
					if(f.allowOrNot()) {
						adminInterface fg=new adminInterface();
						fg.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect password retry!");
						username.setText("");
						password.setText("");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		submit.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		submit.setBounds(216, 213, 113, 39);
		panel.add(submit);
		
		JButton back = new JButton("back");
		back.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainInterface s=new mainInterface();
					s.setVisible(true);
					dispose();
				}
				catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		back.setBounds(51, 213, 113, 39);
		panel.add(back);
	}
}
