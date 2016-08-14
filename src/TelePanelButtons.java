/*
	This class is for the "cross" of buttons on the GUI.
	It is for moving the mount manually north, east, south, west.
	The Track button currently doesn't do anything.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelePanelButtons extends JPanel
{
	private TeleFrame frame;

	public TelePanelButtons(TeleFrame tf)
	{
		frame = tf;

		JButton north = new JButton("N");
		JButton west = new JButton("W");
		JButton track = new JButton("Track");
		JButton east = new JButton("E");
		JButton south = new JButton("S");

		setPreferredSize(new Dimension(300, 250));

		setLayout(new GridLayout(3,3));

		add(new JPanel());
		add(north);
		add(new JPanel());
		add(west);
		add(track);
		add(east);
		add(new JPanel());
		add(south);
		add(new JPanel());

		north.addMouseListener(new MouseHandler("^"));
		south.addMouseListener(new MouseHandler("v"));
		east.addMouseListener(new MouseHandler(">"));
		west.addMouseListener(new MouseHandler("<"));
	}

	//When button pressed
	private class MouseHandler extends MouseAdapter
	{
		String state;
		public MouseHandler(String s)
		{
			state = s;
		}
		public void mousePressed(MouseEvent e)
		{
			if(state.equals("^"))
			{
				TelePort.sendMssg(":Mn#");
				System.out.println("north");
			}
			else if(state.equals("v"))
			{
				TelePort.sendMssg(":Ms#");
				System.out.println("south");
			}
			else if(state.equals("<"))
			{
				TelePort.sendMssg(":Mw#");
				System.out.println("west");
			}
			else if(state.equals(">"))
			{
				TelePort.sendMssg(":Me#");
				System.out.println("east");
			}
		}
		
		//when button released
		public void mouseReleased(MouseEvent e)
		{
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				TelePort.sendMssg(":Q#");
				System.out.println("stop");
			}
		}

	}
}