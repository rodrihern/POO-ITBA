package guias.guia4.HTMLText;

public class PlainText implements HTMLText{
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String source() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
