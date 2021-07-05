package notice.controller.login;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.MemberDao;
import notice.vo.Member;

public class LogoutProcController implements Controller{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		System.out.println("LogoutProcController");

		request.getSession().invalidate();
		response.sendRedirect("../customer/notice.do");
		
	}
}
