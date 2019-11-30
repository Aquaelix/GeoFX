package dad.javafx.mvc.conection;

import dad.javafx.mvc.service.IpData;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConectionModel {

	private StringProperty address = new SimpleStringProperty();
	private StringProperty isp = new SimpleStringProperty();
	private StringProperty type = new SimpleStringProperty();
	private StringProperty hostname = new SimpleStringProperty();
	private StringProperty asn = new SimpleStringProperty();

	private ObjectProperty<IpData> datos = new SimpleObjectProperty<IpData>();
	
	public final StringProperty addressProperty() {
		return this.address;
	}
	
	public final String getAddress() {
		return this.addressProperty().get();
	}
	
	public final void setAddress(final String address) {
		this.addressProperty().set(address);
	}
	
	public final StringProperty ispProperty() {
		return this.isp;
	}
	
	public final String getIsp() {
		return this.ispProperty().get();
	}
	
	public final void setIsp(final String isp) {
		this.ispProperty().set(isp);
	}
	
	public final StringProperty typeProperty() {
		return this.type;
	}
	
	public final String getType() {
		return this.typeProperty().get();
	}
	
	public final void setType(final String type) {
		this.typeProperty().set(type);
	}
	
	public final StringProperty hostnameProperty() {
		return this.hostname;
	}
	
	public final String getHostname() {
		return this.hostnameProperty().get();
	}
	
	public final void setHostname(final String hostname) {
		this.hostnameProperty().set(hostname);
	}

	public final StringProperty asnProperty() {
		return this.asn;
	}
	

	public final String getAsn() {
		return this.asnProperty().get();
	}
	

	public final void setAsn(final String asn) {
		this.asnProperty().set(asn);
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
