/*
	This class is reserved for 
	the main functionality of the GUI.
	There should be no GUI elements here.
	Only calculations, getters, setters, and 
	anything that is function goes here and in other
	model classes.

	This and TelePort.java are the only model classes
	so far for this GUI.
*/
	
public class TeleModel
{
	public TeleModel()
	{

	}

	public void makeConfigFrame()
	{
		new TeleFrameConfig();
	}

	public void makeVideoFrame()
	{
		new TeleFrameVideo();
	}

	public void makePlanetFrame()
	{
		new TeleFramePlanet();
	}
}