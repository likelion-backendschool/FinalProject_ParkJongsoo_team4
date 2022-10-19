package com.ll.exam.ebook;

import com.ll.exam.ebook.entity.Article;
import com.ll.exam.ebook.service.articleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")

        public String showList(Model model) {
            List<Article> articles = articleService.getList();
            model.addAttribute("articles", articles);
            return "article/list";
        }

        @GetMapping("/write")
        public String showWrite() {
            return "article/write";
        }

        @PostMapping("/write")

            public String write(Article article) {
                articleService.save(article);
                return "redirect:/article/list";
    }
}