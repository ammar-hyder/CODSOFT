import java.util.Scanner;

public class TASK2 {
    public static void gradeAssigner(double percentage,int total){
        System.out.println("Total Marks: "+total);
        System.out.println("Percentage : "+percentage);

        if (percentage>=90){
            System.out.println("Grade : A+");
        }
        else if (percentage>=80){
            System.out.println("Grade : A");
        }
        else if (percentage>=70){
            System.out.println("Grade : B");
        }
        else if (percentage>=60){
            System.out.println("Grade : C");
        }
        else if (percentage>=50){
            System.out.println("Grade : D");
        }
        else {
            System.out.println("Grade : F");
        }

    }
    public static void GradeCalculator(){
        Scanner scanner = new Scanner(System.in);
        int numOfSubjects=0;
        int total=0;
        double percentage=0;

        System.out.println("Enter number of subjects");
        numOfSubjects = scanner.nextInt();
        for (int i =0;i<numOfSubjects;i++){
            System.out.println("Enter Marks for subject "+(i+1));
            int marks= scanner.nextInt();
            if (marks<=100 && marks>=0){
                total+=marks;
            }else{
                while (true) {
                    System.out.println("Incorrect Marks Enter again");
                    marks = scanner.nextInt();
                    if (marks<=100 && marks>=0) {
                        total += marks;
                        break;
                    }
                }
            }
        }
        percentage = (double) total /numOfSubjects;
        gradeAssigner(percentage,total);
    }
    public static void main(String[] args) {
        GradeCalculator();
    }
}
