package SessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EntityBeans.User;

@Stateless
public class Mod implements ModLocal {
	@PersistenceContext
	EntityManager em;
	
    public Mod() {

    }

	@Override
	public User dang_nhap(String username, String password) {
		Query q = em.createNamedQuery("User.Login", User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		
		return (User) q.getSingleResult();
	}

	@Override
	public boolean dang_ky(User mod) {
		String sql = "INSERT INTO `ql_hocsinh`.`user` (`username`, `password`, `ho_ten`, `idLoai`) VALUES (?, ?, ?, '1')";
		Query q = em.createNativeQuery(sql);
		
		q.setParameter(1, mod.getUsername());
		q.setParameter(2, mod.getPassword());
		q.setParameter(3, mod.getHoTen());
		
		if(q.executeUpdate() != 0)
			return true;
		return false;
	}

    
}
