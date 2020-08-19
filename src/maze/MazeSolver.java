package maze;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MazeSolver {

	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Maze> mazes = readMazes();
				
		
		
		int i = 0;
		while(i < mazes.size()) {
			if(solveMaze(mazes.get(i))) {
				System.out.println("You won!");
			}
			else {
				System.out.println("No Path");
			}
			i++;
		}
		
		
	}
	
	private static ArrayList<Maze> readMazes() throws FileNotFoundException {
		
		ArrayList<Maze> mazes = new ArrayList<Maze>();
		
		
		
		Scanner in = new Scanner(new File("mazes.txt"));
		while(in.hasNext()) {
			
			Maze m = new Maze();
			
			//fill list from file
			
			int rows = Integer.parseInt(in.nextLine());
			m.maze = new int[rows][];
			
			
			for (int i = 0; i < rows; i++) {
				String line = in.nextLine();

				//converts String Array to Integer Array
				m.maze[i] = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray();
			}
			
			m.start = new Position(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
			
			//toss the extra space
			in.nextLine();
			
			mazes.add(m);
		}
		
		in.close();
		return mazes;
	}

	private static boolean solveMaze(Maze m) {
		
		
		Position p = m.start;
		m.path.push(p);
		
		
		
		while(true) {
			
			//y represents row, x represents column
			//Because you go up and down rows and left and right columns even though switching x and y may be weird at first
			int y = m.path.peek().y;
			int x = m.path.peek().x;
			m.maze[y][x] = 0;
			
			if (isValid(y+1, x, m)) {
				//down
				if (m.maze[y+1][x] == 2) {
					System.out.println("Moved down.");
					return true;
				} 
				else if (m.maze[y+1][x] == 1) {
					System.out.println("Moved down");
					m.path.push(new Position(y+1, x));
					continue;
				}
			}
			
			if (isValid(y, x-1, m)) {
				//left
				if (m.maze[y][x-1] == 2) {
					System.out.println("Moved left.");
					return true;
				} 
				else if (m.maze[y][x-1] == 1) {
					System.out.println("Moved left");
					m.path.push(new Position(y, x-1));
					continue;
				}
			}
			
			if (isValid(y-1, x, m)) {
				//up
				if (m.maze[y-1][x] == 2) {
					System.out.println("Moved up.");
					return true;
				} 
				else if (m.maze[y-1][x] == 1) {
					System.out.println("Moved up");
					m.path.push(new Position(y-1, x));
					continue;
				}
			}
			
			if (isValid(y, x+1, m)) {
				//right
				if (m.maze[y][x+1] == 2) {
					System.out.println("Moved right.");
					return true;
				} 
				else if (m.maze[y][x+1] == 1) {
					System.out.println("Moved right");
					m.path.push(new Position(y, x+1));
					continue;
				}
			}
			
			
			
			m.path.pop();
			System.out.println("moved back");
			if (m.path.size() <= 0) {
				
				return false;
			}
		}
		
	}

	public static boolean isValid(int y, int x, Maze m) {
		if(y < 0 || 
		   y >= m.maze.length ||
		   x < 0 ||
		   x >= m.maze[y].length) {
			return false;
		}
		return true;
	}

}
