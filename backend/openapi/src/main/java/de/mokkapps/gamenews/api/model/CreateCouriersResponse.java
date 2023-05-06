package de.mokkapps.gamenews.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.mokkapps.gamenews.api.model.CourierDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * CreateCouriersResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

public class CreateCouriersResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("couriers")
  
  private List<CourierDto> couriers = new ArrayList<CourierDto>();

  public CreateCouriersResponse couriers(List<CourierDto> couriers) {
    this.couriers = couriers;
    return this;
  }

  public CreateCouriersResponse addCouriersItem(CourierDto couriersItem) {
    this.couriers.add(couriersItem);
    return this;
  }

  /**
   * Get couriers
   * @return couriers
  */
  @ApiModelProperty(required = true, value = "")
  public List<CourierDto> getCouriers() {
    return couriers;
  }

  public void setCouriers(List<CourierDto> couriers) {
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
    CreateCouriersResponse createCouriersResponse = (CreateCouriersResponse) o;
    return Objects.equals(this.couriers, createCouriersResponse.couriers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(couriers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCouriersResponse {\n");
    
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

