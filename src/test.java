import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class test extends JFrame {

	private JPanel contentPane;
	public   static JTextPane textPane;
	public static  JPanel panel_1,panel_2,panel_;
	public static JLabel lblNewLabel_2;

	public static JLabel lb; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Object cont[][]= {{0,"Bike",false},{0,"Car",false},{0,"Cycle",false},
				{0,"AutoRikshaw",false},{0,"Heavy duty",false}};
		Object column[]= {"price","Vehicle","Boolean"};
		JTable tb=new JTable(cont,column) {
			public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
      
        boolean []canEdit=new boolean[] {
        		true,false,true
        };
        public boolean isCellEditable(int rowIndex,int columnIndex) {
        	return canEdit[columnIndex];
        }
		};
		contentPane.setLayout(null);
		
		JScrollPane jt=new JScrollPane(tb);
		jt.setBounds(10, 5, 491, 187);
		contentPane.add(jt);
		
		ArrayList<String> veh=new ArrayList<String>();
		ArrayList<Integer>  rate=new ArrayList<Integer>();
		
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				
				for(int i=tb.getRowCount()-1;i>=0;i--)
				{
				boolean b=(boolean)tb.getValueAt(i, 2);
				if(b==true)
				{

					rate.add((int)tb.getValueAt(i, 0));
					veh.add((String)tb.getValueAt(i, 1));
				}
				}
				for(int st:rate) {
					System.out.println(st);	
				}
				for(String v:veh) {
					System.out.println(v);
				}
				}
		});
		
		panel.setBackground(Color.ORANGE);
		panel.setBounds(156, 273, 86, 24);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Submit");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);

		
	}
}
