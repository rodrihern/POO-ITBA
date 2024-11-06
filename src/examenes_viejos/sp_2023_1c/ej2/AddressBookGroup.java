package examenes_viejos.sp_2023_1c.ej2;

import java.util.Objects;

public class AddressBookGroup implements Comparable<AddressBookGroup>{

    private final String name;

    public AddressBookGroup(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(AddressBookGroup o) {
        return name.compareTo(o.name);
    }
}

