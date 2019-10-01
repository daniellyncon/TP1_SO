import com.sun.security.jgss.GSSUtil;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Printer {
    private static final int TIME_SPENT_PER_PAGE = 1500 / 1000;
    private static final int SECONDS_BETWEEN_PRINTS = 8;
    private static final LocalTime OPENING_TIME = LocalTime.of(8, 0);
    private static final LocalTime CLOSING_TIME = LocalTime.of(18, 0);
    private List<Request> requests;


    public Printer(List<Request> requests) {
        this.requests = requests;
    }

    public Printer() {
        this.requests= new ArrayList<>();
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void adicionaRequisicao(Request request) {
       this.requests.add(request);
    }


    //nova versao
    public void printRequests() throws InterruptedException {
        LocalTime startingTime = LocalTime.now();
        LocalTime timeSpent = startingTime;
        for (Request request : this.getRequests()) {
            System.out.println("Imprimindo documento de " + request.getDocumentOwner() + " que tem " + request.getPageNumber() + " paginas...");
            //multiplicando o numero de paginas por 1500 milisegundos(1 segundo e meio) e dividindo por 1000 para converter de volta
            timeSpent = timeSpent.plusSeconds(request.getPageNumber() * 1500 / 1000);
            //acrescentando 8 segundos entre uma impressao e outra
            timeSpent = timeSpent.plusSeconds(SECONDS_BETWEEN_PRINTS);
            System.out.println("Finalizada impressao de " + request.getDocumentOwner() + ".");
            System.out.println("Tempo gasto ate  o momento: " + timeSpent.minusNanos(startingTime.toNanoOfDay()) + "\n");
            //Thread.sleep(8000);
        }
        System.out.println("Tempo total gasto: " + timeSpent.minusNanos(startingTime.toNanoOfDay()));
    }

    public void realTimePrint() throws InterruptedException {

        System.out.println("Começando o dia de trabalho!");
        LocalTime currentTime = OPENING_TIME;
        String currentOwner = null;
        boolean isPrinting = false;
        long currentRequestTimeLeft = 0;
        List<Request> waitList = new ArrayList<>();
        while (currentTime.compareTo(CLOSING_TIME) != 0) {

            //quando o tempo tempo de chegada do proximo item na lista for maior que o tempo atual, remover ele da lista
            //e incluir na lista de espera
            if (requests.size()>0) {
                if (currentTime.toNanoOfDay() >= requests.get(0).getArrivalTime().toNanoOfDay()) {

                    while (currentTime.toNanoOfDay() >= requests.get(0).getArrivalTime().toNanoOfDay()){
                        waitList.add(requests.remove(0));
                        if (requests.size() == 0)
                            break;
                    }

                    System.out.println("=================================================");
                    System.out.println("=================================================");
                    System.out.println("Exibindo lista ordenada");
                    RequestSorter.realTimeSort(waitList);
                    for (Request r : waitList) {
                        System.out.println(r);
                    }
                    System.out.println("Agora sao "+currentTime+" horas");
                    System.out.println("=================================================");
                    System.out.println("=================================================");
                }
            }
            if (waitList.size() > 0 && !isPrinting) {
                currentOwner = waitList.get(0).getDocumentOwner();
                System.out.println("Iniciando a impressao de " + waitList.get(0).getDocumentOwner()
                        + ", o documento possui " + waitList.get(0).getPageNumber() + " paginas.");
                currentRequestTimeLeft = waitList.get(0).getPageNumber() * 1500 / 1000;
                System.out.println(currentRequestTimeLeft);
                isPrinting = true;
                waitList.remove(0);
                System.out.println("Agora sao "+currentTime+" horas");
            }

            //se estamos imprimindo, decrementar o tempo restante para imprimir o documento atual pelo tempo gasto por
            //pagina e se terminar de imprimir, somar o tempo entre documentos de 8 segundos
            //e muda para falso o atributo IMPRIMINDO

            if (isPrinting) {
                currentRequestTimeLeft -= 1500 / 1000;
                currentTime = currentTime.plusSeconds(1500 / 1000);

                if (currentRequestTimeLeft <= 0) {
                    System.out.println("Encenrrando impressao do documento de "+currentOwner);
                    currentTime = currentTime.plusSeconds(8);
                    isPrinting = false;
                }

            } else {
                currentTime = currentTime.plusSeconds(1);
            }
            System.out.println("Agora sao "+currentTime+" horas");

        }
        System.out.println("Encerrando o dia de trabalho!");
    }

}
