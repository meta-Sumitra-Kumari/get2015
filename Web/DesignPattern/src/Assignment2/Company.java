
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sumitra this is comapny class to add the engineer in the list
 */
public class Company {
	static List<Engineer> engineerList = new ArrayList<Engineer>();

	/**
	 * 
	 * @param engineer
	 *            -- object of engineer to add engineer in list
	 */
	public void add(Engineer engineer) {
		engineerList.add(engineer);
	}

	/**
	 * 
	 * @return list of engineer
	 */
	public List<Engineer> getList() {
		return engineerList;
	}
}
