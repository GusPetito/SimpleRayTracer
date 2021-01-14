import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keychecker implements KeyListener {
	public static boolean upIsPressed = false;
	public static boolean downIsPressed = false;
	public static boolean leftIsPressed = false;
	public static boolean rightIsPressed = false;
	public static boolean wIsPressed = false;
	public static boolean sIsPressed = false;
	public static boolean aIsPressed = false;
	public static boolean dIsPressed = false;
	public static boolean spaceIsPressed = false;
	public static boolean shiftIsPressed = false;

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) upIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN) downIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_LEFT) leftIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) rightIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_W) wIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_S) sIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_A) aIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_D) dIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_SPACE) spaceIsPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) shiftIsPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) upIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN) downIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_LEFT) leftIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) rightIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_W) wIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_S) sIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_A) aIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_D) dIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_SPACE) spaceIsPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) shiftIsPressed = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
}
