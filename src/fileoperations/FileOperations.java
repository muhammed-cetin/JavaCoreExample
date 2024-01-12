package fileoperations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    private String fileName;
    private String graphicFile;
    private BufferedReader br;
    private File f;

    public FileOperations() {
    }

    // Add getters and setters

    void createFile() {
        f = new File(this.fileName);
        createFileHelper(f);
    }

    void createGraphicalFile() {
        f = new File(this.graphicFile);
        createFileHelper(f);
    }

    private void createFileHelper(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("The file already exists, no creation process will be performed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToStudentFile(Student s) {
        String data = s.getName() + "&" + s.getSurname() + "&" + s.getStudentNumber() + "&" +
                s.getMidtermGrade() + "&" + s.getFinalGrade() + "&" + s.getSuccessGrade() + "&" +
                s.getLetterGrade();
        try (FileWriter writer = new FileWriter(this.fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file!!");
        }
    }

    public void writeToGraphicalFile(String data) {
        try (FileWriter writer = new FileWriter(this.graphicFile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file!!");
        }
    }

    public void deleteFile(String name) {
        f = new File(name);
        if (f.exists()) {
            f.delete();
        }
    }

    public List<Student> readFromFile() {
        List<Student> studentList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(this.fileName)) {
            br = new BufferedReader(fileReader);
            String str = br.readLine();
            while (str != null) {
                String[] attributes = str.split("&");
                Student student = new Student(attributes[0], attributes[1], attributes[2],
                        Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]),
                        Double.parseDouble(attributes[5]), attributes[6]);
                studentList.add(student);
                str = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file!!");
        }
        return studentList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getGraphicFile() {
        return graphicFile;
    }

    public void setGraphicFile(String graphicFile) {
        this.graphicFile = graphicFile;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }
}
