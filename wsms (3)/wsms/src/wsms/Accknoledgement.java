package wsms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Accknoledgement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Accknoledgement(String name,String quantity,String price,String brandnameout,String nameout) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200,600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(87, 47, 404, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 39, 384, 310);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel username = new JLabel("Username  :");
		username.setBounds(27, 69, 114, 23);
		username.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		panel_1.add(username);
		
		JLabel BrandName = new JLabel("Brand Name :");
		BrandName.setBounds(27, 106, 114, 23);
		BrandName.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		panel_1.add(BrandName);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Quantity Ordered :");
		lblNewLabel_1_2_1.setBounds(27, 139, 145, 23);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Each bottle Rs :");
		lblNewLabel_1_2_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(27, 172, 145, 23);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JLabel totalprice = new JLabel("Total Price :");
		totalprice.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		totalprice.setBounds(27, 205, 145, 23);
		panel_1.add(totalprice);
		
	
		
		JLabel lblNewLabel_1_2_1_2_1_1 = new JLabel("\"Save Water Save Life \"");
		lblNewLabel_1_2_1_2_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_2_1_2_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1_2_1_2_1_1.setBounds(97, 271, 173, 29);
		panel_1.add(lblNewLabel_1_2_1_2_1_1);
		
	
		
		JLabel Username = new JLabel(name);
		Username.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		Username.setBounds(156, 69, 114, 23);
		panel_1.add(Username);
		
		JLabel Brandname = new JLabel(brandnameout);
		Brandname.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		Brandname.setBounds(156, 106, 114, 23);
		panel_1.add(Brandname);
		
		JLabel orderquantity = new JLabel(quantity);
		orderquantity.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		orderquantity.setBounds(156, 139, 114, 23);
		panel_1.add(orderquantity);
		
		JLabel priceofeachbottle = new JLabel(price);
		priceofeachbottle.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		priceofeachbottle.setBounds(135, 172, 114, 23);
		panel_1.add(priceofeachbottle);
		
		JLabel total = new JLabel(Integer.toString(Integer.parseInt(quantity)*Integer.parseInt(price)));
		total.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		total.setBounds(117, 205, 114, 23);
		panel_1.add(total);
		
	
		
		JLabel lblNewLabel = new JLabel("ACKNOWLEGEMENT");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel.setBounds(110, 10, 195, 27);
		panel.add(lblNewLabel);
		Username.setText(name);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
		            	userInterface s=new userInterface(name);
		            	s.setVisible(true);
		            	dispose();
		            }
		            catch(Exception e1) {
		            	e1.printStackTrace();
		            }
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		btnNewButton.setBounds(66, 359, 112, 37);
		panel.add(btnNewButton);
		
		JButton btnExit = new JButton("exit");
		btnExit.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		btnExit.setBounds(188, 359, 112, 37);
		panel.add(btnExit);
	}

}
