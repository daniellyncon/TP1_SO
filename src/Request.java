import java.time.LocalTime;
import java.util.Comparator;

public class Request {
    private int pageNumber;
    private String documentOwner;
    private LocalTime deadline;
    private LocalTime arrivalTime;
    private Priority priority;

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

//    //comparar pelo numero de paginas
//    public int compareByPages(Request r) {
//        if (this.pageNumber == r.getPageNumber())
//            return 0;
//        else if (this.pageNumber > (r.getPageNumber()))
//            return 1;
//        else
//            return -1;
//    }
//
//    //comparar pela prioridade
//    public int compareByPriority(Request r) {
//        return this.priority.compareTo(r.getPriority());
//    }
//
//    //comparar pelo prazo
//    public int compareByDeadline(Request r) {
//        if (this.deadline.equals(r.getDeadline()))
//            return 0;
//        else if (this.getDeadline().isAfter(r.getDeadline()))
//            return 1;
//        else
//            return -1;
//    }

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

//class PageComparator implements Comparator<Request> {
//    //comparar pelo numero de paginas
//    public int compare(Request r1, Request r2) {
//        return Integer.compare(r1.getPageNumber(), r2.getPageNumber());
//    }
//}
//
//class DeadlineComparator implements Comparator<Request> {
//    //comparar pelo prazo
//    public int compare(Request r1, Request r2) {
//        if (r1.getDeadline().equals(r2.getDeadline()))
//            return 0;
//        else if (r1.getDeadline().isAfter(r2.getDeadline()))
//            return 1;
//        else
//            return -1;
//    }
//}
//
//class PriorityComparator implements Comparator<Request> {
//    //comparar por prioridade
//    public int compare(Request r1, Request r2) {
//        return r1.getPriority().compareTo(r2.getPriority());
//    }
//}