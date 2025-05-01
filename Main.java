package FirstYr_SecondSem_Midterm_PracticalExam;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "grade.txt";

        printStudentGrades(fileName);
        System.out.printf("Average Grade: %.2f",calculateAverageGrade(fileName));
    }

    public static double calculateAverageGrade(String fileName){
        HashMap<String,Integer> studentGrades = new HashMap<>();
        File file = new File(fileName);
        double avgGrade = 0;

        try(Scanner avgGradeScanner = new Scanner(file)){
            while (avgGradeScanner.hasNextLine()){
                String nextLine = avgGradeScanner.nextLine();
                String[] studentGradesArray = nextLine.split(" ");

                int gradeIntegerConversion = Integer.parseInt(studentGradesArray[1]);
                studentGrades.put(studentGradesArray[0],gradeIntegerConversion);
            }
        }catch(Exception e){
            System.out.println("Error: " +  e);
        }
        for(int i: studentGrades.values()){
            avgGrade += i;
        }
        return avgGrade / studentGrades.size();
    }

    public static void printStudentGrades(String fileName){
        HashMap<String,Integer> studentGrades = new HashMap<>();
        File file = new File(fileName);

        try(Scanner scanStudentGrades = new Scanner(file)){
            while(scanStudentGrades.hasNextLine()){
                String nextLine = scanStudentGrades.nextLine();
                String[] studentGradesArray = nextLine.split(" ");
                int gradesConvertStringToInt = Integer.parseInt(studentGradesArray[1]);
                studentGrades.put(studentGradesArray[0],gradesConvertStringToInt);
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
        System.out.println("Student Grades: ");
        for(String i : studentGrades.keySet()){
            System.out.println(i + ": " + studentGrades.get(i));
        }
    }
}