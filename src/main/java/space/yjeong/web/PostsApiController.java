package space.yjeong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.yjeong.service.PostsService;
import space.yjeong.web.dto.PostsSaveRequestDto;
import space.yjeong.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
}