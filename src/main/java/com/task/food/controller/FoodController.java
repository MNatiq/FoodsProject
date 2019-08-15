package com.task.food.controller;

import com.task.food.dto.CompactFoodDto;
import com.task.food.dto.FoodDto;
import com.task.food.exception.FoodNotFoundException;
import com.task.food.message.Response;
import com.task.food.service.FatSecretApiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

  @Autowired
  FatSecretApiService fatSecretService;

  @RequestMapping("/food/{id}")
  public Response findFoodById(@PathVariable("id") long id) {
    FoodDto foodDto = fatSecretService.getFoodItem(id);
    if (foodDto == null) throw new FoodNotFoundException("Food with id=" + id + " not found!");
    return new Response("Done", foodDto);
  }

  @RequestMapping("/foodType")
  public Response findByFoodType(
      @RequestParam("foodType") String food, @RequestParam("pageNumber") int pageNumber) {
    List<CompactFoodDto> foodDto = fatSecretService.searchFoodItems(food, pageNumber);
    if (foodDto == null) throw new FoodNotFoundException(food + " is missng");
    return new Response("Done", foodDto);
  }
}
