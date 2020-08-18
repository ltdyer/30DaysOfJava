import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MySweetProgram {
	

	public static void main(String[] args)  {
		
		int[][] data = {
				{4, 6, 3, 10},
				{4, 2, 40, 1},
				{5, 34, 1, 43}
		};
		
		data[1][2] = 49;
		
		for (int i = 0; i < data.length; i++) {
			System.out.println("row " + i);
			
			for (int j = 0; j < data[i].length; j++) {
				System.out.println("column: " + j);
			}
		}
		
	}
	

}
