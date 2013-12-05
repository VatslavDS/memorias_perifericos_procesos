package tablasconresulset;

import static java.awt.Component.BOTTOM_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;



/**
 * @author Jorge Martínez
 */
public class llenarJTable extends javax.swing.JFrame {
    
    public int memoria = 0;
    
    public ArrayList pila = new ArrayList();
    
    public static int idProceso;
    public static String Proceso;
    public static int duracion;
    public static int tamanio;
    /////////////////////////////////////////////
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3307/gestion";
    //Declarando las credenciales de la base de datos
    static final String usuario ="root";
    static final String PASS = "jorge57623558";
    ///////////////////////////////////////////
    public Connection conn = null;
    public Statement stat;
    
    public Date fecha;
    static Timer tiempo;
    public int n = 0;

    
    public llenarJTable() throws ClassNotFoundException, SQLException {
        super("Gestion de Memoria");
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, usuario, PASS);
        PreparedStatement psInsertar = null;
        PreparedStatement psInsertar1 = null;
        psInsertar = conn.prepareStatement("DELETE FROM datosprocesos");
        psInsertar1 = conn.prepareStatement("DELETE FROM procesoseliminados");
        psInsertar.executeUpdate();
        psInsertar1.executeUpdate();
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 153));
        setFont(new java.awt.Font("Agency FB", 0, 10)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jLabel1.setText("                                                   Gestion de Procesos");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setBackground(new java.awt.Color(255, 204, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 102, 51));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Meiryo", 1, 11)); // NOI18N
        jButton1.setText("Memoria");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Meiryo", 1, 11)); // NOI18N
        jButton2.setText("Cola");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Meiryo", 1, 11)); // NOI18N
        jLabel7.setText("By Jorge Alberto Martínez Escandón");

        jLabel8.setText("ID Proceso");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Proceso");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Duración");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Meiryo", 1, 11)); // NOI18N
        jButton4.setText("Cargar");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Memoria");

        jLabel3.setText("Tamaño");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Meiryo", 1, 11)); // NOI18N
        jLabel11.setText("Presionar Enter en cada Entrada.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(20, 20, 20)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// ESTE ES EL BOTON QUE MUESTRA LOS PROCESOS CARGANDOSE LO UTILIZARÉ PARA LA PILA DE MEMORIA
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        //Para establecer el modelo al JTable
        DefaultTableModel modelo = new DefaultTableModel();
        this.jTable1.setModel(modelo);
        //Registrando el driver del JDBC
        Class.forName(JDBC_DRIVER);
        //Abriendo la conexion
        System.out.println("Conectando ala base de datos...");
        conn = DriverManager.getConnection(DB_URL, usuario, PASS);
        Statement s = conn.createStatement();
        //Ejecutamos la consulta que escribimos en la caja de texto
        //y los datos lo almacenamos en un ResultSet
        ResultSet rs = s.executeQuery("SELECT * FROM datosprocesos;");
        //Obteniendo la informacion de las columnas que estan siendo consultadas
        ResultSetMetaData rsMd = rs.getMetaData();
        //La cantidad de columnas que tiene la consulta
        int cantidadColumnas = rsMd.getColumnCount();
        //Establecer como cabezeras el nombre de las colimnas
        for (int i = 1; i <= cantidadColumnas; i++) {
        modelo.addColumn(rsMd.getColumnLabel(i));
        }
        //Creando las filas para el JTable
        while (rs.next()) {
        Object[] fila = new Object[cantidadColumnas];
        for (int i = 0; i < cantidadColumnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        modelo.addRow(fila);
        }
        rs.close();
        conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
//  Este es el de los procesos eliminados la tabla de procesos eliminados
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
        //Para establecer el modelo al JTable
        DefaultTableModel modelo = new DefaultTableModel();
        this.jTable1.setModel(modelo);
        //Registrando el driver del JDBC
        Class.forName(JDBC_DRIVER);
        //Abriendo la conexion
        System.out.println("Conectando ala base de datos...");
        conn = DriverManager.getConnection(DB_URL, usuario, PASS);
        Statement s = conn.createStatement();
        //Ejecutamos la consulta que escribimos en la caja de texto
        //y los datos lo almacenamos en un ResultSet
        ResultSet rs = s.executeQuery("SELECT * FROM procesoseliminados");
        //Obteniendo la informacion de las columnas que estan siendo consultadas
        ResultSetMetaData rsMd = rs.getMetaData();
        //La cantidad de columnas que tiene la consulta
        int cantidadColumnas = rsMd.getColumnCount();
        //Establecer como cabezeras el nombre de las colimnas
        for (int i = 1; i <= cantidadColumnas; i++) {
        modelo.addColumn(rsMd.getColumnLabel(i));
        }
        //Creando las filas para el JTable
        while (rs.next()) {
        Object[] fila = new Object[cantidadColumnas];
        for (int i = 0; i < cantidadColumnas; i++) {
            fila[i]=rs.getObject(i+1);
        }
        modelo.addRow(fila);
        }
        rs.close();
        conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
      
        idProceso = Integer.parseInt(jTextField1.getText());
        System.out.println(idProceso);
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        Proceso = jTextField2.getText();
        System.out.println(Proceso);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        duracion = Integer.parseInt(jTextField3.getText());
        duracion = duracion * 100;
        System.out.println(duracion);
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(memoria < 40){
            try {
                    //Registrando el driver del JDBC
                    Class.forName(JDBC_DRIVER);
                    //Abriendo la conexion
                    System.out.println("Conectando ala base de datos...");
                    conn = DriverManager.getConnection(DB_URL, usuario, PASS);
                
                    fecha = new Date(0);
                    //Ejecutando un query
                    PreparedStatement psInsertar = null;
                    psInsertar = conn.prepareStatement("INSERT INTO datosprocesos VALUES (?, ?, ?, ?, ?)");
                    psInsertar.setInt(1, idProceso);
                    psInsertar.setString(2, Proceso);
                    psInsertar.setInt(3, tamanio);
                    psInsertar.setDate(4, fecha);
                    psInsertar.setInt(5, duracion);
                    psInsertar.executeUpdate();
                    memoria+=10;
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    n+=35;
                    jProgressBar1.setValue(n);
                    tiempo = new Timer(duracion, new ActionListener() {
                            int detencion = 0;
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(detencion < 100){
                                    detencion+=10;
                                }else{
                                    conn = null;
                                    n = n-35;
                                    jProgressBar1.setValue(n);
                                    PreparedStatement psInsertar = null;
                                    PreparedStatement psCopiar = null;
                                    try {
                                        Class.forName(JDBC_DRIVER);
                                        conn = DriverManager.getConnection(DB_URL, usuario, PASS);
                                        psCopiar = conn.prepareStatement("DELETE FROM datosprocesos WHERE idProceso= ?" );
                                        psCopiar.setInt(1, idProceso);
                                        psCopiar.executeUpdate();
                                        System.out.println("Eliminado ultimo registro!");
                                        memoria = memoria - 10;
                                        psInsertar = conn.prepareStatement("INSERT INTO datosprocesos VALUES (?, ?, ?, ?, ?)");
                                        
                                        for(int i = 0; i<=3;i++){
                                            if(i == 1){
                                                psInsertar.setString(i+1, (String) pila.get(i));
                                            }
                                            psInsertar.setInt(i, (int) pila.get(i));
                                        }
                                        psInsertar.executeQuery();
                                        } catch (SQLException ex) {
                                        Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                                        }  
                                    try {
                                        conn.close();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    tiempo.stop();
                                }
                            }                            
                        });
                    if(!tiempo.isRunning()){
                         tiempo.start();
                    }
                try {
                    conn.close();
                    } catch (SQLException ex) {
                    Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                    //Registrando el driver del JDBC
                    Class.forName(JDBC_DRIVER);
                    //Abriendo la conexion
                    System.out.println("Conectando ala base de datos...");
                    conn = DriverManager.getConnection(DB_URL, usuario, PASS);
                
                    fecha = new Date(0);
                    pila.add(idProceso);
                    pila.add(Proceso);
                    pila.add(tamanio);
                    pila.add(fecha);
                    pila.add(duracion);
                    //Ejecutando un query
                    PreparedStatement psInsertar = null;
                    psInsertar = conn.prepareStatement("INSERT INTO procesoseliminados VALUES (?, ?, ?, ?, ?)");
                    psInsertar.setInt(1, idProceso);
                    psInsertar.setString(2, Proceso);
                    psInsertar.setInt(3, tamanio);
                    psInsertar.setDate(4, fecha);
                    psInsertar.setInt(5, duracion);
                    psInsertar.executeUpdate();
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    } catch (ClassNotFoundException ex) {
                    Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                    Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        tamanio = Integer.parseInt(jTextField4.getText());
        System.out.println(tamanio);
    }//GEN-LAST:event_jTextField4ActionPerformed
/*
 * 
 *              Apartir de aqui empezamos con los procesos que se vana cargar
 */
    
    
    
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
            java.util.logging.Logger.getLogger(llenarJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(llenarJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(llenarJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(llenarJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new llenarJTable().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(llenarJTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
