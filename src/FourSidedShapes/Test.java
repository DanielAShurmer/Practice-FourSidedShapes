package FourSidedShapes;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void testPointToString() {
		Point testPoint = new Point(4,5);
		assertEquals("X:4.00 Y:5.00", testPoint.toString());
	}
	
	@org.junit.jupiter.api.Test
	void testDistanceToPoint() {
		Point testPoint = new Point(3,4);
		assertEquals(5.00, testPoint.distanceTo(new Point(0,0)));
	}
	
	@org.junit.jupiter.api.Test
	void testLengthOfLine() {
		Point testPoint1 = new Point(3,4);
		Point testPoint2 = new Point(0,0);
		Line testLine = new Line(testPoint1,testPoint2);
		assertEquals(5.00, testLine.getLength());
	}
	
	@org.junit.jupiter.api.Test
	void testLineGradOne() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(6,6);
		Line testLine = new Line(testPoint1,testPoint2);
		assertEquals(1.00, testLine.getSlope());
	}
	
	@org.junit.jupiter.api.Test
	void testLineGradNegativeTwo() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(-6,12);
		Line testLine = new Line(testPoint1,testPoint2);
		assertEquals(-2.00, testLine.getSlope());
	}
	
	@org.junit.jupiter.api.Test
	void testLineGradZero() {
		Point testPoint1 = new Point(3,4);
		Point testPoint2 = new Point(-7,4);
		Line testLine = new Line(testPoint1,testPoint2);
		assertEquals(0.00, testLine.getSlope());
	}
	
	@org.junit.jupiter.api.Test
	void testLineGradInfinity() {
		Point testPoint1 = new Point(-4,9);
		Point testPoint2 = new Point(-4,1);
		Line testLine = new Line(testPoint1,testPoint2);
		assertEquals(Double.POSITIVE_INFINITY, testLine.getSlope());
	}
	
	@org.junit.jupiter.api.Test
	void testPerimeterOfTrapezium() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(3,4);
		Point testPoint3 = new Point(6,4);
		Point testPoint4 = new Point(9,0);
		Trapezium testTrapez = new Trapezium(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(22.00, testTrapez.getPerimeter());
	}
	
	@org.junit.jupiter.api.Test
	void testAreaOfTrapezium() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(4,4);
		Point testPoint3 = new Point(8,4);
		Point testPoint4 = new Point(12,0);
		Trapezium testTrapez = new Trapezium(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(32.00, testTrapez.getArea());
	}
	
	@org.junit.jupiter.api.Test
	void testAreaOfTrapeziumWithMinus() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(5,6);
		Point testPoint3 = new Point(10,5);
		Point testPoint4 = new Point(0,-7);
		Trapezium testTrapez = new Trapezium(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(52.5, testTrapez.getArea());
	}
	
	@org.junit.jupiter.api.Test
	void testAreaOfTrapeziumWithDecimal() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(10,0);
		Point testPoint3 = new Point(8,5);
		Point testPoint4 = new Point(3.3,5);
		Trapezium testTrapez = new Trapezium(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(36.75, testTrapez.getArea());
	}
	
	@org.junit.jupiter.api.Test
	void testAreaOfParallelogram() {
		Point testPoint1 = new Point(5,5);
		Point testPoint2 = new Point(11,5);
		Point testPoint3 = new Point(12,20);
		Point testPoint4 = new Point(6,20);
		Parallelogram testParall = new Parallelogram(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(90.00, testParall.getArea());
	}
	
	@org.junit.jupiter.api.Test
	void testAreaOfRectangle() {
		Point testPoint1 = new Point(17,14);
		Point testPoint2 = new Point(30,14);
		Point testPoint3 = new Point(30,28);
		Point testPoint4 = new Point(17,28);
		Rectangle testRect = new Rectangle(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(182.00, testRect.getArea());
	}
	
	@org.junit.jupiter.api.Test
	void testAreaOfSquare() {
		Point testPoint1 = new Point(4,0);
		Point testPoint2 = new Point(8,0);
		Point testPoint3 = new Point(8,4);
		Point testPoint4 = new Point(4,4);
		Square testSqu = new Square(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(16.00, testSqu.getArea());
	}
	
	@org.junit.jupiter.api.Test
	void testAreaOfKite() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(5,5);
		Point testPoint3 = new Point(10,0);
		Point testPoint4 = new Point(5,-20);
		Kite testKite = new Kite(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(125.00, testKite.getArea());
	}
	
	@org.junit.jupiter.api.Test
	void testAreaOfKiteTwo() {
		Point testPoint1 = new Point(4,0);
		Point testPoint2 = new Point(5,5);
		Point testPoint3 = new Point(6,0);
		Point testPoint4 = new Point(5,-20);
		Kite testKite = new Kite(testPoint1,testPoint2,testPoint3,testPoint4);
		assertEquals(25.00, testKite.getArea());
	}
	
	@org.junit.jupiter.api.Test
	void testCheckSquarenessTrue() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(5,0);
		Point testPoint3 = new Point(5,5);
		Point testPoint4 = new Point(0,5);
		Square testSqu = new Square(testPoint1,testPoint2,testPoint3,testPoint4);
		assertTrue(Square.isSquare(testSqu));
	}
	
	@org.junit.jupiter.api.Test
	void testCheckSquarenessFalse() {
		Point testPoint1 = new Point(0,20);
		Point testPoint2 = new Point(5,20);
		Point testPoint3 = new Point(5,5);
		Point testPoint4 = new Point(0,5);
		assertThrows(ShapeException.class, () -> {new Square(testPoint1,testPoint2,testPoint3,testPoint4);});
	}
	
	@org.junit.jupiter.api.Test
	void testCheckRectanglenessFalse() {
		Point testPoint1 = new Point(0,4);
		Point testPoint2 = new Point(5,0);
		Point testPoint3 = new Point(5,5);
		Point testPoint4 = new Point(0,5);
		assertThrows(ShapeException.class, () -> {new Rectangle(testPoint1,testPoint2,testPoint3,testPoint4);});
	}
	
	@org.junit.jupiter.api.Test
	void testCheckParellelogramnessFalse() {
		Point testPoint1 = new Point(0,4);
		Point testPoint2 = new Point(5,0);
		Point testPoint3 = new Point(5,5);
		Point testPoint4 = new Point(0,5);
		assertThrows(ShapeException.class, () -> {new Parallelogram(testPoint1,testPoint2,testPoint3,testPoint4);});
	}
	
	@org.junit.jupiter.api.Test
	void testCheckTrapeziumnessFalse() {
		Point testPoint1 = new Point(0,4);
		Point testPoint2 = new Point(5,0);
		Point testPoint3 = new Point(5,5);
		Point testPoint4 = new Point(0,5);
		assertThrows(ShapeException.class, () -> {new Trapezium(testPoint1,testPoint2,testPoint3,testPoint4);});
	}
	
	@org.junit.jupiter.api.Test
	void testCheckKitenessFalse() {
		Point testPoint1 = new Point(0,4);
		Point testPoint2 = new Point(5,0);
		Point testPoint3 = new Point(5,5);
		Point testPoint4 = new Point(0,5);
		assertThrows(ShapeException.class, () -> {new Kite(testPoint1,testPoint2,testPoint3,testPoint4);});
	}
	
	@org.junit.jupiter.api.Test
	void testFixSquare() {
		Point testPoint1 = new Point(0,0);
		Point testPoint2 = new Point(10,10);
		Point testPoint3 = new Point(0,10);
		Point testPoint4 = new Point(10,0);
		Quadrilateral testQuad = Quadrilateral.makeNewQuad(testPoint1, testPoint2, testPoint3, testPoint4);
		assertEquals(100.00, testQuad.getArea());
	}
}
