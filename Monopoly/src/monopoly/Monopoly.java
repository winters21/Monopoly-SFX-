/*
MONOPOLY ASSIGNMENT
By: Shawn Sun, Christopher Jordan, Gabriel Martell, and Bryce Batten
ICS3U
 */
package monopoly;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Monopoly {

    public static JButton number;
    public static JButton newNum;
    public static int num;
    public static JLabel[] player = new JLabel[4];
    public static Integer[] playerturn = new Integer[4];

    public static void main(String[] args) throws IOException {
        JFrame HUD = new JFrame();
        HUD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HUD.setSize(1800, 1050);
        HUD.setLayout(null);

        for (int playericon = 0; playericon < 4; playericon++) {
            int playericonInt = 0;
            do {
                String playericonInput = JOptionPane.showInputDialog("Choose your player piece player " + (playericon + 1));
                playericonInt = Integer.parseInt(playericonInput); // parsing
                if (playericonInt < 1 || playericonInt > 6) {
                    JOptionPane.showMessageDialog(null, "Please input a Valid Number"); //alerting of error, and loops
                }
            } while (playericonInt < 1 || playericonInt > 6);
            switch (playericonInt) {
                case 1:
                    player[playericon] = new JLabel(new ImageIcon("images/players/binderfix.png"));
                    break;
                case 2:
                    player[playericon] = new JLabel(new ImageIcon("images/players/mousefix.png"));
                    break;
                case 3:
                    player[playericon] = new JLabel(new ImageIcon("images/players/sunfix.png"));
                    break;
                case 4:
                    player[playericon] = new JLabel(new ImageIcon("images/players/phonefix.png"));
                    break;
                case 5:
                    player[playericon] = new JLabel(new ImageIcon("images/players/soccerfix.png"));
                    break;
                case 6:
                    player[playericon] = new JLabel(new ImageIcon("images/players/paintfix.png"));
                    break;
            }

            HUD.add(player[playericon]);
        }
        player[0].setBounds((855), (875), player[0].getPreferredSize().width, player[0].getPreferredSize().height);
        player[1].setBounds((895), (875), player[1].getPreferredSize().width, player[1].getPreferredSize().height);
        player[2].setBounds((855), (925), player[2].getPreferredSize().width, player[2].getPreferredSize().height);
        player[3].setBounds((895), (925), player[3].getPreferredSize().width, player[3].getPreferredSize().height);

        number = new JButton(num + "");
        number.setFont(new Font("Monospaced Plain", Font.PLAIN, 50));
        number.setBounds(1050, 10, 100, 100);
        HUD.add(number);

        newNum = new JButton("ROLL");
        newNum.setBounds(1200, 10, 100, 100);
        newNum.addActionListener(action);
        HUD.add(newNum);
        
        JLabel board = new JLabel();
        board.setIcon(new ImageIcon("images/monopolyboard.jpg"));
        board.setBounds((1), (1), board.getPreferredSize().width, board.getPreferredSize().height);
        HUD.add(board);

        HUD.setVisible(true);

    }

    private static ActionListener action = (new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            num = ((new Random()).nextInt((12 - 1) + 1) + 1);
            number.setText(num + "");
            player[0].setBounds((765), (875), player[0].getPreferredSize().width, player[0].getPreferredSize().height);
            player[1].setBounds((805), (875), player[1].getPreferredSize().width, player[1].getPreferredSize().height);
            player[2].setBounds((765), (925), player[2].getPreferredSize().width, player[2].getPreferredSize().height);
            player[3].setBounds((805), (925), player[3].getPreferredSize().width, player[3].getPreferredSize().height);

        }
    });
}
