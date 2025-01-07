
////            PROBLEM STATEMENT
//INPUT: Take marks obtained (out of 100) in each subject.
//Calculate total marks: Sum of the marks obtained in all subjects.
//Calculate Average percentage: Divide the total marks of total number of subjects to get the average percentage.
//Grade Calculation: Assign grades based on average percentage achieved.
//Display result: Show the total marks, average percentage, and the corresponding grade to the user.

import java.util.Scanner;

public class StudentGradeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Enter total number of subjects
        System.out.println("Enter total number of subjects: ");
        int numSubjects = sc.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("Enter marks for subject " + i + "(out of 100): ");
            int marks = sc.nextInt();

            //INPUT VALIDATION
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. please enter marks between 0 and 100.");
                System.out.println("Enter marks for subject " + i + "(out of 100): ");
                marks = sc.nextInt();
            }
            totalMarks += marks;
        }
        System.out.println("Student Result: ");
        System.out.println("Total marks obtained in all subject : " + totalMarks);

        //Calculate Average Percentage : Divide the 'total merks ' by the 'total number of subjects'
        // to get the average percentage.

        int AveragePercentage = totalMarks / numSubjects;
        System.out.println("Average Percentage: " + AveragePercentage);

        //Grade calculation : Assign grade based on the average percentage achieved.
        if (AveragePercentage >= 90) {
            System.out.println("Your grade: A+");
        } else if (AveragePercentage >= 80) {
            System.out.println("Your grade: B+");
        } else if (AveragePercentage >= 70) {
            System.out.println("Your grade: B");
        } else if (AveragePercentage >= 60) {
            System.out.println("Your grade: C+");
        } else if (AveragePercentage >= 50) {
            System.out.println("Your grade: C");
        } else if (AveragePercentage >= 40) {
            System.out.println("Your grade: D+");
        } else if (AveragePercentage >= 30) {
            System.out.println("Your grade: D");
        } else {
            System.out.println("Your grade si : E");
        }

        sc.close();
    }
}
