package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.daos.AuthorDao;
import pl.coderslab.entities.Author;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author convert(String s) {
        return this.authorDao.findById(Long.parseLong(s));
    }
}
