package uas_pbo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    private static int id;
    Koneksi koneksi = new Koneksi();
    Session session = new Session();
    public Login() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        LB_header = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        LB_judul = new javax.swing.JLabel();
        LB_note = new javax.swing.JLabel();
        LB_username = new javax.swing.JLabel();
        LB_password = new javax.swing.JLabel();
        TF_Username = new javax.swing.JTextField();
        PF_Password = new javax.swing.JPasswordField();
        BT_Login = new javax.swing.JButton();
        Logo_Welcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelHeader.setBackground(new java.awt.Color(204, 204, 255));
        panelHeader.setPreferredSize(new java.awt.Dimension(600, 50));

        LB_header.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        LB_header.setText("Login");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LB_header)
                .addContainerGap(530, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(LB_header)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 600, 50);

        mainPanel.setBackground(new java.awt.Color(255, 204, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 450));

        LB_judul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        LB_judul.setText("Selamat Datang");

        LB_note.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LB_note.setText("Tolong Masukkan Username dan Password");

        LB_username.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        LB_username.setText("Username");

        LB_password.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        LB_password.setText("Password");

        TF_Username.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TF_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_UsernameActionPerformed(evt);
            }
        });

        PF_Password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BT_Login.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        BT_Login.setText("Login");
        BT_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_LoginActionPerformed(evt);
            }
        });

        Logo_Welcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(355, Short.MAX_VALUE)
                        .addComponent(BT_Login)
                        .addGap(98, 98, 98))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(Logo_Welcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LB_note)
                            .addComponent(LB_judul)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LB_username, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LB_password))
                                .addGap(33, 33, 33)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TF_Username)
                                    .addComponent(PF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(75, 75, 75))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(LB_judul)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Logo_Welcome)
                    .addComponent(LB_note))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LB_username)
                    .addComponent(TF_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_password))
                .addGap(18, 18, 18)
                .addComponent(BT_Login)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 50, 600, 450);

        setSize(new java.awt.Dimension(616, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_LoginActionPerformed
        try{
            koneksi.koneksi();
            ResultSet res = koneksi.koneksi.createStatement().executeQuery("SELECT * FROM user WHERE username = '"+ TF_Username.getText()+"' AND password = md5('" + PF_Password.getText() + "')");
            if(res.next()){
                id = Integer.parseInt(res.getString("id_user"));
                
                if(res.getString("status").equals("Transaksi")){
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    session.setId(id);
                    new Home().setVisible(true);
                    this.dispose();
                }
                else if(res.getString("status").equals("Inventory")){
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    session.setId(id);
                    Home hm = new Home();
                    hm.Inventory();
                    hm.setVisible(true);
                    this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null ,"Username / Password salah !");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, ""+ e.getMessage());
        }
    }//GEN-LAST:event_BT_LoginActionPerformed

    private void TF_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_UsernameActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Login;
    private javax.swing.JLabel LB_header;
    private javax.swing.JLabel LB_judul;
    private javax.swing.JLabel LB_note;
    private javax.swing.JLabel LB_password;
    private javax.swing.JLabel LB_username;
    private javax.swing.JLabel Logo_Welcome;
    private javax.swing.JPasswordField PF_Password;
    private javax.swing.JTextField TF_Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelHeader;
    // End of variables declaration//GEN-END:variables
}
