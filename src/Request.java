import java.time.LocalTime;

public class Request {
    private int pageNumber;
    private String documentOwner;
    private LocalTime deadline;
    private Priority priority;
    private LocalTime arrivalTime;
    private LocalTime startTime;
    private LocalTime finishTime;

    public Request(int pageNumber, String documentOwner, LocalTime deadline, Priority priority, LocalTime arrivalTime) {
        this.pageNumber = pageNumber;
        this.documentOwner = documentOwner;
        this.deadline = deadline;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public Request(int pageNumber, String documentOwner, LocalTime deadline, Priority priority, LocalTime arrivalTime, LocalTime startTime, LocalTime finishTime) {
        this.pageNumber = pageNumber;
        this.documentOwner = documentOwner;
        this.deadline = deadline;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    public Request(String documentOwner, int pageNumber, LocalTime deadline, Priority priority) {
        this.documentOwner = documentOwner;
        this.pageNumber = pageNumber;
        this.deadline = deadline;
        this.priority = priority;
        this.startTime = LocalTime.of(0,0);
        this.finishTime = LocalTime.of(0,0);
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
        StringBuilder sb = new StringBuilder();
        sb.append("Proprietario: ").append(documentOwner).append(", Numero de paginas: ").append(pageNumber);
        if (this.deadline.compareTo(LocalTime.of(23,59)) == 0)
            sb.append(", Prazo: nao definido");
        else
            sb.append(", Prazo: ").append(deadline);
        sb.append(", Prioridade: ").append(priority);
        if (this.arrivalTime != null)
            sb.append(", Hora de chegada: ").append(arrivalTime);
        return sb.toString();
    }


}