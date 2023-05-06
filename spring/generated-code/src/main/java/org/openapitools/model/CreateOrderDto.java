package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreateOrderDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class CreateOrderDto {

  private Float weight;

  private Integer regions;

  @Valid
  private List<String> deliveryHours = new ArrayList<>();

  private Integer cost;

  /**
   * Default constructor
   * @deprecated Use {@link CreateOrderDto#CreateOrderDto(Float, Integer, List<String>, Integer)}
   */
  @Deprecated
  public CreateOrderDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateOrderDto(Float weight, Integer regions, List<String> deliveryHours, Integer cost) {
    this.weight = weight;
    this.regions = regions;
    this.deliveryHours = deliveryHours;
    this.cost = cost;
  }

  public CreateOrderDto weight(Float weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
  */
  @NotNull 
  @Schema(name = "weight", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("weight")
  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public CreateOrderDto regions(Integer regions) {
    this.regions = regions;
    return this;
  }

  /**
   * Get regions
   * @return regions
  */
  @NotNull 
  @Schema(name = "regions", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("regions")
  public Integer getRegions() {
    return regions;
  }

  public void setRegions(Integer regions) {
    this.regions = regions;
  }

  public CreateOrderDto deliveryHours(List<String> deliveryHours) {
    this.deliveryHours = deliveryHours;
    return this;
  }

  public CreateOrderDto addDeliveryHoursItem(String deliveryHoursItem) {
    if (this.deliveryHours == null) {
      this.deliveryHours = new ArrayList<>();
    }
    this.deliveryHours.add(deliveryHoursItem);
    return this;
  }

  /**
   * Get deliveryHours
   * @return deliveryHours
  */
  @NotNull 
  @Schema(name = "delivery_hours", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("delivery_hours")
  public List<String> getDeliveryHours() {
    return deliveryHours;
  }

  public void setDeliveryHours(List<String> deliveryHours) {
    this.deliveryHours = deliveryHours;
  }

  public CreateOrderDto cost(Integer cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Get cost
   * @return cost
  */
  @NotNull 
  @Schema(name = "cost", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cost")
  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateOrderDto createOrderDto = (CreateOrderDto) o;
    return Objects.equals(this.weight, createOrderDto.weight) &&
        Objects.equals(this.regions, createOrderDto.regions) &&
        Objects.equals(this.deliveryHours, createOrderDto.deliveryHours) &&
        Objects.equals(this.cost, createOrderDto.cost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight, regions, deliveryHours, cost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateOrderDto {\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
    sb.append("    deliveryHours: ").append(toIndentedString(deliveryHours)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

