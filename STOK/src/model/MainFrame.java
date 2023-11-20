package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

	
	private JDesktopPane desktopPane;
	

	
	
	
	public MainFrame() {
		setTitle("MainFrame");

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 679);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("STOK");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnıtmNewMenuItem = new JMenuItem("Stok Kartı");
		mnıtmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StokCard stokCard=new StokCard();
			    desktopPane.add(stokCard);
				stokCard.setVisible(true);
				
				
				
				
			}
		});
		mnNewMenu.add(mnıtmNewMenuItem);
		
		JMenuItem mnıtmNewMenuItem_1 = new JMenuItem("Stok Kart Listesi");
		mnıtmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			StokKartListesi stokKartListesi=new StokKartListesi();
			desktopPane.add(stokKartListesi);
			stokKartListesi.setVisible(true);
			
				
			}
		});
		mnNewMenu.add(mnıtmNewMenuItem_1);
		
		JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("Kdv Tip Kartı");
		mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KdvTipKartı kdvTipKartı=new KdvTipKartı();
				desktopPane.add(kdvTipKartı);
				kdvTipKartı.setVisible(true);
				
			}
			
		});
		mnNewMenu.add(mnıtmNewMenuItem_2);
		desktopPane=new JDesktopPane();
		desktopPane.setBackground(new Color(192, 192, 192));
		desktopPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(desktopPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 62, 34);
		desktopPane.add(toolBar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StokCard stokCard=new StokCard();
				desktopPane.add(stokCard);
				stokCard.setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/icon2.png")));
		toolBar.add(btnNewButton);
	}
	
	
	
	
	

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
