package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.CouriersGroupOrders;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderAssignResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class OrderAssignResponse {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @Valid
  private List<@Valid CouriersGroupOrders> couriers = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link OrderAssignResponse#OrderAssignResponse(LocalDate, List<@Valid CouriersGroupOrders>)}
   */
  @Deprecated
  public OrderAssignResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderAssignResponse(LocalDate date, List<@Valid CouriersGroupOrders> couriers) {
    this.date = date;
    this.couriers = couriers;
  }

  public OrderAssignResponse date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @NotNull @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public OrderAssignResponse couriers(List<@Valid CouriersGroupOrders> couriers) {
    this.couriers = couriers;
    return this;
  }

  public OrderAssignResponse addCouriersItem(CouriersGroupOrders couriersItem) {
    if (this.couriers == null) {
      this.couriers = new ArrayList<>();
    }
    this.couriers.add(couriersItem);
    return this;
  }

  /**
   * Get couriers
   * @return couriers
  */
  @NotNull @Valid 
  @Schema(name = "couriers", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("couriers")
  public List<@Valid CouriersGroupOrders> getCouriers() {
    return couriers;
  }

  public void setCouriers(List<@Valid CouriersGroupOrders> couriers) {
    this.couriers = couriers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderAssignResponse orderAssignResponse = (OrderAssignResponse) o;
    return Objects.equals(this.date, orderAssignResponse.date) &&
        Objects.equals(this.couriers, orderAssignResponse.couriers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, couriers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderAssignResponse {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    couriers: ").append(toIndentedString(couriers)).append("\n");
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

