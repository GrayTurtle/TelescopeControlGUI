/*
	This class is for user inputted
	coordinates for the telescope to
	slew to.
*/

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class TelePanelInput extends JPanel
{
	private TeleFrame frame;
	private JTextField aziDegrees = new JTextField();
	private JTextField aziArcmin = new JTextField();
	private JTextField aziArcsec = new JTextField();
	private JTextField eleDegrees = new JTextField();
	private JTextField eleArcmin = new JTextField();
	private JTextField eleArcsec = new JTextField();
	private JTextField rigHours = new JTextField();
	private JTextField rigMin = new JTextField();
	private JTextField rigSec = new JTextField();
	private JTextField decDegrees = new JTextField();
	private JTextField decArcmin = new JTextField();
	private JTextField decArcsec = new JTextField();

	public TelePanelInput(TeleFrame tf)
	{
		frame = tf;
		setPreferredSize(new Dimension(400, 250));
		setLayout(new GridLayout(2,2));

		JPanel aziPanel = new JPanel();
		JPanel elePanel = new JPanel();
		JPanel rigPanel = new JPanel();
		JPanel decPanel = new JPanel();

		JLabel aziDegUnit = new JLabel("'");
		JLabel aziArcminUnit = new JLabel("'");
		JLabel aziArcsecUnit = new JLabel("''");
		JLabel eleDegUnit = new JLabel("'");
		JLabel eleArcminUnit = new JLabel("'");
		JLabel eleArcsecUnit = new JLabel("''");
		JLabel rigDegUnit = new JLabel("'");
		JLabel rigArcminUnit = new JLabel("'");
		JLabel rigArcsecUnit = new JLabel("''");
		JLabel decDegUnit = new JLabel("'");
		JLabel decArcminUnit = new JLabel("'");
		JLabel decArcsecUnit = new JLabel("''");

		TitledBorder titleAzi = new TitledBorder("Azimuth");
		TitledBorder titleEle = new TitledBorder("Elevation");
		TitledBorder titleRig = new TitledBorder("Right Ascension");
		TitledBorder titleDec = new TitledBorder("Declination");

		titleAzi.setTitleJustification(TitledBorder.CENTER);
		titleEle.setTitleJustification(TitledBorder.CENTER);
		titleRig.setTitleJustification(TitledBorder.CENTER);
		titleDec.setTitleJustification(TitledBorder.CENTER);

		aziPanel.setBorder(titleAzi);
		elePanel.setBorder(titleEle);
		rigPanel.setBorder(titleRig);
		decPanel.setBorder(titleDec);

		aziPanel.setLayout(new GridLayout(1,7));
		elePanel.setLayout(new GridLayout(1,7));
		rigPanel.setLayout(new GridLayout(1,7));
		decPanel.setLayout(new GridLayout(1,7));

		aziPanel.add(new JPanel());
		aziPanel.add(aziDegrees);
		aziPanel.add(aziDegUnit);
		aziPanel.add(aziArcmin);
		aziPanel.add(aziArcminUnit);
		aziPanel.add(aziArcsec);
		aziPanel.add(aziArcsecUnit);
		elePanel.add(new JPanel());
		elePanel.add(eleDegrees);
		elePanel.add(eleDegUnit);
		elePanel.add(eleArcmin);
		elePanel.add(eleArcminUnit);
		elePanel.add(eleArcsec);
		elePanel.add(eleArcsecUnit);
		rigPanel.add(new JPanel());
		rigPanel.add(rigHours);
		rigPanel.add(rigDegUnit);
		rigPanel.add(rigMin);
		rigPanel.add(rigArcminUnit);
		rigPanel.add(rigSec);
		rigPanel.add(rigArcsecUnit);
		decPanel.add(new JPanel());
		decPanel.add(decDegrees);
		decPanel.add(decDegUnit);
		decPanel.add(decArcmin);
		decPanel.add(decArcminUnit);
		decPanel.add(decArcsec);
		decPanel.add(decArcsecUnit);

		add(aziPanel);
		add(elePanel);
		add(rigPanel);
		add(decPanel);
	}

	//These are getters for the TelePort.java to send
	//RA and declination from the user.

	public String getRightHour()
	{
		return rigHours.getText();
	}
	public String getRightMin()
	{
		return rigMin.getText();
	}
	public String getRightSec()
	{
		return rigSec.getText();
	}

	public String getDecDeg()
	{
		return decDegrees.getText();
	}
	public String getDecMin()
	{
		return decArcmin.getText();
	}
	public String getDecSec()
	{
		return decArcsec.getText();
	}
}