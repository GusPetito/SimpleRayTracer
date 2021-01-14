
public abstract class GameObject {
	private double x;
	private double y;
	private double z;
	
	public GameObject(double x, double y, double z) {
		this.x = x; this.y = y; this.z = z;
	}
	
	public abstract Double findIntersection(Ray ray);
	
	public double getX() {return x;}
	public void setX(double x) {this.x = x;}
	public double getY() {return y;}
	public void setY(double y) {this.y = y;}
	public double getZ() {return z;}
	public void setZ(double z) {this.z = z;}
}
