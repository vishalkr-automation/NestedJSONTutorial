package bychillyfacts;

import java.io.StringWriter;
import org.codehaus.jackson.map.ObjectMapper;

public class JAVA_TO_JSON {
	
	public static void main(String[] args) throws Exception {
		Country_Bean obj_country_Bean=new Country_Bean();
		
		obj_country_Bean.setIp("117.245.94.65");
		obj_country_Bean.setCountry_code("IN");
	    obj_country_Bean.setCountry_name("INDIA");
	    obj_country_Bean.setRegion_name("BIHAR");
	    obj_country_Bean.setCity_name("ARA");
	    obj_country_Bean.setLatitude("27.6");
	    obj_country_Bean.setLongitude("27.6");
	    obj_country_Bean.setZip_code("802301");
	    obj_country_Bean.setTime_zone("+05:30");
	    obj_country_Bean.setAsn("9829");
	    obj_country_Bean.setAs("National Internet Backbone");
	    obj_country_Bean.setIs_proxy("false");
	    
	    ObjectMapper objcetMapper=new ObjectMapper();
	    StringWriter stringWriter=new StringWriter();
	    objcetMapper.writeValue(stringWriter, obj_country_Bean);
	    
	    System.out.println("Country JSON is\n"+stringWriter);
	    
	    
	}
}
