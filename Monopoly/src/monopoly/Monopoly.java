/*
MONOPOLY ASSIGNMENT
By: Shawn Sun, Christopher Jordan, Gabriel Martell, and Bryce Batten
ICS3U
 */
package monopoly;

import java.awt.Font;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Monopoly {

    public static JButton number;
    public static JButton newNum;
    public static int roll;
    public static JLabel[] player = new JLabel[4];
    public static int playerturn = 0;
    public static int[] space = {0, 0, 0, 0};
    public static String[] spacename = {"Go!", "Mr. Royko's Room", "Community Chest", "Ms. Dale's Room", "Student Fee", "Retaj", "Ms. Brooks' Room", "Chance", "Mr. Blank's Room", "Mr. Loy's Room", "Jail/Just Visiting", "Mr. Ketcheson's Room", "Cafeteria", "Ms. Turnbulll's Room", "Mr. Yemensky's Room", "Subway", "Ms. Galveals' Room", "Community Chest", "Mr. Lahey's Room", "Ms. Andreoli's Room", "Hall Pass", "Mr. McKee's Room", "Chance Card", "Ms. Egan's Room", "Mr. Baar's Room", "DQ", "Mr. Thompson's Room", "Ms. Miri's Room", "Learning Commons", "Mr. Scerbo's Room", "Go to Detention", "Ms. Sipes' Room", "Mrs. Gibson's Room", "Community Chest", "Ms. Ramsay's Room", "Gabriel's Pizza", "Chance", "Mr. Blakely's Room", "Field Trip", "Mr. Schwartz's Room"};
    public static String[] chanceCards = {"Advance to \"Go\", Collect $200", "Advance to Mrs. Egan’s Religion. If you pass \"Go\", collect $200.", "Advance to Mr. Ketcheson’s Visual Arts. If you pass \"Go\", collect $200.", "Advance your player piece to nearest Lunch Hangout Area. If unowned, you may buy it from the RBC. If owned, throw dice and pay owner a total 10 times the amount thrown.", "Advance your player piece to the nearest Plaza Restaurant and pay owner twice the rental to which he/she is otherwise entitled. If the Plaza Restaurant is unowned, you may buy it from the RBC.", "RBC pays you the $50 your parents put into your account.", "Get out of Detention Free Card. This card may be kept until needed, or traded/sold.", "Go back Three (3) tiles.", "You got caught skipping! Go to Detention. . . directly to Detention! Do not pass \"Go\", do not collect $200.", "Out of rage because of a bad grade, you accidentally broke stuff at all your property sites! For each house pay $25, For each hotel pay $100.", "Mr. Adams’ charming voice forces you to buy pizza! You pay $15 worth of pizza.", "Take your time at lunch to go to the plaza’s Retaj. If you pass Go, collect $200.", "Time to play BINGO. Advance your player piece to Mr. Schwartz’s Tech.", "You have been elected as the Student Council President. Pay each player $50.", "You somehow find a jackpot of money under your couch?! Collect $150.", "You have won a contest of sorts. Collect $100."};
    public static String[] chestCards = {"Advance to \"Go\", Collect $200", "RBC withdrawal error in your favor. Collect $200.", "You stand on a stool in drama class but fall. Your friends will probably make fun of you for quite some time. Pay hospital fee of $50.", "Sold baked good at the cafeteria, you got $50.", "Get out of Detention Free Card. This card may be kept until needed, or traded/sold.", "You got caught skipping! Go to Detention. . . directly to Detention! Do not pass \"Go\", do not collect $200.", "Elf Auction! Collect $50 from every player for the entry tickets.", "Coyote Prowl! Receive $100 for putting on a good show.", "You asked your parents for money. They were feeling generous and gave you a bit extra. Collect $20.", "It is your birthday, everyone in your class sings “Happy Birthday” out of tune. Collect $10 from every player.", "A student was low-riding to a point where they gave away their Gucci belt, and gave it to you. You sell it because brands don’t mean anything. Collect $100 ", "You want to purchase a school hoodie to show off your Coyote Spirit! Pay $50. ", "At the elf auction, you got into a bid battle and won. On the negative side, you battled for quite a while. Pay $50.", "You tutor a student and they pay you out of generosity. Receive $25.", "You connect to the bluetooth speaker at every property site you own and play Youtube Rewind 2018, wasn’t a bright idea… Pay $40 per house and $115 per hotel you own.", "Your grandparent slips you some money when your parents wouldn't. Receive $100."};
    public static Integer[] buyPrice = {0, 60, 0, 60, 0, 200, 100, 0, 100, 120, 0, 140, 150, 140, 160, 200, 180, 0, 180, 200, 0, 220, 0, 220, 240, 200, 260, 260, 280, 0, 300, 300, 0, 320, 200, 0, 350, 0, 400};
    public static JLabel turn = new JLabel();
    public static Integer[] money = {1500, 1500, 1500, 1500};
    public static JLabel[] moneyLabel = new JLabel[4];
    public static String[] name = new String[4];
    public static Integer[] deckChance = new Integer[16];
    public static Integer[] deckChest = new Integer[16];
    public static Integer[] getOutFree = {0, 0, 0, 0};
    // how many get out of jail free cards each person has, goes down when traded or used
    public static int playInGame = 4;
    //goes down when someone goes bankrupt, for chance cards
    public static int[] houseTotal = {0, 0, 0, 0};
    public static int[] hotelTotal = {0, 0, 0, 0};
    // add to house total to playerturn when they upgrade, for chance cards
    public static Boolean[] bought = new Boolean[40];
    public static Boolean[] mortgaged = new Boolean[40];
    public static Integer[] owner = new Integer[40];
    //0,1,2,3, depending on player
    public static Integer[] rentLevel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //rentlevel[space[playerturn]]++ when buying a home or hotel
    public static Integer[][] rentPrices = {
        {0, 2, 0, 4, 0, 0, 6, 0, 6, 8, 0, 10, 0, 10, 12, 0, 14, 0, 14, 16, 0, 18, 0, 18, 20, 0, 22, 22, 0, 24, 0, 26, 26, 0, 28, 0, 0, 35, 0, 50},
        {0, 10, 0, 20, 0, 0, 30, 0, 30, 40, 0, 50, 0, 50, 60, 0, 70, 0, 70, 80, 0, 90, 0, 90, 100, 0, 110, 110, 0, 120, 0, 130, 130, 0, 150, 0, 0, 175, 0, 200},
        {0, 30, 0, 60, 0, 0, 90, 0, 90, 100, 0, 150, 0, 150, 180, 0, 200, 0, 200, 220, 0, 250, 0, 250, 300, 0, 330, 330, 0, 360, 0, 390, 390, 0, 450, 0, 0, 500, 0, 600},
        {0, 90, 0, 180, 0, 0, 270, 0, 270, 300, 0, 450, 0, 450, 500, 0, 550, 0, 550, 600, 0, 700, 0, 700, 750, 0, 800, 800, 0, 850, 0, 900, 900, 0, 1000, 0, 0, 1100, 0, 1400},
        {0, 160, 0, 320, 0, 0, 400, 0, 400, 450, 0, 625, 0, 625, 700, 0, 750, 0, 750, 800, 0, 875, 0, 875, 925, 0, 975, 975, 0, 1025, 0, 1100, 1100, 0, 1200, 0, 0, 1300, 0, 1700},
        {0, 250, 0, 450, 0, 0, 550, 0, 550, 600, 0, 750, 0, 750, 900, 0, 950, 0, 950, 1000, 0, 1050, 0, 1050, 1100, 0, 1150, 1150, 0, 1200, 0, 1275, 1275, 0, 1400, 0, 0, 1500, 0, 2000},};

    public static int[] rrOwned = {0, 0, 0, 0};
    public static int[] utilOwned = {0, 0, 0, 0};
    public static Boolean[] bankrupt = {false, false, false, false};

    public static void main(String[] args) throws IOException {
        JFrame HUD = new JFrame();
        HUD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HUD.setSize(1800, 1050);
        HUD.setLayout(null);

        for (int nameInput = 0; nameInput < 4; nameInput++) {
            do {
                name[nameInput] = JOptionPane.showInputDialog("What is your name Player " + (nameInput + 1) + " (12 Characters Max)");
                if ((name[nameInput].length() > 12) || (name[nameInput].length() == 0)) {
                    JOptionPane.showMessageDialog(null, "Please input a valid name");
                }
            } while ((name[nameInput].length() > 12) || (name[nameInput].length() == 0));

        }
        for (int playericon = 0; playericon < 4; playericon++) {
            String[] options = {"Binder", "Mouse", "Sun G.'s", "Phone", "Soccer", "Paint"};
            int iconchoice = JOptionPane.showOptionDialog(null, "Choose a playerpiece, " + name[playericon],
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

        number = new JButton(roll + "");
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

        Arrays.fill(bought, false);
        Arrays.fill(mortgaged, false);

        HUD.setVisible(true);

        while (playInGame > 1) {
            if(bankrupt[playerturn] == false){
            String[] options = {"Roll", "Properties", "Trade", "blank"};
            int menuchoice = JOptionPane.showOptionDialog(null, "What would you like to do, " + name[playerturn] + "?",
                    "PICK SOMETHING",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (menuchoice) {
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
        JOptionPane.showMessageDialog(null, "THE GAME IS OVER");
    }

    public static void moverMethod() {
        roll = ((new Random()).nextInt((12 - 2) + 1) + 2);
        number.setText(roll + "");
        JOptionPane.showMessageDialog(null, "You rolled " + roll);
        space[playerturn] += roll;
        do {
            if (space[playerturn] >= 40) {
                space[playerturn] -= 40;
                JOptionPane.showMessageDialog(null, "You passed go, collect $200");
                money[playerturn] += 200;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
            }
        } while (space[playerturn] >= 40);
        spaceMaker();
        spaceLanded();

        playerturn += 1;
        if (playerturn == 4) {
            playerturn = 0;
        }
    }

    public static void spaceLanded() {
        JOptionPane.showMessageDialog(null, name[playerturn] + ", you landed on " + spacename[space[playerturn]]);
        switch (space[playerturn]) {
            case 0:
                landedOnGo();
                break;
            case 7:
            case 22:
            case 36:
                landedOnChance();
                break;
            case 2:
            case 17:
            case 33:
                landedOnChest();
                break;
            case 4:
            case 38:
                landedOnPay();
                break;
            case 30:
                landedOnGoTo();
                break;
            case 10:
            case 20:
                landedOnRelax();
                break;
            default:
                landedOnProperty();
                break;
        }
    }

    public static void landedOnGo() {
        JOptionPane.showMessageDialog(null, "GO, time to relax!");

    }

    public static void landedOnChance() {
        int cardChance = chanceCardMaker(deckChance);
        JOptionPane.showMessageDialog(null, chanceCards[cardChance]);
        switch (cardChance) {
            case 0:
                money[playerturn] += 200;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                space[playerturn] = 0;
                spaceMaker();
                spaceLanded();
                break;
            case 1:
                if (space[playerturn] > 23) {
                    JOptionPane.showMessageDialog(null, "You passed go, collect $200");
                    money[playerturn] += 200;
                    moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                }
                space[playerturn] = 23;
                spaceMaker();
                spaceLanded();
                break;
            case 2:
                if (space[playerturn] > 11) {
                    JOptionPane.showMessageDialog(null, "You passed go, collect $200");
                    money[playerturn] += 200;
                    moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                }
                space[playerturn] = 11;
                spaceMaker();
                spaceLanded();
                break;
            case 3:
                if (space[playerturn] > 28) {
                    JOptionPane.showMessageDialog(null, "You passed go, collect $200");
                    money[playerturn] += 200;
                    moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                    space[playerturn] = 12;
                } else if (space[playerturn] > 12) {
                    space[playerturn] = 28;
                } else if (space[playerturn] >= 0) {
                    space[playerturn] = 12;
                }
                spaceMaker();
                spaceLanded();
                break;
            case 4:
                if (space[playerturn] > 35) {
                    JOptionPane.showMessageDialog(null, "You passed go, collect $200");
                    money[playerturn] += 200;
                    moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                    space[playerturn] = 5;
                } else if (space[playerturn] > 25) {
                    space[playerturn] = 35;
                } else if (space[playerturn] > 15) {
                    space[playerturn] = 25;
                } else if (space[playerturn] > 5) {
                    space[playerturn] = 15;
                } else if (space[playerturn] >= 0) {
                    space[playerturn] = 5;
                }
                spaceMaker();
                spaceLanded();
                break;
            case 5:
                money[playerturn] += 50;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 6:
                getOutFree[playerturn] += 1;
                break;
            case 7:
                space[playerturn] -= 3;
                spaceMaker();
                spaceLanded();
                break;
            case 8:
                switch (playerturn) {
                    case 0:
                        player[playerturn].setBounds((38), (845), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((73), (845), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((38), (880), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((73), (880), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 9:
                money[playerturn] -= (25 * houseTotal[playerturn]) + (100 * hotelTotal[playerturn]);
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 10:
                money[playerturn] -= 15;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 11:
                if (space[playerturn] > 5) {
                    JOptionPane.showMessageDialog(null, "You passed go, collect $200");
                    money[playerturn] += 200;
                    moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                }
                space[playerturn] = 5;
                spaceMaker();
                spaceLanded();
                break;
            case 12:
                space[playerturn] = 39;
                spaceMaker();
                spaceLanded();
                break;
            case 13:
                money[playerturn] -= (50 * (playInGame - 1));
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                switch (playerturn) {
                    case 0:
                        money[1] += 50;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[2] += 50;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[3] += 50;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 1:
                        money[0] += 50;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        money[2] += 50;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[3] += 50;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 2:
                        money[1] += 50;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[0] += 50;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        money[3] += 50;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 3:
                        money[1] += 50;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[2] += 50;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[0] += 50;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        break;
                }
                break;
            case 14:
                money[playerturn] += 150;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 15:
                money[playerturn] += 100;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
        }
    }

    public static int chanceCardMaker(Integer archive[]) {
        int x = 0;
        int ran = ((new Random()).nextInt((15 - 0) + 1) + 0);
        while (x < archive.length) {
            if (x == 15) {
                archive = null;
                x = 0;
            }
            if (archive[x] == null) {
                archive[x] = ran;
                return (ran);
            } else if (archive[x] == ran) {
                ran = ((new Random()).nextInt((16 - 1) + 1) + 1);
                x = 0;
            } else {
                x++;
            }
        }
        return -1;
    }

    public static void landedOnChest() {
        int cardChest = chestCardMaker(deckChest);
        JOptionPane.showMessageDialog(null, chestCards[cardChest]);
        switch (cardChest) {
            case 0:
                money[playerturn] += 200;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                space[playerturn] = 0;
                spaceMaker();
                spaceLanded();
                break;
            case 1:
                money[playerturn] += 200;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 2:
                money[playerturn] -= 50;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 3:
                money[playerturn] += 50;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 4:
                getOutFree[playerturn] += 1;
                break;
            case 5:
                switch (playerturn) {
                    case 0:
                        player[playerturn].setBounds((38), (845), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((73), (845), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((38), (880), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((73), (880), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 6:
                money[playerturn] += (50 * (playInGame - 1));
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                switch (playerturn) {
                    case 0:
                        money[1] -= 50;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[2] -= 50;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[3] -= 50;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 1:
                        money[0] -= 50;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        money[2] -= 50;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[3] -= 50;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 2:
                        money[1] -= 50;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[0] -= 50;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        money[3] -= 50;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 3:
                        money[1] -= 50;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[2] -= 50;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[0] -= 50;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        break;
                }
                break;
            case 7:
                money[playerturn] += 100;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 8:
                money[playerturn] += 20;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 9:
                money[playerturn] += (10 * (playInGame - 1));
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                switch (playerturn) {
                    case 0:
                        money[1] -= 10;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[2] -= 10;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[3] -= 10;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 1:
                        money[0] -= 10;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        money[2] -= 10;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[3] -= 10;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 2:
                        money[1] -= 10;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[0] -= 10;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        money[3] -= 10;
                        moneyLabel[3].setText(name[3] + "'s money: $" + money[3] + "");
                        break;
                    case 3:
                        money[1] -= 10;
                        moneyLabel[1].setText(name[1] + "'s money: $" + money[1] + "");
                        money[2] -= 10;
                        moneyLabel[2].setText(name[2] + "'s money: $" + money[2] + "");
                        money[0] -= 10;
                        moneyLabel[0].setText(name[0] + "'s money: $" + money[0] + "");
                        break;
                }
                break;
            case 10:
                money[playerturn] += 100;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 11:
                money[playerturn] -= 50;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 12:
                money[playerturn] -= 50;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 13:
                money[playerturn] += 25;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 14:
                money[playerturn] -= (40 * houseTotal[playerturn]) + (115 * hotelTotal[playerturn]);
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 15:
                money[playerturn] += 100;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
        }
    }

    public static int chestCardMaker(Integer archive[]) {
        int z = 0;
        int ran = ((new Random()).nextInt((15 - 0) + 1) + 0);
        while (z < archive.length) {
            if (z == 15) {
                archive = null;
                z = 0;
            }
            if (archive[z] == null) {
                archive[z] = ran;
                return (ran);
            } else if (archive[z] == ran) {
                ran = ((new Random()).nextInt((16 - 1) + 1) + 1);
                z = 0;
            } else {
                z++;
            }
        }
        return -1;
    }

    public static void landedOnPay() {
        switch (space[playerturn]) {
            case 4:
                JOptionPane.showMessageDialog(null, "Please Pay $200 for a Student Fee");
                money[playerturn] -= 200;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 38:
                JOptionPane.showMessageDialog(null, "FIELD TRIP!!! Pay $100");
                money[playerturn] -= 100;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
        }
    }

    public static void landedOnGoTo() {
        JOptionPane.showMessageDialog(null, "GO TO JAIL, DO NOT PASS GO, DO NOT COLLECT 200");
        switch (playerturn) {
            case 0:
                player[playerturn].setBounds((38), (845), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                break;
            case 1:
                player[playerturn].setBounds((73), (845), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                break;
            case 2:
                player[playerturn].setBounds((38), (880), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                break;
            case 3:
                player[playerturn].setBounds((73), (880), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                break;

        }
    }

    public static void landedOnRelax() {
        JOptionPane.showMessageDialog(null, "Ahh finally, a space that does nothing!");

    }

    public static void landedOnProperty() {
        if (bought[space[playerturn]] == false) {
            int reply = JOptionPane.showConfirmDialog(
                    null,
                    "Would you like to buy " + spacename[space[playerturn]],
                    "Wanna buy it?",
                    JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "You bought the propety");
                bought[space[playerturn]] = true;
                owner[space[playerturn]] = playerturn;
                money[playerturn] -= buyPrice[space[playerturn]];
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                switch (space[playerturn]) {
                    case 5:
                    case 15:
                    case 25:
                    case 35:
                        rrOwned[playerturn] += 1;
                }
            } else if (reply == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "You did not buy the propety");
            }
        } else if (bought[space[playerturn]] == true) {
            if (owner[space[playerturn]] == playerturn) {
                JOptionPane.showMessageDialog(null, "This is your Property, nothing happens");
            } else if (mortgaged[space[playerturn]] == true) {
                JOptionPane.showMessageDialog(null, "This Property is Mortgaged, nothing happens");
            } else {
                switch (space[playerturn]) {
                    case 5:
                    case 15:
                    case 25:
                    case 35:
                        JOptionPane.showMessageDialog(null, "Please pay $" + 50 * rrOwned[owner[space[playerturn]]]);
                        break;
                    case 12:
                    case 28:
                        if ((owner[space[playerturn]] == owner[12]) && (owner[space[playerturn]] == owner[28])) {
                            JOptionPane.showMessageDialog(null, "Please pay $" + (10 * roll));
                        } else {
                            JOptionPane.showMessageDialog(null, "Please pay $" + (4 * roll));
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Please pay $" + rentPrices[rentLevel[space[playerturn]]][space[playerturn]]);
                        money[playerturn] -= rentPrices[rentLevel[space[playerturn]]][space[playerturn]];
                        moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                        money[owner[space[playerturn]]] += rentPrices[rentLevel[space[playerturn]]][space[playerturn]];
                        moneyLabel[owner[space[playerturn]]].setText(name[owner[space[playerturn]]] + "'s money: $" + money[owner[space[playerturn]]] + "");
                        break;
                }
            }
        }
    }

    public static void spaceMaker() {
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
