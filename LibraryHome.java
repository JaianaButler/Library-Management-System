/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LibraryHome extends JFrame{
    static LibraryHome jframe;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;


    private JLabel homeTitleLabel;
    private JPanel homeTitlePanel, homeBodyPanel, homeSidePanel;
    private JSeparator separator;
    
    private JPanel cards, viewBooksSwitchPanel, checkoutSwitchPanel, returnSwitchPanel;
    private JLabel bookTitleLabel, authorLabel, publisherLabel, genreLabel, isbnLabel, statusLabel, checkoutISBNLabel, returnISBNLabel;
    private JTextField bookTitleTextField, authorTextField, publisherTextField, genreTextField, isbnTextField, statusTextField, checkoutISBNTextField, returnISBNTextField;
    private JButton prevButton, nextButton, processCheckoutButton, processReturnButton;
            
    private JButton logoutButton, viewBooksButton, checkoutButton, returnButton;
    
    public LibraryHome(){
        //**Title Label**
        homeTitleLabel = new JLabel("Library System");
        homeTitleLabel.setFont(new Font("Times New Roman", 0, 22));
        
        //**Log out Button**
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        
        //**Separator**
        separator = new JSeparator();
        
        //**Home Title Panel**
        homeTitlePanel = new JPanel();
            //Panel Layout
        GroupLayout homeTitlePanelLayout = new GroupLayout(homeTitlePanel);
        homeTitlePanelLayout.setHorizontalGroup(
            homeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeTitlePanelLayout.createSequentialGroup()
                        .addGap(0, 194, Short.MAX_VALUE)
                        .addComponent(homeTitleLabel)
                        .addGap(133, 133, 133)
                        .addComponent(logoutButton))
                    .addComponent(separator))
                .addContainerGap())
        );
        homeTitlePanelLayout.setVerticalGroup(
            homeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeTitleLabel)
                    .addComponent(logoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        homeTitlePanel.setLayout(homeTitlePanelLayout);
        
        
        
        //**Home Body Panel**
        homeBodyPanel = new JPanel();
            //Panel Layout
        GroupLayout homeBodyPanelLayout = new GroupLayout(homeBodyPanel);
        homeBodyPanelLayout.setHorizontalGroup(
            homeBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        homeBodyPanelLayout.setVerticalGroup(
            homeBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        homeBodyPanel.setLayout(homeBodyPanelLayout);
        
        //**Side Panel Buttons**
        viewBooksButton = new JButton("View Inventory");
        viewBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewBooksButtonActionPerformed(evt);
            }
        });
     
        checkoutButton = new JButton("Process Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });
        
        returnButton = new JButton("Process Return");
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        
        
        //**Home Side Panel**
        homeSidePanel = new JPanel();
            //Panel Layout
        GroupLayout homeSidePanelLayout = new GroupLayout(homeSidePanel);
        homeSidePanelLayout.setHorizontalGroup(
            homeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewBooksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(checkoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );
        homeSidePanelLayout.setVerticalGroup(
            homeSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBooksButton)
                .addGap(49, 49, 49)
                .addComponent(checkoutButton)
                .addGap(53, 53, 53)
                .addComponent(returnButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeSidePanel.setLayout(homeSidePanelLayout);
        
        
        //**View Books Components**
        bookTitleLabel = new JLabel("Title");
        authorLabel = new JLabel("Author");
        publisherLabel = new JLabel("Publisher");
        genreLabel = new JLabel("Genre");
        isbnLabel = new JLabel("ISBN");
        statusLabel = new JLabel("Availability");
        
        bookTitleTextField = new JTextField();
        authorTextField = new JTextField();
        publisherTextField = new JTextField();
        genreTextField = new JTextField();
        isbnTextField = new JTextField();
        statusTextField = new JTextField();
        
        prevButton = new JButton("Prev");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });
        nextButton = new JButton("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        
        //**View Books Switch Panel
        viewBooksSwitchPanel = new JPanel();
        viewBooksSwitchPanel.setBackground(new Color(204,204,204));
            //Panel Layout
        GroupLayout viewBooksSwitchPanelLayout = new javax.swing.GroupLayout(viewBooksSwitchPanel);
        viewBooksSwitchPanelLayout.setHorizontalGroup(
            viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                        .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                                .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(isbnTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(genreTextField)
                                    .addComponent(authorTextField)
                                    .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                                        .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(authorLabel)
                                            .addComponent(bookTitleLabel)
                                            .addComponent(genreLabel)
                                            .addComponent(isbnLabel))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))
                            .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                                .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(publisherTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookTitleTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusLabel)
                            .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                                .addComponent(prevButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextButton))
                            .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                        .addComponent(publisherLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        viewBooksSwitchPanelLayout.setVerticalGroup(
            viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTitleLabel)
                    .addComponent(statusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(authorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(genreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                        .addComponent(isbnLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(publisherLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(publisherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(viewBooksSwitchPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(viewBooksSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prevButton)
                            .addComponent(nextButton)))))
        );
        viewBooksSwitchPanel.setLayout(viewBooksSwitchPanelLayout);
        
        //**Check Out Switch Components
        checkoutISBNLabel = new JLabel("Enter ISBN");
        checkoutISBNTextField = new JTextField();
        processCheckoutButton = new JButton("Process");
        processCheckoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processCheckoutButtonActionPerformed(evt);
            }
        });
        
        //**Check Out Switch Panel**
        checkoutSwitchPanel = new JPanel();
        checkoutSwitchPanel.setBackground(new Color(204, 204, 204));
            //Panel Layout
        javax.swing.GroupLayout checkoutSwitchPanelLayout = new javax.swing.GroupLayout(checkoutSwitchPanel);
        checkoutSwitchPanelLayout.setHorizontalGroup(
            checkoutSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutSwitchPanelLayout.createSequentialGroup()
                .addGroup(checkoutSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkoutSwitchPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(checkoutISBNLabel))
                    .addGroup(checkoutSwitchPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(checkoutISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutSwitchPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(processCheckoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        checkoutSwitchPanelLayout.setVerticalGroup(
            checkoutSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutSwitchPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(checkoutISBNLabel)
                .addGap(18, 18, 18)
                .addComponent(checkoutISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(processCheckoutButton)
                .addGap(32, 32, 32))
        );
        checkoutSwitchPanel.setLayout(checkoutSwitchPanelLayout);
        
        
        //**Return Switch Panel Components**
        returnISBNLabel = new JLabel("Enter ISBN");
        returnISBNTextField = new JTextField();
        processReturnButton = new JButton("Process");
        processReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processReturnButtonActionPerformed(evt);
            }
        });
        
        //**Return Switch Panel**
        returnSwitchPanel = new JPanel();
        returnSwitchPanel.setBackground(new Color(204, 204, 204));
            //Panel Layout
        javax.swing.GroupLayout returnSwitchPanelLayout = new javax.swing.GroupLayout(returnSwitchPanel);
        returnSwitchPanelLayout.setHorizontalGroup(
            returnSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnSwitchPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(returnSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnISBNLabel)
                    .addComponent(returnISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returnSwitchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(processReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        returnSwitchPanelLayout.setVerticalGroup(
            returnSwitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnSwitchPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(returnISBNLabel)
                .addGap(18, 18, 18)
                .addComponent(returnISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(processReturnButton)
                .addGap(32, 32, 32))
        );
        returnSwitchPanel.setLayout(returnSwitchPanelLayout);
        
        
        //**Switching Cards Main Panel**
        cards = new JPanel(new CardLayout());
        cards.setBackground(new Color(0, 0, 0));
        cards.add(viewBooksSwitchPanel, "viewBooks");
        cards.add(checkoutSwitchPanel, "checkout");
        cards.add(returnSwitchPanel, "return");
        
        homeBodyPanel.add(cards);
        
        
        //**Frame Layout**
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(homeSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(homeTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeBodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(homeTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeBodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        DoConnect();
    }
    
    private void logoutButtonActionPerformed(ActionEvent evt) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login.main(new String[]{});
        jframe.dispose();
    } 
    
    private void viewBooksButtonActionPerformed(ActionEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "viewBooks");
    }                                               
    
    private void checkoutButtonActionPerformed(ActionEvent evt) {                                               
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "checkout");
    }                                              

    private void returnButtonActionPerformed(ActionEvent evt) {                                             
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "return");
    }
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try{
            if(rs.next()){
                int isbn_col = rs.getInt("ISBN");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                String publ = rs.getString("Publisher");
                String genre = rs.getString("Genre");
                boolean avail_col = rs.getBoolean("Status");
                
                String isbn = Integer.toString(isbn_col);
                String avail;
                if(avail_col == true){
                    avail = "Checked In";
                }else{
                    avail = "Checked Out";
                }
            
                isbnTextField.setText(isbn);
                bookTitleTextField.setText(title);
                authorTextField.setText(author);
                publisherTextField.setText(publ);
                genreTextField.setText(genre);
                statusTextField.setText(avail);
            }else{
                rs.previous();
            }
        }catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }                                          

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try{
            if(rs.previous()){
                int isbn_col = rs.getInt("ISBN");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                String publ = rs.getString("Publisher");
                String genre = rs.getString("Genre");
                boolean avail_col = rs.getBoolean("Status");
                
                String isbn = Integer.toString(isbn_col);
                String avail;
                if(avail_col == true){
                    avail = "Checked In";
                }else{
                    avail = "Checked Out";
                }
            
                isbnTextField.setText(isbn);
                bookTitleTextField.setText(title);
                authorTextField.setText(author);
                publisherTextField.setText(publ);
                genreTextField.setText(genre);
                statusTextField.setText(avail);
            }else{
                rs.next();

            }
        }catch(SQLException err){
            System.out.println(err.getMessage());
        }
    } 
    
    private void processCheckoutButtonActionPerformed(ActionEvent evt) {
        boolean currStatus = false;
        String status = statusTextField.getText();
        String isbn = checkoutISBNTextField.getText();
        int currISBN = Integer.parseInt(isbn);
        
        if(status.equals("Checked In")){
           currStatus = true;
        }
        //boolean currStatus = Boolean.parseBoolean(status);
        boolean newStatus = false;
        
        if(currStatus == true){
            statusTextField.setText("Checked Out");
        }else{
            JOptionPane.showMessageDialog(LibraryHome.this, "Book Unavailable");
        }
        
        
        try{
            //stmt = con.createStatement();
            String query = "update BOOKINFO set STATUS = " + newStatus + " where ISBN = " + currISBN;
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.executeUpdate();
            if(currStatus == true){
                JOptionPane.showMessageDialog(LibraryHome.this, "Records Updated");
            }
        }catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    private void processReturnButtonActionPerformed(ActionEvent evt) {
        boolean currStatus = true;
        String status = statusTextField.getText();
        String isbn = returnISBNTextField.getText();
        int currISBN = Integer.parseInt(isbn);
        
        if(status.equals("Checked Out")){
           currStatus = false;
        }
        //boolean currStatus = Boolean.parseBoolean(status);
        boolean newStatus = true;
        
        if(currStatus == false){
            statusTextField.setText("Checked In");
        }else{
            JOptionPane.showMessageDialog(LibraryHome.this, "Book Already Checked In");
        }
        
        
        try{
            String query = "update BOOKINFO set STATUS = " + newStatus + " where ISBN = " + currISBN;
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.executeUpdate();
            if(currStatus == false){
                JOptionPane.showMessageDialog(LibraryHome.this, "Records Updated");
            }
        }catch(SQLException err){
            System.out.println(err.getMessage());
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
            java.util.logging.Logger.getLogger(LibraryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
                    jframe = new LibraryHome();
                    jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    jframe.setVisible(true);
                    jframe.setResizable(false);
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
    }
    
    
    
    public void DoConnect(){
        try{
            String host = "jdbc:derby://localhost:1527/UserDB";
            String uName = "adminaccess";
            String uPass = "admin";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String sql = "SELECT * FROM BOOKINFO";
            
            rs = stmt.executeQuery(sql);
            
            rs.next();
            int isbn_col = rs.getInt("ISBN");
            String title = rs.getString("Title");
            String author = rs.getString("Author");
            String publ = rs.getString("Publisher");
            String genre = rs.getString("Genre");
            boolean avail_col = rs.getBoolean("Status");
            
            String isbn = Integer.toString(isbn_col);
            String avail;
            if(avail_col == true){
                avail = "Checked In";
            }else{
                avail = "Checked Out";
            }
            
            isbnTextField.setText(isbn);
            bookTitleTextField.setText(title);
            authorTextField.setText(author);
            publisherTextField.setText(publ);
            genreTextField.setText(genre);
            statusTextField.setText(avail);
            
        }catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
}