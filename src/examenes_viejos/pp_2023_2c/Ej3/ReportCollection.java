package examenes_viejos.pp_2023_2c.Ej3;

public interface ReportCollection<R> {

    void add(R report);


    R get(int index);


    R[] reports();
}
