package guias.guia4.HTMLText;

public class ItalicText extends FormatText{
    private static final String format = "<i>%s<i/>";

    public ItalicText(HTMLText text) {
        super(text, format);
    }
}
