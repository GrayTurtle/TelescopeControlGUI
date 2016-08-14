/*
	This model class handles the USB communication
	with the jssc library.

	This is where a lot of experimentation was done 
	because I had no idea how USBCOM in Java would
	be done. For example, every single method here
	is static

*/
import jssc.SerialPort; 
import jssc.SerialPortException;
import java.nio.charset.StandardCharsets;

public class TelePort
{
	private static boolean isPortOpen = false;
	private static SerialPort serialPort;

	//this method opens the port
	public static synchronized void portOpen(String port)
	{
		serialPort = new SerialPort(port);	
		try
		{
			serialPort.openPort();

			//this writes a string command to the mount
			//the string is from the manual of commands
			serialPort.writeBytes(":Q#".getBytes(StandardCharsets.US_ASCII));
			serialPort.setParams(9600, 8, 1, 0);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}
	}

	public static synchronized void sendMssg(String message)
	{	
		try
		{
			serialPort.writeBytes(message.getBytes(StandardCharsets.US_ASCII));
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}
	}

	public static synchronized String getTime()
	{
		String time = null;
		try
		{
			serialPort.writeBytes(":GL#".getBytes(StandardCharsets.US_ASCII));

			byte[] buffer = serialPort.readBytes(11);
			time = new String(buffer, StandardCharsets.US_ASCII);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}

		return time; 
	}

	public static synchronized String getLongitude()
	{
		String longitude = null;
		try
		{
			serialPort.writeBytes(":Gg#".getBytes(StandardCharsets.US_ASCII));

			byte[] buffer = serialPort.readBytes(11);
			longitude = new String(buffer, StandardCharsets.US_ASCII);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}

		return longitude; 
	}

	public static synchronized String getLatitude()
	{
		String latitude = null;
		try
		{
			serialPort.writeBytes(":Gt#".getBytes(StandardCharsets.US_ASCII));

			byte[] buffer = serialPort.readBytes(10);
			latitude = new String(buffer, StandardCharsets.US_ASCII);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}

		return latitude; 
	}

	public static synchronized String getAltitude()
	{
		String altitude = null;
		try
		{
			serialPort.writeBytes(":GA#".getBytes(StandardCharsets.US_ASCII));

			byte[] buffer = serialPort.readBytes(10);
			altitude = new String(buffer, StandardCharsets.US_ASCII);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}

		return altitude; 
	}

	public static synchronized String getAzimuth()
	{
		String azimuth = null;
		try
		{
			serialPort.writeBytes(":GZ#".getBytes(StandardCharsets.US_ASCII));

			byte[] buffer = serialPort.readBytes(10);
			azimuth = new String(buffer, StandardCharsets.US_ASCII);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}

		return azimuth; 
	}

	public static synchronized String getElevation()
	{
		String elevation = null;
		try
		{
			serialPort.writeBytes(":GA#".getBytes(StandardCharsets.US_ASCII));

			byte[] buffer = serialPort.readBytes(10);
			elevation = new String(buffer, StandardCharsets.US_ASCII);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}

		return elevation; 
	}
	
	public static synchronized String getRightAsc()
	{
		String rightAsc = null;
		try
		{
			serialPort.writeBytes(":GR#".getBytes(StandardCharsets.US_ASCII));

			byte[] buffer = serialPort.readBytes(11);
			rightAsc = new String(buffer, StandardCharsets.US_ASCII);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}

		return rightAsc; 
	}

	public static synchronized String getDeclination()
	{
		String declination = null;
		try
		{
			serialPort.writeBytes(":GD#".getBytes(StandardCharsets.US_ASCII));

			byte[] buffer = serialPort.readBytes(10);
			declination = new String(buffer, StandardCharsets.US_ASCII);
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}

		return declination; 
	}

	//this is for giving user input to the mount
	public static synchronized void rightAsc(String hr, String m, String s)
	{
		try
		{
			serialPort.writeBytes((":Sr " + hr + ":" + m + ":" + s + "#").getBytes(StandardCharsets.US_ASCII));
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}
	}

	public static synchronized void declination(String d, String m, String s)
	{
		try
		{
			serialPort.writeBytes((":Sd " + d + "*" + m + ":" + s + "#").getBytes(StandardCharsets.US_ASCII));
		}
		catch (SerialPortException ex) 
   		{
      		System.out.println(ex);
  		}
	}

	//once the port is open, it sets isPortOpen to true
	public static synchronized void setPortStatus()
	{
		isPortOpen = true;
	}
	public static synchronized boolean getPortStatus()
	{
		return isPortOpen;
	}
}