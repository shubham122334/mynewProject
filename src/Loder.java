import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Loder extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel lblNewLabel_1;
	
	public static void main(String[] args) {
		Loder ld=new Loder();
		Thread th=new Thread(ld);
		th.start();
	}
	public  void run() {
		
		for(int i=0;i<=100;i++)
		{
			
			String str=lblNewLabel_1.getText();
			if(str.trim().equals("......"))
			{
				lblNewLabel_1.setText("");	
			}
			else
			{
			lblNewLabel_1.setText(str+".");
			}
			progressBar.setValue(i);
			progressBar.setString(i+"%");
			try {
				
				Thread.sleep(70);
			}
			catch(Exception e)
			{
				
			}
		}
		
		lblNewLabel_1.setText(".....");

		new Pan().setVisible(true);
		dispose();

		
	}

	
	public Loder() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 progressBar = new JProgressBar();
		 progressBar.setOpaque(true);
		 progressBar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		 progressBar.setBackground(new Color(255, 255, 255));
	progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setStringPainted(true);
		progressBar.setBounds(64, 94, 436, 45);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("Loading");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(196, 31, 69, 26);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(".");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(264, 31, 46, 22);
		contentPane.add(lblNewLabel_1);
		setSize(570, 205);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
