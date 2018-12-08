/*
MONOPOLY ASSIGNMENT
By: Shawn Sun, Christopher Jordan, Gabriel Martell, and Bryce Batten
ICS3U
 */
package monopoly;

import java.awt.Color;
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

    public static void main(String[] args) throws IOException {
        JFrame HUD = new JFrame();
        HUD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HUD.setSize(1800, 1050);
        HUD.setLayout(null);
        /*
        String text = "rules.txt";
        ProcessBuilder txtfile = new ProcessBuilder("Notepad.exe", text);

        txtfile.start();
        String[] spacetext = new String[41];
        Integer[] space = new Integer[41];
        Integer[] homes = new Integer[40];
        Integer[] playerturn = new Integer[4];
        Integer[][] owner = new Integer[40][4];

        Integer[] money = new Integer[4];
        Boolean[] bankrupt = new Boolean[4];
        Boolean[][] bought = new Boolean[4][40];
        
        int i=1;

        int reply = JOptionPane.showConfirmDialog(
                null,
                "Would you like to buy this?",
                "You landed on " + spacetext[i],
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            
        }
         */
        JLabel board = new JLabel();
        board.setIcon(new ImageIcon("images/monopolyboard.jpg"));
        board.setBounds((1), (1), board.getPreferredSize().width, board.getPreferredSize().height);
        HUD.add(board);

        JLabel[] player = new JLabel[4];
        for (int playericon = 0; playericon < 4; playericon++) {
            int playericonInt=0;
            do {
                String playericonInput = JOptionPane.showInputDialog("Choose your player piece");

                playericonInt = Integer.parseInt(playericonInput); // parsing
                if (playericonInt < 1 || playericonInt > 6) {
                    JOptionPane.showMessageDialog(null, "Please input a Valid Number"); //alerting of error, and loops
                }
            } while (playericonInt < 2 || playericonInt > 8);
            switch (playericonInt) {
                case 1:
                    player[playericon].setIcon(new ImageIcon("images/players/piecebinder.png"));
                case 2:
                    player[playericon].setIcon(new ImageIcon("images/players/piecemouse.png"));
                case 3:
                    player[playericon].setIcon(new ImageIcon("images/players/piecesun.png"));
                case 4:
                    player[playericon].setIcon(new ImageIcon("images/players/piecephone.png"));
                case 5:
                    player[playericon].setIcon(new ImageIcon("images/players/piecesoccer.png"));
                case 6:
                    player[playericon].setIcon(new ImageIcon("images/players/piecepaint.png"));

            }
        }

        number = new JButton(num + "");
        number.setFont(new Font("Monospaced Plain", Font.PLAIN, 50));
        number.setBounds(1050, 10, 100, 100);
        HUD.add(number);

        newNum = new JButton("ROLL");
        newNum.setBounds(1200, 10, 100, 100);
        newNum.addActionListener(action);
        HUD.add(newNum);

        HUD.setVisible(true);

    }

    private static ActionListener action = (new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            num = ((new Random()).nextInt((12 - 1) + 1) + 1);
            number.setText(num + "");
        }
    });
}
