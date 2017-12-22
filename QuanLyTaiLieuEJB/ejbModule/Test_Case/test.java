package Test_Case;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import org.omg.IOP.TAG_INTERNET_IOP;

import EntityBeans.Tailieu;
import Function.DateTimeCurrent;
import SessionBeans.TaiLieuDAO;
import SessionBeans.TaiLieuDAOLocal;

public class test {
	@EJB
	private static TaiLieuDAO tl;
	
	public static void main(String [] args) {
		DateTimeCurrent dtc = new DateTimeCurrent();
		String ngay = dtc.getDay();
		String gio = dtc.getTime();
		
		System.out.println(ngay + " " + gio);
		
		///
		List<Tailieu> dstl = tl.list_of_tailieu();
		System.out.println("Size : "+ dstl.size());
		
		
	}
}
