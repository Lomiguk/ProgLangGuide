package com.vsu.skibin.coursework.app.controller.article;

import com.vsu.skibin.coursework.app.api.data.dto.ArticleDTO;
import com.vsu.skibin.coursework.app.api.data.request.article.AddArticleRequest;
import com.vsu.skibin.coursework.app.api.data.request.article.PatchArticleRequest;
import com.vsu.skibin.coursework.app.exception.article.UnknownArticleException;
import com.vsu.skibin.coursework.app.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ArticleDTO getArticle(@PathVariable Long id) {
        ArticleDTO articleDTO = articleService.getArticle(id);
        if (articleDTO == null){
            throw new UnknownArticleException("Unknown article");
        }
        return articleDTO;
    }

    @PostMapping("/{id}")
    public int incReadCount(@PathVariable Long id) {
        return articleService.incReadCount(id);
    }

    @PostMapping("/")
    public int addArticle(@RequestParam Long authorId, @RequestBody AddArticleRequest articleRequest) {
        return articleService.addArticle(authorId,
                articleRequest.getTitle(),
                articleRequest.getDate(),
                articleRequest.getContent());
    }

    @PatchMapping("/{id}")
    public int editArticle(@PathVariable Long id, @RequestBody PatchArticleRequest patchArticle) {
        return articleService.updateArticle(id, patchArticle.getTittle(), patchArticle.getContent());
    }

    @DeleteMapping("/{id}")
    public int deleteArticle(@PathVariable Long id) {
        return articleService.deleteArticle(id);
    }
}
