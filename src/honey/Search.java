package honey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HoneyControl
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String src = "./comb";

		HoneyDAO dao = new DBHoneyDAO();
		String address = null;
		request.setCharacterEncoding("utf-8");
		
		ArrayList<HoneyBean> eventlist = null;
		String search = request.getParameter("search");
		HashMap<Integer, HoneyBean> hashList = new HashMap<Integer, HoneyBean>();
		// �˻��� ����
		if (search == null) {
			address = src + "/fail_contents.jsp";
		} else {
			eventlist = dao.getHoneyVideo();	// ��� �Խñ� �θ���
			String content = null, title = null, member = null;
			
			// �����ϴ� �Խñ۵��� �ߺ� �����ϱ� ���� hashList�� �߰�
			for (HoneyBean e : eventlist) {
				content = e.getList_contents();
				title = e.getList_title();
				member = e.getMember_name();
				if ((content != null && content.contains(search)) || (title != null && title.contains(search)) || 
						(member != null && member.contains(search))) {
					hashList.put(e.getList_n(), e);
				}
			}
			
			// �˻� ����� ����
			eventlist.clear();
			eventlist.addAll(hashList.values());
			
			request.setAttribute("eventlist", eventlist); // �˻� ��� ���
			address = src + "/H_search_result.jsp";
		}
		
		

	RequestDispatcher dispatcher = request.getRequestDispatcher(address);dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
