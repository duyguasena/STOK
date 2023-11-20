package model;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class StokKartListesi extends JInternalFrame {
	private final JTable table = new JTable();
	DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					StokKartListesi frame = new StokKartListesi();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public StokKartListesi() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 760, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 728, 255);
		getContentPane().add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stok Kod", "Stok Ad", "Barkod", "Stok Tip", "Birim", "Kdv Tip", "A\u00E7\u0131klama", "Zaman"
			}
		));
		scrollPane.setViewportView(table);
		model=(DefaultTableModel)table.getModel();
		try {
			ArrayList<Stok>stoks=getStoks();
			for(Stok stok:stoks) 
			{
				Object[] row={stok.getStokkod(),
						      stok.getStokad(),
						      stok.getBarkod(),
						      stok.getStoktip(),
						      stok.getBirim(),
						      stok.getKdvtipid(),
						      stok.getAçıklama(),
						      stok.getZaman()};
				model.addRow(row);
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		

	}
	
	
	
	public ArrayList<Stok> getStoks() throws SQLException
	{
		Connection connection=null;
		DbHelper dbHelper=new DbHelper();
		Statement statement=null;
		ResultSet resultSet;
		ArrayList<Stok> stoks=null;
		
		
		try 
		{
			connection=dbHelper.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select stok_kod,stok_ad,barkod,stok_tip,birim,kdv_tip_id,acıklama,zaman from stok");
			stoks=new ArrayList<Stok>();
			while (resultSet.next()) 
			{
				stoks.add(new Stok(resultSet.getString("stok_kod"),
						           resultSet.getString("stok_ad"),
						           resultSet.getString("barkod"),
						           resultSet.getString("stok_tip"),
						           resultSet.getString("birim"),
						           resultSet.getString("kdv_tip_id"),
						           resultSet.getString("acıklama"),
						           resultSet.getString("zaman")));
				
			}
			
		
		}
		catch (SQLException e)
		{
			dbHelper.showErrorMessage(e);
		}
		finally 
		{
			statement.close();
			connection.close();
		}
		return stoks;
	}

}
