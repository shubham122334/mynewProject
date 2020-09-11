package p;
import javax.swing.*;

public class ChekNo extends JFrame {
	private JPanel contentPane;
	ChekNo(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		contentPane=new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb=new JLabel();
		lb.setText("Hello !");
		lb.setBounds(180,150, 100, 20);
		contentPane.add(lb);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChekNo();

	}

}
