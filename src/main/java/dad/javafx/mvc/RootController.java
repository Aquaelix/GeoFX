package dad.javafx.mvc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.mvc.conection.ConectionController;
import dad.javafx.mvc.location.LocationController;
import dad.javafx.mvc.security.SecurityController;
import dad.javafx.mvc.service.GeoService;
import dad.javafx.mvc.service.IpData;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
	
public class RootController implements Initializable{
	
	private RootModel model = new RootModel();

	private GeoService service = new GeoService();
	
	private ConectionController conexionController = new ConectionController();
	private LocationController locationController = new LocationController();
	private SecurityController securityController = new SecurityController();
	
	private Task<IpData> tarea;
	
    @FXML
    private TextField IPField;

    @FXML
    private Button checkIPButton;

    @FXML
    private VBox view;

    @FXML
    private Tab locationTab;

    @FXML
    private Tab conectionTab;

    @FXML
    private Tab securityTab;

    @FXML
    void onCheckIPAction(ActionEvent event) {
    	
    	tarea = new Task<IpData>() {

			@Override
			protected IpData call() throws Exception {
		    	return service.checkIp(model.getIp());
			}
		};
    	
		tarea.setOnSucceeded(e ->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Acceso al servicio");
			alert.setHeaderText("Todo fue bien");
			alert.setContentText(e.getSource().getMessage()); //esto no muestra nada
			alert.showAndWait();
		});
		
		tarea.setOnFailed(e ->{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fallo al acceso al servicio.");
			alert.setHeaderText("Algo no fue bien.");
			alert.setContentText(e.getSource().getException().getMessage());
			alert.showAndWait();
		});
		
    	model.datosProperty().bind(tarea.valueProperty());
    	new Thread(tarea).start();
    	
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	//contenido de los tabs
    	locationTab.setContent(locationController.getView());
		conectionTab.setContent(conexionController.getView());
		securityTab.setContent(securityController.getView());
		
		//bindeos
		IPField.textProperty().bindBidirectional(model.ipProperty());
		conexionController.getModel().datosProperty().bind(model.datosProperty());
		securityController.getModel().datosProperty().bind(model.datosProperty());
		locationController.getModel().datosProperty().bind(model.datosProperty());
		
		//inicializamos con nuestra ip
		try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
		    model.setIp(s.next());
		} catch (java.io.IOException e) {
		    e.printStackTrace();
		}
		
	}
    
    public RootController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();
	}
    
    public VBox getView() {
    	return view;
    }

}
