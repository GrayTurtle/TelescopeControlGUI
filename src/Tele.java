//@author John Tran and Emily Cook
/*
	This main class (on the bottom) creates the main frame.
	The entire code follows (mostly) model view controller
	architecture and has multiple panels to hold all of the
	features of the telescope controller.
	The classes that are in this program are:
	-Tele.java
	-TeleFrame.java
	-TeleFrameVideo.java
	-TeleFrameConfig.java
	-TeleFramePlanet.java
	-TeleModel.java
	-TelePanelBot.java
	-TelePanelButtons.java
	-TelePanelConfig.java
	-TelePanelContainer.java
	-TelePanelCoord.java
	-TelePanelGPS.java
	-TelePanelInput.java
	-TelePanelMid.java
	-TelePanelObject.java
	-TelePanelOptions.java
	-TelePanelSlew.java
	-TelePanelTime.java
	-TelePanelTop.java
	-TelePort.java

	This piece of software is basically a frame that has a panel within panels
	within panels. Please refer to the additional documentation provided to see
	which panels contain which panels (or just read the code).

	You might have noticed how I passed the frame into most of the code. 
	This was because I wanted to have a lot of the classes access the model 
	from the frame. However, a lot of that is just there just for the future and
	currently does not have much function.

	A list of known bugs are:
	-The program is too big on smaller screens. There needs to be a way to dynamically resize
	 according to relative screen resolution.
	-Choosing a second port after the program has already selected a port it will throw a "Port
	 busy" exception.
	-Response time is slow. Probably because of Java or the way I programmed this.
	-When the user inputs custom coordinates, you have to press the "Slew" button twice for the mount to move
	 to the coordinates. It also destroys the formatting of the information presented on the GUI. I have no idea
	 nor the time to fix that problem. It has to do with the amount and the way the bytes are being sent and sent
	 back, I'm sure.

	This GUI is currently incomplete, so if you contribute
	please try to follow the same formatting to make it 
	easy for programmers in the future to decode what is
	happening. On the other hand, if you
	feel there is a need to organized the code in a more effiecient way, by all means go for it.
	Go ahead and add your name to the top if you
	add/change anything reasonable to the code.
	Plus, I didn't do the javadoc commenting because I didn't think it's
	really important at this stage of development.
	Also, I'm not sure if this would even be used in the future or not.
	I am by no means an expert in programming. I'm just a freshman.
	I tried my best with this GUI and I hope there isn't too much confusion.
	If there is, contact me.

	contact info: johtr@okstate.edu or just ask Waid Schaelgal for me
*/

public class Tele
{
	public static void main(String[] args) 
	{
		new TeleFrame();
	}
}