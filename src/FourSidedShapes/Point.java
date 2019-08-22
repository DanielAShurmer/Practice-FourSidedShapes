package FourSidedShapes;

public class Point {
	
	private double x;
	private double y;
	
	public double getX() {
		return x;
	}

	private void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	private void setY(double y) {
		this.y = y;
	}
	
	public Point(double X, double Y) {
		setX(X);
		setY(Y);
	}
	
	public double distanceTo(Point secondPoint) {
		double xDist = Math.abs( this.getX() - secondPoint.getX() );
		double yDist = Math.abs( this.getY() - secondPoint.getY() );
		double totDist = Math.sqrt( (xDist * xDist) + (yDist * yDist) );	
		return totDist;	
	}
	
	public String toString() {
		return String.format("X:%.2f Y:%.2f", getX(), getY());
	}

}
