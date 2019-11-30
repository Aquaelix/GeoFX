package dad.javafx.mvc.service;

import javafx.scene.image.Image;

public class Comprobacion {

	//Localizacion
	
	public Double latitude(IpData location) {
		try {
			return location.getLatitude();
		} catch (RuntimeException e) {
			return 0.0;
		}
	}
	
	public Double longitude(IpData location) {
		try {
			return location.getLongitude();
		} catch (RuntimeException e) {
			return 0.0;
		}
	}
	
	public String location(IpData location) {
		try {
			return location.getCountryName()+" ("+location.getCountryCode()+")";
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public Image bandera(IpData location) {
		try {
			return new Image(getClass().getResource("/images/flag-icons/64x42/"+location.getCountryCode()+".png").toString());
		} catch (RuntimeException e) {
			return new Image(getClass().getResource("/images/World.png").toString());
		}
	}
	
	public String city(IpData location) {
		try {
			return location.getCity()+" ("+location.getRegionName()+")";
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String zipCode(IpData location) {
		try {
			return location.getZip();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String language(IpData location) {
		try {
			return location.getLocation().getLanguages().get(0).getName()+" ("+location.getLocation().getLanguages().get(0).getCode().toUpperCase()+")";
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String timeZone(IpData location) {
		try {
			return location.getTimeZone().getCode();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String callingCode(IpData location) {
		try {
			return "+"+location.getLocation().getCallingCode();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String currency(IpData location) {
		try {
			return location.getCurrency().getName()+" ("+location.getCurrency().getSymbol()+")";
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	//Conexion
	public String address(IpData location) {
		try {
			return location.getIp();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String isp(IpData location) {
		try {
			return location.getConnection().getIsp();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String type(IpData location) {
		try {
			return location.getType();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String asn(IpData location) {
		try {
			return location.getConnection().getAsn().toString();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String hostname(IpData location) {
		try {
			return location.getHostname();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	//Seguridad

	public boolean tor(IpData location) {
		try {
			return location.getSecurity().getIsProxy();
		} catch (RuntimeException e) {
			return false;
		}
	}
	
	public boolean proxy(IpData location) {
		try {
			return location.getSecurity().getIsTor();
		} catch (RuntimeException e) {
			return false;
		}
	}
	
	public boolean crawler(IpData location) {
		try {
			return location.getSecurity().getIsCrawler();
		} catch (RuntimeException e) {
			return false;
		}
	}
	
	public String nivelAmenaza(IpData location) {
		try {
			return location.getSecurity().getThreatLevel();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
	public String tipoAmenaza(IpData location) {
		try {
			return location.getSecurity().getThreatTypes().toString();
		} catch (RuntimeException e) {
			return "You need an upgrade account to see this option";
		}
	}
	
  	public String seguro(boolean proxy, boolean tor, boolean crawler) {
  		int i=0;
  		String nivelSeguridad;
  		if(proxy)
  			i++;
  		if(tor)
  			i++;
  		if(crawler)
  			i++;
  		
  		if(i==0)
  			nivelSeguridad = "This IP is safe. No threats have been detected.";
  		else if(i==1)
  			nivelSeguridad = "This IP is a bit safe. There is a threat detected.";
  		else if(i==2)
  			nivelSeguridad = "This IP is not safe. There are some threats detected.";
  		else 
  			nivelSeguridad = "This IP is really dangerous. There are threats detected.";
  		
  		return nivelSeguridad;
  	}
	
}
