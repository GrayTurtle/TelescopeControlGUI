import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import jssc.SerialPort; 
import jssc.SerialPortException;
import java.nio.charset.StandardCharsets;
public class TelePanelConfig extends JPanel
{
	private TeleFrameConfig frame;
	private JComboBox<String> dropDownMenuCOM;
	private JComboBox<String> dropDownMenuUSB;
	SerialPort serialPort;
	private String port;

	public TelePanelConfig (TeleFrameConfig tf)
	{
		frame = tf;
		setBackground(Color.BLUE);

		String[] comList = {"None", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6"};
		String[] usbList = {"None", "/dev/ttyUSB0", "/dev/ttyUSB1", "/dev/ttyUSB2",
								    "/dev/ttyUSB3", "/dev/ttyUSB4", "/dev/ttyUSB5"};

		setLayout(new GridLayout(2,2));

		JButton okButt = new JButton("Okay");

		JPanel com = new JPanel();
		JPanel okayBox = new JPanel();
		JPanel buttPanel = new JPanel();

		dropDownMenuCOM = new JComboBox<String> (comList);
		dropDownMenuUSB = new JComboBox<String> (usbList);
		JLabel dropDownTitleCOM = new JLabel("Windows Port");
		JLabel dropDownTitleUSB = new JLabel("Linux Port");

		okayBox.setLayout(new BorderLayout());
		buttPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		com.setLayout(new GridLayout(2,2));

		add(com);
		add(new JPanel());
		add(new JPanel());
		add(okayBox);

		com.add(dropDownTitleCOM);
		com.add(dropDownMenuCOM);
		com.add(dropDownTitleUSB);
		com.add(dropDownMenuUSB);
		okayBox.add(buttPanel, BorderLayout.SOUTH);
		buttPanel.add(okButt);

		okButt.addActionListener(new ActionHandler("ok"));
		dropDownMenuCOM.addActionListener(new ActionHandler("temp"));
		dropDownMenuUSB.addActionListener(new ActionHandler("temp"));

	}

	private class ActionHandler implements ActionListener
	{
		String butt;


		ActionHandler(String s)
		{
			butt = s;
		}

		public void actionPerformed(ActionEvent e)
		{
			String choiceCOM = (String) dropDownMenuCOM.getSelectedItem();
			String choiceUSB = (String) dropDownMenuUSB.getSelectedItem();

			if (butt.equals("ok"))
			{
				frame.dispose();
			}
			
			if (choiceCOM.equals("COM1") && choiceUSB.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("COM1");	
				TelePort.setPortStatus();
			}
			else if (choiceCOM.equals("COM2") && choiceUSB.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("COM2");
				TelePort.setPortStatus();
			}
			else if (choiceCOM.equals("COM3") && choiceUSB.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("COM3");
				TelePort.setPortStatus();
			}
			else if (choiceCOM.equals("COM4") && choiceUSB.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("COM4");
				TelePort.setPortStatus();
			}
			else if (choiceCOM.equals("COM5") && choiceUSB.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("COM5");
				TelePort.setPortStatus();
			}
			else if (choiceCOM.equals("COM6") && choiceUSB.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("COM6");
				TelePort.setPortStatus();
			}
			else if (choiceUSB.equals("/dev/ttyUSB0") && choiceCOM.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("/dev/ttyUSB0");
				TelePort.setPortStatus();
			}
			else if (choiceUSB.equals("/dev/ttyUSB1") && choiceCOM.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("/dev/ttyUSB1");
				TelePort.setPortStatus();
			}
			else if (choiceUSB.equals("/dev/ttyUSB2") && choiceCOM.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("/dev/ttyUSB2");
				TelePort.setPortStatus();
			}
			else if (choiceUSB.equals("/dev/ttyUSB3") && choiceCOM.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("/dev/ttyUSB3");
				TelePort.setPortStatus();
			}
			else if (choiceUSB.equals("/dev/ttyUSB4") && choiceCOM.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("/dev/ttyUSB4");
				TelePort.setPortStatus();
			}
			else if (choiceUSB.equals("/dev/ttyUSB5") && choiceCOM.equals("None") && !butt.equals("ok"))
			{
				TelePort.portOpen("/dev/ttyUSB5");
				TelePort.setPortStatus();
			}
		}
	}
}