/**
 * Created by cristobalvega on 10/2/17.
 */
/**
 * Created by cristobalvega on 8/7/17.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * El controlador coordina las interacciones
 * entre la vista y el modelo.
 */
public class CalculadoraControlador {

    private CongruencialMultiplicativoVista la_vista;
    private CongruencialMultiplicativo el_modelo;

    public CalculadoraControlador(CongruencialMultiplicativoVista la_vista, CongruencialMultiplicativo el_modelo){

        this.la_vista = la_vista;
        this.el_modelo = el_modelo;

        /**
         * Toca decirle a la vista que cuando el botón de calcular es precionado
         * ejecute el método actionPerformed en la clase anonima (o intima) EscuchadorCalcular.
         */

        this.la_vista.agregarEscuchadorParaCalcular(new EscuchadorCalcular());
    }//Constructor

    //Inner Class
    class EscuchadorCalcular implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int primerNumero, segundoNumero = 0;

            /**
             * Evolver las interacciones con la vista con un try/catch
             * en caso de que los números no sean propiamente entrados
             */

            try{
                primerNumero = la_vista.obtenerPrimerNumero();
                segundoNumero = la_vista.obtenerSegundoNumero();

                el_modelo.agregarValores(primerNumero,segundoNumero);
                la_vista.establecerSolucionCalculada(el_modelo.obtenerValorCalculado());
            }//try

            catch(NumberFormatException excepcion_numero){
                System.out.println(excepcion_numero);
                la_vista.mostrarMensajeError("Necesitas meter dos enteros");
            }//catch

        }//actionPerformed

    }//EscuchadorCalcular

}//CalculadoraControlador