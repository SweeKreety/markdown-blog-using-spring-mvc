package com.markdown.blog.repositories;

import com.markdown.blog.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
