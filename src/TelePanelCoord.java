/*
	This class has the current coordinates
	for the telescope mount.
*/

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.Timer;
import java.util.TimerTask;

public class TelePanelCoord extends JPanel
{
	private TeleFrame frame;

	public TelePanelCoord(TeleFrame tf)
	{
		frame = tf;
		setPreferredSize(new Dimension(300, 250));
		
		setLayout(new GridLayout(4,1));

		JLabel azimuth = new JLabel("0'    0'    0''");
		JLabel elevation = new JLabel("0'    0'    0''");
		JLabel rightasc = new JLabel("0h   0m   0s");
		JLabel decline = new JLabel("0'    0'    0''");

		azimuth.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		elevation.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		rightasc.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		decline.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

		azimuth.setHorizontalAlignment(JLabel.CENTER);
		elevation.setHorizontalAlignment(JLabel.CENTER);
		rightasc.setHorizontalAlignment(JLabel.CENTER);
		decline.setHorizontalAlignment(JLabel.CENTER);

		TitledBorder titleAzi = new TitledBorder("Current Azimuth");
		TitledBorder titleEle = new TitledBorder("Current Elevation");
		TitledBorder titleRig = new TitledBorder("Current Right Ascension");
		TitledBorder titleDec = new TitledBorder("Current Declination");

		titleAzi.setTitleJustification(TitledBorder.CENTER);
		titleEle.setTitleJustification(TitledBorder.CENTER);
		titleRig.setTitleJustification(TitledBorder.CENTER);
		titleDec.setTitleJustification(TitledBorder.CENTER);

		azimuth.setBorder(titleAzi);
		elevation.setBorder(titleEle);
		rightasc.setBorder(titleRig);
		decline.setBorder(titleDec);

		//This timer is used to update the coordinates every second.
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if (TelePort.getPortStatus())
				{
					azimuth.setText(TelePort.getAzimuth());
					elevation.setText(TelePort.getElevation());
					rightasc.setText(TelePort.getRightAsc());
					decline.setText(TelePort.getDeclination());
				}
				else
				{
					System.out.println("Port not open");
				}
			}
		}, 0, 1000);

		add(azimuth);
		add(elevation);
		add(rightasc);
		add(decline);
	}
}