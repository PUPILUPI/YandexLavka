package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class OrderDto {

  private Long orderId;

  private Float weight;

  private Integer regions;

  @Valid
  private List<String> deliveryHours = new ArrayList<>();

  private Integer cost;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime completedTime;

  /**
   * Default constructor
   * @deprecated Use {@link OrderDto#OrderDto(Long, Float, Integer, List<String>, Integer)}
   */
  @Deprecated
  public OrderDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderDto(Long orderId, Float weight, Integer regions, List<String> deliveryHours, Integer cost) {
    this.orderId = orderId;
    this.weight = weight;
    this.regions = regions;
    this.deliveryHours = deliveryHours;
    this.cost = cost;
  }

  public OrderDto orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  */
  @NotNull 
  @Schema(name = "order_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("order_id")
  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public OrderDto weight(Float weight) {
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

  public OrderDto regions(Integer regions) {
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

  public OrderDto deliveryHours(List<String> deliveryHours) {
    this.deliveryHours = deliveryHours;
    return this;
  }

  public OrderDto addDeliveryHoursItem(String deliveryHoursItem) {
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

  public OrderDto cost(Integer cost) {
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

  public OrderDto completedTime(OffsetDateTime completedTime) {
    this.completedTime = completedTime;
    return this;
  }

  /**
   * Get completedTime
   * @return completedTime
  */
  @Valid 
  @Schema(name = "completed_time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("completed_time")
  public OffsetDateTime getCompletedTime() {
    return completedTime;
  }

  public void setCompletedTime(OffsetDateTime completedTime) {
    this.completedTime = completedTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDto orderDto = (OrderDto) o;
    return Objects.equals(this.orderId, orderDto.orderId) &&
        Objects.equals(this.weight, orderDto.weight) &&
        Objects.equals(this.regions, orderDto.regions) &&
        Objects.equals(this.deliveryHours, orderDto.deliveryHours) &&
        Objects.equals(this.cost, orderDto.cost) &&
        Objects.equals(this.completedTime, orderDto.completedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, weight, regions, deliveryHours, cost, completedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDto {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
    sb.append("    deliveryHours: ").append(toIndentedString(deliveryHours)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    completedTime: ").append(toIndentedString(completedTime)).append("\n");
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

