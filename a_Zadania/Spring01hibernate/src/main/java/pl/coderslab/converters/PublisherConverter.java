package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.daos.PublisherDao;
import pl.coderslab.entities.Publisher;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    PublisherDao publisherDao;

    @Override
    public Publisher convert(String s) {
        return this.publisherDao.findById(Long.parseLong(s));
    }
}
