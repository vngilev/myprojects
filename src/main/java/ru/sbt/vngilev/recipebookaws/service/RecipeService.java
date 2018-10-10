package ru.sbt.vngilev.recipebookaws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sbt.vngilev.recipebookaws.common.Mapper;
import ru.sbt.vngilev.recipebookaws.dao.RecipeDao;
import ru.sbt.vngilev.recipebookaws.dto.RecipeDto;
import ru.sbt.vngilev.recipebookaws.entity.Recipe;
import ru.sbt.vngilev.recipebookaws.exception.BusinessException;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeDao recipeDao;
    private final Mapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(RecipeService.class);

    @Autowired
    public RecipeService(@SuppressWarnings("SpringJavaAutowiringInspection") RecipeDao recipeDao, Mapper mapper) {
        this.recipeDao = recipeDao;
        this.mapper = mapper;
    }

    @Transactional
    public void create(RecipeDto recipeDto) {
        Recipe recipe = mapper.map(recipeDto, Recipe.class);
        try {
            recipeDao.create(recipe);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Recipe with same name already exists", e);
        }

    }

    /**
     * Отображает объект класса RecipeDto в объект класса Recipe и сохраняет его.
     */
    @Transactional
    public void save(RecipeDto recipeDto) {
        logger.info("save " + recipeDto.getName());
        Recipe recipe = mapper.map(recipeDto, Recipe.class);
        recipeDao.update(recipe);
    }

    /**
     * @return объект класса RecipeDto по имени.
     */
    @Transactional
    public RecipeDto get(Long id) {
        Recipe recipe = recipeDao.get(id);
        if (recipe != null) {
            return mapper.map(recipe, RecipeDto.class);
        } else {
            logger.info("Not exists id:" + id);
            throw new BusinessException("Recipe with same name not exists");
        }
    }

    /**
     * @return список всех рецептов, отображенных в тип RecipeDto.
     */
    @Transactional
    public List<RecipeDto> getAll() {
        List<Recipe> recipeList = recipeDao.getAll();
        List<RecipeDto> recipeDtoList = mapper.mapAsList(recipeList, RecipeDto.class);
        return recipeDtoList;
    }

    /**
     * Удаляет рецепт по имени.
     */
    @Transactional
    public void delete(Long id) {
        logger.info("delete recipe id:" + id);
        recipeDao.delete(id);
    }

}