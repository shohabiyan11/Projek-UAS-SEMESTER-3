package UAS_Semester_3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateData {
    static final String jdbc = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/pesantren";
    static final String username = "root";
    static final String password = "";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    public static void update() throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("            UPDATE DATA CALON SANTRI            ");
        System.out.println("===============================================");
        
        System.out.print("Nama Calon Santri Sebelumnya : ");
        String nama_pel = sc.nextLine();
        System.out.print("Nama Calon Santri  : ");
        String nama_calonSantri = sc.nextLine();
        System.out.print("Alamat : ");
        String alamat = sc.nextLine();
        System.out.print("Jenis Kelamin [L/P] : ");
        String jenis_kelamin = sc.nextLine();
        System.out.print("ID Asatidz : ");
        String id_asatidz = sc.nextLine();
        
        try{
            Class.forName(jdbc);
            con = DriverManager.getConnection(url,username,password);
            String query = "update calonSantri set nama_calonSantri=?, alamat=?, jenis_kelamin=?, id_asatidz=? WHERE nama_calonSantri=?";
            
            ps = con.prepareStatement(query);
            
            ps.setString(1, nama_calonSantri);
            ps.setString(2, alamat);
            ps.setString(3, jenis_kelamin);
            ps.setString(4, id_asatidz);
            ps.setString(5, nama_pel);
            
            if (ps.executeUpdate() > 0) {
                System.out.println("Proses Update Berhasil!");
            }
            else{
                System.out.println("Proses Update Gagal");
            } 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }  
}