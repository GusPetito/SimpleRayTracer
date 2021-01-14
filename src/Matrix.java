
public class Matrix {
	//Rows then columns
	private double[][] data;
	
	public Matrix(double[][] data) {
		this.data = data;
	}
	
	public Matrix multiply(Matrix other) {
		//The columns of the 1st have to equal the rows of the second
		if(data[0].length != other.data.length) return null;
		double[][] temp = new double[data.length][other.data[0].length];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < other.data[0].length; j++) {
				for(int k = 0; k < other.data.length; k++) {
					temp[i][j] += data[i][k] * other.data[k][j];
				}
			}
		}
		return new Matrix(temp);
	}
	
	public String toString() {
		String result = "";
		for(int r = 0; r < data.length; r++) {
			for(int c = 0; c < data[0].length; c++) {
				result += data[r][c] + " ";
			}
			result += "\n";
		}
		return result;
	}
	
	public Vector toVector() {
		//Precondition: Must be 3 by 1 matrix
		return new Vector(data[0][0], data[1][0], data[2][0]);
	}
}
