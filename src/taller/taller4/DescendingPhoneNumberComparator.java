package taller.taller4;

import java.util.Comparator;

public class DescendingPhoneNumberComparator implements Comparator<PhoneNumber> {

    @Override
    public int compare(PhoneNumber o1, PhoneNumber o2) {
        return o2.compareTo(o1);
    }
}
