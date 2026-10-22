package JacksonSer_Deserlization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Used to set the order of data format in json file
@JsonPropertyOrder(value = { "created by", "projectname", "teamsize", "status" })

//Used to remove the data in json file--> hiding the data
@JsonIgnoreProperties(value = { "status" }, allowSetters = true)

class projectAnn { // Pojo class --> plain old java obj

	// Declare data set private bcz
//	we need to set the data and get the data
	private String projectname;
	// Used to given alternate name
//	where it can use space as java directly don't accept space
	@JsonProperty(value = "created by")
	private String createdby;
	private String status;
	private int teamsize;

	public projectAnn(String projectname, String createdby, String status, int teamsize) {
		super();
		this.projectname = projectname;
		this.createdby = createdby;
		this.status = status;
		this.teamsize = teamsize;
	}

	// Required for deserialization
	private projectAnn() {

	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}

}

public class JacksonAnnotationsTest {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		// Creating obj nad giving data
		projectAnn pobj = new projectAnn("pavkar", "Nandu", "completed", 3);

		// Create obj of Objectmapper from jackson databind import
		ObjectMapper objm = new ObjectMapper();
		objm.writeValue(new File("./changedAnnotations.json"), pobj);

		System.out.println("===End====");

	}

}
