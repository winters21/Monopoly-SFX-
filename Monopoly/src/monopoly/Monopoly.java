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
    public static int playerturn = 0;
    public static int[] space = new int[4];
    public static JLabel turn = new JLabel();
    public static Integer[] money = {1500, 1500, 1500, 1500};
    public static JLabel[] moneyLabel = new JLabel[4];
    public static String[] name = new String[4];

    public static void main(String[] args) throws IOException {
        JFrame HUD = new JFrame();
        HUD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HUD.setSize(1800, 1050);
        HUD.setLayout(null);

        for (int nameInput = 0; nameInput < 4; nameInput++) {
            name[nameInput] = JOptionPane.showInputDialog("What is your name Player " + (nameInput + 1));
        }
        for (int playericon = 0; playericon < 4; playericon++) {
            String[] options = {"Binder", "Mouse", "Sun G.'s", "Phone", "Soccer", "Paint"};
            int iconchoice = JOptionPane.showOptionDialog(null, "Choose a playerpiece " + name[playericon],
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (iconchoice) {
                case 0:
                    player[playericon] = new JLabel(new ImageIcon("images/players/binderfix.png"));
                    break;
                case 1:
                    player[playericon] = new JLabel(new ImageIcon("images/players/mousefix.png"));
                    break;
                case 2:
                    player[playericon] = new JLabel(new ImageIcon("images/players/sunfix.png"));
                    break;
                case 3:
                    player[playericon] = new JLabel(new ImageIcon("images/players/phonefix.png"));
                    break;
                case 4:
                    player[playericon] = new JLabel(new ImageIcon("images/players/soccerfix.png"));
                    break;
                case 5:
                    player[playericon] = new JLabel(new ImageIcon("images/players/paintfix.png"));
                    break;
            }
            HUD.add(player[playericon]);
        }
        player[0].setBounds((855), (875), player[0].getPreferredSize().width, player[0].getPreferredSize().height);
        player[1].setBounds((895), (875), player[1].getPreferredSize().width, player[1].getPreferredSize().height);
        player[2].setBounds((855), (925), player[2].getPreferredSize().width, player[2].getPreferredSize().height);
        player[3].setBounds((895), (925), player[3].getPreferredSize().width, player[3].getPreferredSize().height);

        for (int moneyicon = 0; moneyicon < 4; moneyicon++) {
            moneyLabel[moneyicon] = new JLabel(name[moneyicon] + "'s money: $" + money[moneyicon] + "");
            moneyLabel[moneyicon].setFont(new Font("Monospaced Plain", Font.PLAIN, 35));
            HUD.add(moneyLabel[moneyicon]);
        }
        moneyLabel[0].setBounds(1350, 110, 1000, 100);
        moneyLabel[1].setBounds(1350, 210, 1000, 100);
        moneyLabel[2].setBounds(1350, 310, 1000, 100);
        moneyLabel[3].setBounds(1350, 410, 1000, 100);

        number = new JButton(num + "");
        number.setFont(new Font("Monospaced Plain", Font.PLAIN, 50));
        number.setBounds(1050, 10, 100, 100);
        HUD.add(number);

        turn.setText(name[playerturn] + "'s turn");
        turn.setFont(new Font("Monospaced Plain", Font.PLAIN, 50));
        turn.setBounds(1350, 10, 1000, 100);
        HUD.add(turn);

        JLabel board = new JLabel();
        board.setIcon(new ImageIcon("images/monopolyboard.jpg"));
        board.setBounds((1), (1), board.getPreferredSize().width, board.getPreferredSize().height);
        HUD.add(board);

        HUD.setVisible(true);

        while (true) {
            String[] options = {"Roll", "blank", "blank", "quit"};
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
            }
            turn.setText(name[playerturn] + "'s turn");
        }
    }
    
    public static void Money() {
        
    }

    public static void moverMethod() {
        num = ((new Random()).nextInt((12 - 1) + 1) + 1);
        number.setText(num + "");
        JOptionPane.showMessageDialog(null, "You rolled " + num);
        space[playerturn] += num;
        do {
            if (space[playerturn] >= 40) {
                space[playerturn] -= 40;
                JOptionPane.showMessageDialog(null, "You passed go, collect $200");
                money[playerturn] += 200;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
            }
        } while (space[playerturn] >= 40);
        spacemaker();
        playerturn += 1;
        if (playerturn == 4) {
            playerturn = 0;
        }
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
                        player[playerturn].setBounds((18), (845), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((18), (760), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((18), (695), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((18), (615), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((18), (535), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((18), (455), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((18), (385), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((18), (305), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((18), (230), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((18), (150), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((50), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((145), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((227), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((307), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((383), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((458), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((534), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((614), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((690), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((765), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((875), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((875), (155), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((875), (230), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((875), (305), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((875), (385), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((875), (460), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((875), (535), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((875), (620), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((875), (695), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((875), (760), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 1:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((895), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((800), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((725), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((649), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((569), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((493), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((418), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((342), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((262), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((180), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((18), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((68), (760), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((68), (695), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((68), (615), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((68), (535), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((68), (455), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((68), (385), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((68), (305), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((68), (230), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((68), (150), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((100), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((180), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((262), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((342), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((418), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((493), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((569), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((649), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((725), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((800), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((925), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((925), (155), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((925), (230), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((925), (305), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((925), (385), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((925), (460), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((925), (535), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((925), (620), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((925), (695), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((925), (760), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 2:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((855), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((765), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((690), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((614), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((534), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((458), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((383), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((307), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((227), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((145), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((18), (905), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((18), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((18), (730), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((18), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((18), (575), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((18), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((18), (425), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((18), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((18), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((18), (190), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((50), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((145), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((227), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((307), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((383), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((458), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((534), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((614), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((690), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((765), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((875), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((875), (190), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((875), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((875), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((875), (425), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((875), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((875), (575), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((875), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((875), (730), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((875), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 3:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((895), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((800), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((725), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((649), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((569), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((493), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((418), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((342), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((262), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((180), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((18), (935), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((68), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((68), (730), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((68), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((68), (575), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((68), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((68), (425), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((68), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((68), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((68), (190), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((100), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((180), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((262), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((342), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((418), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((493), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((569), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((649), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((725), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((800), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((925), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((925), (190), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((925), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((925), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((925), (425), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((925), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((925), (575), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((925), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((925), (730), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((925), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
        }
    }
}
