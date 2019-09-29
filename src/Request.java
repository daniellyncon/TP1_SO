import java.time.LocalTime;
import java.util.Comparator;

public class Request {
    private int pageNumber;
    private String documentOwner;
    private LocalTime deadline;
    private Priority priority;
    private LocalTime arrivalTime;

    public Request(int pageNumber, String documentOwner, LocalTime deadline, Priority priority, LocalTime arrivalTime) {
        this.pageNumber = pageNumber;
        this.documentOwner = documentOwner;
        this.deadline = deadline;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }


    public Request(String documentOwner, int pageNumber, LocalTime deadline, Priority priority) {
        this.documentOwner = documentOwner;
        this.pageNumber = pageNumber;
        this.deadline = deadline;
        this.priority = priority;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getDocumentOwner() {
        return documentOwner;
    }

    public void setDocumentOwner(String documentOwner) {
        this.documentOwner = documentOwner;
    }

    public LocalTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Request{" +
                "pageNumber=" + pageNumber +
                ", documentOwner='" + documentOwner + '\'' +
                ", deadline=" + deadline +
                ", arrivalTime=" + arrivalTime +
                ", priority=" + priority +
                '}';
    }


}