package Dijkstra_and_A_Star;

import java.util.*;

public class Dijkstra extends AbstractDistance{
    public Dijkstra(City start, City target){
		calcDistance(start, target);
	}
	
	public void calcDistance(City start, City target) {
	    PriorityQueue<City> closedList = new PriorityQueue<>();
	    PriorityQueue<City> openList = new PriorityQueue<>();
	    
	    start.cost = start.move;
	    openList.add(start);
	
	    while(!openList.isEmpty()){
	        City n = openList.peek();
	        if(n == target){
	            return;
	        }
	        for(City.Edge edge : n.neighbors){
	            City m = edge.city;
	            double totalWeight = n.move + edge.weight;
	
	            if(!openList.contains(m) && !closedList.contains(m)){
	                m.prev = n;
	                m.move = totalWeight;
	                m.cost = m.move;
	                openList.add(m);
	            } else {
	                if(totalWeight < m.move){
	                    m.prev = n;
	                    m.move = totalWeight;
	                    m.cost = m.move;
	
	                    if(closedList.contains(m)){
	                        closedList.remove(m);
	                        openList.add(m);
	                    }
	                }
	            }
	            distance = totalWeight;
	        }
	        openList.remove(n);
	        closedList.add(n);
	    }
	    return;
	}
}
