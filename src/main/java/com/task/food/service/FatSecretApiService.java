package com.task.food.service;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import com.task.food.dto.CompactFoodDto;
import com.task.food.dto.FoodDto;
import com.task.food.exception.FoodNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FatSecretApiService {

  @Autowired FatsecretService fatsecretService;

  @Autowired ModelMapper modelMapper;

  public FoodDto getFoodItem(long id) {
    Food food = fatsecretService.getFood(id);
    if (food == null) throw new FoodNotFoundException("Food not found");
    return convertToFoodDto(food);
  }

  public List<CompactFoodDto> searchFoodItems(String foodQuery, int pageNumber) {
    Response<CompactFood> responseAtPage3 = fatsecretService.searchFoods(foodQuery, pageNumber);
    List<CompactFood> compactFoods = responseAtPage3.getResults();
    return compactFoods.stream()
        .map(post -> convertToCompactFoodDto(post))
        .collect(Collectors.toList());
  }

  private CompactFoodDto convertToCompactFoodDto(CompactFood post) {
    CompactFoodDto postDto = modelMapper.map(post, CompactFoodDto.class);
    return postDto;
  }

  private FoodDto convertToFoodDto(Food post) {
    FoodDto postDto = modelMapper.map(post, FoodDto.class);
    return postDto;
  }
}
