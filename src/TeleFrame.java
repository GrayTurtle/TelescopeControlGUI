/*
	This class is the main frame of the program.
	It has all of the menu items and contains
	the main container for all the components.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeleFrame extends JFrame
{
	private TeleModel model;

	public TeleFrame()
	{
		setTitle("TeleGui [WIP]");

		model = new TeleModel();

		//adds a panel to contain all of the components and other containers
		//and passes the frame into the panel.
		add(new TelePanelContainer(this));

		//All of the menu items is to add a menu bar at the top of the frame.
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu teleMenu = new JMenu("Telescope");
		JMenu viewMenu = new JMenu("View");
		JMenu objectMenu = new JMenu("Object");
		JMenu helpMenu = new JMenu("Help");
		JMenu colorConfig = new JMenu("Color Configuration");

		JMenuItem openTLE = new JMenuItem("Open TLE");
		JMenuItem configure = new JMenuItem("Configure Telescope");
		JMenuItem nightMode = new JMenuItem("Night Mode");
		JMenuItem dayMode = new JMenuItem("Day Mode");
		JMenuItem video = new JMenuItem("Video");
		JMenuItem planetarium = new JMenuItem("Planetarium");
		JMenuItem selectObject = new JMenuItem("Select Object");

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(teleMenu);
		menuBar.add(viewMenu);
		menuBar.add(objectMenu);
		menuBar.add(helpMenu);

		fileMenu.add(openTLE);
		teleMenu.add(configure);
		viewMenu.add(colorConfig);
		viewMenu.add(video);
		viewMenu.add(planetarium);
		objectMenu.add(selectObject);
		colorConfig.add(nightMode);
		colorConfig.add(dayMode);

		configure.addActionListener(new ActionHandler("config"));
		nightMode.addActionListener(new ActionHandler("night"));
		video.addActionListener(new ActionHandler("vid"));
		planetarium.addActionListener(new ActionHandler("planet"));

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ActionHandler implements ActionListener
	{
		String choice;

		ActionHandler(String s)
		{
			choice = s;
		}

		public void actionPerformed(ActionEvent e)
		{
			if (choice.equals("config"))
			{
				model.makeConfigFrame();
			}

			if (choice.equals("vid"))
			{
				model.makeVideoFrame();
			}

			if (choice.equals("planet"))
			{
				model.makePlanetFrame();
			}

			if (choice.equals("night"))
			{
				
			}

			repaint();
		}
	}

	//returns the model(functionality part of the code) for all of the components
	//to access it through the frame.
	public TeleModel getModel()
	{
		return model;
	}
}