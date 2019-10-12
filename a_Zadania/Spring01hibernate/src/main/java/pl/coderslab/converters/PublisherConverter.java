package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.daos.PublisherDao;
import pl.coderslab.entities.Publisher;
import pl.coderslab.repositories.PublisherRepository;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher convert(String s) {
        return this.publisherRepository.findById(Long.parseLong(s)).get();
    }
}
