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

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ItemRepository itemService = new ItemRepository(DaoEnum.PostgreHiber);

        List<ItemEntity> users = itemService.findAllItem();

        String json = gson.toJson(users);
        req.setAttribute("usersJson", json);

        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }


}