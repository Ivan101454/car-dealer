package ru.clevertec.dealer.repository;

import org.hibernate.Session;
import ru.clevertec.dealer.entity.Category;

public class CategoryRepository extends RepositoryBase<Long, Category>{

    public CategoryRepository(Session session) {
        super(Category.class, session);
    }
}
