/**
 * Created by cristobalvega on 10/2/17.
 */
public class CongruencialMultiplicativo{

    public double x,k,g,m;
    double[] numeros_psudo_aleatorios;

    public CongruencialMultiplicativo(){

    }

    public CongruencialMultiplicativo(
            double x,
            double k,
            double g,
            double m,
            double numero_iteraciones){

        this.x=x; //17
        this.k=k;   //2
        this.g=g;   //5
        this.m=m;   //32

        double a=3+(8*k); //19


        //javax.swing.JOptionPane.showMessageDialog(null,"X="+x+"\n"+"K="+k+"\n"+"G="+g+"\n"+"M="+m);

        numeros_psudo_aleatorios=new double[50+1];

        for (int i=1; i<=numero_iteraciones; i++){
            numeros_psudo_aleatorios[i]=calcularRSubIndice(calcularXSubIndice(x,a));
            x=calcularXSubIndice(x,a);
          // System.out.println("Numero PsudoAleatorio"+i+"="+numeros_psudo_aleatorios[i]);
        }//for
    }//Constructor

    private double calcularXSubIndice(double x_anterior,double a){
        double nueva_x;
        //System.out.println("x_anterior="+x_anterior);
        nueva_x=(a*x_anterior)%32;
        //System.out.println("nueva_x="+nueva_x);
        return nueva_x;
    }//calcularXSubIndice

    private double calcularRSubIndice(double x_anterior){
        //System.out.println("x_anterior="+x_anterior);
        double r_i=(x_anterior/31);
        //System.out.println("r_i="+r_i);
        return r_i;
    }//calcularRSubIndice

    public double obtenerValorCalculado(){
        return x;
    }//obtenerValorCalculado

    public void agregarValores(
            double x,
            double k,
            double g,
            double m,
            double numero_iteraciones){
        this.x=x; //17
        this.k=k;   //2
        this.g=g;   //5
        this.m=m;   //32
    }//agregarDosNumeros

    public static void main(String args[]){
        CongruencialMultiplicativo cm=new CongruencialMultiplicativo(17,2,5,32,50);
    }//main

}//class