package PojoUtility;

public class ProjPojoClassTest {

//	 We always can change data if we have dynamic values in Json file
//	or obj i.e., we go for pojo class
//	"createdBy" : "Orange",
//	"status" : "created",
//	"teamSize" : 10,
//	"projectName" : "Ninja_DoraJson2"

	String projectName;
	int teamSize;
	String status;
	String createdBy;

	// Helps for deserialization
	private ProjPojoClassTest() {
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public ProjPojoClassTest(String projectName, int teamSize, String status, String createdBy) {
		super();
		this.projectName = projectName;
		this.teamSize = teamSize;
		this.status = status;
		this.createdBy = createdBy;
	}

}
