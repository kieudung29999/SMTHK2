package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main window = new Main();
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
	public Main() {
		initialize();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 1146, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Tư vấn ngành-nghề học");
		 URL urlIcon = Main.class.getResource("icon.png.png");
		 Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		 frame.setIconImage(img);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 0, 139));
		panel_3.setBackground(new Color(173, 216, 230));
		panel_3.setBounds(10, 10, 1112, 233);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(-622, -15, 988, 274);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setBounds(6, 15, 976, 253);
		panel_6.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(Main.class.getResource("/view/manin.png")));
		
		JLabel lblNewLabel = new JLabel("Khám Phá Ngành Học Tương Lai ");
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setBounds(548, 72, 724, 34);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 26));
		
		JLabel lblHngDnChn = new JLabel("Hướng Dẫn Chọn Lựa Con Đường Sự Nghiệp Phù Hợp!");
		lblHngDnChn.setForeground(new Color(0, 0, 128));
		lblHngDnChn.setFont(new Font("Times New Roman", Font.ITALIC, 26));
		lblHngDnChn.setBackground(new Color(148, 0, 211));
		lblHngDnChn.setBounds(442, 127, 724, 34);
		panel_3.add(lblHngDnChn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(10, 211, 1112, 363);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(36, 76, 288, 277);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 10, 268, 257);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("TRẮC NGHIỆM MBTI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 TrangKT trangKT = new TrangKT();
			        trangKT.setVisible(true); // Hiển thị frame mới
			        frame.dispose(); // Đóng frame hiện tại
			}
		});
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setFont(new Font("Serif", Font.ITALIC, 16));
		btnNewButton.setBounds(-13, -12, 298, 72);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/view/TEST.jpg")));
		lblNewLabel_1.setBounds(-58, 37, 343, 257);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 0, 128));
		panel_1_2.setBounds(788, 76, 288, 277);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 10, 268, 257);
		panel_1_2.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnTngQuanV = new JButton("TỔNG QUAN VỀ NGÀNH HỌC\r\n\r\n");
		btnTngQuanV.setBounds(0, 0, 268, 54);
		panel_5.add(btnTngQuanV);
		btnTngQuanV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TQ();
				frame.dispose();
			}
		});
		btnTngQuanV.setFont(new Font("Serif", Font.ITALIC, 16));
		btnTngQuanV.setBackground(new Color(255, 228, 225));
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(Main.class.getResource("/view/bannerTQ.png")));
		lblNewLabel_1_2.setBounds(-63, 23, 443, 257);
		panel_5.add(lblNewLabel_1_2);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(0, 0, 128));
		panel_1_2_1.setBounds(412, 76, 288, 277);
		panel.add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 10, 268, 257);
		panel_1_2_1.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnHngNghHng = new JButton("TRA CỨU THÔNG TIN TRƯỜNG");
		btnHngNghHng.setBounds(0, 0, 268, 60);
		panel_4.add(btnHngNghHng);
		btnHngNghHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HNHN();
				frame.dispose();
			}
		});
		btnHngNghHng.setFont(new Font("Serif", Font.ITALIC, 16));
		btnHngNghHng.setBackground(new Color(255, 228, 225));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Main.class.getResource("/view/hong.jpg")));
		lblNewLabel_1_1.setBounds(-151, 0, 456, 313);
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 10, 1112, 233);
		frame.getContentPane().add(lblNewLabel_2);
	}

	private void setIconImage(Image img) {
		// TODO Auto-generated method stub
		
	}
}
