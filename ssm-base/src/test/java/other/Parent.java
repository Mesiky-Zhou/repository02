package other;

import java.util.ArrayList;
import java.util.List;

import com.framework.utils.GenericsUtils;
import com.framework.utils.ReflectUtils;

public class Parent <T,W>{

	public void test(int id){
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		
		Class<W> clazz = GenericsUtils.getSuperClassGenricType(this.getClass(), 1);
    	Object obj = null;
		try {
			obj = clazz.newInstance();
			Object c = ReflectUtils.execMethod(obj, "createCriteria", null, null);
	    	c = ReflectUtils.execMethod(c, "andIdIn", new Class[]{List.class} , new Object[]{ids});
	    	
	    	W where = (W)obj;
	    	System.out.println(where.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
