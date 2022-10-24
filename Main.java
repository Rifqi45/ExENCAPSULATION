package ENCAPSULATION;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Teacher> daftarDosen = new ArrayList<>();
        ArrayList<Student> daftarMahasiswa = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan Total Data Dosen : ");
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Masukan Nama Dosen : ");
            String nama = input.nextLine();
            System.out.print("Masukan Alamat Dosen : ");
            String alamat = input.nextLine();
            System.out.print("Masukan Total Matkul :");
            int m = Integer.parseInt(input.nextLine());
            Teacher teacher = new Teacher(nama, alamat);
            for (int j = 0; j < m; j++) {
                System.out.print("Nama Matkul :");
                String matkul = input.nextLine();
                teacher.addCourse(matkul);
            }
            daftarDosen.add(teacher);
        }

        System.out.print("Masukan Total Data Mahasiswa : ");
        n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Masukan Nama Mahasiswa : ");
            String nama = input.nextLine();
            System.out.print("Masukan Alamat Mahasiswa : ");
            String alamat = input.nextLine();
            System.out.print("Masukan Total Input Nilai :");
            int m = Integer.parseInt(input.nextLine());
            Student student = new Student(nama, alamat);
            for (int j = 0; j < m; j++) {
                boolean benar = false;
                String matkul = " ";
                do {
                    System.out.print("Nama Matkul :");
                    matkul = input.nextLine();
                    String fm = matkul;
                    if (daftarDosen.stream().flatMap(e -> e.getCourses().stream()).anyMatch(e -> e.equals(fm))) {
                        benar = true;
                    } else {
                        System.out.println("Matkul Tidak Ada");
                    }
                } while (!benar);
                System.out.print("Masukan Nilai :");
                int grade = Integer.parseInt(input.nextLine());
                student.addCourseGrade(matkul, grade);
            }

            daftarMahasiswa.add(student);
        }
        daftarMahasiswa.sort((a, b) -> (int) b.getAverageGrade() - (int) a.getAverageGrade());
        System.out.println("Daftar Nilai Mahasiswa Tertinggi");
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            Student student = daftarMahasiswa.get(i);
            System.out.println(student.getName() + " : " + student.getAverageGrade());
        }
    }
}
