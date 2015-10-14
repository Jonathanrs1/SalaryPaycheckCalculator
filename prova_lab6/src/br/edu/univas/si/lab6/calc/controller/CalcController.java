package br.edu.univas.si.lab6.calc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.univas.si.lab6.calc.service.CalcService;
import br.edu.univas.si.lab6.calc.to.ValoresTO;

public class CalcController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Float salarioBruto = Float.valueOf(request.getParameter("salarioBruto"));
		CalcService cs = new CalcService();
		
		ValoresTO vro = cs.doCalc(salarioBruto); 
		
		Gson gson = new Gson();
		String json = gson.toJson(vro);
		
		response.getWriter().append(json);
	}
	
}
