package SessionBeans;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import EntityBeans.Tailieu;

@Local
public interface TaiLieuDAOLocal {
	List<Tailieu> list_of_tailieu();
	boolean upload(int ma_tai_lieu, String ten_tai_lieu, String ngay_upload);
	
}
