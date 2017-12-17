package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.sun.faces.action.RequestMapping;

@Controller
public class UserDTO {
	
	@RequestMapping("/log-in")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
}
