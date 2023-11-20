package model;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

    public class StokCard extends JInternalFrame {
	private JTextField txtstokkod;
	private JTextField txtstokad;
	private JTextField txtbarkod;
	private JComboBox<String> combo;
	private String[] tip= {" ","Bitmiş ürün","Hazır ürün","Mevcut ürün"};
	private JComboBox<String> combo1;
	private String[] birim= {" ","Adet","Paket","Koli"};
	public JComboBox<String> combo2;
	
	

	
	public JComboBox<String> getCombo2() {
		return combo2;
	}


	public void setCombo2(JComboBox<String> combo2) {
		this.combo2 = combo2;
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokCard frame = new StokCard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StokCard() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Stok Kartı");
		setBounds(100, 100, 265, 420);
		getContentPane().setLayout(null);
		
		JLabel stokkod = new JLabel("Stok Kodu");
		stokkod.setBounds(10, 10, 65, 13);
		getContentPane().add(stokkod);
		
		txtstokkod = new JTextField();
		txtstokkod.setBounds(147, 7, 96, 19);
		getContentPane().add(txtstokkod);
		txtstokkod.setColumns(10);
		
		JLabel stokad = new JLabel("Stok Adı");
		stokad.setBounds(10, 54, 65, 13);
		getContentPane().add(stokad);
		
		txtstokad = new JTextField();
		txtstokad.setBounds(147, 51, 96, 19);
		getContentPane().add(txtstokad);
		txtstokad.setColumns(10);
		
		JLabel barkod = new JLabel("Barkod");
		barkod.setBounds(10, 96, 45, 13);
		getContentPane().add(barkod);
		
		txtbarkod = new JTextField();
		txtbarkod.setBounds(147, 93, 96, 19);
		getContentPane().add(txtbarkod);
		txtbarkod.setColumns(10);
		
		JLabel stoktip = new JLabel("Stok Tip");
		stoktip.setBounds(10, 139, 76, 13);
		getContentPane().add(stoktip);
		
		JLabel birim = new JLabel("Birim");
		birim.setBounds(10, 176, 45, 13);
		getContentPane().add(birim);
		
		JLabel kdvtip = new JLabel("Kdv Tipi");
		kdvtip.setBounds(10, 214, 76, 13);
		getContentPane().add(kdvtip);
		
		JComboBox combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"", "Bitmiş ürün", "Hazır ürün", "Mevcut ürün"}));
		combo.setBounds(147, 135, 96, 21);
		getContentPane().add(combo);
		
		JComboBox combo1 = new JComboBox();
		combo1.setModel(new DefaultComboBoxModel(new String[] {"", "Adet", "Paket", "Koli"}));
		combo1.setBounds(147, 172, 96, 21);
		getContentPane().add(combo1);
		
		JComboBox combo2 = new JComboBox();
		combo2.setModel(new DefaultComboBoxModel(new String[] {"", "Üretim"}));
		combo2.setBounds(147, 210, 96, 21);
		getContentPane().add(combo2);
		
		JLabel acıklama = new JLabel("Açıklama");
		acıklama.setBounds(10, 262, 76, 13);
		getContentPane().add(acıklama);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(145, 261, 98, 32);
		getContentPane().add(textArea);
		
		JLabel zaman = new JLabel("Oluşturma Zamanı");
		zaman.setBounds(10, 318, 127, 13);
		getContentPane().add(zaman);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(147, 315, 96, 19);
		getContentPane().add(formattedTextField);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con=null;
				DbHelper dbHelper=new DbHelper();
				PreparedStatement prepstmt=null;
				
				try 
				{
					con=dbHelper.getConnection();	
				
					
					String query="INSERT INTO stok(stok_kod,stok_ad,barkod,stok_tip,birim,kdv_tip_id,acıklama,zaman) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
					prepstmt=con.prepareStatement(query);
					
					prepstmt.setString(1, txtstokkod.getText());
					prepstmt.setString(2, txtstokad.getText());
					prepstmt.setString(3, txtbarkod.getText());
					prepstmt.setString(4, combo.getSelectedItem().toString());
					prepstmt.setString(5, combo1.getSelectedItem().toString());
					prepstmt.setString(6, combo2.getSelectedItem().toString());
					prepstmt.setString(7, textArea.getText());
					prepstmt.setString(8, formattedTextField.getText().toString());	
					prepstmt.executeUpdate();
					
					txtstokkod.setText("");
					txtstokad.setText("");
					txtbarkod.setText("");
					combo.setSelectedIndex(0);
					combo1.setSelectedIndex(0);
					combo2.setSelectedIndex(0);
					textArea.setText("");
					formattedTextField.setText("");
					
				 
				  JOptionPane.showMessageDialog(null, "Data Insert Succesfully!");
				}
				catch (SQLException e1) 
				{
					dbHelper.showErrorMessage(e1);
				}
				finally 
				{
					try
					{
						prepstmt.close();
					} 
					catch (SQLException e1) 
					{
						
						e1.printStackTrace();
					}
					try
					{
						con.close();
					} 
					catch (SQLException e1) 
					{
						
						e1.printStackTrace();
					}
				}
				
				
				
				
				
				
				
				
			}
		});
		save.setBackground(new Color(255, 255, 128));
		save.setBounds(10, 360, 65, 21);
		getContentPane().add(save);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		delete.setBounds(123, 360, 85, 21);
		getContentPane().add(delete);

	}
}
