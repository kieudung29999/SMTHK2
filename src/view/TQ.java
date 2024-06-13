package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import controller.HNHNconnect;

public class TQ {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    TQ window = new TQ();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TQ() {
        initialize();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tổng quan về các ngành học");
        URL urlIcon = Main.class.getResource("icon.png.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
        frame.setIconImage(img);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(230, 230, 250));
        frame.setBounds(100, 100, 1149, 632);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1135, 55);
        frame.getContentPane().add(menuBar);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Trang chủ");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Main();
                frame.dispose();
            }
        });
        menuBar.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Tổng quan");
        menuBar.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem = new JMenuItem("");
        menuBar.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("\r\n");
        menuBar.add(mntmNewMenuItem_3);

        JLabel lblNewLabel = new JLabel("Ngành:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setBounds(290, 65, 84, 37);
        frame.getContentPane().add(lblNewLabel);

        // Define the options for the ngành combo box
        String[] nganhOptions = {"Tất cả","Y tế", "Marketing", "Công nghệ thông tin", "Ngôn ngữ Anh", "Quản trị kinh doanh","Kỹ thuật ô tô – cơ khí","Xây dựng","Công nghệ thực phẩm","Quản trị nhà hàng, khách sạn","Tâm lý xã hội","Quản lý nhân sự","Sư phạm","Thương mại điện tử","An ninh mạng","Trí tuệ nhân tạo","Phân tích dữ liệu"};

        JComboBox<String> comboBox = new JComboBox<>(nganhOptions);
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        comboBox.setBounds(401, 65, 277, 37);
        frame.getContentPane().add(comboBox);

        JButton btnNewButton = new JButton("Tìm kiếm");
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnNewButton.setBounds(714, 65, 110, 37);
        frame.getContentPane().add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 123, 1115, 462);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
            },
            new String[] {
                "Ng\u00E0nh", "Kh\u1ED1i x\u00E9t tuy\u1EC3n", "C\u01A1 h\u1ED9i vi\u1EC7c l\u00E0m"
            }
        ));
        scrollPane.setViewportView(table);

        // Add action listener to the button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nganh = (String) comboBox.getSelectedItem();
                HNHNconnect connection = new HNHNconnect();
                DefaultTableModel model = connection.fetchResults(nganh);
                table.setModel(model);
            }
        });
    }
}
