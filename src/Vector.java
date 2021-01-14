
public class Vector {
	public double[] direction;
	
	public Vector(double x, double y, double z) {
		direction = new double[3];
		direction[0] = x; direction[1] = y; direction[2] = z;
	}
	
	public double getX() {return direction[0];}
	public double getY() {return direction[1];}
	public double getZ() {return direction[2];}
	
	public String toString() {
		return "<" + direction[0] + "," + direction[1] + "," + direction[2] + ">";
	}
	
	public double dotProduct(Vector other) {
		return direction[0]*other.direction[0] + direction[1]*other.direction[1] + direction[2]*other.direction[2];
	}
	
	public Vector crossProduct(Vector other) {
		return new Vector(direction[1]*other.direction[2]-direction[2]*other.direction[1],
				direction[2]*other.direction[0]-direction[0]*other.direction[2],
				direction[0]*other.direction[1]-direction[1]*other.direction[0]);
	}
	
	public Vector add(Vector other) {
		return new Vector(direction[0] + other.direction[0], direction[1] + other.direction[1], direction[2] + other.direction[2]);
	}
	
	public Vector subtract(Vector other) {
		Vector temp = other.inverse();
		return add(temp);
	}
	
	public Vector multiply(double factor) {
		return new Vector(direction[0] * factor, direction[1] * factor, direction[2] * factor);
	}
	
	public Vector divide(double factor) {
		return multiply(1 / factor);
	}
	
	public Vector inverse() {
		return multiply(-1);
	}
	
	public double magnitude() {
		return Math.sqrt(Math.pow(direction[0], 2) + Math.pow(direction[1], 2) + Math.pow(direction[2], 2));
	}
	
	public Vector unitVector() {
		return divide(magnitude());
	}
	
	public Matrix toMatrix() {
		//Gives a 3 by 1 matrix (3 rows a 1 column)
		double[][] data = {{direction[0]},{direction[1]},{direction[2]}};
		return new Matrix(data);
	}
}
