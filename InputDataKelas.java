package UAS_Semester_3;
import java.util.Scanner;


public class InputDataKelas {
    public static void InputData(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             INPUT DATA KELAS             ");
        System.out.println("==========================================");
        
        System.out.print("ID Kelas : ");
        String id_kelas = sc.nextLine();
        System.out.print("Tipe Kelas : ");
        String type_kelas = sc.nextLine();
        System.out.print("Harga Kelas : ");
        String hargakelas = sc.nextLine();
        System.out.print("ID Calon SSantri : ");
        String id_calonSantri = sc.nextLine();
        
        try{
            Database.DataKelas(id_kelas, type_kelas, hargakelas, id_calonSantri);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}