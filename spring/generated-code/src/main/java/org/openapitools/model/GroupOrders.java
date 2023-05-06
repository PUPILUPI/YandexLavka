package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.OrderDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * GroupOrders
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class GroupOrders {

  private Long groupOrderId;

  @Valid
  private List<@Valid OrderDto> orders = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link GroupOrders#GroupOrders(Long, List<@Valid OrderDto>)}
   */
  @Deprecated
  public GroupOrders() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GroupOrders(Long groupOrderId, List<@Valid OrderDto> orders) {
    this.groupOrderId = groupOrderId;
    this.orders = orders;
  }

  public GroupOrders groupOrderId(Long groupOrderId) {
    this.groupOrderId = groupOrderId;
    return this;
  }

  /**
   * Get groupOrderId
   * @return groupOrderId
  */
  @NotNull 
  @Schema(name = "group_order_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("group_order_id")
  public Long getGroupOrderId() {
    return groupOrderId;
  }

  public void setGroupOrderId(Long groupOrderId) {
    this.groupOrderId = groupOrderId;
  }

  public GroupOrders orders(List<@Valid OrderDto> orders) {
    this.orders = orders;
    return this;
  }

  public GroupOrders addOrdersItem(OrderDto ordersItem) {
    if (this.orders == null) {
      this.orders = new ArrayList<>();
    }
    this.orders.add(ordersItem);
    return this;
  }

  /**
   * Get orders
   * @return orders
  */
  @NotNull @Valid 
  @Schema(name = "orders", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orders")
  public List<@Valid OrderDto> getOrders() {
    return orders;
  }

  public void setOrders(List<@Valid OrderDto> orders) {
    this.orders = orders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupOrders groupOrders = (GroupOrders) o;
    return Objects.equals(this.groupOrderId, groupOrders.groupOrderId) &&
        Objects.equals(this.orders, groupOrders.orders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupOrderId, orders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupOrders {\n");
    sb.append("    groupOrderId: ").append(toIndentedString(groupOrderId)).append("\n");
    sb.append("    orders: ").append(toIndentedString(orders)).append("\n");
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

