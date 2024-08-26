package guias.guia3.CellPhoneBill;

public class FriendCellPhoneBill extends CellPhoneBill {
    private String[] friends;
    private int maxFriends, friendIndex = 0;
    private double discount;

    public FriendCellPhoneBill(String number, int maxFriends, double discount) {
        super(number);
        this.friends = new String[maxFriends];
        this.maxFriends = maxFriends;
        this.discount = discount;
    }

    public void setDiscount(double discount) {
        if(discount >= 0 && discount <= 100) {
            this.discount = discount;
        }
    }

    public void addFriend(String number) {
        if(friendIndex < maxFriends) {
            friends[friendIndex++] = number;
        }
    }

    public void removeFriend(String number) {
        boolean found = false;
        for(int i = 0; i < friendIndex && !found; i++) {
            if(friends[i].compareTo(number) == 0) {
                friends[i] = friends[--friendIndex];
                found = true;
            }
        }
    }

    private boolean isFriend(String number) {
        for(int i = 0; i < friendIndex; i++) {
            if(friends[i].compareTo(number) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double processBill() {
        double bill = 0;
        for(int i = 0; i < callsIndex; i++) {
            bill += (isFriend(calls[i].getTo()) ? 1 - discount/100.0 : 1) * calls[i].getCost();
        }

        return bill;
    }



}
