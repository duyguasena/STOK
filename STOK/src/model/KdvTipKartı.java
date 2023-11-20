package model;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class KdvTipKartı extends JInternalFrame {
	private JTextField kdvkodtext;
	private static JTextField kdvadtext;
	private JTextField kdvorantext;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KdvTipKartı frame = new KdvTipKartı();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public KdvTipKartı() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Kdv Tip Kartı");
		setBounds(100, 100, 220, 187);
		getContentPane().setLayout(null);
		
		JLabel kdvkodu = new JLabel("Kdv Kodu");
		kdvkodu.setFont(new Font("Tahoma", Font.BOLD, 10));
		kdvkodu.setBounds(10, 10, 67, 13);
		getContentPane().add(kdvkodu);
		
		JLabel kdvadi = new JLabel("Kdv Adı");
		kdvadi.setFont(new Font("Tahoma", Font.BOLD, 10));
		kdvadi.setBounds(10, 47, 45, 13);
		getContentPane().add(kdvadi);
		
		JLabel kdvorani = new JLabel("Kdv Oranı");
		kdvorani.setFont(new Font("Tahoma", Font.BOLD, 10));
		kdvorani.setBounds(10, 86, 67, 13);
		getContentPane().add(kdvorani);
		
		kdvkodtext = new JTextField();
		kdvkodtext.setBounds(102, 7, 96, 19);
		getContentPane().add(kdvkodtext);
		kdvkodtext.setColumns(10);
		
		kdvadtext = new JTextField();
		kdvadtext.setColumns(10);
		kdvadtext.setBounds(102, 44, 96, 19);
		getContentPane().add(kdvadtext);
		
		kdvorantext = new JTextField();
		kdvorantext.setColumns(10);
		kdvorantext.setBounds(102, 83, 96, 19);
		getContentPane().add(kdvorantext);
		
		JButton addbtn = new JButton("Add");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addItem();
				
				
				
				Connection con=null;
				DbHelper dbHelper=new DbHelper();
				PreparedStatement prepstmt=null;
				
				try 
				{
					con=dbHelper.getConnection();	
				
					
					String query="INSERT INTO kdvtipkartı(kod,adi,orani)"
							+ "VALUES (?, ?, ?)";
					prepstmt=con.prepareStatement(query);
					
					prepstmt.setString(1, kdvkodtext.getText());
					prepstmt.setString(2, kdvadtext.getText());
					prepstmt.setString(3, kdvorantext.getText());
						
					prepstmt.executeUpdate();
					
					kdvkodtext.setText("");
					kdvadtext.setText("");
					kdvorantext.setText("");
					
					
				 
				  JOptionPane.showMessageDialog(null, "Data Insert Succesfully!");
				}
				catch (SQLException e2) 
				{
					dbHelper.showErrorMessage(e2);
				}
				finally 
				{
					try
					{
						prepstmt.close();
					} 
					catch (SQLException e2) 
					{
						
						e2.printStackTrace();
					}
					try
					{
						con.close();
					} 
					catch (SQLException e2) 
					{
						
						e2.printStackTrace();
					}
					
				}
				
				
				
				
				
				
				
			}
			
			
		});
		addbtn.setBackground(new Color(255, 255, 128));
		addbtn.setBounds(10, 127, 85, 21);
		getContentPane().add(addbtn);
		
		JButton deletebtn = new JButton("Delete");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		deletebtn.setBounds(113, 127, 85, 21);
		getContentPane().add(deletebtn);

	}
	public  void addItem() {
		
		StokCard stokCard=new StokCard();
		String value=kdvadtext.getText();
		stokCard.combo2.addItem(value);
		
	}
}
