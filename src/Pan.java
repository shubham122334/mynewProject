
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.time.*;

import javax.swing.*;

import p.IdMaker;
import p.connProvider;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;


public class Pan extends JFrame {

	/**
	 * 
	 */
	static float amount;
	public static JComboBox comboBox;
	static boolean discount=false; 
	public static JButton btnNewButton_1 ;
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	int  offX=0;
    int  offY=0;
	public static JLabel lb, lblNewLabel,lblNewLabel_1;
	public static String date;
	public static String id;
	private JButton lb1,lb2;
	public static JTextField textField ;
	public   static JTextPane textPane;
	public static  JPanel panel_1,panel_2,panel_, panel_p;
	public static JLabel lblNewLabel_2;
	public static void date1() {
		LocalDate d=LocalDate.now();
		date=d.toString();	
	}
	public static void dShow() {
		if(discount==true)
		{
			textPane.setText("Amount:"+amount+"\nDiscount:10%"+"\nPayable-amount:"+(amount-(amount*(0.10))));
		}
	}
	/**
	 * Launch the application.
	 */
	int count=0;
	private JTextField txtMonth;
	private JLabel lblRegistered;
	private JLabel label_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button;
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pan frame = new Pan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Pan() {
		setBounds(new Rectangle(0, 0, 2, 0));
		setUndecorated(true);
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		
		contentPane = new JPanel();
		
		
		contentPane.setFont(new Font("Arial", Font.PLAIN, 17));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\subham\\Downloads\\Free_Sample_By_Wix (2).jpg");    
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\subham\\OneDrive\\Pictures\\shb.jpg")); 
		contentPane.setLayout(null);
				
				String Items[]= {"Bike","Car","Bus","Cycle","AutoRikshaw"};
				comboBox = new JComboBox(Items);
				comboBox.setBounds(674, 222, 189, 27);
				contentPane.add(comboBox);
				comboBox.setVisible(false);
				
				panel_1 = new JPanel();
				panel_1.setBounds(1, 36, 301, 613);
				panel_1.setForeground(new Color(255, 255, 255));
				panel_1.setFont(new Font("Courier New", Font.PLAIN, 16));
				panel_1.setBackground(new Color(0, 206, 209));
				contentPane.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblNewLabel_3 = new JLabel("ark My Car");
				lblNewLabel_3.setIconTextGap(8);
				lblNewLabel_3.setForeground(new Color(255, 255, 255));
				lblNewLabel_3.setBounds(60, 35, 193, 47);
				lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 35));
				panel_1.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("P");
				lblNewLabel_4.setIconTextGap(8);
				lblNewLabel_4.setForeground(new Color(255, 255, 255));
				lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 65));
				lblNewLabel_4.setBounds(30, 8, 48, 73);
				panel_1.add(lblNewLabel_4);
				
				ImageIcon ig=new ImageIcon(Pan.class.getResource("/img/images.jpeg"));
				Image ig1=ig.getImage();
				Image img=ig1.getScaledInstance(302,179, Image.SCALE_SMOOTH);
				ig=new ImageIcon(img);
				
				
				lblNewLabel_2 = new JLabel(ig,JLabel.CENTER);
				panel_1.add(lblNewLabel_2);
				lblNewLabel_2.setBounds(0,0,302,179);
				
				
				JButton btnNewButton = new JButton("Registration");
				btnNewButton.setBorder(null);
				btnNewButton.setHideActionText(true);
				btnNewButton.setFocusable(false);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton.setBackground(new Color(30, 144, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton.setBackground(new Color(0, 206, 209));
					}
				});
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							
							Connection con=connProvider.getCon();
							String sql="select id from (select * from reg_car order by id desc) where rownum<=1";
							PreparedStatement pt=con.prepareStatement(sql);
							ResultSet rst=pt.executeQuery();
							rst.next();
							id=rst.getString(1);
							id=IdMaker.IdMkr(id);
						}
						catch(Exception em) {
							
							System.out.println(em);
						}
						
						// Registration module linking 
						
						new Registration().setVisible(true);

						
					}
				});
				btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 17));
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setBackground(new Color(0, 206, 209));
				btnNewButton.setBounds(0, 299, 301, 41);
				panel_1.add(btnNewButton);
				
				JButton btnEntry = new JButton("Entry");
			
				btnEntry.setBorder(null);
				btnEntry.setFocusable(false);
				btnEntry.setFont(new Font("Monospaced", Font.BOLD, 17));
				btnEntry.setForeground(Color.WHITE);
				btnEntry.setBackground(new Color(0, 206, 209));
				btnEntry.setBounds(0, 219, 301, 41);
				panel_1.add(btnEntry);
				
				btnEntry.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnEntry.setBackground(new Color(30, 144, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnEntry.setBackground(new Color(0, 206, 209));
					}
				});

				
				JButton btnNewButton_3 = new JButton("Price");
				btnNewButton_3.setBorder(null);
				btnNewButton_3.setFocusable(false);
				btnNewButton_3.setFont(new Font("Monospaced", Font.BOLD, 17));
				btnNewButton_3.setBackground(new Color(0, 206, 209));
				btnNewButton_3.setForeground(Color.WHITE);
				btnNewButton_3.setBounds(0, 259, 302, 41);
				panel_1.add(btnNewButton_3);
				
				btnNewButton_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton_3.setBackground(new Color(30, 144, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton_3.setBackground(new Color(0, 206, 209));
					}
				});

				

		          String str[]= {"Bike :20","Car :30","Bus :40","Cycle :15","AutoRikshaw :25"}; 
		          JList list = new JList(str);
		          list.setBounds(312,272, 100,94); 
		             contentPane.add(list);   
		             list.setVisible(false);

				btnNewButton_3.addActionListener(new ActionListener(){
		            public void actionPerformed(ActionEvent e)
		            {
		          if(count<1 )
		            {
		           list.setVisible(true);
		           count++;
		            }
		            else
		            {
		              list.setVisible(false);
		              count=0;
		            }
		            }
		          
		          });

				JButton btnNewButton_4 = new JButton("Info");
				btnNewButton_4.setBorder(null);
				btnNewButton_4.setToolTipText("Monthly");
				btnNewButton_4.setBackground(new Color(0, 206, 209));
				btnNewButton_4.setForeground(SystemColor.text);
				btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD, 17));
				btnNewButton_4.setFocusable(false);
				btnNewButton_4.setBounds(0, 178, 301, 41);
				panel_1.add(btnNewButton_4);
				
				btnNewButton_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton_4.setBackground(new Color(30, 144, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton_4.setBackground(new Color(0, 206, 209));
					}
				});

				

				
				panel_p = new JPanel();
				panel_p.setBackground(Color.BLACK);
				panel_p.setBounds(303, 370, 147, 51);
				contentPane.add(panel_p);
				panel_p.setLayout(null);
				panel_p.setVisible(false);
				
				JTextField txtMon = new JTextField();
				txtMon.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						txtMon.setText("");
					}
					public void focusLost(FocusEvent e) {
						txtMon.setText("Vehicle No");
					}
				});
				txtMon.setBounds(0, 0, 147, 25);
				panel_p.add(txtMon);
				txtMon.setColumns(10);
				txtMon.setText("Vehicle No");
				
				button = new JButton("Out");
				button.setBorder(null);
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						String st=txtMon.getText().toUpperCase().trim();
				
						if(st.equalsIgnoreCase("Vehicle No"))
						{
							JOptionPane.showMessageDialog(null, "Enter vehicle_no");
						}
						else
						{
							Connection con=null;
							try {
							  
								con=connProvider.getCon();	
								PreparedStatement pst=con.prepareStatement("update park_car set outtime=? where vehicle_no=? and outtime=?");
								pst.setString(1, Time1());
								pst.setString(2, st);
								pst.setString(3, "null");
								int s=pst.executeUpdate();

						        if(s!=0)
								{
									JOptionPane.showMessageDialog(null, "out");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "no vehicle is parked with this NO");
								}
						        con.close();
						
							}
							catch(Exception em) {}
						}
						
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						button.setFont(new Font("Segoe UI", Font.BOLD, 15));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					}
				});
				button.setForeground(Color.WHITE);
				button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				button.setFocusable(false);
				button.setBackground(Color.BLUE);
				button.setBounds(0, 26, 147, 25);
				panel_p.add(button);
				
				JButton btnVehicleOut = new JButton("Vehicle out");
				btnVehicleOut.setBorder(null);
				btnVehicleOut.setFocusTraversalKeysEnabled(false);
				btnVehicleOut.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnVehicleOut.setBackground(new Color(30, 144, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnVehicleOut.setBackground(new Color(0, 206, 209));
					}
				});
				btnVehicleOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(count<1)
						{
						panel_p.setVisible(true);		
						count++;
						}
						else
						{
							panel_p.setVisible(false);
							btnVehicleOut.setActionCommand(null);
							count=0;
						}
					}
				});
				btnVehicleOut.setForeground(Color.WHITE);
				btnVehicleOut.setFont(new Font("Monospaced", Font.BOLD, 17));
				btnVehicleOut.setFocusable(false);
				btnVehicleOut.setBackground(new Color(0, 206, 209));
				btnVehicleOut.setBounds(0, 340, 301, 41);
				panel_1.add(btnVehicleOut);
				
				String str1="Now your vehicle is"+"\n"+" our responsiblity";
				JTextArea textArea = new JTextArea(str1);
				textArea.setEditable(false);
				textArea.setForeground(Color.WHITE);
				textArea.setBackground(new Color(0, 206, 209));
				textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
				textArea.setBounds(48, 512, 223, 54);
				panel_1.add(textArea);
				
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(0, 206, 209));
				panel.setBounds(1, 1, 1048, 35);
				contentPane.add(panel);
				
				panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent em) {
						offX=em.getX();
						offY=em.getY();
					}
				});
				
				panel.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						int evx=e.getXOnScreen();
						int evY=e.getYOnScreen();
						setLocation(evx-offX,evY-offY);
					}
				});
			
				panel.setLayout(null);
				date1();
				
				JLabel lblNewLabel_5 = new JLabel(	date  +"              CSE [ G.N ]  ");
				lblNewLabel_5.setBounds(458, 3, 194, 25);
				panel.add(lblNewLabel_5);
				
				lb2=new JButton("X");
				lb2.setBounds(1004, 0, 46, 35);
				panel.add(lb2);
				lb2.setFocusable(false);
				lb2.setBorder(BorderFactory.createEmptyBorder());
				lb2.setBackground(new Color(0, 206, 209));
				lb2.setForeground(Color.white);
				lb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				lb1=new JButton("-");
				lb1.setBounds(958, 0, 46, 35);
				panel.add(lb1);
				
				lb1.setFocusable(false);
				lb1.setBackground(new Color(0, 206, 209));
				lb1.setBorder(BorderFactory.createEmptyBorder());
				lb1.setForeground(Color.white);
				lb1.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						setState(JFrame.ICONIFIED);
					}
					public void mouseEntered(MouseEvent e) {
						lb1.setBackground(Color.white);
						lb1.setForeground(Color.lightGray);
					}
					public void mouseExited(MouseEvent e) {
						lb1.setBackground(new Color(0, 206, 209));
						lb1.setForeground(Color.white);
					}
				});
				lb1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
				lb2.addMouseListener(new MouseAdapter(){

					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
					public void mouseEntered(MouseEvent e) {
						lb2.setBackground(Color.RED);
						lb2.setForeground(Color.WHITE);
					}
					public void mouseExited(MouseEvent e) {
						lb2.setBackground(new Color(0, 206, 209));
						lb2.setForeground(Color.white);
					}
				});
				
				
				panel_ = new JPanel();
				panel_.setBounds(450, 122, 472, 364);
				contentPane.add(panel_);
				panel_.setLayout(null);
				
				JLabel lblNewLabel_8 = new JLabel("Vehicle    :");
				lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 17));
				lblNewLabel_8.setBounds(81, 106, 93, 24);
				panel_.add(lblNewLabel_8);
				
				JLabel lblName = new JLabel("Name    :");
				lblName.setFont(new Font("Arial", Font.BOLD, 17));
				lblName.setBounds(81, 62, 93, 24);
				panel_.add(lblName);
				
				textField_1 = new JTextField();
				textField_1.setBounds(223, 63, 189, 26);
				panel_.add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(223, 140, 189, 26);
				panel_.add(textField_2);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(223, 184, 189, 26);
				panel_.add(textField_3);
				
				JLabel lblVehicleNo = new JLabel("Vehicle no  :");
				lblVehicleNo.setFont(new Font("Arial", Font.BOLD, 17));
				lblVehicleNo.setBounds(81, 146, 101, 24);
				panel_.add(lblVehicleNo);
				
				JLabel lblMobileNo = new JLabel("Mobile no    :");
				lblMobileNo.setFont(new Font("Arial", Font.BOLD, 17));
				lblMobileNo.setBounds(81, 183, 101, 24);
				panel_.add(lblMobileNo);
				
			    btnNewButton_1 = new JButton("Submit");
			    btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			    btnNewButton_1.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		
			    		Connection con=null;
			    			String name=textField_1.getText().toUpperCase();
			    			String vehicle_no=textField_2.getText().toUpperCase();
			    			String vehicle=(String) comboBox.getItemAt(comboBox.getSelectedIndex());
			    			String Mobile=textField_3.getText();
			    			
	    			if(name.trim().equals("") || vehicle_no.trim().equals("") || Mobile.trim().equals(""))
	    			{
	    				JOptionPane.showMessageDialog(null, "Textfield required","Alert",JOptionPane.WARNING_MESSAGE);
	    			}
			    	else {
			    		
			    		
			    			try {
			    			con=connProvider.getCon();
			    		    String tm=Time1();
			    			PreparedStatement prt=con.prepareStatement("insert into park_car values(?,?,?,?,?,?,?)");
			    			prt.setString(1,name);
			    			prt.setString(2,vehicle);
			    			prt.setString(3,vehicle_no);
			    			prt.setString(4,Mobile);
			    			prt.setString(5, date);
			    			prt.setString(6,tm);
			    			prt.setString(7, "null");
			    			prt.execute();
			    			amount=Fair(vehicle);
			    			textPane.setText("Discount:0"+"\nPayable-amount:"+amount);
			    			JOptionPane.showMessageDialog(null, "successfully added");
			    		    con.close();
			    		}
			   
			    		catch(Exception em) { } 	
			   			
			   			 textField_1.setText("");
			   			 textField_2.setText("");
			   			 textField_3.setText("");
			    			
			    			}
			    	}
			    });
			    btnNewButton_1.setBounds(63, 246, 349, 35);
			    panel_.add(btnNewButton_1);
			    btnNewButton_1.setFocusable(false);
			    btnNewButton_1.setBackground(new Color(30, 144, 255));
			    btnNewButton_1.setForeground(Color.WHITE);
			    btnNewButton_1.setVisible(false);
			    
	    	
	    			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    			//Discount and all the working going here 
	    			
	    			
	 				panel_.setVisible(false);
				
				lb=new JLabel("");
				lb.setIcon(new ImageIcon(Pan.class.getResource("/img/Car-Right-Red-icon.png")));
				lb.setBounds(450, 141, 472, 335);
				contentPane.add(lb);
				
				
				textPane = new JTextPane();
				textPane.setBackground(SystemColor.inactiveCaption);
				textPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textPane.setFocusable(false);
				textPane.setBounds(545, 497, 292, 81);
				textPane.setText(" Hello Welcome");
				contentPane.add(textPane);
				
				JButton btnNewButton_2 = new JButton("Clear");
				btnNewButton_2.setForeground(new Color(255, 255, 255));
				btnNewButton_2.setBackground(new Color(128, 128, 128));
				btnNewButton_2.setFocusable(false);
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textPane.setText("");
					}
				});
				btnNewButton_2.setBounds(654, 589, 75, 23);
				contentPane.add(btnNewButton_2);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBackground(Color.BLACK);
				panel_3.setBounds(303, 210, 147, 51);
				contentPane.add(panel_3);
				panel_3.setLayout(null);
				panel_3.setVisible(false);
				
				txtMonth = new JTextField();
				txtMonth.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						txtMonth.setText("");
					}
					public void focusLost(FocusEvent e) {
						txtMonth.setText(" Type date");
					}
				});
				txtMonth.setToolTipText("yyyy-mm");
				txtMonth.setBounds(0, 0, 147, 25);
				panel_3.add(txtMonth);
				txtMonth.setColumns(10);
				txtMonth.setText(" Type date");
				
				panel_2 = new JPanel();
				panel_2.setBounds(450, 141, 472, 322);
				contentPane.add(panel_2);
				panel_2.setLayout(null);
				

				JButton btnNewButton4 = new JButton("Submit");
				btnNewButton4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				btnNewButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton4.setForeground(new Color(255, 255, 255));
				btnNewButton4.setFont(new Font("Arial", Font.BOLD, 15));
				btnNewButton4.setBackground(new Color(30, 144, 255));
				btnNewButton4.setFocusable(false);
				btnNewButton4.setBounds(80, 208, 321, 33);
				panel_2.add(btnNewButton4);
				
				
   			btnNewButton4.addMouseListener(new MouseAdapter() {
   				@Override
   				public void mouseClicked(MouseEvent e) {
   		    			String pw=textField.getText().toUpperCase();

   				Connection con=null;
	    					if(pw.toString().equals(""))
	    			{
	    				JOptionPane.showMessageDialog(panel_2, "Textfield required","Alert",JOptionPane.WARNING_MESSAGE);
	    			}
			else
			{ 
				
		        try {

        	        	con=connProvider.getCon();
        	
		    			String	data=(String) comboBox.getItemAt(comboBox.getSelectedIndex());
		    			amount=Fair(data);
	                	String Vn=textField.getText().toUpperCase();
	                	PreparedStatement pt=con.prepareStatement("select name,vehicle,contact from reg_car where vehicle_no=?");
	                	pt.setString(1, Vn);
	                	
	                	ResultSet rt=pt.executeQuery();
	                	
	                   	if(rt.next())
	                	{
	                		String name=rt.getString(1);
	                		String V=rt.getString(2);
	                		String contact=rt.getString(3);
	                		amount=Fair(V);
	                	    PreparedStatement pt1=con.prepareStatement("insert into park_car values(?,?,?,?,?,?,?)");
	                  		pt1.setString(1, name);
	                		pt1.setString(2, V);
	                		pt1.setString(3, Vn);
	                		pt1.setString(4, contact);
	                		pt1.setString(5, date);
	                		pt1.setString(6,Time1());
	                		pt1.setString(7, "null");
	                		pt1.executeUpdate();
	                		discount=true;
	                		dShow();
							JOptionPane.showMessageDialog(null, "successfully added");
	                	
	                	}
	                	else
	                	{
	                		JOptionPane.showMessageDialog(null, "Not Registered");
	                	}

    			               
    			                
	   		    			        
	   		    			            // Iterate through the data in the result set and display it.
	   		    			            con.close();			                
	   		    			}
	   		    			        // Handle any errors that may have occurred. 
	   		    			        catch (Exception ec) {
	   		    			            System.out.println(ec.getMessage());
	   		    			        }
	   		    			}

	   		    					 textField.setText("");
	   				}
	   				public void mouseExited(MouseEvent e) {
	   		    			discount=false;
	   				}
	   			});

				
				lblNewLabel_1 = new JLabel("Vehicle No   :");
				lblNewLabel_1.setBounds(67, 131, 113, 27);
				panel_2.add(lblNewLabel_1);
				lblNewLabel_1.setBackground(Color.BLACK);
				lblNewLabel_1.setForeground(Color.BLACK);
				lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
				
					
					lblNewLabel = new JLabel("Vehicle        :");
					lblNewLabel.setBounds(67, 81, 118, 27);
					panel_2.add(lblNewLabel);
					lblNewLabel.setBackground(Color.BLACK);
					lblNewLabel.setForeground(Color.BLACK);
					lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
					
					textField = new JTextField();
					textField.setBounds(223, 133, 189, 27);
					panel_2.add(textField);
					textField.setColumns(10);
				    panel_2.setVisible(false);
			
	
				JButton btnNewButton_5 = new JButton("Get info");
				btnNewButton_5.setBorder(null);
				btnNewButton_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String st=txtMonth.getText().trim();
						if(st.equals(""))
						{
							JOptionPane.showMessageDialog(null, "textfield required");
						}
						else if(st.length()>6 && st.length()<8)
						{
							
					        try {
					        	 String t=st+"%";
				        		Class.forName("oracle.jdbc.driver.OracleDriver");
				        		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iimt123");
					            PreparedStatement pst=con.prepareStatement("select vehicle,vehicle_no,date1,name from  park_car where date1 like ? ");
					            pst.setString(1, t);
					            ResultSet rt=pst.executeQuery();
					            System.out.println("Query execute");
					            FileWriter f;
					            File t1;
					            if(rt.next())
					            {
					            	t1=new File(st+".txt");
					            	boolean b=t1.exists();
					            	if(b)
					            		t1.delete();
					            	 f=new FileWriter(st+".txt",true);
					            	 f.write("\tVehicle"+"\t\t"+"Vehicle_no"+"\t\t"+"Date"+"\n");
					            	 f.write("   ---------------------------------------------------"+"\n");
						            f.write("\t"+rt.getString(4)+"\t\t"+rt.getString(1)+"\t\t"+rt.getString(2)+"\t\t"+rt.getString(3)+"\n");
					           
					            while(rt.next())
					            {
					            	
					            	f.write("\t"+rt.getString(4)+"\t\t"+rt.getString(1)+"\t\t"+rt.getString(2)+"\t\t"+rt.getString(3)+"\n");
					            }
					            f.close();
				            	JOptionPane.showMessageDialog(null, "\tplease check !\n info has been saved to file "+st+".txt");
					            }
					            else
					            	JOptionPane.showMessageDialog(null, "data not available for this input");					            	
					            con.close();
					        }
					        catch(Exception em)
					        {
					        	System.out.println(em.getMessage());
					        }
					     
						}
					    else 
			            	JOptionPane.showMessageDialog(null, "incorrect input");
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 15));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnNewButton_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					}
				});
				btnNewButton_5.setForeground(Color.WHITE);
				btnNewButton_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				btnNewButton_5.setFocusable(false);
				btnNewButton_5.setBackground(Color.BLUE);
				btnNewButton_5.setBounds(0, 26, 147, 25);
				panel_3.add(btnNewButton_5);
				
				JLabel lblL = new JLabel("");
				lblL.setIcon(new ImageIcon(Pan.class.getResource("/img/blue-color.jpg")));
				lblL.setBounds(448, 60, 219, 51);
				lblL.setVisible(false);
				contentPane.add(lblL);
				
				JLabel label = new JLabel("");
				label.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						
						new Thread(new Move1()).start();
						
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						label_1.setForeground(Color.darkGray);
					}
					public void mouseExited(MouseEvent e) {
						label_1.setForeground(Color.WHITE);
					}
				});
				
				
				label.setIcon(new ImageIcon(Pan.class.getResource("/img/orange-solid.jpg")));
				label.setBounds(703, 60, 219, 51);
				label.setVisible(false);
				contentPane.add(label);
				
				lblRegistered = new JLabel("Registered");
				lblL.add(lblRegistered);
				lblRegistered.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
				lblRegistered.setForeground(Color.WHITE);
				lblRegistered.setBounds(50, 8, 137, 35);
				
				lblL.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						new Thread(new Move()).start();


					}
					@Override
					public void mouseEntered(MouseEvent e) {
						lblRegistered.setForeground(Color.darkGray);
					}
					
					public void mouseExited(MouseEvent e) {
						lblRegistered.setForeground(Color.white);
					}
				});
				
				label_1 = new JLabel("Guest");
				label_1.setForeground(Color.WHITE);
				label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
				label_1.setBounds(80, 8, 137, 35);
				label.add(label_1);
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(count<1)
						{
						panel_3.setVisible(true);		
						count++;
						}
						else
						{
							panel_3.setVisible(false);
							btnNewButton_4.setActionCommand(null);
							count=0;
						}
					}
				});

				
				btnEntry.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						lblL.setVisible(true);
						label.setVisible(true);

					}
				});
			 		
		setBounds(200,30,1050,650);
		
	}
	int Fair(String v)
	{
		int am=0;
		if(v.equalsIgnoreCase("Bike"))
		{
			am=20;
		}
		if(v.equalsIgnoreCase("Car"))
		{
			am=30;
		}
		if(v.equalsIgnoreCase("Bus"))
		{
			am=40;
		}
		if(v.equalsIgnoreCase("Cycle"))
		{
			am=15;
		}
		if(v.equalsIgnoreCase("AutoRikshaw"))
		{
			am=25;
		}
		return am;
	}
	
	 public static String Time1() {
			LocalTime time=LocalTime.now();
			int st=time.getHour();
			int st1=time.getMinute();
			return st+":"+st1;
		}
}
