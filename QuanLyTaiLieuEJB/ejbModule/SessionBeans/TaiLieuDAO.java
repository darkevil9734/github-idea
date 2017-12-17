package SessionBeans;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import EntityBeans.Tailieu;

@Stateless
public class TaiLieuDAO implements TaiLieuDAOLocal {
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Tailieu> list_of_tailieu() {
		Query q = em.createNamedQuery("Tailieu.findAll", Tailieu.class);
		return q.getResultList();
	}

	@Override
	public boolean upload(int ma_tai_lieu, String ten_tai_lieu, String ngay_upload) {
		
		String sql = "INSERT INTO `ql_hocsinh`.`tailieu` (`idTaiLieu`,`ten_tai_lieu`, `ngay_upload`) VALUES (?,?,?)";
		
		Query q = em.createNativeQuery(sql);
		q.setParameter(1, ma_tai_lieu);
		q.setParameter(2, ten_tai_lieu);
		q.setParameter(3, ngay_upload);
		
		if(q.executeUpdate() != 0)
			return true;
		return false;
	}

	public TaiLieuDAO() {
    
	}

}
