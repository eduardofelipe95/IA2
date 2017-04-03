import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainTest {
	
	public static int[][] aStar(int a[][], int xInitial, int yInitial){
		int xCurrent, yCurrent;
		
		xCurrent = xInitial;
		yCurrent = yInitial;
		
		Queue<Square> queue = new LinkedList<Square>();
		queue.add(new Square(xInitial, yInitial));
		
		while(!queue.isEmpty()){
		
			Square aux = queue.poll();
			xCurrent = aux.x;
			yCurrent = aux.y;
			
			if(((xCurrent - 1) > -1) && (yCurrent + 1) < a[0].length){
				
				if(a[xCurrent - 1][yCurrent + 1] == 0){
					
					a[xCurrent -1][yCurrent + 1] = a[xCurrent][yCurrent] + 1;
					queue.add(new Square(xCurrent - 1, yCurrent + 1));
					
				}
			}if(((xCurrent - 1) > -1) && (yCurrent - 1) > -1){
				if(a[xCurrent - 1][yCurrent - 1] == 0){
					
					a[xCurrent - 1][yCurrent - 1] = a[xCurrent][yCurrent] + 1;
					queue.add(new Square(xCurrent - 1, yCurrent - 1));
					
				}
				
			}if(((xCurrent - 1) > -1)){
				if(a[xCurrent - 1][yCurrent] == 0){
					
					a[xCurrent -1][yCurrent] = a[xCurrent][yCurrent] + 1;
					queue.add(new Square(xCurrent - 1, yCurrent));
					
				}
				
			}if(((xCurrent + 1) < a.length) && ((yCurrent + 1) < a[0].length)){
				if(a[xCurrent + 1][yCurrent + 1] == 0){
					
					a[xCurrent + 1][yCurrent + 1] = a[xCurrent][yCurrent] + 1;
					queue.add(new Square(xCurrent + 1, yCurrent + 1));
					
				}
			}if(((xCurrent + 1) < a.length) && ((yCurrent - 1) > -1)){
				if(a[xCurrent + 1][yCurrent - 1] == 0){
					
					a[xCurrent +1][yCurrent - 1] = a[xCurrent][yCurrent] + 1;
					queue.add(new Square(xCurrent + 1, yCurrent - 1));
					
				}
			}if(((xCurrent + 1) < a.length)){
				if(a[xCurrent + 1][yCurrent] == 0){
					
					a[xCurrent + 1][yCurrent] = a[xCurrent][yCurrent] + 1;
					queue.add(new Square(xCurrent + 1, yCurrent));
					
				}
			}if((yCurrent - 1) > -1){
				if(a[xCurrent][yCurrent - 1] == 0){
					
					a[xCurrent][yCurrent - 1] = a[xCurrent][yCurrent] + 1;
					queue.add(new Square(xCurrent, yCurrent - 1));
					
				}
			}if((yCurrent + 1) < a[0].length){
				if(a[xCurrent][yCurrent + 1] == 0){
					
					a[xCurrent][yCurrent + 1] = a[xCurrent][yCurrent] + 1;
					queue.add(new Square(xCurrent, yCurrent + 1));
					
				}
			}
		}
		
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				System.out.print(" " + a[i][j]);
			}
			System.out.println();
		}
		
		
		return a;
	}
	
	public static int calcDist(int a[][], int xEnd, int yEnd){
		int dist = 30000;//infinito
		
		if(((xEnd - 1) > -1) && (yEnd + 1) < a[0].length){
			
			if(a[xEnd - 1][yEnd + 1] > 0 && a[xEnd - 1][yEnd + 1] < dist){
				dist = a[xEnd - 1][yEnd + 1];
				
			}
		}if(((xEnd - 1) > -1) && (yEnd - 1) > -1){
			if(a[xEnd - 1][yEnd - 1] > 0 && a[xEnd - 1][yEnd - 1] < dist){
				dist = a[xEnd - 1][yEnd - 1];
			}
			
		}if(((xEnd - 1) > -1)){
			if(a[xEnd - 1][yEnd] > 0 && a[xEnd - 1][yEnd] < dist){
				dist = a[xEnd - 1][yEnd];
			}
			
		}if(((xEnd + 1) < a.length) && ((yEnd + 1) < a[0].length)){
			if(a[xEnd + 1][yEnd + 1] > 0 && a[xEnd + 1][yEnd + 1] < dist){
				dist = a[xEnd + 1][yEnd + 1];
			}
		}if(((xEnd + 1) < a.length) && ((yEnd - 1) > -1)){
			if(a[xEnd + 1][yEnd - 1] > 0 && a[xEnd + 1][yEnd - 1] < dist){
				dist = a[xEnd + 1][yEnd - 1];
			}
		}if(((xEnd + 1) < a.length)){
			if(a[xEnd + 1][yEnd] > 0 && a[xEnd + 1][yEnd] < dist){
				dist = a[xEnd + 1][yEnd];
			}
		}if((yEnd - 1) > -1){
			if(a[xEnd][yEnd - 1] > 0 && a[xEnd][yEnd - 1] < dist){
				dist = a[xEnd][yEnd - 1];
			}
		}if((yEnd + 1) < a[0].length){
			if(a[xEnd][yEnd + 1] > 0 && a[xEnd][yEnd + 1] < dist){
				dist = a[xEnd][yEnd + 1];
			}
		}
		
		return dist;
	}

	public static void main(String[] args) {
		
		int a[][] = {{0,0,0,0,0,0,0,0,0,0}
					,{0,0,0,0,0,0,0,0,0,0}
					,{0,0,0,0,0,-1,0,0,0,0}
					,{0,0,0,0,0,-1,0,0,0,0}
					,{0,0,0,0,0,-1,0,0,0,0}
					,{0,0,0,0,0,-1,0,0,0,0}
					,{0,0,0,0,0,0,0,0,0,0}
					,{0,0,0,0,0,0,0,0,0,0}
					,{0,0,0,0,0,0,0,0,0,0}
					,{0,0,0,0,0,0,0,0,0,0}
					,{0,0,0,0,0,0,0,0,0,0}};
		
		
		System.out.println(MainTest.calcDist(aStar(a, 3, 3), 3, 7));
		
	}

}
