package uas_pbo;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Transaksi extends javax.swing.JFrame {
    Koneksi koneksi = new Koneksi();
    Session session = new Session();
    String id_user = Integer.toString(session.getId());
    
    DefaultTableModel transaksi, stok;
    String no_nota, id_barang, nama_barang, customer;
    int index,id_transaksi, total, total_harga, pilih, tunai, kembali, jumlah, harga, status = 0;
    
    public Transaksi() {
        initComponents();
        String[] judul1 = {"ID","Nama","Harga","Jumlah","Total"};
        String[] judul2 = {"ID","Nama","Harga","Stok"};
        transaksi = new DefaultTableModel(judul1, 0);
        stok = new DefaultTableModel(judul2,0);
        TB_transaksi.setModel(transaksi);
        TB_stok.setModel(stok);
        TB_transaksi.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_transaksi.getColumnModel().getColumn(0).setMinWidth(0);
        TB_transaksi.getColumnModel().getColumn(0).setPreferredWidth(0);
        autoNumber();
        readDataStok();
        readDataTransaksi();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        LB_header = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        BT_kembali = new javax.swing.JButton();
        LB_session = new javax.swing.JLabel();
        panelData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_transaksi = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TF_tunai = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TF_kembali = new javax.swing.JTextField();
        BT_Simpan = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        TF_totalharga = new javax.swing.JLabel();
        LB_nama = new javax.swing.JLabel();
        LB_customer = new javax.swing.JLabel();
        TF_customer = new javax.swing.JTextField();
        LB_harga = new javax.swing.JLabel();
        TF_harga = new javax.swing.JTextField();
        LB_jumlah = new javax.swing.JLabel();
        TF_jumlah = new javax.swing.JTextField();
        LB_Total = new javax.swing.JLabel();
        TF_total = new javax.swing.JTextField();
        BT_Tambah = new javax.swing.JButton();
        BT_Hapus = new javax.swing.JButton();
        LB_info = new javax.swing.JLabel();
        TF_namabarang = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TB_stok = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        panelHeader.setBackground(new java.awt.Color(204, 204, 255));
        panelHeader.setPreferredSize(new java.awt.Dimension(600, 50));

        LB_header.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        LB_header.setForeground(new java.awt.Color(51, 51, 51));
        LB_header.setText("Transaksi Penjualan");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap(292, Short.MAX_VALUE)
                .addComponent(LB_header)
                .addGap(290, 290, 290))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_header)
                .addContainerGap())
        );

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 800, 50);

        mainPanel.setBackground(new java.awt.Color(255, 204, 255));

        BT_kembali.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        BT_kembali.setText("<-");
        BT_kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BT_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_kembaliMouseClicked(evt);
            }
        });

        LB_session.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        LB_session.setForeground(new java.awt.Color(51, 51, 51));
        LB_session.setText("Halo !");

        panelData.setBackground(new java.awt.Color(204, 204, 255));

        TB_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Harga", "Jumlah", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TB_transaksi);

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Total Harga");

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Tunai");

        TF_tunai.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TF_tunai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TF_tunaiKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Kembali");

        TF_kembali.setEditable(false);
        TF_kembali.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        BT_Simpan.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        BT_Simpan.setText("Proses");
        BT_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SimpanActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("*Tekan Enter");

        TF_totalharga.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        TF_totalharga.setForeground(new java.awt.Color(51, 51, 51));
        TF_totalharga.setMinimumSize(new java.awt.Dimension(150, 25));

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createSequentialGroup()
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addGroup(panelDataLayout.createSequentialGroup()
                                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TF_kembali, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TF_tunai, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(BT_Simpan)
                                    .addComponent(TF_totalharga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF_totalharga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TF_tunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TF_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(BT_Simpan)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        LB_nama.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        LB_nama.setText("Nama");

        LB_customer.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        LB_customer.setForeground(new java.awt.Color(51, 51, 51));
        LB_customer.setText("Customer");

        TF_customer.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TF_customer.setForeground(new java.awt.Color(51, 51, 51));

        LB_harga.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        LB_harga.setForeground(new java.awt.Color(51, 51, 51));
        LB_harga.setText("Harga");

        TF_harga.setEditable(false);
        TF_harga.setBackground(new java.awt.Color(255, 204, 255));
        TF_harga.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TF_harga.setForeground(new java.awt.Color(51, 51, 51));
        TF_harga.setBorder(null);

        LB_jumlah.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        LB_jumlah.setForeground(new java.awt.Color(51, 51, 51));
        LB_jumlah.setText("Jumlah");

        TF_jumlah.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TF_jumlah.setForeground(new java.awt.Color(51, 51, 51));
        TF_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TF_jumlahKeyPressed(evt);
            }
        });

        LB_Total.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        LB_Total.setForeground(new java.awt.Color(51, 51, 51));
        LB_Total.setText("Total");

        TF_total.setEditable(false);
        TF_total.setBackground(new java.awt.Color(255, 204, 255));
        TF_total.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TF_total.setBorder(null);

        BT_Tambah.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        BT_Tambah.setText("Tambah");
        BT_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_TambahActionPerformed(evt);
            }
        });

        BT_Hapus.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        BT_Hapus.setText("Hapus");
        BT_Hapus.setPreferredSize(new java.awt.Dimension(100, 27));
        BT_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_HapusActionPerformed(evt);
            }
        });

        LB_info.setForeground(new java.awt.Color(51, 51, 51));
        LB_info.setText("*Tekan Enter");

        TF_namabarang.setEditable(false);
        TF_namabarang.setBackground(new java.awt.Color(255, 204, 255));
        TF_namabarang.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TF_namabarang.setForeground(new java.awt.Color(51, 51, 51));
        TF_namabarang.setBorder(null);

        TB_stok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Harga", "Stok"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TB_stok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_stokMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TB_stok);
        if (TB_stok.getColumnModel().getColumnCount() > 0) {
            TB_stok.getColumnModel().getColumn(1).setHeaderValue("ID");
        }

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(BT_kembali)
                        .addGap(18, 18, 18)
                        .addComponent(LB_session, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(135, 135, 135))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(LB_info))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(LB_jumlah)
                                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(LB_nama)
                                                .addComponent(LB_harga))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(LB_Total)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TF_jumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(TF_harga, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(TF_total)
                                            .addComponent(TF_namabarang)))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(LB_customer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TF_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(BT_Tambah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BT_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LB_session)
                    .addComponent(BT_kembali))
                .addGap(29, 29, 29)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_nama))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_harga)
                    .addComponent(TF_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_jumlah)
                    .addComponent(TF_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LB_info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_customer)
                    .addComponent(TF_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_Total)
                    .addComponent(TF_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Tambah)
                    .addComponent(BT_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 50, 800, 560);

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TB_stokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_stokMouseClicked
        index = TB_stok.getSelectedRow();
        if(index>-1){
            id_barang = stok.getValueAt(index, 0).toString();
            TF_namabarang.setText(stok.getValueAt(index,1).toString());
            TF_harga.setText(stok.getValueAt(index,2).toString());
        }
        JOptionPane.showMessageDialog(null, "Data Terpilih");
    }//GEN-LAST:event_TB_stokMouseClicked

    private void TF_jumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_jumlahKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jumlah = Integer.parseInt(TF_jumlah.getText());
            harga = Integer.parseInt(TF_harga.getText());
            total = jumlah*harga;
            TF_total.setText(Integer.toString(total));
        }
    }//GEN-LAST:event_TF_jumlahKeyPressed

    private void BT_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_TambahActionPerformed
        pilih = JOptionPane.showConfirmDialog (null, "Data sudah benar ?","Data Barang",JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_OPTION){
            int jumlah = Integer.parseInt(TF_jumlah.getText());
            int sisa;
            String total_bayar;
            try {
                koneksi.koneksi();
                // ini buat bikin Nota klo blom bikin, tapi cuma bisa sekali ampe status = 1;
                if (status == 0){
                    koneksi.koneksi.createStatement().executeUpdate("INSERT INTO nota VALUES ('"+no_nota+"', "+id_user+", '', 0, 0, 0)");
                    status = 1;
                }
                // udh notanya
                //ini ngecek stok 
                ResultSet sisa_stok = koneksi.koneksi.createStatement().executeQuery("SELECT stok FROM stok WHERE id_barang = '"+id_barang+"'");
                sisa_stok.next();
                sisa = Integer.parseInt(sisa_stok.getString(1));
                if (jumlah > sisa){
                    JOptionPane.showMessageDialog(null,"Stok Barang Kurang !");
                }
                //sampe if ini ya klo else berarti sisa > jumlah
                else {
                   koneksi.koneksi.createStatement().executeUpdate("INSERT INTO transaksi VALUES (null,'"+id_barang+"','"+no_nota+"','"+jumlah+"',"+total+",now())");
                    koneksi.koneksi.createStatement().executeUpdate("UPDATE stok SET stok = stok-"+jumlah+" WHERE id_barang='"+id_barang+"'");
                    //ini buat itung otomatis total harganya
                    ResultSet bayar = koneksi.koneksi.createStatement().executeQuery("SELECT SUM(harga) FROM transaksi WHERE no_nota = '"+no_nota+"'");
                    bayar.next();
                    total_bayar = bayar.getString(1);
                    TF_totalharga.setText(total_bayar);
                    //sampe sini
                    JOptionPane.showMessageDialog(null, "Berhasil Tambah Barang");
                    readDataTransaksi();
                    readDataStok(); 
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Tambah Barang : "+ex);
            }
        }
    }//GEN-LAST:event_BT_TambahActionPerformed

    private void TF_tunaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_tunaiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                koneksi.koneksi();
                ResultSet res = koneksi.koneksi.createStatement().executeQuery("SELECT SUM(harga) FROM transaksi WHERE no_nota = '"+no_nota+"'");
                res.next();
                total_harga = Integer.parseInt(res.getString(1));
                tunai = Integer.parseInt(TF_tunai.getText());
                kembali = tunai - total_harga;
                TF_totalharga.setText(Integer.toString(total_harga));
                TF_kembali.setText(Integer.toString(kembali));
            } catch (SQLException ex) {
                Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_TF_tunaiKeyPressed

    private void BT_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SimpanActionPerformed
        pilih = JOptionPane.showConfirmDialog (null, "Data sudah benar ?","Data Barang",JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_OPTION){
            jumlah = Integer.parseInt(TF_jumlah.getText());
            try {
                customer = TF_customer.getText();
                koneksi.koneksi();
                koneksi.koneksi.createStatement().executeUpdate("UPDATE nota "
                        + "SET customer = '"+customer+"', total_harga = "+total_harga+", tunai = "+tunai+", kembali = "+kembali+" "
                        + "WHERE no_nota = '"+no_nota+"'");
                JOptionPane.showMessageDialog(null, "Berhasil Tambah Barang");
                // ini biar abis selesai transaksi bikin nota baru
                TF_totalharga.setText(""); 
                TF_tunai.setText("");
                TF_kembali.setText("");
                TF_namabarang.setText("");
                TF_harga.setText("");
                TF_jumlah.setText("");
                TF_customer.setText("");
                TF_total.setText("");
                status = 0;
                autoNumber();
                //ampe sini
                readDataTransaksi();
                readDataStok();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Tambah Barang : "+ex);
            }
        }
    }//GEN-LAST:event_BT_SimpanActionPerformed

    private void TB_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_transaksiMouseClicked
        index = TB_transaksi.getSelectedRow();
        if(index>-1){
            id_transaksi = Integer.parseInt(transaksi.getValueAt(index, 0).toString());
            id_barang = transaksi.getValueAt(index,1).toString();
            TF_namabarang.setText(transaksi.getValueAt(index, 2).toString());
            TF_harga.setText(transaksi.getValueAt(index,3).toString());
            TF_jumlah.setText(transaksi.getValueAt(index,4).toString());
            TF_total.setText(transaksi.getValueAt(index,5).toString());
        }
        JOptionPane.showMessageDialog(null, "Data Terpilih");
    }//GEN-LAST:event_TB_transaksiMouseClicked

    private void BT_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_HapusActionPerformed
        pilih = JOptionPane.showConfirmDialog (null, "Yakin ?","Hapus Data",JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
            try {
                koneksi.koneksi();
                //ini buat nambahin stok lagi klo gk jadi beli
                ResultSet jml = koneksi.koneksi.createStatement().executeQuery("SELECT jumlah FROM transaksi WHERE id_transaksi = "+id_transaksi+"");
                jml.next();
                jumlah = Integer.parseInt(jml.getString(1));
                koneksi.koneksi.createStatement().executeUpdate("UPDATE stok SET stok = stok+"+jumlah+" WHERE id_barang = '"+id_barang+"'");
                //sampe sini
                koneksi.koneksi.createStatement().executeUpdate("DELETE FROM transaksi WHERE id_transaksi = "+id_transaksi+"");
                JOptionPane.showMessageDialog(null, "Berhasil Hapus Barang");
                readDataTransaksi();
                readDataStok();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Hapus Barang : "+ex);
            }
        }
    }//GEN-LAST:event_BT_HapusActionPerformed

    private void BT_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_kembaliMouseClicked
        dispose();
    }//GEN-LAST:event_BT_kembaliMouseClicked

    public void readDataTransaksi(){
        int row = TB_transaksi.getRowCount();
        for (int i=0 ; i<row ; i++){
            transaksi.removeRow(0);
        }
        try {
            koneksi.koneksi();
            ResultSet res = koneksi.koneksi.createStatement().executeQuery("SELECT t.id_transaksi, b.id_barang, b.nama_barang, b.harga, t.jumlah, t.harga "
                    + "FROM transaksi t, stok b WHERE t.no_nota = '"+no_nota+"' AND t.id_barang=b.id_barang");
            while (res.next()){
                String data[] = {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)};
                transaksi.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readDataStok(){
        int row = TB_stok.getRowCount();
        for (int i=0 ; i<row ; i++){
            stok.removeRow(0);
        }
        try {
            koneksi.koneksi();
            ResultSet res = koneksi.koneksi.createStatement().executeQuery("SELECT * FROM stok");
            while (res.next()){
                String data[] = {res.getString(1),res.getString(2),res.getString(3),res.getString(4)};
                stok.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void autoNumber() {
        try {
            koneksi.koneksi();
            ResultSet res = koneksi.koneksi.createStatement().executeQuery("SELECT MAX(RIGHT(no_nota,4)) AS no_auto FROM nota");
            if (res.next()) {
                String no_auto, nol_plus;
                int a;
                no_auto = Integer.toString(res.getInt(1)+1);
                a = no_auto.length();
                nol_plus = "";
                for(int i=1;i<=4-a;i++){
                    nol_plus = nol_plus+"0";
                }
                no_nota = ("NT"+nol_plus+no_auto);
                }
            } catch (Exception e) {
                no_nota = ("NT0001");
            JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public void huruf(KeyEvent a){
       if(Character.isDigit(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan huruf saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
    }
    
    public void angka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
    }
        
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Hapus;
    private javax.swing.JButton BT_Simpan;
    private javax.swing.JButton BT_Tambah;
    private javax.swing.JButton BT_kembali;
    private javax.swing.JLabel LB_Total;
    private javax.swing.JLabel LB_customer;
    private javax.swing.JLabel LB_harga;
    private javax.swing.JLabel LB_header;
    private javax.swing.JLabel LB_info;
    private javax.swing.JLabel LB_jumlah;
    private javax.swing.JLabel LB_nama;
    private javax.swing.JLabel LB_session;
    private javax.swing.JTable TB_stok;
    private javax.swing.JTable TB_transaksi;
    private javax.swing.JTextField TF_customer;
    private javax.swing.JTextField TF_harga;
    private javax.swing.JTextField TF_jumlah;
    private javax.swing.JTextField TF_kembali;
    private javax.swing.JTextField TF_namabarang;
    private javax.swing.JTextField TF_total;
    private javax.swing.JLabel TF_totalharga;
    private javax.swing.JTextField TF_tunai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelHeader;
    // End of variables declaration//GEN-END:variables
}
