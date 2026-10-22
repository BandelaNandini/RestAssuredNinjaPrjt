package JacksonSer_Deserlization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class project { // Pojo class --> plain old java obj

	// Declare data set private bcz
//	we need to set the data and get the data
	private String projectname;
	private String createdby;
	private String status;
	private int teamsize;

	public project(String projectname, String createdby, String status, int teamsize) {
		super();
		this.projectname = projectname;
		this.createdby = createdby;
		this.status = status;
		this.teamsize = teamsize;
	}

	// Required for deserialization
	private project() {

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

public class JacksonSerTest {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		// Creating obj nad giving data
		project pobj = new project("pavkar", "Nandu", "completed", 3);

		// Create obj of Objectmapper from jackson databind import
		ObjectMapper objm = new ObjectMapper();
		objm.writeValue(new File("./Data.json"), pobj);

		System.out.println("===End====");

	}

}
