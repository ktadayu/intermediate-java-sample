package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContentsDao;
import exception.MyException;
import model.Contents;


@WebServlet("/ContentServlet")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	//ログイン成功後ここへ遷移
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = null;
		try {
			//記録されている書き込みの一覧を取得
			ContentsDao contentsDao = new ContentsDao();
			List<Contents> contentsList = contentsDao.findAllContents();

			request.setAttribute("contentsList", contentsList);

			// 一覧画面をセット
			nextPage = "/view/main.jsp";

		} catch(MyException e) {
			// 一覧処理中に例外が発生した場合はログイン画面に遷移させる
			// 一覧が表示できない可能性があるため
			String message = e.getMessage();
			request.setAttribute("message", message);
			request.setAttribute("error", "true");

			// ログイン画面を表示する準備
			nextPage = "login.jsp";
		}

		// 次の画面に遷移
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);

	}

}
