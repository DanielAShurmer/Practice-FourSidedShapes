package FourSidedShapes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Parallelogram extends Trapezium{

	public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4);
		if (isParallelogram(this)== false) {
			throw new ShapeException(this, p1, p2, p3, p4);
		}
	}
	
	@Override
	public double getArea() {
		
		Line usedSide1 = getSide1();
		Line usedSide2 = getSide2();
		
		double angleOne = Math.atan(getSide1().getSlope());
		double angleTwo = Math.atan(getSide2().getSlope());
		
		if (angleOne > angleTwo) {
			double temp = angleOne;
			angleOne = angleTwo;
			angleTwo = temp;
		}
		
		double angle = angleTwo - angleOne;
		
		if (angle > 90) {
			usedSide1 = getSide2();
			usedSide2 = getSide3();
			
			angleOne = Math.atan(getSide2().getSlope());
			angleTwo = Math.atan(getSide3().getSlope());
			
			if (angleOne > angleTwo) {
				double temp = angleOne;
				angleOne = angleTwo;
				angleTwo = temp;
			}
			
			angle = angleTwo - angleOne;
		}
		
		double totalArea = Math.sin(angle) * usedSide1.getLength() * usedSide2.getLength();
		
		BigDecimal bd = new BigDecimal(Double.toString(totalArea));
		bd = bd.setScale(3,RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public static boolean isParallelogram(Quadrilateral quad) {
		
		if (quad.getSide1().getLength() == quad.getSide3().getLength()
			&& quad.getSide2().getLength() == quad.getSide4().getLength())
		{
			return true;				
		}
		return false;
	}
}
