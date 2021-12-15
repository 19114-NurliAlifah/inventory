package uas_pbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    Connection koneksi;
    public void koneksi() throws SQLException{
        koneksi = DriverManager.getConnection("jdbc:mysql://localhost/projek","root","");
    }
}

