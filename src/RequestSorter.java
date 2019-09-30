import java.util.Comparator;
import java.util.List;

public class RequestSorter {

    public RequestSorter() {
    }

    //enfileirar por prioridade de cargo
    public static List<Request> sortRequestsByPriority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por quantidade de paginas
    public static List<Request> sortRequestsByPageQuantity(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar pelo prazo
    public static List<Request> sortRequestsByDeadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por prioridade de cargo e entao pela quantidade de paginas
    public static List<Request> sortRequestsByPriority_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por prioridade e entao pelo prazo
    public static List<Request> sortRequestsByPriority_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por prazo e entao pela prioridade de cargo
    public static List<Request> sortRequestByDeadline_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por prazo e entao pela prioridade de cargo
    public static List<Request> sortRequestByDeadline_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar pela quantidade de paginas e entao pelo prazo
    public static List<Request> sortRequestByPageNumber_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
        return requestList;
    }


    //enfileirar pela quantidade de paginas e entao pela prioridade de cargo
    public static List<Request> sortRequestByPageNumber_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
        return requestList;
    }

    public static List<Request> sortRequestByPageNumber_Priority_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getPriority)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
        return requestList;
    }

    public static List<Request> sortRequestByPageNumber_Deadline_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getDeadline)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
        return requestList;
    }

    public static List<Request> sortRequestByDeadline_PageNumber_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPageNumber)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
        return requestList;
    }

    public static List<Request> sortRequestByDeadline_Priority_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPriority)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
        return requestList;
    }

    public static List<Request> sortRequestByPriority_PageNumber_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getPageNumber)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
        return requestList;
    }

    public static List<Request> sortRequestByPriority_Deadline_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getDeadline)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
        return requestList;
    }

    public static void realTimeSort(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getDeadline)
                .thenComparing(Request::getPageNumber)
                .thenComparing(Request::getArrivalTime);
        requestList.sort(comparator);
    }

}