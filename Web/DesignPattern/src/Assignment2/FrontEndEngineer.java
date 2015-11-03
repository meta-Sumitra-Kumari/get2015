
public class FrontEndEngineer implements Engineer {
	String name;
	String role;
	public String getName() {
		
		return name;
	}

	public String getRole() {
	
		return role;
	}

	public void setName(String name) {
		this.name=name;

	}

	public void setRole() {
		this.role=Role.FrontEndEngineer.toString();

	}

}
