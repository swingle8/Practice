class AlienLanguageTranslator {
    private static final int OFFSET = 3;
    public String fromDefaultLanguage(String languageTokens) {
        String newText = processConversion(languageTokens, true);
        return newText;
    }

    public String toDefaultLanguage(String languageTokens) {
        String newText = processConversion(languageTokens, false);
        return newText;
    }

    public String processConversion (String data, boolean translateIntoCodeword) {
        int len = data.length();
        String output = new String();
        for (int i = 0 ; i < len ; i ++) {
            char text = data.charAt(i);
            int ascii = (int) text;
            if (translateIntoCodeword)
                ascii = ascii + OFFSET;
            else
                ascii = ascii - OFFSET;
            char newChar = (char) ascii;
            output = output + newChar;
        }

        return output;
    }
}

public class OwnTranslation {
  public static void main (String [] args) {
    String text = "hello shivam, how are you?";
    System.out.println("My original text was : " + text);
    AlienLanguageTranslator alt = new AlienLanguageTranslator ();

    String alienText = alt.fromDefaultLanguage (text);
    System.out.println(alienText);

    String backToNormal = alt.toDefaultLanguage (alienText);
    System.out.println (backToNormal);
  }
}
