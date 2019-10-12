package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.daos.AuthorDao;
import pl.coderslab.entities.Author;
import pl.coderslab.repositories.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author convert(String s) {
        return this.authorRepository.findById(Long.parseLong(s)).get();
    }
}
