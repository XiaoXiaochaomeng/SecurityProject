package com.jwt.JWT.Project.HomeController;

import com.jwt.JWT.Project.dto.FeedbackDto;
import com.jwt.JWT.Project.entity.Account;
import com.jwt.JWT.Project.entity.Feedback;
import com.jwt.JWT.Project.service.AccountService;
import com.jwt.JWT.Project.service.FeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;

	@Autowired
	AccountService accountService;

	@RequestMapping("user/feedback/{username}")
	public String add(Model model, @PathVariable("username") Account username) {
		FeedbackDto dto = new FeedbackDto();
		dto.setAccount(username);
		model.addAttribute("Feedback", dto);
		return "user/feedback";
	}

	@PostMapping("user/feedback/save")
	public String save(ModelMap model,
			@ModelAttribute("Feedback") FeedbackDto dto, HttpServletRequest request, BindingResult result) {

		try {
			if (result.hasErrors()) {
				return "user/feedback";
			}
			String username = request.getRemoteUser();
			Account account = accountService.findByUsername(username);
			dto.setAccount(account);
			Feedback entity = new Feedback();
			BeanUtils.copyProperties(dto, entity);
			feedbackService.save(entity);
			model.addAttribute("message", "Cảm ơn bạn đã góp ý!");
			return "user/feedback";
		} catch (Exception e) {
			model.addAttribute("message", "Bình luận theo mã!");
			return "user/feedback";

		}
	}
}
