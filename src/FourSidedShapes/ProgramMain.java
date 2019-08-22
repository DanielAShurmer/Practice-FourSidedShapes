package FourSidedShapes;

import java.util.Scanner;

public class ProgramMain {

	public static void main(String[] args) throws Exception {
		
		double x1 = 0;
		double y1 = 0;
		double x2 = 0;
		double y2 = 0;
		double x3 = 0;
		double y3 = 0;
		double x4 = 0;
		double y4 = 0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter First Point X:");
		x1 = read.nextDouble();
		System.out.println("Enter First Point Y:");
		y1 = read.nextDouble();
		System.out.println("Enter Second Point X:");
		x2 = read.nextDouble();
		System.out.println("Enter Second Point Y:");
		y2 = read.nextDouble();
		System.out.println("Enter Third Point X:");
		x3 = read.nextDouble();
		System.out.println("Enter Third Point Y:");
		y3 = read.nextDouble();
		System.out.println("Enter Fourth Point X:");
		x4 = read.nextDouble();
		System.out.println("Enter Fourth Point Y:");
		y4 = read.nextDouble();
		
		Point p1 = new Point(x1,y1);
		Point p2 = new Point(x2,y2);
		Point p3 = new Point(x3,y3);
		Point p4 = new Point(x4,y4);
		
		Quadrilateral foundShape = Quadrilateral.makeNewQuad(p1, p2, p3, p4);
		
		if (foundShape == null) {
			System.out.println("This Shape Is An Irregular Quadrilateral.");
		}
		else {
			String typeName = foundShape.getClass().toString();
			String typeNameArray[] = typeName.split("\\.");
			typeName = typeNameArray[typeNameArray.length - 1];
				
			System.out.printf("\nThis Shape Is A %s",typeName);
			System.out.printf("\nIt Has A Perimeter Of %f",foundShape.getPerimeter());
			System.out.printf("\nIt Has An Area Of %f",foundShape.getArea());
		}
	}	
}
