package FourSidedShapes;

public class Line {
	
	private Point p1;
	private Point p2;
	
	public Point getP1() {
		return p1;
	}

	private void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	private void setP2(Point p2) {
		this.p2 = p2;
	}

	public Line (Point pointA, Point pointB) {
		setP1(pointA);
		setP2(pointB);
	}
	
	public double getLength() {
		double xDist = Math.abs( getP1().getX() - getP2().getX() );
		double yDist = Math.abs( getP1().getY() - getP2().getY() );
		double totDist = Math.sqrt( (xDist * xDist) + (yDist * yDist) );	
		return totDist;	
	}
	
	public double getSlope() {
		double xDist = getP1().getX() - getP2().getX();
		double yDist =  getP1().getY() - getP2().getY();
		double slopeGrad = yDist / xDist;
		return slopeGrad;
	}

}
