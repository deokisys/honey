package honey;

import java.io.IOException;
import java.util.ArrayList;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String src="./comb";
		
		HoneyDAO dao = new DBHoneyDAO();
		String address = null;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();	
		
		//�˻��� ����
		if(request.getParameter("search")==null){
			address=src+"/fail_contents.jsp";
		}else{
		
			String search = request.getParameter("search");//����
		if(Pattern.matches("^[0-9]+$", search)){
			int search_int= Integer.parseInt(search);//���ڷ� 
			System.out.println("�˻��Ұ͵� ����"+search);
			System.out.println("�˻��Ұ͵� ����"+search_int);
			
			
			//���� ���̵�
			Mgr_bean HC_id=dao.getHC(search_int);		//�� �ش�hc_id���� ����
			
			
			//���� ����
			 ArrayList<HoneyBean> HC_title = dao.getHoneytitle(search);
				
				//�Խñ�����
				 ArrayList<HoneyBean> LIST_title=dao.getListtitle(search);			//�Խ��� ���� �˻�
					
				//�Խñ۳���
				ArrayList<HoneyBean> LIST_contents=dao.getListcontents(search);			//�Խ��� ���� �˻�
				
				
				request.setAttribute("HC_id", HC_id);
				request.setAttribute("HC_title", HC_title);
				request.setAttribute("LIST_title", LIST_title);
				request.setAttribute("LIST_contents", LIST_contents);
			
			address=src+"/H_search_result.jsp";
			//������
		}else{
			//���ھƴ�		
			System.out.println("�˻��Ұ͵� "+search);
			
			
			
			
			//���� ����
			 ArrayList<HoneyBean> HC_title = dao.getHoneytitle(search);
			
			//�Խñ�����
			 ArrayList<HoneyBean> LIST_title=dao.getListtitle(search);			//�Խ��� ���� �˻�
				
			//�Խñ۳���
			ArrayList<HoneyBean> LIST_contents=dao.getListcontents(search);			//�Խ��� ���� �˻�
			
			
			
			request.setAttribute("HC_title", HC_title);
			request.setAttribute("LIST_title", LIST_title);
			request.setAttribute("LIST_contents", LIST_contents);
			
			
			address=src+"/H_search_result.jsp";
			
			
			
		}
	
		
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
