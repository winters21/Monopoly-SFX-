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

    public static int player_num;
    public static JButton number;
    public static JButton newNum;
    public static int num;
    public static JLabel[] player = new JLabel[4];
    public static int playerturn = 0;
    public static int[] space = new int[4];
    public static JLabel turn = new JLabel();
    public static Integer[] money = new Integer[4];
    public static JLabel[] moneyLabel = new JLabel[4];
    public static String[] name = new String[4];

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

        turn.setText("Player " + (playerturn + 1) + "'s turn");
        turn.setFont(new Font("Monospaced Plain", Font.PLAIN, 50));
        turn.setBounds(1350, 10, 1000, 100);
        HUD.add(turn);

        JLabel board = new JLabel();
        board.setIcon(new ImageIcon("images/monopolyboard.jpg"));
        board.setBounds((1), (1), board.getPreferredSize().width, board.getPreferredSize().height);
        HUD.add(board);

        HUD.setVisible(true);

        while (true) {
            String[] options = {"Roll", "def", "ghi", "quit"};
            int x = JOptionPane.showOptionDialog(null, "What would you like to do?",
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (x) {
                case 0:
                    moverMethod();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                //turn.setText( name[playerturn] + "'s turn");
            }
        }
    }
        public static void moverMethod(){
        //  num = ((new Random()).nextInt((12 - 1) + 1) + 1);
        // num = 1;
        String numInput = JOptionPane.showInputDialog("input num");
        space[playerturn] = Integer.parseInt(numInput); // parsing
        //number.setText(num + "");
        //JOptionPane.showMessageDialog(null, "You rolled " + num);
        //space[playerturn] += num;
        do {
            if (space[playerturn] >= 40) {
                space[playerturn] -= 40;
            }
        } while (space[playerturn] >= 40);
        spacemaker();
        //playerturn++;
        // if (playerturn == 4) {
        //playerturn = 0;
        //  }
    }

    public static void spacemaker() {
        switch (playerturn) {
            case 0:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((855), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((765), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((690), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((614), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((534), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((458), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((383), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((307), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((227), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((145), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((18), (855), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((18), (790), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((18), (735), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((18), (660), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((18), (580), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((18), (505), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((18), (430), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((18), (355), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((18), (280), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((18), (205), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((18), (115), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((185), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((260), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((335), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((410), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((485), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((560), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((635), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((710), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((785), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((875), (115), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((875), (195), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((875), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((875), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((875), (420), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((875), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((875), (570), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((875), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((875), (725), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((875), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 1:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((855), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((765), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((690), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((615), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((540), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((465), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((390), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((315), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((240), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((165), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((19), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((19), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((19), (725), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((19), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((19), (570), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((19), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((19), (420), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((19), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((19), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((19), (195), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((19), (115), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((185), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((260), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((335), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((410), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((485), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((560), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((635), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((710), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((785), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((875), (115), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((875), (195), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((875), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((875), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((875), (420), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((875), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((875), (570), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((875), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((875), (725), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((875), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 2:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((855), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((765), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((690), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((615), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((540), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((465), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((390), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((315), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((240), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((165), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((19), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((19), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((19), (725), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((19), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((19), (570), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((19), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((19), (420), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((19), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((19), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((19), (195), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((19), (115), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((185), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((260), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((335), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((410), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((485), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((560), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((635), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((710), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((785), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((875), (115), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((875), (195), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((875), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((875), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((875), (420), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((875), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((875), (570), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((875), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((875), (725), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((875), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 3:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((855), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((765), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((690), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((615), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((540), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((465), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((390), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((315), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((240), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((165), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((19), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((19), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((19), (725), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((19), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((19), (570), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((19), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((19), (420), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((19), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((19), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((19), (195), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((19), (115), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((185), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((260), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((335), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((410), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((485), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((560), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((635), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((710), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((785), (100), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((875), (115), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((875), (195), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((875), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((875), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((875), (420), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((875), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((875), (570), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((875), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((875), (725), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((875), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
        }
    }
}
