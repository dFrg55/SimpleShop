package servlets;

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

@WebServlet(name = "servlets.MainServlet", urlPatterns = "/index")
public class MainServlet extends HttpServlet {
    private final Gson gson = new Gson();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        ItemRepository itemService = new ItemRepository(DaoEnum.PostgreHiber);

        List<ItemEntity> users = itemService.findAllItem();

        response.addHeader("Content-Type", "application/json");

        String json = gson.toJson(users);

        response.getWriter().print(json);

        response.flushBuffer();
    }
}