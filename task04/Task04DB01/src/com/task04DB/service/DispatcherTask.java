package com.task04DB.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.task04DB.dao.PoetCheck;
import com.task04DB.dao.impl.PoetCheckImpl;
import com.task04DB.dto.PoetInfo;
import com.task04DB.util.ConnectionFactory;

/**
 * Servlet implementation class DispatcherTask
 */
@WebServlet("/DispatcherTask")
public class DispatcherTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession ss = request.getSession();		
		Connection conn = ConnectionFactory.getInstance().doConnection();
		PoetCheck pc = new PoetCheckImpl();
		try {
			request.setCharacterEncoding("UTF-8");
			String search_content = request.getParameter("search_poet");
			List<PoetInfo> pi = pc.getResult(conn, search_content.trim());
			if (pi == null) {
				conn.close();
			}
			
			ss.setAttribute("poetInfo", pi);
			response.sendRedirect("poets.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
