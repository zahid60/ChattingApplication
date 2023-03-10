
import java.io.*;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zshan
 */
public class Client_side extends javax.swing.JFrame {

    /**
     * Creates new form Client_side
     */
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    public Client_side() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msz_area = new javax.swing.JTextArea();
        msz_text = new javax.swing.JTextField();
        msz_send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 420));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        msz_area.setColumns(20);
        msz_area.setRows(5);
        jScrollPane1.setViewportView(msz_area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 143, 467, 144));

        msz_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msz_textActionPerformed(evt);
            }
        });
        getContentPane().add(msz_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 305, 370, 50));

        msz_send.setText("Send");
        msz_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msz_sendActionPerformed(evt);
            }
        });
        getContentPane().add(msz_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Send Message:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo3.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 467, 10));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Candara", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Shamim");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg22.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msz_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msz_sendActionPerformed
        // TODO add your handling code here:
        try {
            String msgout = "";
            msgout = msz_text.getText().trim();

                dout.writeUTF(msgout);
                msz_area.setText(msz_area.getText().trim() + "\n \t\t" + msgout + "\t : Shamim Ahmed\n");


        } catch (IOException e) {
            //exception handling
        }
    }//GEN-LAST:event_msz_sendActionPerformed

    private void msz_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msz_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msz_textActionPerformed

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
            java.util.logging.Logger.getLogger(Client_side.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_side.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_side.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_side.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_side().setVisible(true);
            }
        });

        String msgin = "";

        try {

            s = new Socket("127.0.0.1", 5555); // ip address is of localhost because server is running on the same machine

            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while (!msgin.equals("Bye")) {
                msgin = din.readUTF(); // object that hold message recive for server from clients
                msz_area.setText(msz_area.getText().trim() + "\nZahid Hasan : \t" + msgin); //displaying the msz from client side
            }
        } catch (IOException e) {
            // Error handleing
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextArea msz_area;
    private javax.swing.JButton msz_send;
    private javax.swing.JTextField msz_text;
    // End of variables declaration//GEN-END:variables
}
