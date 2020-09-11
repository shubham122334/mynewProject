
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Login  {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel;
	
	private JPasswordField textField_1;
	static int x,y;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Login();
		
	
	}

	/**
	 * Create the application.
	 */
	public Login() {

		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(670, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
					JPanel panel_1 = new JPanel();
					frame.getContentPane().add(panel_1);
					panel_1.setBackground(new Color(105, 105, 105));
					panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
					panel_1.setBounds(0, 0, 670, 300);
					panel_1.setLayout(null);
					
					lblNewLabel = new JLabel("");
					panel_1.add(lblNewLabel);
					lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/2.png")));
					lblNewLabel.setBounds(335, 114, 32, 32);
					
					JLabel lblNewLabel_1 = new JLabel("");
					panel_1.add(lblNewLabel_1);
					lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/img/Lock-icon.png")));
					lblNewLabel_1.setBounds(335, 157, 32, 32);
					
					textField_1 = new JPasswordField();
					textField_1.setHorizontalAlignment(JTextField.CENTER);
					textField_1.setBounds(377, 157, 246, 32);
					panel_1.add(textField_1);
					textField_1.setBorder(null);
					textField_1.addFocusListener(new FocusAdapter() {
				
							public void focusGained(FocusEvent e) {
							char ch[]=textField_1.getPassword();
							String pw=new String(ch,0,ch.length);
							if(pw.equals("Password"))
							textField_1.setText("");
									}
					public void focusLost(FocusEvent e) {
						char ch[]=textField_1.getPassword();
						String pw=new String(ch,0,ch.length);
							if(pw.equals("Password") || pw.equals(""))
						textField_1.setText("Password");
					}
				});
				textField_1.setText("Password");
				textField_1.setFont(new Font("Segoe UI", Font.BOLD, 21));
				textField_1.setColumns(10);
				
				textField =new JTextField("");
				textField.setHorizontalAlignment(JTextField.CENTER);
				textField.setAlignmentY(JTextField.CENTER);
				textField.setBounds(377, 114, 246, 32);
				panel_1.add(textField);
				textField.setBorder(null);
				textField.setText("Username");
				textField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
				textField.setColumns(20);
				
				JButton button = new JButton("Close");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button.setBounds(510, 211, 113, 32);
				panel_1.add(button);
					button.setBorderPainted(false);
					button.addMouseListener(new MouseAdapter() {
	@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						button.setBounds(508, 210, 117, 34);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						button.setBounds(510, 211, 113, 32);
					}
				});
			
					button.setForeground(Color.WHITE);
			button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			button.setFocusable(false);
			button.setBackground(new Color(30, 144, 255));

		JButton btnNewButton = new JButton("Log in");
			btnNewButton.setBounds(378, 211, 113, 32);
			panel_1.add(btnNewButton);
			btnNewButton.setBorderPainted(false);

			btnNewButton.setFocusable(false);
			btnNewButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					char ch[]=textField_1.getPassword();
					String pw=new String(ch,0,ch.length);
					if(pw.equals("Password") ||pw.equals("")|| textField.getText().equals("Email-Id") ||textField.getText().equals("") )
					{
						JOptionPane.showMessageDialog(null,"Incorrect Input");
																								}
					   else
							{
							frame.dispose();
								Thread thread=new Thread(new Loder());
								thread.start();
	
								
							}
						}															
					public void mouseEntered(MouseEvent e) {
						btnNewButton.setBounds(376, 210, 117, 34);
						}
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton.setBounds(378, 211, 113, 32);
				}
																										
			    });																						
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setBackground(new Color(30, 144, 255));
				btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				

				ImageIcon ig=new ImageIcon(Login.class.getResource("/img/download.png"));
				Image img=ig.getImage();
				Image img1=img.getScaledInstance(325, 300, Image.SCALE_SMOOTH);
				ig=new ImageIcon(img1);
				
				JLabel lblNewLabel_2 = new JLabel("",ig,JLabel.CENTER);
				lblNewLabel_2.setBounds(0, 0, 314, 300);
				panel_1.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("Log In");
				lblNewLabel_3.setForeground(new Color(255, 255, 255));
				lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 23));
				lblNewLabel_3.setBounds(456, 21, 84, 43);
				panel_1.add(lblNewLabel_3);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(new Rectangle(0, 0, 10, 5));
				separator.setBounds(420, 66, 145, 12);
				panel_1.add(separator);
											

				textField.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if(textField.getText().equals("Username"))
						textField.setText("");
					}
					public void focusLost(FocusEvent e) {
						if(textField.getText().equals("Username")||textField.getText().equals("") )
						textField.setText("Username");
					}
				});
				
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
}
