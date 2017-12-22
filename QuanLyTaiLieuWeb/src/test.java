

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EntityBeans.Binhluan;
import EntityBeans.Loai;
import EntityBeans.Tailieu;
import EntityBeans.User;
import EntityBeans.UserPK;
import SessionBeans.BinhLuanDAOLocal;
import SessionBeans.TaiLieuDAOLocal;
import SessionBeans.UserDAOLocal;

@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    private BinhLuanDAOLocal blDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noidung = "abcdef";
		int ma_tai_lieu = 1;
		int id_user = 1;
		int loai = 1;
		
		UserPK u = new UserPK();
		u.setIdUser(id_user);
		u.setIdLoai(loai);
		
		Loai l = new Loai();
		l.setIdLoai(loai);
		
		
		User u1 = new User();
		u1.getId().getIdUser();
		u1.getLoai().getIdLoai();
		
		Tailieu tl = new Tailieu();
		tl.setIdTaiLieu(ma_tai_lieu);
		
		Binhluan bl = new Binhluan();
		bl.setNoiDung(noidung);
		bl.setTailieu(tl);
		
	
		if(blDAO.them_binh_luan(bl) == true) {
			System.out.println("thanh cong");
		}
		else {
			System.out.println("loi");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
