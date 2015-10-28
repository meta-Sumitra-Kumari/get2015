package Assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BackHandEngineer implements Engineer {

	
	String name;
	String role;
	 private static List<BackHandEngineer> EngineerListBack= new ArrayList<BackHandEngineer>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole() {
		this.role = "BackEndEngineer";
	}
	@Override
	public String toString() {
		
		return "Name -> " + name + "\nRole -> " + role + "\n";    
	}
	private BackHandEngineer() {

	}
	private static BackHandEngineer back_end=new BackHandEngineer();
	public static BackHandEngineer getInstance(){
		return back_end;
	}
	public void addBackEndEngineer(String name) {
		BackHandEngineer engineer=new BackHandEngineer();
		engineer.setName(name);
		engineer.setRole();
		EngineerListBack.add(engineer);

	}
	public void showList() {
		if(EngineerListBack.isEmpty()){
			System.out.println("List is empty");
		}
		else{
		Iterator<BackHandEngineer> iterator = EngineerListBack.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
	}}
	
}
