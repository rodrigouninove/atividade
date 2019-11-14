package br.gerenciador.controllers;

import java.io.*;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.gerenciador.banco.Conta;
import br.gerenciador.dao.BancoDao;

@WebServlet("/contas")
public class ContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BancoDao bancoDao = new BancoDao();
		List<Conta> contas = bancoDao.Listar();

		request.setAttribute("contas", contas);
		request.getRequestDispatcher("contas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		
		BancoDao bancoDao = new BancoDao();
		List<Conta> contas = bancoDao.Listar(nome);
		
		request.setAttribute("contas", contas);
		request.getRequestDispatcher("contas.jsp").forward(request, response);

	}

}
