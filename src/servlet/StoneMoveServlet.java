package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CanStone;
import model.MatrixBeans;
import model.StoneLogic;
import model.StoneMove;


@WebServlet("/StoneMoveServlet")
public class StoneMoveServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException {

    request.setCharacterEncoding("UTF-8");
    //stoneMoveの取得
    String stoneMove=request.getParameter("stoneMove");

    ServletContext application = this.getServletContext();
    MatrixBeans matrixDB = (MatrixBeans) application.getAttribute("matrixDB");

    //MKM stb.setStoneAreaDB(staDB);ここ必要か？→//shika いやsetじゃなくgetだな

    List<Integer> stoneAreaDB = matrixDB.getStoneAreaDB();
    List<Integer> selectList = matrixDB.getSelectList();
    String stoneSelect = matrixDB.getStoneSelect();

    CanStone cs = new CanStone();
    boolean canRange = cs.canRange(stoneSelect ,stoneAreaDB);

    StoneMove stm = new StoneMove();
    selectList = stm.judgeStoneMove(stoneMove, selectList);
    matrixDB.setSelectList(selectList);


        //StoneLogicの呼び出し,stoneLogic作成
        StoneLogic stoneLogic=new StoneLogic();
        //StoneLogicを起動、stoneAreaDB
        //List<Integer> stoneAreaDB=stoneLogic.execute(stb);

        /*//StoneRoll呼び出し
        StoneRoll str= new StoneRoll();
        //実行
         stoneAreaDB =str.execute(stb);*/

        //stoneAreaDBをアプリケーションスコープに取得
        ServletContext application1= request.getServletContext();
        //stoneAreaDBをアプリケーションスコープに保存しなおす
        application1.setAttribute("stoneAreaDB",stoneAreaDB);

        //matrix.jspへフォワード
        String path = "/matrix.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);

    }//doGet()


    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
    IOException {

    }//doPost()

}//class