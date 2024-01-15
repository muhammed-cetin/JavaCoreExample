package fileprocessingjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class MainJSON {
    public static void main(String[] args) {
        // Örnek bir Person dizisi oluştur
        Person[] persons = {
                new Person("Java", 29, "Core"),
                new Person("Muhammed", 25, "Bursa"),
                new Person("Spring", 8, "Java")
        };

        try {

            System.out.println("Person dizisini JSON dizisine dönüştür");
            String jsonArray = JsonFileProcessor.personsToJsonArray(persons);
            System.out.println("--------------------------------------------------------------");

            System.out.println("JSON dizisini dosyaya yaz");
            JsonFileProcessor.writeJsonToFile("persons.json", jsonArray);
            System.out.println("--------------------------------------------------------------");

            System.out.println("Dosyadan JSON dizisini oku");
            String readJsonArray = JsonFileProcessor.readJsonFromFile("persons.json");
            System.out.println("--------------------------------------------------------------");

            System.out.println("JSON dizisini Person dizisine dönüştür");
            Person[] readPersons = JsonFileProcessor.jsonArrayToPersons(readJsonArray);
            System.out.println("--------------------------------------------------------------");

            System.out.println("Dosyadan JSON dizisini yazdır");
            JsonFileProcessor.printJsonFile("persons.json");
            System.out.println("--------------------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
