package de.mokkapps.gamenews.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.mokkapps.gamenews.api.model.GroupOrders;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * CouriersGroupOrders
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

public class CouriersGroupOrders  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("courier_id")
  private Long courierId;

  @JsonProperty("orders")
  
  private List<GroupOrders> orders = new ArrayList<GroupOrders>();

  public CouriersGroupOrders courierId(Long courierId) {
    this.courierId = courierId;
    return this;
  }

  /**
   * Get courierId
   * @return courierId
  */
  @ApiModelProperty(required = true, value = "")
  public Long getCourierId() {
    return courierId;
  }

  public void setCourierId(Long courierId) {
    this.courierId = courierId;
  }

  public CouriersGroupOrders orders(List<GroupOrders> orders) {
    this.orders = orders;
    return this;
  }

  public CouriersGroupOrders addOrdersItem(GroupOrders ordersItem) {
    this.orders.add(ordersItem);
    return this;
  }

  /**
   * Get orders
   * @return orders
  */
  @ApiModelProperty(required = true, value = "")
  public List<GroupOrders> getOrders() {
    return orders;
  }

  public void setOrders(List<GroupOrders> orders) {
    this.orders = orders;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

