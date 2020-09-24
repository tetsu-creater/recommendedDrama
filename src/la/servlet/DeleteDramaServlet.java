package la.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.dao.DAOException;
import la.dao.DeleteChangeAddDAO;

/**
 * Servlet implementation class DeleteDramaServlet
 */
@WebServlet("/DeleteDramaServlet")
public class DeleteDramaServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String drama_delete = request.getParameter("drama_delete");
			int code = Integer.parseInt(drama_delete);

			DeleteChangeAddDAO deletedao = new DeleteChangeAddDAO();

			//データベースから削除
			deletedao.deleteDrama(code);
			deletedao.deleteDramaPoints(code);

			//index.jspに戻る
			response.sendRedirect("index.jsp");

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
