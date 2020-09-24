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

import la.bean.CodePointBean;
import la.bean.QuestionBean;
import la.dao.DAOException;
import la.dao.PointDAO;

/**
 * Servlet implementation class PointServlet
 */
@WebServlet("/PointServlet")
public class PointServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータの解析
		String type = request.getParameter("type");
		String pet = request.getParameter("pet");
		String ope = request.getParameter("ope");
		String confession = request.getParameter("confession");
		String action = request.getParameter("action");
		String own = request.getParameter("own");
		String excite = request.getParameter("excite");
		String fear = request.getParameter("fear");

		try {
			//PointDAOをインスタンス化
			PointDAO dao = new PointDAO();

			//作品ごとのCodePointBeanのインスタンスを収納するためのリストを生成
			List<CodePointBean> list = new ArrayList<CodePointBean>();

			if(type==null || pet==null || ope==null || confession==null || action==null || own==null || excite==null || fear==null || type.isEmpty() || pet.isEmpty() || ope.isEmpty() || confession.isEmpty() || action.isEmpty() || own.isEmpty() || excite.isEmpty() || fear.isEmpty()) {
				response.sendRedirect("question.jsp");
			} else {

				//１つ目の質問に関する条件分岐
				switch(type) {
				case "one":
					addList("1-1",dao,list);
					break;

				case "continue":
					addList("1-2",dao,list);
					break;

				default:
					addList("1-3",dao,list);
					break;
				} //ここまでが１つ目の質問に関する条件分岐

				//２つ目の質問に関する条件分岐
				switch(pet) {
				case "dragon":
					addList("2-1",dao,list);
					break;

				case "lizard":
					addList("2-2",dao,list);
					break;

				case "owl":
					addList("2-3",dao,list);
					break;

				case "rabbit":
					addList("2-4",dao,list);
					break;

				} //ここまでが2つ目の質問に関する条件分岐

				//3つ目の質問に関する条件分岐
				switch(ope) {
				case "skill":
					addList("3-1",dao,list);
					break;

				case "kind":
					addList("3-2",dao,list);
					break;

				default:
					addList("3-3",dao,list);
					break;
				} //ここまでが3つ目の質問に関する条件分岐

				//4つ目の質問に関する条件分岐
				switch(confession) {
				case "eat":
					addList("4-1",dao,list);
					break;

				case "friends":
					addList("4-2",dao,list);
					break;

				case "talk":
					addList("4-3",dao,list);
					break;

				case "alone":
					addList("4-4",dao,list);
					break;

				case "hobby":
					addList("4-5",dao,list);
					break;

				case "positive":
					addList("4-6",dao,list);
					break;

				} //ここまでが4つ目の質問に関する条件分岐

				//5つ目の質問に関する条件分岐
				switch(action) {
				case "love":
					addList("5-1",dao,list);
					break;

				case "like":
					addList("5-2",dao,list);
					break;

				case "dislike":
					addList("5-3",dao,list);
					break;

				case "hate":
					addList("5-4",dao,list);
					break;

				default:
					addList("5-5",dao,list);
					break;

				} //ここまでが5つ目の質問に関する条件分岐

				//6つ目の質問に関する条件分岐
				switch(own) {
				case "alone":
					addList("6-1",dao,list);
					break;

				case "multiple":
					addList("6-2",dao,list);
					break;

				default:
					addList("6-3",dao,list);
					break;
				} //ここまでが6つ目の質問に関する条件分岐

				//7つ目の質問に関する条件分岐
				switch(excite) {
				case "like":
					addList("7-1",dao,list);
					break;

				case "dislike":
					addList("7-2",dao,list);
					break;

				} //ここまでが7つ目の質問に関する条件分岐

				//8つ目の質問に関する条件分岐
				switch(fear) {
				case "love":
					addList("8-1",dao,list);
					break;

				case "like":
					addList("8-2",dao,list);
					break;

				case "hate":
					addList("8-3",dao,list);
					break;
				} //ここまでが8つ目の質問に関する条件分岐

				//listから点数のみを取り出してlist_pointに代入。それを大きい順に並び替える。
				List<Integer> list_point = new ArrayList<Integer>();
				for(int i = 0; i < 5; i++) {
					list_point.add(list.get(i).getPoint());
				}
				Collections.sort(list_point, Collections.reverseOrder());

				//総合得点大きい方から５つの値を収納するリストを生成
				List<Integer> top5 = new ArrayList<Integer>();

				//top5に総合得点大きい方から５つを代入
				for(int i = 0; i <= 4; i++) {
					top5.add(list_point.get(i));
				}

				//コードを、総合得点大きい順に収納するためのリストを生成
				List<Integer> list_code = new ArrayList<Integer>();

				//list_codeに総合得点上から５つ分のコードを入れる
				for(int i = 0; i <= 4; i ++) {
					for (int j = 0; j < list.size(); j++) {
						if(top5.get(i).equals(list.get(j).getPoint())) {
							int code = list.get(i).getCode();
							list_code.add(code);
							list.remove(j);
							break;
						}
					}
				}

				//Mapに、順位(キー)とDramaInfoBeanのインスタンス(値)を入れる
				QuestionBean question = new QuestionBean();
				for(int i = 0; i <= 4; i++) {
					int rank = i + 1;
					int code = list_code.get(i);
					question.add(rank,code);
				}

				//リクエストスコープにquestionをセットしてgoto
				request.setAttribute("question",question);
				gotoPage(request,response,"result.jsp");

			}

		} catch (DAOException e) {
			e.printStackTrace();
		}


	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException,IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	private void addList(String q,PointDAO dao,List<CodePointBean> list) {
		try {
			List<CodePointBean> list1 = dao.addPoint(q);

			if(list == null || list.size() == 0) {
				for(int i = 0; i < list1.size(); i++) {
					list.add(list1.get(i));
				}

			} else {
				for(int i = 0;i < list1.size() ;i++) {
					int a = list.get(i).getPoint();
					int b = list1.get(i).getPoint();

					list.get(i).setPoint(a + b);
				}
			}
		}catch(DAOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
