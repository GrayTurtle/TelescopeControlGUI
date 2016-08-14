/*
	This class gives current location details.
*/

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.Timer;
import java.util.TimerTask;

public class TelePanelGPS extends JPanel
{
	private TeleFrame frame;

	public TelePanelGPS(TeleFrame tf)
	{
		frame = tf;
		
		setPreferredSize(new Dimension(300, 250));

		TitledBorder title = new TitledBorder("Current Location");
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);
		 
		setLayout(new GridLayout(3,0));
		
		JLabel longi = new JLabel("Longitude: ");
		JLabel lat = new JLabel("Latitude: ");
		JLabel alti = new JLabel("Altitude: ");
		
		//This timer is used to update the location details every second.
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if (TelePort.getPortStatus())
				{
					longi.setText("Longitude: " + TelePort.getLongitude());
					lat.setText("Latitude: " + TelePort.getLatitude());
					alti.setText("Altitude: " + TelePort.getAltitude());
				}
				else
				{
					System.out.println("Port not open");
				}
			}
		}, 0, 1000);
		
		add(longi);
		add(lat);
		add(alti);
		
	}
}