package examenes_viejos.sp_2022_2c.ej2;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class MultilingualDictionary {

    private Map<Language, Map<String, String>> dict = new EnumMap<>(Language.class);
    private final Language language;

    public MultilingualDictionary(Language language) {
        this.language = language;
    }

    public MultilingualDictionary addTranslation(String word, Language translatingTo, String translation) {
        if(translatingTo.equals(language)) {
            throw new IllegalArgumentException("Cannot add %s translations".formatted(language));
        }
        dict.putIfAbsent(translatingTo, new HashMap<>());
        dict.get(translatingTo).putIfAbsent(word, translation);
        return this;
    }

    public String getTranslation(String word, Language translatingTo) {
        if(!dict.getOrDefault(translatingTo, new HashMap<>()).containsKey(word)) {
            throw new IllegalArgumentException("No %s translation for %s".formatted(translatingTo, word));
        }
        return dict.get(translatingTo).get(word);
    }

    public int translationsCount(Language lang) {
        return dict.getOrDefault(lang, new HashMap<>()).size();
    }

    public int removeTranslations(Language lang) {
        int ans = translationsCount(lang);
        dict.put(lang, new HashMap<>());
        return ans;
    }


}
