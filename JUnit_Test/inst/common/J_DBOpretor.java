package inst.common;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class J_DBOpretor {

	@Test
	public void test() {
		DBOpretor db = new DBOpretor();
		List<String> pa = new ArrayList<String>();
		pa.add("AA");
		pa.add("BB");
		pa.add("CC");
		db.setSQLSelect("SELECT * FROM TEST WHERE A=? AND B=? AND C=?");
		db.setParameter(pa);
		
		assertEquals(null, "SELECT * FROM TEST WHERE A='AA' AND B='BB' AND C='CC'", db.printSQLLog());
	}

}
