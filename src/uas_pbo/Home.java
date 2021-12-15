package uas_pbo;

public class Home extends javax.swing.JFrame {
    Session session = new Session();
    public Home() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainHeader = new javax.swing.JPanel();
        BT_menu = new javax.swing.JLabel();
        BT_logout = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();
        BT_Transaksi = new javax.swing.JButton();
        BT_Inventory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(null);

        mainHeader.setBackground(new java.awt.Color(204, 204, 255));
        mainHeader.setPreferredSize(new java.awt.Dimension(600, 50));

        BT_menu.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        BT_menu.setText("Menu");

        BT_logout.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        BT_logout.setText("Logout");
        BT_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainHeaderLayout = new javax.swing.GroupLayout(mainHeader);
        mainHeader.setLayout(mainHeaderLayout);
        mainHeaderLayout.setHorizontalGroup(
            mainHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BT_menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
                .addComponent(BT_logout)
                .addGap(20, 20, 20))
        );
        mainHeaderLayout.setVerticalGroup(
            mainHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainHeaderLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(mainHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_logout)
                    .addComponent(BT_menu))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(mainHeader);
        mainHeader.setBounds(0, 0, 600, 50);

        panelMain.setBackground(new java.awt.Color(255, 204, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(600, 450));

        BT_Transaksi.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        BT_Transaksi.setText("Transaksi");
        BT_Transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_TransaksiActionPerformed(evt);
            }
        });

        BT_Inventory.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        BT_Inventory.setText("Inventory");
        BT_Inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_InventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(BT_Transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(BT_Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        getContentPane().add(panelMain);
        panelMain.setBounds(0, 50, 600, 450);

        setSize(new java.awt.Dimension(616, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Transaksi() {
        BT_Inventory.setVisible(false);
    }
    
    public void Inventory() {
        BT_Transaksi.setVisible(false);
    }
    
    private void BT_TransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_TransaksiActionPerformed
        new Transaksi().setVisible(true);
    }//GEN-LAST:event_BT_TransaksiActionPerformed

    private void BT_InventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_InventoryActionPerformed
        new Inventory().setVisible(true);
    }//GEN-LAST:event_BT_InventoryActionPerformed

    private void BT_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_logoutMouseClicked
        new Login().setVisible(true);
        this.dispose();
        session.setId(0);
    }//GEN-LAST:event_BT_logoutMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Inventory;
    private javax.swing.JButton BT_Transaksi;
    private javax.swing.JLabel BT_logout;
    private javax.swing.JLabel BT_menu;
    private javax.swing.JPanel mainHeader;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables

}
