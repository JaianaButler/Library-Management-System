/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

public class Register extends JFrame{
    static Register jframe;
    
    private JLabel signupTitleLabel;
    private JLabel firstNameLabel, lastNameLabel;
    private JLabel usernameLabel, passwordLabel, passwordCheckLabel;
    private JPanel signupTitlePanel, signupInfoPanel;
    
    private JTextField firstNameTextField, lastNameTextField, usernameTextField;
    private JPasswordField passwordTextField, passwordCheckTextField;
    
    private JButton registerButton;
    
    public Register(){
        //**Title Label**
        signupTitleLabel = new JLabel("Register");
        signupTitleLabel.setFont(new Font("Times New Roman", 0, 22));
        
        //**Title Panel**
        signupTitlePanel = new JPanel();
            //Panel Layout
        GroupLayout signupTitlePanelLayout = new GroupLayout(signupTitlePanel);
        signupTitlePanelLayout.setHorizontalGroup(
            signupTitlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(signupTitlePanelLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(signupTitleLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signupTitlePanelLayout.setVerticalGroup(
            signupTitlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(signupTitlePanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signupTitleLabel))
        );
        signupTitlePanel.setLayout(signupTitlePanelLayout);
        
        //**Sign Up Info Labels**
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        usernameLabel = new JLabel("Enter Username");
        passwordLabel = new JLabel("Enter Password");
        passwordCheckLabel = new JLabel("Confirm Password");
        
        //**Sign Up Info Text Fields**
        firstNameTextField = new JTextField();
        //firstNameTextField.setColumns(10);
        
        lastNameTextField = new JTextField();
        //lastNameTextField.setColumns(10);
        
        usernameTextField = new JTextField();
        //createUsernameTextField.setColumns(10);
        
        passwordTextField = new JPasswordField();
        //createPasswordTextField.setColumns(10);
        
        passwordCheckTextField = new JPasswordField();
        //createPasswordCheckTextField.setColumns(10);
        
        //**Register Button**
        registerButton = new JButton("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        
        //**Sign Up Info Panel**
        signupInfoPanel = new JPanel();
            //Panel Layout
        GroupLayout signupInfoPanelLayout = new GroupLayout(signupInfoPanel);
        signupInfoPanelLayout.setHorizontalGroup(
            signupInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupInfoPanelLayout.createSequentialGroup()
                .addGroup(signupInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupInfoPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(signupInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel)
                            .addComponent(usernameLabel)
                            .addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordCheckLabel)
                            .addComponent(passwordCheckTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addGroup(signupInfoPanelLayout.createSequentialGroup()
                                .addGroup(signupInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameLabel))
                                .addGap(38, 38, 38)
                                .addGroup(signupInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameLabel)
                                    .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(signupInfoPanelLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(registerButton)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        signupInfoPanelLayout.setVerticalGroup(
            signupInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(signupInfoPanelLayout.createSequentialGroup()
                .addGroup(signupInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(lastNameLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(usernameLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordCheckLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordCheckTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(registerButton))
        );
        signupInfoPanel.setLayout(signupInfoPanelLayout);
        
        //**Frame Layout**
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(signupTitlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signupInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(signupTitlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    
    private void registerButtonActionPerformed(ActionEvent evt) {                                               
        String fName = firstNameTextField.getText();
        String lName = lastNameTextField.getText();
        String uName = usernameTextField.getText();
        String pword = String.valueOf(passwordTextField.getPassword());
        String pwordCheck = String.valueOf(passwordCheckTextField.getPassword());
        
        if(!pword.equals(pwordCheck)){
            JOptionPane.showMessageDialog(Register.this, "Password Does Not Match");
        }else{
            int i = UserDao.save(fName, lName, uName, pword);
            if(i > 0){
                JOptionPane.showMessageDialog(Register.this,"New User Registered");
                Library.main(new String[]{});
                jframe.dispose();
            }
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
                    jframe = new Register();
                    jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    jframe.setBounds(100, 100, 400, 370);
                    jframe.setVisible(true);
                    jframe.setResizable(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
