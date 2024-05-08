package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import exception.MyException;
import model.Account;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//ログアウト用・GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();

		request.setAttribute("message", "ログアウト完了");

		RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
		rd.forward(request, response);
	}

	//ログイン用・POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int loginId = Integer.parseInt(request.getParameter("loginId"));
		String loginPassword = request.getParameter("loginPassword");
		String nextPage = null;
		try {

			AccountDao accountDao = new AccountDao();
			Account account = accountDao.doLogin(loginId, loginPassword);

			//sessionにインスタンスを格納
			//ログアウト時にinvalidateにする
			HttpSession session = request.getSession();
			session.setAttribute("account", account);

			// ContentServletのPOSTに移動
			//nextPage = "ContentServlet";
			nextPage ="ContentServlet";
		} catch (MyException e) {

			String message = e.getMessage();
			request.setAttribute("message", message);
			request.setAttribute("error", "true");

			// ログイン画面へ
			nextPage = "/view/login.jsp";
		}

		// 次の画面に遷移
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);

	}

}
