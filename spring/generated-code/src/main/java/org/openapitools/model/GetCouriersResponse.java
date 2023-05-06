package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.CourierDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * GetCouriersResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class GetCouriersResponse {

  @Valid
  private List<@Valid CourierDto> couriers = new ArrayList<>();

  private Integer limit;

  private Integer offset;

  /**
   * Default constructor
   * @deprecated Use {@link GetCouriersResponse#GetCouriersResponse(List<@Valid CourierDto>, Integer, Integer)}
   */
  @Deprecated
  public GetCouriersResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetCouriersResponse(List<@Valid CourierDto> couriers, Integer limit, Integer offset) {
    this.couriers = couriers;
    this.limit = limit;
    this.offset = offset;
  }

  public GetCouriersResponse couriers(List<@Valid CourierDto> couriers) {
    this.couriers = couriers;
    return this;
  }

  public GetCouriersResponse addCouriersItem(CourierDto couriersItem) {
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
  public List<@Valid CourierDto> getCouriers() {
    return couriers;
  }

  public void setCouriers(List<@Valid CourierDto> couriers) {
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
  @NotNull 
  @Schema(name = "limit", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("limit")
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
  @NotNull 
  @Schema(name = "offset", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("offset")
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

