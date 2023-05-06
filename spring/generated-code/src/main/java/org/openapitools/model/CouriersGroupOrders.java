package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.GroupOrders;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CouriersGroupOrders
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class CouriersGroupOrders {

  private Long courierId;

  @Valid
  private List<@Valid GroupOrders> orders = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link CouriersGroupOrders#CouriersGroupOrders(Long, List<@Valid GroupOrders>)}
   */
  @Deprecated
  public CouriersGroupOrders() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CouriersGroupOrders(Long courierId, List<@Valid GroupOrders> orders) {
    this.courierId = courierId;
    this.orders = orders;
  }

  public CouriersGroupOrders courierId(Long courierId) {
    this.courierId = courierId;
    return this;
  }

  /**
   * Get courierId
   * @return courierId
  */
  @NotNull 
  @Schema(name = "courier_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("courier_id")
  public Long getCourierId() {
    return courierId;
  }

  public void setCourierId(Long courierId) {
    this.courierId = courierId;
  }

  public CouriersGroupOrders orders(List<@Valid GroupOrders> orders) {
    this.orders = orders;
    return this;
  }

  public CouriersGroupOrders addOrdersItem(GroupOrders ordersItem) {
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
  public List<@Valid GroupOrders> getOrders() {
    return orders;
  }

  public void setOrders(List<@Valid GroupOrders> orders) {
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
    CouriersGroupOrders couriersGroupOrders = (CouriersGroupOrders) o;
    return Objects.equals(this.courierId, couriersGroupOrders.courierId) &&
        Objects.equals(this.orders, couriersGroupOrders.orders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courierId, orders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouriersGroupOrders {\n");
    sb.append("    courierId: ").append(toIndentedString(courierId)).append("\n");
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

