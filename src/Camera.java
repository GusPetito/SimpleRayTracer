
public class Camera {
	private double x;
	private double y;
	private double z;
	private double roll;
	private double pitch;
	private double yaw;
	
	public Camera() {
		//Roll rotates around the z-axis
		//Pitch rotates around the x-axis
		//Yaw rotates around the y-axis
		//0 for everything would make the camera look straight on the z-axis
		x = 0; y = 0; z = 0; roll = 0; pitch = 0; yaw = 0;
	}
	
	public double getX() {return x;}
	public void incrementX(double amount) {x += amount;}
	public double getY() {return y;}
	public void incrementY(double amount) {y += amount;}
	public double getZ() {return z;}
	public void incrementZ(double amount) {z += amount;}
	public double getRoll() {return roll;}
	public void incrementRoll(double amount) {roll += amount;}
	public double getPitch() {return pitch;}
	public void setPitch(double pitch) {this.pitch = pitch;}
	public void incrementPitch(double amount) {pitch += amount;}
	public double getYaw() {return yaw;}
	public void incrementYaw(double amount) {yaw += amount;}
}
