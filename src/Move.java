class T{

	public static int count1=0;
}

public class Move   implements Runnable{

	public void run()
	{
		if(T.count1==0)
		{
		try {
		for(int i=400;i<=970;i=i+10)
		{
			
			Thread.sleep(30);
			Pan.lb.setBounds(i, 250, 250, 150);
		}
		Pan.lb.setVisible(false);
		Thread.sleep(1000);
		}
		catch(Exception e) {}

		Pan.panel_2.setVisible(true);
		Pan.comboBox.setVisible(true);
		T.count1++;
		}
		else
		{

			Pan.panel_.setVisible(false);
			Pan.panel_2.setVisible(true);
			T.count1++;
		}
	}
}


class Move1 extends T implements Runnable{


	public void run()
	{
		if(T.count1==0)
		{
		try {
		for(int i=400;i<=970;i=i+10)
		{
			
			Thread.sleep(30);
			Pan.lb.setBounds(i, 250, 250, 150);
		}
		Pan.lb.setVisible(false);
		Thread.sleep(1000);
		}
		catch(Exception e) {}
		T.count1++;
		Pan.btnNewButton_1.setVisible(true);
		Pan.panel_.setVisible(true);
		Pan.comboBox.setVisible(true);
		}
		else
		{
		Pan.panel_2.setVisible(false);
		Pan.panel_.setVisible(true);
		Pan.comboBox.setVisible(true);
		Pan.btnNewButton_1.setVisible(true);
		T.count1++;
		}
	}

}


