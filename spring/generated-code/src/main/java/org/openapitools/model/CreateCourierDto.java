package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreateCourierDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
public class CreateCourierDto {

  /**
   * Gets or Sets courierType
   */
  public enum CourierTypeEnum {
    FOOT("FOOT"),
    
    BIKE("BIKE"),
    
    AUTO("AUTO");

    private String value;

    CourierTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CourierTypeEnum fromValue(String value) {
      for (CourierTypeEnum b : CourierTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private CourierTypeEnum courierType;

  @Valid
  private List<Integer> regions = new ArrayList<>();

  @Valid
  private List<String> workingHours = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link CreateCourierDto#CreateCourierDto(CourierTypeEnum, List<Integer>, List<String>)}
   */
  @Deprecated
  public CreateCourierDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateCourierDto(CourierTypeEnum courierType, List<Integer> regions, List<String> workingHours) {
    this.courierType = courierType;
    this.regions = regions;
    this.workingHours = workingHours;
  }

  public CreateCourierDto courierType(CourierTypeEnum courierType) {
    this.courierType = courierType;
    return this;
  }

  /**
   * Get courierType
   * @return courierType
  */
  @NotNull 
  @Schema(name = "courier_type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("courier_type")
  public CourierTypeEnum getCourierType() {
    return courierType;
  }

  public void setCourierType(CourierTypeEnum courierType) {
    this.courierType = courierType;
  }

  public CreateCourierDto regions(List<Integer> regions) {
    this.regions = regions;
    return this;
  }

  public CreateCourierDto addRegionsItem(Integer regionsItem) {
    if (this.regions == null) {
      this.regions = new ArrayList<>();
    }
    this.regions.add(regionsItem);
    return this;
  }

  /**
   * Get regions
   * @return regions
  */
  @NotNull 
  @Schema(name = "regions", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("regions")
  public List<Integer> getRegions() {
    return regions;
  }

  public void setRegions(List<Integer> regions) {
    this.regions = regions;
  }

  public CreateCourierDto workingHours(List<String> workingHours) {
    this.workingHours = workingHours;
    return this;
  }

  public CreateCourierDto addWorkingHoursItem(String workingHoursItem) {
    if (this.workingHours == null) {
      this.workingHours = new ArrayList<>();
    }
    this.workingHours.add(workingHoursItem);
    return this;
  }

  /**
   * Get workingHours
   * @return workingHours
  */
  @NotNull 
  @Schema(name = "working_hours", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("working_hours")
  public List<String> getWorkingHours() {
    return workingHours;
  }

  public void setWorkingHours(List<String> workingHours) {
    this.workingHours = workingHours;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCourierDto createCourierDto = (CreateCourierDto) o;
    return Objects.equals(this.courierType, createCourierDto.courierType) &&
        Objects.equals(this.regions, createCourierDto.regions) &&
        Objects.equals(this.workingHours, createCourierDto.workingHours);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courierType, regions, workingHours);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCourierDto {\n");
    sb.append("    courierType: ").append(toIndentedString(courierType)).append("\n");
    sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
    sb.append("    workingHours: ").append(toIndentedString(workingHours)).append("\n");
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

