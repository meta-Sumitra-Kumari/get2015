package Assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FrontHandEngineer implements Engineer {
 String name;
 String role;
 private static List<FrontHandEngineer> EngineerListFront= new ArrayList<FrontHandEngineer>();
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
	this.role = "FrontEndEngineer";
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Name -> " + name + "\nRole -> " + role + "\n";
}
private FrontHandEngineer() {

}
private static FrontHandEngineer front_end=new FrontHandEngineer();
public static FrontHandEngineer getInstance(){
	return front_end;
}
public void addFrontEndEngineer(String name) {
	FrontHandEngineer engineer=new FrontHandEngineer();
	engineer.setName(name);
	engineer.setRole();
	EngineerListFront.add(engineer);

}
public void showList() {
	if(EngineerListFront.isEmpty()){
		System.out.println("List is empty");
	}
	else{
	Iterator<FrontHandEngineer> iterator = EngineerListFront.iterator();
	while (iterator.hasNext()) {
		System.out.println(iterator.next().toString());
	}}
}

}
