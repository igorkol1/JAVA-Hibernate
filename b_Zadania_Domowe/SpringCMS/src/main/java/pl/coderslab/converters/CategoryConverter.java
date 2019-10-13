package pl.coderslab.converters;

import pl.coderslab.entities.Category;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.repositories.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String s) {
        return categoryRepository.findById(Long.parseLong(s)).get();
    }
}
