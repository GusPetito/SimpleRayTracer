
public class Ray extends GameObject{
	//A ray is in the form of E + tD, where E is the origin and D is the direction vector
	//E is in the form [x,y,z], and so is D
	private Vector dirVec;
	
	public Ray(double x, double y, double z, Vector direction) {
		super(x,y,z);
		//Normalizing
		dirVec = direction.unitVector();
	}//TODO - make it go through middle of pixel
	
	public Vector getDirVec() {return dirVec;}
	
	public Double findIntersection(Ray ray) {return null;}
	
	public Vector findIntersection(double t) {
		return new Vector(getX(),getY(),getZ()).add(dirVec.multiply(t));
	}
	
}
