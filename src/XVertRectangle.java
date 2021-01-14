
public class XVertRectangle extends Plane{
	private double width;
	private double height;
	
	public XVertRectangle(double x, double y, double z, double width, double height) {
		super(x,y,z,0,0,1);
		this.width = width; this.height = height;
	}
	
	@Override
	public Double findIntersection(Ray ray) {
		Double t = super.findIntersection(ray);
		if(t == null) return null;
		else {
			Vector intersection = ray.findIntersection(t);
			if(intersection.getX() > getX() && intersection.getX() < getX() + width && intersection.getY() < getY() && intersection.getY() > getY() - height) return t;
		}
		return null;
	}
}
