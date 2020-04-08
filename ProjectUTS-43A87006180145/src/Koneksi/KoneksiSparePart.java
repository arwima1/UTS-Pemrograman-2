/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 *
 * @author Parzival
 */
public class KoneksiSparePart {
    String host ="127.0.0.1";
    String db ="bengkel";
    String username ="root";
    String password ="";
    String driver ="com.mysql.jdbc.Driver"; //driver database
    //jdbc:mysql://127.0.0.1/crud?user=root$password=
    String connect ="jdbc:mysql://" + host + "/" + db +"?user="+ username + "&password="+ password;
    Connection koneksi;
    Statement stmt;
    ResultSet rs;

    public KoneksiSparePart() {
    }
    
    public KoneksiSparePart(String namaHost, 
            String namaDatabase, 
            String username,
            String password){
        this.host = namaHost ;
        this.db = namaDatabase ;
        this.username = username;
        this.password = password;
    }
    
    public  boolean connect(){
        try {
            Class.forName(driver);
            koneksi = DriverManager.getConnection(connect);
            stmt = koneksi.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("koneksi berhasil");
            return  true;
        } catch (Exception e) {
            System.out.println("koneksi database gagal "+e.getMessage());
            return false;
        }
    }
    
     public boolean close(){
        try {
            koneksi.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
     public boolean executeQuery(String q){
        try {
            stmt.execute(q);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public ResultSet showQuery(String sql){
        try {
            rs =stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
}
