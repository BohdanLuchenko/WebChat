package tere;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class ServerAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        /*PrintWriter out = resp.getWriter();
        out.println("<h1>Bohdan Luchenko</h1>");*/



        String type = req.getParameter("typeOfRequest");

        if (type != null && type.equals("getUsersOnline")) {

            Team team = Team.getInstance();
            team.getListOfPersonsOnline();
            String myList = new String();
            for (int i = 0; i < team.getListOfPersonsOnline().size(); i++) {
                myList = myList + team.getListOfPersonsOnline().get(i).getName() + ", <br>";
            }

            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html;charset=UTF-8");
            out.print(myList);
            out.flush();
        }


        else if(type != null && type.equals("getHistory")) {
            Messager messager = Messager.getInstance();
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html;charset=UTF-8");
            out.print(messager.getMessages());
            out.flush();
        }

        else if(type != null && type.equals("sendMessage")) {

            String message = req.getParameter("message");
            System.out.println(message);
            Messager messager = Messager.getInstance();
            String myUser = req.getParameter("myUser");
            messager.addMessageByUser(message,myUser);

        }



        else{
                req.setAttribute("myName", " - Enter another name");
                req.getRequestDispatcher("indexChat.jsp").forward(req, resp);
            }
        }

}