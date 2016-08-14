/*
	This class is the frame for 
	the telescope configuration
	options. It contains TelePanelConfig.java
*/

import javax.swing.*;
import java.awt.*;

public class TeleFrameConfig extends JFrame
{
	private TeleModel model;
	
	public TeleFrameConfig()
	{
		setTitle("TeleGuiConfig [WIP]");
		setSize(500,200);

		model = new TeleModel();

		add(new TelePanelConfig(this));

		setVisible(true);
	}

	public TeleModel getModel()
	{
		return model;
	}
}