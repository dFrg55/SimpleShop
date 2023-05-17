package secure;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class Validator extends HttpServlet {
    String login;
    String password;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login=req.getParameter("j_username");
        password=req.getParameter("j_password");
        //todo проверить какую роль имеет пользователь и сфорировать для него токен

        //todo добавить токеy jwt которы будет потверждать права
        System.out.println(login+" "+password);
    }
}