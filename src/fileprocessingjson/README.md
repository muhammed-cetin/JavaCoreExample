# File Processing JSON

Java programlama dilinde yazılmış bir dosya işleme uygulamasını içermektedir. Aşağıda, her bir sınıf ve metodun işlevini açıklamaya çalışacağım

---

### Person 
Bu sınıf, bir kişinin adını, yaşını ve şehrini temsil eden temel bir veri modelidir.

### Metodlar:
- **Constructor:**
    - `Person(String name, int age, String city)`: Ad, yaş ve şehir bilgileri ile bir Person nesnesi oluşturur.

- **Getter ve Setter Metodları:**
    - `getName(): String`: Kişinin adını döndürür.
    - `getAge(): int`: Kişinin yaşını döndürür.
    - `getCity(): String`: Kişinin şehrini döndürür.
    - `setName(String name)`: Kişinin adını ayarlar.
    - `setAge(int age)`: Kişinin yaşını ayarlar.
    - `setCity(String city)`: Kişinin şehrini ayarlar.

---

### JsonFileProcessor 
Bu sınıf, JSON formatında verileri dosyaya yazmak, dosyadan JSON formatındaki verileri okumak, JSON dizisini Person dizisine dönüştürmek ve Person dizisini JSON dizisine dönüştürmek gibi işlevlere sahiptir.

### Metodlar:
- `writeJsonToFile(String fileName, String jsonData)`: Verilen dosya adına sahip bir dosyaya JSON verisini yazar.
- `readJsonFromFile(String fileName): String`: Verilen dosya adındaki dosyadan JSON verisini okur.
- `jsonArrayToPersons(String jsonArray): Person[]`: JSON dizisini ayrıştırarak Person dizisine dönüştürür.
- `personsToJsonArray(Person[] persons): String`: Person dizisini JSON dizisine dönüştürür.
- `personToJson(Person person): String`: Bir Person nesnesini JSON formatına çevirir.
- `jsonToObject(String json): Person`: Bir JSON string'ini Person nesnesine çevirir.
- `printJsonFile(String fileName)`: Verilen dosya adındaki dosyanın içeriğini ekrana yazdırır.

---

### MainJSON 
Bu sınıf, JsonFileProcessor sınıfındaki metodları kullanarak örnek bir Person dizisini JSON dizisine dönüştürür, bu JSON dizisini bir dosyaya yazar, dosyadan okur, tekrar Person dizisine dönüştürür ve en sonunda dosyanın içeriğini ekrana yazdırır.

### Metodlar:
- `main(String[] args)`: Uygulamanın ana noktası. JSON işlemlerini gösteren örnek uygulama.

