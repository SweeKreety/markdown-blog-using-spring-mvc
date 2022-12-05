package com.markdown.blog.util;


import com.markdown.blog.entities.Author;
import com.markdown.blog.repositories.AuthorRepository;

import java.util.Optional;

public class AuthorUtil {
    public static Author bootstrapAuthor(AuthorRepository authorRepository) {
        Optional<Author> authorOpt = authorRepository.findById(1L);
        if (authorOpt.isPresent()) {
            return authorOpt.get();
        } else {
            Author author = new Author();
            author.setName("Swikriti Kandel");
            author.setEmail("swikriti@gmail.com");
            author.setUrl("swikriti.name.np");

            authorRepository.save(author);
            return author;
        }
    }
}
