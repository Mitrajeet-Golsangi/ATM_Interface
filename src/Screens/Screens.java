/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screens;

import Login.Login;
import Transaction.Transaction;
import db.Database;
import db.User;
import java.awt.Color;
import java.sql.SQLException;

/**
 *
 * @author mitrajeet
 */
public class Screens extends javax.swing.JFrame {

    User u;

    public Screens() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Parent = new javax.swing.JPanel();
        loginPane = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        uname = new javax.swing.JLabel();
        unameField = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        loginError = new javax.swing.JLabel();
        homePane = new javax.swing.JPanel();
        AccBalance = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        withdraw = new javax.swing.JButton();
        deposit = new javax.swing.JButton();
        amount = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Parent.setLayout(new java.awt.CardLayout());

        title.setText("ATM Login");
        title.setToolTipText("");

        uname.setText("Username :");

        unameField.setToolTipText("Enter Username");

        pass.setText("Password :");

        passField.setToolTipText("Enter Password");

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        loginError.setText(" ");

        javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
        loginPane.setLayout(loginPaneLayout);
        loginPaneLayout.setHorizontalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPaneLayout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPaneLayout.createSequentialGroup()
                        .addComponent(loginError, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPaneLayout.createSequentialGroup()
                        .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uname)
                            .addComponent(pass))
                        .addGap(18, 18, 18)
                        .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginBtn)
                            .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(unameField)
                                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(title))
                        .addGap(161, 161, 161))))
        );
        loginPaneLayout.setVerticalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(loginError)
                .addGap(18, 18, 18)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uname)
                    .addComponent(unameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(loginBtn)
                .addGap(112, 112, 112))
        );

        Parent.add(loginPane, "card2");

        AccBalance.setText("Account Balance : ");

        balance.setText("------");

        withdraw.setText("Witdraw");
        withdraw.setActionCommand("Withdraw");
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });

        deposit.setText("Deposit");
        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });

        amount.setText("Enter Amount :");

        message.setForeground(new java.awt.Color(51, 255, 51));
        message.setText("  ");

        javax.swing.GroupLayout homePaneLayout = new javax.swing.GroupLayout(homePane);
        homePane.setLayout(homePaneLayout);
        homePaneLayout.setHorizontalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePaneLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePaneLayout.createSequentialGroup()
                        .addComponent(AccBalance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homePaneLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homePaneLayout.createSequentialGroup()
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(amountField)))
                .addGap(151, 151, 151))
            .addGroup(homePaneLayout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homePaneLayout.setVerticalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePaneLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccBalance)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deposit)
                    .addComponent(withdraw))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        Parent.add(homePane, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handles Actions when the login button is pressed Makes a call to the
     * Login.Login.checkLogin function to check if the inputted credentials
     * match the database and if they do navigates to the home screen
     *
     * @param evt
     */
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String errorMsg = Login.checkLogin(
                this.unameField.getText(),
                new String(this.passField.getPassword())
        );
        if (errorMsg == null) {
            u = Login.getCurrentUser();
            Parent.removeAll();
            balance.setText(String.valueOf(u.getBankBalance()));
            Parent.add(homePane);
            Parent.repaint();
            Parent.revalidate();
        } else {
            loginError.setForeground(Color.RED);
            loginError.setText(errorMsg);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * Handles Actions when the withdraw button is pressed Makes a call to the
     * Transaction.Transaction.withdraw method to update the bank balance in the
     * database as well as in the current user repository
     *
     * @param evt
     */
    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawActionPerformed
        try {
            new Transaction().withdraw(Integer.parseInt(amountField.getText()), u);
            message.setText("Withdraw Successfull");
            message.setForeground(Color.GREEN);
            
        } catch (RuntimeException e) {
            message.setText(e.getMessage());
            message.setForeground(Color.RED);
        
        } catch (SQLException e) {
            message.setText(e.getLocalizedMessage());
            message.setForeground(Color.RED);
        }

        balance.setText(String.valueOf(u.getBankBalance()));
        Parent.repaint();
    }//GEN-LAST:event_withdrawActionPerformed

    /**
     * Handles Actions when the deposit button is pressed Makes a call to the
     * Transaction.Transaction.deposit method to update the bank balance in the
     * database as well as in the current user repository
     *
     * @param evt
     */
    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
        try {
            new Transaction().deposit(Integer.parseInt(amountField.getText()), u);
            message.setForeground(Color.GREEN);
            message.setText("Deposit Successfull");
            balance.setText(String.valueOf(u.getBankBalance()));
        
        } catch (SQLException e) {
            message.setForeground(Color.RED);
            message.setText(e.getLocalizedMessage());
        }
        Parent.repaint();
    }//GEN-LAST:event_depositActionPerformed

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
            java.util.logging.Logger.getLogger(Screens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Screens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Screens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Screens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccBalance;
    public javax.swing.JPanel Parent;
    private javax.swing.JLabel amount;
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel balance;
    private javax.swing.JButton deposit;
    private javax.swing.JPanel homePane;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginError;
    private javax.swing.JPanel loginPane;
    private javax.swing.JLabel message;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel title;
    private javax.swing.JLabel uname;
    private javax.swing.JTextField unameField;
    private javax.swing.JButton withdraw;
    // End of variables declaration//GEN-END:variables
}
