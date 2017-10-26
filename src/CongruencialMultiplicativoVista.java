import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class CongruencialMultiplicativoVista extends JFrame{

    JButton btnCalcular;
    JLabel lbl_x,lbl_k,lbl_g,lbl_m;
    JTextField txt_x,txt_k,txt_g,txt_m;
    CongruencialMultiplicativo cm;

    private CongruencialMultiplicativoVista(){
        super("Congruencial Multiplicativo");

        setLayout(new FlowLayout());

        Object[][] datos = new Object[50][20];
        //double[][] datos1 = new double[5][3];
        String[] columnas = {"Números Pseudoaleatorios"};

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

        txt_x = new JTextField("17");
        txt_k = new JTextField("2");
        txt_g = new JTextField("5");
        txt_m = new JTextField("32");

        panel.add(scroll);
        panel.add(btnCalcular);
        panel.add(lbl_x);
        panel.add(txt_x);
        panel.add(lbl_k);
        panel.add(txt_k);
        panel.add(lbl_g);
        panel.add(txt_g);
        panel.add(lbl_m);
        panel.add(txt_m);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setVisible(true);

        cm = new CongruencialMultiplicativo(
                Integer.parseInt(txt_x.getText()),
                Integer.parseInt(txt_k.getText()+""),
                Integer.parseInt(txt_g.getText()+""),
                Integer.parseInt(txt_m.getText()+""),
                50);
        Double cadena[]= new Double[5];
        for (int i=0; i<=49;i++){
               dtm.setValueAt(cm.numeros_psudo_aleatorios[i],i,0);
        }

        //Controlador
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }//windowClosing
                }//WindowAdapter
        );
        //addWindowListener( (WindowAdapter) windowClosing(e) -> ){ System.exit(0);};
    }//Constructor

    public void evento(int x,int k, int g, int m){
        cm = new CongruencialMultiplicativo(x,k,g,m,50);
    }//Evento

    void agregarEscuchadorParaCalcular(ActionListener escuchaParaBotonCalcular){
        btnCalcular.addActionListener(escuchaParaBotonCalcular);
    }//agregarEscuchadorParaCalcular

    public static void main(String[] args){
        CongruencialMultiplicativoVista cmv = new CongruencialMultiplicativoVista();
        cmv.pack();
        cmv.setVisible(true);
    }//main

}//class