package examenes_viejos.pp_2023_1c.Ej2;

import java.time.LocalDate;

public abstract class VideoCatalogElement implements Comparable<VideoCatalogElement> {
    private final String title;
    private final LocalDate airedDate;

    public VideoCatalogElement(String title, LocalDate airedDate) {
        this.title = title;
        this.airedDate = airedDate;
    }

    @Override
    public int compareTo(VideoCatalogElement o) {
        int cmp = this.title.compareTo(o.title);
        if(cmp == 0) {
            cmp = this.airedDate.compareTo(o.airedDate);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "%s aired on %s".formatted(title, airedDate);
    }


}
