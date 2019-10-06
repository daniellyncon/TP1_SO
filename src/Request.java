import java.time.LocalTime;

public class Request {
    private int pageNumber;
    private String documentOwner;
    private LocalTime deadline;
    private Priority priority;
    private LocalTime arrivalTime;
    private LocalTime startTime;
    private LocalTime finishTime;

    Request(int pageNumber, String documentOwner, LocalTime deadline, Priority priority, LocalTime arrivalTime) {
        this.pageNumber = pageNumber;
        this.documentOwner = documentOwner;
        this.deadline = deadline;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    Request(int pageNumber, String documentOwner, LocalTime deadline, Priority priority, LocalTime arrivalTime, LocalTime startTime, LocalTime finishTime) {
        this.pageNumber = pageNumber;
        this.documentOwner = documentOwner;
        this.deadline = deadline;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    LocalTime getStartTime() {
        return startTime;
    }

    void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    LocalTime getFinishTime() {
        return finishTime;
    }

    void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    LocalTime getArrivalTime() {
        return arrivalTime;
    }

    Priority getPriority() {
        return priority;
    }

    int getPageNumber() {
        return pageNumber;
    }

    String getDocumentOwner() {
        return documentOwner;
    }

    LocalTime getDeadline() {
        return deadline;
    }

    void setDeadline(LocalTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proprietario: ").append(documentOwner).append(", Numero de paginas: ").append(pageNumber);
        if (this.deadline.compareTo(LocalTime.of(23,59,59,0)) == 0)
            sb.append(", Prazo: nao definido");
        else
            sb.append(", Prazo: ").append(deadline);
        sb.append(", Prioridade: ").append(priority);
        if (this.arrivalTime != null)
            sb.append(", Hora de chegada: ").append(arrivalTime);
        if (this.startTime != null)
            sb.append(", Inicio: ").append(startTime);
        if (this.finishTime != null)
            sb.append(", Termino: ").append(finishTime);

        return sb.toString();
    }


}