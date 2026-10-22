package JacksonSer_Deserlization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Projectmanager {
	public String name;
	public String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Projectmanager(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

}

class PojoProject {
	public String projectname;
	@JsonProperty("ProjectStatus")
	public String projectStatus;
	public int teamsize;
	public ArrayList<String> teammmembers;
	public Projectmanager projectmanager;

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}

	public ArrayList<String> getTeammmembers() {
		return teammmembers;
	}

	public void setTeammmembers(ArrayList<String> teammmembers) {
		this.teammmembers = teammmembers;
	}

	public Projectmanager getProjectmanager() {
		return projectmanager;
	}

	public void setProjectmanager(Projectmanager projectmanager) {
		this.projectmanager = projectmanager;
	}

	public PojoProject(String projectname, String projectStatus, int teamsize, ArrayList<String> teammmembers,
			Projectmanager projectmanager) {
		super();
		this.projectname = projectname;
		this.projectStatus = projectStatus;
		this.teamsize = teamsize;
		this.teammmembers = teammmembers;
		this.projectmanager = projectmanager;
	}

}

public class ComplexJacksonPojoClassTest {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		ArrayList<String> alst = new ArrayList<String>();
		alst.add("pav");
		alst.add("kar");
		alst.add("nan");

		Projectmanager pmobj = new Projectmanager("chand", "ty01");
		
		PojoProject pp1 = new PojoProject("Rest_Assured", "Created", 3, alst, pmobj);

		System.out.println(pp1.projectname);
		System.out.println(pp1.projectStatus);
		System.out.println(pp1.teamsize);
		System.out.println(pp1.teammmembers);
		System.out.println(pp1.projectmanager);

		//Converting obj type to json file
		ObjectMapper objm = new ObjectMapper();
		objm.writeValue(new File("./ComplexPojo.json"), pp1);

		System.out.println("====end=====");
	}
}
