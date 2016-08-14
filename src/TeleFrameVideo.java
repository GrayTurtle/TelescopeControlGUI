/*
	This class is for the frame
	containing the video feed
	from the webcam.
*/

import javax.swing.*;
import java.awt.*;

public class TeleFrameVideo extends JFrame
{
	private TeleModel model;

	public TeleFrameVideo()
	{
		setTitle("TeleGuiVideo [WIP]");
		setSize(500,500);
		model = new TeleModel();
		setVisible(true);
	}

	public TeleModel getModel()
	{
		return model;
	}
}