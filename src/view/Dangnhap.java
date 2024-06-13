package view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import controller.dangki;
import javax.swing.ImageIcon;

public class Dangnhap {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Dangnhap window = new Dangnhap();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dangnhap() {
        initialize();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Đăng nhập");
		 URL urlIcon = Main.class.getResource("icon.png.png");
		 Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		 frame.setIconImage(img);
    }

    private void xuliDangNhap() {
        String enteredEmail = textField.getText();
        char[] enteredPasswordArray = passwordField.getPassword();
        String enteredPassword = new String(enteredPasswordArray);

        if (dangki.checkLogin(enteredEmail, enteredPassword)) {
            JOptionPane.showMessageDialog(frame, "Đăng nhập thành công!");
            new Main();
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Đăng nhập không thành công. Vui lòng kiểm tra lại tài khoản và mật khẩu.");
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 816, 569);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 402, 549);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Dangnhap.class.getResource("/view/dn.png")));
        lblNewLabel_3.setBounds(0, 0, 402, 538);
        panel.add(lblNewLabel_3);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(253, 245, 230));
        panel_1.setBounds(403, 0, 399, 539);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(new Color(0, 0, 139));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblNewLabel.setBounds(170, 102, 77, 39);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Email: ");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        lblNewLabel_1.setBounds(42, 150, 62, 24);
        panel_1.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(42, 184, 317, 39);
        panel_1.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Password: ");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        lblNewLabel_1_1.setBounds(42, 256, 95, 24);
        panel_1.add(lblNewLabel_1_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(42, 290, 317, 39);
        panel_1.add(passwordField);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xuliDangNhap();
            }
        });
        btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
        btnNewButton.setBackground(new Color(253, 245, 230));
        btnNewButton.setForeground(new Color(0, 0, 128));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
        btnNewButton.setBounds(42, 376, 317, 39);
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("Bạn chưa có tài khoản?");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(67, 445, 135, 13);
        panel_1.add(lblNewLabel_2);

        JButton btnNewButton_1 = new JButton("Đăng ký");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dangky();
                frame.dispose();
            }
        });
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setBounds(201, 442, 95, 21);
        panel_1.add(btnNewButton_1);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Nhớ mật khẩu");
        chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        chckbxNewCheckBox.setBackground(new Color(253, 245, 230));
        chckbxNewCheckBox.setBounds(44, 335, 93, 21);
        panel_1.add(chckbxNewCheckBox);
    }
}
