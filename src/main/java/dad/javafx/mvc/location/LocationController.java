package dad.javafx.mvc.location;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.mvc.service.Comprobacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LocationController implements Initializable{

	private LocationModel model = new LocationModel();
	
	private Comprobacion comprobacion = new Comprobacion();
	
    @FXML
    private GridPane view;

    @FXML
    private Label latitudeLabel;

    @FXML
    private Label longitudeLabel;

    @FXML
    private Label ipLocationLabel;

    @FXML
    private ImageView imagenView;

    @FXML
    private Label cityLabel;

    @FXML
    private Label zipCodeLabel;

    @FXML
    private Label idiomaLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label callingLabel;

    @FXML
    private Label currencyLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		longitudeLabel.textProperty().bind(model.longitudeProperty().asString());
		latitudeLabel.textProperty().bind(model.latitudeProperty().asString());
		ipLocationLabel.textProperty().bind(model.locationProperty());
		cityLabel.textProperty().bind(model.cityProperty());
		zipCodeLabel.textProperty().bind(model.zipCodeProperty());
		idiomaLabel.textProperty().bind(model.languageProperty());
		timeLabel.textProperty().bind(model.timeZoneProperty());
		callingLabel.textProperty().bind(model.callingCodeProperty());
		currencyLabel.textProperty().bind(model.currencyProperty());

		imagenView.imageProperty().bind(model.banderaProperty());
		
		model.datosProperty().addListener(e -> onCambioAction());
	}
	
	private void onCambioAction() {
		
	    	model.setLatitude(comprobacion.latitude(model.getDatos()));
	    	model.setLongitude(comprobacion.longitude(model.getDatos()));
	    	model.setLocation(comprobacion.location(model.getDatos()));
	    	model.setBandera(comprobacion.bandera(model.getDatos()));
	    	model.setCity(comprobacion.city(model.getDatos()));
	    	model.setZipCode(comprobacion.city(model.getDatos()));
	    	model.setLanguage(comprobacion.language(model.getDatos()));
	    	model.setTimeZone(comprobacion.timeZone(model.getDatos()));
	    	model.setCallingCode(comprobacion.callingCode(model.getDatos()));
	    	model.setCurrency(comprobacion.currency(model.getDatos()));
		
	}

	public LocationController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LocationView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public GridPane getView() {
	   	return view;
	}
	
	public LocationModel getModel() {
		return model;
	}
}
