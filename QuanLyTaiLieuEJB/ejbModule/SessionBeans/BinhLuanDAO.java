package SessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EntityBeans.Binhluan;

@Stateless
public class BinhLuanDAO implements BinhLuanDAOLocal {
	@PersistenceContext
	private EntityManager em;
	
    public BinhLuanDAO() {

    }

	@Override
	public boolean them_binh_luan(Binhluan bl) {
		String sql = "INSERT INTO `ql_hocsinh`.`binhluan` "
				+ "(`noi_dung`, `TaiLieu_idTaiLieu`, `User_idUser`, `User_idLoai`) "
				+ " VALUES (?, ?, ? , ? )";
		Query q = em.createNativeQuery(sql);
		q.setParameter(1, bl.getNoiDung());
		q.setParameter(2, bl.getTailieu().getIdTaiLieu());
		q.setParameter(3, bl.getUser().getId().getIdUser());
		q.setParameter(4, bl.getUser().getId().getIdLoai());
		
		if(q.executeUpdate() != 0)
			return true;
		return false;
	}

	@Override
	public List<Binhluan> dsbl() {
		Query q = em.createNamedQuery("Binhluan.FindAll", Binhluan.class);
		return q.getResultList();
	}
    
    

}
