package dad.javafx.mvc.security;

import dad.javafx.mvc.service.IpData;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SecurityModel {

	private StringProperty seguro = new SimpleStringProperty();
	private StringProperty nivelAmenaza = new SimpleStringProperty();
	private StringProperty tipoAmenaza = new SimpleStringProperty();
	
	private BooleanProperty proxy = new SimpleBooleanProperty();
	private BooleanProperty tor = new SimpleBooleanProperty();
	private BooleanProperty crawler = new SimpleBooleanProperty();
	
	private ObjectProperty<IpData> datos = new SimpleObjectProperty<IpData>();
	
	public final StringProperty seguroProperty() {
		return this.seguro;
	}
	
	public final String getSeguro() {
		return this.seguroProperty().get();
	}
	
	public final void setSeguro(final String seguro) {
		this.seguroProperty().set(seguro);
	}
	
	public final StringProperty nivelAmenazaProperty() {
		return this.nivelAmenaza;
	}
	
	public final String getNivelAmenaza() {
		return this.nivelAmenazaProperty().get();
	}
	
	public final void setNivelAmenaza(final String nivelAmenaza) {
		this.nivelAmenazaProperty().set(nivelAmenaza);
	}
	
	public final StringProperty tipoAmenazaProperty() {
		return this.tipoAmenaza;
	}
	
	public final String getTipoAmenaza() {
		return this.tipoAmenazaProperty().get();
	}
	
	public final void setTipoAmenaza(final String tipoAmenaza) {
		this.tipoAmenazaProperty().set(tipoAmenaza);
	}
	
	public final BooleanProperty proxyProperty() {
		return this.proxy;
	}
	
	public final boolean isProxy() {
		return this.proxyProperty().get();
	}
	
	public final void setProxy(final boolean proxy) {
		this.proxyProperty().set(proxy);
	}
	
	public final BooleanProperty torProperty() {
		return this.tor;
	}
	
	public final boolean isTor() {
		return this.torProperty().get();
	}
	
	public final void setTor(final boolean tor) {
		this.torProperty().set(tor);
	}
	
	public final BooleanProperty crawlerProperty() {
		return this.crawler;
	}
	
	public final boolean isCrawler() {
		return this.crawlerProperty().get();
	}
	
	public final void setCrawler(final boolean crawler) {
		this.crawlerProperty().set(crawler);
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
