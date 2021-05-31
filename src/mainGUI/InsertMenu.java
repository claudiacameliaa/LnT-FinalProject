package mainGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.DAO;

public class InsertMenu extends JFrame implements ActionListener{
	JButton submitButton = new JButton("Submit");
	JButton cancelButton = new JButton("Cancel");
	
	JLabel kodeMenu = new JLabel("Kode Menu  :");
	JTextField inputKodeMenu = new JTextField();
	
	JLabel namaMenu = new JLabel("Nama Menu  :");
	JTextField inputNamaMenu = new JTextField();
	
	JLabel hargaMenu = new JLabel("Harga Menu :");
	JTextField inputHargaMenu = new JTextField();
	
	JLabel stokMenu = new JLabel("Stok Menu  :");
	JTextField inputStokMenu = new JTextField();
	
	public InsertMenu() {
		createFrameInsertMenu();
	}
	
	private void createFrameInsertMenu() {
		setTitle("BobaCool");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		insertMenuTitle();
		insertMenuComponent();
		
		setVisible(true);
	}
	
	private void insertMenuTitle() {
		JLabel insertMenuTitle = new JLabel("Insert Menu");
		insertMenuTitle.setHorizontalAlignment(JLabel.CENTER);
		add(insertMenuTitle, BorderLayout.NORTH);
	}
	
	private void insertMenuComponent() {
		JPanel insertMenuComponentPanel = new JPanel();
		insertMenuComponentPanel.setLayout(new GridLayout(5,2));
		
		insertMenuComponentPanel.add(kodeMenu);
		insertMenuComponentPanel.add(inputKodeMenu);
		
		insertMenuComponentPanel.add(namaMenu);
		insertMenuComponentPanel.add(inputNamaMenu);
		
		insertMenuComponentPanel.add(hargaMenu);
		insertMenuComponentPanel.add(inputHargaMenu);
		
		insertMenuComponentPanel.add(stokMenu);
		insertMenuComponentPanel.add(inputStokMenu);
		
		insertMenuComponentPanel.add(submitButton);
		insertMenuComponentPanel.add(cancelButton);
		
		add(insertMenuComponentPanel);
		
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}
	
	private String randomCode(JTextField inputKodeMenu) {
		
		Random rnd = new Random();
		
		String rndCode ="";
		
		rndCode = inputKodeMenu.getText();
		
		rndCode = "BC-" + rnd.nextInt(10) 
						+ rnd.nextInt(10) 
						+ rnd.nextInt(10);
		
		return rndCode;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			try {
				DAO controller = new DAO();
				controller.insertDatabase(randomCode(inputKodeMenu), inputNamaMenu.getText(), inputHargaMenu.getText(), inputStokMenu.getText());
				inputNamaMenu.setText(null);
				inputHargaMenu.setText(null);
				inputStokMenu.setText(null);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource() == cancelButton) {
			System.out.println("Cancel insert menu");
			JOptionPane.showMessageDialog(null, "Back to Home");
			new MainMenu();
			setVisible(false);
		}
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
