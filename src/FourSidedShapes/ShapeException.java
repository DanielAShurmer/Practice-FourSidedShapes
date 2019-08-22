package FourSidedShapes;

public class ShapeException extends RuntimeException{

	public ShapeException(Quadrilateral type, Point p1, Point p2, Point p3, Point p4) {
		
		String typeName = type.getClass().toString();
		String typeNameArray[] = typeName.split("\\.");
		typeName = typeNameArray[typeNameArray.length - 1];
			
		System.out.printf("\nThe Following Four Coordinates Cannot Make A %s:",typeName);
		System.out.printf("\nPoint 1:[X:%5.2f Y:%5.2f]", p1.getX(),p1.getY());
		System.out.printf("\nPoint 2:[X:%5.2f Y:%5.2f]", p2.getX(),p2.getY());
		System.out.printf("\nPoint 3:[X:%5.2f Y:%5.2f]", p3.getX(),p3.getY());
		System.out.printf("\nPoint 4:[X:%5.2f Y:%5.2f]\n", p4.getX(),p4.getY());
	}
}
