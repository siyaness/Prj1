package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.customer.ErrorController;
import notice.controller.customer.NoticeController;
import notice.controller.customer.NoticeDelProcController;
import notice.controller.customer.NoticeDetailController;
import notice.controller.customer.NoticeEditController;
import notice.controller.customer.NoticeEditProcController;
import notice.controller.customer.NoticeRegController;
import notice.controller.customer.NoticeRegProcController;
import notice.controller.login.LoginController;
import notice.controller.login.LoginProcController;
import notice.controller.login.LogoutProcController;

public class MyDispatcher extends HttpServlet {
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGetdoPost 모두받기");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		
		System.out.println("uri : "+uri);
		System.out.println("conPath : "+conPath);
		System.out.println("com : "+com);
		
//		NoticeDetailController controller1=new NoticeDetailController();
//		NoticeEditController controller2=new NoticeEditController();
		Controller controller=null;
		try {
			if(com.equals("/customer/noticeDetail.do")) {
				controller=new NoticeDetailController();	
			}else if(com.equals("/customer/noticeEdit.do")) {
				controller=new NoticeEditController();
			}else if(com.equals("/customer/noticeEditProc.do")) {
				controller=new NoticeEditProcController();
			}else if(com.equals("/customer/noticeReg.do")) {
				controller=new NoticeRegController();
			}else if(com.equals("/customer/noticeRegProc.do")) {
				controller=new NoticeRegProcController();
			}else if(com.equals("/customer/noticeDelProc.do")) {
				controller=new NoticeDelProcController();
			}else if(com.equals("/customer/notice.do")) {
				controller=new NoticeController();
			}else if(com.equals("/login/login.do")) {
				controller=new LoginController();
			}else if(com.equals("/login/loginproc.do")) {
				controller=new LoginProcController();
			}else if(com.equals("/login/logoutproc.do")) {
				controller=new LogoutProcController();
			}
			if (controller==null) {
				controller=new ErrorController();
			}
			controller.execute(request, response);	
		}catch (Exception e) {
			// TODO: handle exception
		}	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	
	

}
