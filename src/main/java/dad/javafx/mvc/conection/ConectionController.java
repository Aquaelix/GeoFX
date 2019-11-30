package dad.javafx.mvc.conection;

import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.mvc.service.Comprobacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ConectionController implements Initializable {
	
	private ConectionModel model = new ConectionModel();
	
	private Comprobacion comprobacion = new Comprobacion();
	
	@FXML
    private GridPane view;

    @FXML
    private Label addresLabel;

    @FXML
    private Label ispLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label asnLabel;

    @FXML
    private Label hostnameLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addresLabel.textProperty().bind(model.addressProperty());
		ispLabel.textProperty().bind(model.ispProperty());
		typeLabel.textProperty().bind(model.typeProperty());
		hostnameLabel.textProperty().bind(model.hostnameProperty());
		
		asnLabel.textProperty().bind(model.asnProperty());
	
		model.datosProperty().addListener(e -> onCambioAction());
	}
	
	private void onCambioAction() {
		model.setAddress(comprobacion.address(model.getDatos()));
    	model.setIsp(comprobacion.isp(model.getDatos()));
    	model.setType(comprobacion.type(model.getDatos()));
    	model.setAsn(comprobacion.asn(model.getDatos()));
    	model.setHostname(comprobacion.hostname(model.getDatos()));
	}

	public ConectionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConectionView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public GridPane getView() {
	   	return view;
	}

	public ConectionModel getModel() {
		return model;
	}
}
