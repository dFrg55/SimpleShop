package servlets.filter;



import dao.DaoEnum;
import dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserEntity;
import repository.ItemRepository;
import repository.UserRepository;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

public class AuthFilter implements  Filter {
    private final UserRepository userRepository = new UserRepository(DaoEnum.PostgreHiber);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("j_username");
        final String password = req.getParameter("j_password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDAO> dao = new AtomicReference<UserDAO>();

        final HttpSession session = req.getSession();

        //Logged UserEntity.
         if (nonNull(session) &&
                nonNull(session.getAttribute("j_username")) &&
                nonNull(session.getAttribute("j_password"))) {
            final String role = (String) session.getAttribute("role");


            moveToMenu(req, res, role);


        } else if (userRepository.userIsExist(login, password)) {

            final String role = userRepository.getRoleByLoginPassword(login, password);
            req.getSession().setAttribute("j_password", password);
            req.getSession().setAttribute("j_username", login);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, res, role);

        } else {

            moveToMenu(req, res, "UNKNOWN");
        }
    }

    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final String role)
            throws ServletException, IOException {


        if (role.equals("admin")) {

            req.getRequestDispatcher("/home").forward(req, res);

        } else if (role.equals("user")) {

            req.getRequestDispatcher("/home").forward(req, res);

        } else {
            req.getSession().invalidate();
            req.getRequestDispatcher("allUsers/login-page.jsp").forward(req, res);
        }
    }


    @Override
    public void destroy() {
    }

}
