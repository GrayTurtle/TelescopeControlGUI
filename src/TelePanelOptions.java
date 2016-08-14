/*
	This class contains telescope tracking
	options and status.
	The only functional thing is the 
	status.
*/

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.Timer;
import java.util.TimerTask;

public class TelePanelOptions extends JPanel
{
	private TeleFrame frame;

	public TelePanelOptions(TeleFrame tf)
	{
		frame = tf;

		setPreferredSize(new Dimension(400, 250));
		setLayout(new GridLayout(4,1));

		TitledBorder title = new TitledBorder("Telescope");
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);

		JLabel teleStatus = new JLabel("Telescope Status: No Connection");

		JRadioButton sidereal = new JRadioButton("Sidereal Tracking");
		JRadioButton solar = new JRadioButton("Solar Tracking");

		JLabel otherStuff = new JLabel("Other Stuff");

		//this is used to update the status every second
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if (TelePort.getPortStatus())
				{
					teleStatus.setText("Telescope Status: Connected");
				}
				else
				{
					System.out.println("Port not open");
				}
			}
		}, 0, 1000);

		add(teleStatus);
		add(sidereal);
		add(solar);
		add(otherStuff);
	}
}