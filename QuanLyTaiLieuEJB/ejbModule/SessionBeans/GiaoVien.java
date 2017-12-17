package SessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EntityBeans.User;

@Stateless
public class GiaoVien implements GiaoVienLocal {
	@PersistenceContext
	EntityManager em;
	
    public GiaoVien() {

    }

	@Override
	public User dang_nhap(String username, String password) {
		Query q = em.createNamedQuery("User.Login", User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		
		return (User) q.getSingleResult();
	}

	@Override
	public boolean dang_ky(User gv) {
		String sql = "INSERT INTO `ql_hocsinh`.`user` (`username`, `password`, `ho_ten`, `idLoai`) VALUES (?, ?, ?, '2')";
		Query q = em.createNativeQuery(sql);
		
		q.setParameter(1, gv.getUsername());
		q.setParameter(2, gv.getPassword());
		q.setParameter(3, gv.getHoTen());
		
		if(q.executeUpdate() != 0)
			return true;
		return false;
	}

    
}
