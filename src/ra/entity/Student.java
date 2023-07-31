package ra.entity;

import java.util.Scanner;

public class Student {
    //1. Fields-Attributes: Tính bao đóng - private
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private float htmlScore;
    private float cssScore;
    private float javascriptScore;
    private float avgScore;
    public static final float PASSMARK = 5.0F;

    //2. Constructors
    //2.1.Default
    public Student() {
    }

    //2.2. Khởi tạo tất cả thông tin sinh viên
    public Student(String studentId, String studentName, int age, boolean sex, float htmlScore, float cssScore, float javascriptScore, float avgScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.javascriptScore = javascriptScore;
        this.avgScore = avgScore;
    }

    //3. Methods
    //3.1. Getter/Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(float htmlScore) {
        this.htmlScore = htmlScore;
    }

    public float getCssScore() {
        return cssScore;
    }

    public void setCssScore(float cssScore) {
        this.cssScore = cssScore;
    }

    public float getJavascriptScore() {
        return javascriptScore;
    }

    public void setJavascriptScore(float javascriptScore) {
        this.javascriptScore = javascriptScore;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    //3.2. Phương thức nhập dữ liệu sinh viên
    public void inputData(Scanner scanner, Student[] arrStudent, int index) {
        System.out.println("Nhập vào mã sinh viên:");
        boolean checkStudentId = true;
        do {
            this.studentId = scanner.nextLine();
            if (index!=0) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrStudent[i].studentId.equals(this.studentId)) {
                       isExist = true;
                       break;
                    }
                }
                if (!isExist){
                    break;
                }else{
                    System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại");
                }
            }else{
                break;
            }
        }while(checkStudentId);

        System.out.println("Nhập vào tên sinh viên:");
        this.studentName = scanner.nextLine();
        System.out.println("Nhập vào tuổi sinh viên: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giới tính sinh viên: ");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập vào điểm HTML: ");
        this.htmlScore = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào điểm CSS: ");
        this.cssScore = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào điểm Javascript:");
        this.javascriptScore = Float.parseFloat(scanner.nextLine());
    }

    //3.3. Phương thức in thông tin sinh viên
    public void displayData() {
        String sexDisplay = this.sex ? "Nam" : "Nữ";
        System.out.printf("Mã sinh viên: %s - Tên sinh viên: %s - Tuổi: %d - Giới tính: %s\n", this.studentId, this.studentName, this.age, sexDisplay);
        System.out.printf("HTML: %.1f - CSS: %.1f - Javascript: %.1f - Avg Score: %.1f\n", this.htmlScore, this.cssScore, this.javascriptScore, this.avgScore);
    }
    //3.4. Phương thức tính điểm trung bình của học viên
    public void calAvgScore(){
        this.avgScore = (this.htmlScore+this.cssScore+this.javascriptScore)/3;
    }

    public static int add(int number1, int number2){
        return number1+number2;
    }
}
