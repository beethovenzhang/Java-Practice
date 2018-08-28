/**
 * 
 */

/**
 * @author beethovenzhang
 *
 */
import java.util.Arrays;
import java.util.Scanner;

public class BattleShipsGame {
	
	public static void main(String[] args) {
		String [][] map=new String[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j]="0";
			}
		}
		int [] ships= {5,5};
		System.out.println("**** Welcome to Battle Ships Game ****");
		System.out.println("Right now the sea is empty.");
		printMap(ships, map);
		playerDeploy(map);
		printMap(ships, map);
		//System.out.println(Arrays.deepToString(map));
		computerDeploy(map);
		//System.out.println(Arrays.deepToString(map));
		printMap(ships, map);
		while (ships[0]!=0&&ships[1]!=0) {
			playerMove(ships,map);
			printMap(ships, map);
			computerMove(ships,map);
			printMap(ships, map);
			
		}
		if (ships[0]==0) {
			System.out.println("You lose!");
		} else {
			System.out.println("You win!");

		}
		
		
	}
	
	
	
	public static void printMap(int[] ships, String[][] map) {
		System.out.println("   0123456789");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 16; j++) {
				if (j==0) {
					System.out.print(i+" |");
				} else if (j==13) {
					System.out.print("| "+i);
				} else if (j>2&&j<13) {
					if (map[i][j-3].equals("0")||map[i][j-3].equals("2")) {
						System.out.print(" ");
					} else if (map[i][j-3].equals("1")) {
						System.out.print("@");
					} else {
						System.out.print(map[i][j-3]);
					}
				} 
				
			}
			System.out.println();
			
		}
		
		System.out.println("   0123456789");
		System.out.println();
		System.out.println("Your ships: "+ships[0]+" | Computer's ships: "+ ships[1]);
		System.out.println();
	}
	
	
	
	public static void playerDeploy(String [][] map) {
		Scanner input=new Scanner(System.in);
		System.out.println("Deploy your ships:");
		for (int i = 1; i < 6; i++) {
			
			System.out.print("Enter X coordinates for your "+i+". ship:");
			int x=input.nextInt();
			
			System.out.print("Enter Y coordinates for your "+i+". ship:");
			int y=input.nextInt();
			while (legalDeploy(x,y,map)==false) {
				
				
				System.out.print("Enter X coordinates for your "+i+". ship:");
				x=input.nextInt();
				
				System.out.print("Enter Y coordinates for your "+i+". ship:");
				y=input.nextInt();
				
			}
			map[y][x]="1";
		}
	}
	
	public static void computerDeploy(String [][] map) {
		System.out.println("Computer is deploying ships.");
		for (int i = 0; i < 6; i++) {
			int x=(int) (Math.random()*9);
			int y=(int) (Math.random()*9);
			//System.out.println(x);
			//System.out.println(y);
			while (legalDeploy(x,y,map)==false) {
				x=(int) Math.random()*9;
				y=(int) Math.random()*9;
				
			}
			map[y][x]="2";
			System.out.println(i+". ship deployed.");
		}
		System.out.println("-------------------------");
	}
	
	
	public static boolean legalDeploy(int x, int y, String [][] map) {
		if (x<10&&x>-1&&y<10&&y>-1&&map[y][x].equals("0")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void playerMove(int[] ships, String[][] map) {
		System.out.println("Your Turn.");
		Scanner input= new Scanner(System.in);
		System.out.print("Enter X coordinate: ");		
		int x=input.nextInt();
		System.out.print("Enter Y coordinate: ");		
		int y=input.nextInt();
		while (legalGuess(x,y,map)==false) {
			System.out.print("Enter X coordinate: ");		
			x=input.nextInt();
			System.out.print("Enter Y coordinate: ");		
			y=input.nextInt();
			
		}
		if (map[y][x].equals("1")) {
			System.out.println("Oh no, you sunk your own ship :(");
			map[y][x]="x";
			ships[0]--;
		} else if (map[y][x].equals("2")) {
			System.out.println("Boom! You sunk the ship!");
			map[y][x]="!";
			ships[1]--;
		} else {
			System.out.println("Sorry, you missed");
			map[y][x]="-";

		}
	}
	
	public static void computerMove(int[] ships, String[][] map) {
		System.out.println("Computer's Turn.");			
		int x=(int) (Math.random()*9);		
		int y=(int) (Math.random()*9);
		while (legalGuess(x,y,map)==false) {	
			x=(int) (Math.random()*9);	
			y=(int) (Math.random()*9);
			
		}
		
		
		if (map[y][x].equals("1")) {
			System.out.println("The Computer sunk one of your ships!");
			map[y][x]="x";
			ships[0]--;
		} else if (map[y][x].equals("2")) {
			System.out.println("The Computer sunk one of its own ships");
			map[y][x]="!";
			ships[1]--;
		} else {
			System.out.println("Computer missed");
			map[y][x]="-";

		}
		
	}
	
	
	public static boolean legalGuess(int x, int y, String [][] map) {
		if (x<10&&x>-1&&y<10&&y>-1&&map[y][x]!="-") {
			return true;
		} else {
			return false;
		}
		
		
		
	}

}
