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
 * GetCouriersResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

public class GetCouriersResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("couriers")
  
  private List<CourierDto> couriers = new ArrayList<CourierDto>();

  @JsonProperty("limit")
  private Integer limit;

  @JsonProperty("offset")
  private Integer offset;

  public GetCouriersResponse couriers(List<CourierDto> couriers) {
    this.couriers = couriers;
    return this;
  }

  public GetCouriersResponse addCouriersItem(CourierDto couriersItem) {
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

  public GetCouriersResponse limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Get limit
   * @return limit
  */
  @ApiModelProperty(required = true, value = "")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public GetCouriersResponse offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
  */
  @ApiModelProperty(required = true, value = "")
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCouriersResponse getCouriersResponse = (GetCouriersResponse) o;
    return Objects.equals(this.couriers, getCouriersResponse.couriers) &&
        Objects.equals(this.limit, getCouriersResponse.limit) &&
        Objects.equals(this.offset, getCouriersResponse.offset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(couriers, limit, offset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCouriersResponse {\n");
    
    sb.append("    couriers: ").append(toIndentedString(couriers)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
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

