package negocio;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;




public class RedirecionaPaginaPadrao implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		if(roles.contains("ROLE_ADMINISTRADOR")){
			response.sendRedirect("/LojaVirtual/admin/principal.xhtml");
		}
		else if(roles.contains("ROLE_Cliente")){
			response.sendRedirect("/LojaVirtual/cliente/forma_de_pagamento.xhtml");
		}
		
	}

	
	
}