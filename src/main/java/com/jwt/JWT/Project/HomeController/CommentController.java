package com.jwt.JWT.Project.HomeController;

import com.jwt.JWT.Project.dto.CommentDto;
import com.jwt.JWT.Project.entity.Account;
import com.jwt.JWT.Project.entity.Comment;
import com.jwt.JWT.Project.entity.Product;
import com.jwt.JWT.Project.service.AccountService;
import com.jwt.JWT.Project.service.CommentService;
import com.jwt.JWT.Project.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	CommentService commentService;

	@Autowired
	ProductService productService;

	@Autowired
	AccountService accountService;

	@GetMapping("add/{productId}")
	public String addComment(Model model, @PathVariable("productId") Product name) {
		CommentDto dto = new CommentDto();
		dto.setProduct(name);
		model.addAttribute("Comment", dto);
		return "product/comment";
	}

	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(Model model, HttpServletRequest request,
			@ModelAttribute("Comment") CommentDto dto, BindingResult result) {

		try {
			if (result.hasErrors()) {
				return "product/comment";
			}
			String username = request.getRemoteUser();
			Account account = accountService.findByUsername(username);
			dto.setAccount(account);
			Comment entity = new Comment();
			BeanUtils.copyProperties(dto, entity);
			commentService.save(entity);
			model.addAttribute("message", "Cảm ơn bạn đã đánh giá sản phẩm.");
			return "product/comment";
		} catch (Exception e) {
			model.addAttribute("message", "Bình luận theo mã!");
			return "product/comment";
		}
	}
}
