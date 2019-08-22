package FourSidedShapes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Trapezium extends Quadrilateral{

	public Trapezium(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4);
		if (isTrapezium(this)== false) {
			throw new ShapeException(this, p1, p2, p3, p4);
		}
	}

	@Override
	public double getArea() {
		
		double line1Grad = this.getSide1().getSlope();
		double line2Grad = this.getSide2().getSlope();
		double line3Grad = this.getSide3().getSlope();
		double line4Grad = this.getSide4().getSlope();
		
		double firstBase = 0;
		double secondBase = 0;
		double firstLeg = 0;
		double secondLeg = 0;
		
		if (line1Grad == line2Grad) {
			firstBase = getSide1().getLength(); 
			secondBase = getSide2().getLength(); 
			firstLeg = getSide3().getLength();
			secondLeg = getSide4().getLength();
		}
		else if (line1Grad == line3Grad) {
			firstBase = getSide1().getLength(); 
			secondBase = getSide3().getLength(); 
			firstLeg = getSide2().getLength();
			secondLeg = getSide4().getLength();
		}
		else if (line1Grad == line4Grad) {
			firstBase = getSide1().getLength(); 
			secondBase = getSide4().getLength(); 
			firstLeg = getSide3().getLength();
			secondLeg = getSide2().getLength();
		}
		else if (line2Grad == line3Grad) {
			firstBase = getSide2().getLength(); 
			secondBase = getSide3().getLength(); 
			firstLeg = getSide1().getLength();
			secondLeg = getSide4().getLength();
		}
		else if (line2Grad == line4Grad) {
			firstBase = getSide2().getLength(); 
			secondBase = getSide4().getLength(); 
			firstLeg = getSide3().getLength();
			secondLeg = getSide1().getLength();
		}
		else if (line3Grad == line4Grad) {
			firstBase = getSide3().getLength(); 
			secondBase = getSide4().getLength(); 
			firstLeg = getSide1().getLength();
			secondLeg = getSide2().getLength();
		}
		else {
			System.out.println("Shape Is Not A Trapezium! Abort!");
			return 0;
		}
		
		if (firstBase == secondBase) {
			System.out.println("Shape Is Not A Trapezium! Abort!");
			return 0;
		}
		
		if (firstBase > secondBase) {
			double temp = firstBase;
			firstBase = secondBase;
			secondBase = temp;
		}
		
		double baseDiff = secondBase - firstBase;
		
		double height = (firstLeg * firstLeg) - (secondLeg * secondLeg) + (baseDiff * baseDiff);
		height = (height / (2 * baseDiff));
		height = height * height;
		height = (firstLeg * firstLeg) - height;
		height = Math.sqrt(height);
		
		double totalArea = height * ((firstBase + secondBase) / 2);
		
		BigDecimal bd = new BigDecimal(Double.toString(totalArea));
		bd = bd.setScale(3,RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public static boolean isTrapezium(Quadrilateral quad) {	
		if ((quad.getSide1().getSlope() == quad.getSide3().getSlope()) ||
			(quad.getSide2().getSlope() == quad.getSide4().getSlope())	)
		{
			return true;				
		}
		return false;
	}
}
