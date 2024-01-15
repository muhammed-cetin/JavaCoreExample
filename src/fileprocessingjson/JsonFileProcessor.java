package fileprocessingjson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileProcessor {

    public static void writeJsonToFile(String fileName, String jsonData) throws IOException {
        // Dosyada varolan veriyi sil
        Files.deleteIfExists(Paths.get(fileName));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Yeni veriyi dosyaya yaz
            writer.write(jsonData);
        }
    }

    public static String readJsonFromFile(String fileName) throws IOException {
        StringBuilder jsonData = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonData.append(line);
            }
        }
        return jsonData.toString();
    }

    public static Person[] jsonArrayToPersons(String jsonArray) {
        // JSON dizisini ayrıştırarak Person dizisine dönüştür
        String[] jsonObjects = jsonArray.split(",\\s*");
        Person[] persons = new Person[jsonObjects.length];

        for (int i = 0; i < jsonObjects.length; i++) {
            persons[i] = jsonToObject(jsonObjects[i]);
        }

        return persons;
    }

    public static String personsToJsonArray(Person[] persons) {
        // Person dizisini JSON dizisine dönüştür
        StringBuilder jsonArray = new StringBuilder("[");
        for (int i = 0; i < persons.length; i++) {
            jsonArray.append(personToJson(persons[i]));
            if (i < persons.length - 1) {
                jsonArray.append(",");
            }
        }
        jsonArray.append("]");
        return jsonArray.toString();
    }

    private static String personToJson(Person person) {
        // Person nesnesini JSON formatına çevir
        return "{" +
                "\"name\": \"" + person.getName() + "\"," +
                "\"age\": " + person.getAge() + "," +
                "\"city\": \"" + person.getCity() + "\"" +
                "}";
    }

    private static Person jsonToObject(String json) {
        String[] keyValuePairs = json.replaceAll("[{}\"]", "").split(",");
        Person person = new Person();

        for (String pair : keyValuePairs) {
            String[] entry = pair.split(":");

            // Uzunluğu kontrol et
            if (entry.length == 2) {
                String key = entry[0].trim();
                String value = entry[1].trim();

                switch (key) {
                    case "name":
                        person.setName(value);
                        break;
                    case "age":
                        person.setAge(Integer.parseInt(value));
                        break;
                    case "city":
                        person.setCity(value);
                        break;
                }
            }
        }

        return person;
    }

    public static void printJsonFile(String fileName) throws IOException {
        String jsonData = readJsonFromFile(fileName);
        System.out.println("Content of " + fileName + ":");
        System.out.println(jsonData);
    }
}
