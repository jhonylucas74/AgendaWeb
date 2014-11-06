package br.com.caelum.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.ContatoDAO;

@WebServlet("/contatos")
public class ContatoAll extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();		
		
		List<Contato> lista = null;
		
		ContatoDAO dao = new ContatoDAO();
		lista = dao.getLista();
		
	    out.println("<html>");
        out.println("<body>");
        out.println("<ul>");
        
        if(lista != null){
        for(Contato c: lista){
        	out.println("<li> nome:" +c.getNome()+" email:"+c.getEmail()+" data:"+c.getDataNascimento().toString()+"</li> ");
        }
                        	
        }else{
        	out.println("Lista vazia :( ");
        }
        
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
		
		
	}

}
