package br.uninove.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.DepartamentoDao;
import br.uninove.dominio.Departamento;

@WebServlet("/departamento/cadastro.do")
public class DepartamentoCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DepartamentoDao dao = new DepartamentoDao();
		String sigla = request.getParameter("sigla");
		Departamento departamento = new Departamento();
		departamento = dao.Get(sigla);
		request.setAttribute("departamento", departamento);
		
		if ("e".equals(request.getParameter("fn"))) {
			String funcao = "Cadastrar";
			if (sigla != null) {
				funcao = "Editar";
			}
			
			request.setAttribute("funcao", funcao);
			request.getRequestDispatcher("/departamentos/cadastro.jsp").forward(request, response);
			
		} else {
			
			request.getRequestDispatcher("/departamentos/excluir.jsp").forward(request, response);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("codigo"));
		DepartamentoDao dao = new DepartamentoDao();
		
		if("d".equals(request.getParameter("fn"))) {
			
			dao.Excluir(codigo);
			
		}else {
			
			String nome = request.getParameter("nome");
			String sigla = request.getParameter("sigla");
			dao.Gravar(codigo, nome, sigla);			
		}
		
		response.sendRedirect("/uninove/departamento");

	}

}
