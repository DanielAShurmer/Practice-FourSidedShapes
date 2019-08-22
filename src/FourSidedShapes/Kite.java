package FourSidedShapes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Kite extends Quadrilateral {

	public Kite(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4);
		if (isKite(this) == false) {
			throw new ShapeException(this, p1, p2, p3, p4);
		}
	}

	@Override
	public double getArea() {
		Line diagOne = new Line(getPoint1(),getPoint3());
		Line diagTwo = new Line(getPoint2(),getPoint4());
		
		double diagOneLength = diagOne.getLength();
		double diagTwoLength = diagTwo.getLength();
		
		double totalArea = (diagOneLength * diagTwoLength) / 2;
		
		BigDecimal bd = new BigDecimal(Double.toString(totalArea));
		bd = bd.setScale(3,RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public static boolean isKite(Quadrilateral quad) {
		
		if ( ( ( quad.getSide1().getLength() == quad.getSide2().getLength() ) && 
			   ( quad.getSide3().getLength() == quad.getSide4().getLength() ) ) ||
			 ( ( quad.getSide1().getLength() == quad.getSide4().getLength() ) && 
			   ( quad.getSide2().getLength() == quad.getSide3().getLength() ) ) ){
			return true;
		}		
		return false;
	}
}
