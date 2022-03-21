import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.stream.IntStream;

public class CityGraph {
    private Graph<Intersection, DefaultWeightedEdge> city;

    public CityGraph(Intersection[] nodes, Street[] edges) {
        this.city = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        IntStream.range(0, nodes.length).forEach(i -> city.addVertex(nodes[i]));
        //IntStream.range(0, nodes.length).forEach(i -> System.out.println(nodes[i]));
        IntStream.range(0, edges.length).forEach(i -> {city.addEdge(edges[i].getEndA(), edges[i].getEndB());
                                                       city.setEdgeWeight(edges[i].getEndA(), edges[i].getEndB(),edges[i].getLength());
                                                      });
        //IntStream.range(0, edges.length).forEach(i -> System.out.println(edges[i].getEndA().toString() + edges[i].getEndB().toString()));
    }

    public Graph<Intersection, DefaultWeightedEdge> getCity() {
        return city;
    }
}
