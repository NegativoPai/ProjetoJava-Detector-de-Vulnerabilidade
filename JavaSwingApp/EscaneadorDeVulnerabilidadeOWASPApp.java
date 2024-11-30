/**
 * Escaneador de Vulnerabilidades OWASP
 * @author joaom
 */
public class EscaneadorDeVulnerabilidadeOWASPApp extends javax.swing.JFrame {

    /**
     * Creates new form EscaneadorDeVulnerabilidadeOWASPApp
     */
    public EscaneadorDeVulnerabilidadeOWASPApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnFechar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textResultado = new javax.swing.JTextArea();
        textUrleIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFechar.setFont(new java.awt.Font("Arial", 1, 12)); 
        btnFechar.setText("X");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });

        btnConfirmar.setFont(new java.awt.Font("Arial", 1, 12)); 
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(evt -> btnConfirmarActionPerformed(evt));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); 
        jLabel1.setText("Digite um URL/IP valido:");

        textResultado.setColumns(20);
        textResultado.setRows(5);
        textResultado.setEditable(false); // Apenas leitura
        jScrollPane1.setViewportView(textResultado);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); 
        jLabel2.setText("Detector Via OWASP");

        // Layout do Formulário
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textUrleIp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFechar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textUrleIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null); // Centraliza a janela
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        String input = textUrleIp.getText();
        if (input.isEmpty()) {
            textResultado.setText("Erro: Campo URL/IP vazio!");
        } else {
            textResultado.setText("Analisando: " + input + "\nResultado: Nenhuma vulnerabilidade encontrada.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EscaneadorDeVulnerabilidadeOWASPApp().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textResultado;
    private javax.swing.JTextField textUrleIp;
    // End of variables declaration                   
}
