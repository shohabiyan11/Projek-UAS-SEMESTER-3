package UAS_Semester_3;
import java.util.Scanner;

public class Menu2 {
    static void menuForm() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             MENU UTAMA             ");
        System.out.println("=====================================");
        System.out.println("1. Input Data Calon Santri");
        System.out.println("2. Melihat Data Calon Santri");
        System.out.println("3. Update Data Calon Santri");
        System.out.println("4. Hapus Data Calon Santri");
        System.out.println("5. Keluar");
        System.out.println();
            
        System.out.print("Pilihan [1/2/3/4/5] = ");
        int pilih = sc.nextInt();
            
        if(pilih == 1){
            InputDataCalonSantri.InputData();
        }
        else if(pilih == 2){
            Database.ShowDataCalonSantri();
        }
        else if(pilih == 3){
            UpdateData.update();
        }
        else if(pilih == 4){
            DeleteData.Delete();
        }
        else if(pilih == 5){
            System.exit(0);
        }
        else{
            System.out.println("Silahkan masukkan akun yang valid");
            System.out.println();
            menuForm();
        }
        
        try{
            menuForm();
        }
        catch(Exception e){
            System.out.println("Ada Sebuah Kesalahan");
            System.out.println("Error Message : " +e.getMessage());
            e.printStackTrace();
        }
    }
}