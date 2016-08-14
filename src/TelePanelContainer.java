/*
	This class is a container contains other containers
	A lot of the code uses GridBagLayout, which is new to me. Feel 
	free to fix it all up. 
*/
import javax.swing.*;
import java.awt.*;

public class TelePanelContainer extends JPanel
{
	private TeleFrame frame;

	public TelePanelContainer(TeleFrame tf)
	{
		frame = tf;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//This adds the clock panel
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		add(new TelePanelTime(frame), c);

		//This adds the top panel that contains the current location
		//and object details panels
		c.insets = new Insets(0,0,0,0);
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 1;
		add(new TelePanelTop(frame), c);

		//this adds the middle panel that contains the button and user input
		//panels
		c.insets = new Insets(0,0,0,0);
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 2;
		add(new TelePanelMid(frame), c);

		//This adds the bottom panel that contains the current location details
		//and telescope status and options panels
		c.insets = new Insets(0,0,0,0);
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		add(new TelePanelBot(frame), c);
	}
}