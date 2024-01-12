package fileoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectMain {
    public static void main(String[] args) {
        FileOperations fileOps = new FileOperations();
        fileOps.setFileName("src/fileoperations/txt/studentInfo.txt");
        fileOps.createFile();
        fileOps.setGraphicFile("src/fileoperations/txt/frequencyChart.txt");
        fileOps.createGraphicalFile();

        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        int menu1;
        do {
            System.out.println("1-Record Operation");
            System.out.println("2-Calculation Operation");
            System.out.println("3-Reporting Operation");
            System.out.println("0-Exit");
            System.out.println("Please Choose an Operation: ");
            menu1 = scanner.nextInt();
            System.out.println();

            switch (menu1) {
                case 1:
                    System.out.println("Student Name: ");
                    String name = scanner.next();
                    System.out.println("Student Surname: ");
                    String surname = scanner.next();
                    System.out.println("Student Number: ");
                    String studentNo = scanner.next();
                    System.out.println("Enter Student's Midterm Grade: ");
                    double midtermGrade = scanner.nextDouble();
                    System.out.println("Enter Student's Final Grade: ");
                    double finalGrade = scanner.nextDouble();

                    Student newStudent = new Student(name, surname, studentNo, midtermGrade, finalGrade, 0, " ");
                    fileOps.writeToStudentFile(newStudent);
                    break;

                case 2:
                    studentList = fileOps.readFromFile();
                    if (studentList.size() == 0) {
                        System.out.println("The list is empty, please add the first student.");
                        System.out.println();
                    } else {
                        fileOps.deleteFile(fileOps.getFileName());
                        fileOps.createFile();

                        for (Student student : studentList) {
                            double successGrade = (student.getMidtermGrade() * 0.40) + (student.getFinalGrade() * 0.60);
                            student.setSuccessGrade(successGrade);

                            String letterGrade;
                            if (successGrade > 75 && successGrade <= 100) {
                                letterGrade = "A";
                            } else if (successGrade > 50 && successGrade <= 75) {
                                letterGrade = "B";
                            } else if (successGrade > 25 && successGrade <= 50) {
                                letterGrade = "C";
                            } else {
                                letterGrade = "D";
                            }
                            student.setLetterGrade(letterGrade);

                            fileOps.writeToStudentFile(new Student(student.getName(), student.getSurname(),
                                    student.getStudentNumber(), student.getMidtermGrade(), student.getFinalGrade(),
                                    successGrade, letterGrade));

                            System.out.println(student.getStudentNumber() + " Student " + student.getName() +
                                    " " + student.getSurname() + "'s " + " Midterm Grade: " + student.getMidtermGrade() +
                                    " Final Grade: " + student.getFinalGrade() + " Success Grade: " + successGrade +
                                    " LETTER GRADE : " + letterGrade);
                        }

                        System.out.println();
                        fileOps.deleteFile(fileOps.getGraphicFile());
                        fileOps.createGraphicalFile();

                        for (Student student : studentList) {
                            switch (student.getLetterGrade()) {
                                case "A":
                                    fileOps.writeToGraphicalFile("* * * *");
                                    break;
                                case "B":
                                    fileOps.writeToGraphicalFile("* * *");
                                    break;
                                case "C":
                                    fileOps.writeToGraphicalFile("* *");
                                    break;
                                case "D":
                                    fileOps.writeToGraphicalFile("*");
                                    break;
                            }
                        }
                    }
                    break;

                case 3:
                    studentList = fileOps.readFromFile();
                    if (studentList.size() == 0) {
                        System.out.println("The list is empty, please add the first student.");
                        System.out.println();
                    } else {
                        double midtermSum = 0, finalSum = 0, successSum = 0, midtermAvg, finalAvg, successAvg;

                        for (Student student : studentList) {
                            System.out.println(student.getStudentNumber() + " Student " + student.getName() +
                                    " " + student.getSurname() + "'s " + " Success Grade: " + student.getSuccessGrade() +
                                    " LETTER GRADE : " + student.getLetterGrade());

                            midtermSum += student.getMidtermGrade();
                            finalSum += student.getFinalGrade();
                            successSum += student.getSuccessGrade();
                        }

                        midtermAvg = midtermSum / studentList.size();
                        finalAvg = finalSum / studentList.size();
                        successAvg = successSum / studentList.size();

                        System.out.println();
                        System.out.println("Students' Midterm Average: " + midtermAvg);
                        System.out.println("Students' Final Average: " + finalAvg);
                        System.out.println("Students' Success Average: " + successAvg);

                        double max = studentList.get(0).getSuccessGrade();
                        double min = studentList.get(0).getSuccessGrade();
                        Student mostSuccessful = studentList.get(0);
                        Student leastSuccessful = studentList.get(0);

                        for (Student student : studentList) {
                            if (student.getSuccessGrade() > max) {
                                max = student.getSuccessGrade();
                                mostSuccessful = student;
                            }

                            if (student.getSuccessGrade() < min) {
                                min = student.getSuccessGrade();
                                leastSuccessful = student;
                            }
                        }

                        System.out.println();
                        System.out.println("Most Successful Student");
                        System.out.println("Student's Name: " + mostSuccessful.getName() +
                                " Surname: " + mostSuccessful.getSurname() +
                                " Student Number: " + mostSuccessful.getStudentNumber() +
                                " Midterm Grade: " + mostSuccessful.getMidtermGrade() +
                                " Final Grade: " + mostSuccessful.getFinalGrade() +
                                " Success Grade: " + mostSuccessful.getSuccessGrade() +
                                " Letter Grade: " + mostSuccessful.getLetterGrade());

                        System.out.println();
                        System.out.println("Least Successful Student");
                        System.out.println("Student's Name: " + leastSuccessful.getName() +
                                " Surname: " + leastSuccessful.getSurname() +
                                " Student Number: " + leastSuccessful.getStudentNumber() +
                                " Midterm Grade: " + leastSuccessful.getMidtermGrade() +
                                " Final Grade: " + leastSuccessful.getFinalGrade() +
                                " Success Grade: " + leastSuccessful.getSuccessGrade() +
                                " Letter Grade: " + leastSuccessful.getLetterGrade());
                    }
                    System.out.println();
            }
        } while (menu1 != 0);
    }
}
