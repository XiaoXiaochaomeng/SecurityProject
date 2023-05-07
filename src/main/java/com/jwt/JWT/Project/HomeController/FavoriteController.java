package com.jwt.JWT.Project.HomeController;

import com.jwt.JWT.Project.dto.FavoriteDto;
import com.jwt.JWT.Project.entity.Favorite;
import com.jwt.JWT.Project.entity.Product;
import com.jwt.JWT.Project.service.AccountService;
import com.jwt.JWT.Project.service.FavoriteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("favorite")
public class FavoriteController {
	@Autowired
	FavoriteService favoriteService;

	@Autowired
	AccountService accountService;

	@RequestMapping("")
	public String list(Model model) {
		List<Favorite> list = favoriteService.findAll();
		model.addAttribute("favorites", list);
		return "user/favorite";
	}

	@GetMapping("save/{productId}")
	public ModelAndView save(ModelMap model, FavoriteDto dto, HttpServletRequest request,
							 @PathVariable("productId") Long productId) {
		String username = request.getRemoteUser();

		dto.setUsername(username);
		dto.setProductId(productId);

		Favorite fa = new Favorite();
		BeanUtils.copyProperties(dto, fa);

		Product product = new Product();
		product.setProductId(dto.getProductId());
		fa.setProduct(product);

		favoriteService.save(fa);

		return new ModelAndView("forward:/", model);
	}

	@GetMapping("delete/{favoriteId}")
	public ModelAndView delete(ModelMap model, @PathVariable("favoriteId") Long favoriteId) throws IOException {

		Optional<Favorite> opt = favoriteService.findById(favoriteId);

		favoriteService.delete(opt.get());
		model.addAttribute("message", "Đã xóa!");

		return new ModelAndView("forward:/favorite", model);
	}
}
