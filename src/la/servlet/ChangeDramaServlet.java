package la.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.DramaInfoBean;
import la.bean.QuestionPointBean;
import la.dao.DAOException;
import la.dao.DeleteChangeAddDAO;

/**
 * Servlet implementation class ChangeDramaServlet
 */
@WebServlet("/ChangeDramaServlet")
public class ChangeDramaServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action");

			//dramaPointsの列名をquestionListに入れる
			String[] questionList = new String[29];
			questionList[0] = "1-1";
			questionList[1] = "1-2";
			questionList[2] = "1-3";
			questionList[3] = "2-1";
			questionList[4] = "2-2";
			questionList[5] = "2-3";
			questionList[6] = "2-4";
			questionList[7] = "3-1";
			questionList[8] = "3-2";
			questionList[9] = "3-3";
			questionList[10] = "4-1";
			questionList[11] = "4-2";
			questionList[12] = "4-3";
			questionList[13] = "4-4";
			questionList[14] = "4-5";
			questionList[15] = "4-6";
			questionList[16] = "5-1";
			questionList[17] = "5-2";
			questionList[18] = "5-3";
			questionList[19] = "5-4";
			questionList[20] = "5-5";
			questionList[21] = "6-1";
			questionList[22] = "6-2";
			questionList[23] = "6-3";
			questionList[24] = "7-1";
			questionList[25] = "7-2";
			questionList[26] = "8-1";
			questionList[27] = "8-2";
			questionList[28] = "8-3";

			if(action.equals("first")) {

				int code = Integer.parseInt(request.getParameter("drama_change"));

				DeleteChangeAddDAO changedao = new DeleteChangeAddDAO();
				//beanに現在のドラマ情報を入れる
				DramaInfoBean bean = changedao.show_change(code);

				HttpSession session = request.getSession(true);
				session.setAttribute("drama",bean );

				//現在の点数をnow_pointListに入れる
				int[] now_pointList = changedao.show_change_questionPoint(code, questionList);

				List<QuestionPointBean> list = new ArrayList<QuestionPointBean>();
				String question;
				int nowPoint;

				//bean1に質問一つ一つの現在の点数を入れ、listに加える
				for(int i = 0; i < 29; i++) {

					question = questionList[i];
					nowPoint = now_pointList[i];

					QuestionPointBean bean1 = new QuestionPointBean(question,nowPoint);
					list.add(bean1);
				}


				session.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("/changeDrama.jsp");
				rd.forward(request,response);

			}else if(action.equals("second")) {

				int[] new_pointList = new int[29];

				String title = request.getParameter("title");
				String category = request.getParameter("category");
				String season_str = request.getParameter("season");
				String casts = request.getParameter("cast");
				String services = request.getParameter("service");

				for(int i = 0; i < questionList.length; i++) {
					int a = Integer.parseInt(request.getParameter(questionList[i]));
					new_pointList[i] = a;
				}

				if(title==null || category==null || season_str==null || casts==null || services==null || title.isEmpty() || category.isEmpty() || season_str.isEmpty() || casts.isEmpty() || services.isEmpty()) {
					response.sendRedirect("changeDrama.jsp");
				} else {

					HttpSession session = request.getSession(false);
					DramaInfoBean bean = (DramaInfoBean)session.getAttribute("drama");

					int code = bean.getCode();

					int season = Integer.parseInt(season_str);

					DeleteChangeAddDAO changedao = new DeleteChangeAddDAO();
					//データベースを変更する
					changedao.changeDrama(code,title,category,season,casts,services);
					changedao.changeDramaPoints(code, new_pointList);

					response.sendRedirect("index.jsp");
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
