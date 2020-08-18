import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MySweetProgram {
	

	public static void main(String[] args)  {
		
		LinkedList<String> names = new LinkedList<String>();
		names.push("caleb");
		names.push("Sue");
		names.push("Sally");
		
		Iterator<String> it = names.iterator();
		
		names.add(2, "Susan");
		
		for( String s : names) {
			System.out.println(s);
		}
		
		
	}
	

}
