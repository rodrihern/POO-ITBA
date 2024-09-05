package examenes_viejos.pp_2024_1q_ej1;

import java.util.Objects;

public class FerryCompany {
    private final String name;
    public FerryCompany(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof FerryCompany fc) && fc.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

