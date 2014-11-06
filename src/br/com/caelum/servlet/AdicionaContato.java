package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.ContatoDAO;

@WebServlet("/adicionaContato")
public class AdicionaContato extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		
		// pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        
        Calendar dataNascimento = null;
        
        
        // fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return; 
        }
        
        Contato co = new Contato();
        co.setNome(nome);
        co.setEmail(email);
        co.setEndereco(endereco);
        co.setDataNascimento(dataNascimento);
        
        ContatoDAO dao = new ContatoDAO();
        dao.adiciona(co);
		        
        RequestDispatcher rd = request
                .getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(request,response);
		
	}
	
}
