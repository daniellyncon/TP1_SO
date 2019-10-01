import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Report {

    private Float tempoMedioRetorno;



    public static Double averageReturnTime(List<Request> requests){
        List<Double> tempoRetorno = new ArrayList<>();
        int horaChegada, horaTermino;
        double retorno = 0;

        for (Request r: requests) {
            horaChegada = r.getArrivalTime().toSecondOfDay();
            horaTermino = r.getFinishTime().toSecondOfDay();
            tempoRetorno.add((double)(horaTermino - horaChegada)/60);
        }

        for (int i = 0; i <= tempoRetorno.size(); i++){
            retorno += tempoRetorno.get(i);
        }

        retorno = retorno/tempoRetorno.size();
        System.out.println(retorno);

        return retorno;
}

}
