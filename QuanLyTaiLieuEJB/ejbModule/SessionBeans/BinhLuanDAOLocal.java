package SessionBeans;

import java.util.List;

import javax.ejb.Local;

import EntityBeans.Binhluan;

@Local
public interface BinhLuanDAOLocal {
	boolean them_binh_luan(Binhluan bl);
	List<Binhluan> dsbl();
}
