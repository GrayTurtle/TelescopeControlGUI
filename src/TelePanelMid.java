/*
	This panel is the middle 1/3 of the GUI.
	This contains TelePanelButtons.java and
	TelePanelSlew.java, which each take 1/2 left 
	and right of this panel.
*/
import javax.swing.*;
import java.awt.*;

public class TelePanelMid extends JPanel
{
	private TeleFrame frame;

	public TelePanelMid(TeleFrame tf)
	{
		frame = tf;

		setPreferredSize(new Dimension(700, 250));

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;

		add(new TelePanelButtons(frame), c);

		c.gridx = 1;
		c.gridy = 0;

		add(new TelePanelSlew(frame), c);
		
	}
}
