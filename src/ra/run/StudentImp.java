package ra.run;

import ra.entity.Student;

import java.util.Scanner;

public class StudentImp{

    public static void main(String[] args) {
        Student[] arrStudents = new Student[100];
        Scanner scanner = new Scanner(System.in);
        //Khởi tạo biến index của mảng arrStudent để quản lý xem đang có bao nhiêu sinh viên
        int index = 0;
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Nhập thông tin n sinh viên");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Hiển thị thông tin các sinh viên");
            System.out.println("4. Sắp xếp sinh viên theo điểm trung bình giảm dần");
            System.out.println("5. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số sinh viên cần nhập dữ liệu: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    //Nhập thông tin cho n sinh viên
                    for (int i = 0; i < n; i++) {
                        //Khởi tạo đối tượng phần tử thứ index cần nhập thông tin
                        //null
                        arrStudents[index] = new Student();
                        //Nhập thông tin cho sinh viên student
                        arrStudents[index].inputData(scanner,arrStudents,index);
                        index++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < index; i++) {
                        arrStudents[i].calAvgScore();
                    }
                    System.out.println("Đã tính xong điểm trung bình cho tất cả sinh viên");
                    break;
                case 3:
                    //Hiển thị thông tin sinh viên
                    System.out.println("THÔNG TIN CÁC SINH VIÊN:");
                    for (int i = 0; i < index; i++) {
                        arrStudents[i].displayData();
                    }
                    break;
                case 4:
                    //Sử dụng thuật toán selection sort để sắp xếp
                    for (int i = 0; i < index-1; i++) {
                        for (int j = i+1; j < index; j++) {
                            if (arrStudents[i].getAvgScore()<arrStudents[j].getAvgScore()){
                                //Đổi chỗ 2 phần tử
                                Student studentTemp = arrStudents[i];
                                arrStudents[i] =arrStudents[j];
                                arrStudents[j] = studentTemp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong sinh viên theo điểm trung bình giảm dần");
                    break;
                case 5:
                    System.out.println("Nhập vào tên sinh viên cần tìm: ");
                    String stNameSearch = scanner.nextLine();
                    boolean isExist = false;
                    System.out.println("Sinh viên tìm thấy: ");
                    for (int i = 0; i < index; i++) {
                        if (arrStudents[i].getStudentName().toLowerCase().contains(stNameSearch.toLowerCase())){
                            arrStudents[i].displayData();
                            isExist = true;
                        }
                    }
                    if (!isExist){
                        System.out.println("Không có sinh viên thỏa mãn điều kiện tìm kiếm");
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-6");
            }
        } while (true);
    }
}
