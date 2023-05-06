package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CompleteOrder
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class CompleteOrder {

  private Long courierId;

  private Long orderId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime completeTime;

  /**
   * Default constructor
   * @deprecated Use {@link CompleteOrder#CompleteOrder(Long, Long, OffsetDateTime)}
   */
  @Deprecated
  public CompleteOrder() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CompleteOrder(Long courierId, Long orderId, OffsetDateTime completeTime) {
    this.courierId = courierId;
    this.orderId = orderId;
    this.completeTime = completeTime;
  }

  public CompleteOrder courierId(Long courierId) {
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

  public CompleteOrder orderId(Long orderId) {
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

  public CompleteOrder completeTime(OffsetDateTime completeTime) {
    this.completeTime = completeTime;
    return this;
  }

  /**
   * Get completeTime
   * @return completeTime
  */
  @NotNull @Valid 
  @Schema(name = "complete_time", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("complete_time")
  public OffsetDateTime getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(OffsetDateTime completeTime) {
    this.completeTime = completeTime;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

