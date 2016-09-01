/* 
 * Copyright 2016 Orange.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tracer.ui;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import tracer.utils.tabs.LogTableRenderer;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class LoggerUI extends javax.swing.JFrame {
    
    private final String LOG_BK = "#";
    private Object[] rmqNodeData;
    
    private final String LOG_EXCHANGE_NAME = "amq.rabbitmq.log";
    private final String LOG_EXCHANGE_TYPE = "topic";
    
    //the inbox will be used afterwards for saving log files
    //private final ArrayList<Object[]> inbox = new ArrayList<Object[]>();
    
    private final SimpleDateFormat myDateFormatter =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    
    public LoggerUI() {
        initComponents();
        initLogTable();
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
        logTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rabbitIP = new javax.swing.JTextField();
        rabbitPort = new javax.swing.JTextField();
        rabbitID = new javax.swing.JTextField();
        rabbitPass = new javax.swing.JPasswordField();
        rabbitVHost = new javax.swing.JTextField();
        rabbitTimeout = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RabbitMQ Node Logger");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/tracer/res/rabbit.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        logTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "timestamp", "type", "message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        logTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        LogTableRenderer myRenderer = new LogTableRenderer();
        logTable.setDefaultRenderer(Object.class, myRenderer);
        jScrollPane1.setViewportView(logTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" RabbitMQ Node Configuration "));

        jLabel1.setText("Host IP:");

        jLabel2.setText("User ID:");

        jLabel3.setText("User Password:");

        jLabel4.setText("Host Port:");

        jLabel5.setText("RabbitMQ Virtual Host:");

        jLabel6.setText("RabbitMQ Timeout:");

        rabbitIP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitIPFocusGained(evt);
            }
        });

        rabbitPort.setText("5672");
        rabbitPort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitPortFocusGained(evt);
            }
        });

        rabbitID.setText("guest");
        rabbitID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitIDFocusGained(evt);
            }
        });

        rabbitPass.setText("guest");
        rabbitPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitPassFocusGained(evt);
            }
        });

        rabbitVHost.setText("/");
        rabbitVHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitVHostFocusGained(evt);
            }
        });

        rabbitTimeout.setText("500");
        rabbitTimeout.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitTimeoutFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitIP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitPort))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rabbitID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitPass))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitTimeout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitVHost)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rabbitIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rabbitPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rabbitID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rabbitPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rabbitVHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rabbitTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Get Log");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Quit");
        jButton2.setMaximumSize(new java.awt.Dimension(69, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(69, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Save as..");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Quit..");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean isValidConfig = true;
        if(rabbitIP.getText().isEmpty()){
            System.out.println("the RabbitMQ host IP cannot be empty..");
            isValidConfig = false;
        }
        int port = 5672;
        try{
            port = Integer.parseInt(rabbitPort.getText());
            if(port < 0 || port > 65535){
                System.out.println("the port you defined is not valid, using"
                        + " default 5672..");
            }
        }catch(NumberFormatException ex){
            System.out.println("the port you defined is not valid..");
            isValidConfig = false;
        }
        if(rabbitID.getText().isEmpty()){
            System.out.println("the RabbitMQ username cannot be empty..");
            isValidConfig = false;
        }
        if(rabbitPass.getPassword().length == 0){
            System.out.println("the RabbitMQ password cannot be empty..");
            isValidConfig = false;
        }
        if(rabbitVHost.getText().isEmpty()){
            System.out.println("the RabbitMQ virtual host cannot be empty..");
            isValidConfig = false;
        }
        int timeout = 500;
        try{
            timeout = Integer.parseInt(rabbitTimeout.getText());
            if(timeout < 0){
                System.out.println("the timeout you defined is not valid, "
                        + "using default 500ms..");
            }
        }catch(NumberFormatException ex){
            System.out.println("the timeout you defined is not valid..");
            isValidConfig = false;
        }
        if(isValidConfig){
            connectRMQNode(new Object[]{rabbitIP.getText(),
                port, 
                rabbitID.getText(), 
                String.copyValueOf(rabbitPass.getPassword()),
                rabbitVHost.getText(),
                timeout
            });
        }else{
            System.out.println("please check the confguration and try again!");
        }
        if(isValidConfig){
            rmqNodeData = new Object[]{rabbitIP.getText(), port, 
                rabbitID.getText(), 
                String.copyValueOf(rabbitPass.getPassword()), 
                rabbitVHost.getText(), timeout
            };
            connectRMQNode(rmqNodeData);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disconnectRMQNode(rmqNodeData);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        disconnectRMQNode(rmqNodeData);
    }//GEN-LAST:event_formWindowClosing

    private void rabbitIPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitIPFocusGained
        rabbitIP.selectAll();
    }//GEN-LAST:event_rabbitIPFocusGained

    private void rabbitPortFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitPortFocusGained
        rabbitPort.selectAll();
    }//GEN-LAST:event_rabbitPortFocusGained

    private void rabbitIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitIDFocusGained
        rabbitID.selectAll();
    }//GEN-LAST:event_rabbitIDFocusGained

    private void rabbitPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitPassFocusGained
        rabbitPass.selectAll();
    }//GEN-LAST:event_rabbitPassFocusGained

    private void rabbitVHostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitVHostFocusGained
        rabbitVHost.selectAll();
    }//GEN-LAST:event_rabbitVHostFocusGained

    private void rabbitTimeoutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitTimeoutFocusGained
        rabbitTimeout.selectAll();
    }//GEN-LAST:event_rabbitTimeoutFocusGained

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jButton2ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.out.println("not implemented yet..");
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable logTable;
    private javax.swing.JTextField rabbitID;
    private javax.swing.JTextField rabbitIP;
    private javax.swing.JPasswordField rabbitPass;
    private javax.swing.JTextField rabbitPort;
    private javax.swing.JTextField rabbitTimeout;
    private javax.swing.JTextField rabbitVHost;
    // End of variables declaration//GEN-END:variables
    
    //connection objects
    private Connection myConnection;
    private Channel myChannel;
    
    private void connectRMQNode(Object[] rmqNodeData) {
        try {
            com.rabbitmq.client.ConnectionFactory myFactory =
                    new ConnectionFactory();
            myFactory.setHost((String) rmqNodeData[0]);
            myFactory.setPort((Integer) rmqNodeData[1]);
            myFactory.setUsername((String) rmqNodeData[2]);
            myFactory.setPassword((String) rmqNodeData[3]);
            myFactory.setVirtualHost((String) rmqNodeData[4]);
            myFactory.setConnectionTimeout((Integer) rmqNodeData[5]);
            
            //Automatic recovery from network failures
            myFactory.setAutomaticRecoveryEnabled(true);
            System.out.println("automatic recovery from network failures is "
                    + "enabled");
            
            System.out.println("creating new connection..");
            myConnection = myFactory.newConnection();
            System.out.println("creating new channel..");
            myChannel = myConnection.createChannel();
            System.out.println("declaring the log exchange..");
            myChannel.exchangeDeclare(LOG_EXCHANGE_NAME, LOG_EXCHANGE_TYPE,
                    true, false, true, null);
            
            System.out.println("creating random queue..");
            String QUEUE_NAME = myChannel.queueDeclare().getQueue();
            
            System.out.println("binding to exchange="+LOG_EXCHANGE_NAME+
                        " using binding key="+LOG_BK);
            myChannel.queueBind(QUEUE_NAME, LOG_EXCHANGE_NAME, LOG_BK);

            System.out.println("waiting for messages, this may take few seconds"
                    + "..");
            
            com.rabbitmq.client.Consumer myConsumer =
                    new DefaultConsumer(myChannel){
                int messageCounter = 1;

                @Override
                public void handleDelivery(String consumerTag,
                    Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {

                    String messageCore = new String (body, "UTF-8");

                    addNewMessageToInbox(new Object[]{messageCounter,
                        getFormattedTime(), envelope.getRoutingKey(),
                        messageCore});

                    // Properties object added to message object
                    displayNewMessage(new Object[]{messageCounter,
                        getFormattedTime(), envelope.getRoutingKey(),
                        messageCore});
                    messageCounter++;
                }

                private String getFormattedTime() {
                    return myDateFormatter.format(new Date());
                }

                public void addNewMessageToInbox(Object[] message){
                    //inbox.add(message);
                }

                private void displayNewMessage(Object[] data) {
                    DefaultTableModel logTableModel = 
                            (DefaultTableModel) logTable.getModel();
                    logTableModel.addRow(data);
//                    for (int i = 0; i < data.length; i++) {
//                        logTable.setValueAt(data[i], logTable.getRowCount()+1,
//                                i);
//                    }
                }
            };
            myChannel.basicConsume(QUEUE_NAME, true, myConsumer);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } catch (TimeoutException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    private void disconnectRMQNode(Object[] rmqNodeData) {
        if(rmqNodeData != null){
            if(myChannel != null && myChannel.isOpen()){
                System.out.println("closing channel..");
                try {
                    myChannel.close();
                    System.out.println("channel closed successfully..");
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                } catch (TimeoutException ex) {
                    ex.printStackTrace(System.out);
                }
                if(myConnection != null && myConnection.isOpen()){
                    System.out.println("disconnecting from rabbit node..");
                    try {
                        myConnection.close();
                        System.out.println("disconnected successfully..");
                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
            }
        }
    }
    
    private void initLogTable() {
        JTableHeader header = logTable.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.ORANGE);
        logTable.getColumnModel().getColumn(0).setMaxWidth(70);
        logTable.getColumnModel().getColumn(0).setPreferredWidth(35);
        logTable.getColumnModel().getColumn(1).setMaxWidth(150);
        logTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        logTable.getColumnModel().getColumn(2).setMaxWidth(80);
        logTable.getColumnModel().getColumn(2).setPreferredWidth(60);
    }
}
