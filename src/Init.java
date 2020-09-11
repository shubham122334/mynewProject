

import java.awt.*;

import javax.swing.*;

public class Init extends Thread {

	private JFrame frame;
	private JLabel lblNewLabel, lblNewLabel_1;
	private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Init t=new Init();
		t.start();
	}

	/**
	 * Create the application.
	 */
	public Init() {	
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(470, 200, 500, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon ig=new ImageIcon(Init.class.getResource("/img/1.jpg"));
		Image img=ig.getImage();
		Image img1=img.getScaledInstance(500,330,Image.SCALE_SMOOTH);
	    ig=new ImageIcon(img1);
	    
	    lblNewLabel = new JLabel("",ig,JLabel.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 500, 330);
		frame.getContentPane().add(lblNewLabel);
		
	    lblNewLabel_1 = new JLabel("Park my Car");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		
		frame.setVisible(true);
		
		
		//Code to make the text movable #Animated text  
		
		
		try {
			int x=10;
			lblNewLabel.add(lblNewLabel_1);
			lblNewLabel_1.setBounds(120, 200, 300, 45);
			lblNewLabel_2 = new JLabel("Services");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel.add(lblNewLabel_2);
			lblNewLabel_2.setBounds(206, 158, 100, 20);
			
		for(int i=0;i<=38;i++)
		{
			
		Thread.sleep(50);
		lblNewLabel_1.setBounds(500-x, 114, 300, 45);
			x+=10;
		}
		Thread.sleep(5000);
		}
		catch(Exception e) {
			
		}

		frame.dispose();
		new Login();
		
	}
	
	
}
