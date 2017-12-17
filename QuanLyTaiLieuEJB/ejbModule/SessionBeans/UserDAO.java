package SessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EntityBeans.User;

@Stateless
public class UserDAO implements UserDAOLocal {
    @PersistenceContext
    EntityManager em;
	public UserDAO() {

    }

	@Override
	public User dang_nhap(String username, String password) {
		Query q = em.createNamedQuery("User.Login", User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		
		return (User) q.getSingleResult();
	}

	@Override
	public boolean dang_ky(User u) {
		String sql = "INSERT INTO `ql_hocsinh`.`user` (`username`, `password`, `ho_ten`, `idLoai`) VALUES (?, ?, ?, '3')";
		Query q = em.createNativeQuery(sql);
		
		q.setParameter(1, u.getUsername());
		q.setParameter(2, u.getPassword());
		q.setParameter(3, u.getHoTen());
		
		
		if(q.executeUpdate() != 0)
			return true;
		return false;
		
	}
	
	
}
