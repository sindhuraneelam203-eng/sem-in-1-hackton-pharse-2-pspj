import java.util.Scanner;
public class Student{
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int coursecredits;

    public Student(String studentName, int rollNumber, double marks, String courseName, int coursecredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.coursecredits = coursecredits;
    }
    public String getStudentName() {
        return studentName;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public double getMarks() {
        return marks;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getCourseCredits() {
        return coursecredits;
    }
    public int calculateFee(){
        return getCourseCredits() * 1500;
    }
    public boolean checkEligibility(){
        return getMarks() >= 50;
    }
    public double calculateScholarship(){
        if(getMarks() >= 85){
            return 0.20 * calculateFee();
        } else if(getMarks() >= 70 && getMarks() < 85){
            return 0.10 * calculateFee();
        }  else {
            return 0;
        }
    }
    public double calculateFinalFee(){
        return calculateFee() - calculateScholarship();
    }
    public void displayDetails(){
        boolean eligibility= checkEligibility();
        double scholarship= calculateScholarship();
        double finalFee= calculateFinalFee();
        double totalFee= calculateFee();
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Roll Number: " + getRollNumber());
        System.out.println("Marks: " + getMarks());
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Course Credits: " + getCourseCredits());
        System.out.println("Eligibility for Scholarship: " + eligibility);
        System.out.println("Total Fee: " + totalFee);
        System.out.println("Scholarship Amount: " + scholarship);
        System.out.println("Final Fee after Scholarship: " + finalFee);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        scanner.nextLine(); 

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

        Student student = new Student(name, rollNumber, marks, courseName, courseCredits);
        if (student.checkEligibility()) {
            System.out.println("The student is eligible for scholarship.");
        } else {
            System.out.println("The student is not eligible for scholarship.");
        }
        student.displayDetails();
    }
}SINDHU