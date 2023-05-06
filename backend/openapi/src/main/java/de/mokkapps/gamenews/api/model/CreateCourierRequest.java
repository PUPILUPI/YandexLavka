package de.mokkapps.gamenews.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.mokkapps.gamenews.api.model.CreateCourierDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * CreateCourierRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

public class CreateCourierRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("couriers")
  
  private List<CreateCourierDto> couriers = new ArrayList<CreateCourierDto>();

  public CreateCourierRequest couriers(List<CreateCourierDto> couriers) {
    this.couriers = couriers;
    return this;
  }

  public CreateCourierRequest addCouriersItem(CreateCourierDto couriersItem) {
    this.couriers.add(couriersItem);
    return this;
  }

  /**
   * Get couriers
   * @return couriers
  */
  @ApiModelProperty(required = true, value = "")
  public List<CreateCourierDto> getCouriers() {
    return couriers;
  }

  public void setCouriers(List<CreateCourierDto> couriers) {
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
    CreateCourierRequest createCourierRequest = (CreateCourierRequest) o;
    return Objects.equals(this.couriers, createCourierRequest.couriers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(couriers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCourierRequest {\n");
    
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

