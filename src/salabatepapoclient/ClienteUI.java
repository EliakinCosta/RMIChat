package salabatepapoclient;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import salabatepapoclient.Util.VerificadorServidor;
import salabatepapoclient.interfaces.ICliente;
import salabatepapoclient.interfaces.IServidor;

public class ClienteUI extends JFrame implements Runnable {

    private ICliente cliente;
    private IServidor servidor;
    private boolean isConectado;

    public ClienteUI() {
        initComponents();
        jPnlLogin.setVisible(true);
        JpnlChat.setVisible(false);
        jTxarConversa.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jPnlLogin = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFTxIp = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxfApelido = new javax.swing.JTextField();
        jBtnConectar = new javax.swing.JButton();
        JpnlChat = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLstParticipantes = new javax.swing.JList<>();
        jBtbEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxarConversa = new javax.swing.JTextArea();
        jTxtMensagem = new javax.swing.JTextField();
        jBtnDesconectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bate Papo D'uol");
        setMaximumSize(new java.awt.Dimension(450, 685));
        setMinimumSize(new java.awt.Dimension(450, 685));
        setName("mainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(450, 685));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(450, 950));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(450, 950));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speech-bubble-128.png"))); // NOI18N
        jLabel1.setText("Bate Papo D'uol");
        jLabel1.setToolTipText("Bate Papo D'uol");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEtchedBorder()));
        jLabel1.setFocusable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Login"));
        jPanel2.setMaximumSize(new java.awt.Dimension(384, 300));
        jPanel2.setMinimumSize(new java.awt.Dimension(384, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(384, 300));

        jLabel2.setText("Endereço");
        jLabel2.setToolTipText("Endereço");

        try {
            jFTxIp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTxIp.setToolTipText("Endereço");

        jLabel3.setText("Apelido");
        jLabel3.setToolTipText("Apelido");

        jTxfApelido.setToolTipText("Apelido");

        jBtnConectar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jBtnConectar.setText("Conectar");
        jBtnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnConectar)
                    .addComponent(jFTxIp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxfApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFTxIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxfApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jBtnConectar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnlLoginLayout = new javax.swing.GroupLayout(jPnlLogin);
        jPnlLogin.setLayout(jPnlLoginLayout);
        jPnlLoginLayout.setHorizontalGroup(
            jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
            .addGroup(jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnlLoginLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE)))
        );
        jPnlLoginLayout.setVerticalGroup(
            jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
            .addGroup(jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnlLoginLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        JpnlChat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JpnlChat.setEnabled(false);
        JpnlChat.setMaximumSize(new java.awt.Dimension(426, 470));
        JpnlChat.setMinimumSize(new java.awt.Dimension(426, 470));
        JpnlChat.setPreferredSize(new java.awt.Dimension(426, 470));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Participantes"));
        jPanel1.setMaximumSize(new java.awt.Dimension(130, 382));
        jPanel1.setMinimumSize(new java.awt.Dimension(130, 382));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("Participantes");
        jScrollPane2.setMaximumSize(new java.awt.Dimension(41, 146));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(41, 146));

        jLstParticipantes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jLstParticipantes.setToolTipText("Participantes");
        jLstParticipantes.setAutoscrolls(false);
        jScrollPane2.setViewportView(jLstParticipantes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jBtbEnviar.setText("Enviar");
        jBtbEnviar.setAlignmentY(0.0F);
        jBtbEnviar.setIconTextGap(0);
        jBtbEnviar.setMargin(new java.awt.Insets(8, 0, 8, 0));
        jBtbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbEnviarActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAlignmentX(0.0F);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(285, 420));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(285, 420));
        jScrollPane1.setName(""); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(285, 420));

        jTxarConversa.setColumns(20);
        jTxarConversa.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTxarConversa.setLineWrap(true);
        jTxarConversa.setRows(10);
        jTxarConversa.setTabSize(4);
        jTxarConversa.setToolTipText("");
        jScrollPane1.setViewportView(jTxarConversa);

        jTxtMensagem.setToolTipText("Vamos lá, diga alguma coisa.");
        jTxtMensagem.setMaximumSize(new java.awt.Dimension(69, 22));
        jTxtMensagem.setMinimumSize(new java.awt.Dimension(69, 22));
        jTxtMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtMensagemKeyPressed(evt);
            }
        });

        jBtnDesconectar.setText("Desconectar");
        jBtnDesconectar.setToolTipText("Desconectar");
        jBtnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDesconectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnlChatLayout = new javax.swing.GroupLayout(JpnlChat);
        JpnlChat.setLayout(JpnlChatLayout);
        JpnlChatLayout.setHorizontalGroup(
            JpnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(JpnlChatLayout.createSequentialGroup()
                .addGroup(JpnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnlChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JpnlChatLayout.createSequentialGroup()
                        .addComponent(jTxtMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        JpnlChatLayout.setVerticalGroup(
            JpnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlChatLayout.createSequentialGroup()
                .addGroup(JpnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnlChatLayout.createSequentialGroup()
                        .addComponent(jBtnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(2, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPnlLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(JpnlChat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpnlChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpnlChat, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConectarActionPerformed
        this.conectarServidor();
    }//GEN-LAST:event_jBtnConectarActionPerformed

    private void conectarServidor() throws HeadlessException {
        if (jTxfApelido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Você precisa informar um apelido.");
            return;
        }
        if (jFTxIp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Você precisa informar um endereço de IP.");
            return;
        }
        try {
            if (!isConectado) {
                jTxarConversa.setText("");
                cliente = new Cliente(jTxfApelido.getText(), this);
                String mensagem = cliente.getApelido() + ", entrou na sala.";
                servidor = (IServidor) Naming.lookup("rmi://" + jFTxIp.getText() + "/batePapoDuol");
                servidor.registrar(cliente);
                servidor.publicarMensagem(mensagem);
                ArrayList<ICliente> clientesConectados = servidor.getClientesConectados();
                for (ICliente clienteConectado : clientesConectados) {
                    clienteConectado.atualizarParticipantes();
                }
                isConectado = true;
                jPnlLogin.setVisible(false);
                JpnlChat.setVisible(true);
            }
            new Thread(this).start();
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao tentar se conectar com o servidor.");
            Logger.getLogger(ClienteUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void jBtbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbEnviarActionPerformed
        try {
            servidor.publicarMensagem(cliente.getApelido() + " disse:\r\n  " + jTxtMensagem.getText());
            this.jTxtMensagem.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtbEnviarActionPerformed

    private void jBtnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDesconectarActionPerformed
        this.desconectarServidor();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnDesconectarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.desconectarServidor();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTxtMensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtMensagemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.jBtbEnviarActionPerformed(null);
        }
    }//GEN-LAST:event_jTxtMensagemKeyPressed

    private void desconectarServidor() throws HeadlessException {
        try {
            if (isConectado) {
                String mensagem = cliente.getApelido() + ", saiu da sala.";
                servidor.desregistrar(cliente);
                servidor.publicarMensagem(mensagem);

                ArrayList<ICliente> clientesConectados = servidor.getClientesConectados();
                for (ICliente clienteConectado : clientesConectados) {
                    clienteConectado.atualizarParticipantes();
                }
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao tentar se desconectar do servidor.");
            Logger.getLogger(ClienteUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            isConectado = false;
            jPnlLogin.setVisible(true);
            JpnlChat.setVisible(false);
        }
    }

    public void escreverMensagem(String mensagem) {
        jTxarConversa.append(mensagem + "\n\r");
    }

    public void atualizarUsuario() {
        try {
            final DefaultListModel<String> listaParticipantes = new DefaultListModel<>();
            ArrayList<ICliente> clientesConectados = servidor.getClientesConectados();
            for (ICliente clienteConectado : clientesConectados) {
                listaParticipantes.addElement(clienteConectado.getApelido());
            }
            this.jLstParticipantes.setModel(listaParticipantes);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            ClienteUI clienteUI = new ClienteUI();
            clienteUI.setLocationRelativeTo(null);
            clienteUI.setVisible(true);
        });

    }

    @Override
    public synchronized void run() {
        VerificadorServidor verificadorServidor = new VerificadorServidor();
        try {
            while (true) {
                verificadorServidor.verificar();
                Thread.sleep(1000);
            }
        } catch (InterruptedException | NotBoundException | RemoteException ex) {
            Logger.getLogger(VerificadorServidor.class.getName()).log(Level.SEVERE, null, ex);
            if (!Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupt();
            }
            JOptionPane.showMessageDialog(this, "Falha no servidor. Servidor fora do ar.");
            this.desconectarServidor();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpnlChat;
    private javax.swing.JButton jBtbEnviar;
    private javax.swing.JButton jBtnConectar;
    private javax.swing.JButton jBtnDesconectar;
    private javax.swing.JFormattedTextField jFTxIp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jLstParticipantes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPnlLogin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTxarConversa;
    private javax.swing.JTextField jTxfApelido;
    private javax.swing.JTextField jTxtMensagem;
    // End of variables declaration//GEN-END:variables

}

class Cliente extends UnicastRemoteObject implements ICliente {

    private final String apelido;
    private final ClienteUI clienteUi;

    public Cliente(String apelido, ClienteUI clienteUi) throws RemoteException {
        this.apelido = apelido;
        this.clienteUi = clienteUi;
    }

    @Override
    public void informar(String mensagem) throws RemoteException {
        clienteUi.escreverMensagem(mensagem);
    }

    @Override
    public String getApelido() throws RemoteException {
        return apelido;
    }

    @Override
    public void atualizarParticipantes() throws RemoteException {
        clienteUi.atualizarUsuario();
    }

}
