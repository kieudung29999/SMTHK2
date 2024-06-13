package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class TrangKT extends JFrame {
    private static final String JobMatcher = null;
	private JPanel cardPanel;
    private CardLayout cardLayout;
    private JButton nextButton, prevButton, finishButton;
    private int currentCard = 0;

    // Scores for MBTI types
    private int eScore = 0, iScore = 0, sScore = 0, nScore = 0, tScore = 0, fScore = 0, jScore = 0, pScore = 0;
    private JMenuBar menuBar;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_2;
	private static view.jobMatcher jobMatcher;

    public TrangKT() {
        setTitle("Trắc nghiệm MBTI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1149, 609);
        setLocationRelativeTo(null);
        URL urlIcon = Main.class.getResource("icon.png.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
        this.setIconImage(img);

        // Create CardLayout and JPanel containing the cards
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(0, 51, 1135, 492);

        // Create the cards
        JPanel[] cards = new JPanel[4];
        cards[0] = createCard1();
        cards[1] = createCard2();
        cards[2] = createCard3();
        cards[3] = createCard4();

        // Add cards to cardPanel
        for (int i = 0; i < cards.length; i++) {
            cardPanel.add(cards[i], "card" + (i + 1));
        }

        // Create navigation buttons
        nextButton = new JButton("Tiếp theo");
        prevButton = new JButton("Trước");
        finishButton = new JButton("Kết quả");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentCard < 3) {
                    currentCard++;
                    cardLayout.next(cardPanel);
                    updateButtons();
                }
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentCard > 0) {
                    currentCard--;
                    cardLayout.previous(cardPanel);
                    updateButtons();
                }
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showResults();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 541, 1135, 31);
        buttonPanel.setBackground(new Color(240, 255, 255));
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(finishButton);

        getContentPane().setLayout(null);
        getContentPane().add(cardPanel);
        getContentPane().add(buttonPanel);
        
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1135, 52);
        getContentPane().add(menuBar);
        
        mntmNewMenuItem_1 = new JMenuItem("Trang chủ");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Main();
        		dispose();
        	}
        });
        menuBar.add(mntmNewMenuItem_1);
        
        mntmNewMenuItem = new JMenuItem("Trắc nghiệm MBTI");
        menuBar.add(mntmNewMenuItem);
        
        mntmNewMenuItem_2 = new JMenuItem("\r\n");
        menuBar.add(mntmNewMenuItem_2);

        updateButtons();
    }

    private JPanel createCard1() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        panel.setLayout(null);
        JLabel lblWelcome = new JLabel("Chào mừng đến với Tư vấn Nghề nghiệp! ");
        lblWelcome.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        lblWelcome.setBounds(382, 0, 1085, 85);
        panel.add(lblWelcome);
       

        JLabel lblInstruction = new JLabel("Hãy trả lời các câu hỏi liên quan đến MBTI để xác định loại tính cách của bạn.");
        lblInstruction.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        lblInstruction.setBounds(170, 68, 1085, 85);
        panel.add(lblInstruction);

        JLabel lblGroup1 = new JLabel("I. Nhóm E/I:");
        lblGroup1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblGroup1.setBounds(10, 147, 113, 44);
        panel.add(lblGroup1);

        JSeparator separator = new JSeparator();
        separator.setBounds(-15, 147, 1150, 2);
        panel.add(separator);

        String[] questions = {
            "1. Bạn thích đi tiệc tùng (E) hay ở nhà đọc sách (I)?",
            "2. Sau tuần căng thẳng, bạn muốn đi chơi với bạn (E) hay nghỉ ngơi một mình (I)?",
            "3. Bạn thích làm việc nhóm (E) hay làm việc độc lập (I)?"
        };

        ButtonGroup[] buttonGroups = new ButtonGroup[questions.length];
        for (int i = 0; i < questions.length; i++) {
            buttonGroups[i] = new ButtonGroup();
            createQuestion(panel, questions[i], buttonGroups[i], 201 + i * 79, "E", "I");
        }

        return panel;
    }

    private JPanel createCard2() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        panel.setLayout(null);

        JLabel lblGroup2 = new JLabel("II. Nhóm S/N:");
        lblGroup2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblGroup2.setBounds(10, 147, 113, 44);
        panel.add(lblGroup2);

        JSeparator separator = new JSeparator();
        separator.setBounds(-15, 147, 1150, 2);
        panel.add(separator);

        JLabel lblWelcome = new JLabel("Chào mừng đến với Tư vấn Nghề nghiệp! ");
        lblWelcome.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        lblWelcome.setBounds(382, 0, 1085, 85);
        panel.add(lblWelcome);
       

        JLabel lblInstruction = new JLabel("Hãy trả lời các câu hỏi liên quan đến MBTI để xác định loại tính cách của bạn.");
        lblInstruction.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        lblInstruction.setBounds(170, 68, 1085, 85);
        panel.add(lblInstruction);

        String[] questions = {
            "4. Bạn chú ý đến chi tiết cụ thể (S) hay ý tưởng trừu tượng (N)?",
            "5. Bạn tin vào kinh nghiệm (S) hay trực giác (N) nhiều hơn?",
            "6. Khi đọc, bạn thích tài liệu thực tế (S) hay tưởng tượng (N)?"
        };

        ButtonGroup[] buttonGroups = new ButtonGroup[questions.length];
        for (int i = 0; i < questions.length; i++) {
            buttonGroups[i] = new ButtonGroup();
            createQuestion(panel, questions[i], buttonGroups[i], 201 + i * 79, "S", "N");
        }

        return panel;
    }

    private JPanel createCard3() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        panel.setLayout(null);

        JLabel lblGroup3 = new JLabel("III. Nhóm T/F:");
        lblGroup3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblGroup3.setBounds(10, 147, 113, 44);
        panel.add(lblGroup3);

        JSeparator separator = new JSeparator();
        separator.setBounds(-15, 147, 1150, 2);
        panel.add(separator);

        JLabel lblWelcome = new JLabel("Chào mừng đến với Tư vấn Nghề nghiệp! ");
        lblWelcome.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        lblWelcome.setBounds(382, 0, 1085, 85);
        panel.add(lblWelcome);
       

        JLabel lblInstruction = new JLabel("Hãy trả lời các câu hỏi liên quan đến MBTI để xác định loại tính cách của bạn.");
        lblInstruction.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        lblInstruction.setBounds(170, 68, 1085, 85);
        panel.add(lblInstruction);

        String[] questions = {
            "7. Khi quyết định, bạn dựa vào logic (T) hay cảm xúc cá nhân (F)?",
            "8. Bạn thấy mình khách quan (T) hay đồng cảm (F) hơn?",
            "9. Khi giải quyết xung đột, bạn tìm kiếm công bằng (T) hay hòa hợp (F)?"
        };

        ButtonGroup[] buttonGroups = new ButtonGroup[questions.length];
    
        for (int i = 0; i < questions.length; i++) {
            buttonGroups[i] = new ButtonGroup();
            createQuestion(panel, questions[i], buttonGroups[i], 201 + i * 79, "T", "F");
        }

        return panel;
    }

    private JPanel createCard4() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        panel.setLayout(null);

        JLabel lblGroup4 = new JLabel("IV. Nhóm J/P:");
        lblGroup4.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblGroup4.setBounds(10, 147, 113, 44);
        panel.add(lblGroup4);

        JSeparator separator = new JSeparator();
        separator.setBounds(-15, 147, 1150, 2);
        panel.add(separator);
        JLabel lblWelcome = new JLabel("Chào mừng đến với Tư vấn Nghề nghiệp! ");
        lblWelcome.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        lblWelcome.setBounds(382, 0, 1085, 85);
        panel.add(lblWelcome);
       

        JLabel lblInstruction = new JLabel("Hãy trả lời các câu hỏi liên quan đến MBTI để xác định loại tính cách của bạn.");
        lblInstruction.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        lblInstruction.setBounds(170, 68, 1085, 85);
        panel.add(lblInstruction);

        String[] questions = {
            "10. Bạn thích lập kế hoạch trước (J) hay quyết định khi đến lúc (P)?",
            "11. Bạn thích cuộc sống có tổ chức (J) hay linh hoạt (P)?",
            "12. Bạn thấy mình nguyên tắc (J) hay thích thích nghi (P)?"
        };

        ButtonGroup[] buttonGroups = new ButtonGroup[questions.length];
        for (int i = 0; i < questions.length; i++) {
            buttonGroups[i] = new ButtonGroup();
            createQuestion(panel, questions[i], buttonGroups[i], 201 + i * 79, "J", "P");
        }

        return panel;
    }

    private void createQuestion(JPanel panel, String question, ButtonGroup buttonGroup, int y, String option1Type, String option2Type) {
        JLabel lblQuestion = new JLabel(question);
        lblQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblQuestion.setBounds(200, y, 885, 44);
        lblQuestion.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblQuestion);

        JRadioButton btnOption1 = new JRadioButton(option1Type);
        btnOption1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        btnOption1.setBackground(new Color(224, 255, 255));
        btnOption1.setBounds(20, y + 45, 100, 30);
        btnOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateScore(option1Type);
            }
        });

        JRadioButton btnOption2 = new JRadioButton(option2Type);
        btnOption2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        btnOption2.setBackground(new Color(224, 255, 255));
        btnOption2.setBounds(130, y + 45, 100, 30);
        btnOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateScore(option2Type);
            }
        });

        buttonGroup.add(btnOption1);
        buttonGroup.add(btnOption2);

        panel.add(btnOption1);
        panel.add(btnOption2);
    }

    private void updateScore(String type) {
        switch (type) {
            case "E":
                eScore++;
                break;
            case "I":
                iScore++;
                break;
            case "S":
                sScore++;
                break;
            case "N":
                nScore++;
                break;
            case "T":
                tScore++;
                break;
            case "F":
                fScore++;
                break;
            case "J":
                jScore++;
                break;
            case "P":
                pScore++;
                break;
        }
    }

    private void updateButtons() {
        prevButton.setEnabled(currentCard > 0);
        nextButton.setEnabled(currentCard < 3);
        finishButton.setEnabled(currentCard == 3);
    }

    private void showResults() {
        String result = "";
        result += eScore > iScore ? "E" : "I";
        result += sScore > nScore ? "S" : "N";
        result += tScore > fScore ? "T" : "F";
        result += jScore > pScore ? "J" : "P";

        jobMatcher jobMatcher = new jobMatcher(); // Khởi tạo đối tượng jobMatcher

        jobMatcher.MBTIProfile profile = jobMatcher.getProfileForMBTI(result);

        // Hiển thị thông tin kết quả trong cửa sổ thông báo
        JOptionPane.showMessageDialog(this, profile.toString(), "Kết quả MBTI", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
            	 jobMatcher = new view.jobMatcher();
                TrangKT frame = new TrangKT();
           

                frame.setVisible(true);
            }
        });
    }
}

