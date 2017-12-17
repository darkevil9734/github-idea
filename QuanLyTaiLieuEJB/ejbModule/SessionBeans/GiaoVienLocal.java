package SessionBeans;

import javax.ejb.Local;

import EntityBeans.User;

@Local
public interface GiaoVienLocal {
	User dang_nhap(String username, String password);
	boolean dang_ky(User gv);
}
