package de.mokkapps.gamenews.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * CompleteOrder
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

public class CompleteOrder  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("courier_id")
  private Long courierId;

  @JsonProperty("order_id")
  private Long orderId;

  @JsonProperty("complete_time")
  private Date completeTime;

  public CompleteOrder courierId(Long courierId) {
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

  public CompleteOrder orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  */
  @ApiModelProperty(required = true, value = "")
  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public CompleteOrder completeTime(Date completeTime) {
    this.completeTime = completeTime;
    return this;
  }

  /**
   * Get completeTime
   * @return completeTime
  */
  @ApiModelProperty(required = true, value = "")
  public Date getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(Date completeTime) {
    this.completeTime = completeTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteOrder completeOrder = (CompleteOrder) o;
    return Objects.equals(this.courierId, completeOrder.courierId) &&
        Objects.equals(this.orderId, completeOrder.orderId) &&
        Objects.equals(this.completeTime, completeOrder.completeTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courierId, orderId, completeTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteOrder {\n");
    
    sb.append("    courierId: ").append(toIndentedString(courierId)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    completeTime: ").append(toIndentedString(completeTime)).append("\n");
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

