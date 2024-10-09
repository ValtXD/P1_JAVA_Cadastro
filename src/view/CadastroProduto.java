/*
 * Created by JFormDesigner on Fri Sep 13 18:17:00 AMT 2024
 */

package view;

import controller.P_Acabado_Controller;
import model.ProdutoAcabado;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author etech
 */
public class CadastroProduto extends JFrame {
    public CadastroProduto() {
        initComponents();
    }

    P_Acabado_Controller pac = new P_Acabado_Controller();

    private void btnCadastrar(ActionEvent e) {
        ProdutoAcabado produto = new ProdutoAcabado();
        produto.setNome(txtNome.getText());
        produto.setCodigoLegado(txtCodigo.getText());

        try {
            float preco = Float.parseFloat(txtPreco.getText());
            int garantia = Integer.parseInt(txtGarantia.getText());
            int palete = Integer.parseInt(txtPalete.getText());

            produto.setPreco(preco);
            produto.setGarantia(garantia);
            produto.setQuantidadePalete(palete);

            pac.salvar(produto);
            limparCampos();
            preencherTabela();
            txtNome.requestFocusInWindow();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelar(ActionEvent e) {
        this.dispose();
    }

    private void preencherTabela() {
        String[] colunas = {"Nome", "Preço", "Código", "Garantia", "Qtd Palete"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (ProdutoAcabado produto : pac.getProdutos()) {
            Object[] linha = {
                    produto.getNome(),
                    produto.getPreco(),
                    produto.getCodigoLegado(),
                    produto.getGarantia(),
                    produto.getQuantidadePalete()
            };
            modelo.addRow(linha);
        }
        table1.setModel(modelo);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtPreco.setText("");
        txtCodigo.setText("");
        txtGarantia.setText("");
        txtPalete.setText("");
    }

    private void initComponents() {
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        lBlNome = new JLabel();
        txtNome = new JTextField();
        lBlPreco = new JLabel();
        txtPreco = new JTextField();
        lBlQuantPalete = new JLabel();
        lBlCodigo = new JLabel();
        txtCodigo = new JTextField();
        lBlGarantia = new JLabel();
        txtPalete = new JTextField();
        txtGarantia = new JTextField();
        btnCadastrar = new JButton();
        btnCancelar = new JButton();

        var contentPane = getContentPane();
        contentPane.setLayout(null);

        {
            panel1.setLayout(null);

            {

                table1.setModel(new DefaultTableModel(
                        new Object[][] {
                                {"", null, null, null, ""},
                                {null, null, null, null, ""},
                        },
                        new String[] {
                                "Nome", "Preço", "Código", "Garantia", "Qtd Palete"
                        }
                ));
                table1.setFont(new Font("Inter", Font.BOLD, 14));
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(5, 100, 780, 300);
            {
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(10, 230, 800, 350);
        {
            panel2.setFont(new Font("Inter", Font.PLAIN, 14));
            panel2.setLayout(null);

            lBlNome.setText("Nome:");
            lBlNome.setFont(new Font("Inter", Font.BOLD, 14));
            panel2.add(lBlNome);
            lBlNome.setBounds(10, 35, 55, lBlNome.getPreferredSize().height);

            txtNome.setFont(new Font("Inter", Font.PLAIN, 14));
            panel2.add(txtNome);
            txtNome.setBounds(80, 35, 200, 25);

            lBlPreco.setText("Preço:");
            lBlPreco.setFont(new Font("Inter", Font.BOLD, 14));
            panel2.add(lBlPreco);
            lBlPreco.setBounds(10, 65, 50, 17);

            txtPreco.setFont(new Font("Inter", Font.PLAIN, 14));
            panel2.add(txtPreco);
            txtPreco.setBounds(80, 65, 200, 25);

            lBlQuantPalete.setText("Qtd.Palete:");
            lBlQuantPalete.setFont(new Font("Inter", Font.BOLD, 14));
            panel2.add(lBlQuantPalete);
            lBlQuantPalete.setBounds(10, 175, 100, 17);

            lBlCodigo.setText("Código:");
            lBlCodigo.setFont(new Font("Inter", Font.BOLD, 14));
            panel2.add(lBlCodigo);
            lBlCodigo.setBounds(10, 95, 60, 17);

            txtCodigo.setFont(new Font("Inter", Font.PLAIN, 14));
            panel2.add(txtCodigo);
            txtCodigo.setBounds(80, 95, 200, 25);

            lBlGarantia.setText("Garantia:");
            lBlGarantia.setFont(new Font("Inter", Font.BOLD, 14));
            panel2.add(lBlGarantia);
            lBlGarantia.setBounds(10, 125, 80, 17);

            txtPalete.setFont(new Font("Inter", Font.PLAIN, 14));
            panel2.add(txtPalete);
            txtPalete.setBounds(80, 175, 200, 25);

            txtGarantia.setFont(new Font("Inter", Font.PLAIN, 14));
            panel2.add(txtGarantia);
            txtGarantia.setBounds(80, 125, 200, 25);

            btnCadastrar.setText("Cadastrar");
            btnCadastrar.setFont(new Font("Inter", Font.BOLD, 14));
            btnCadastrar.addActionListener(e -> btnCadastrar(e));
            panel2.add(btnCadastrar);
            btnCadastrar.setBounds(300, 35, 150, 40);

            btnCancelar.setText("Cancelar");
            btnCancelar.setFont(new Font("Inter", Font.BOLD, 14));
            btnCancelar.addActionListener(e -> btnCancelar(e));
            panel2.add(btnCancelar);
            btnCancelar.setBounds(300, 140, 150, 40);

            {
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel2);
        panel2.setBounds(10, 10, 800, 220);

        {
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(830, 620);
        setLocationRelativeTo(getOwner());
    }

    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JLabel lBlNome;
    private JTextField txtNome;
    private JLabel lBlPreco;
    private JTextField txtPreco;
    private JLabel lBlQuantPalete;
    private JLabel lBlCodigo;
    private JTextField txtCodigo;
    private JLabel lBlGarantia;
    private JTextField txtPalete;
    private JTextField txtGarantia;
    private JButton btnCadastrar;
    private JButton btnCancelar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
