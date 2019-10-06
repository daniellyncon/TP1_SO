import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Printer {
    private static final int SECONDS_BETWEEN_PRINTS = 8;
    private static final LocalTime OPENING_TIME = LocalTime.of(8, 0, 0, 0);
    private static final LocalTime CLOSING_TIME = LocalTime.of(18, 0, 0, 0);
    private List<Request> requests;
    private List<Request> reportData;
    private float countDocuments;
    private float countDirectors;
    private float countCoordenators;
    private float countProfessors;
    private float diretoresNoPrazo;
    private float coordenadoresNoPrazo;
    private float professoresNoPrazo;
    private List<Integer> minutos;

    List<Request> getReportData() {
        return reportData;
    }

    Printer(List<Request> requests) {
        this.requests = requests;
        this.reportData = new ArrayList<>();
        this.countDocuments = 0;
        this.countDirectors = 0;
        this.countCoordenators = 0;
        this.countProfessors = 0;
        this.diretoresNoPrazo = 0;
        this.coordenadoresNoPrazo = 0;
        this.professoresNoPrazo = 0;
        this.minutos = new ArrayList<>();
    }

    Printer() {
        this.requests = new ArrayList<>();
        this.reportData = new ArrayList<>();
        this.countDocuments = 0;
        this.countDirectors = 0;
        this.countCoordenators = 0;
        this.countProfessors = 0;
        this.diretoresNoPrazo = 0;
        this.coordenadoresNoPrazo = 0;
        this.professoresNoPrazo = 0;
        this.minutos = new ArrayList<>();
    }

    public static int getSecondsBetweenPrints() {
        return SECONDS_BETWEEN_PRINTS;
    }

    public static LocalTime getOpeningTime() {
        return OPENING_TIME;
    }

    public static LocalTime getClosingTime() {
        return CLOSING_TIME;
    }

    public float getCountDocuments() {
        return countDocuments;
    }

    public float getCountDirectors() {
        return countDirectors;
    }

    public float getCountCoordenators() {
        return countCoordenators;
    }

    public float getCountProfessors() {
        return countProfessors;
    }

    public float getDiretoresNoPrazo() {
        return diretoresNoPrazo;
    }

    public float getCoordenadoresNoPrazo() {
        return coordenadoresNoPrazo;
    }

    public float getProfessoresNoPrazo() {
        return professoresNoPrazo;
    }

    public List<Integer> getMinutos() {
        return minutos;
    }

    List<Request> getRequests() {
        return requests;
    }


    void printRequests() {
        LocalTime startingTime = OPENING_TIME;
        LocalTime timeSpent = startingTime;

        for (Request request : this.requests) {
            request.setStartTime(timeSpent);
            if (request.getPriority().equals(Priority.D))
                this.countDirectors++;
            else if (request.getPriority().equals(Priority.C))
                this.countCoordenators++;
            else
                this.countProfessors++;

            if (!request.getDeadline().equals(LocalTime.of(18, 0, 0, 0))) {
                LocalTime newDeadline = OPENING_TIME.plusSeconds(request.getDeadline().toSecondOfDay());
                request.setDeadline(newDeadline);
            }

            System.out.println("Imprimindo documento de " + request.getDocumentOwner() + " que tem " + request.getPageNumber()
                    + " paginas. Inicio: " + request.getStartTime() + " prazo: " + request.getDeadline() + " prioridade: " + request.getPriority());
            timeSpent = timeSpent.plusSeconds((request.getPageNumber() * 1500 / 1000) + SECONDS_BETWEEN_PRINTS);

            request.setFinishTime(timeSpent);
            System.out.println("Finalizada impressao de " + request.getDocumentOwner() + ". Termino: " + request.getFinishTime());

            this.minutos.add(request.getFinishTime().toSecondOfDay() - OPENING_TIME.toSecondOfDay());
            if (timeSpent.isBefore(request.getDeadline())) {
                System.out.println("Documento impresso dentro do prazo!");
                this.countDocuments++;
                if (request.getPriority().equals(Priority.D))
                    this.diretoresNoPrazo++;
                else if (request.getPriority().equals(Priority.C))
                    this.coordenadoresNoPrazo++;
                else
                    this.professoresNoPrazo++;
            } else
                System.out.println("Documento impresso fora do prazo...");

            System.out.println("Tempo gasto ate o momento: " + timeSpent.minusNanos(startingTime.toNanoOfDay()) + "\n");
            this.reportData.add(request);

        }

        imprimirRelatorio();
    }

    void realTimePrint() {

        System.out.println("Começando o dia de trabalho!");
        LocalTime currentTime = OPENING_TIME;
        String currentOwner = null;
        LocalTime currentOwnerArrivalTime = null;
        LocalTime currentOwnerDeadline = null;
        Priority currentOwnerPriority = null;
        boolean isPrinting = false;
        long currentRequestTimeLeft = 0;
        List<Request> waitList = new ArrayList<>();
        while (currentTime.compareTo(CLOSING_TIME) != 0) {

//            quando o tempo tempo de chegada do proximo item na lista for maior que o tempo atual, remover ele da lista
//            e incluir na lista de espera
            if (this.requests.size() > 0) {
                if (currentTime.toNanoOfDay() >= this.requests.get(0).getArrivalTime().toNanoOfDay()) {
                    try {
                        while (currentTime.toNanoOfDay() >= this.requests.get(0).getArrivalTime().toNanoOfDay()) {
                            waitList.add(this.requests.remove(0));
                            int ultimoDaFila = waitList.size() - 1;
                            //waitList.get(ultimoDaFila).setStartTime(waitList.get(ultimoDaFila).getArrivalTime());

                            ///////////////////////////////////////////////////////////////////////////////////////////////////
                            if (waitList.get(ultimoDaFila).getPriority().equals(Priority.D))
                                this.countDirectors++;
                            else if (waitList.get(ultimoDaFila).getPriority().equals(Priority.C))
                                this.countCoordenators++;
                            else
                                this.countProfessors++;

                            if (!waitList.get(ultimoDaFila).getDeadline().equals(LocalTime.of(18, 0, 0, 0))) {
                                LocalTime newDeadline = currentTime.plusSeconds(waitList.get(ultimoDaFila).getDeadline().toSecondOfDay());
                                waitList.get(ultimoDaFila).setDeadline(newDeadline);
                            } else {
                                waitList.get(ultimoDaFila).setDeadline(LocalTime.of(23, 59, 59, 0));
                            }

                            System.out.println(currentTime + " " + waitList.get(ultimoDaFila).getDocumentOwner() +
                                    " entrou na lista de espera. Seu prazo de impressao e ate " + waitList.get(ultimoDaFila).getDeadline());
                            ///////////////////////////////////////////////////////////////////////////////////////////////////
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Acabou a entrada de documentos.");
                    }

                    RequestSorter.realTimeSort(waitList);
                }
            }

            if (waitList.size() > 0 && !isPrinting) {
                System.out.println("Quantidade de documentos na lista de espera: " + waitList.size());
                System.out.println("Proprietario | Prazo: ");
                for (Request request : waitList) {
                    System.out.println(request.getDocumentOwner() + " " + request.getDeadline());
                }
                currentOwner = waitList.get(0).getDocumentOwner();
                currentOwnerArrivalTime = waitList.get(0).getArrivalTime();
                currentOwnerDeadline = waitList.get(0).getDeadline();
                currentOwnerPriority = waitList.get(0).getPriority();


                //waitList.get(0).setDeadline(waitList.get(0).getArrivalTime().plusSeconds(waitList.get(0).getDeadline().toNanoOfDay()));
                waitList.get(0).setStartTime(currentTime);
                System.out.println(currentTime + " Iniciando a impressao de " + waitList.get(0).getDocumentOwner()
                        + ", o documento possui " + waitList.get(0).getPageNumber() + " paginas. Chegada " + waitList.get(0).getArrivalTime() + " Prazo: " + waitList.get(0).getDeadline());


                //reportData.get(0).setStartTime(currentTime);
                currentRequestTimeLeft = waitList.get(0).getPageNumber() * 1500 / 1000;
                isPrinting = true;
                Request r = new Request(waitList.get(0).getPageNumber(),
                        waitList.get(0).getDocumentOwner(),
                        waitList.get(0).getDeadline(),
                        waitList.get(0).getPriority(),
                        waitList.get(0).getArrivalTime(),
                        waitList.get(0).getStartTime(),
                        waitList.get(0).getFinishTime());
                this.reportData.add(r);
                this.reportData.get(this.reportData.size() - 1).setStartTime(currentTime);

                waitList.remove(0);
            }

            if (waitList.size() == 0 && !isPrinting) {
                System.out.println(currentTime + " Impressora ociosa...");
            }

            //se estamos imprimindo, decrementar o tempo restante para imprimir o documento atual pelo tempo gasto por
            //pagina e se terminar de imprimir, somar o tempo entre documentos de 8 segundos
            //e muda para falso o atributo IMPRIMINDO

            if (isPrinting) {
                currentRequestTimeLeft -= 1500 / 1000;
                currentTime = currentTime.plusSeconds(1500 / 1000);


                if (currentRequestTimeLeft <= 0) {

                    System.out.println(currentTime + " Finalizando impressao: ");
                    System.out.println("Proprietario " + currentOwner);
                    System.out.println("Chegada " + currentOwnerArrivalTime);
                    System.out.println("Prazo " + currentOwnerDeadline);
                    this.reportData.get(this.reportData.size() - 1).setFinishTime(currentTime);

                    //////////////////////////////////////////////////////////////////////////////////////////////
                    this.minutos.add(currentTime.toSecondOfDay() - currentOwnerArrivalTime.toSecondOfDay());
                    if (currentTime.isBefore(currentOwnerDeadline)) {
                        System.out.println("Documento impresso dentro do prazo!\n");
                        this.countDocuments++;
                        if (currentOwnerPriority.equals(Priority.D))
                            this.diretoresNoPrazo++;
                        else if (currentOwnerPriority.equals(Priority.C))
                            this.coordenadoresNoPrazo++;
                        else
                            this.professoresNoPrazo++;
                    } else {
                        System.out.println("Documento impresso fora do prazo...");
                        System.out.println(currentOwner);
                    }
                    ////////////////////////////////////////////////////////////////////////////////////////////////

                    currentTime = currentTime.plusSeconds(8);
                    isPrinting = false;


                }

            } else {
                currentTime = currentTime.plusSeconds(1);
            }
            // System.out.println("Agora sao "+currentTime+" horas");

        }
        System.out.println("Encerrando o dia de trabalho!");
        if (waitList.size() > 0) {
            System.out.println("Ficaram " + waitList.size() + " documentos sem imprimir...");
            for (Request request : waitList) {
                System.out.println(request);
            }
        }

        imprimirRelatorio();
    }


    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private void imprimirRelatorio() {
        System.out.printf("\nTotal de documentos impressos dentro do prazo: %2.0f\n", this.countDocuments);
        System.out.printf("Porcentagem de impressoes dentro do prazo: %2.2f", this.countDocuments / this.reportData.size() * 100);
        System.out.println("%.");
        System.out.println("Quantidade de atendimentos por cargo:");
        System.out.println("Diretores: " + (int) this.countDirectors);
        System.out.println("Coordenadores " + (int) this.countCoordenators);
        System.out.println("Professores " + (int) this.countProfessors);
        System.out.println("Quantidade de atendimentos dentro do prazo por cargo ");
        System.out.println("Diretores " + (int) this.diretoresNoPrazo);
        System.out.println("Coordenadores " + (int) this.coordenadoresNoPrazo);
        System.out.println("Professores " + (int) this.professoresNoPrazo);
        System.out.printf("Total de documentos de diretores impressos dentro do prazo: %2.0f\n", this.diretoresNoPrazo);
        System.out.printf("Porcentagem de impressoes de diretores dentro do prazo: %2.2f", this.diretoresNoPrazo / this.countDirectors * 100);
        System.out.println("%.");
        System.out.printf("Total de documentos de coordenadores dentro do prazo: %2.0f\n", this.coordenadoresNoPrazo);
        System.out.printf("Porcentagem de impressoes de coordenadores dentro do prazo: %2.2f", this.coordenadoresNoPrazo / this.countCoordenators * 100);
        System.out.println("%.");
        System.out.printf("Total de documentos de professores dentro do prazo: %2.0f\n", this.professoresNoPrazo);
        System.out.printf("Porcentagem de impressoes de professores dentro do prazo: %2.2f", this.professoresNoPrazo / this.countProfessors * 100);
        System.out.println("%.");
        System.out.println("Tempo de retorno medio " + LocalTime.ofSecondOfDay((long) this.minutos.stream().mapToDouble(Integer::doubleValue).average().getAsDouble()));
    }


}
