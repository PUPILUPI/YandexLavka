package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.CreateCourierDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreateCourierRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class CreateCourierRequest {

  @Valid
  private List<@Valid CreateCourierDto> couriers = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link CreateCourierRequest#CreateCourierRequest(List<@Valid CreateCourierDto>)}
   */
  @Deprecated
  public CreateCourierRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateCourierRequest(List<@Valid CreateCourierDto> couriers) {
    this.couriers = couriers;
  }

  public CreateCourierRequest couriers(List<@Valid CreateCourierDto> couriers) {
    this.couriers = couriers;
    return this;
  }

  public CreateCourierRequest addCouriersItem(CreateCourierDto couriersItem) {
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
  public List<@Valid CreateCourierDto> getCouriers() {
    return couriers;
  }

  public void setCouriers(List<@Valid CreateCourierDto> couriers) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

