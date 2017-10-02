import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class CongruencialMultiplicativoVista extends JFrame{

    JButton btnCalcular;
    JLabel lbl_x,lbl_k,lbl_g,lbl_m;

    public CongruencialMultiplicativoVista(){
        super("Congruencial Multiplicativo");

        setLayout(new FlowLayout());

        Object[][] datos = new Object[5][3];
        double[][] datos1 = new double[5][3];
        String[] columnas = {"1","2","3","4","5"};

        DefaultTableModel dtm = new DefaultTableModel(datos,columnas);

        JTable tabla = new JTable(dtm);
        tabla.setPreferredScrollableViewportSize(new Dimension(500,140));

        JScrollPane scroll = new JScrollPane(tabla);
        JPanel panel = new JPanel();

        btnCalcular = new JButton("Calcular");

        lbl_x = new JLabel("Valor en x = ");
        lbl_k = new JLabel("Valor en k = ");
        lbl_g = new JLabel("Valor en g = ");
        lbl_m = new JLabel("Valor en m = ");

        panel.add(scroll);
        panel.add(btnCalcular);
        panel.add(lbl_x);
        panel.add(lbl_k);
        panel.add(lbl_g);
        panel.add(lbl_m);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,200);
        this.setVisible(true);

        //Controlador
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }//windowClosing
                }//WindowAdapter
        );
    }//Constructor

    void agregarEscuchadorParaCalcular(ActionListener escuchaParaBotonCalcular){
        btnCalcular.addActionListener(escuchaParaBotonCalcular);
    }//agregarEscuchadorParaCalcular

    void mostrarMensajeError(String mensajeError){
        JOptionPane.showMessageDialog(this,mensajeError);
    }//mostrarMensajeError
    ///Controlador

    public static void main(String[] args){
        CongruencialMultiplicativoVista cmv = new CongruencialMultiplicativoVista();
        cmv.pack();
        cmv.setVisible(true);
    }//main

}//class