package ru.clevertec.dealer.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.dealer.dto.CategoryDto;
import ru.clevertec.dealer.entity.Category;
import ru.clevertec.dealer.mapper.CarMapper;
import ru.clevertec.dealer.dao.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Optional<CategoryDto> findById(Long id) {
        return categoryRepository.finById(id).map(CarMapper.INSTANCE::categoryToCategoryDto);
    }

    public List<CategoryDto> findAllStore() {
        return categoryRepository.findAll().stream().map(CarMapper.INSTANCE::categoryToCategoryDto).toList();
    }

    public Category create(CategoryDto categoryDto) {
        Category category = CarMapper.INSTANCE.categoryDtoToCategory(categoryDto);
        return categoryRepository.save(category);
    }

    public void update(CategoryDto categoryDto) {
        categoryRepository.update(CarMapper.INSTANCE.categoryDtoToCategory(categoryDto));
    }

    public boolean delete(Long id) {
        Optional<Category> category = categoryRepository.finById(id);
        category.ifPresent(a -> categoryRepository.delete(a.getCategoryId()));
        return category.isPresent();
    }
}
