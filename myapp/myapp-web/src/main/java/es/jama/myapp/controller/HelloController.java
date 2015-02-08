package es.jama.myapp.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.jama.myapp.service.ProductService;

@Controller
public class HelloController {

//	Declaration zone for autowired services
	@Autowired
	private ProductService productService;
	
	
//	Declaration zone for view names used by controllers
	private static final String HOME_PAGE = "hello";
	
	
//	Controller implementations
	@RequestMapping(value="/hello")
	public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("now", new Date().toString());
		model.put("productList", this.productService.getProductList());
		
		return new ModelAndView(HOME_PAGE, "model", model);
	}
}
