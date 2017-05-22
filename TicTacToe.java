
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcelorsjr
 */


public class TicTacToe extends javax.swing.JFrame {

    private PlayType currentState = PlayType.CIRCLE;
    private GameController game;
    /**
     * Creates new form TicTacToe
     */
    public TicTacToe() {
        initComponents();
        blockButtonsMatrix();
        restartButton.setVisible(false);
        game = new GameController();
    }
    
    public void restartGame() {
   
        game = new GameController();
        currentState = PlayType.CIRCLE;
        labelGameStatus.setText("WHO STARTS?");
        buttonMatrix1.setIcon(null);
        buttonMatrix2.setIcon(null);
        buttonMatrix3.setIcon(null);
        buttonMatrix4.setIcon(null);
        buttonMatrix5.setIcon(null);
        buttonMatrix6.setIcon(null);
        buttonMatrix7.setIcon(null);
        buttonMatrix8.setIcon(null);
        buttonMatrix9.setIcon(null);
        
        blockButtonsMatrix();
        
        

    }
    
    private void blockButtonsMatrix() {
        iWillStartButton.setEnabled(true);
        youStartButton.setEnabled(true);
        buttonMatrix1.setEnabled(false);
        buttonMatrix2.setEnabled(false);
        buttonMatrix3.setEnabled(false);
        buttonMatrix4.setEnabled(false);
        buttonMatrix5.setEnabled(false);
        buttonMatrix6.setEnabled(false);
        buttonMatrix7.setEnabled(false);
        buttonMatrix8.setEnabled(false);
        buttonMatrix9.setEnabled(false);
    }
    
    private void unblockButtonsMatrix() {
        iWillStartButton.setEnabled(false);
        youStartButton.setEnabled(false);
        buttonMatrix1.setEnabled(true);
        buttonMatrix2.setEnabled(true);
        buttonMatrix3.setEnabled(true);
        buttonMatrix4.setEnabled(true);
        buttonMatrix5.setEnabled(true);
        buttonMatrix6.setEnabled(true);
        buttonMatrix7.setEnabled(true);
        buttonMatrix8.setEnabled(true);
        buttonMatrix9.setEnabled(true);
    }

    private void computerPlay() {

        Move move = game.findBestMove();
        System.out.println(move.row+""+move.col);
        if (move.row == 0 && move.col == 0) {
            buttonMatrix1.doClick();
        } else if (move.row == 0 && move.col == 1) {
            buttonMatrix2.doClick();
        } else if (move.row == 0 && move.col == 2) {
            buttonMatrix3.doClick();
        } else if (move.row == 1 && move.col == 0) {
            buttonMatrix4.doClick();
        } else if (move.row == 1 && move.col == 1) {
            buttonMatrix5.doClick();
        } else if (move.row == 1 && move.col == 2) {
            buttonMatrix6.doClick();
        } else if (move.row == 2 && move.col == 0) {
            buttonMatrix7.doClick();
        } else if (move.row == 2 && move.col == 1) {
            buttonMatrix8.doClick();
        } else if (move.row == 2 && move.col == 2) {
            buttonMatrix9.doClick();
        }
    }
    
    private void changeButtonState(JButton button) {
 
       Image img = null;
        try {
            
            if (button.getIcon() == null) {

                if (currentState == PlayType.CROSS) {
                    
                     img = ImageIO.read(getClass().getResource("cancel-music.png"));
                     currentState = PlayType.CIRCLE;
                    
                } else {

                    img = ImageIO.read(getClass().getResource("circle-shape-outline.png"));
                    currentState = PlayType.CROSS;
                     computerPlay();
                }
                
                button.setIcon(new ImageIcon(img));
            }
            
            int matrixEvaluation = game.evaluateGameMatrix();
            boolean movesLeft = game.isMovesLeft();
            if (matrixEvaluation != 0 || movesLeft == false) {
                blockButtonsMatrix();
                iWillStartButton.setEnabled(false);
                youStartButton.setEnabled(false);
                restartButton.setVisible(true);
                JOptionPane jo;
                if (matrixEvaluation == -10) {
                    labelGameStatus.setText("VOCÊ VENCEU!");
                } else if (matrixEvaluation == 10) {
                    labelGameStatus.setText("VOCÊ PERDEU!");
                } else {
                    labelGameStatus.setText("DEU VELHA!");
                }
          
            } 
            
            
            
            
            
          
        } catch (IOException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelGameStatus = new javax.swing.JLabel();
        iWillStartButton = new javax.swing.JButton();
        youStartButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        buttonMatrix4 = new javax.swing.JButton();
        buttonMatrix7 = new javax.swing.JButton();
        buttonMatrix8 = new javax.swing.JButton();
        buttonMatrix9 = new javax.swing.JButton();
        buttonMatrix6 = new javax.swing.JButton();
        buttonMatrix1 = new javax.swing.JButton();
        buttonMatrix5 = new javax.swing.JButton();
        buttonMatrix2 = new javax.swing.JButton();
        buttonMatrix3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelGameStatus.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        labelGameStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGameStatus.setText("WHO STARTS?");

        iWillStartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profile.png"))); // NOI18N
        iWillStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iWillStartButtonActionPerformed(evt);
            }
        });

        youStartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pc-computer-with-monitor.png"))); // NOI18N
        youStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youStartButtonActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("You Start");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("I'll Start");

        restartButton.setText("RESTART");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(youStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGameStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iWillStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelGameStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(youStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iWillStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(restartButton))
                    .addComponent(jLabel3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        buttonMatrix4.setFocusPainted(false);
        buttonMatrix4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix4ActionPerformed(evt);
            }
        });

        buttonMatrix7.setFocusPainted(false);
        buttonMatrix7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix7ActionPerformed(evt);
            }
        });

        buttonMatrix8.setFocusPainted(false);
        buttonMatrix8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix8ActionPerformed(evt);
            }
        });

        buttonMatrix9.setFocusPainted(false);
        buttonMatrix9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix9ActionPerformed(evt);
            }
        });

        buttonMatrix6.setFocusPainted(false);
        buttonMatrix6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix6ActionPerformed(evt);
            }
        });

        buttonMatrix1.setFocusPainted(false);
        buttonMatrix1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix1ActionPerformed(evt);
            }
        });

        buttonMatrix5.setFocusPainted(false);
        buttonMatrix5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix5ActionPerformed(evt);
            }
        });

        buttonMatrix2.setFocusPainted(false);
        buttonMatrix2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix2ActionPerformed(evt);
            }
        });

        buttonMatrix3.setFocusPainted(false);
        buttonMatrix3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMatrix3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonMatrix1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMatrix4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMatrix7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonMatrix8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonMatrix9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonMatrix2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonMatrix5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonMatrix6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonMatrix3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonMatrix1, buttonMatrix2, buttonMatrix3, buttonMatrix4, buttonMatrix5, buttonMatrix6, buttonMatrix7, buttonMatrix8, buttonMatrix9});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMatrix1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMatrix2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMatrix3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMatrix4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMatrix6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMatrix5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMatrix8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMatrix7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMatrix9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonMatrix1, buttonMatrix2, buttonMatrix3, buttonMatrix4, buttonMatrix5, buttonMatrix6, buttonMatrix7, buttonMatrix8, buttonMatrix9});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMatrix4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix4ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[1][0] = currentState;
        changeButtonState((JButton)evt.getSource());
    }//GEN-LAST:event_buttonMatrix4ActionPerformed

    private void buttonMatrix7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix7ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[2][0] = currentState;
        changeButtonState((JButton)evt.getSource());
    }//GEN-LAST:event_buttonMatrix7ActionPerformed

    private void buttonMatrix8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix8ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[2][1] = currentState;
        changeButtonState((JButton)evt.getSource());
    }//GEN-LAST:event_buttonMatrix8ActionPerformed

    private void buttonMatrix9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix9ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[2][2] = currentState;
        changeButtonState((JButton)evt.getSource());
    }//GEN-LAST:event_buttonMatrix9ActionPerformed

    private void buttonMatrix6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix6ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[1][2] = currentState;
       changeButtonState((JButton)evt.getSource());
        
    }//GEN-LAST:event_buttonMatrix6ActionPerformed

    private void buttonMatrix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix1ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[0][0] = currentState;
        changeButtonState((JButton)evt.getSource());
        
    }//GEN-LAST:event_buttonMatrix1ActionPerformed

    private void buttonMatrix5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix5ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[1][1] = currentState;
        changeButtonState((JButton)evt.getSource());
    }//GEN-LAST:event_buttonMatrix5ActionPerformed

    private void buttonMatrix2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix2ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[0][1] = currentState;
        changeButtonState((JButton)evt.getSource());
    }//GEN-LAST:event_buttonMatrix2ActionPerformed

    private void buttonMatrix3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMatrix3ActionPerformed
        // TODO add your handling code here:
        game.gameMatrix[0][2] = currentState;
        changeButtonState((JButton)evt.getSource());
    }//GEN-LAST:event_buttonMatrix3ActionPerformed

    private void youStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youStartButtonActionPerformed
        // TODO add your handling code here:
        
        unblockButtonsMatrix();
        computerStarts();
    }//GEN-LAST:event_youStartButtonActionPerformed

    private void iWillStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iWillStartButtonActionPerformed
        // TODO add your handling code here:
        labelGameStatus.setText("GO!");
        unblockButtonsMatrix();
    }//GEN-LAST:event_iWillStartButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        // TODO add your handling code here:
  
        restartGame();
    }//GEN-LAST:event_restartButtonActionPerformed

    private void computerStarts() {
        currentState = PlayType.CROSS;
         computerPlay();
         labelGameStatus.setText("GO!");
        
        
    }


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonMatrix1;
    private javax.swing.JButton buttonMatrix2;
    private javax.swing.JButton buttonMatrix3;
    private javax.swing.JButton buttonMatrix4;
    private javax.swing.JButton buttonMatrix5;
    private javax.swing.JButton buttonMatrix6;
    private javax.swing.JButton buttonMatrix7;
    private javax.swing.JButton buttonMatrix8;
    private javax.swing.JButton buttonMatrix9;
    private javax.swing.JButton iWillStartButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelGameStatus;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton youStartButton;
    // End of variables declaration//GEN-END:variables
}
