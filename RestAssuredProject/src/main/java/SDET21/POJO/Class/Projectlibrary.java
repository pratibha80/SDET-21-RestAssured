package SDET21.POJO.Class;

public class Projectlibrary {
	
	// create global variables 
	String createdBy;
	String projectName;
	String status;
	int  teamSize;
	
	//Initialize all variables using a constructor
	
	public Projectlibrary(String createdBy, String projectName, String status, int teamSize) {
		
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
		
		
		
	}
	// use getter and setter to access the variables

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	

	
	

}
