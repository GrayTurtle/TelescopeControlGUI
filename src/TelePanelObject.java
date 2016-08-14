/*
	This class has the details of the object
	that is being tracked. 
	This currently doesn't do anything.
*/
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class TelePanelObject extends JPanel
{
	private TeleFrame frame;

	public TelePanelObject(TeleFrame tf)
	{
		frame = tf;
		
		setPreferredSize(new Dimension(400, 250));
		setLayout(new GridLayout(10,1));

		TitledBorder title = new TitledBorder("Object Details");
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);

		JLabel objectName = new JLabel("Name: " + ".............................");
		JLabel azimuth = new JLabel("Azimuth: " + "000' 000' 000\"");
		JLabel elevation = new JLabel("Elevation: " + "000' 000' 000\"");
		JLabel rightasc = new JLabel("Right Ascension: " + "000' 000' 000\"");
		JLabel decline = new JLabel("Declination: " + "000' 000' 000\"");
		JLabel longitude = new JLabel("Longitude: " + "000' 000' 000\"");
		JLabel latitude = new JLabel("Latitude: " + "000' 000' 000\"");
		JLabel altitude = new JLabel("Altitude: " + "000' 000' 000\"");
		JLabel range = new JLabel("Range: " + "000' 000' 000\"");
		JLabel velocity = new JLabel("Velocity: " + "000' 000' 000\"");

		objectName.setHorizontalAlignment(JLabel.CENTER);
		azimuth.setHorizontalAlignment(JLabel.CENTER);
		elevation.setHorizontalAlignment(JLabel.CENTER);
		rightasc.setHorizontalAlignment(JLabel.CENTER);
		decline.setHorizontalAlignment(JLabel.CENTER);
		longitude.setHorizontalAlignment(JLabel.CENTER);
		latitude.setHorizontalAlignment(JLabel.CENTER);
		altitude.setHorizontalAlignment(JLabel.CENTER);
		range.setHorizontalAlignment(JLabel.CENTER);
		velocity.setHorizontalAlignment(JLabel.CENTER);

		add(objectName);
		add(azimuth);
		add(elevation);
		add(rightasc);
		add(decline);
		add(longitude);
		add(latitude);
		add(altitude);
		add(range);
		add(velocity);
	}
}