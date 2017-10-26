import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class CongruencialMultiplicativoFX extends Application{

    Button btnCalcular;
    TextField txtX,txtG, txtK, txtM;
    Label lblX,lblG,lblK,lblM;
    BorderPane borderPaneGeneral;
    GridPane gridPaneOne;
    HBox hBoxOne;

    Scene sceneOne;
    Stage stageOne;

    @Override
    public void start(Stage stage) throws Exception{
        inicializar();
        stageOne = new Stage();
        sceneOne = new Scene(borderPaneGeneral);
        stageOne.setScene(sceneOne);
        stage.show();
    }//Start

    public void inicializar(){
        borderPaneGeneral = new BorderPane();
        hBoxOne = new HBox();
        borderPaneGeneral.setCenter(hBoxOne);
        crearComponentes();

        hBoxOne.setPadding(new Insets(10.0));
        hBoxOne.setAlignment(Pos.CENTER);
        borderPaneGeneral.getChildren().addAll(
                lblX,
                txtX
        );
        /*
        gridPaneOne.add(lblX,0,0);
        gridPaneOne.add(txtX,0,1);
        */

    }//inicializar

    private void crearComponentes() {
        crearLabels();
        crearTextFields();
        crearButtons();
    }

    private void crearLabels() {
        lblX = new Label("Valor en X = ");
        lblG = new Label("Valor en G = ");
        lblK = new Label("Valor en K = ");
        lblM = new Label("Valor en M = ");
    }

    private void crearTextFields(){
        txtX = new TextField();
        txtG = new TextField();
        txtK = new TextField();
        txtM = new TextField();
    }

    private void crearButtons(){
        btnCalcular = new Button("Calcular");
    }

    public static void main (String args[]){
        Application.launch();
    }

}//class
