import com.google.gson.Gson;
import dao.DaoEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ItemEntity;
import repository.ItemRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemRepository itemService = new ItemRepository(DaoEnum.PostgreHiber);

        List<ItemEntity> item = itemService.findAllItem();
        String json = gson.toJson(item);
        req.setAttribute("itemJson", json);
        req.getRequestDispatcher("secure/home.jsp").forward(req, resp);
//        if(req.getSession().getAttribute("role")==null){
//            req.getRequestDispatcher("secure/login-page.jsp").forward(req, resp);
//        }
//        else if (req.getSession().getAttribute("role").equals("admin")) {
//            req.setAttribute("itemJson", json);
//            req.getRequestDispatcher("secure/home.jsp").forward(req, resp);
//        } else if (req.getSession().getAttribute("role").equals("user")) {
//            req.setAttribute("itemJson", json);
//            req.getRequestDispatcher("secure/index.jsp").forward(req, resp);
//        }
//        else {
//            req.getSession().invalidate();
//            req.getRequestDispatcher("secure/login-page.jsp").forward(req, resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}