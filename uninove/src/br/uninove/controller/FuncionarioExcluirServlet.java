package br.uninove.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.FuncionarioDao;
import br.uninove.dominio.Funcionario;

@WebServlet("/funcionario/excluir")
public class FuncionarioExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.Get(codigo);
		
		if(funcionario != null) {
			request.setAttribute("funcionario", funcionario);
			request.setAttribute("msgError", "");
			request.setAttribute("sigla", request.getParameter("sigla"));
		}else {
			request.setAttribute("funcionario", null);
			request.setAttribute("msgError", "O codigo fornecido não corresponde a um funcionário válido!");
		}
		
		request.getRequestDispatcher("/funcionarios/excluir.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.Excluir(codigo);
		
		request.setAttribute("msgSuccess", "Funcionário exclido com sucesso");
		request.setAttribute("sigla", request.getParameter("sigla"));
		
		request.getRequestDispatcher("/funcionarios/excluir.jsp").forward(request, response);
		
	}

}
