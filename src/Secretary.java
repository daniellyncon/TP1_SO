import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalUnit;
import java.util.*;

public class Secretary {
    public static void main(String[] args) throws IOException, InterruptedException {
        menu();

    }

    public static void menu() throws IOException, InterruptedException {
        List<Request> requestList = requestList();
        Printer printer = new Printer(requestList);
        int opcao = 0;
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
            System.out.println("      |    0. Sair                                         |");
            System.out.println("       ====================================================\n");

            System.out.print("Informe uma opcao: ");
            opcao = Teclado.readInt();
            System.out.print("\n");
            switch (opcao) {
                case 1:
                    printer.printRequests();
                    break;
                case 2:
                    RequestSorter.sortRequestsByPageQuantity(requestList);
                    printer.printRequests();
                    break;
                case 3:
                    RequestSorter.sortRequestsByPriority(requestList);
                    printer.printRequests();
                    break;
                case 4:
                    RequestSorter.sortRequestsByDeadline(requestList);
                    printer.printRequests();
                    break;
                case 5:
                    RequestSorter.sortRequestByPageNumber_Priority(requestList);
                    printer.printRequests();
                    break;
                case 6:
                    RequestSorter.sortRequestByPageNumber_Deadline(requestList);
                    printer.printRequests();
                    break;
                case 7:
                    RequestSorter.sortRequestsByPriority_PageNumber(requestList);
                    printer.printRequests();
                    break;
                case 8:
                    RequestSorter.sortRequestsByPriority_Deadline(requestList);
                    printer.printRequests();
                    break;
                case 9:
                    RequestSorter.sortRequestByDeadline_PageNumber(requestList);
                    printer.printRequests();
                    break;
                case 10:
                    RequestSorter.sortRequestByDeadline_Priority(requestList);
                    printer.printRequests();
                    break;
                case 11:
                    RequestSorter.sortRequestByPageNumber_Priority_Deadline(requestList);
                    printer.printRequests();
                    break;
                case 12:
                    RequestSorter.sortRequestByPageNumber_Deadline_Priority(requestList);
                    printer.printRequests();
                    break;
                case 13:
                    RequestSorter.sortRequestByPriority_PageNumber_Deadline(requestList);
                    printer.printRequests();
                    break;
                case 14:
                    RequestSorter.sortRequestByPriority_Deadline_PageNumber(requestList);
                    printer.printRequests();
                    break;
                case 15:
                    RequestSorter.sortRequestByDeadline_PageNumber_Priority(requestList);
                    printer.printRequests();
                    break;
                case 16:
                    RequestSorter.sortRequestByDeadline_Priority_PageNumber(requestList);
                    printer.printRequests();
                    break;
                case 0:
                    break;

                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
        } while (opcao != 0);
    }


    private static List<Request> requestList() {
        Scanner requests = null;
        try {
            requests = new Scanner(new FileReader("requests.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
            LocalTime deadline;
            if (requestData[3].length() == 5) {
                deadline = LocalTime.parse(requestData[3]);
            } else if (requestData[3].length() == 4) {
                deadline = LocalTime.parse("0" + requestData[3]);
            } else {
                deadline = LocalTime.of(23, 59);
            }
            r = new Request(owner, pages, deadline, p);
            requestList.add(r);
        }
        requests.close();
        return requestList;
    }

    private static int quantityRegisters() {
        Scanner file = null;
        try {
            file = new Scanner(new FileReader("requests.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int registersQuantity = Integer.parseInt(file.nextLine());
        file.close();
        return registersQuantity;
    }
}
