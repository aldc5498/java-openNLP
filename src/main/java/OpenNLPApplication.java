

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OpenNLPApplication {
    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream("opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin")) {

            TokenNameFinderModel model = new TokenNameFinderModel(inputStream);

            NameFinderME nameFinder = new NameFinderME(model);

            String[] sentence = new String[]{
                    "John",
                    "Smith",
                    "is",
                    "a",
                    "software",
                    "engineer",
                    "at",
                    "ABC",
                    "Technologies",
                    "."
            };
            Span[] spans = nameFinder.find(sentence);
            for (Span span : spans) {
                System.out.println(span.toString());
                for (int i = span.getStart(); i < span.getEnd(); i++) {
                    System.out.println(sentence[i]);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
