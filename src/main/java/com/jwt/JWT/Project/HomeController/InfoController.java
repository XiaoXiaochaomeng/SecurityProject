package com.jwt.JWT.Project.HomeController;

import com.jwt.JWT.Project.dto.AccountDto;
import com.jwt.JWT.Project.entity.Account;
import com.jwt.JWT.Project.service.AccountService;
import com.jwt.JWT.Project.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InfoController {
    @Autowired
    AccountService accountService;
    @Autowired
    StorageService storageService;

    @RequestMapping("/info/{username}")
    public String info(Model model, @PathVariable("username") String username) {
        Account acc = accountService.findById(username).get();
        model.addAttribute("info", acc);
        return "user/info";
    }

    @RequestMapping("/info/edit/{username}")
    public String edit(ModelMap model, @PathVariable("username") String username) {

        Optional<Account> opt = accountService.findById(username);
        AccountDto dto = new AccountDto();

        if (opt.isPresent()) {
            Account acc = opt.get();
            BeanUtils.copyProperties(acc, dto);

            model.addAttribute("account", dto);
            return "user/edit";
        }

        model.addAttribute("message", "Lỗi thiết lập tài khoản!");

        return "forward:/info/edit";
    }

    @PostMapping("/info/saveOrUpdate")
    public String saveOrUpdate(ModelMap model,
            @ModelAttribute("account") AccountDto dto, BindingResult result) {

        if (result.hasErrors()) {
            return "/user/edit";
        }
        Account acc = new Account();
        BeanUtils.copyProperties(dto, acc);

        if (!dto.getImageFile().isEmpty()) {
            acc.setImage(storageService.getStoredFilename(dto.getImageFile(), null));
            storageService.store(dto.getImageFile(), acc.getImage());
        }

        accountService.save(acc);
        model.addAttribute("message", "Lưu thành công!");
        return "user/edit";
    }

    @GetMapping("/info/images/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

}
