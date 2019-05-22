package it.polito.tdp.porto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {
	
	private SimpleGraph<Author, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
	private Map<Integer, Author> idMap = new HashMap<>();

	public List<Author> getAllAuthor() {
		PortoDAO dao = new PortoDAO();
		return dao.getAllAuthor(idMap);
	}

	public String getCoAutori(Author a) {
		String risultato="";
		PortoDAO dao = new PortoDAO();
		List<CoAutori> coAutori = dao.getCoAutori();
		Graphs.addAllVertices(grafo, idMap.values()); //lo uso quando devo aggiungere tutti i vertici
		for(CoAutori co: coAutori) {
			Author a1 = idMap.get(co.getPrimo().getId());
			Author a2 = idMap.get(co.getSecondo().getId());
			
			Graphs.addEdgeWithVertices(grafo, a1, a2);
		}
		System.out.println("Vertici: "+grafo.vertexSet().size()+" Archi: "+grafo.edgeSet().size());
		List<Author> vicini=Graphs.neighborListOf(grafo, a);
		for(Author a1: vicini) {
			risultato+= a1.toString()+"\n";
		}
		
		return risultato;
	}

}
