package Tester;

public class myClass {
    private int num;

    public myClass(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "%d".formatted(num);
    }
}
