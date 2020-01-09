/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;


public class Login extends JFrame {
    static Login jframe;
    
    private JPanel loginTitlePanel, loginInfoPanel;
    private JLabel loginTitleLabel, enterUserLabel, enterPasswordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JCheckBox passwordToggleBox;
    
    
    public Login(){
        //**Title Label**
        loginTitleLabel = new JLabel("Library Login");
        loginTitleLabel.setFont(new Font("Times New Roman", 0, 22));
        
        //**Title Panel**
        loginTitlePanel = new JPanel();
            //Panel Layout
        GroupLayout loginTitlePanelLayout = new GroupLayout(loginTitlePanel);
        loginTitlePanelLayout.setHorizontalGroup(
            loginTitlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(loginTitlePanelLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(loginTitleLabel)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        loginTitlePanelLayout.setVerticalGroup(
            loginTitlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(loginTitlePanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginTitleLabel))
        );
        loginTitlePanel.setLayout(loginTitlePanelLayout);
        
        //**User and Password Labels
        enterUserLabel = new JLabel("Username");
        enterPasswordLabel = new JLabel("Password");
        
        //**Text Fields**
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        
        //**Password Toggle Box**
        passwordToggleBox = new JCheckBox("Show Password");
        passwordToggleBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                passwordToggleBoxActionPerformed(evt);
            }
        });
        
        //** Login Button**
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", 0, 12));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
            
        });
        
        //**Login Info Panel**
        loginInfoPanel = new JPanel();
            //Panel Layout
        GroupLayout loginInfoPanelLayout = new GroupLayout(loginInfoPanel);
        loginInfoPanelLayout.setHorizontalGroup(
            loginInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(loginInfoPanelLayout.createSequentialGroup()
                .addGroup(loginInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(loginInfoPanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(loginInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(loginInfoPanelLayout.createSequentialGroup()
                                .addGroup(loginInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(userTextField))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordToggleBox))
                            .addComponent(enterUserLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterPasswordLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loginInfoPanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginInfoPanelLayout.setVerticalGroup(
            loginInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(loginInfoPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(enterUserLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(enterPasswordLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(passwordToggleBox)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(loginButton)
                .addGap(31, 31, 31))
        );
        loginInfoPanel.setLayout(loginInfoPanelLayout);
        
        //**Frame Layout**
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(loginInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginTitlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginTitlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }   
    
    private void passwordToggleBoxActionPerformed(ActionEvent evt) {
        if(passwordToggleBox.isSelected()){
            passwordField.setEchoChar((char)0);
        }else{
            passwordField.setEchoChar('*');
        }
    }
    private void loginButtonActionPerformed(ActionEvent evt){
        String user = userTextField.getText();
        String password = String.valueOf(passwordField.getPassword());
                
        if(UserDao.validate(user, password)){
            LibraryHome.main(new String[]{});
            jframe.dispose();
        }
    }
    
    public static void main(String[] args){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    jframe = new Login();
                    jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    jframe.setBounds(100, 100, 400, 350);
                    jframe.setVisible(true);
                    jframe.setResizable(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}