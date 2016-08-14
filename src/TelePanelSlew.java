import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class TelePanelSlew extends JPanel
{
	private TeleFrame frame;
	private TelePanelInput input = new TelePanelInput(frame);

	public TelePanelSlew(TeleFrame tf)
	{
		frame = tf;

		setPreferredSize(new Dimension(400, 250));
		setLayout(new GridLayout(2,1));

		JPanel dropDown = new JPanel();
		dropDown.setLayout(new GridLayout(1,2));
		
		JButton slew = new JButton("Slew to coordinates");
		JButton stop = new JButton("Stop");
		
		dropDown.add(slew);
		dropDown.add(stop);
		add(input);
		add(dropDown);

		slew.addActionListener(new ActionHandler("slew"));
		stop.addActionListener(new ActionHandler("stop"));

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
			if (choice.equals("slew"))
			{
				String rightHour = input.getRightHour();
				String rightMin = input.getRightMin();
				String rightSec = input.getRightSec();

				TelePort.rightAsc(rightHour, rightMin, rightSec);

				String decDeg = input.getDecDeg();
				String decMin = input.getDecMin();
				String decSec = input.getDecSec();

				TelePort.declination(decDeg, decMin, decSec);

				TelePort.sendMssg(":MS#");
			}

			if (choice.equals("stop"))
			{
				TelePort.sendMssg(":Q#");
			}
		}
	}
}