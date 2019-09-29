import java.util.Comparator;
import java.util.List;

public class RequestSorter {

    //enfileirar por prioridade de cargo
    private static List<Request> sortRequestsByPriority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por quantidade de paginas
    private static List<Request> sortRequestsByPageQuantity(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar pelo prazo
    private static List<Request> sortRequestsByDeadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por prioridade de cargo e entao pela quantidade de paginas
    private static List<Request> sortRequestsByPriority_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por prioridade e entao pelo prazo
    private static List<Request> sortRequestsByPriority_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por prazo e entao pela prioridade de cargo
    private static List<Request> sortRequestByDeadline_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar por prazo e entao pela prioridade de cargo
    private static List<Request> sortRequestByDeadline_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
        return requestList;
    }

    //enfileirar pela quantidade de paginas e entao pelo prazo
    private static List<Request> sortRequestByPageNumber_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
        return requestList;
    }


    //enfileirar pela quantidade de paginas e entao pela prioridade de cargo
    private static List<Request> sortRequestByPageNumber_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
        return requestList;
    }

    //

}
