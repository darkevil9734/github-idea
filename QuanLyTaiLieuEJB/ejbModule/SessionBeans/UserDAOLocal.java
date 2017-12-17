package SessionBeans;

import javax.ejb.Local;

import EntityBeans.User;

@Local
public interface UserDAOLocal {
	User dang_nhap(String username, String password);
	boolean dang_ky(User u);
}
