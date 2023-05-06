package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.CompleteOrder;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CompleteOrderRequestDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class CompleteOrderRequestDto {

  @Valid
  private List<@Valid CompleteOrder> completeInfo = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link CompleteOrderRequestDto#CompleteOrderRequestDto(List<@Valid CompleteOrder>)}
   */
  @Deprecated
  public CompleteOrderRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CompleteOrderRequestDto(List<@Valid CompleteOrder> completeInfo) {
    this.completeInfo = completeInfo;
  }

  public CompleteOrderRequestDto completeInfo(List<@Valid CompleteOrder> completeInfo) {
    this.completeInfo = completeInfo;
    return this;
  }

  public CompleteOrderRequestDto addCompleteInfoItem(CompleteOrder completeInfoItem) {
    if (this.completeInfo == null) {
      this.completeInfo = new ArrayList<>();
    }
    this.completeInfo.add(completeInfoItem);
    return this;
  }

  /**
   * Get completeInfo
   * @return completeInfo
  */
  @NotNull @Valid 
  @Schema(name = "complete_info", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("complete_info")
  public List<@Valid CompleteOrder> getCompleteInfo() {
    return completeInfo;
  }

  public void setCompleteInfo(List<@Valid CompleteOrder> completeInfo) {
    this.completeInfo = completeInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteOrderRequestDto completeOrderRequestDto = (CompleteOrderRequestDto) o;
    return Objects.equals(this.completeInfo, completeOrderRequestDto.completeInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(completeInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteOrderRequestDto {\n");
    sb.append("    completeInfo: ").append(toIndentedString(completeInfo)).append("\n");
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

