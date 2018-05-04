/**
 * 
 */
package com.github.tntgamestv.school;

import com.github.tntgamestv.school.lib.Edge;
import com.github.tntgamestv.school.lib.Graph;
import com.github.tntgamestv.school.lib.List;
import com.github.tntgamestv.school.lib.Vertex;

/**
 * @author TnTGamesTV
 * Project: Dijkstra
 * Date: 04-05-2018
 */
public class Main {
	
	private static int SIZE = 6;
	private static Graph g;
	private static Data[] data;
	private static Vertex current = null;
	
	static class Data {
		
		private Vertex vertex;
		private int distance;
		private Vertex parent;
		
		public Data(Vertex vertex) {
			this.vertex = vertex;
			this.distance = Integer.MAX_VALUE;
			this.parent = null;
		}

		/**
		 * @return the distance
		 */
		public int getDistance() {
			return distance;
		}

		/**
		 * @param distance the distance to set
		 */
		public void setDistance(int distance) {
			this.distance = distance;
		}

		/**
		 * @return the parent
		 */
		public Vertex getParent() {
			return parent;
		}

		/**
		 * @param parent the parent to set
		 */
		public void setParent(Vertex parent) {
			this.parent = parent;
		}

		/**
		 * @return the vertex
		 */
		public Vertex getVertex() {
			return vertex;
		}
	}
	
	public static void init()  {
		g = new Graph();

		Vertex vA = new Vertex("A");
		Vertex vB = new Vertex("B");
		Vertex vC = new Vertex("C");
		Vertex vD = new Vertex("D");
		Vertex vE = new Vertex("E");
		Vertex vF = new Vertex("F");

		Edge eAB = new Edge(vA, vB, 4);
		Edge eAC = new Edge(vA, vC, 2);
		Edge eAE = new Edge(vA, vE, 4);
		Edge eBC = new Edge(vB, vC, 1);
		Edge eCD = new Edge(vC, vD, 3);
		Edge eCE = new Edge(vC, vE, 5);
		Edge eDF = new Edge(vD, vF, 2);
		Edge eEF = new Edge(vE, vF, 1);

		g.addVertex(vA);
		g.addVertex(vB);
		g.addVertex(vC);
		g.addVertex(vD);
		g.addVertex(vE);
		g.addVertex(vF);

		g.addEdge(eAB);
		g.addEdge(eAC);
		g.addEdge(eAE);
		g.addEdge(eBC);
		g.addEdge(eCD);
		g.addEdge(eCE);
		g.addEdge(eDF);
		g.addEdge(eEF);
	}
	
	public static void main(String[] args) {
		init();
		
		data = new Data[SIZE];
		
		//Step 0
		int counter1 = 0;
		List<Vertex> vertices = g.getVertices();
		vertices.toFirst();
		while(vertices.hasAccess()) {
			Vertex vertex = vertices.getContent();
			
			data[counter1] = new Data(vertex);
			
			vertices.next();
			counter1++;
		}
		
		//Step 0.5
		data[0].setDistance(0);
		data[0].setParent(data[0].getVertex());
		
		//Step 1
		while(!g.allVerticesMarked()) {
			Data lowestUnmarkedData = getLowestVertex(data);
			Vertex lowestUnmarked = lowestUnmarkedData.getVertex();
			lowestUnmarked.setMark(true);
			
			current = lowestUnmarked;
			
			List<Vertex> neighbours = g.getNeighbours(current);
			neighbours.toFirst();
			
			while(neighbours.hasAccess()) {
				Vertex neighbour = neighbours.getContent();
				
				if(!neighbour.isMarked()) {
					Edge edge = g.getEdge(current, neighbour);
					Data d = getData(neighbour);
					
					int totalDistance = ((int) (edge.getWeight())) + lowestUnmarkedData.getDistance();
				
					if(totalDistance < d.getDistance() ) {
						d.setDistance(totalDistance);
						d.setParent(current);
					}
				}
				
				neighbours.next();
			}
		}
		
		//Step output
		result(data, data[0].getVertex(), current);
	}
	
	public static void result(Data[] data, Vertex startVertex, Vertex endVertex)  {
		
	}
	
	public static Data getData(Vertex vertex) {
		for(int i = 0; i < data.length; i++) {
			Data d = data[i];
			
			if(d.getVertex().equals(vertex)) {
				return d;
			}
		}
		return null;
	}
	
	public static Data getLowestVertex(Data[] data) {
		Data minimumData = null;
		int minimumDistance = Integer.MAX_VALUE;
		
		for(int i = 0; i < data.length; i++) {
			Data d = data[i];
			
			if(!d.getVertex().isMarked()) {
				if(d.getDistance() < minimumDistance) {
					minimumData = d;
					minimumDistance = d.getDistance();
				}
			}
		}
		
		return minimumData;
	}
}