
public class Rectangle extends Plane{
	//origin is top left of square
	//The two vectors represent the sides of the rectangle
	private Vector s1; //Top left to top right
	private Vector s2; //Top right to bottom right
	
	public Rectangle(double x, double y, double z, Vector s1, Vector s2) {
		super(x,y,z,s1.crossProduct(s2));
		this.s1 = s1; this.s2 = s2;
	}
	
	public Vector getS1() {return s1;}
	public Vector getS2() {return s2;}
	
	@Override
	public Double findIntersection(Ray ray) {
		Double t = super.findIntersection(ray);
		if(t == null) return null;
		else {
			Vector intersection = ray.findIntersection(t);//TODO - why when y is 0 is it not fully underground?
			Vector p1 = new Vector(getX(),getY(),getZ());
			Vector n1 = s1.crossProduct(getNormal());
			Vector p2 = p1.add(s1);
			Vector n2 = s2.crossProduct(getNormal());
			Vector p3 = p2.add(s2);
			Vector p4 = p1.add(s2);
			Vector s3 = p4.subtract(p3);
			Vector s4 = p1.subtract(p4);
			Vector n3 = s3.crossProduct(getNormal());
			Vector n4 = s4.crossProduct(getNormal());
			if(n1.dotProduct(intersection) <= n1.dotProduct(p1) && n2.dotProduct(intersection) <= n2.dotProduct(p2) && 
					n3.dotProduct(intersection) <= n3.dotProduct(p3) && n4.dotProduct(intersection) <= n4.dotProduct(p4)) return t;
		}
		return null;
	}
}