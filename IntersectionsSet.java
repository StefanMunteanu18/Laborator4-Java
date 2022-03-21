import java.util.Arrays;
import java.util.HashSet;

public class IntersectionsSet {
    private HashSet<Intersection> intersections;

    public IntersectionsSet() {
        this.intersections = new HashSet<Intersection>();
    }

    public IntersectionsSet(HashSet<Intersection> intersections) {
        this.intersections = intersections;
    }

    public IntersectionsSet(Intersection[] nodes) {
        this.intersections = new HashSet<>(Arrays.asList(nodes));
    }

    public HashSet<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(HashSet<Intersection> intersections) {
        this.intersections = intersections;
    }


}
