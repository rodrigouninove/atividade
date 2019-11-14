package br.uninove.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.FuncionarioDao;
import br.uninove.dominio.Funcionario;

@WebServlet("/funcionario")
public class FuncionariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sigla = request.getParameter("sigla");
	
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		if(sigla != null && !sigla.isEmpty()) {
			funcionarios = funcionarioDao.Listar(sigla);
		}else {
			funcionarios = funcionarioDao.Listar();
		}
		
		request.setAttribute("funcionarios", funcionarios);
		request.setAttribute("sigla", sigla);
		
		request.getRequestDispatcher("funcionarios/index.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
