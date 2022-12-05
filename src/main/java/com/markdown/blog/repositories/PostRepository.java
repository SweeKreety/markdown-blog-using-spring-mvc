package com.markdown.blog.repositories;

import com.markdown.blog.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    long count();

    Page<Post> findAll(Pageable pageRequest);

    Optional<Post> findById(long id);

    void save(Post post);
}
