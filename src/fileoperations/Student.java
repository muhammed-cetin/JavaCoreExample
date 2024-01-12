package fileoperations;

public class Student {
    private String name;
    private String surname;
    private String studentNumber;
    private double midtermGrade;
    private double finalGrade;
    private double successGrade;
    private String letterGrade;

    public Student() {
    }

    public Student(String name, String surname, String studentNumber, double midtermGrade, double finalGrade, double successGrade, String letterGrade) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.midtermGrade = midtermGrade;
        this.finalGrade = finalGrade;
        this.successGrade = successGrade;
        this.letterGrade = letterGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getMidtermGrade() {
        return midtermGrade;
    }

    public void setMidtermGrade(double midtermGrade) {
        this.midtermGrade = midtermGrade;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public double getSuccessGrade() {
        return successGrade;
    }

    public void setSuccessGrade(double successGrade) {
        this.successGrade = successGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
}
