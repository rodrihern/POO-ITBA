package guias.guia4.HTMLText;

public class LinkText implements HTMLText{
    private static final String format = "<a href='%s'>%s<a/>";
    private final String url;
    private final HTMLText element;

    public LinkText(HTMLText element, String url) {
        this.element = element;
        this.url = url;
    }


    @Override
    public String source() {
        return format.formatted(url, element.source());
    }

    @Override
    public String toString() {
        return source();
    }
}
