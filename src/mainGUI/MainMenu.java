package mainGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainMenu extends JFrame implements ActionListener {
	JButton insertButton = new JButton("Insert Menu");
	JButton viewButton = new JButton("View Menu");
	JButton updateButton = new JButton("Update Menu");
	JButton deleteButton = new JButton("Delete Menu");

	public MainMenu() {
		createMainMenuFrame();
	}

	private void createMainMenuFrame() {
		setTitle("BobaCool");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		createMainMenuTitle();
		createButtonMainMenu();
		
		setVisible(true);
	}
	
	private void createMainMenuTitle() {
		JLabel labelMainMenuTitle = new JLabel("BobaCool");
		labelMainMenuTitle.setHorizontalAlignment(JLabel.CENTER);
		add(labelMainMenuTitle, BorderLayout.NORTH);
	}
	
	private void createButtonMainMenu() {
		JPanel mainMenuButtonPanel = new JPanel();
		mainMenuButtonPanel.setLayout(new GridLayout(2,3));
		
		JPanel mainMenuButtonPanel1 = new JPanel();
		mainMenuButtonPanel1.add(insertButton);
		mainMenuButtonPanel1.add(viewButton);		
		mainMenuButtonPanel1.setLayout(new GridLayout(1,2));
		
		JPanel mainMenuButtonPanel2 = new JPanel();
		mainMenuButtonPanel2.add(updateButton);
		mainMenuButtonPanel2.add(deleteButton);
		mainMenuButtonPanel2.setLayout(new GridLayout(1,2));
		
		mainMenuButtonPanel.add(mainMenuButtonPanel1);
		mainMenuButtonPanel.add(mainMenuButtonPanel2);
		
		insertButton.addActionListener(this);
		viewButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		add(mainMenuButtonPanel);
	}
	

	
	public static void main(String[] args) {
		new MainMenu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertButton) {
			System.out.println("Main Menu - Insert");
			JOptionPane.showMessageDialog(null, "Insert menu baru");
			new InsertMenu();
			setVisible(false);
		} else if (e.getSource() == viewButton) {
			System.out.println("Main Menu - View");
			JOptionPane.showMessageDialog(null, "View Menu");
			try {
				new ViewMenu();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			setVisible(false);
		} //UPDATE DELETE BLM BIKIN OVERRIDE
		
	}

}
