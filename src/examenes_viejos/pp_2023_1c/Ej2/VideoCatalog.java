package examenes_viejos.pp_2023_1c.Ej2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class VideoCatalog {
    private VideoCatalogElement[] catalog;
    private final static int DEFAULT_SIZE = 10;
    private int dim;

    public VideoCatalog() {
        catalog = new VideoCatalogElement[DEFAULT_SIZE];
        dim = 0;
    }

    private void resize() {
        catalog = Arrays.copyOf(catalog, catalog.length + DEFAULT_SIZE);
    }

    private VideoCatalog addElement(VideoCatalogElement element) {
        if(dim == catalog.length) {
            resize();
        }
        catalog[dim++] = element;
        return this;
    }

    // el add de episodios
    public VideoCatalog add(String title, LocalDate airedDate, int season) {
        return addElement(new TVEpisode(title, airedDate, season));
    }

    // el add de movies
    public VideoCatalog add(String title, LocalDate airedDate, String studio) {
        return addElement(new Movie(title, airedDate, studio));
    }

    public VideoCatalogElement[] getChronologicalDateCopy() {
        VideoCatalogElement[] copy = Arrays.copyOf(catalog, dim);
        Arrays.sort(copy);
        return copy;
    }

    public VideoCatalogElement[] getDescendingDateCopy() {
        VideoCatalogElement[] copy = Arrays.copyOf(catalog, dim);
        Arrays.sort(copy, Comparator.reverseOrder());
        return copy;
    }
}
