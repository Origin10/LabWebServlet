package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.ProductBean;
import model.ProductService;

@Controller
@RequestMapping("/pages/product.controller")
public class ProductController {
	private SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private ProductService productService;

	@RequestMapping(
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String method(String prodaction,
			@RequestParam("id") String temp1,
			String name,
			@RequestParam("price") String temp2,
			@RequestParam("make") String temp3,
			@RequestParam("expire") String temp4,
			Model model) {
//接收資料
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		
		if("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if(temp1==null || temp1.length()==0) {
				errors.put("id", "請輸入Id以便執行"+prodaction);
			}
		}


//		@InitBinder
//		public void xxx(WebDataBinder webDataBinder){
//			CustomDateEditor customDateEditor =new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd")
//					webDataBinder.registerCustomEditor(java.util.Date.class, customDateEditor);
//					);
//		}
//p108 form-backing Bean
//		public void initBinder(WebDataBinder binder){
//			binder.registerCustomEditor(java.util.Date.class, new CsutomDateEdiror(new SimpleDateFrom("..."), ture))
//		}
//p109
//修改form.jsp:加入新的<input type="text">
//撰寫Form-backing Bean:model.FormBean
//修改HelloController:加入@InitBinder方法
//修改HelloController；修改@RequestMapping方法
//轉換資料

		int id = 0;
		if (temp1!=null && temp1.length()!=0) {
			try {
				id = Integer.parseInt(temp1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("id", "Id欄位請輸入整數");
			}
		}
		
		double price = 0;
		if (temp2!=null && temp2.length()!=0) {
			try {
				price = Double.parseDouble(temp2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("price", "Price欄位請輸入整數");
			}
		}

		java.util.Date make = null;
		if (temp3!=null && temp3.length()!=0) {
			try {
				make = sdFormat.parse(temp3);
			} catch (ParseException e) {
				e.printStackTrace();
				errors.put("make", "Make必須是擁有YYYY-MM-DD格式的日期");
			} 
		}
		
		int expire = 0;
		if (temp4!=null && temp4.length()!=0) {
			try {
				expire = Integer.parseInt(temp4);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("expire", "Expire欄位請輸入整數");
			}
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "product.error";
		}
		
//呼叫Model
		ProductBean bean = new ProductBean();
		bean.setId(id);
		bean.setName(name);
		bean.setPrice(price);
		bean.setMake(make);
		bean.setExpire(expire);
		
//根據Model執行結果呼叫View
		if("Select".equals(prodaction)) {
			List<ProductBean> result = productService.select(bean);
			model.addAttribute("select", result);
			return "product.select";
		} else if("Insert".equals(prodaction)) {
			ProductBean result = productService.insert(bean);
			if(result==null) {
				errors.put("action", "Insert失敗");
			} else {
				model.addAttribute("insert", result);
			}
			return "product.error";
		} else if("Update".equals(prodaction)) {
			ProductBean result = productService.update(bean);
			if(result==null) {
				errors.put("action", "Update失敗");
			} else {
				model.addAttribute("update", result);
			}
			return "product.error";
		} else if("Delete".equals(prodaction)) {
			boolean result = productService.delete(bean);
			if(result) {
				model.addAttribute("delete", 1);
			} else {
				model.addAttribute("delete", 0);
			}
			return "product.error";
		} else {
			errors.put("action", "Unknown Action:"+prodaction);
			return "product.error";
		}
	}
}
