package honey;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import honey.DBHoneyDAO;
import honey.HoneyDAO;

/**
 * Servlet implementation class Editor
 */
@WebServlet("/Editor")
public class Editor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				// request�� �Ķ����
				// 1. String hc_id : ������ ���̵�
				// 2. String input_pwd : �Է��� ������ ��й�ȣ
				// ������ : (���� ���̵�� Mgr_bean ������) -> (������ ��й�ȣ�� �Է� ���� ��й�ȣ ���� ����[Ʋ���� ��])
				//			-> (Mgr_bean�� createHC�� �ѱ�))
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String src="./comb";
		PrintWriter out = response.getWriter();
		HoneyDAO DB = new DBHoneyDAO();
		String input_hc_id = request.getParameter("hc_id");
		String input_pwd = request.getParameter("input_pwd");
		// �Է¹��� ���� ������ ��
		
		
		
		if (input_hc_id == null || input_pwd == null) {
			out.println("<script>alert('can't find values');history.back();</script>");
			out.flush();
			return;
		}
		
		int hc_id = Integer.parseInt(input_hc_id);
		Mgr_bean HC = DB.getHC(hc_id);	
		
		// hc_id�� �ش��ϴ� ���� ������ ��
		if (HC == null) {
			out.println("<script>alert('�ش� hc_id�� �������� �ʽ��ϴ�');history.back();</script>");
			out.flush();
			return;
		}
		
		// ��й�ȣ�� �ȸ����� ��
		if (!HC.getHc_pwd().equals(input_pwd)) {
			out.println("<script>alert('��й�ȣ�� Ʋ�Ƚ��ϴ�');history.back();</script>');history.back();</script>");
			out.flush();
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("HC", HC);	//���ǿ� Mgr_bean ���
		session.setAttribute("mode", "edit");	// ������Ʈ�� edit ���
		// forward
		String address="HoneyControl?action=hccreate";
		//String address = src+"/manager/createHC.jsp";
		//RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		//dispatcher.forward(request, response);
		response.sendRedirect(address);
	}

}
