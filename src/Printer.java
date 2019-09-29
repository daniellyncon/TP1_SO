import java.time.LocalTime;
import java.util.List;

public class Printer {
    private static final int PAGE_PER_MINUTE = 40;
    private static final LocalTime INTERVAL_BETWEEN_PRINTS = LocalTime.of(0,0,8);
    private List<Request> requests;

    public Printer(List<Request> requests) {
        this.requests = requests;
    }

    public Printer() {
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

}
