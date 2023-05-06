package de.mokkapps.gamenews.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.mokkapps.gamenews.api.model.OrderDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * GroupOrders
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

public class GroupOrders  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("group_order_id")
  private Long groupOrderId;

  @JsonProperty("orders")
  
  private List<OrderDto> orders = new ArrayList<OrderDto>();

  public GroupOrders groupOrderId(Long groupOrderId) {
    this.groupOrderId = groupOrderId;
    return this;
  }

  /**
   * Get groupOrderId
   * @return groupOrderId
  */
  @ApiModelProperty(required = true, value = "")
  public Long getGroupOrderId() {
    return groupOrderId;
  }

  public void setGroupOrderId(Long groupOrderId) {
    this.groupOrderId = groupOrderId;
  }

  public GroupOrders orders(List<OrderDto> orders) {
    this.orders = orders;
    return this;
  }

  public GroupOrders addOrdersItem(OrderDto ordersItem) {
    this.orders.add(ordersItem);
    return this;
  }

  /**
   * Get orders
   * @return orders
  */
  @ApiModelProperty(required = true, value = "")
  public List<OrderDto> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderDto> orders) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

