package mainGUI;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAO;

public class ViewMenu extends JFrame implements ActionListener {
	JButton backButton = new JButton("Back");

	public ViewMenu() throws SQLException {
		createFrameViewMenu();
	}
	
	private void createFrameViewMenu() throws SQLException {
		setTitle("BobaCool");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		viewMenuTitle();
		initTable();
		viewMenuButton();
		
		setVisible(true);
	}
	
	private void viewMenuTitle() {
		JLabel viewMenuTitle = new JLabel("View Menu");
		viewMenuTitle.setHorizontalAlignment(JLabel.CENTER);
		add(viewMenuTitle, BorderLayout.NORTH);
	}
	
	private void initTable() throws SQLException {
		DAO menuData = new DAO();
		Vector<String> data = new Vector<>();

		data.add("kodeMenu");
		data.add("namaMenu");
		data.add("hargaMenu");
		data.add("stokMenu");

		DefaultTableModel tableModel = new DefaultTableModel(menuData.getMenuData(), data) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable table = new JTable(tableModel);
		
		JScrollPane scrollPaneTable = new JScrollPane(table);
		
		add(scrollPaneTable);
	}
	
	private void viewMenuButton() {
		JPanel viewMenuButton = new JPanel();
		viewMenuButton.setLayout(new GridLayout(1,1));
		
		viewMenuButton.add(backButton);
		
		add(viewMenuButton, BorderLayout.SOUTH);
		
		backButton.addActionListener(this);
		
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			System.out.println("View Menu - Back");
			JOptionPane.showMessageDialog(null, "Back to Home");
			new MainMenu();
			setVisible(false);
		}
		
	}
	

}
