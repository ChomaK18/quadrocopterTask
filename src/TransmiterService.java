import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransmiterService {

    public String pass = "Safe passage is possible";
    public String notPass = "Safe passage is impossible";

    public boolean checkIfPassageIsPossible(List<Transmitter> transmitters, Point start, Point end) {

        TransmitterMapBuilder transmitterMapBuilder = new TransmitterMapBuilder();

        Map<Transmitter, List<Transmitter>> map = transmitterMapBuilder.makeMap(transmitters);

        boolean result = false;

        for (Transmitter t : transmitters) {

            if (t.isPointInside(start)) {
                boolean branchResult = checkIfPassageIsPossible(t, end, map);
                result = result || branchResult;
            }
        }
        return result;
    }

    private static boolean checkIfPassageIsPossible(Transmitter transmitter, Point point,
                                                    Map<Transmitter, List<Transmitter>> map) {

        transmitter.visit();

        if (transmitter.isPointInside(point)) {
            return true;
        }

        List<Transmitter> neibours = map.get(transmitter);
        List<Transmitter> notVisitedNeibours = neibours.stream()
                .filter(transmitter1 -> !transmitter1.isVisited())
                .collect(Collectors.toList());

        if (notVisitedNeibours.isEmpty()) {
            return false;
        }
        for (Transmitter t : notVisitedNeibours) {
            return checkIfPassageIsPossible(t, point, map);
        }
        return false;
    }
}
