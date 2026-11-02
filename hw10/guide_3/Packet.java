package guide_3;

import java.io.Serializable;

public class Packet implements Serializable {
    public final int COMMAND;
    public final String PAYLOAD;

    public Packet(int command, String payload) {
        this.COMMAND = command;
        this.PAYLOAD = payload;
    }
}