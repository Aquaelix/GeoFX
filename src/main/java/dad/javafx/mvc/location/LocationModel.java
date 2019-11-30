package dad.javafx.mvc.location;

import dad.javafx.mvc.service.IpData;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class LocationModel {

	private DoubleProperty latitude = new SimpleDoubleProperty();
	private DoubleProperty longitude = new SimpleDoubleProperty();
	private StringProperty location = new SimpleStringProperty();
	private StringProperty city = new SimpleStringProperty();
	private StringProperty zipCode = new SimpleStringProperty();
	private StringProperty language = new SimpleStringProperty();
	private StringProperty timeZone = new SimpleStringProperty();
	private StringProperty callingCode = new SimpleStringProperty();
	private StringProperty currency = new SimpleStringProperty();
	
	private ObjectProperty<Image> bandera = new SimpleObjectProperty<Image>();
	private ObjectProperty<IpData> datos = new SimpleObjectProperty<IpData>();

	public final StringProperty locationProperty() {
		return this.location;
	}
	
	public final String getLocation() {
		return this.locationProperty().get();
	}
	
	public final void setLocation(final String location) {
		this.locationProperty().set(location);
	}
	
	public final StringProperty cityProperty() {
		return this.city;
	}
	
	public final String getCity() {
		return this.cityProperty().get();
	}
	
	public final void setCity(final String city) {
		this.cityProperty().set(city);
	}
	
	public final StringProperty languageProperty() {
		return this.language;
	}
	
	public final String getLanguage() {
		return this.languageProperty().get();
	}
	
	public final void setLanguage(final String language) {
		this.languageProperty().set(language);
	}
	
	public final StringProperty timeZoneProperty() {
		return this.timeZone;
	}
	
	public final String getTimeZone() {
		return this.timeZoneProperty().get();
	}
	
	public final void setTimeZone(final String timeZone) {
		this.timeZoneProperty().set(timeZone);
	}
	
	public final StringProperty callingCodeProperty() {
		return this.callingCode;
	}
	
	public final String getCallingCode() {
		return this.callingCodeProperty().get();
	}
	
	public final void setCallingCode(final String callingCode) {
		this.callingCodeProperty().set(callingCode);
	}
	
	public final StringProperty currencyProperty() {
		return this.currency;
	}
	
	public final String getCurrency() {
		return this.currencyProperty().get();
	}
	
	public final void setCurrency(final String currency) {
		this.currencyProperty().set(currency);
	}

	public final ObjectProperty<Image> banderaProperty() {
		return this.bandera;
	}
	

	public final Image getBandera() {
		return this.banderaProperty().get();
	}
	

	public final void setBandera(final Image bandera) {
		this.banderaProperty().set(bandera);
	}

	public final DoubleProperty latitudeProperty() {
		return this.latitude;
	}
	

	public final double getLatitude() {
		return this.latitudeProperty().get();
	}
	

	public final void setLatitude(final double latitude) {
		this.latitudeProperty().set(latitude);
	}
	

	public final DoubleProperty longitudeProperty() {
		return this.longitude;
	}
	

	public final double getLongitude() {
		return this.longitudeProperty().get();
	}
	

	public final void setLongitude(final double longitude) {
		this.longitudeProperty().set(longitude);
	}

	public final StringProperty zipCodeProperty() {
		return this.zipCode;
	}
	

	public final String getZipCode() {
		return this.zipCodeProperty().get();
	}
	

	public final void setZipCode(final String zipCode) {
		this.zipCodeProperty().set(zipCode);
	}

	public final ObjectProperty<IpData> datosProperty() {
		return this.datos;
	}
	

	public final IpData getDatos() {
		return this.datosProperty().get();
	}
	

	public final void setDatos(final IpData datos) {
		this.datosProperty().set(datos);
	}
	
	
	
	
	
}
