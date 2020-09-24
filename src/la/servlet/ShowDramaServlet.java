package la.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ShowDramaListBean;
import la.dao.DAOException;
import la.dao.QuestionDAO;

/**
 * Servlet implementation class ShowDramaServlet
 */
@WebServlet("/ShowDramaServlet")
public class ShowDramaServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");

			if(action.equals("show")) {
				QuestionDAO dao = new QuestionDAO();
				List<ShowDramaListBean> list = dao.showDrama();

				//タイトルだけ取り出してlist_drama_titleに入れる
				List<String> list_drama_title = new ArrayList<String>();
				for(int i = 0; i < list.size(); i++) {
					list_drama_title.add(list.get(i).getTitle());
				}

				//list_drama_titleをあいうえお順に並び替える
				Collections.sort(list_drama_title);

				List<ShowDramaListBean> list_new = new ArrayList<ShowDramaListBean>();

				//listをタイトルのあいうえお順に合わせてlist_newに入れる
				for(int i = 0; i < list_drama_title.size(); i++) {
					for(int j = 0; j < list.size(); j++) {
						if(list_drama_title.get(i).equals(list.get(j).getTitle())) {
							list_new.add(list.get(j));
							break;
						}
					}
				}

				//番号をふる
				for(int i = 0; i < list_new.size(); i++) {
					list_new.get(i).setNo(i+1);
				}

				request.setAttribute("dramas",list_new);
				gotoPage(request,response,"/showDrama.jsp");
			}
		}catch(DAOException e) {
			e.printStackTrace();
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException,IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
