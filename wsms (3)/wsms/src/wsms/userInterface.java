package wsms;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.spec.ECFieldF2m;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class userInterface extends JFrame {

	private static String Nameout;
	private JPanel contentPane;
	private JTextField brandname;
	int quantitycount=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInterface frame = new userInterface("pandurangasai");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	 static void pushData(String onprice,String quantity,String username) throws IOException {
		  File s=new File("E:\\eclipse\\wsms\\src\\wsms\\UsersDetails");
		  String result="";
	      Scanner sc = new Scanner(s);
	      StringBuffer buffer = new StringBuffer();
	      while (sc.hasNextLine()) {
	    	 String sd= sc.nextLine();
	    	 if(sd.contains(username)) {
	    		result=sd;
	    	 }
	         buffer.append(sd+System.lineSeparator());
	      }
	      String fileContents = buffer.toString();
	      sc.close();
	      String oldLine =result;
	      System.out.println(oldLine);
	      String [] arfs=oldLine.split(" ");
	      System.out.println(oldLine);
	     String newLine =arfs[0]+" "+arfs[1]+" "+arfs[2]+" "+Integer.parseInt(arfs[1])+Integer.parseInt(quantity)+" "+Integer.parseInt(onprice)*Integer.parseInt(quantity) ;
	      Nameout=arfs[0];
		fileContents = fileContents.replaceAll(oldLine, newLine);
	      FileWriter writer = new FileWriter(s);
	      System.out.println("");
	      System.out.println("new data: "+fileContents);
	      writer.append(fileContents);
	      writer.flush();
		  
	  }
		String Price;
		String Quantity;
	public userInterface(String username) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200,600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 24, 566, 429);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 33, 546, 324);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Wellcome "+username);
		lblNewLabel_1.setBounds(35, 22, 360, 33);
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Order waterbottles (each water bottle is 1 ltr)");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(35, 65, 360, 33);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("water bottle brand :");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(35, 103, 132, 33);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Quantity (1ltr)");
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(35, 151, 94, 33);
		panel_1.add(lblNewLabel_1_1_2);
		JLabel quantity = new JLabel("");
		
		JButton decrease = new JButton("-");
		decrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(quantitycount!=0) {
					quantitycount=quantitycount-1;
					quantity.setText(""+quantitycount);
				}
				
			
			}
		});
		decrease.setFont(new Font("Segoe UI Variable", Font.BOLD, 18));
		decrease.setBounds(139, 151, 42, 33);
		panel_1.add(decrease);
		

		quantity.setBackground(new Color(255, 255, 255));
		quantity.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		quantity.setBounds(194, 151, 34, 33);
		panel_1.add(quantity);
		
		JButton increase = new JButton("+");
		increase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantitycount=quantitycount+1;
				quantity.setText(""+quantitycount);
			}
		});
		increase.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		increase.setBounds(233, 151, 42, 33);
		panel_1.add(increase);

		JButton addtobasket = new JButton("ADD BASKET\r\n");
		addtobasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String onprice="";
		        try
		        {
		        	boolean flag=false;
		            File f1 = new File("E:\\eclipse\\wsms\\src\\wsms\\stockDetails");
		            FileReader fr = new FileReader(f1);
		            try (BufferedReader br = new BufferedReader(fr); FileWriter fw = new FileWriter(f1,true);BufferedWriter out = new BufferedWriter(fw);) {
						String line=null;
						while ((line = br.readLine() )!= null)
						{
							flag=true;
							String str[]=line.split(" ");
						    if (line.contains(brandname.getText())) {
						    	String tr=str[0]+" "+(Integer.parseInt(str[1])-Integer.parseInt(quantity.getText()))+" "+(Integer.parseInt(str[2])-Integer.parseInt(quantity.getText()))+" "+brandname.getText()+" "+str[4];
						        out.write("\n"+tr);
						        onprice=str[4];
						        Price=str[4];
						        Quantity=quantity.getText();
						    }
						}
					}
		        }
		        catch (Exception ex)
		        {
		            ex.printStackTrace();
		        }
		        try {
					pushData(onprice,quantity.getText(),username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		addtobasket.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		addtobasket.setBounds(35, 213, 123, 33);
		panel_1.add(addtobasket);
		
		brandname = new JTextField();
		brandname.setBounds(174, 108, 193, 28);
		panel_1.add(brandname);
		brandname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ORDER WATER BOTTLES");
		lblNewLabel.setBounds(160, 0, 362, 37);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		
		JButton order = new JButton("ORDER");
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accknoledgement s=new Accknoledgement(username,Quantity,Price,brandname.getText(),Nameout);
				s.setVisible(true);
				dispose();
				
			}
		});
		order.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		order.setBounds(437, 367, 103, 42);
		panel.add(order);
		
		JButton back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin s=new UserLogin();
				s.setVisible(true);
				dispose();
			}
		});
		back.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		back.setBounds(311, 367, 103, 42);
		panel.add(back);
	}
}
