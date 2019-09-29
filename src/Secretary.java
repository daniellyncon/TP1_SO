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
    public static void main(String[] args) {
        List<Request> requestList = requestList();


        Printer printer = new Printer(requestList);
        printer.printRequests();




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
