package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class HNHNconnect {

    public DefaultTableModel fetchResults(String linhvucyeuthich, String khoixettuyen, String khuvuc) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Ngành", "Khu vực", "Trường", "Học phí", "Điểm xét tuyển", "Khối xét tuyển"}, 0);

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Failed to establish a database connection.");
                throw new SQLException("Failed to establish a database connection.");
            }

            String query;
            PreparedStatement pstmt;

            if ("Tất cả".equals(khoixettuyen)) {
                query = "SELECT nganh, khuvuc, truong, hocphi, tongdiem, khoixettuyen FROM hehthong.hnhn WHERE linhvucyeuthich = ? AND khuvuc = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, linhvucyeuthich);
                pstmt.setString(2, khuvuc);
            } else {
                query = "SELECT nganh, khuvuc, truong, hocphi, tongdiem, khoixettuyen FROM hehthong.hnhn WHERE linhvucyeuthich = ? AND khoixettuyen = ? AND khuvuc = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, linhvucyeuthich);
                pstmt.setString(2, khoixettuyen);
                pstmt.setString(3, khuvuc);
            }

            ResultSet rs = pstmt.executeQuery();

            // Debug statement
            System.out.println("Query executed: " + query);

            while (rs.next()) {
                String nganh = rs.getString("nganh");
                String khuVuc = rs.getString("khuvuc");
                String truong = rs.getString("truong");
                String hocPhi = rs.getString("hocphi");
                String diemxt = rs.getString("tongdiem");
                String khoixt = rs.getString("khoixettuyen");
                model.addRow(new Object[]{nganh, khuVuc, truong, hocPhi, diemxt, khoixt});

                // Debug statement
//                System.out.println("Data fetched: " + nganh + ", " + khuVuc + ", " + truong + ", " + hocPhi + ", " + diemxt + ", " + khoixt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    public DefaultTableModel fetchResults(String nganh) {
        DefaultTableModel model = new DefaultTableModel(new String[]{ "Ngành", "Khối xét tuyển", "Cơ hội việc làm"}, 0);

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                throw new SQLException("Failed to establish a database connection.");
            }

            String query;
            PreparedStatement pstmt;

            if ("Tất cả".equals(nganh)) {
                query = "SELECT nganh, khoixt, cohoivieclam FROM hehthong.TQ";
                pstmt = conn.prepareStatement(query);
            } else {
                query = "SELECT nganh, khoixt, cohoivieclam FROM hehthong.TQ WHERE nganh = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, nganh);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nganhStr = rs.getString("nganh");
                String khoiXetTuyen = rs.getString("khoixt");
                String coHoiViecLam = rs.getString("cohoivieclam");
                model.addRow(new Object[] { nganhStr, khoiXetTuyen, coHoiViecLam});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
}
