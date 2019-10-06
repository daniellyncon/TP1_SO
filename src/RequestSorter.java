import java.util.Comparator;
import java.util.List;

public class RequestSorter {

    public RequestSorter() {
    }

    //enfileirar por prioridade de cargo
    static void sortRequestsByPriority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority);
        requestList.sort(comparator);
    }

    //enfileirar por quantidade de paginas
    static void sortRequestsByPageQuantity(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber);
        requestList.sort(comparator);
    }

    //enfileirar pelo prazo
    static void sortRequestsByDeadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline);
        requestList.sort(comparator);
//        return requestList;
    }

    //enfileirar por prioridade de cargo e entao pela quantidade de paginas
    static void sortRequestsByPriority_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
    }

    //enfileirar por prioridade e entao pelo prazo
    static void sortRequestsByPriority_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
    }

    //enfileirar por prazo e entao pela prioridade de cargo
    static void sortRequestByDeadline_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
    }

    //enfileirar por prazo e entao pela prioridade de cargo
    static void sortRequestByDeadline_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
    }

    //enfileirar pela quantidade de paginas e entao pelo prazo
    static void sortRequestByPageNumber_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
    }


    //enfileirar pela quantidade de paginas e entao pela prioridade de cargo
    static void sortRequestByPageNumber_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
    }

    static void sortRequestByPageNumber_Priority_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getPriority)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
    }

    static void sortRequestByPageNumber_Deadline_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPageNumber)
                .thenComparing(Request::getDeadline)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
    }

    static void sortRequestByDeadline_PageNumber_Priority(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPageNumber)
                .thenComparing(Request::getPriority);
        requestList.sort(comparator);
    }

    static void sortRequestByDeadline_Priority_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPriority)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
    }

    static void sortRequestByPriority_PageNumber_Deadline(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getPageNumber)
                .thenComparing(Request::getDeadline);
        requestList.sort(comparator);
    }

    static void sortRequestByPriority_Deadline_PageNumber(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getPriority)
                .thenComparing(Request::getDeadline)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
    }

    static void realTimeSort(List<Request> requestList) {
        Comparator<Request> comparator = Comparator.comparing(Request::getDeadline)
                .thenComparing(Request::getPriority)
                .thenComparing(Request::getPageNumber);
        requestList.sort(comparator);
    }

}