package br.uninove.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.DepartamentoDao;
import br.uninove.dominio.Departamento;

@WebServlet("/departamento")
public class DepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepartamentoDao departamentoDao = new DepartamentoDao();		
		List<Departamento> departamentos = departamentoDao.Listar();
		
		request.setAttribute("departamentos", departamentos);
		
		request.getRequestDispatcher("departamentos/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
