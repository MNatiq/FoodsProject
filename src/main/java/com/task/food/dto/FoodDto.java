package com.task.food.dto;

import java.util.List;

public class FoodDto {
  private List<ServingDto> servings;

  public List<ServingDto> getServings() {
    return servings;
  }

  public void setServings(List<ServingDto> servings) {
    this.servings = servings;
  }
}
