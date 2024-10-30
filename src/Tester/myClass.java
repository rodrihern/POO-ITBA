package Tester;

public class myClass {
    private int num = 0;

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
