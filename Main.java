import java.util.*;
import com.github.javafaker.Faker;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        Intersection[] nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("v" + i) )
                .toArray(Intersection[]::new);
        Arrays.stream(nodes).forEach(i -> System.out.println(i.toString()));

        List<Street> edges = new LinkedList<Street>();

        Faker faker = new Faker();

        String name = faker.name().fullName();

        Street[] edgesArray = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Street(faker.name().fullName()) )
                .toArray(Street[]::new);
        edges.addAll(Arrays.asList(edgesArray));
        edgesArray[0].setEndA(nodes[0]);
        edgesArray[0].setEndB(nodes[1]);
        edgesArray[0].setLength(1);
        edgesArray[1].setEndA(nodes[1]);
        edgesArray[1].setEndB(nodes[2]);
        edgesArray[1].setLength(2);
        edgesArray[2].setEndA(nodes[2]);
        edgesArray[2].setEndB(nodes[3]);
        edgesArray[2].setLength(3);
        edgesArray[3].setEndA(nodes[3]);
        edgesArray[3].setEndB(nodes[0]);
        edgesArray[3].setLength(4);


        //Set<Intersection> set = new HashSet<>(Arrays.asList(nodes));
        IntersectionsSet intersections = new IntersectionsSet(nodes);
        //System.out.println(intersections.getIntersections());
        IntStream.range(0, edgesArray.length).forEach(i -> System.out.println(edgesArray[i].getName()));



        CityGraph city = new CityGraph(nodes, edgesArray);
        edges.stream()
                .filter(i -> i.getLength() > 3)
                .filter(i -> city.getCity().edgesOf(i.getEndA()).size() - 1 +
                        city.getCity().edgesOf(i.getEndB()).size() - 1 > 3);
        System.out.println(city.getCity().edgeSet());

        Collections.sort(edges);

        PrimMinimumSpanningTree<Intersection, DefaultWeightedEdge> primAlg = new PrimMinimumSpanningTree<>(city.getCity());
        System.out.println(primAlg.getSpanningTree());
    }
}
