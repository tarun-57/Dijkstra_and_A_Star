package Dijkstra_and_A_Star;

import java.util.*;
import java.lang.Math;

public class City implements Comparable<City>{
    private static int idCounter = 0;
    public int id;	//Unique Id for every city
    public static double dist;
    
    // Previous city in the path
    public City prev = null;

    public List<Edge> neighbors;

    // Evaluation functions
    public double cost = Double.MAX_VALUE;	//Cost Function
    public double move = Double.MAX_VALUE;	//Move Function
    // Heuristic
    public int x, y;	//Coordinates of the City
    public double heuristic; 	// Heuristic Function

    City(int x, int y){
          this.x = x;
          this.y = y;
          this.id = idCounter++;
          this.neighbors = new ArrayList<>();
    }

    @Override
    public int compareTo(City n) {
          return Double.compare(this.cost, n.cost);
    }

    public static class Edge {
          Edge(int weight, City city){
                this.weight = weight;
                this.city = city;
          }

          public int weight;
          public City city;
    }

    public void addBranch(City city, int weight){
          Edge newEdge = new Edge(weight, city);
          neighbors.add(newEdge);
    }

    public double calcHeuristic(City target){
    	this.heuristic = Math.abs(x - target.x) + Math.abs(y - target.y);
        return this.heuristic;
    }
}
