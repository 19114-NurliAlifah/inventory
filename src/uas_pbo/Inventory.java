package uas_pbo;
/** @author Kelompok 1 - 4F*/

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Inventory extends javax.swing.JFrame {
    DefaultTableModel model;
    String id_barang, kode, nama, cari;
    int harga, stok, index, pilih;
    Koneksi koneksi = new Koneksi();
    public Inventory() {
        initComponents();
        String[] judul = {"ID Barang","Nama Barang","Harga","Stok"};
        model = new DefaultTableModel(judul, 0);
        TB_inventori.setModel(model);
        readData();
        idBarang();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        LB_header = new javax.swing.JLabel();
        BT_kembali = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();
        LB_nama = new javax.swing.JLabel();
        LB_stok = new javax.swing.JLabel();
        LB_harga = new javax.swing.JLabel();
        TF_nama = new javax.swing.JTextField();
        TF_harga = new javax.swing.JTextField();
        TF_stok = new javax.swing.JTextField();
        BT_batal = new javax.swing.JButton();
        BT_tambah = new javax.swing.JButton();
        BT_hapus = new javax.swing.JButton();
        BT_ubah = new javax.swing.JButton();
        TF_cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_inventori = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        panelHeader.setBackground(new java.awt.Color(204, 204, 255));
        panelHeader.setPreferredSize(new java.awt.Dimension(600, 50));

        LB_header.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        LB_header.setText("Inventori");

        BT_kembali.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        BT_kembali.setText("<-");
        BT_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_kembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BT_kembali)
                .addGap(23, 23, 23)
                .addComponent(LB_header)
                .addContainerGap(395, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(LB_header))
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(BT_kembali)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 600, 50);

        panelMain.setBackground(new java.awt.Color(255, 204, 255));

        LB_nama.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        LB_nama.setText("Nama Barang");

        LB_stok.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        LB_stok.setText("Stok");

        LB_harga.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        LB_harga.setText("Harga");

        TF_nama.setMinimumSize(new java.awt.Dimension(6, 30));

        TF_harga.setMinimumSize(new java.awt.Dimension(6, 30));
        TF_harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_hargaKeyTyped(evt);
            }
        });

        TF_stok.setMinimumSize(new java.awt.Dimension(6, 30));

        BT_batal.setText("Batal");
        BT_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_batalActionPerformed(evt);
            }
        });

        BT_tambah.setText("Tambah");
        BT_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_tambahActionPerformed(evt);
            }
        });

        BT_hapus.setText("Hapus");
        BT_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_hapusActionPerformed(evt);
            }
        });

        BT_ubah.setText("Ubah");
        BT_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ubahActionPerformed(evt);
            }
        });

        TF_cari.setText("Pencarian");
        TF_cari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TF_cariFocusGained(evt);
            }
        });
        TF_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_cariKeyReleased(evt);
            }
        });

        TB_inventori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Barang", "Harga", "Stok", "TEs"
            }
        ));
        TB_inventori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_inventoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TB_inventori);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TF_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LB_harga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LB_stok, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(79, 79, 79)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(BT_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LB_nama)
                        .addGap(18, 18, 18)
                        .addComponent(TF_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_nama)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BT_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BT_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LB_harga))
                        .addGap(18, 18, 18)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TF_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LB_stok)))
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BT_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BT_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(TF_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(panelMain);
        panelMain.setBounds(0, 50, 600, 450);

        setSize(new java.awt.Dimension(616, 538));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_batalActionPerformed
        TF_nama.setText("");
        TF_harga.setText("");
        TF_stok.setText("");
        TF_cari.setText("Pencarian");
    }//GEN-LAST:event_BT_batalActionPerformed

    private void BT_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_hapusActionPerformed
        pilih = JOptionPane.showConfirmDialog (null, "Yakin ?","Hapus Data",JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
            try {
                koneksi.koneksi();
                koneksi.koneksi.createStatement().executeUpdate("DELETE FROM stok WHERE id_barang = '"+id_barang+"'");
                JOptionPane.showMessageDialog(null, "Berhasil Hapus Barang");
                readData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Hapus Barang : "+ex);
            }
        }
    }//GEN-LAST:event_BT_hapusActionPerformed

    private void BT_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ubahActionPerformed
        pilih = JOptionPane.showConfirmDialog (null, "Yakin ?","Edit Data",JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
                nama = TF_nama.getText();
                harga = Integer.parseInt(TF_harga.getText());
                stok = Integer.parseInt(TF_stok.getText());
                try {
                    koneksi.koneksi();
                    koneksi.koneksi.createStatement().executeUpdate("UPDATE stok SET nama_barang = '"+nama+"', harga = "+harga+", stok = "+stok+" WHERE id_barang = '"+id_barang+"'");
                    JOptionPane.showMessageDialog(null, "Berhasil Edit Barang");
                    readData();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Gagal Edit Barang : "+ex);
                }
            }
    }//GEN-LAST:event_BT_ubahActionPerformed

    private void BT_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_tambahActionPerformed
        pilih = JOptionPane.showConfirmDialog (null, "Data sudah benar ?","Data Barang",JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_OPTION){
            nama = TF_nama.getText();
            harga = Integer.parseInt(TF_harga.getText());
            stok  = Integer.parseInt(TF_stok.getText());
            try {
                koneksi.koneksi();
                koneksi.koneksi.createStatement().executeUpdate("INSERT INTO stok VALUES ('"+id_barang+"','"+nama+"','"+harga+"','"+stok+"')");
                JOptionPane.showMessageDialog(null, "Berhasil Tambah Barang");
                readData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Tambah Barang : "+ex);
            }
        }
    }//GEN-LAST:event_BT_tambahActionPerformed

    private void TB_inventoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_inventoriMouseClicked
        index = TB_inventori.getSelectedRow();
        if(index>-1){
            id_barang = model.getValueAt(index, 0).toString();
            TF_nama.setText(model.getValueAt(index, 1).toString());
            TF_harga.setText(model.getValueAt(index,2).toString());
            TF_stok.setText(model.getValueAt(index,3).toString());
        }
        JOptionPane.showMessageDialog(null, "Data Terpilih");
    }//GEN-LAST:event_TB_inventoriMouseClicked

    private void TF_hargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_hargaKeyTyped
        CekAngka(evt);
    }//GEN-LAST:event_TF_hargaKeyTyped

    private void TF_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_cariKeyReleased
        cari = TF_cari.getText();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) TB_inventori.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(TF_cari.getText()));

        TB_inventori.setRowSorter(sorter);
    }//GEN-LAST:event_TF_cariKeyReleased

    private void BT_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_kembaliActionPerformed
        dispose();
    }//GEN-LAST:event_BT_kembaliActionPerformed

    private void TF_cariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TF_cariFocusGained
        TF_cari.setText("");
    }//GEN-LAST:event_TF_cariFocusGained
    
    private void readData() {
        int row = TB_inventori.getRowCount();
        for (int i=0 ; i<row ; i++){
            model.removeRow(0);
        }
        try {
            koneksi.koneksi();
            ResultSet res = koneksi.koneksi.createStatement().executeQuery("SELECT * FROM stok");
            while (res.next()){
                String data[] = {res.getString(1),res.getString(2),res.getString(3),res.getString(4)};
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void idBarang() {
        try {
            koneksi.koneksi();
            ResultSet r = koneksi.koneksi.createStatement().executeQuery("SELECT * FROM stok ORDER by id_barang DESC");
            if (r.next()) {
                String nofak = r.getString("id_barang").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                id_barang = "A" + Nol + AN;
            } else {
                id_barang = "A0001";
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
     
    }
    
    public void CekAngka(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "Hanya Bisa Memasukan Karakter Angka", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
    }
    
    public void CekHuruf(KeyEvent b){
        if(Character.isDigit(b.getKeyChar())){
           b.consume();
           JOptionPane.showMessageDialog(null, "Hanya Bisa Memasukan Karakter Huruf", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_batal;
    private javax.swing.JButton BT_hapus;
    private javax.swing.JButton BT_kembali;
    private javax.swing.JButton BT_tambah;
    private javax.swing.JButton BT_ubah;
    private javax.swing.JLabel LB_harga;
    private javax.swing.JLabel LB_header;
    private javax.swing.JLabel LB_nama;
    private javax.swing.JLabel LB_stok;
    private javax.swing.JTable TB_inventori;
    private javax.swing.JTextField TF_cari;
    private javax.swing.JTextField TF_harga;
    private javax.swing.JTextField TF_nama;
    private javax.swing.JTextField TF_stok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
