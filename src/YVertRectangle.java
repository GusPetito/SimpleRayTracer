
public class YVertRectangle extends Plane{
	private double width;
	private double height;
	
	public YVertRectangle(double x, double y, double z, double width, double height) {
		super(x,y,z,1,0,0);
		this.width = width; this.height = height;
	}
	
	@Override
	public Double findIntersection(Ray ray) {
		Double t = super.findIntersection(ray);
		if(t == null) return null;
		else {
			Vector intersection = ray.findIntersection(t);
			if(intersection.getZ() > getZ() && intersection.getZ() < getZ() + width && intersection.getY() < getY() && intersection.getY() > getY() - height) return t;
		}
		return null;
	}
}
