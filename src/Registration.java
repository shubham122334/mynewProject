
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.border.*;

import p.*;

public class Registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	static String gender;
	private JTextField textF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	 Registration() {
		setUndecorated(true);

		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\subham\\Downloads\\Free_Sample_By_Wix (2).jpg");    
		setIconImage(icon); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 509, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(255, 250, 250));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(123, 155, 50, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblVehicle = new JLabel("Vehicle ");
		lblVehicle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblVehicle.setBounds(123, 188, 60, 22);
		contentPane.add(lblVehicle);
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 191, 180, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(223, 225, 180, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(223, 158, 180, 23);
		contentPane.add(textField_3);
		
		JLabel lblVehicleno = new JLabel("Vehicle _No");
		lblVehicleno.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblVehicleno.setBounds(123, 222, 83, 22);
		contentPane.add(lblVehicleno);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblId.setBounds(123, 127, 42, 22);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(Pan.id);
		textField.setFocusable(false);
		textField.setBounds(223, 126, 180, 23);
		contentPane.add(textField);
		 
		CheckboxGroup bx=new CheckboxGroup();
		Checkbox bx1=new Checkbox("Male",bx,false);
		bx1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender="Male";
			}
		});

		Checkbox bx2=new Checkbox("Female",bx,false);
		bx2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender="Female";
			}
		});

		bx1.setBounds(223, 297, 67, 20);
		bx2.setBounds(313, 297, 83, 20);
		contentPane.add(bx1);
		contentPane.add(bx2);
		

		ImageIcon ig=new ImageIcon(Pan.class.getResource("/img/Registration.jpg"));
		Image ig1=ig.getImage();
		Image img=ig1.getScaledInstance(190, 45, Image.SCALE_SMOOTH);
		ig=new ImageIcon(img);
		
		JLabel lblNewLabel_1 = new JLabel(ig, JLabel.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setIconTextGap(7);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(171, 26, 189, 44);
		contentPane.add(lblNewLabel_1);
	
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().trim().equals("")||textField_2.getText().trim().equals("")||textField_3.getText().trim().equals("")||textField.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(contentPane, "textField require", "Warning !",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					datasaver();

			    }
		   }
		});
		btnNewButton.setBounds(123, 334, 269, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.RED);
				btnNewButton_1.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_1.setForeground(Color.LIGHT_GRAY);
			}
		});
	
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(466, 1, 42, 23);
		contentPane.add(btnNewButton_1);
		
		textF = new JTextField();
		textF.setColumns(10);
		textF.setBounds(223, 259, 180, 23);
		contentPane.add(textF);
		
		JLabel lblContact = new JLabel("Mobile no");
		lblContact.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblContact.setBounds(123, 256, 83, 22);
		contentPane.add(lblContact);
	}
	 public void datasaver() {
		 Connection con=null;
		 String id=textField.getText();
		 String vehicle=textField_1.getText();
		 String vehicle_no=textField_2.getText().toUpperCase();
		 String name=textField_3.getText();
         String cont=textF.getText();
		 Pan.date1();
		 String dt=Pan.date;
		 int rt=0;
		 try {
		 
		 con=connProvider.getCon();
		 String sql="insert into reg_car values('"+id+"','"+vehicle+"','"+vehicle_no+"','"+name+"','"+gender+"','"+cont+"')";
		 Statement pst=con.createStatement();
		 rt=pst.executeUpdate(sql);
			 
		  if(rt>=1)
		  {
			dispose();
			JOptionPane.showMessageDialog(contentPane, "Registration successfull  ", "Success",JOptionPane.PLAIN_MESSAGE);
		 }
		 
		 else 
		 {
  		
			 textField.setText("");
			 textField_1.setText("");
			 textField_2.setText("");
			 textField_3.setText("");
			
			
		 }
		 con.close();
	   }
		 catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	 }
}
