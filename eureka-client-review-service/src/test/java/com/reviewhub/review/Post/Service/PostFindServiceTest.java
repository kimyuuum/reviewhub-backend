package com.reviewhub.review.Post.Service;

import com.reviewhub.review.Exception.NotFoundException;
import com.reviewhub.review.Post.Post;
import com.reviewhub.review.Post.PostRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PostFindServiceTest {
    private PostRepository postRepository = mock(PostRepository.class);

    private PostFindService sut = new PostFindService(postRepository);

    @Test
    public void should_find_all_posts() {
        // given
        List<Post> dummyPosts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dummyPosts.add(mock(Post.class));
        }
        when(postRepository.findAll()).thenReturn(dummyPosts);

        // when
        List<Post> result = assertDoesNotThrow(() -> sut.findAll());

        // then
        assertThat(result)
                .isNotEmpty()
                .hasSameSizeAs(dummyPosts)
                .containsExactlyInAnyOrderElementsOf(dummyPosts);
        verify(postRepository, times(1)).findAll();
    }

    @Test
    public void should_find_Post_by_idx() {
        // given
        Long idx = new Random().nextLong();
        Post dummyPost = mock(Post.class);
        when(postRepository.findByIdx(idx)).thenReturn(dummyPost);

        // when
        Post result = assertDoesNotThrow(() -> sut.findPost(idx));

        // then
        assertThat(result)
                .isNotNull()
                .isEqualTo(dummyPost);
        verify(postRepository, times(1)).findByIdx(idx);
    }

    @Test
    public void should_throw_NotFoundException_when_Post_is_not_found_by_idx() {
        // given
        Long idx = new Random().nextLong();
        when(postRepository.findByIdx(idx)).thenReturn(null);

        // when, then
        NotFoundException error = assertThrows(NotFoundException.class, () -> sut.findPost(idx));
        assertThat(error.getMessage()).isEqualTo("Can not found posts");
        verify(postRepository, times(1)).findByIdx(idx);
    }
}
