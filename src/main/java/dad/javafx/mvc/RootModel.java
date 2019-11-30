package dad.javafx.mvc;

import dad.javafx.mvc.service.IpData;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RootModel {

	private StringProperty ip = new SimpleStringProperty();

	private ObjectProperty<IpData> datos = new SimpleObjectProperty<IpData>();
	
	public final StringProperty ipProperty() {
		return this.ip;
	}
	

	public final String getIp() {
		return this.ipProperty().get();
	}
	

	public final void setIp(final String ip) {
		this.ipProperty().set(ip);
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
