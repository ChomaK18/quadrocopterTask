import java.util.Objects;

public class Transmitter {

    private final int number;
    private final Point center;
    private final int power;
    private boolean visited;

    public int getNumber() {
        return number;
    }

    public Point getCenter() {
        return center;
    }

    public int getPower() {
        return power;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        this.visited = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transmitter that = (Transmitter) o;
        return number == that.number &&
                power == that.power &&
                Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, center, power);
    }

    @Override
    public String toString() {
        return "Transmitter " + number;
    }

    public Transmitter(int number, Point center, int power) {
        this.number = number;
        this.center = new Point(center.getX(), center.getY());
        this.power = power;
    }

    public boolean isPointInside(Point point) {
        double distance = center.distanceTo(point);
        double radius = power;
        return distance <= radius;
    }

    public boolean isCrossedWith(Transmitter secondTr) {
        double distance = center.distanceTo(secondTr.getCenter());
        double sumRadius = power + secondTr.power;
        double diffrence = power - secondTr.power;
        if ((distance > sumRadius) || (distance < diffrence) || (distance == 0)) {  // without any intersections
            return false;
        }
        return true;
    }
}
