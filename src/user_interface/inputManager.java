package user_interface;

import java.awt.event.KeyEvent;



public class inputManager {
	public void proceesKeypressed(int KeyCode)
	{
		switch (KeyCode) {
		case KeyEvent.VK_UP: {
			break;
		}
		case KeyEvent.VK_DOWN: {
			break;
		}
		case KeyEvent.VK_RIGHT: {
			break;
		}
		case KeyEvent.VK_LEFT: {
			break;
		}
		case KeyEvent.VK_ENTER: {
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + KeyCode);
		}
	}
}
