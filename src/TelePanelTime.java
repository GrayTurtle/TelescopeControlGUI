/*
	This class is the clock of the GUI
*/

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TelePanelTime extends JPanel
{
	private TeleFrame frame;

	public TelePanelTime (TeleFrame tf)
	{
		frame = tf;
		JLabel clock = new JLabel("Connect mount");

		setPreferredSize(new Dimension(90, 15));
		setLayout(new BorderLayout());
		

		//this updates the time every second
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if (TelePort.getPortStatus())
				{
					clock.setText(TelePort.getTime());
				}
				else
				{
					System.out.println("Port not open");
				}
			}
		}, 0, 1000);
		
		
		clock.setHorizontalAlignment(JLabel.RIGHT);

		
		add(clock);

	}
}