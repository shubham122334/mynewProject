import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Install extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Install frame = new Install();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Install() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 80, 698, 557);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("MenuBar.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(169, 41, 83, 24);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(169, 65, 177, 30);
		textField.setColumns(10);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 131, 177, 30);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JLabel lblOracleDbId = new JLabel("Oracle db Id");
		lblOracleDbId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOracleDbId.setBounds(169, 106, 83, 24);
		contentPane.add(lblOracleDbId);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(356, 131, 174, 30);
		contentPane.add(passwordField);
		
		JLabel lblOraclePassword = new JLabel("Oracle password");
		lblOraclePassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOraclePassword.setBounds(356, 108, 113, 24);
		contentPane.add(lblOraclePassword);		

		Object cont[][]= {{0,"Bike",0,false},{0,"Car",0,false},{0,"Cycle",0,false},
				{0,"AutoRikshaw",0,false},{0,"Heavy duty",0,false}};
		Object column[]= {"set price / hr","vehicle","pass price","select vehicle"};
		JTable tb=new JTable(cont,column) {
			public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2: 
                    	return Integer.class;
                    default:
                        return Boolean.class;
                }
            }
      
        boolean []canEdit=new boolean[] {
        		true,false,true,true
        };
        public boolean isCellEditable(int rowIndex,int columnIndex) {
        	return canEdit[columnIndex];
        }
		};
		JScrollPane jt=new JScrollPane(tb);
		jt.setBounds(169, 172, 361, 106);
		contentPane.add(jt);
		
		
		JComboBox comboBox = new JComboBox(new String[] {"No","Yes"});
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int com=comboBox.getSelectedIndex();
				System.out.println(com);
				if(com==0)
				{
					JOptionPane.showMessageDialog(null, "First Install oracle 10g/11g in your system");
				}
				else
				{
					
				}
			}
		});
		comboBox.setBounds(356, 65, 174, 30);
		contentPane.add(comboBox);
		
		JLabel lblOracleAvailablity = new JLabel("Oracle Availablity");
		lblOracleAvailablity.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOracleAvailablity.setBounds(356, 41, 113, 24);
		contentPane.add(lblOracleAvailablity);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(169, 318, 174, 30);
		contentPane.add(passwordField_1);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(169, 294, 83, 24);
		contentPane.add(lblPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(356, 318, 174, 30);
		contentPane.add(passwordField_2);
		
		JLabel lblConfirmPassword = new JLabel("confirm password");
		lblConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblConfirmPassword.setBounds(357, 294, 113, 24);
		contentPane.add(lblConfirmPassword);
		

		ArrayList<String> veh=new ArrayList<String>();
		ArrayList<Integer>  rate=new ArrayList<Integer>();
		ArrayList<Integer>  pass=new ArrayList<Integer>();
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=tb.getRowCount()-1;i>=0;i--)
				{
				boolean b=(boolean)tb.getValueAt(i, 3);
				if(b==true)
				{

					rate.add((int)tb.getValueAt(i, 0));
					pass.add((int)tb.getValueAt(i,2));
					veh.add((String)tb.getValueAt(i, 1));
				}
				}
				for(int st:rate) {
					System.out.println(st);	
				}
				for(int st:pass) {
					System.out.println(st);	
				}
				for(String v:veh) {
					System.out.println(v);
				}
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(369, 389, 161, 30);
		contentPane.add(btnNewButton);
		
	}
}
