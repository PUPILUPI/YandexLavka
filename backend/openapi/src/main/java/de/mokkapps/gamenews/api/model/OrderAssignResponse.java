package de.mokkapps.gamenews.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.mokkapps.gamenews.api.model.CouriersGroupOrders;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * OrderAssignResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:27:20.658336400+03:00[Europe/Moscow]")

public class OrderAssignResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("date")
  private Date date;

  @JsonProperty("couriers")
  
  private List<CouriersGroupOrders> couriers = new ArrayList<CouriersGroupOrders>();

  public OrderAssignResponse date(Date date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @ApiModelProperty(required = true, value = "")
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public OrderAssignResponse couriers(List<CouriersGroupOrders> couriers) {
    this.couriers = couriers;
    return this;
  }

  public OrderAssignResponse addCouriersItem(CouriersGroupOrders couriersItem) {
    this.couriers.add(couriersItem);
    return this;
  }

  /**
   * Get couriers
   * @return couriers
  */
  @ApiModelProperty(required = true, value = "")
  public List<CouriersGroupOrders> getCouriers() {
    return couriers;
  }

  public void setCouriers(List<CouriersGroupOrders> couriers) {
    this.couriers = couriers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

