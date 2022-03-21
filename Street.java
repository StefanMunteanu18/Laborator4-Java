import java.util.Comparator;

public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Intersection endA;
    private Intersection endB;

    public Street(String name, int length, Intersection endA, Intersection endB) {
        this.name = name;
        this.length = length;
        this.endA = endA;
        this.endB = endB;
    }

    public Street(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Intersection getEndA() {
        return endA;
    }

    public void setEndA(Intersection endA) {
        this.endA = endA;
    }

    public Intersection getEndB() {
        return endB;
    }

    public void setEndB(Intersection endB) {
        this.endB = endB;
    }

    public void setEnds(Intersection endA, Intersection endB) {
        this.endA = endA;
        this.endB = endB;
    }

    @Override
    public int compareTo(Street obj) {
        return Integer.compare(this.getLength(), obj.getLength());
    }
}
