package dad.javafx.mvc.service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GeoService {
		
	public GeoService() {
		Unirest.setObjectMapper(new UnirestObjectMapper());
	}
	
	public IpData checkIp(String ip) throws Exception{
		
		String url = "http://api.ipapi.com/api/"+ip+"?access_key=8670935ad31f7a5b9c553dd9ccd68ef4";
		
		try {
			IpData message=
				Unirest
					.get(url)
					.asObject(IpData.class)
					.getBody();

			return message;
			
		} catch (UnirestException e) {
			throw new Exception(e.getMessage());
		}	
	}
}
