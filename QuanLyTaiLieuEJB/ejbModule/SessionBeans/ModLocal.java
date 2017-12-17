package SessionBeans;

import javax.ejb.Local;

import EntityBeans.User;

@Local
public interface ModLocal {
	User dang_nhap(String username, String password);
	boolean dang_ky(User mod);
}
