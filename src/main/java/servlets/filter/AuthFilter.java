package servlets.filter;


import dao.DaoEnum;
import dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.UserRepository;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

@WebFilter("/*")
public class AuthFilter implements Filter {
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

        @SuppressWarnings("unchecked") final AtomicReference<UserDAO> dao = new AtomicReference<UserDAO>();

        final HttpSession session = req.getSession();
        //todo  разграничить роли
        if (((HttpServletRequest) request).getRequestURI().matches(".*(css|jpg|png|gif|js|min\\.js)|(/logout)")) {
            filterChain.doFilter(request, response);
            return;
        }
        
        //Logged UserEntity.
        if (nonNull(session) &&
                nonNull(session.getAttribute("j_username")) &&
                nonNull(session.getAttribute("j_password"))) {
            final String role = (String) session.getAttribute("role");


            moveToMenu(req, res, role,filterChain);


        } else if (userRepository.userIsExist(login, password)) {

            final String role = userRepository.getRoleByLoginPassword(login, password);
            req.getSession().setAttribute("j_password", password);
            req.getSession().setAttribute("j_username", login);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, res, role, filterChain);

        } else {

            moveToMenu(req, res, "UNKNOWN", filterChain);
        }
    }

    private void moveToMenu(final HttpServletRequest request,
                            final HttpServletResponse response,
                            final String role,
                            final FilterChain filterChain)
            throws ServletException, IOException {


        if (role.equals("admin")) {
            if (((HttpServletRequest) request).getRequestURI().matches("(/api/).*")) {
                filterChain.doFilter(request, response);
            }
            else {
                request.getRequestDispatcher("/home").forward(request, response);
            }
        } else if (role.equals("user")) {
            if (((HttpServletRequest) request).getRequestURI().matches("(/api/item/getAllItem)|(/api/item/getOneItem/.*)")) {
                filterChain.doFilter(request, response);
            }
            else {
                request.getRequestDispatcher("/home").forward(request, response);
            }
        } else {
            request.getSession().invalidate();
            request.getRequestDispatcher("allUsers/login-page.jsp").forward(request, response);
        }

    }


    @Override
    public void destroy() {
    }

}
