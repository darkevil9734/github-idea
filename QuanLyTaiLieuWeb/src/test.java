

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

import EntityBeans.Tailieu;
import EntityBeans.User;
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
    private TaiLieuDAOLocal tl;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten_tailieu = "1.pdf";
		// get current day 
		java.util.Date date = new java.util.Date();
		long t = date.getTime();
		
		java.sql.Date sqlDate = new java.sql.Date(t);
		SimpleDateFormat fmt_date = new SimpleDateFormat("dd-MM-yyyy");
		String ngay = fmt_date.format(sqlDate);
		java.sql.Time sqlTime = new java.sql.Time(t);
		
		// eof
		String ngay_upload = sqlDate + " " + sqlTime;
		
		List<Tailieu> dstl = tl.list_of_tailieu();
		int rd = dstl.size()+1;
		
		Tailieu tl_upload = new Tailieu();
		tl_upload.setIdTaiLieu(rd);
		tl_upload.setTenTaiLieu(ten_tailieu);
		//tl_upload.setNgayUpload(ngayUpload);
		if(tl.upload(rd, ten_tailieu, ngay_upload)) {
			System.out.println("thanh cong");
		}
		else {
			System.out.println("loi");
		}
		
		
		System.out.println("Size: " + rd);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
