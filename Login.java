package UAS_Semester_3;
import java.util.Scanner;

public class Login {
    public static void Login(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Username : ");
        String id_asatidz = sc.nextLine();
        
        System.out.print("Password : ");
        String pw = sc.nextLine();
        System.out.println();
        
        try{
            if(pw.equals(Database.getPassword(id_asatidz))){
                Menu2.menuForm();
            }
            else{
                System.out.println("Username Atau Password Salah");
                System.out.println("");
                Login();
            }
        }
        catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}