package br.com.jhony.servlet;

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

import br.com.jhony.beans.Contato;
import br.com.jhony.db.ContatoDAO;

@WebServlet("/alteraContato")
public class AlteraContatoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		
		// pegando os parâmetros do request
		String idTexto = request.getParameter("id");
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
        
        Long id = new Long(idTexto);
        
        Contato co = new Contato();
        co.setId(id);
        co.setNome(nome);
        co.setEmail(email);
        co.setEndereco(endereco);
        co.setDataNascimento(dataNascimento);
        
        ContatoDAO dao = new ContatoDAO();
        dao.altera(co);
		        
        RequestDispatcher rd = request
                .getRequestDispatcher("/contato-alterado.jsp");
        rd.forward(request,response);
		
	}
	
}
