import java.awt.Color;

public class Driver {
	private GameFrame frame;
	private GamePanel panel;
	private Plane plane;
	private XVertRectangle rect;
	private Camera camera;
	private Keychecker keychecker;
	private Vector[] rays;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	private double halfWidth;
	private double halfHeight;
	public static final int VIEWLENGTH = 200; //Smaller viewlength increases weirdness
	public static final double EPSILON = 1e-14;
	
	public static void main(String[] args) {
		Driver driver = new Driver();
	}
	
	public Driver() {
		halfWidth = WIDTH/2.0;
		halfHeight = HEIGHT/2.0;
		frame = new GameFrame(WIDTH,HEIGHT);
		frame.setVisible(true);
		plane = new Plane(0,-1,0,0,1,0);
		rect = new XVertRectangle(0,1,1,2,2);
		panel = new GamePanel(WIDTH, HEIGHT);
		frame.add(panel);
		camera = new Camera();
		keychecker = new Keychecker();
		frame.addKeyListener(keychecker);
		
		tick();
	}
	
	public void tick() {
		int counter = 0;
		while(true) {
			
			long startTime = System.nanoTime();
			
			if(Keychecker.upIsPressed) camera.incrementPitch(-0.05);
			if(Keychecker.downIsPressed) camera.incrementPitch(0.05);
			if(Keychecker.leftIsPressed) camera.incrementYaw(-0.05);
			if(Keychecker.rightIsPressed) camera.incrementYaw(0.05);
			if(Keychecker.wIsPressed) {
				camera.incrementZ(0.1*Math.cos(camera.getYaw()));
				camera.incrementX(0.1*Math.sin(camera.getYaw()));
			}
			if(Keychecker.sIsPressed) {
				camera.incrementZ(-0.1*Math.cos(camera.getYaw()));
				camera.incrementX(-0.1*Math.sin(camera.getYaw()));
			}
			if(Keychecker.aIsPressed) {
				camera.incrementZ(0.1*Math.sin(camera.getYaw()));
				camera.incrementX(-0.1*Math.cos(camera.getYaw()));
			}
			if(Keychecker.dIsPressed) {
				camera.incrementZ(-0.1*Math.sin(camera.getYaw()));
				camera.incrementX(0.1*Math.cos(camera.getYaw()));
			}
			if(Keychecker.spaceIsPressed) camera.incrementY(0.1);
			if(Keychecker.shiftIsPressed) camera.incrementY(-0.1);
			
			double cosPitch = Math.cos(camera.getPitch());
			double sinPitch = Math.sin(camera.getPitch());
			double cosYaw = Math.cos(camera.getYaw());
			double sinYaw = Math.sin(camera.getYaw());
			
			Ray tempRay;
			for(int x = 0; x < WIDTH; x++) {
				for(int y = 0; y < HEIGHT; y++) {
					double[] dirVecOld = {x-halfWidth, halfHeight-y, VIEWLENGTH};
					double[] dirVec = {dirVecOld[0], dirVecOld[1]*cosPitch - dirVecOld[2]*sinPitch, dirVecOld[2]*cosPitch + dirVecOld[1]*sinPitch};
					dirVecOld = dirVec.clone();
					dirVec[0] = dirVecOld[0]*cosYaw + dirVecOld[2]*sinYaw; dirVec[2] = dirVecOld[2]*cosYaw - dirVecOld[0]*sinYaw;
					tempRay = new Ray(camera.getX(),camera.getY(),camera.getZ(), new Vector(dirVec[0], dirVec[1], dirVec[2]));
					Double t0 = rect.findIntersection(tempRay); 
					Double t1 = plane.findIntersection(tempRay);
					//Double t1 = null;
					if(t0 != null && t1 != null) {
						if(t0 > t1) panel.paintPixel(x, y, Color.GREEN);
						else panel.paintPixel(x, y, Color.RED);
					}else if(t0 != null) panel.paintPixel(x, y, Color.RED);
					else if(t1 != null) panel.paintPixel(x, y, Color.GREEN);
					else panel.paintPixel(x, y, Color.BLUE);
				}
			}
			
			panel.repaint();
			
			long endTime = System.nanoTime();
			
			if(counter % 1000 == 0) System.out.println((endTime - startTime) / 1000000 + "milliseconds");
			counter++;
		}
	}
}