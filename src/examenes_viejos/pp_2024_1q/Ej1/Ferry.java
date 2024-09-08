package examenes_viejos.pp_2024_1q.Ej1;

import java.util.Objects;

public class Ferry {
    private final String name;
    private final FerryCompany company;
    public Ferry(String name, FerryCompany c) {
        this.name = name;
        this.company = c;
    }
    public FerryCompany getCompany() {
        return company;
    }
    @Override
    public String toString() {
        return "Ferry %s".formatted(name);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Ferry f) && f.name.equals(this.name) && f.company.equals(this.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company);
    }

}

