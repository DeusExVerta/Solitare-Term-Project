/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitare;


import java.util.Stack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * TODO:
 * Buttons in Empty space and button for score area.
 *
 *
 * @author S0335108
 */
public class PlayAreaDisplay extends javax.swing.JFrame
{

    /** Creates new form PlayAreaDisplay */
    public PlayAreaDisplay()
    {
        initComponents();
        for ( int i = 0; i < buttons.length; i++ )
        {
            buttons[i] = new javax.swing.JButton[13];
        }
        {
            buttons[0][0] = L1C1;
            buttons[0][1] = L1C2;
            buttons[0][2] = L1C3;
            buttons[0][3] = L1C4;
            buttons[0][4] = L1C5;
            buttons[0][5] = L1C6;
            buttons[0][6] = L1C7;
            buttons[0][7] = L1C8;
            buttons[0][8] = L1C9;
            buttons[0][9] = L1C10;
            buttons[0][10] = L1C11;
            buttons[0][11] = L1C12;
            buttons[0][12] = L1C13;
            buttons[1][0] = L2C1;
            buttons[1][1] = L2C2;
            buttons[1][2] = L2C3;
            buttons[1][3] = L2C4;
            buttons[1][4] = L2C5;
            buttons[1][5] = L2C6;
            buttons[1][6] = L2C7;
            buttons[1][7] = L2C8;
            buttons[1][8] = L2C9;
            buttons[1][9] = L2C10;
            buttons[1][10] = L2C11;
            buttons[1][11] = L2C12;
            buttons[1][12] = L2C13;
            buttons[2][0] = L3C1;
            buttons[3][0] = L4C1;
            buttons[4][0] = L5C1;
            buttons[5][0] = L6C1;
            buttons[6][0] = L7C1;
            buttons[2][1] = L3C2;
            buttons[3][1] = L4C2;
            buttons[4][1] = L5C2;
            buttons[5][1] = L6C2;
            buttons[6][1] = L7C2;
            buttons[2][2] = L3C3;
            buttons[3][2] = L4C3;
            buttons[4][2] = L5C3;
            buttons[5][2] = L6C3;
            buttons[6][2] = L7C3;
            buttons[2][3] = L3C4;
            buttons[3][3] = L4C4;
            buttons[4][3] = L5C4;
            buttons[5][3] = L6C4;
            buttons[6][3] = L7C4;
            buttons[2][4] = L3C5;
            buttons[3][4] = L4C5;
            buttons[4][4] = L5C5;
            buttons[5][4] = L6C5;
            buttons[6][4] = L7C5;
            buttons[2][5] = L3C6;
            buttons[3][5] = L4C6;
            buttons[4][5] = L5C6;
            buttons[5][5] = L6C6;
            buttons[6][5] = L7C6;
            buttons[2][6] = L3C7;
            buttons[3][6] = L4C7;
            buttons[4][6] = L5C7;
            buttons[5][6] = L6C7;
            buttons[6][6] = L7C7;
            buttons[2][7] = L3C8;
            buttons[3][7] = L4C8;
            buttons[4][7] = L5C8;
            buttons[5][7] = L6C8;
            buttons[6][7] = L7C8;
            buttons[2][8] = L3C9;
            buttons[3][8] = L4C9;
            buttons[4][8] = L5C9;
            buttons[5][8] = L6C9;
            buttons[6][8] = L7C9;
            buttons[2][9] = L3C10;
            buttons[3][9] = L4C10;
            buttons[4][9] = L5C10;
            buttons[5][9] = L6C10;
            buttons[6][9] = L7C10;
            buttons[2][10] = L3C11;
            buttons[3][10] = L4C11;
            buttons[4][10] = L5C11;
            buttons[5][10] = L6C11;
            buttons[6][10] = L7C11;
            buttons[2][11] = L3C12;
            buttons[3][11] = L4C12;
            buttons[4][11] = L5C12;
            buttons[5][11] = L6C12;
            buttons[6][11] = L7C12;
            buttons[2][12] = L3C13;
            buttons[3][12] = L4C13;
            buttons[4][12] = L5C13;
            buttons[5][12] = L6C13;
            buttons[6][12] = L7C13;
        }
        scorelabels[0] = scoreHearts;
        scorelabels[1] = scoreSpades;
        scorelabels[2] = scoreClubs;
        scorelabels[3] = scoreDiamonds;

        playareapanes[0] = Column1;
        playareapanes[1] = Column2;
        playareapanes[2] = Column3;
        playareapanes[3] = Column4;
        playareapanes[4] = Column5;
        playareapanes[5] = Column6;
        playareapanes[6] = Column7;

        facedowns[0] = L1FaceDown;
        facedowns[1] = L2FaceDown;
        facedowns[2] = L3FaceDown;
        facedowns[3] = L4FaceDown;
        facedowns[4] = L5FaceDown;
        facedowns[5] = L6FaceDown;
        facedowns[6] = L7FaceDown;

        int column = 0;
        for ( javax.swing.JButton[] buttonarray : buttons )
        {
            int depth = 0;
            for ( javax.swing.JButton button : buttonarray )
            {
                button.setText("");
                playareapanes[column].setLayer(button, depth);
                button.addActionListener(new CardButtonListener());
                button.setVisible(false);
                depth++;
            }
            column++;
        }
        discardButton.addActionListener(new CardButtonListener());
        
        for(javax.swing.JButton button:facedowns)
        {
            button.addActionListener(new EmptyPileListener());
        }
        
        
        for ( int i = 0; i < 7; i++ )
        {
            columnDisplayUpdate(i);
        }

    }

    SingleDeck singleDeck = new SingleDeck();
    ScoreArea score = new ScoreArea();
    Stack<Card> discard = new Stack<>();
    PlayArea playArea = new PlayArea(singleDeck, discard, score);
    javax.swing.JButton[][] buttons = new javax.swing.JButton[7][];
    javax.swing.JLabel[] scorelabels = new javax.swing.JLabel[4];
    javax.swing.JButton[] facedowns = new javax.swing.JButton[7];
    javax.swing.JLayeredPane[] playareapanes = new javax.swing.JLayeredPane[7];

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        moveTo = new javax.swing.JComboBox<>();
        MoveFrom = new javax.swing.JComboBox<>();
        MoveDepth = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deckButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Column1 = new javax.swing.JLayeredPane();
        L1C5 = new javax.swing.JButton();
        L1C6 = new javax.swing.JButton();
        L1C7 = new javax.swing.JButton();
        L1C8 = new javax.swing.JButton();
        L1C9 = new javax.swing.JButton();
        L1C10 = new javax.swing.JButton();
        L1C13 = new javax.swing.JButton();
        L1C11 = new javax.swing.JButton();
        L1C4 = new javax.swing.JButton();
        L1C12 = new javax.swing.JButton();
        L1C3 = new javax.swing.JButton();
        L1C2 = new javax.swing.JButton();
        L1C1 = new javax.swing.JButton();
        L1FaceDown = new javax.swing.JButton();
        Column2 = new javax.swing.JLayeredPane();
        L2C5 = new javax.swing.JButton();
        L2C6 = new javax.swing.JButton();
        L2C7 = new javax.swing.JButton();
        L2C8 = new javax.swing.JButton();
        L2C9 = new javax.swing.JButton();
        L2C10 = new javax.swing.JButton();
        L2C11 = new javax.swing.JButton();
        L2C12 = new javax.swing.JButton();
        L2C13 = new javax.swing.JButton();
        L2C2 = new javax.swing.JButton();
        L2C4 = new javax.swing.JButton();
        L2C3 = new javax.swing.JButton();
        L2C1 = new javax.swing.JButton();
        L2FaceDown = new javax.swing.JButton();
        Column4 = new javax.swing.JLayeredPane();
        L4C5 = new javax.swing.JButton();
        L4C6 = new javax.swing.JButton();
        L4C7 = new javax.swing.JButton();
        L4C8 = new javax.swing.JButton();
        L4C9 = new javax.swing.JButton();
        L4C10 = new javax.swing.JButton();
        L4C11 = new javax.swing.JButton();
        L4C12 = new javax.swing.JButton();
        L4C13 = new javax.swing.JButton();
        L4C4 = new javax.swing.JButton();
        L4C3 = new javax.swing.JButton();
        L4C2 = new javax.swing.JButton();
        L4C1 = new javax.swing.JButton();
        L4FaceDown = new javax.swing.JButton();
        Column5 = new javax.swing.JLayeredPane();
        L5C5 = new javax.swing.JButton();
        L5C6 = new javax.swing.JButton();
        L5C7 = new javax.swing.JButton();
        L5C8 = new javax.swing.JButton();
        L5C9 = new javax.swing.JButton();
        L5C10 = new javax.swing.JButton();
        L5C11 = new javax.swing.JButton();
        L5C12 = new javax.swing.JButton();
        L5C13 = new javax.swing.JButton();
        L5C2 = new javax.swing.JButton();
        L5C4 = new javax.swing.JButton();
        L5C3 = new javax.swing.JButton();
        L5C1 = new javax.swing.JButton();
        L5FaceDown = new javax.swing.JButton();
        Column6 = new javax.swing.JLayeredPane();
        L6C5 = new javax.swing.JButton();
        L6C6 = new javax.swing.JButton();
        L6C7 = new javax.swing.JButton();
        L6C8 = new javax.swing.JButton();
        L6C9 = new javax.swing.JButton();
        L6C10 = new javax.swing.JButton();
        L6C11 = new javax.swing.JButton();
        L6C12 = new javax.swing.JButton();
        L6C13 = new javax.swing.JButton();
        L6C4 = new javax.swing.JButton();
        L6C3 = new javax.swing.JButton();
        L6C2 = new javax.swing.JButton();
        L6C1 = new javax.swing.JButton();
        L6FaceDown = new javax.swing.JButton();
        Column7 = new javax.swing.JLayeredPane();
        L7C9 = new javax.swing.JButton();
        L7C10 = new javax.swing.JButton();
        L7C13 = new javax.swing.JButton();
        L7C12 = new javax.swing.JButton();
        L7C11 = new javax.swing.JButton();
        L7C8 = new javax.swing.JButton();
        L7C7 = new javax.swing.JButton();
        L7C6 = new javax.swing.JButton();
        L7C5 = new javax.swing.JButton();
        L7C4 = new javax.swing.JButton();
        L7C3 = new javax.swing.JButton();
        L7C2 = new javax.swing.JButton();
        L7C1 = new javax.swing.JButton();
        L7FaceDown = new javax.swing.JButton();
        Column3 = new javax.swing.JLayeredPane();
        L3C5 = new javax.swing.JButton();
        L3C6 = new javax.swing.JButton();
        L3C7 = new javax.swing.JButton();
        L3C8 = new javax.swing.JButton();
        L3C9 = new javax.swing.JButton();
        L3C10 = new javax.swing.JButton();
        L3C11 = new javax.swing.JButton();
        L3C12 = new javax.swing.JButton();
        L3C13 = new javax.swing.JButton();
        L3C2 = new javax.swing.JButton();
        L3C4 = new javax.swing.JButton();
        L3C3 = new javax.swing.JButton();
        L3C1 = new javax.swing.JButton();
        L3FaceDown = new javax.swing.JButton();
        MakeMoveButton = new javax.swing.JButton();
        scoreHearts = new javax.swing.JLabel();
        scoreSpades = new javax.swing.JLabel();
        scoreClubs = new javax.swing.JLabel();
        scoreDiamonds = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        moveTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6", "Column 7", "Discard", "Score" }));

        MoveFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6", "Column 7", "Discard" }));
        MoveFrom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MoveFromActionPerformed(evt);
            }
        });

        MoveDepth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", " " }));
        MoveDepth.setEnabled(false);

        jLabel1.setText("To");

        jLabel2.setText("From");

        jLabel3.setText("Number of Cards");

        deckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        deckButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deckButtonActionPerformed(evt);
            }
        });

        discardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        discardButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                discardButtonActionPerformed(evt);
            }
        });

        Column1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        Column1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L1C5.setText("1");
        L1C5.setBorderPainted(false);
        buttonGroup1.add(L1C5);
        L1C5.setContentAreaFilled(false);
        L1C5.setFocusPainted(false);
        L1C5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C5ActionPerformed(evt);
            }
        });
        Column1.add(L1C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 337, -1, -1));

        L1C6.setText("1");
        L1C6.setBorderPainted(false);
        buttonGroup1.add(L1C6);
        L1C6.setContentAreaFilled(false);
        L1C6.setFocusPainted(false);
        L1C6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C6ActionPerformed(evt);
            }
        });
        Column1.add(L1C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 365, -1, -1));

        L1C7.setText("1");
        L1C7.setBorderPainted(false);
        buttonGroup1.add(L1C7);
        L1C7.setContentAreaFilled(false);
        L1C7.setFocusPainted(false);
        L1C7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C7ActionPerformed(evt);
            }
        });
        Column1.add(L1C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 393, -1, -1));

        L1C8.setText("1");
        L1C8.setBorderPainted(false);
        buttonGroup1.add(L1C8);
        L1C8.setContentAreaFilled(false);
        L1C8.setFocusPainted(false);
        L1C8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C8ActionPerformed(evt);
            }
        });
        Column1.add(L1C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 421, -1, -1));

        L1C9.setText("1");
        L1C9.setBorderPainted(false);
        buttonGroup1.add(L1C9);
        L1C9.setContentAreaFilled(false);
        L1C9.setFocusPainted(false);
        L1C9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C9ActionPerformed(evt);
            }
        });
        Column1.add(L1C9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 449, -1, -1));

        L1C10.setText("1");
        L1C10.setBorderPainted(false);
        buttonGroup1.add(L1C10);
        L1C10.setContentAreaFilled(false);
        L1C10.setFocusPainted(false);
        L1C10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C10ActionPerformed(evt);
            }
        });
        Column1.add(L1C10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 477, -1, -1));

        L1C13.setText("1");
        L1C13.setBorderPainted(false);
        buttonGroup1.add(L1C13);
        L1C13.setContentAreaFilled(false);
        L1C13.setFocusPainted(false);
        L1C13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C13ActionPerformed(evt);
            }
        });
        Column1.add(L1C13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 561, -1, -1));

        L1C11.setText("1");
        L1C11.setBorderPainted(false);
        buttonGroup1.add(L1C11);
        L1C11.setContentAreaFilled(false);
        L1C11.setFocusPainted(false);
        L1C11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C11ActionPerformed(evt);
            }
        });
        Column1.add(L1C11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 505, -1, -1));

        L1C4.setText("1");
        L1C4.setBorderPainted(false);
        buttonGroup1.add(L1C4);
        L1C4.setContentAreaFilled(false);
        L1C4.setFocusPainted(false);
        L1C4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C4ActionPerformed(evt);
            }
        });
        Column1.add(L1C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 309, -1, -1));

        L1C12.setText("1");
        L1C12.setBorderPainted(false);
        buttonGroup1.add(L1C12);
        L1C12.setContentAreaFilled(false);
        L1C12.setFocusPainted(false);
        L1C12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C12ActionPerformed(evt);
            }
        });
        Column1.add(L1C12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 533, -1, -1));

        L1C3.setText("1");
        L1C3.setBorderPainted(false);
        buttonGroup1.add(L1C3);
        L1C3.setContentAreaFilled(false);
        L1C3.setFocusPainted(false);
        L1C3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C3ActionPerformed(evt);
            }
        });
        Column1.add(L1C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 281, -1, -1));

        L1C2.setText("1");
        L1C2.setBorderPainted(false);
        buttonGroup1.add(L1C2);
        L1C2.setContentAreaFilled(false);
        L1C2.setFocusPainted(false);
        L1C2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C2ActionPerformed(evt);
            }
        });
        Column1.add(L1C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 253, -1, -1));

        L1C1.setText("1");
        L1C1.setBorderPainted(false);
        buttonGroup1.add(L1C1);
        L1C1.setContentAreaFilled(false);
        L1C1.setFocusPainted(false);
        L1C1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L1C1ActionPerformed(evt);
            }
        });
        Column1.add(L1C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 225, -1, -1));

        L1FaceDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        L1FaceDown.setEnabled(false);
        Column1.add(L1FaceDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, -1));

        Column2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        Column2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L2C5.setText("1");
        L2C5.setBorderPainted(false);
        buttonGroup1.add(L2C5);
        L2C5.setContentAreaFilled(false);
        L2C5.setFocusPainted(false);
        L2C5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C5ActionPerformed(evt);
            }
        });
        Column2.add(L2C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 337, -1, -1));

        L2C6.setText("1");
        L2C6.setBorderPainted(false);
        buttonGroup1.add(L2C6);
        L2C6.setContentAreaFilled(false);
        L2C6.setFocusPainted(false);
        L2C6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C6ActionPerformed(evt);
            }
        });
        Column2.add(L2C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 365, -1, -1));

        L2C7.setText("1");
        L2C7.setBorderPainted(false);
        buttonGroup1.add(L2C7);
        L2C7.setContentAreaFilled(false);
        L2C7.setFocusPainted(false);
        L2C7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C7ActionPerformed(evt);
            }
        });
        Column2.add(L2C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 393, -1, -1));

        L2C8.setText("1");
        L2C8.setBorderPainted(false);
        buttonGroup1.add(L2C8);
        L2C8.setContentAreaFilled(false);
        L2C8.setFocusPainted(false);
        L2C8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C8ActionPerformed(evt);
            }
        });
        Column2.add(L2C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 421, -1, -1));

        L2C9.setText("1");
        L2C9.setBorderPainted(false);
        buttonGroup1.add(L2C9);
        L2C9.setContentAreaFilled(false);
        L2C9.setFocusPainted(false);
        L2C9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C9ActionPerformed(evt);
            }
        });
        Column2.add(L2C9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 449, -1, -1));

        L2C10.setText("1");
        L2C10.setBorderPainted(false);
        buttonGroup1.add(L2C10);
        L2C10.setContentAreaFilled(false);
        L2C10.setFocusPainted(false);
        L2C10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C10ActionPerformed(evt);
            }
        });
        Column2.add(L2C10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 477, -1, -1));

        L2C11.setText("1");
        L2C11.setBorderPainted(false);
        buttonGroup1.add(L2C11);
        L2C11.setContentAreaFilled(false);
        L2C11.setFocusPainted(false);
        L2C11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C11ActionPerformed(evt);
            }
        });
        Column2.add(L2C11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 505, -1, -1));

        L2C12.setText("1");
        L2C12.setBorderPainted(false);
        buttonGroup1.add(L2C12);
        L2C12.setContentAreaFilled(false);
        L2C12.setFocusPainted(false);
        L2C12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C12ActionPerformed(evt);
            }
        });
        Column2.add(L2C12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 533, -1, -1));

        L2C13.setText("1");
        L2C13.setBorderPainted(false);
        buttonGroup1.add(L2C13);
        L2C13.setContentAreaFilled(false);
        L2C13.setFocusPainted(false);
        L2C13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C13ActionPerformed(evt);
            }
        });
        Column2.add(L2C13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 561, -1, -1));

        L2C2.setText("1");
        L2C2.setBorderPainted(false);
        buttonGroup1.add(L2C2);
        L2C2.setContentAreaFilled(false);
        L2C2.setFocusPainted(false);
        L2C2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C2ActionPerformed(evt);
            }
        });
        Column2.add(L2C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 258, -1, -1));

        L2C4.setText("1");
        L2C4.setBorderPainted(false);
        buttonGroup1.add(L2C4);
        L2C4.setContentAreaFilled(false);
        L2C4.setFocusPainted(false);
        L2C4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C4ActionPerformed(evt);
            }
        });
        Column2.add(L2C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 309, -1, -1));

        L2C3.setText("1");
        L2C3.setBorderPainted(false);
        buttonGroup1.add(L2C3);
        L2C3.setContentAreaFilled(false);
        L2C3.setFocusPainted(false);
        L2C3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C3ActionPerformed(evt);
            }
        });
        Column2.add(L2C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 281, -1, -1));

        L2C1.setText("1");
        L2C1.setBorderPainted(false);
        buttonGroup1.add(L2C1);
        L2C1.setContentAreaFilled(false);
        L2C1.setFocusPainted(false);
        L2C1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L2C1ActionPerformed(evt);
            }
        });
        Column2.add(L2C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 230, -1, -1));

        L2FaceDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        L2FaceDown.setEnabled(false);
        Column2.add(L2FaceDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, -1));

        Column4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        Column4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L4C5.setText("1");
        L4C5.setBorderPainted(false);
        buttonGroup1.add(L4C5);
        L4C5.setContentAreaFilled(false);
        L4C5.setFocusPainted(false);
        L4C5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C5ActionPerformed(evt);
            }
        });
        Column4.add(L4C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 342, -1, -1));

        L4C6.setText("1");
        L4C6.setBorderPainted(false);
        buttonGroup1.add(L4C6);
        L4C6.setContentAreaFilled(false);
        L4C6.setFocusPainted(false);
        L4C6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C6ActionPerformed(evt);
            }
        });
        Column4.add(L4C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 370, -1, -1));

        L4C7.setText("1");
        L4C7.setBorderPainted(false);
        buttonGroup1.add(L4C7);
        L4C7.setContentAreaFilled(false);
        L4C7.setFocusPainted(false);
        L4C7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C7ActionPerformed(evt);
            }
        });
        Column4.add(L4C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 398, -1, -1));

        L4C8.setText("1");
        L4C8.setBorderPainted(false);
        buttonGroup1.add(L4C8);
        L4C8.setContentAreaFilled(false);
        L4C8.setFocusPainted(false);
        L4C8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C8ActionPerformed(evt);
            }
        });
        Column4.add(L4C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 426, -1, -1));

        L4C9.setText("1");
        L4C9.setBorderPainted(false);
        buttonGroup1.add(L4C9);
        L4C9.setContentAreaFilled(false);
        L4C9.setFocusPainted(false);
        L4C9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C9ActionPerformed(evt);
            }
        });
        Column4.add(L4C9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 454, -1, -1));

        L4C10.setText("1");
        L4C10.setBorderPainted(false);
        buttonGroup1.add(L4C10);
        L4C10.setContentAreaFilled(false);
        L4C10.setFocusPainted(false);
        L4C10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C10ActionPerformed(evt);
            }
        });
        Column4.add(L4C10, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 482, -1, -1));

        L4C11.setText("1");
        L4C11.setBorderPainted(false);
        buttonGroup1.add(L4C11);
        L4C11.setContentAreaFilled(false);
        L4C11.setFocusPainted(false);
        L4C11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C11ActionPerformed(evt);
            }
        });
        Column4.add(L4C11, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 510, -1, -1));

        L4C12.setText("1");
        L4C12.setBorderPainted(false);
        buttonGroup1.add(L4C12);
        L4C12.setContentAreaFilled(false);
        L4C12.setFocusPainted(false);
        L4C12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C12ActionPerformed(evt);
            }
        });
        Column4.add(L4C12, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 538, -1, -1));

        L4C13.setText("1");
        L4C13.setBorderPainted(false);
        buttonGroup1.add(L4C13);
        L4C13.setContentAreaFilled(false);
        L4C13.setFocusPainted(false);
        L4C13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C13ActionPerformed(evt);
            }
        });
        Column4.add(L4C13, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 566, -1, -1));

        L4C4.setText("1");
        L4C4.setBorderPainted(false);
        buttonGroup1.add(L4C4);
        L4C4.setContentAreaFilled(false);
        L4C4.setFocusPainted(false);
        L4C4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C4ActionPerformed(evt);
            }
        });
        Column4.add(L4C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 314, -1, -1));

        L4C3.setText("1");
        L4C3.setBorderPainted(false);
        buttonGroup1.add(L4C3);
        L4C3.setContentAreaFilled(false);
        L4C3.setFocusPainted(false);
        L4C3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C3ActionPerformed(evt);
            }
        });
        Column4.add(L4C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 286, -1, -1));

        L4C2.setText("1");
        L4C2.setBorderPainted(false);
        buttonGroup1.add(L4C2);
        L4C2.setContentAreaFilled(false);
        L4C2.setFocusPainted(false);
        L4C2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C2ActionPerformed(evt);
            }
        });
        Column4.add(L4C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 258, -1, -1));

        L4C1.setText("1");
        L4C1.setBorderPainted(false);
        buttonGroup1.add(L4C1);
        L4C1.setContentAreaFilled(false);
        L4C1.setFocusPainted(false);
        L4C1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L4C1ActionPerformed(evt);
            }
        });
        Column4.add(L4C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 230, -1, -1));

        L4FaceDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        L4FaceDown.setEnabled(false);
        Column4.add(L4FaceDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, -1));

        Column5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        Column5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L5C5.setText("1");
        L5C5.setBorderPainted(false);
        buttonGroup1.add(L5C5);
        L5C5.setContentAreaFilled(false);
        L5C5.setFocusPainted(false);
        L5C5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C5ActionPerformed(evt);
            }
        });
        Column5.add(L5C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 342, -1, -1));

        L5C6.setText("1");
        L5C6.setBorderPainted(false);
        buttonGroup1.add(L5C6);
        L5C6.setContentAreaFilled(false);
        L5C6.setFocusPainted(false);
        L5C6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C6ActionPerformed(evt);
            }
        });
        Column5.add(L5C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 370, -1, -1));

        L5C7.setText("1");
        L5C7.setBorderPainted(false);
        buttonGroup1.add(L5C7);
        L5C7.setContentAreaFilled(false);
        L5C7.setFocusPainted(false);
        L5C7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C7ActionPerformed(evt);
            }
        });
        Column5.add(L5C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 398, -1, -1));

        L5C8.setText("1");
        L5C8.setBorderPainted(false);
        buttonGroup1.add(L5C8);
        L5C8.setContentAreaFilled(false);
        L5C8.setFocusPainted(false);
        L5C8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C8ActionPerformed(evt);
            }
        });
        Column5.add(L5C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 426, -1, -1));

        L5C9.setText("1");
        L5C9.setBorderPainted(false);
        buttonGroup1.add(L5C9);
        L5C9.setContentAreaFilled(false);
        L5C9.setFocusPainted(false);
        L5C9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C9ActionPerformed(evt);
            }
        });
        Column5.add(L5C9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 454, -1, -1));

        L5C10.setText("1");
        L5C10.setBorderPainted(false);
        buttonGroup1.add(L5C10);
        L5C10.setContentAreaFilled(false);
        L5C10.setFocusPainted(false);
        L5C10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C10ActionPerformed(evt);
            }
        });
        Column5.add(L5C10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 482, -1, -1));

        L5C11.setText("1");
        L5C11.setBorderPainted(false);
        buttonGroup1.add(L5C11);
        L5C11.setContentAreaFilled(false);
        L5C11.setFocusPainted(false);
        L5C11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C11ActionPerformed(evt);
            }
        });
        Column5.add(L5C11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 510, -1, -1));

        L5C12.setText("1");
        L5C12.setBorderPainted(false);
        buttonGroup1.add(L5C12);
        L5C12.setContentAreaFilled(false);
        L5C12.setFocusPainted(false);
        L5C12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C12ActionPerformed(evt);
            }
        });
        Column5.add(L5C12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 538, -1, -1));

        L5C13.setText("1");
        L5C13.setBorderPainted(false);
        buttonGroup1.add(L5C13);
        L5C13.setContentAreaFilled(false);
        L5C13.setFocusPainted(false);
        L5C13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C13ActionPerformed(evt);
            }
        });
        Column5.add(L5C13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 566, -1, -1));

        L5C2.setText("1");
        L5C2.setBorderPainted(false);
        buttonGroup1.add(L5C2);
        L5C2.setContentAreaFilled(false);
        L5C2.setFocusPainted(false);
        L5C2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C2ActionPerformed(evt);
            }
        });
        Column5.add(L5C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 258, -1, -1));

        L5C4.setText("1");
        L5C4.setBorderPainted(false);
        buttonGroup1.add(L5C4);
        L5C4.setContentAreaFilled(false);
        L5C4.setFocusPainted(false);
        L5C4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C4ActionPerformed(evt);
            }
        });
        Column5.add(L5C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 314, -1, -1));

        L5C3.setText("1");
        L5C3.setBorderPainted(false);
        buttonGroup1.add(L5C3);
        L5C3.setContentAreaFilled(false);
        L5C3.setFocusPainted(false);
        L5C3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C3ActionPerformed(evt);
            }
        });
        Column5.add(L5C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 286, -1, -1));

        L5C1.setText("1");
        L5C1.setBorderPainted(false);
        buttonGroup1.add(L5C1);
        L5C1.setContentAreaFilled(false);
        L5C1.setFocusPainted(false);
        L5C1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L5C1ActionPerformed(evt);
            }
        });
        Column5.add(L5C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 230, -1, -1));

        L5FaceDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        L5FaceDown.setEnabled(false);
        Column5.add(L5FaceDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, -1));

        Column6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        Column6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L6C5.setText("1");
        L6C5.setBorderPainted(false);
        buttonGroup1.add(L6C5);
        L6C5.setContentAreaFilled(false);
        L6C5.setFocusPainted(false);
        L6C5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C5ActionPerformed(evt);
            }
        });
        Column6.add(L6C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 342, -1, -1));

        L6C6.setText("1");
        L6C6.setBorderPainted(false);
        buttonGroup1.add(L6C6);
        L6C6.setContentAreaFilled(false);
        L6C6.setFocusPainted(false);
        L6C6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C6ActionPerformed(evt);
            }
        });
        Column6.add(L6C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 370, -1, -1));

        L6C7.setText("1");
        L6C7.setBorderPainted(false);
        buttonGroup1.add(L6C7);
        L6C7.setContentAreaFilled(false);
        L6C7.setFocusPainted(false);
        L6C7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C7ActionPerformed(evt);
            }
        });
        Column6.add(L6C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 398, -1, -1));

        L6C8.setText("1");
        L6C8.setBorderPainted(false);
        buttonGroup1.add(L6C8);
        L6C8.setContentAreaFilled(false);
        L6C8.setFocusPainted(false);
        L6C8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C8ActionPerformed(evt);
            }
        });
        Column6.add(L6C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 426, -1, -1));

        L6C9.setText("1");
        L6C9.setBorderPainted(false);
        buttonGroup1.add(L6C9);
        L6C9.setContentAreaFilled(false);
        L6C9.setFocusPainted(false);
        L6C9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C9ActionPerformed(evt);
            }
        });
        Column6.add(L6C9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 454, -1, -1));

        L6C10.setText("1");
        L6C10.setBorderPainted(false);
        buttonGroup1.add(L6C10);
        L6C10.setContentAreaFilled(false);
        L6C10.setFocusPainted(false);
        L6C10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C10ActionPerformed(evt);
            }
        });
        Column6.add(L6C10, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 482, -1, -1));

        L6C11.setText("1");
        L6C11.setBorderPainted(false);
        buttonGroup1.add(L6C11);
        L6C11.setContentAreaFilled(false);
        L6C11.setFocusPainted(false);
        L6C11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C11ActionPerformed(evt);
            }
        });
        Column6.add(L6C11, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 510, -1, -1));

        L6C12.setText("1");
        L6C12.setBorderPainted(false);
        buttonGroup1.add(L6C12);
        L6C12.setContentAreaFilled(false);
        L6C12.setFocusPainted(false);
        L6C12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C12ActionPerformed(evt);
            }
        });
        Column6.add(L6C12, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 538, -1, -1));

        L6C13.setText("1");
        L6C13.setBorderPainted(false);
        buttonGroup1.add(L6C13);
        L6C13.setContentAreaFilled(false);
        L6C13.setFocusPainted(false);
        L6C13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C13ActionPerformed(evt);
            }
        });
        Column6.add(L6C13, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 566, -1, -1));

        L6C4.setText("1");
        L6C4.setBorderPainted(false);
        buttonGroup1.add(L6C4);
        L6C4.setContentAreaFilled(false);
        L6C4.setFocusPainted(false);
        L6C4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C4ActionPerformed(evt);
            }
        });
        Column6.add(L6C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 314, -1, -1));

        L6C3.setText("1");
        L6C3.setBorderPainted(false);
        buttonGroup1.add(L6C3);
        L6C3.setContentAreaFilled(false);
        L6C3.setFocusPainted(false);
        L6C3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C3ActionPerformed(evt);
            }
        });
        Column6.add(L6C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 286, -1, -1));

        L6C2.setText("1");
        L6C2.setBorderPainted(false);
        buttonGroup1.add(L6C2);
        L6C2.setContentAreaFilled(false);
        L6C2.setFocusPainted(false);
        L6C2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C2ActionPerformed(evt);
            }
        });
        Column6.add(L6C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 258, -1, -1));

        L6C1.setText("1");
        L6C1.setBorderPainted(false);
        buttonGroup1.add(L6C1);
        L6C1.setContentAreaFilled(false);
        L6C1.setFocusPainted(false);
        L6C1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L6C1ActionPerformed(evt);
            }
        });
        Column6.add(L6C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 230, -1, -1));

        L6FaceDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        L6FaceDown.setEnabled(false);
        Column6.add(L6FaceDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, -1));

        Column7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        Column7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L7C9.setText("1");
        L7C9.setBorderPainted(false);
        buttonGroup1.add(L7C9);
        L7C9.setContentAreaFilled(false);
        L7C9.setFocusPainted(false);
        L7C9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C9ActionPerformed(evt);
            }
        });
        Column7.add(L7C9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 454, -1, -1));

        L7C10.setText("1");
        L7C10.setBorderPainted(false);
        buttonGroup1.add(L7C10);
        L7C10.setContentAreaFilled(false);
        L7C10.setFocusPainted(false);
        L7C10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C10ActionPerformed(evt);
            }
        });
        Column7.add(L7C10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 482, -1, -1));

        L7C13.setText("1");
        L7C13.setBorderPainted(false);
        buttonGroup1.add(L7C13);
        L7C13.setContentAreaFilled(false);
        L7C13.setFocusPainted(false);
        L7C13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C13ActionPerformed(evt);
            }
        });
        Column7.add(L7C13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 566, -1, -1));

        L7C12.setText("1");
        L7C12.setBorderPainted(false);
        buttonGroup1.add(L7C12);
        L7C12.setContentAreaFilled(false);
        L7C12.setFocusPainted(false);
        L7C12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C12ActionPerformed(evt);
            }
        });
        Column7.add(L7C12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 538, -1, -1));

        L7C11.setText("1");
        L7C11.setBorderPainted(false);
        buttonGroup1.add(L7C11);
        L7C11.setContentAreaFilled(false);
        L7C11.setFocusPainted(false);
        L7C11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C11ActionPerformed(evt);
            }
        });
        Column7.add(L7C11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 510, -1, -1));

        L7C8.setText("1");
        L7C8.setBorderPainted(false);
        buttonGroup1.add(L7C8);
        L7C8.setContentAreaFilled(false);
        L7C8.setFocusPainted(false);
        L7C8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C8ActionPerformed(evt);
            }
        });
        Column7.add(L7C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 426, -1, -1));

        L7C7.setText("1");
        L7C7.setBorderPainted(false);
        buttonGroup1.add(L7C7);
        L7C7.setContentAreaFilled(false);
        L7C7.setFocusPainted(false);
        L7C7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C7ActionPerformed(evt);
            }
        });
        Column7.add(L7C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 398, -1, -1));

        L7C6.setText("1");
        L7C6.setBorderPainted(false);
        buttonGroup1.add(L7C6);
        L7C6.setContentAreaFilled(false);
        L7C6.setFocusPainted(false);
        L7C6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C6ActionPerformed(evt);
            }
        });
        Column7.add(L7C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 370, -1, -1));

        L7C5.setText("1");
        L7C5.setBorderPainted(false);
        buttonGroup1.add(L7C5);
        L7C5.setContentAreaFilled(false);
        L7C5.setFocusPainted(false);
        L7C5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C5ActionPerformed(evt);
            }
        });
        Column7.add(L7C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 342, -1, -1));

        L7C4.setText("1");
        L7C4.setBorderPainted(false);
        buttonGroup1.add(L7C4);
        L7C4.setContentAreaFilled(false);
        L7C4.setFocusPainted(false);
        L7C4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C4ActionPerformed(evt);
            }
        });
        Column7.add(L7C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 314, -1, -1));

        L7C3.setText("1");
        L7C3.setBorderPainted(false);
        buttonGroup1.add(L7C3);
        L7C3.setContentAreaFilled(false);
        L7C3.setFocusPainted(false);
        L7C3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C3ActionPerformed(evt);
            }
        });
        Column7.add(L7C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 286, -1, -1));

        L7C2.setText("1");
        L7C2.setBorderPainted(false);
        buttonGroup1.add(L7C2);
        L7C2.setContentAreaFilled(false);
        L7C2.setFocusPainted(false);
        L7C2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C2ActionPerformed(evt);
            }
        });
        Column7.add(L7C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 258, -1, -1));

        L7C1.setText("1");
        L7C1.setBorderPainted(false);
        buttonGroup1.add(L7C1);
        L7C1.setContentAreaFilled(false);
        L7C1.setFocusPainted(false);
        L7C1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L7C1ActionPerformed(evt);
            }
        });
        Column7.add(L7C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 228, -1, -1));

        L7FaceDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        L7FaceDown.setEnabled(false);
        Column7.add(L7FaceDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, -1));

        Column3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        Column3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L3C5.setText("1");
        L3C5.setBorderPainted(false);
        buttonGroup1.add(L3C5);
        L3C5.setContentAreaFilled(false);
        L3C5.setFocusPainted(false);
        L3C5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C5ActionPerformed(evt);
            }
        });
        Column3.add(L3C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 342, -1, -1));

        L3C6.setText("1");
        L3C6.setBorderPainted(false);
        buttonGroup1.add(L3C6);
        L3C6.setContentAreaFilled(false);
        L3C6.setFocusPainted(false);
        L3C6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C6ActionPerformed(evt);
            }
        });
        Column3.add(L3C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 370, -1, -1));

        L3C7.setText("1");
        L3C7.setBorderPainted(false);
        buttonGroup1.add(L3C7);
        L3C7.setContentAreaFilled(false);
        L3C7.setFocusPainted(false);
        L3C7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C7ActionPerformed(evt);
            }
        });
        Column3.add(L3C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 398, -1, -1));

        L3C8.setText("1");
        L3C8.setBorderPainted(false);
        buttonGroup1.add(L3C8);
        L3C8.setContentAreaFilled(false);
        L3C8.setFocusPainted(false);
        L3C8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C8ActionPerformed(evt);
            }
        });
        Column3.add(L3C8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 426, -1, -1));

        L3C9.setText("1");
        L3C9.setBorderPainted(false);
        buttonGroup1.add(L3C9);
        L3C9.setContentAreaFilled(false);
        L3C9.setFocusPainted(false);
        L3C9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C9ActionPerformed(evt);
            }
        });
        Column3.add(L3C9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 454, -1, -1));

        L3C10.setText("1");
        L3C10.setBorderPainted(false);
        buttonGroup1.add(L3C10);
        L3C10.setContentAreaFilled(false);
        L3C10.setFocusPainted(false);
        L3C10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C10ActionPerformed(evt);
            }
        });
        Column3.add(L3C10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 482, -1, -1));

        L3C11.setText("1");
        L3C11.setBorderPainted(false);
        buttonGroup1.add(L3C11);
        L3C11.setContentAreaFilled(false);
        L3C11.setFocusPainted(false);
        L3C11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C11ActionPerformed(evt);
            }
        });
        Column3.add(L3C11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 510, -1, -1));

        L3C12.setText("1");
        L3C12.setBorderPainted(false);
        buttonGroup1.add(L3C12);
        L3C12.setContentAreaFilled(false);
        L3C12.setFocusPainted(false);
        L3C12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C12ActionPerformed(evt);
            }
        });
        Column3.add(L3C12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 538, -1, -1));

        L3C13.setText("1");
        L3C13.setBorderPainted(false);
        buttonGroup1.add(L3C13);
        L3C13.setContentAreaFilled(false);
        L3C13.setFocusPainted(false);
        L3C13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C13ActionPerformed(evt);
            }
        });
        Column3.add(L3C13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 566, -1, -1));

        L3C2.setText("1");
        L3C2.setBorderPainted(false);
        buttonGroup1.add(L3C2);
        L3C2.setContentAreaFilled(false);
        L3C2.setFocusPainted(false);
        L3C2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C2ActionPerformed(evt);
            }
        });
        Column3.add(L3C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 258, -1, -1));

        L3C4.setText("1");
        L3C4.setBorderPainted(false);
        buttonGroup1.add(L3C4);
        L3C4.setContentAreaFilled(false);
        L3C4.setFocusPainted(false);
        L3C4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C4ActionPerformed(evt);
            }
        });
        Column3.add(L3C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 314, -1, -1));

        L3C3.setText("1");
        L3C3.setBorderPainted(false);
        buttonGroup1.add(L3C3);
        L3C3.setContentAreaFilled(false);
        L3C3.setFocusPainted(false);
        L3C3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C3ActionPerformed(evt);
            }
        });
        Column3.add(L3C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 286, -1, -1));

        L3C1.setText("1");
        L3C1.setBorderPainted(false);
        buttonGroup1.add(L3C1);
        L3C1.setContentAreaFilled(false);
        L3C1.setFocusPainted(false);
        L3C1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                L3C1ActionPerformed(evt);
            }
        });
        Column3.add(L3C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 230, -1, -1));

        L3FaceDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N
        L3FaceDown.setEnabled(false);
        Column3.add(L3FaceDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Column1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Column2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Column3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Column4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Column5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Column6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Column7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Column3)
                    .addComponent(Column1)
                    .addComponent(Column2)
                    .addComponent(Column6)
                    .addComponent(Column5)
                    .addComponent(Column4)
                    .addComponent(Column7))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        MakeMoveButton.setText("Move");
        MakeMoveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MakeMoveButtonActionPerformed(evt);
            }
        });

        scoreHearts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N

        scoreSpades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N

        scoreClubs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N

        scoreDiamonds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solitare/CardPNG/CardBack.png"))); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("This Is Solitare.\nClick on a Card to select it.\nShift+Click Where you'd like\n\tto Move it To.\n\t(WIP empty spaces)\nCtrl+Click to score a card!\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(moveTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MoveFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MoveDepth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)))
                                    .addComponent(MakeMoveButton)))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoreHearts)
                        .addGap(18, 18, 18)
                        .addComponent(scoreSpades)
                        .addGap(18, 18, 18)
                        .addComponent(scoreClubs)
                        .addGap(18, 18, 18)
                        .addComponent(scoreDiamonds)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(moveTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MoveFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MoveDepth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(MakeMoveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(discardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scoreHearts)
                            .addComponent(scoreSpades)
                            .addComponent(scoreClubs)
                            .addComponent(scoreDiamonds))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setIndecies( int indexfrom, int depth )
    {
        MoveFrom.setSelectedIndex(indexfrom);
        MoveDepth.setSelectedIndex(depth - 1);
    }
    private class EmptyPileListener implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent e )
        {
            int mod = e.getModifiers();
            boolean shift = ( ( mod & ActionEvent.SHIFT_MASK ) != 0 );
            for(int i=0;i<facedowns.length;i++)
            {
                if(e.getSource().equals(facedowns[i])&&shift)
                {
                    moveTo.setSelectedIndex(i);
                    MakeMoveButton.doClick();
                }
            }
        }
    }
    
    private class CardButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent e )
        {
            javax.swing.JButton button = ( javax.swing.JButton ) e.getSource();
            int mod = e.getModifiers();
            boolean shift = ( ( mod & ActionEvent.SHIFT_MASK ) != 0 );
            boolean ctrl = ( ( mod & ActionEvent.CTRL_MASK ) != 0 );
            if ( e.getSource().equals(discardButton) )
            {
                if ( ctrl )
                {
                    moveTo.setSelectedIndex(8);
                    MoveFrom.setSelectedIndex(7);
                    MakeMoveButton.doClick();
                }
                else
                {
                    setIndecies(7, 1);
                }
            }
            for ( int i = 0; i < buttons.length; i++ )
            {
                for ( int j = 0; j < buttons[i].length; j++ )
                {
                    if ( button.equals(buttons[i][j]) )
                    {

                        if ( shift )
                        {
                            moveTo.setSelectedIndex(i);
                            MakeMoveButton.doClick();
                        }
                        else if ( ctrl )
                        {
                            moveTo.setSelectedIndex(8);
                            MoveFrom.setSelectedIndex(i);
                            MakeMoveButton.doClick();
                        }
                        else
                        {
                            setIndecies(i, playArea.areaUp.get(i).size() - j);
                        }
                    }

                }
            }

        }
    }


    private void deckButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deckButtonActionPerformed
    {//GEN-HEADEREND:event_deckButtonActionPerformed

        try
        {
            if ( singleDeck.isEmpty() )
            {
                while ( !discard.isEmpty() )
                {
                    singleDeck.push(discard.pop());
                }
            }
            if ( !singleDeck.isEmpty() )
            {
                discard.push(singleDeck.draw());
            }
            ImageIcon icon = new ImageIcon(playArea.peekDiscard().getFace());
            discardButton.setIcon(icon);
        }
        catch ( Exception ex )
        {

        }

    }//GEN-LAST:event_deckButtonActionPerformed

    private void columnDisplayUpdate( int index )
    {
        int i = 0;
        if ( 6 >= index && index >= 0 )//card pile Icon handling
        {
            for ( Card c : playArea.areaUp.get(index) )
            {
                try
                {
                    ImageIcon icon = new ImageIcon(c.getFace());
                    buttons[index][i].setIcon(icon);
                    buttons[index][i].setEnabled(true);
                    buttons[index][i].setVisible(true);
                }
                catch ( Exception ex )
                {

                }
                i++;
            }
            for ( ; i < 12; i++ )
            {
                buttons[index][i].setEnabled(false);
                buttons[index][i].setText("");
                buttons[index][i].setVisible(false);
            }
        }
        else if ( index == 7 )//discard icon handling
        {
            try
            {
                ImageIcon icon = new ImageIcon(discard.peek().getFace());
                discardButton.setIcon(icon);
            }
            catch ( Exception ex )
            {
                ImageIcon icon = new ImageIcon(this.getClass().getResource("").getPath() +
                  "\\CardPNG\\CardBack.png");
                discardButton.setIcon(icon);
                discardButton.setEnabled(false);
            }
        }
        else if ( index == 8 )//score icon handling
        {
            try
            {
                for ( int k = 0; k < 4; k++ )
                {
                    ImageIcon icon = new ImageIcon(score.area.get(k).peek().getFace());
                    scorelabels[k].setIcon(icon);
                }
            }
            catch ( Exception ex )
            {

            }
        }
    }

    private void MakeMoveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_MakeMoveButtonActionPerformed
    {//GEN-HEADEREND:event_MakeMoveButtonActionPerformed
        int indexTo = moveTo.getSelectedIndex();
        int indexFrom = MoveFrom.getSelectedIndex();
        playArea.makeMove(indexTo, indexFrom, MoveDepth.
          getSelectedIndex() + 1);
        columnDisplayUpdate(indexTo);
        columnDisplayUpdate(indexFrom);
        if ( indexFrom <= 6 && indexFrom >= 0 & playArea.isStackEmpty(indexFrom) )
        {
            //facedowns[indexFrom].setVisible(false);
            facedowns[indexFrom].setEnabled(true);
        }
    }//GEN-LAST:event_MakeMoveButtonActionPerformed

    private void MoveFromActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_MoveFromActionPerformed
    {//GEN-HEADEREND:event_MoveFromActionPerformed
        MoveDepth.removeAllItems();
        int selection = MoveFrom.getSelectedIndex();
        switch ( selection )
        {
            case 7:
                MoveDepth.addItem(discard.peek().toString());
                break;
            default:
                for ( int i = 0; i < playArea.areaUp.get(selection).size(); i++ )
                {
                    MoveDepth.addItem("" + ( i + 1 ));
                }
                break;
        }
    }//GEN-LAST:event_MoveFromActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_discardButtonActionPerformed
    {//GEN-HEADEREND:event_discardButtonActionPerformed

    }//GEN-LAST:event_discardButtonActionPerformed

    private void L3C1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C1ActionPerformed
    {//GEN-HEADEREND:event_L3C1ActionPerformed

    }//GEN-LAST:event_L3C1ActionPerformed

    private void L3C2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C2ActionPerformed
    {//GEN-HEADEREND:event_L3C2ActionPerformed
    }//GEN-LAST:event_L3C2ActionPerformed

    private void L3C3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C3ActionPerformed
    {//GEN-HEADEREND:event_L3C3ActionPerformed
    }//GEN-LAST:event_L3C3ActionPerformed

    private void L3C4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C4ActionPerformed
    {//GEN-HEADEREND:event_L3C4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L3C4ActionPerformed

    private void L3C5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C5ActionPerformed
    {//GEN-HEADEREND:event_L3C5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L3C5ActionPerformed

    private void L3C6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C6ActionPerformed
    {//GEN-HEADEREND:event_L3C6ActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_L3C6ActionPerformed

    private void L3C7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C7ActionPerformed
    {//GEN-HEADEREND:event_L3C7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L3C7ActionPerformed

    private void L3C8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C8ActionPerformed
    {//GEN-HEADEREND:event_L3C8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L3C8ActionPerformed

    private void L3C9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C9ActionPerformed
    {//GEN-HEADEREND:event_L3C9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L3C9ActionPerformed

    private void L3C10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C10ActionPerformed
    {//GEN-HEADEREND:event_L3C10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L3C10ActionPerformed

    private void L3C11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C11ActionPerformed
    {//GEN-HEADEREND:event_L3C11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L3C11ActionPerformed

    private void L3C12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C12ActionPerformed
    {//GEN-HEADEREND:event_L3C12ActionPerformed
    }//GEN-LAST:event_L3C12ActionPerformed

    private void L3C13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L3C13ActionPerformed
    {//GEN-HEADEREND:event_L3C13ActionPerformed
    }//GEN-LAST:event_L3C13ActionPerformed

    private void L7C1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C1ActionPerformed
    {//GEN-HEADEREND:event_L7C1ActionPerformed
    }//GEN-LAST:event_L7C1ActionPerformed

    private void L7C2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C2ActionPerformed
    {//GEN-HEADEREND:event_L7C2ActionPerformed
    }//GEN-LAST:event_L7C2ActionPerformed

    private void L7C3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C3ActionPerformed
    {//GEN-HEADEREND:event_L7C3ActionPerformed
    }//GEN-LAST:event_L7C3ActionPerformed

    private void L7C4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C4ActionPerformed
    {//GEN-HEADEREND:event_L7C4ActionPerformed
    }//GEN-LAST:event_L7C4ActionPerformed

    private void L7C5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C5ActionPerformed
    {//GEN-HEADEREND:event_L7C5ActionPerformed
    }//GEN-LAST:event_L7C5ActionPerformed

    private void L7C6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C6ActionPerformed
    {//GEN-HEADEREND:event_L7C6ActionPerformed
    }//GEN-LAST:event_L7C6ActionPerformed

    private void L7C7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C7ActionPerformed
    {//GEN-HEADEREND:event_L7C7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L7C7ActionPerformed

    private void L7C8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C8ActionPerformed
    {//GEN-HEADEREND:event_L7C8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L7C8ActionPerformed

    private void L7C9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C9ActionPerformed
    {//GEN-HEADEREND:event_L7C9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L7C9ActionPerformed

    private void L7C10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C10ActionPerformed
    {//GEN-HEADEREND:event_L7C10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L7C10ActionPerformed

    private void L7C11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C11ActionPerformed
    {//GEN-HEADEREND:event_L7C11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L7C11ActionPerformed

    private void L7C12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C12ActionPerformed
    {//GEN-HEADEREND:event_L7C12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L7C12ActionPerformed

    private void L7C13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L7C13ActionPerformed
    {//GEN-HEADEREND:event_L7C13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L7C13ActionPerformed

    private void L6C1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C1ActionPerformed
    {//GEN-HEADEREND:event_L6C1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C1ActionPerformed

    private void L6C2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C2ActionPerformed
    {//GEN-HEADEREND:event_L6C2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C2ActionPerformed

    private void L6C3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C3ActionPerformed
    {//GEN-HEADEREND:event_L6C3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C3ActionPerformed

    private void L6C4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C4ActionPerformed
    {//GEN-HEADEREND:event_L6C4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C4ActionPerformed

    private void L6C5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C5ActionPerformed
    {//GEN-HEADEREND:event_L6C5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C5ActionPerformed

    private void L6C6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C6ActionPerformed
    {//GEN-HEADEREND:event_L6C6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C6ActionPerformed

    private void L6C7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C7ActionPerformed
    {//GEN-HEADEREND:event_L6C7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C7ActionPerformed

    private void L6C8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C8ActionPerformed
    {//GEN-HEADEREND:event_L6C8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C8ActionPerformed

    private void L6C9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C9ActionPerformed
    {//GEN-HEADEREND:event_L6C9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C9ActionPerformed

    private void L6C10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C10ActionPerformed
    {//GEN-HEADEREND:event_L6C10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C10ActionPerformed

    private void L6C11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C11ActionPerformed
    {//GEN-HEADEREND:event_L6C11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C11ActionPerformed

    private void L6C12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C12ActionPerformed
    {//GEN-HEADEREND:event_L6C12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C12ActionPerformed

    private void L6C13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L6C13ActionPerformed
    {//GEN-HEADEREND:event_L6C13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L6C13ActionPerformed

    private void L5C1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C1ActionPerformed
    {//GEN-HEADEREND:event_L5C1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C1ActionPerformed

    private void L5C2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C2ActionPerformed
    {//GEN-HEADEREND:event_L5C2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C2ActionPerformed

    private void L5C3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C3ActionPerformed
    {//GEN-HEADEREND:event_L5C3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C3ActionPerformed

    private void L5C4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C4ActionPerformed
    {//GEN-HEADEREND:event_L5C4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C4ActionPerformed

    private void L5C5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C5ActionPerformed
    {//GEN-HEADEREND:event_L5C5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C5ActionPerformed

    private void L5C6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C6ActionPerformed
    {//GEN-HEADEREND:event_L5C6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C6ActionPerformed

    private void L5C7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C7ActionPerformed
    {//GEN-HEADEREND:event_L5C7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C7ActionPerformed

    private void L5C8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C8ActionPerformed
    {//GEN-HEADEREND:event_L5C8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C8ActionPerformed

    private void L5C9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C9ActionPerformed
    {//GEN-HEADEREND:event_L5C9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C9ActionPerformed

    private void L5C10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C10ActionPerformed
    {//GEN-HEADEREND:event_L5C10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C10ActionPerformed

    private void L5C11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C11ActionPerformed
    {//GEN-HEADEREND:event_L5C11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C11ActionPerformed

    private void L5C12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C12ActionPerformed
    {//GEN-HEADEREND:event_L5C12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C12ActionPerformed

    private void L5C13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L5C13ActionPerformed
    {//GEN-HEADEREND:event_L5C13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L5C13ActionPerformed

    private void L4C1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C1ActionPerformed
    {//GEN-HEADEREND:event_L4C1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C1ActionPerformed

    private void L4C2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C2ActionPerformed
    {//GEN-HEADEREND:event_L4C2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C2ActionPerformed

    private void L4C3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C3ActionPerformed
    {//GEN-HEADEREND:event_L4C3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C3ActionPerformed

    private void L4C4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C4ActionPerformed
    {//GEN-HEADEREND:event_L4C4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C4ActionPerformed

    private void L4C5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C5ActionPerformed
    {//GEN-HEADEREND:event_L4C5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C5ActionPerformed

    private void L4C6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C6ActionPerformed
    {//GEN-HEADEREND:event_L4C6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C6ActionPerformed

    private void L4C7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C7ActionPerformed
    {//GEN-HEADEREND:event_L4C7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C7ActionPerformed

    private void L4C8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C8ActionPerformed
    {//GEN-HEADEREND:event_L4C8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C8ActionPerformed

    private void L4C9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C9ActionPerformed
    {//GEN-HEADEREND:event_L4C9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C9ActionPerformed

    private void L4C10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C10ActionPerformed
    {//GEN-HEADEREND:event_L4C10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C10ActionPerformed

    private void L4C11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C11ActionPerformed
    {//GEN-HEADEREND:event_L4C11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C11ActionPerformed

    private void L4C12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C12ActionPerformed
    {//GEN-HEADEREND:event_L4C12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C12ActionPerformed

    private void L4C13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L4C13ActionPerformed
    {//GEN-HEADEREND:event_L4C13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L4C13ActionPerformed

    private void L1C1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C1ActionPerformed
    {//GEN-HEADEREND:event_L1C1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C1ActionPerformed

    private void L1C2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C2ActionPerformed
    {//GEN-HEADEREND:event_L1C2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C2ActionPerformed

    private void L1C3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C3ActionPerformed
    {//GEN-HEADEREND:event_L1C3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C3ActionPerformed

    private void L1C4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C4ActionPerformed
    {//GEN-HEADEREND:event_L1C4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C4ActionPerformed

    private void L1C5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C5ActionPerformed
    {//GEN-HEADEREND:event_L1C5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C5ActionPerformed

    private void L1C6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C6ActionPerformed
    {//GEN-HEADEREND:event_L1C6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C6ActionPerformed

    private void L1C7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C7ActionPerformed
    {//GEN-HEADEREND:event_L1C7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C7ActionPerformed

    private void L1C8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C8ActionPerformed
    {//GEN-HEADEREND:event_L1C8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C8ActionPerformed

    private void L1C9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C9ActionPerformed
    {//GEN-HEADEREND:event_L1C9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C9ActionPerformed

    private void L1C10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C10ActionPerformed
    {//GEN-HEADEREND:event_L1C10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C10ActionPerformed

    private void L1C11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C11ActionPerformed
    {//GEN-HEADEREND:event_L1C11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C11ActionPerformed

    private void L1C12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C12ActionPerformed
    {//GEN-HEADEREND:event_L1C12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C12ActionPerformed

    private void L1C13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L1C13ActionPerformed
    {//GEN-HEADEREND:event_L1C13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1C13ActionPerformed

    private void L2C1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C1ActionPerformed
    {//GEN-HEADEREND:event_L2C1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C1ActionPerformed

    private void L2C2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C2ActionPerformed
    {//GEN-HEADEREND:event_L2C2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C2ActionPerformed

    private void L2C3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C3ActionPerformed
    {//GEN-HEADEREND:event_L2C3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C3ActionPerformed

    private void L2C4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C4ActionPerformed
    {//GEN-HEADEREND:event_L2C4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C4ActionPerformed

    private void L2C5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C5ActionPerformed
    {//GEN-HEADEREND:event_L2C5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C5ActionPerformed

    private void L2C6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C6ActionPerformed
    {//GEN-HEADEREND:event_L2C6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C6ActionPerformed

    private void L2C7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C7ActionPerformed
    {//GEN-HEADEREND:event_L2C7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C7ActionPerformed

    private void L2C8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C8ActionPerformed
    {//GEN-HEADEREND:event_L2C8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C8ActionPerformed

    private void L2C9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C9ActionPerformed
    {//GEN-HEADEREND:event_L2C9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C9ActionPerformed

    private void L2C10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C10ActionPerformed
    {//GEN-HEADEREND:event_L2C10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C10ActionPerformed

    private void L2C11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C11ActionPerformed
    {//GEN-HEADEREND:event_L2C11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C11ActionPerformed

    private void L2C12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C12ActionPerformed
    {//GEN-HEADEREND:event_L2C12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C12ActionPerformed

    private void L2C13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_L2C13ActionPerformed
    {//GEN-HEADEREND:event_L2C13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2C13ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main( String args[] )
    {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and
         * feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
              getInstalledLookAndFeels() )
            {
                if ( "Nimbus".equals(info.getName()) )
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch ( ClassNotFoundException ex )
        {
            java.util.logging.Logger.getLogger(PlayAreaDisplay.class.getName()).log(
              java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( InstantiationException ex )
        {
            java.util.logging.Logger.getLogger(PlayAreaDisplay.class.getName()).log(
              java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( IllegalAccessException ex )
        {
            java.util.logging.Logger.getLogger(PlayAreaDisplay.class.getName()).log(
              java.util.logging.Level.SEVERE, null, ex);
        }
        catch ( javax.swing.UnsupportedLookAndFeelException ex )
        {
            java.util.logging.Logger.getLogger(PlayAreaDisplay.class.getName()).log(
              java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PlayAreaDisplay().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Column1;
    private javax.swing.JLayeredPane Column2;
    private javax.swing.JLayeredPane Column3;
    private javax.swing.JLayeredPane Column4;
    private javax.swing.JLayeredPane Column5;
    private javax.swing.JLayeredPane Column6;
    private javax.swing.JLayeredPane Column7;
    private javax.swing.JButton L1C1;
    private javax.swing.JButton L1C10;
    private javax.swing.JButton L1C11;
    private javax.swing.JButton L1C12;
    private javax.swing.JButton L1C13;
    private javax.swing.JButton L1C2;
    private javax.swing.JButton L1C3;
    private javax.swing.JButton L1C4;
    private javax.swing.JButton L1C5;
    private javax.swing.JButton L1C6;
    private javax.swing.JButton L1C7;
    private javax.swing.JButton L1C8;
    private javax.swing.JButton L1C9;
    private javax.swing.JButton L1FaceDown;
    private javax.swing.JButton L2C1;
    private javax.swing.JButton L2C10;
    private javax.swing.JButton L2C11;
    private javax.swing.JButton L2C12;
    private javax.swing.JButton L2C13;
    private javax.swing.JButton L2C2;
    private javax.swing.JButton L2C3;
    private javax.swing.JButton L2C4;
    private javax.swing.JButton L2C5;
    private javax.swing.JButton L2C6;
    private javax.swing.JButton L2C7;
    private javax.swing.JButton L2C8;
    private javax.swing.JButton L2C9;
    private javax.swing.JButton L2FaceDown;
    private javax.swing.JButton L3C1;
    private javax.swing.JButton L3C10;
    private javax.swing.JButton L3C11;
    private javax.swing.JButton L3C12;
    private javax.swing.JButton L3C13;
    private javax.swing.JButton L3C2;
    private javax.swing.JButton L3C3;
    private javax.swing.JButton L3C4;
    private javax.swing.JButton L3C5;
    private javax.swing.JButton L3C6;
    private javax.swing.JButton L3C7;
    private javax.swing.JButton L3C8;
    private javax.swing.JButton L3C9;
    private javax.swing.JButton L3FaceDown;
    private javax.swing.JButton L4C1;
    private javax.swing.JButton L4C10;
    private javax.swing.JButton L4C11;
    private javax.swing.JButton L4C12;
    private javax.swing.JButton L4C13;
    private javax.swing.JButton L4C2;
    private javax.swing.JButton L4C3;
    private javax.swing.JButton L4C4;
    private javax.swing.JButton L4C5;
    private javax.swing.JButton L4C6;
    private javax.swing.JButton L4C7;
    private javax.swing.JButton L4C8;
    private javax.swing.JButton L4C9;
    private javax.swing.JButton L4FaceDown;
    private javax.swing.JButton L5C1;
    private javax.swing.JButton L5C10;
    private javax.swing.JButton L5C11;
    private javax.swing.JButton L5C12;
    private javax.swing.JButton L5C13;
    private javax.swing.JButton L5C2;
    private javax.swing.JButton L5C3;
    private javax.swing.JButton L5C4;
    private javax.swing.JButton L5C5;
    private javax.swing.JButton L5C6;
    private javax.swing.JButton L5C7;
    private javax.swing.JButton L5C8;
    private javax.swing.JButton L5C9;
    private javax.swing.JButton L5FaceDown;
    private javax.swing.JButton L6C1;
    private javax.swing.JButton L6C10;
    private javax.swing.JButton L6C11;
    private javax.swing.JButton L6C12;
    private javax.swing.JButton L6C13;
    private javax.swing.JButton L6C2;
    private javax.swing.JButton L6C3;
    private javax.swing.JButton L6C4;
    private javax.swing.JButton L6C5;
    private javax.swing.JButton L6C6;
    private javax.swing.JButton L6C7;
    private javax.swing.JButton L6C8;
    private javax.swing.JButton L6C9;
    private javax.swing.JButton L6FaceDown;
    private javax.swing.JButton L7C1;
    private javax.swing.JButton L7C10;
    private javax.swing.JButton L7C11;
    private javax.swing.JButton L7C12;
    private javax.swing.JButton L7C13;
    private javax.swing.JButton L7C2;
    private javax.swing.JButton L7C3;
    private javax.swing.JButton L7C4;
    private javax.swing.JButton L7C5;
    private javax.swing.JButton L7C6;
    private javax.swing.JButton L7C7;
    private javax.swing.JButton L7C8;
    private javax.swing.JButton L7C9;
    private javax.swing.JButton L7FaceDown;
    private javax.swing.JButton MakeMoveButton;
    private javax.swing.JComboBox<String> MoveDepth;
    private javax.swing.JComboBox<String> MoveFrom;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton deckButton;
    private javax.swing.JButton discardButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> moveTo;
    private javax.swing.JLabel scoreClubs;
    private javax.swing.JLabel scoreDiamonds;
    private javax.swing.JLabel scoreHearts;
    private javax.swing.JLabel scoreSpades;
    // End of variables declaration//GEN-END:variables
}
