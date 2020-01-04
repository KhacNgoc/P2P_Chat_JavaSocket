/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.server;
import static Server.server.SERVER_PORT;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author khacngoc
 */
public class client extends javax.swing.JFrame {

    /**
     * Creates new form client
     */
    public final static int SERVER_PORT = 9999;
    public final static String ip = "127.0.0.1";
    
    public static ServerSocket serverCli;
    public static DataInputStream inserver;
    public static DataOutputStream outserver;
    
    private static Socket socket;
    private static String port_client;
    private static String name;
    
    public static DataInputStream inp2p;
    public static DataOutputStream outp2p;
    
    private static Socket sockp2p;
    public static String messp2p;
    
    DefaultListModel<String> model_client = new DefaultListModel<String>();
    
    public client() {
        initComponents();
        list_ol.setModel(model_client);
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_cli = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_ol = new javax.swing.JList<>();
        txt_mess = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_port = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        jLabel1.setText("Client");

        txt_cli.setColumns(20);
        txt_cli.setRows(5);
        jScrollPane2.setViewportView(txt_cli);

        list_ol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_olMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(list_ol);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_port.setText("Port");

        txt_name.setText("Name");

        jButton2.setText("Connect");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(50, 234, 22));
        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(75, 222, 18));
        jLabel2.setText("Online");

        jButton3.setText("Disconnect");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_mess, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mess)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class ServerClient implements Runnable{
        @Override
        public void run(){
            try {
                port_client = txt_port.getText();
                name = txt_name.getText();
                serverCli = new ServerSocket(Integer.parseInt(port_client));
                txt_cli.append("Server client Started!!!\n");
                txt_cli.append("Waiting clients connected!\n");
                while(true){
                    sockp2p = serverCli.accept();
                    txt_cli.append("Accept "+socket+"\n");
                    Thread t = new Thread(new P2P(sockp2p));
                    t.start();
                    txt_cli.append(sockp2p.getRemoteSocketAddress().toString()+"\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public class IncomingReaderP2p extends Thread{
        DataInputStream in;
        public IncomingReaderP2p(DataInputStream inn){
            this.in = inn;
        }
        @Override
        public void run(){
            String data;
            try {
                while ((data = in.readUTF()) != null){
                    String[] m = data.split(":");
                    txt_cli.append(m[0]+": "+m[1]+"\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public class IncomingReader extends Thread{
        DataInputStream in;
        public IncomingReader(DataInputStream inn){
            this.in = inn;
        }
        @Override
        public void run(){
            String data;
            int temp;
            try {
                while ((data = in.readUTF()) != null){
                    String[] m = data.split(":");
                    temp = m.length;
                    System.out.println(temp);
                    if(m[temp-1].equals("online")){
                        model_client.clear();
                        for(String a : m){
                            model_client.addElement(a);
                        }
                        model_client.remove(temp-1);
                        list_ol.setModel(model_client);
                    }
                    else if(m[1].equals("connectp2p")){
                        sockp2p = new Socket(ip, Integer.parseInt(m[0]));
                        inp2p = new DataInputStream(sockp2p.getInputStream());
                        outp2p = new DataOutputStream(sockp2p.getOutputStream());
                        Thread messp2p = new Thread(new IncomingReaderP2p(inp2p));
                        messp2p.start();
                    }
                    else if(m[1].equals("connected")){
                        txt_cli.append(m[0]+" connected."+"\n");
                    }
                    else{
                        txt_cli.append(m[0]+": "+m[1]+"\n");
                    }
                }
           }catch(Exception e){
                System.out.println(e.getMessage());
           }
        }
    }
    public void sentToServer(String mess) throws IOException{
        outserver.writeUTF(mess);
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(txt_port.getText() == null || txt_name.getText() == null){
            JOptionPane.showMessageDialog(null, "Can not empty!");
        }
        else{
            this.port_client = txt_port.getText();
            this.name = txt_name.getText();
            try {
                socket = new Socket(ip, SERVER_PORT);
                inserver = new DataInputStream(socket.getInputStream());
                outserver = new DataOutputStream(socket.getOutputStream());
                outserver.writeUTF(port_client+":"+name+":connect");
                Thread t = new Thread(new ServerClient());
                t.start();
                Thread message = new Thread(new IncomingReader(inserver));
                message.start();
//                serverCli = new ServerSocket(Integer.parseInt(this.port_client));
//                txt_cli.append("Server "+this.port_client+" started.");
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String mess = name+":"+txt_mess.getText()+":send";
        
        try {
            if(sockp2p != null){
                System.out.println(mess);
                txt_cli.append(name+": "+txt_mess.getText()+"\n");
                outp2p.writeUTF(mess);
            }
            else{
                sentToServer(mess);
            }
            txt_mess.setText("");
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void list_olMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_olMouseClicked
        try {
            // TODO add your handling code here:
            outserver.writeUTF("get:"+list_ol.getSelectedValue()+":wanttoconnect");
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_list_olMouseClicked

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
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList<String> list_ol;
    public static javax.swing.JTextArea txt_cli;
    private javax.swing.JTextField txt_mess;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_port;
    // End of variables declaration//GEN-END:variables
}
class P2P extends Thread{
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;
    public P2P(Socket so){
        this.socket=so;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(P2P.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run(){
        String mess;
        try{
            while((mess = in.readUTF()) != null){
                String[] m = mess.split(":");
                System.out.println(mess);
                //client.messp2p = mess;
                client.txt_cli.append(m[0]+": "+m[1]+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(P2P.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
