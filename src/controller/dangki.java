package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dangki {
	public static boolean registerUser(String username, String password) {
	    // Kiểm tra xem email và password có rỗng hay không
	    if (username.trim().isEmpty() || password.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Email và mật khẩu không được bỏ trống", "Lỗi đăng ký", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Kiểm tra xem email đã tồn tại trong cơ sở dữ liệu hay chưa
	    if (isUsernameTaken(username)) {
	        JOptionPane.showMessageDialog(null, "Email đã tồn tại", "Lỗi đăng ký", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = connect.getConnection();
	        stmt = conn.prepareStatement(sql);

	        // Thiết lập giá trị cho các placeholders
	        stmt.setString(1, username);
	        stmt.setString(2, password);

	        // Thực hiện câu lệnh chèn dữ liệu
	        stmt.executeUpdate();

	        JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
	        return true; // Đăng ký thành công
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // Đăng ký thất bại
	    } finally {
	        // Đóng kết nối và statement
	        connect.closeConnection(conn);
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

    public static boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connect.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true; // Login successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnection(conn);
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // Login failed
    }

    private static boolean isUsernameTaken(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connect.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.closeConnection(conn);
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}