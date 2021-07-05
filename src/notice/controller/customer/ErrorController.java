package notice.controller.customer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;

public class ErrorController implements Controller{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		System.out.println("ErrorController");
		response.sendRedirect("/jspWeb14/customer/error.jsp");

	}

}
