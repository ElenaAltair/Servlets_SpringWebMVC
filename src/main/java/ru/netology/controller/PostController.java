package ru.netology.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.model.Post;
import ru.netology.service.PostService;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    //public static final String APPLICATION_JSON = "application/json";
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public Map<Long, Post> all() {
        return service.all();
    }
    /*
    public void all(HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var data = service.all();
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data));
    }*/

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return service.getById(id);
    }
    /*
    public void getById(@PathVariable long id, HttpServletResponse response) throws IOException {
        final var data = service.getById(id);
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data));
    }*/

    @PostMapping
    public Post save(@RequestBody Post post) {
        return service.save(post);
    }
    /*
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var gson = new Gson();
        final var post = gson.fromJson(request.getReader(), Post.class);
        final var data = service.save(post);
        response.getWriter().print(gson.toJson(data));
    }*/

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) {
        service.removeById(id);
    }
}