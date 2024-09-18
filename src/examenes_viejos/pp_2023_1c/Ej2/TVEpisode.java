package examenes_viejos.pp_2023_1c.Ej2;

import java.time.LocalDate;

public class TVEpisode extends VideoCatalogElement {
    private final int season;

    public TVEpisode(String title, LocalDate airedDate, int season) {
        super(title, airedDate);
        this.season = season;
    }

    @Override
    public String toString() {
        return  "%s is a TV Epsiode of Season %d".formatted(super.toString(), season);
    }
}
