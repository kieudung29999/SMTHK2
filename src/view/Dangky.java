package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import controller.dangki;


public class Dangky {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Dangky window = new Dangky();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dangky() {
        initialize();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Đăng ký");
        URL urlIcon = Main.class.getResource("icon.png.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
        frame.setIconImage(img);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 466, 657);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 139));
        panel.setForeground(new Color(178, 34, 34));
        panel.setBounds(0, 0, 452, 629);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("ĐĂNG KÝ");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(172, 81, 116, 57);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Email:");
        lblNewLabel_1.setFont(new Font("Sylfaen", Font.ITALIC, 17));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(62, 153, 84, 23);
        panel.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(62, 186, 338, 39);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Password:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Sylfaen", Font.ITALIC, 17));
        lblNewLabel_1_1.setBounds(62, 255, 84, 23);
        panel.add(lblNewLabel_1_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(62, 288, 338, 39);
        panel.add(passwordField);

        JLabel lblNewLabel_1_1_1 = new JLabel("Nhập lại Password:");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        lblNewLabel_1_1_1.setBounds(62, 350, 160, 23);
        panel.add(lblNewLabel_1_1_1);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(62, 383, 338, 39);
        panel.add(passwordField_1);

        JButton btnNewButton = new JButton("Đăng ký");
        btnNewButton.setBackground(new Color(178, 34, 34));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton.setBounds(62, 459, 161, 39);
        panel.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(passwordField_1.getPassword());

                // Kiểm tra xem mật khẩu và mật khẩu xác nhận có khớp nhau hay không
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Mật khẩu và mật khẩu xác nhận không khớp nhau", "Lỗi đăng ký", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Gọi phương thức registerUser để đăng ký người dùng mới
                boolean isRegistered = dangki.registerUser(username, password);

                // Nếu đăng ký thành công, chuyển sang màn hình đăng nhập
                if (isRegistered) {
                    new Dangnhap();
                    frame.dispose();
                }
            }
        });
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, "Bạn có muốn thoát khỏi chương trình?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        JButton btnDangNhap = new JButton("Đăng nhập");
        btnDangNhap.setBackground(new Color(178, 34, 34));
        btnDangNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dangnhap();
                frame.dispose();
            }
        });
        btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnDangNhap.setBounds(233, 459, 161, 39);
        panel.add(btnDangNhap);
    }

   
    protected void dispose() {
        // TODO Auto-generated method stub
    }
}