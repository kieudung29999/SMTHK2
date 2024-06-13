package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBoxMenuItem;

public class Home {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Home window = new Home();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Home() {
        initialize();
//        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("TƯ VẤN HƯỚNG NGHỀ HƯỚNG NGHIỆP");
		 URL urlIcon = Main.class.getResource("icon.png.png");
		 Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		 frame.setIconImage(img);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1183, 682);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        frame.getContentPane().add(panel, "name_500735677550500");
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setToolTipText("");
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 0, 1169, 645);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(-6, 54, 1169, 635);
        lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/view/homain.png")));
        panel_1.add(lblNewLabel_2);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(-6, -15, 1171, 73);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(6, 15, 1159, 52);
        panel_2.add(menuBar);
        
        JMenu mnNewMenu = new JMenu("Trang chủ");
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Đăng nhập");
        mntmNewMenuItem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage( Home.class.getResource("Pictogrammers-Material-Light-Login.16.png"))));
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Dangnhap();
        		frame.dispose();
        	}
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Đăng ký");
        mntmNewMenuItem_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage( Home.class.getResource("add.png"))));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Dangky();
        		frame.dispose();
        	}
        });
        mnNewMenu.add(mntmNewMenuItem_1);
    }
}
