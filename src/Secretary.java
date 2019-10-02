
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.*;


public class Secretary {
    public static void main(String[] args) throws InterruptedException {
//        List<Request> requestList = requestList();
//        Printer printer = new Printer();
//        printer.realTimePrint();
//
//            Double prioridade = Report.averageReturnTime(printer.getReportData());
//            System.out.println(prioridade);
//
//



        int op;
        do {
            System.out.println("\n###                    Sistema de Impressão               ###");
            System.out.println("       ====================================================");
            System.out.println("      |    1. Pedidos chegam por email                     |");
            System.out.println("      |    2. Execuçao em tempo real                       |");
            System.out.println("      |    0. Sair                                         |");
            System.out.println("       ====================================================\n");

            System.out.print("Informe uma opcao: ");
            op = Teclado.readInt();
            System.out.print("\n");

            switch (op) {
                case 1:
                    menuDuasImpressoras();
                    break;
                case 2:
                    List<Request> requestList = requestList();
                    Printer printer3 = new Printer(requestList);
                    printer3.realTimePrint();
                    break;
                case 3:
                    menuDuasImpressoras();
                case 0:
                    System.out.println("Saindo do sistema");
                    break;

                default:
                    System.out.println("Opcao Invalida");
                    break;
            }

        } while (op != 0);

    }

    static void menuDuasImpressoras() throws InterruptedException {
        List<Request> requestList = requestList();
        Printer printer = new Printer(requestList);
        int opcao = 0;
        int qtdeImpressoras = 0;
        boolean inserirAlternado = false;
        do {
            System.out.println("\n###                    Sistema de Impressão               ###");
            System.out.println("       =====================================================");
            System.out.println("      |    1. Ordem de chegada (FIFO)                      |");
            System.out.println("      |    2. Ordem de paginas                             |");
            System.out.println("      |    3. Ordem de prioridade                          |");
            System.out.println("      |    4. Ordem de prazo                               |");
            System.out.println("      |    5. Ordem de paginas > prioridade                |");
            System.out.println("      |    6. Ordem de pagina > prazo                      |");
            System.out.println("      |    7. Ordem de prioridade > paginas                |");
            System.out.println("      |    8. Ordem de prioridade > prazo                  |");
            System.out.println("      |    9. Ordem de prazo > paginas                     |");
            System.out.println("      |   10. Ordem de prazo > prioridade                  |");
            System.out.println("      |   11. Ordem de pagina > prioridade > prazo         |");
            System.out.println("      |   12. Ordem de pagina > prazo > prioridade         |");
            System.out.println("      |   13. Ordem de prioridade > paginas > prioridade   |");
            System.out.println("      |   14. Ordem de prioridade > prazo > paginas        |");
            System.out.println("      |   15. Ordem de prazo > paginas > prioridade        |");
            System.out.println("      |   16. Ordem de prazo > prioridade > paginas        |");
            System.out.println("      |                                                    |");
            System.out.println("      |   17. Relatorios                                   |");
            System.out.println("      |                                                    |");
            System.out.println("      |    0. Sair                                         |");
            System.out.println("       ====================================================\n");

            System.out.print("Informe uma opcao: ");
            opcao = Teclado.readInt();
            Printer printer1 = new Printer();
            Printer printer2 = new Printer();
            System.out.print("\n");
            switch (opcao) {
                case 1:
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);

                    }
                    break;
                case 2:
                    RequestSorter.sortRequestsByPageQuantity(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 3:
                    RequestSorter.sortRequestsByPriority(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 4:
                    RequestSorter.sortRequestsByDeadline(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 5:
                    RequestSorter.sortRequestByPageNumber_Priority(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 6:
                    RequestSorter.sortRequestByPageNumber_Deadline(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 7:
                    RequestSorter.sortRequestsByPriority_PageNumber(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 8:
                    RequestSorter.sortRequestsByPriority_Deadline(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 9:
                    RequestSorter.sortRequestByDeadline_PageNumber(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 10:
                    RequestSorter.sortRequestByDeadline_Priority(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 11:
                    RequestSorter.sortRequestByPageNumber_Priority_Deadline(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 12:
                    RequestSorter.sortRequestByPageNumber_Deadline_Priority(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 13:
                    RequestSorter.sortRequestByPriority_PageNumber_Deadline(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 14:
                    RequestSorter.sortRequestByPriority_Deadline_PageNumber(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 15:
                    RequestSorter.sortRequestByDeadline_PageNumber_Priority(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 16:
                    RequestSorter.sortRequestByDeadline_Priority_PageNumber(requestList);
                    System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                    qtdeImpressoras = Teclado.readInt();
                    if (qtdeImpressoras == 1)
                        printer.printRequests();
                    else {
                        imprimir(printer1, printer2, inserirAlternado, requestList);
                    }
                    break;
                case 17:
                    Integer retorno = 0;
                    printer.realTimePrint();
                    System.out.println(printer.getReportData().size());
                    for (Request r: printer.getReportData()){
                        retorno += (r.getFinishTime().toSecondOfDay() - r.getFinishTime().toSecondOfDay());
                        System.out.println(r.getStartTime());
                        System.out.println(r.getFinishTime() + "\n");
                    }
                    break;
                case 0:
                    break;

                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
        } while (opcao != 0);
    }


    private static void imprimir (Printer printer1, Printer printer2, boolean inserirAlternado, List<Request> requestList ) {
        for (Request request : requestList) {
            if (!inserirAlternado) {
                printer1.getRequests().add(request);
                inserirAlternado = true;
            } else {
                printer2.getRequests().add(request);
                inserirAlternado = false;
            }
        }
        System.out.println("Impressora 1");
        try {
            printer1.printRequests();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------");
        System.out.println("Impressora 2");
        try {
            printer2.printRequests();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @SuppressWarnings("unlikely-arg-type")
	private static List<Request> requestList() {
        Scanner requests = null;
        try {
            requests = new Scanner(new FileReader("dadosImpressora20192.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        requests.nextLine();
        Request r;
        Priority p;
        List<Request> requestList = new ArrayList<>();
		requests.nextLine();
        assert requests != null;
        while (requests.hasNextLine()) {
            String line = requests.nextLine();
            String[] requestData = line.split(";");
            String owner = requestData[0];
            String priority = requestData[1];
            if (priority.equals("P"))
                p = Priority.P;
            else if (priority.equals("C"))
                p = Priority.C;
            else
                p = Priority.D;
            int pages = Integer.parseInt(requestData[2]);
            LocalTime deadline = null;
            if (requestData[3].length() == 5) {
                deadline = LocalTime.parse(requestData[3]);
            } else if (requestData[3].length() == 4) {
                deadline = LocalTime.parse("0" + requestData[3]);
                if(deadline.equals("00:00")) {
                	deadline = LocalTime.of(23, 59);
                }
            }
            LocalTime arrivalTime;
            if (requestData[4].length() == 5) {
                arrivalTime = LocalTime.parse(requestData[4]);
            } else {
                arrivalTime = LocalTime.parse("0" + requestData[4]);
            }

            r = new Request(pages, owner, deadline, p, arrivalTime);
            requestList.add(r);
        }
        requests.close();
        return requestList;
    }
}
