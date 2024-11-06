package examenes_viejos.sp_2023_1c.ej2;


import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class AddressBook {
    private final SortedMap<AddressBookGroup, SortedMap<String, Contact>> contactsByGroup = new TreeMap<>();

    public void addContact(AddressBookGroup abg, String name, String phoneNumber) {
        contactsByGroup.putIfAbsent(abg, new TreeMap<>());
        contactsByGroup.get(abg).put(name, new Contact(name, phoneNumber));
    }

    public Contact getContact(AddressBookGroup abg, String name) {
        if(!contactsByGroup.getOrDefault(abg, new TreeMap<>()).containsKey(name)) {
            throw new IllegalArgumentException();
        }
        return contactsByGroup.get(abg).get(name);
    }

    public void renameContact(AddressBookGroup abg, String oldName, String newName) {
        Contact contact = getContact(abg, oldName);
        contactsByGroup.get(abg).remove(oldName);
        contact.setName(newName);
        contactsByGroup.get(abg).put(newName, contact);
    }

    public List<Contact> getAllContacts(AddressBookGroup abg) {
        return new ArrayList<>(contactsByGroup.getOrDefault(abg, new TreeMap<>()).values());
    }

    public List<Contact> getAllContacts() {
        List<Contact> ans = new ArrayList<>();
        for(AddressBookGroup abg : contactsByGroup.keySet()) {
            ans.addAll(getAllContacts(abg));
        }
        return ans;
    }


}
