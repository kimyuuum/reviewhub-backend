package com.reviewhub.review.Post.Service;

import com.reviewhub.review.Exception.NotFoundException;
import com.reviewhub.review.Post.Post;
import com.reviewhub.review.Post.PostRepository;
import org.easymock.EasyMockExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(EasyMockExtension.class)
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
        expect(postRepository.findAll()).andReturn(dummyPosts);

        // when
        replay(postRepository);
        List<Post> result = assertDoesNotThrow(sut::findAll);

        // then
        assertThat(result)
                .isNotEmpty()
                .hasSameSizeAs(dummyPosts)
                .containsExactlyInAnyOrderElementsOf(dummyPosts);
        verify(postRepository);
    }

    @Test
    public void should_find_Post_by_idx() {
        // given
        Long idx = new Random().nextLong();
        Post dummyPost = mock(Post.class);
        expect(postRepository.findByIdx(idx)).andReturn(dummyPost);


        // when
        replay(postRepository);
        Post result = assertDoesNotThrow(() -> sut.findPost(idx));

        // then
        assertThat(result)
                .isNotNull()
                .isEqualTo(dummyPost);
        verify(postRepository);
    }

    @Test
    public void should_throw_NotFoundException_when_Post_is_not_found_by_idx() {
        // given
        Long idx = new Random().nextLong();
        expect(postRepository.findByIdx(idx)).andReturn(null);

        // when, then
        replay(postRepository);
        NotFoundException error = assertThrows(NotFoundException.class, () -> sut.findPost(idx));
        assertThat(error.getMessage()).isEqualTo("Can not found posts");
        verify(postRepository);
    }
}
