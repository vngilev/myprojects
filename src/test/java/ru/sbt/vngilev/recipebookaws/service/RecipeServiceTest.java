package ru.sbt.vngilev.recipebookaws.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.sbt.vngilev.recipebookaws.dto.RecipeDto;
import ru.sbt.vngilev.recipebookaws.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/recipebook-application.xml")
public class RecipeServiceTest extends TestCase {


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RecipeService recipeService;

    @Test
    public void testGetAll() {
        List<RecipeDto> recipeDtoList = recipeService.getAll();
        recipeDtoList.stream()
                .forEach(s -> System.out.println(s.toString()));
        assertEquals(10, recipeDtoList.size());
    }


}

