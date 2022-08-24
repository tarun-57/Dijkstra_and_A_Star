package Dijkstra_and_A_Star;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		System.out.println("Please Enter Number of Cities: ");
		int N = sc.nextInt();	//Number of Cities
		System.out.println("Please Enter Number of Connections between Cities: ");
		int Noc = sc.nextInt();	//Number of Connections between Cities
		
	    City Cities[] = new City[N]; 
	    for(int i = 0; i < N; i++) {
	    	Cities[sc.nextInt()] = new City(sc.nextInt(), sc.nextInt());
	    }
	    Cities[0].move = 0;	
	    for(int i = 0; i < Noc; i++) {
	    	Cities[sc.nextInt()].addBranch(Cities[sc.nextInt()], sc.nextInt());
	    }

	    int startId = sc.nextInt();
	    int targetId = sc.nextInt();
	    
		sc.close();

	    Distance result;
		result = new Dijkstra(Cities[startId], Cities[targetId]);
		System.out.println("Distance according to Dijkstra algorithm = " + result.getDistance());
		result = new A_Star(Cities[startId], Cities[targetId]);
		System.out.println("Distance according to A* algorithm = " + result.getDistance());
	}
}
