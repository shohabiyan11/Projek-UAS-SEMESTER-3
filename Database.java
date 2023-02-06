package UAS_Semester_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {
    static final String jdbc = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/pesantren";
    static final String username = "root";
    static final String password = "";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    static Statement state;
    
    public static String getPassword(String id_asatidz) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "SELECT pw FROM asatidz WHERE id_asatidz = (?)";
        ps = con.prepareStatement(query);
        ps.setString(1, id_asatidz);
        rs = ps.executeQuery();
        
        if(!rs.next()){
            return null;
        }
        else{
            return rs.getString(1).toString();
        }
    }
    
    public static void insertAkun(String id_asatidz, String nama_asatidz, String jenis_kelamin, String alamat, String pw) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO asatidz VALUES (?,?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_asatidz);
        ps.setString(2, nama_asatidz);
        ps.setString(3, jenis_kelamin);
        ps.setString(4, alamat);
        ps.setString(5, pw);
        
        if(ps.executeUpdate() > 0){
            System.out.println();
            System.out.println("Akun berhasil didaftarkan");
        }
        else{
            System.out.println("Akun gagal didaftarkan");
        }
    }
    
    public static void DataCalonSantri(String id_calonSantri, String nama_calonSantri, String alamat, String jenis_kelamin, String id_asatidz) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO calon santri VALUES (?,?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_calonSantri);
        ps.setString(2, nama_calonSantri);
        ps.setString(3, alamat);
        ps.setString(4, jenis_kelamin);
        ps.setString(5, id_asatidz);
        
        if(ps.executeUpdate() > 0){
            InputDataKelas.InputData();
        }
        else{
            System.out.println("Data Gagal Diinput");
        }
    }
    
    public static void DataKelas(String id_kelas, String type_kelas, String hargakelas, String id_calonSantri) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO kelas VALUES (?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_kelas);
        ps.setString(2, type_kelas);
        ps.setString(3, hargakelas);
        ps.setString(4, id_calonSantri);
        
        if(ps.executeUpdate() > 0){
            System.out.println();
            System.out.println("Data Berhasil Diinput");
        }
        else{
            System.out.println("Data Gagal Diinput");
        }
    }
    
    public static void ShowDataCalonSantri() throws Exception{
        int no = 0;
        try{
            Class.forName(jdbc);
            con = DriverManager.getConnection(url, username, password);
            state = con.createStatement();
            String query = "SELECT calonSantri.*, kelas.* FROM calonSantri INNER JOIN kelas ON calonSantri.id_calonSantri=kelas.id_calonSantri";
            rs = state.executeQuery(query);
            
            while(rs.next()){
                no++;
                System.out.println("No."+ no);
                System.out.println("ID Calon Santri    : " + rs.getString("id_calonSantri"));
                System.out.println("Nama Calon Santri  : " + rs.getString("nama_calonSantri"));
                System.out.println("Alamat             : " + rs.getString("alamat"));
                System.out.println("Jenis Kelamin      : " + rs.getString("jenis_kelamin"));
                System.out.println("ID Asatidz         : " + rs.getString("id_asatidz"));
                System.out.println("ID Kelas           : " + rs.getString("id_kelas"));
                System.out.println("Tipe Kelas         : " + rs.getString("type_kelas"));
                System.out.println("Harga Kelas        : " + rs.getString("hargakelas"));
                System.out.println("-------------------------------------------------------");
            } 
        }
        catch(Exception ex){
            ex.printStackTrace();
        } 
    }
}