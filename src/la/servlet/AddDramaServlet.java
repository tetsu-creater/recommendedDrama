package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.DAOException;
import la.dao.DeleteChangeAddDAO;

/**
 * Servlet implementation class AddDramaServlet
 */
@WebServlet("/AddDramaServlet")
public class AddDramaServlet extends HttpServlet {
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


			if(action.equals("first")) { //まず最初はここを通る

				HttpSession session = request.getSession(true);
				session.setAttribute("questionList",questionList);
				RequestDispatcher rd = request.getRequestDispatcher("/addDrama.jsp");
				rd.forward(request, response);

			}else if(action.equals("second")) {

				int[] new_pointList = new int[29];

				String title = request.getParameter("title");
				String category = request.getParameter("category");
				String season_str = request.getParameter("season");
				String image = request.getParameter("image");
				String casts = request.getParameter("casts");
				String content = request.getParameter("content");
				String services = request.getParameter("services");

				//パラメータで受け取った点数をnew_pointListに入れる
				for(int i = 0; i < questionList.length; i++) {
					int a = Integer.parseInt(request.getParameter(questionList[i]));
					new_pointList[i] = a;
				}

				if(title==null || category==null || season_str==null || image==null || casts==null || content==null || services==null || title.isEmpty() || category.isEmpty() || season_str.isEmpty() || image.isEmpty() || casts.isEmpty() || content.isEmpty() || services.isEmpty()) {
					response.sendRedirect("addDrama.jsp");
				} else {

					image = image + "_image.jpg";
					content = content + "_content.jpg";

					DeleteChangeAddDAO adddao = new DeleteChangeAddDAO();

					int season = Integer.parseInt(season_str);

					//データベースに追加
					adddao.addDrama(title, category, season, image, casts, content, services);
					adddao.addDramaPoints(new_pointList);

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
