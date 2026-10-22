package JacksonSer_Deserlization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JasonDeserTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper objm=new ObjectMapper();
		
		project pobj = objm.readValue(new File("./Data.json"), project.class);
		
		System.out.println(pobj.getProjectname());
		System.out.println(pobj.getCreatedby());
		System.out.println(pobj.getStatus());
		System.out.println(pobj.getTeamsize());

	}
}
