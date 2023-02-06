 package UAS_Semester_3;

import java.util.Scanner;

public class DaftarAsatidz {
    public static void DaftarAsatidz(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             DAFTAR AKUN USTADZ             ");
        System.out.println("=============================================");
        
        System.out.print("Username : ");
        String id_asatidz = sc.nextLine();
        System.out.print("Password : ");
        String pw = sc.nextLine();
        System.out.print("Nama Ustadz/Ustadzah : ");
        String nama_asatidz = sc.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String jenis_kelamin = sc.nextLine();
        System.out.print("Alamat : ");
        String alamat = sc.nextLine();
        
        try{
            Database.insertAkun(id_asatidz, nama_asatidz, jenis_kelamin, alamat, pw);
            System.out.println("Tolong ingat username dan password Anda");
            System.out.println("Username dan Password" + id_asatidz + pw);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}