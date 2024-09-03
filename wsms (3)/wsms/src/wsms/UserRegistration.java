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
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class UserRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
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
	public UserRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200,600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(38, 21, 508, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 66, 488, 306);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel re = new JLabel("Name");
		re.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		re.setBounds(77, 35, 105, 24);
		panel_1.add(re);
		
		JLabel lblNewLabel_2 = new JLabel("UserName");
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_2.setBounds(77, 80, 105, 24);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_3.setBounds(77, 125, 105, 24);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Address");
		lblNewLabel_3_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(77, 186, 105, 24);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Phone no");
		lblNewLabel_3_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(77, 246, 105, 24);
		panel_1.add(lblNewLabel_3_2);
		
		name = new JTextField();
		name.setBounds(197, 35, 207, 29);
		panel_1.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(197, 75, 207, 29);
		panel_1.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(197, 120, 207, 29);
		panel_1.add(password);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(197, 241, 207, 29);
		panel_1.add(phone);
		
		JTextArea address = new JTextArea();
		address.setBounds(197, 168, 207, 63);
		panel_1.add(address);
		
		JLabel lblNewLabel = new JLabel("NEW USER REGISTRATION");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(133, 10, 254, 46);
		panel.add(lblNewLabel);
		
		JButton back = new JButton("back");
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
		back.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		back.setBounds(96, 382, 116, 40);
		panel.add(back);
		
		JButton submit = new JButton("submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataLineForpurchase=name.getText()+" "+username.getText()+" "+phone.getText()+" "+0+" "+0;
				String userCreate=username.getText()+" "+password.getText();
				String Address="\n"+username.getText()+" {"+address.getText()+"}\n";	
				try {
					File d=new File("E:\\eclipse\\wsms\\src\\wsms\\UsersDetails");
					FileWriter s=new FileWriter(d,true);
					BufferedWriter sd=new BufferedWriter(s);
			 
					sd.write(dataLineForpurchase);
					sd.write("\n");
					System.out.print(dataLineForpurchase);
					sd.close();
					
				}
				catch(Exception e1) {
					e1.printStackTrace()
;				}
				try {
					File d=new File("E:\\eclipse\\wsms\\src\\wsms\\Users");
					FileWriter s=new FileWriter(d,true);
					BufferedWriter sd=new BufferedWriter(s);
					sd.write("\n");
					sd.write(userCreate);
					sd.write("\n");
					System.out.print(userCreate);
					sd.close();
				}
				catch(Exception e1) {
					e1.printStackTrace()
;				}
				try {
					File d=new File("E:\\eclipse\\wsms\\src\\wsms\\UserAddress");
					FileWriter s=new FileWriter(d,true);
					BufferedWriter sd=new BufferedWriter(s);
					sd.write(Address);
					System.out.print(Address);
					sd.close();
					
				}
				catch(Exception e1) {
					e1.printStackTrace()
;				}
	            JOptionPane.showMessageDialog(null, "Data saved user created Seccessfully !");
	            try {
	            	mainInterface s=new mainInterface();
	            	s.setVisible(true);
	            	dispose();
	            	
	            }
	            catch(Exception e1) {
	            	e1.printStackTrace();
	            }

				
				
			}
		});
		submit.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		submit.setBounds(290, 382, 116, 40);
		panel.add(submit);
	}
}
