package MemoryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MemoryGame {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JPanel gameBoard = new JPanel();
    static JButton g1 = new JButton();
    static JButton g2 = new JButton();
    static JButton g3 = new JButton();
    static JButton g4 = new JButton();
    static JButton g5 = new JButton();
    static JButton g6 = new JButton();
    static JButton g7 = new JButton();
    static JButton g8 = new JButton();
    static JButton g9 = new JButton();
    static JButton g10 = new JButton();
    static JButton g11 = new JButton();
    static JButton g12 = new JButton();
    static JButton g13 = new JButton();
    static JButton g14 = new JButton();
    static JButton g15 = new JButton();
    static JButton g16 = new JButton();
    static JButton card1 = new JButton();
    static JButton card2 = new JButton();
    static int[] iconPlace = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    static JButton startButton = new JButton();
    static JButton quit = new JButton();
    static JButton noMatch = new JButton();
    static int highScore = 0, highestScore = 1000000000;
    static JLabel scoreDisplay = new JLabel();
    static JLabel HSDisplay = new JLabel();
    static ActionListener buttonListener;
    static Icon image1 = new ImageIcon(
            new ImageIcon("images\\image1.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    static Icon image2 = new ImageIcon(
            new ImageIcon("images\\image2.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    static Icon image3 = new ImageIcon(
            new ImageIcon("images\\image3.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    static Icon image4 = new ImageIcon(
            new ImageIcon("images\\image4.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    static Icon image5 = new ImageIcon(
            new ImageIcon("images\\image5.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    static Icon image6 = new ImageIcon(
            new ImageIcon("images\\image6.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    static Icon image7 = new ImageIcon(
            new ImageIcon("images\\image7.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    static Icon image8 = new ImageIcon(
            new ImageIcon("images\\image8.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    public static void main(String[] args) {

        // frame settings
        frame.setBounds(300, 30, 899, 899);
        frame.setTitle("Matching");
        frame.setVisible(true);

        // main panel settings
        panel.setSize(900, 900);
        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);

        // game board panel settings
        gameBoard.setBounds(90, 80, 699, 699);
        gameBoard.setBackground(Color.BLACK);
        gameBoard.setLayout(null);

        // scoreDisplay label settings
        scoreDisplay.setBounds(365, 10, 150, 50);
        scoreDisplay.setText("Clicks: " + highScore );

        // High score Display label settings
        HSDisplay.setBounds(150, 10, 150, 50);
        HSDisplay.setText("Record: " + highestScore + " clicks" );
        HSDisplay.setVisible(false);

        // Start Button settings
        startButton.setBounds(365, 790, 150, 50);
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.setText("Play");
        startButton.setBackground(Color.green);
        startButton.setForeground(Color.BLACK);

        // button for flipping back wrong matches
        noMatch.setBounds(520, 790, 150, 50);
        noMatch.setFont(new Font("Arial", Font.PLAIN, 30));
        noMatch.setText("continue");
        noMatch.setBackground(Color.yellow);
        noMatch.setForeground(Color.BLACK);

        // quit button
        quit.setBounds(800, 820, 70, 30);
        quit.setFont(new Font("Arial", Font.PLAIN, 10));
        quit.setText("quit");
        quit.setBackground(Color.red);
        quit.setForeground(Color.BLACK);

        // cards settings
        g1.setBounds(0, 0, 174, 174);
        g2.setBounds(175, 0, 174, 174);
        g3.setBounds(350, 0, 174, 174);
        g4.setBounds(525, 0, 174, 174);
        g5.setBounds(0, 175, 174, 174);
        g6.setBounds(175, 175, 174, 174);
        g7.setBounds(350, 175, 174, 174);
        g8.setBounds(525, 175, 174, 174);
        g9.setBounds(0, 350, 174, 174);
        g10.setBounds(175, 350, 174, 174);
        g11.setBounds(350, 350, 174, 174);
        g12.setBounds(525, 350, 174, 174);
        g13.setBounds(0, 525, 174, 174);
        g14.setBounds(175, 525, 174, 174);
        g15.setBounds(350, 525, 174, 174);
        g16.setBounds(525, 525, 174, 174);

        // Adding all the components
        frame.add(panel);
        panel.add(gameBoard);
        panel.add(startButton);
        panel.add(quit);
        panel.add(scoreDisplay);
        panel.add(HSDisplay);
        gameBoard.add(g1);
        gameBoard.add(g2);
        gameBoard.add(g3);
        gameBoard.add(g4);
        gameBoard.add(g5);
        gameBoard.add(g6);
        gameBoard.add(g7);
        gameBoard.add(g8);
        gameBoard.add(g9);
        gameBoard.add(g10);
        gameBoard.add(g11);
        gameBoard.add(g12);
        gameBoard.add(g13);
        gameBoard.add(g14);
        gameBoard.add(g15);
        gameBoard.add(g16);
        card1 = null;
        card2 = null;

        // pregame set up
        shuffle();
        viewIcons(true);

        // start/restart game
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                highScore = 0;
                scoreDisplay.setText("Clicks: " + highScore );
                startButton.setEnabled(false);
                panel.setBackground(Color.ORANGE);
                g1.setEnabled(true);
                g2.setEnabled(true);
                g3.setEnabled(true);
                g4.setEnabled(true);
                g5.setEnabled(true);
                g6.setEnabled(true);
                g7.setEnabled(true);
                g8.setEnabled(true);
                g9.setEnabled(true);
                g10.setEnabled(true);
                g11.setEnabled(true);
                g12.setEnabled(true);
                g13.setEnabled(true);
                g14.setEnabled(true);
                g15.setEnabled(true);
                g16.setEnabled(true);
                viewIcons(false);
                startGame();
            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    } // end of main

    public static void startGame() {

        // Main game
        buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /* on each click, record the total clicks
                 * once any button is clicked, find out which button was pressed,
                 * card1 and card2 are null buttons that don't technically exist on the board
                 * if card1 is null, set the clicked button equal to card1,
                 * otherwise set it to card2 and check for a match
                 * once all the buttons are disabled, the round ends
                 */

                highScore++;
                scoreDisplay.setText("Clicks: " + highScore );
                if (e.getSource() == g1) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g1;
                        showCard(g1, 0);
                    } else if (card2 == null) {
                        card2 = g1;
                        showCard(g1, 0);
                        checkMatch();
                    }
                }
                if (e.getSource() == g2) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g2;
                        showCard(g2, 1);
                    } else if (card2 == null) {
                        card2 = g2;
                        showCard(g2, 1);
                        checkMatch();
                    }
                }
                if (e.getSource() == g3) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g3;
                        showCard(g3, 2);
                    } else if (card2 == null) {
                        card2 = g3;
                        showCard(g3, 2);
                        checkMatch();
                    }
                }
                if (e.getSource() == g4) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g4;
                        showCard(g4, 3);
                    } else if (card2 == null) {
                        card2 = g4;
                        showCard(g4, 3);
                        checkMatch();
                    }
                }
                if (e.getSource() == g5) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g5;
                        showCard(g5, 4);
                    } else if (card2 == null) {
                        card2 = g5;
                        showCard(g5, 4);
                        checkMatch();
                    }
                }
                if (e.getSource() == g6) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g6;
                        showCard(g6, 5);
                    } else if (card2 == null) {
                        card2 = g6;
                        showCard(g6, 5);
                        checkMatch();
                    }
                }
                if (e.getSource() == g7) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g7;
                        showCard(g7, 6);
                    } else if (card2 == null) {
                        card2 = g7;
                        showCard(g7, 6);
                        checkMatch();
                    }
                }
                if (e.getSource() == g8) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g8;
                        showCard(g8, 7);
                    } else if (card2 == null) {
                        card2 = g8;
                        showCard(g8, 7);
                        checkMatch();
                    }
                }
                if (e.getSource() == g9) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g9;
                        showCard(g9, 8);
                    } else if (card2 == null) {
                        card2 = g9;
                        showCard(g9, 8);
                        checkMatch();
                    }
                }
                if (e.getSource() == g10) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g10;
                        showCard(g10, 9);
                    } else if (card2 == null) {
                        card2 = g10;
                        showCard(g10, 9);

                        checkMatch();
                    }
                }
                if (e.getSource() == g11) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g11;
                        showCard(g11, 10);
                    } else if (card2 == null) {
                        card2 = g11;
                        showCard(g11, 10);
                        checkMatch();
                    }
                }
                if (e.getSource() == g12) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g12;
                        showCard(g12, 11);
                    } else if (card2 == null) {
                        card2 = g12;
                        showCard(g12, 11);
                        checkMatch();
                    }
                }
                if (e.getSource() == g13) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g13;
                        showCard(g13, 12);
                    } else if (card2 == null) {
                        card2 = g13;
                        showCard(g13, 12);
                        checkMatch();
                    }
                }
                if (e.getSource() == g14) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g14;
                        showCard(g14, 13);
                    } else if (card2 == null) {
                        card2 = g14;
                        showCard(g14, 13);
                        checkMatch();
                    }
                }
                if (e.getSource() == g15) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g15;
                        showCard(g15, 14);
                    } else if (card2 == null) {
                        card2 = g15;
                        showCard(g15, 14);
                        checkMatch();
                    }
                }
                if (e.getSource() == g16) {
                    if (card1 == null) {
                        panel.setBackground(Color.ORANGE);
                        card1 = g16;
                        showCard(g16, 15);
                    } else if (card2 == null) {
                        card2 = g16;
                        showCard(g16, 15);
                        checkMatch();
                    }
                }
                checkEnd();
            }
        }; // end of action listener
        g1.addActionListener(buttonListener);
        g2.addActionListener(buttonListener);
        g3.addActionListener(buttonListener);
        g4.addActionListener(buttonListener);
        g5.addActionListener(buttonListener);
        g6.addActionListener(buttonListener);
        g7.addActionListener(buttonListener);
        g8.addActionListener(buttonListener);
        g9.addActionListener(buttonListener);
        g10.addActionListener(buttonListener);
        g11.addActionListener(buttonListener);
        g12.addActionListener(buttonListener);
        g13.addActionListener(buttonListener);
        g14.addActionListener(buttonListener);
        g15.addActionListener(buttonListener);
        g16.addActionListener(buttonListener);
    } // end of start game method

    public static boolean checkMatch() {

        if (card1 == card2) {
            // flip card back if a card is clicked twice
            card1.setEnabled(true);
            card2.setEnabled(true);
            card1.setIcon(null);
            card2.setIcon(null);
            card1 = null;
            card2 = null;
            return false;

        } else if (card1.getIcon() == card2.getIcon()) { // if cards match
            panel.setBackground(Color.green);
            card1.setEnabled(false);
            card2.setEnabled(false);
            card1 = null;
            card2 = null;
            return true;

        } else {
            // if cards don't match, add a button to flip the cards again
            panel.setBackground(Color.red);
            panel.add(noMatch);
            noMatch.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    card1.setEnabled(true);
                    card2.setEnabled(true);
                    card1.setIcon(null);
                    card2.setIcon(null);
                    card1 = null;
                    card2 = null;
                    panel.setBackground(Color.ORANGE);
                }
            });
            return false;
        }

    } // end of check match method

    public static void shuffle() {
        // method to shuffle the cards

        Random random = new Random();

        for (int i = 0; i < 16; i++) {
            // generate a random integer for the remaining positions
            int r = i + random.nextInt(16 - i); // generate a random index from what's remaining

            // this section swaps the array elements which are originally in chronological order
            int temp = iconPlace[r]; // hold the value of the generated index
            iconPlace[r] = iconPlace[i]; // set that value to the index specified by the for loop
            iconPlace[i] = temp;

        }

    } // end of shuffle method

    public static void showCard(JButton button, int n) {
        /*
         * method to show specified card according to shuffled array index 0 will always
         * match with index 8, (same with 1 & 9, 2 & 10, etc.)
         */

        if (iconPlace[n] == 0 || iconPlace[n] == 8) {
            button.setIcon(image1);
        }
        if (iconPlace[n] == 1 || iconPlace[n] == 9) {
            button.setIcon(image2);
        }
        if (iconPlace[n] == 2 || iconPlace[n] == 10) {
            button.setIcon(image3);
        }
        if (iconPlace[n] == 3 || iconPlace[n] == 11) {
            button.setIcon(image4);
        }
        if (iconPlace[n] == 4 || iconPlace[n] == 12) {
            button.setIcon(image5);
        }
        if (iconPlace[n] == 5 || iconPlace[n] == 13) {
            button.setIcon(image6);
        }
        if (iconPlace[n] == 6 || iconPlace[n] == 14) {
            button.setIcon(image7);
        }
        if (iconPlace[n] == 7 || iconPlace[n] == 15) {
            button.setIcon(image8);
        }

    } // end of showCards method

    public static void viewIcons(boolean a) {

        // method to show or hide all icons
        if (a == true) {
            showCard(g1, 0);
            showCard(g2, 1);
            showCard(g3, 2);
            showCard(g4, 3);
            showCard(g5, 4);
            showCard(g6, 5);
            showCard(g7, 6);
            showCard(g8, 7);
            showCard(g9, 8);
            showCard(g10, 9);
            showCard(g11, 10);
            showCard(g12, 11);
            showCard(g13, 12);
            showCard(g14, 13);
            showCard(g15, 14);
            showCard(g16, 15);
        }
        if (a == false) {
            g1.setIcon(null);
            g2.setIcon(null);
            g3.setIcon(null);
            g4.setIcon(null);
            g5.setIcon(null);
            g6.setIcon(null);
            g7.setIcon(null);
            g8.setIcon(null);
            g9.setIcon(null);
            g10.setIcon(null);
            g11.setIcon(null);
            g12.setIcon(null);
            g13.setIcon(null);
            g14.setIcon(null);
            g15.setIcon(null);
            g16.setIcon(null);
        }

    } // end of viewIcons method

    public static void enableBoard(boolean a) {
        // method for enabling or disabling board
        if (a == true) {
            g1.setEnabled(true);
            g2.setEnabled(true);
            g3.setEnabled(true);
            g4.setEnabled(true);
            g5.setEnabled(true);
            g6.setEnabled(true);
            g7.setEnabled(true);
            g8.setEnabled(true);
            g9.setEnabled(true);
            g10.setEnabled(true);
            g11.setEnabled(true);
            g12.setEnabled(true);
            g13.setEnabled(true);
            g14.setEnabled(true);
            g15.setEnabled(true);
            g16.setEnabled(true);
        }
        if (a == false) {
            g1.setEnabled(false);
            g2.setEnabled(false);
            g3.setEnabled(false);
            g4.setEnabled(false);
            g5.setEnabled(false);
            g6.setEnabled(false);
            g7.setEnabled(false);
            g8.setEnabled(false);
            g9.setEnabled(false);
            g10.setEnabled(false);
            g11.setEnabled(false);
            g12.setEnabled(false);
            g13.setEnabled(false);
            g14.setEnabled(false);
            g15.setEnabled(false);
            g16.setEnabled(false);
        }

    } // end of enableBoard method

    public static void checkEnd() {

        // check if all buttons are enabled
        if (!g1.isEnabled() && !g2.isEnabled() && !g3.isEnabled() && !g4.isEnabled()
                && !g5.isEnabled() && !g6.isEnabled() && !g7.isEnabled() && !g8.isEnabled()
                && !g9.isEnabled() && !g10.isEnabled() && !g11.isEnabled() && !g12.isEnabled()
                && !g13.isEnabled() && !g14.isEnabled() && !g15.isEnabled() && !g16.isEnabled()) {

            // restart game but keep track of the highest (lowest number) score
            startButton.setEnabled(true);
            startButton.setText("replay");
            HSDisplay.setVisible(true);
            if (highestScore > highScore) {
                highestScore = highScore;
                HSDisplay.setText("Record: " + highestScore + " clicks" );
            }
            shuffle();
            viewIcons(true);
            enableBoard(true);
            g1.removeActionListener(buttonListener);
            g2.removeActionListener(buttonListener);
            g3.removeActionListener(buttonListener);
            g4.removeActionListener(buttonListener);
            g5.removeActionListener(buttonListener);
            g6.removeActionListener(buttonListener);
            g7.removeActionListener(buttonListener);
            g8.removeActionListener(buttonListener);
            g9.removeActionListener(buttonListener);
            g10.removeActionListener(buttonListener);
            g11.removeActionListener(buttonListener);
            g12.removeActionListener(buttonListener);
            g13.removeActionListener(buttonListener);
            g14.removeActionListener(buttonListener);
            g15.removeActionListener(buttonListener);
            g16.removeActionListener(buttonListener);
        }
    }

} // end of class