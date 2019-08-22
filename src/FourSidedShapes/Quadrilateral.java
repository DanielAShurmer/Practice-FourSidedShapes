package FourSidedShapes;

public abstract class Quadrilateral {
	
	private Point point1;
	private Point point2;
	private Point point3;
	private Point point4;
	
	private Line side1;
	private Line side2;
	private Line side3;
	private Line side4;
	
	public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
		setPoint1(p1);
		setPoint2(p2);
		setPoint3(p3);
		setPoint4(p4);
		
		setSide1(p1,p2);
		setSide2(p2,p3);
		setSide3(p3,p4);
		setSide4(p4,p1);
	}

	public Point getPoint1() {
		return point1;
	}

	private void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	private void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public Point getPoint3() {
		return point3;
	}

	private void setPoint3(Point point3) {
		this.point3 = point3;
	}

	public Point getPoint4() {
		return point4;
	}

	private void setPoint4(Point point4) {
		this.point4 = point4;
	}

	public Line getSide1() {
		return side1;
	}

	private void setSide1(Point p1, Point p2) {
		this.side1 = new Line(p1,p2);
	}

	public Line getSide2() {
		return side2;
	}

	private void setSide2(Point p1, Point p2) {
		this.side2 = new Line(p1,p2);
	}

	public Line getSide3() {
		return side3;
	}

	private void setSide3(Point p1, Point p2) {
		this.side3 = new Line(p1,p2);
	}

	public Line getSide4() {
		return side4;
	}

	private void setSide4(Point p1, Point p2) {
		this.side4 = new Line(p1,p2);
	}
	
	public double getPerimeter() {
		return side1.getLength() + side2.getLength() + side3.getLength() + side4.getLength();
	}
	
	abstract public double getArea();
	
	public static Quadrilateral makeNewQuad(Point p1, Point p2, Point p3, Point p4) {
		
		if (Quadrilateral.isQuadrilateral(p1, p2, p3, p4) == false) {
			Line oneToTwoDist = new Line(p1,p2);
			Line oneToThreeDist = new Line(p1,p3);
			Line oneToFourDist = new Line(p1,p4);
			
			Line currentLongest = oneToTwoDist;
			double currentHighest = oneToTwoDist.getLength();
			if (currentHighest < oneToThreeDist.getLength()) {
				currentHighest = oneToThreeDist.getLength();
				currentLongest = oneToThreeDist;
			}
			if (currentHighest < oneToFourDist.getLength()) {
				currentHighest = oneToFourDist.getLength();
				currentLongest = oneToFourDist;
			}	
			
			Point furthestPoint = currentLongest.getP2();
			
			if (furthestPoint == p2) { 
				p2 = p3; 
				}
			else if (furthestPoint == p4) { 
				p4 = p3; 
				}
			
			p3 = furthestPoint;
		}	
		
		boolean shapeFound = false;
		Quadrilateral foundShape = null;
		
		try {
			Square thisShape = new Square(p1,p2,p3,p4);
			shapeFound = true;
			foundShape = thisShape;
		}
		catch (ShapeException e) {}
		
		if (shapeFound != true) {
			try {
				Rectangle thisShape = new Rectangle(p1,p2,p3,p4);
				shapeFound = true;
				foundShape = thisShape;
			}
			catch (ShapeException e) {}
		}
		
		if (shapeFound != true) {
			try {
				Parallelogram thisShape = new Parallelogram(p1,p2,p3,p4);
				shapeFound = true;
				foundShape = thisShape;
			}
			catch (ShapeException e) {}
		}
		
		if (shapeFound != true) {
			try {
				Trapezium thisShape = new Trapezium(p1,p2,p3,p4);
				shapeFound = true;
				foundShape = thisShape;
			}
			catch (ShapeException e) {}
		}
		
		if (shapeFound != true) {
			try {
				Kite thisShape = new Kite(p1,p2,p3,p4);
				shapeFound = true;
				foundShape = thisShape;
			}
			catch (ShapeException e) {}
		}
		
		if (shapeFound) {
			return foundShape;
		}
		else {
			return null;
		}	
	}
	
	public static boolean isQuadrilateral(Point p1, Point p2, Point p3, Point p4) {
		
		Line lineOne = new Line(p1,p2);
		Line lineTwo = new Line(p2,p3);
		Line lineThree = new Line(p3,p4);
		Line lineFour = new Line(p4,p1);
		
		if (intersect(lineOne, lineTwo)) {
			return false;
		}
		if (intersect(lineOne, lineThree)) {
			return false;
		}
		if (intersect(lineOne, lineFour)) {
			return false;
		}
		if (intersect(lineThree, lineTwo)) {
			return false;
		}
		if (intersect(lineTwo, lineFour)) {
			return false;
		}
		if (intersect(lineThree, lineFour)) {
			return false;
		}
		return true;
	}
	
	// Code Block Provided ---------------------------------
	public static boolean intersect(Line l1, Line l2) {
		  int test1 , test2;
		  test1 = counterClockwiseTurn(l1.getP1(),
		                               l1.getP2(), 
		                               l2.getP1()) 
		        * counterClockwiseTurn(l1.getP1(), 
		                               l1.getP2(),
		                               l2.getP2());

		  test2 = counterClockwiseTurn(l2.getP1(),
		                               l2.getP2(),
		                               l1.getP1()) 
		        * counterClockwiseTurn(l2.getP1(),
		                               l2.getP2(),
		                               l1.getP2());
		  return (test1 <= 0) && (test2 <= 0);
		}

		private static int counterClockwiseTurn
		                        (Point a, Point b, Point c) {
		  double area2 = (b.getX() - a.getX()) 
		               * (c.getY() - a.getY())
		               - (b.getY() - a.getY()) 
		               * (c.getX() - a.getX());
		  if (area2 < 0)      
		    return -1;
		  else if (area2 > 0) 
		    return +1;
		  else                
		    return 0;
		}
	// -----------------------------------------------------

}



/*
--- Class Hierarchy ---
  Quadrilateral
  	Trapezium
  		Parallelogram
  			Rectangle
  				Square
  	Kite
*/