package guias.guia4.CellPhoneBill;

public class CellPhoneBillTester {

    public static void main(String[] args) {
        FriendCellPhoneBill my_bill = new FriendCellPhoneBill("4444-4444", 3, 50);
        try {
            my_bill.addFriend("5555-5555");
            my_bill.addFriend("6666-6666");
        } catch (NumberException ex) {
            // No ocurre
        }
        my_bill.registerCall("5555-5555", 10);
        my_bill.registerCall("6666-5555", 10);
        System.out.println(my_bill.processBill());
        try {
            my_bill.addFriend("6666-6666");
        } catch (NumberException ex){
            System.out.println(ex.getMessage());
        }
        try {
            my_bill.addFriend("4444-4444");
            my_bill.addFriend("7777-7777");
        } catch (NumberException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            my_bill.removeFriend("5555-5555");
            my_bill.removeFriend("5555-5555");
        } catch (NumberException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
