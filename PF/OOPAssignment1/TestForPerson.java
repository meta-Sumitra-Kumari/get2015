import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestForPerson {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testForToString() {
		int uid=101;
		String name="Sumitra";
		int studentid=110;
		Student std=new Student(uid,name,studentid);
		String nameagain;
		nameagain="Name:"+name+", uid:"+uid+", StudentId:"+studentid;
		assertEquals(nameagain,std.toString());
		
		
	}
	@Test
	public void testForToCourses()
	{
		int uid=101;
		String name="Sumitra";
		int studentid=110;
		Student std=new Student(uid,name,studentid);
		String course[]={"computer Science","information Technology"};
		std.setCources(course);
		assertArrayEquals(course,std.getCourses());
	}

}
