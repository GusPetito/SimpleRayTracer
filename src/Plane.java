
public class Plane extends GameObject{
	//normal is the normal vector of the plane
	private Vector normal;
	
	public Plane(double x, double y, double z, double normX, double normY, double normZ) {
		super(x,y,z);
		normal = new Vector(normX, normY, normZ).unitVector();
	}
	
	public Plane(double x, double y, double z, Vector normal) {
		super(x,y,z);
		this.normal = normal.unitVector();
	}
	
	public Vector getNormal() {return normal;}
	
	@Override
	public Double findIntersection(Ray ray) {
		//Returns null if it doesn't intersect
		//If the point of intersection is P, and Q is the point we used to define the plane, then normal * (P-Q) == 0 b/c they're orthogonal
		//That means N*(E + tD - Q) = 0 based on the definition of a ray
		//Doing algebra, t = N*(Q-E)/(N*D)
		//The ray is parallel with the plane if the ray and direction are orthogonal, so they're not intersecting
		Double temp = ray.getDirVec().dotProduct(normal);
		if(Math.abs(temp) < Driver.EPSILON) return null;
		double t = normal.dotProduct(new Vector(getX(),getY(),getZ()).subtract(new Vector(ray.getX(),ray.getY(),ray.getZ()))) / normal.dotProduct(ray.getDirVec());
		//They intersect if t is positive (IE in front of us)
		if(t >= 0) return t;
		return null;
	}
}
