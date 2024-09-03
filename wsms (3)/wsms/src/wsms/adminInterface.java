package wsms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class adminInterface extends JFrame {

  private JPanel contentPane;
  private JTextField agencyname;
  private JTextField netquantity;
  private JTextField bottleunits;
  private JTextField brandname;
  private JTextField priceof;
  int total_bottles = 0;
  int total_ltrs = 0;
  public static void main(String[] args) throws Exception {
    adminInterface s = new adminInterface();
    s.setVisible(true);

  }
 
  static String [] findprice() throws IOException {
	  BufferedReader s=new BufferedReader(new FileReader("E:\\eclipse\\wsms\\src\\wsms\\stockDetails"));
	  String str;
	  Integer net=0;
	  Integer units=0;
	  while((str=s.readLine()) != null) {
		  String stre[]=str.split(" ");
		  net+=Integer.parseInt(stre[1]);
		  units+=Integer.parseInt(stre[2]);
	  }
	  String sre[]=new String[2];
	  sre[0]=net.toString();
	  sre[1]=units.toString();
	  
	return sre ;
  }
  public adminInterface() throws Exception {
	  

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(450, 200, 600, 500);
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
    panel_1.setBounds(29, 39, 507, 342);
    panel.add(panel_1);
    panel_1.setLayout(null);

    JLabel lblNewLabel_1 = new JLabel("Agency Name ");
    lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
    lblNewLabel_1.setBounds(49, 25, 98, 32);
    panel_1.add(lblNewLabel_1);

    JLabel lblNewLabel_1_1 = new JLabel("Net Quantity(Ltrs)");
    lblNewLabel_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
    lblNewLabel_1_1.setBounds(49, 71, 138, 32);
    panel_1.add(lblNewLabel_1_1);

    JLabel lblNewLabel_1_1_1 = new JLabel("Bottle Units");
    lblNewLabel_1_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
    lblNewLabel_1_1_1.setBounds(49, 113, 98, 32);
    panel_1.add(lblNewLabel_1_1_1);
    JLabel totalquantity = new JLabel("Total Quantity (Ltrs) in Storage :");
    JLabel total_count = new JLabel("Total Number of WaterBottles :");
    agencyname = new JTextField();
    agencyname.setBounds(197, 28, 244, 32);
    panel_1.add(agencyname);
    agencyname.setColumns(10);

    netquantity = new JTextField();
    netquantity.setColumns(10);
    netquantity.setBounds(197, 71, 112, 32);
    panel_1.add(netquantity);

    bottleunits = new JTextField();
    bottleunits.setColumns(10);
    bottleunits.setBounds(197, 113, 112, 32);
    panel_1.add(bottleunits);

    JLabel price = new JLabel("Price of ltr");
    price.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
    price.setBounds(319, 71, 78, 32);
    panel_1.add(price);

    priceof = new JTextField();
    priceof.setBounds(391, 73, 53, 28);
    panel_1.add(priceof);
    priceof.setColumns(10);

    JLabel lblNewLabel = new JLabel("ADMIN PLAY GROUND");
    lblNewLabel.setBounds(187, 0, 231, 41);
    panel.add(lblNewLabel);
    lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
    totalquantity.setText(totalquantity.getText() + " " + total_ltrs);
    total_count.setText(total_count.getText() + " " + total_bottles);

    JButton add = new JButton("Add ");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  
        String dataLine = agencyname.getText() + " " + netquantity.getText() + " " + bottleunits.getText() + " " + brandname.getText() + " " + priceof.getText();
        System.out.println(dataLine);
        try
        {
        	FileWriter s=new FileWriter("E:\\eclipse\\wsms\\src\\wsms\\stockDetails",true);
        	s.write(dataLine+"\n");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        /* String str[]=line.split(" ");
		Integer data1 = Integer.parseInt(netquantity.getText()) + Integer.parseInt(str[1]);
	    Integer data2 = Integer.parseInt(bottleunits.getText()) + Integer.parseInt(str[2]);*/
        try {
			String [] sr=findprice();
			String num="Total Quantity (Ltrs) in Storage :"+sr[0];
			totalquantity.setText(num);
			String bot="Total Number of WaterBottles :"+sr[1];
			total_count.setText(bot);
			agencyname.setText("");
			brandname.setText("");
			netquantity.setText("");
			priceof.setText("");
			bottleunits.setText("");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      }
    });
    add.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
    add.setBounds(49, 201, 104, 32);
    panel_1.add(add);

    totalquantity.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
    totalquantity.setBounds(49, 239, 405, 32);
    panel_1.add(totalquantity);

    total_count.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
    total_count.setBounds(49, 281, 392, 32);
    panel_1.add(total_count);

    JLabel TotalQuantity = new JLabel("");
    TotalQuantity.setForeground(new Color(255, 255, 255));
    TotalQuantity.setBackground(new Color(255, 255, 255));
    TotalQuantity.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
    TotalQuantity.setBounds(282, 212, 112, 32);
    panel_1.add(TotalQuantity);

    JLabel TotalNumber = new JLabel("");
    TotalNumber.setForeground(Color.WHITE);
    TotalNumber.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
    TotalNumber.setBackground(Color.WHITE);
    TotalNumber.setBounds(282, 254, 112, 32);
    panel_1.add(TotalNumber);

    JLabel lblNewLabel_1_1_1_1 = new JLabel("BrandName");
    lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
    lblNewLabel_1_1_1_1.setBounds(49, 159, 98, 32);
    panel_1.add(lblNewLabel_1_1_1_1);

    brandname = new JTextField();
    brandname.setColumns(10);
    brandname.setBounds(197, 155, 112, 32);
    panel_1.add(brandname);

    JButton back = new JButton("back");
    back.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
    back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          mainInterface s = new mainInterface();
          s.setVisible(true);
          dispose();
        } catch (Exception e1) {
          e1.printStackTrace();
        }

      }
    });
    back.setBounds(289, 398, 111, 35);
    panel.add(back);

    JButton submit = new JButton("submit");
    submit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Forward to MainLogin page!");
        try {
          mainInterface s = new mainInterface();
          s.setVisible(true);
          dispose();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }

    });
    submit.setFont(new Font("Segoe UI Variable", Font.BOLD, 13));
    submit.setBounds(420, 398, 111, 35);
    panel.add(submit);
  }
}