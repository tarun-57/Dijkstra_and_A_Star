package Dijkstra_and_A_Star;

public interface Distance {
	public double getDistance();
	public void calcDistance(City start, City target);
}
