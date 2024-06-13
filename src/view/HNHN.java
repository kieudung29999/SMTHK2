package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import controller.HNHNconnect;

public class HNHN {

    public JFrame frame;
    private DefaultTableModel table;
    private JTable dmhoc;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    HNHN window = new HNHN();
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
    public HNHN() {
        initialize();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1146, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("TRA CỨU THÔNG TIN CÁC TRƯỜNG");
		 URL urlIcon = Main.class.getResource("icon.png.png");
		 Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		 frame.setIconImage(img);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1132, 53);
        frame.getContentPane().add(menuBar);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Trang chủ");
        mntmNewMenuItem_1.addActionListener(e -> {
            new Main();
            frame.dispose();
        });
        menuBar.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem = new JMenuItem("Hướng nghề hướng nghiệp");
        menuBar.add(mntmNewMenuItem);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 255, 240));
        panel.setBounds(0, 41, 1132, 562);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Lĩnh vực yêu thích: ");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(39, 21, 215, 36);
        panel.add(lblNewLabel);

        JLabel lblKhiXtTuyn = new JLabel("Khối xét tuyển:");
        lblKhiXtTuyn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblKhiXtTuyn.setBounds(615, 21, 215, 36);
        panel.add(lblKhiXtTuyn);

        JLabel lblKhuVc = new JLabel("Khu vực:");
        lblKhuVc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblKhuVc.setBounds(39, 67, 106, 36);
        panel.add(lblKhuVc);

        // Use JComboBox for selections
        String[] linhVucOptions = {"Lĩnh Vực Kinh Doanh và Quản Lí",  "Y tế", "Khoa học xã hội", "Ngoại giao","Lĩnh Vực Kỹ Thuật và Công Nghệ","Lĩnh Vực Sáng Tạo và Thiết Kế"};
        JComboBox<String> linhVucComboBox = new JComboBox<>(linhVucOptions);
        linhVucComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        linhVucComboBox.setBounds(287, 27, 249, 30);
        panel.add(linhVucComboBox);

        String[] khoiXetTuyenOptions = {"Tất cả", "A01(Toán-Lí-Anh)", "C00(Văn- Sử- Địa)", "D01(Toán-Văn- Anh)", "D04(Toán- Văn- Tiếng Trung)","D78(Văn-Anh-KHXH)","D72(Văn-KHTN-Anh)","R22(Toán-Văn-Chứng chỉ tiếng Anh)","R25(Văn-KHTN-Chứng chỉ tiếng Anh)","D07(Toán-Hóa-Anh)","D15(Văn-Địa-Anh)","C14(Toán-Văn-GDCD)","D66(Văn-GDCD-Anh)","A00(Toán-Lí-Hóa)","H02(Toán-Vẽ hình hoạt-Trang trí màu)","H00(Văn-Vẽ năng khiếu 1-Vẽ năng khiếu 2)","V00(Toán-Lí-Vẽ)","V01(Toán-Văn-Vẽ)","V02(Toán-Anh-Vẽ)","S00(Văn-Năng khiếu điện ảnh 1-Năng khiếu điện ảnh 2)","N00(Văn- Năng khiếu âm nhạc 1- Năng khiếu âm nhạc 2)","H03(Toán-KHTN-Vẽ)","B00(Toán-Hóa-Sinh)",};
        JComboBox<String> khoiXetTuyenComboBox = new JComboBox<>(khoiXetTuyenOptions);
        khoiXetTuyenComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        khoiXetTuyenComboBox.setBounds(799, 27, 187, 30);
        panel.add(khoiXetTuyenComboBox);

        String[] khuVucOptions = {"Bắc", "Trung", "Nam"};
        JComboBox<String> khuVucComboBox = new JComboBox<>(khuVucOptions);
        khuVucComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        khuVucComboBox.setBounds(287, 73, 249, 30);
        panel.add(khuVucComboBox);

        table = new DefaultTableModel();
        table.addColumn("Ngành");
        table.addColumn("Khu vực");
        table.addColumn("Trường");
        table.addColumn("Học phí");
        table.addColumn("Điểm xét tuyển");
        table.addColumn("Khối xét tuyển");

        dmhoc = new JTable(table);
        dmhoc.setBackground(new Color(240, 255, 255));
        dmhoc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JScrollPane scrmon = new JScrollPane(dmhoc);
        scrmon.setBounds(25, 119, 1084, 416);
        panel.add(scrmon);

        JButton btnNewButton = new JButton("Xem kết quả");
        btnNewButton.addActionListener(e -> {
            String linhvucyeuthich = (String) linhVucComboBox.getSelectedItem();
            String khoixettuyen = (String) khoiXetTuyenComboBox.getSelectedItem();
            String khuvuc = (String) khuVucComboBox.getSelectedItem();

            HNHNconnect connector = new HNHNconnect();
            DefaultTableModel model = connector.fetchResults(linhvucyeuthich, khoixettuyen, khuvuc);
            dmhoc.setModel(model);

            // Debug statement
            System.out.println("Table updated with data.");
        });
        btnNewButton.setBounds(799, 67, 187, 42);
        panel.add(btnNewButton);
    }
}
