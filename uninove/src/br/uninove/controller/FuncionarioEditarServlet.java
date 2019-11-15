package br.uninove.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.*;
import br.uninove.dominio.*;

@WebServlet("/funcionario/editar")
public class FuncionarioEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("codigo"));

		FuncionarioDao dao = new FuncionarioDao();
		DepartamentoDao daoDepartamento = new DepartamentoDao();
		Funcionario funcionario = dao.Get(codigo);
		List<Departamento> departamentos = daoDepartamento.Listar();
		

		request.setAttribute("funcionario", funcionario);
		request.setAttribute("departamentos", departamentos);

		request.getRequestDispatcher("/funcionarios/editar.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String dt = request.getParameter("dtNascimento");
			Date dtNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(dt);
			int codigoDepartamento = Integer.parseInt(request.getParameter("departamento_codigo"));
			
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.Gravar(codigo, nome, cpf, dtNascimento, codigoDepartamento);

			response.sendRedirect("/uninove/funcionario");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
