package guias.guia4.HTMLText;

public class BoldText extends FormatText{

    private static final String format = "<b>%s<b/>";

    public BoldText(HTMLText text) {
        super(text, format);
    }
}
