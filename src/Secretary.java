import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Secretary {
    public static void main(String[] args) {
        List<Request> requestList = requestList();
        Printer printer = new Printer(requestList);
        Printer printer1 = new Printer();
        Printer printer2 = new Printer();
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
                    int opcao;
                    int qtdeImpressoras;
                    do {
                        System.out.println("\n###                    Sistema de Impressão               ###");
                        System.out.println("       =====================================================");
                        System.out.println("      |    1. Ordem de chegada                             |");
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
                        System.out.println("      |    0. Sair                                         |");
                        System.out.println("       ====================================================\n");

                        System.out.print("Informe uma opcao: ");
                        opcao = Teclado.readInt();
                        System.out.print("\n");
                        switch (opcao) {
                            case 1:
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 2:
                                RequestSorter.sortRequestsByPageQuantity(printer.getRequests());
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 3:
                                RequestSorter.sortRequestsByPriority(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 4:
                                RequestSorter.sortRequestsByDeadline(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 5:
                                RequestSorter.sortRequestByPageNumber_Priority(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 6:
                                RequestSorter.sortRequestByPageNumber_Deadline(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 7:
                                RequestSorter.sortRequestsByPriority_PageNumber(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 8:
                                RequestSorter.sortRequestsByPriority_Deadline(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 9:
                                RequestSorter.sortRequestByDeadline_PageNumber(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 10:
                                RequestSorter.sortRequestByDeadline_Priority(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 11:
                                RequestSorter.sortRequestByPageNumber_Priority_Deadline(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 12:
                                RequestSorter.sortRequestByPageNumber_Deadline_Priority(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 13:
                                RequestSorter.sortRequestByPriority_PageNumber_Deadline(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 14:
                                RequestSorter.sortRequestByPriority_Deadline_PageNumber(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 15:
                                RequestSorter.sortRequestByDeadline_PageNumber_Priority(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 16:
                                RequestSorter.sortRequestByDeadline_Priority_PageNumber(requestList);
                                System.out.println("Digite a quantidade de impressoras(1 ou 2)");
                                qtdeImpressoras = Teclado.readInt();
                                if (qtdeImpressoras == 1)
                                    printer.printRequests();
                                else {
                                    imprimir(printer1, printer2, requestList);
                                }
                                break;
                            case 0:
                                System.out.println("Retornando ao menu principal");
                                break;

                            default:
                                System.out.println("Opcao Invalida");
                                break;
                        }
                        requestList = requestList();
                        printer = new Printer(requestList);
                        printer1 = new Printer();
                        printer2 = new Printer();

                    } while (opcao != 0);
                    break;
                case 2:
                    printer.realTimePrint();
                    printer = new Printer(requestList);
                    break;
                case 0:
                    System.out.println("Saindo do sistema");
                    break;

                default:
                    System.out.println("Opcao Invalida");
                    break;
            }

        } while (op != 0);

    }

    private static void imprimir (Printer printer1, Printer printer2, List<Request> requestList) {
        boolean inserirAlternado = false;
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
        printer1.printRequests();


        System.out.println("-------------------");
        System.out.println("Impressora 2");
        printer2.printRequests();

        float contagemDocumentos = printer1.getCountDocuments()+printer2.getCountDocuments();
        float porcentagemDocumentosDentroPrazo = contagemDocumentos /(printer1.getReportData().size()+printer2.getReportData().size())*100;
        float totalDiretores = printer1.getCountDirectors()+printer2.getCountDirectors();
        float totalCoordenadores = printer1.getCountCoordenators()+printer2.getCountCoordenators();
        float totalProfessores = printer1.getCountProfessors()+printer2.getCountProfessors();
        float totalDiretoresNoPrazo = printer1.getDiretoresNoPrazo()+printer2.getDiretoresNoPrazo();
        float totalCoordenadoresNoPrazo = printer1.getCoordenadoresNoPrazo()+printer2.getCoordenadoresNoPrazo();
        float totalProfessoresNoPrazo = printer1.getProfessoresNoPrazo()+printer2.getProfessoresNoPrazo();

        List<Integer> listaConjuntoMinutos = new ArrayList<>();
        listaConjuntoMinutos.addAll(printer1.getMinutos());
        listaConjuntoMinutos.addAll(printer2.getMinutos());
        System.out.println(listaConjuntoMinutos.size());

        System.out.printf("\nTotal de documentos impressos dentro do prazo: %2.0f\n", contagemDocumentos);
        System.out.printf("Porcentagem de impressoes dentro do prazo: %2.2f", porcentagemDocumentosDentroPrazo);
        System.out.println("%.");
        System.out.println("Quantidade de atendimentos por cargo:");
        System.out.println("Diretores: " + (int) totalDiretores);
        System.out.println("Coordenadores " + (int) totalCoordenadores);
        System.out.println("Professores " + (int) totalProfessores);
        System.out.println("Quantidade de atendimentos dentro do prazo por cargo ");
        System.out.println("Diretores " + (int) totalDiretoresNoPrazo);
        System.out.println("Coordenadores " + (int) totalCoordenadoresNoPrazo);
        System.out.println("Professores " + (int) totalProfessoresNoPrazo);
        System.out.printf("Total de documentos de diretores impressos dentro do prazo: %2.0f\n", totalDiretoresNoPrazo);
        System.out.printf("Porcentagem de impressoes de diretores dentro do prazo: %2.2f", totalDiretoresNoPrazo / totalDiretores * 100);
        System.out.println("%.");
        System.out.printf("Total de documentos de coordenadores dentro do prazo: %2.0f\n", totalCoordenadoresNoPrazo);
        System.out.printf("Porcentagem de impressoes de coordenadores dentro do prazo: %2.2f", totalCoordenadoresNoPrazo / totalCoordenadores * 100);
        System.out.println("%.");
        System.out.printf("Total de documentos de professores dentro do prazo: %2.0f\n", totalProfessoresNoPrazo);
        System.out.printf("Porcentagem de impressoes de professores dentro do prazo: %2.2f", totalProfessoresNoPrazo / totalProfessores * 100);
        System.out.println("%.");
        System.out.println("Tempo de retorno medio " + LocalTime.ofSecondOfDay((long) listaConjuntoMinutos.stream().mapToDouble(Integer::doubleValue).average().getAsDouble()));
    }



    @SuppressWarnings("unlikely-arg-type")
	private static List<Request> requestList() {
        Scanner requests = null;
        try {
            requests = new Scanner(new FileReader("dadosImpressora20192.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert requests != null;
        requests.nextLine();
        Request r;
        Priority p;
        List<Request> requestList = new ArrayList<>();

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

            if(("0" + requestData[3]).equals("00:00")) {
                deadline = LocalTime.of(18, 0,0,0);
            } else
                deadline = LocalTime.parse("0" + requestData[3]);
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
