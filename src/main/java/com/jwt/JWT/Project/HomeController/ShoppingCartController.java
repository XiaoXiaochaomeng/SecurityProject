package com.jwt.JWT.Project.HomeController;

import com.jwt.JWT.Project.entity.Product;
import com.jwt.JWT.Project.repository.CategoryDAO;
import com.jwt.JWT.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShoppingCartController {
    @Autowired
    CategoryDAO dao;
    @Autowired
    ProductService productService;

    @RequestMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cates", dao.findAll());
        model.addAttribute("item", productService.findAll());
        // get totalsize item
        List<Product> items = productService.findAll();
        int totalItems = items.size();
        model.addAttribute("totalItems", totalItems);
        return "cart/view";

    }
}
