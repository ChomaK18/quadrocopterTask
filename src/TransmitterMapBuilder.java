import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransmitterMapBuilder {
    public Map<Transmitter, List<Transmitter>> makeMap (List<Transmitter> transmitters){

        Map <Transmitter, List<Transmitter>> transmitersToCrossTransmiters = new HashMap<>();

        for (Transmitter t : transmitters) {
            List<Transmitter> connectedTransmitters = new ArrayList<>();
            for (Transmitter tr : transmitters ) {
                if (t.isCrossedWith(tr)) {
                    connectedTransmitters.add(tr);
                }
            }
            transmitersToCrossTransmiters.put(t, connectedTransmitters);
        }
        return transmitersToCrossTransmiters;
    }
}
