package dad.javafx.mvc.security;

import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.mvc.service.Comprobacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SecurityController implements Initializable{
	  
	private SecurityModel model = new SecurityModel();
	
	private Comprobacion comprobacion = new Comprobacion();
	
	@FXML
	private GridPane view;
    
	@FXML
    private Label securityLabel;

    @FXML
    private CheckBox proxyCheck;

    @FXML
    private CheckBox torCheck;

    @FXML
    private Label levelLabel;

    @FXML
    private Label potentialLabel;

    @FXML
    private CheckBox crawlerCheck;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		securityLabel.textProperty().bind(model.seguroProperty());
		levelLabel.textProperty().bind(model.nivelAmenazaProperty());
		potentialLabel.textProperty().bind(model.tipoAmenazaProperty());
		
		torCheck.selectedProperty().bind(model.torProperty());
		crawlerCheck.selectedProperty().bind(model.crawlerProperty());
		proxyCheck.selectedProperty().bind(model.proxyProperty());
		
		model.datosProperty().addListener(e -> onCambioAction());

	}
	
	private void onCambioAction() {
		model.setProxy(comprobacion.proxy(model.getDatos()));
		model.setTor(comprobacion.tor(model.getDatos()));
    	model.setCrawler(comprobacion.crawler(model.getDatos()));
    	model.setNivelAmenaza(comprobacion.nivelAmenaza(model.getDatos()));
    	model.setTipoAmenaza(comprobacion.tipoAmenaza(model.getDatos()));
    	model.setSeguro(comprobacion.seguro(model.isProxy(), model.isTor(), model.isCrawler()));
	}

	public SecurityController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SecurityView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public GridPane getView() {
	   	return view;
	}

	public SecurityModel getModel() {
		return model;
	}
}