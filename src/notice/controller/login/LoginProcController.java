package notice.controller.login;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.MemberDao;
import notice.vo.Member;

public class LoginProcController implements Controller{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		System.out.println("LoginProcController");

		//로그인처리
		String uid=request.getParameter("id");
		String pwd=request.getParameter("password");
		
		MemberDao dao=new MemberDao();
		Member m=dao.getMember(uid);

		
		if(m==null) {
			request.setAttribute("error", "아이디틀림");
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		}else if(!m.getPwd().equals(pwd)) {
			request.setAttribute("error", "비번틀림");
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		}else {
			//로그인성공
			request.getSession().setAttribute("uid", uid);
			response.sendRedirect("../customer/notice.do");
		}
		
		
	}
}
