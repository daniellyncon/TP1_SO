import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Printer {
    //private static final int PAGE_PER_MINUTE = 40;
    private static final int TIME_SPENT_PER_PAGE = 1500/1000;
    private static final int SECONDS_BETWEEN_PRINTS = 8;
    private List<Request> requests;

    public Printer(List<Request> requests) {
        this.requests = requests;
    }

    public Printer() {
    	this.requests = new ArrayList<>();
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
    
    public void adicionaRequisicao(Request request) {
    	this.requests.add(request);
    };

    //nova versao
    public void printRequests() throws InterruptedException {
        LocalTime startingTime = LocalTime.now();
        LocalTime timeSpent = startingTime;
        for (Request request : this.getRequests()) {
            System.out.println("Imprimindo documento de " + request.getDocumentOwner() + " que tem " + request.getPageNumber() + " paginas...");
            //multiplicando o numero de paginas por 1500 milisegundos(1 segundo e meio) e dividindo por 1000 para converter de volta
            timeSpent = timeSpent.plusSeconds(request.getPageNumber() * TIME_SPENT_PER_PAGE);
            //acrescentando 8 segundos entre uma impressao e outra
            timeSpent = timeSpent.plusSeconds(SECONDS_BETWEEN_PRINTS);
            System.out.println("Finalizada impressao de "+request.getDocumentOwner()+".");
            System.out.println("Tempo gasto ate  o momento: "+ timeSpent.minusNanos(startingTime.toNanoOfDay()) + "\n");

        }
        System.out.println("Tempo total gasto: "+timeSpent.minusNanos(startingTime.toNanoOfDay()));
    }

//      versao anterior
//    public LocalTime printDocument(Request r, LocalTime timeSpentTotal) {
//        System.out.println("Começo da impressao de "+r.getDocumentOwner()+" que tem "+r.getPageNumber()+" paginas: "+timeSpentTotal);
//        //multiplicando o numero de paginas por 1500 milisegundos(1 segundo e meio) e dividindo por 1000 para converter de volta
//        timeSpentTotal = timeSpentTotal.plusSeconds(r.getPageNumber()*TIME_SPENT_PER_PAGE);
//        //acrescentando 8 segundos entre uma impressao e outra
//        timeSpentTotal = timeSpentTotal.plusSeconds(SECONDS_BETWEEN_PRINTS);
//        System.out.println("Tempo depois de imprimir 40 paginas de fulano: "+timeSpentTotal);
//        return timeSpentTotal;
//    }

}
