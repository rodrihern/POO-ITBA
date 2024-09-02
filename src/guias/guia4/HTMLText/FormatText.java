package guias.guia4.HTMLText;

public class FormatText implements HTMLText{
    HTMLText element;
    String format;

    public FormatText(HTMLText element, String format) {
        this.element = element;
        this.format = format;
    }


    @Override
    public String source() {
        return format.formatted(element.source());
    }

    @Override
    public String toString() {
        return source();
    }
}
