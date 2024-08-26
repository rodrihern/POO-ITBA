package guias.guia3.CellPhoneBill;

public class CellPhoneBillTester {
    public static void main(String[] args) {
        FriendCellPhoneBill b1 = new FriendCellPhoneBill("0000", 3, 50);
        b1.addFriend("1111");
        b1.addFriend("2222");
        b1.addFriend("3333");
        b1.addFriend("5555");
        b1.addFriend("2020");

        b1.registerCall("1111", 100);
        System.out.println(b1.processBill()); // 0.5
        b1.registerCall("2222", 100);
        System.out.println(b1.processBill()); // 1.0
        b1.registerCall("3333", 100);
        System.out.println(b1.processBill()); // 1.5
        b1.registerCall("5555", 100);
        System.out.println(b1.processBill()); //2.5
        b1.setDiscount(75);
        b1.registerCall("1234", 100);
        b1.registerCall("2020", 100);
        System.out.println(b1.processBill()); // 3.75
    }
}
