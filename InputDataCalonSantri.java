package UAS_Semester_3;
import java.util.Scanner;


public class InputDataCalonSantri {
    public static void InputData(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("              INPUT DATA SANTRI              ");
        System.out.println("=============================================");
        
        System.out.print("ID Calon Santri : ");
        String id_calonSantri = sc.nextLine();
        System.out.print("Nama Calon Santri : ");
        String nama_calonSantri = sc.nextLine();
        System.out.print("Alamat : ");
        String alamat = sc.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String jenis_kelamin = sc.nextLine();
        System.out.print("ID Asatidz : ");
        String id_asatidz = sc.nextLine();
        
        try{
            Database.DataCalonSantri(id_calonSantri, nama_calonSantri, alamat, jenis_kelamin, id_asatidz);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}