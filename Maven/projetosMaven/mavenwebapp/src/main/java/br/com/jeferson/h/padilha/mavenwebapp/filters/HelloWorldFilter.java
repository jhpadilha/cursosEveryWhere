package br.com.jeferson.h.padilha.mavenwebapp.filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.jeferson.h.padilha.mavenwebapp.filters.infra.GenericFilterApp;

public class HelloWorldFilter extends GenericFilterApp {
  private FilterConfig filterConfig; 

  public void doFilter(final ServletRequest request,
                       final ServletResponse response,
                       FilterChain chain)
       throws java.io.IOException, javax.servlet.ServletException  { 
    System.out.println("Entering Filter");
    request.setAttribute("hello","Hello World!");
    chain.doFilter(request,response);
    request.setAttribute("hello","Hello World!");
    System.out.println("Exiting HelloWorldFilter"); 
  } 
} 