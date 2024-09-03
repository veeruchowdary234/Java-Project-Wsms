package wsms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ReportUs extends JFrame {

	private JPanel contentPane;
	private JTextField Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportUs frame = new ReportUs();
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
	public ReportUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200,600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 566, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 116, 521, 246);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea ReportedArea = new JTextArea();
		ReportedArea.setText("Enter Issue");
		ReportedArea.setBounds(20, 44, 475, 180);
		panel_1.add(ReportedArea);
		
		JLabel lblNewLabel_2 = new JLabel("Name of Issue Reporter");
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 10, 175, 24);
		panel_1.add(lblNewLabel_2);
		
		Name = new JTextField();
		Name.setBounds(232, 10, 224, 24);
		panel_1.add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("REPORT US");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_1.setBounds(210, 10, 159, 52);
		panel.add(lblNewLabel_1);
		
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
		back.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		back.setBounds(72, 384, 143, 38);
		panel.add(back);
		
		JButton submit = new JButton("submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message=ReportedArea.getText();
				try {
					File d=new File("E:\\eclipse\\wsms\\src\\wsms\\ReportedIssues");
					FileWriter s=new FileWriter(d,true);
					BufferedWriter sd=new BufferedWriter(s);
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
					Date date = new Date();   
					sd.write("{"+"\n");
					sd.write(formatter.format(date)+"\n"); 
					sd.write(Name.getText()+"\n");
					sd.write(message);
					sd.write("\n");
					sd.write("}"+"\n");
					System.out.print(message);
					sd.close();
					
				}
				 
				catch(Exception e1) {
					e1.printStackTrace();
				}
	            JOptionPane.showMessageDialog(null, "Report submitted go back to main menu !");
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
		submit.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		submit.setBounds(295, 384, 143, 38);
		panel.add(submit);
		
		JLabel lblNewLabel = new JLabel("REPORT US ");
		lblNewLabel.setBounds(195, 10, 473, 42);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
	}

}
