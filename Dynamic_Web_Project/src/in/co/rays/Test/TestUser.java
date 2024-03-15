package in.co.rays.Test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Bean.UserBean;
import in.co.rays.Model.UserModel;

public class TestUser {
	
	public static void main(String[] args) throws Exception {
	
		        // testAdd();
				//testUpdate();
			   // testDelete();
				//testFindByPk();
			//	testSearch();
               // testAuthenticate();
		
		
	}
	
	private static void testAuthenticate() throws Exception {
	UserModel model = new UserModel();
	UserBean bean = model.authenticate("xyz@gmail.com", "123");

	
	if (bean != null) {
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getAddress());
		
	}else {
		System.out.println("invalid login & password");
	}
	
	
	
	}

	private static void testSearch () throws Exception {
		
		UserBean bean = new UserBean();
		bean.setFirstName("n");

		UserModel model = new UserModel();

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
            bean = (UserBean) it.next();

	}	
		
}

	
	private static void testFindByPk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(1);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getAddress());
}
	
	
	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(2);


}

	private static void testUpdate() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(2);
		bean.setFirstName("pqr");
		bean.setLastName("abc");
		bean.setLoginId("pqr@gmail.com");
		bean.setPassword("123");
		bean.setDob(new Date());
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.update(bean);
	
	}
	
	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();

		bean.setFirstName("xyz");
		bean.setLastName("abc");
		bean.setLoginId("xyz@gmail.com");
		bean.setPassword("123");
		bean.setDob(new Date());
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.add(bean);

	}


}
