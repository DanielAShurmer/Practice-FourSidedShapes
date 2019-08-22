package FourSidedShapes;

public class Square extends Rectangle {

	public Square(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4);
		if (isSquare(this) == false) {
			throw new ShapeException(this, p1, p2, p3, p4);
		}
	}
	
	public static boolean isSquare(Quadrilateral quad) {
		
		if (quad.getSide1().getLength() == quad.getSide2().getLength()
			&& quad.getSide2().getLength() == quad.getSide3().getLength()
			&& quad.getSide3().getLength() == quad.getSide4().getLength()) {
			
			double angleOne = Math.atan(quad.getSide1().getSlope());
			double angleTwo = Math.atan(quad.getSide2().getSlope());
			
			if (angleOne > angleTwo) {
				double temp = angleOne;
				angleOne = angleTwo;
				angleTwo = temp;
			}
			
			double angle = angleTwo - angleOne;
			
			angle = Math.toDegrees(angle);
			
			if (angle == 90) {
				return true;
			}			
		}
		return false;		
	}
}
