import javax.swing.JOptionPane;

/**
 * Tela para criar uma conta no sistema.
 * Validações incluídas para funcionamento correto.
 * 
 * @author joaom
 */
public class Criar extends javax.swing.JFrame {

    public Criar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButtonCriar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        textUsuario = new javax.swing.JTextField();
        textSenha = new javax.swing.JPasswordField();
        textConfirmarSenha = new javax.swing.JPasswordField();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jLabelConfirmarSenha = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Criar Conta");

        jButtonCriar.setText("Criar");
        jButtonCriar.addActionListener(evt -> criarConta());

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(evt -> System.exit(0));

        jLabelUsuario.setText("Usuário:");

        jLabelSenha.setText("Senha:");

        jLabelConfirmarSenha.setText("Confirmar Senha:");

        jLabelTitulo.setFont(new java.awt.Font("Arial", 1, 18)); 
        jLabelTitulo.setText("Criar Conta");

        // Layout do Formulário
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelSenha)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabelConfirmarSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCriar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addComponent(textConfirmarSenha)
                            .addComponent(textSenha)
                            .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTitulo)
                        .addGap(27, 27, 27)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSenha))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConfirmarSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCriar)
                    .addComponent(btnCancelar))
                .addGap(82, 82, 82))
        );

        pack();
        setLocationRelativeTo(null); // Centraliza a janela
    }

    /**
     * Lógica para criar a conta, com validação de senha.
     */
    private void criarConta() {
        String usuario = textUsuario.getText();
        String senha = new String(textSenha.getPassword());
        String confirmarSenha = new String(textConfirmarSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (!senha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Conta criada com sucesso!");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Criar().setVisible(true));
    }

    // Declaração de variáveis
    private javax.swing.JButton jButtonCriar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelConfirmarSenha;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField textUsuario;
    private javax.swing.JPasswordField textSenha;
    private javax.swing.JPasswordField textConfirmarSenha;
}
