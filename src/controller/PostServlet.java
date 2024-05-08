package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentsDao;
import exception.MyException;
import model.Account;
import model.Contents;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	//書き込む処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String url = request.getParameter("url");

		String message = null ;

		try {
		ContentsDao contentsDao = new ContentsDao();


		if(name == null) {
			Contents content = new Contents(account.getAccountName(),email,title,text,url);
			contentsDao.Insert(content);
			System.out.println(account.getAccountName());
		}else {
			Contents content = new Contents(name,email,title,text,url);
			contentsDao.Insert(content);
		}

		message = "書き込みが完了しました";


		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", message);
		}

		//リスト取得
		try {
			//記録されている書き込みの一覧を取得
			ContentsDao contentsDao = new ContentsDao();
			List<Contents> contentsList = contentsDao.findAllContents();

			request.setAttribute("contentsList", contentsList);

		} catch(MyException e) {
			// 一覧処理中に例外が発生した場合はログイン画面に遷移させる
			// 一覧が表示できない可能性があるため
			message = e.getMessage();
			request.setAttribute("message", message);
			request.setAttribute("error", "true");
		}


		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ContentServlet");
		requestDispatcher.forward(request, response);
//
//		response.sendRedirect(request.getContextPath() + "/view/test.jsp");

	}

}
