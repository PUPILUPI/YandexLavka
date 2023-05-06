package de.mokkapps.gamenews.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * GetCourierMetaInfoResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

public class GetCourierMetaInfoResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("courier_id")
  private Long courierId;

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

  @JsonProperty("courier_type")
  private CourierTypeEnum courierType;

  @JsonProperty("regions")
  
  private List<Integer> regions = new ArrayList<Integer>();

  @JsonProperty("working_hours")
  
  private List<String> workingHours = new ArrayList<String>();

  @JsonProperty("rating")
  private Integer rating;

  @JsonProperty("earnings")
  private Integer earnings;

  public GetCourierMetaInfoResponse courierId(Long courierId) {
    this.courierId = courierId;
    return this;
  }

  /**
   * Get courierId
   * @return courierId
  */
  @ApiModelProperty(required = true, value = "")
  public Long getCourierId() {
    return courierId;
  }

  public void setCourierId(Long courierId) {
    this.courierId = courierId;
  }

  public GetCourierMetaInfoResponse courierType(CourierTypeEnum courierType) {
    this.courierType = courierType;
    return this;
  }

  /**
   * Get courierType
   * @return courierType
  */
  @ApiModelProperty(required = true, value = "")
  public CourierTypeEnum getCourierType() {
    return courierType;
  }

  public void setCourierType(CourierTypeEnum courierType) {
    this.courierType = courierType;
  }

  public GetCourierMetaInfoResponse regions(List<Integer> regions) {
    this.regions = regions;
    return this;
  }

  public GetCourierMetaInfoResponse addRegionsItem(Integer regionsItem) {
    this.regions.add(regionsItem);
    return this;
  }

  /**
   * Get regions
   * @return regions
  */
  @ApiModelProperty(required = true, value = "")
  public List<Integer> getRegions() {
    return regions;
  }

  public void setRegions(List<Integer> regions) {
    this.regions = regions;
  }

  public GetCourierMetaInfoResponse workingHours(List<String> workingHours) {
    this.workingHours = workingHours;
    return this;
  }

  public GetCourierMetaInfoResponse addWorkingHoursItem(String workingHoursItem) {
    this.workingHours.add(workingHoursItem);
    return this;
  }

  /**
   * Get workingHours
   * @return workingHours
  */
  @ApiModelProperty(required = true, value = "")
  public List<String> getWorkingHours() {
    return workingHours;
  }

  public void setWorkingHours(List<String> workingHours) {
    this.workingHours = workingHours;
  }

  public GetCourierMetaInfoResponse rating(Integer rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
  */
  @ApiModelProperty(value = "")
  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public GetCourierMetaInfoResponse earnings(Integer earnings) {
    this.earnings = earnings;
    return this;
  }

  /**
   * Get earnings
   * @return earnings
  */
  @ApiModelProperty(value = "")
  public Integer getEarnings() {
    return earnings;
  }

  public void setEarnings(Integer earnings) {
    this.earnings = earnings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCourierMetaInfoResponse getCourierMetaInfoResponse = (GetCourierMetaInfoResponse) o;
    return Objects.equals(this.courierId, getCourierMetaInfoResponse.courierId) &&
        Objects.equals(this.courierType, getCourierMetaInfoResponse.courierType) &&
        Objects.equals(this.regions, getCourierMetaInfoResponse.regions) &&
        Objects.equals(this.workingHours, getCourierMetaInfoResponse.workingHours) &&
        Objects.equals(this.rating, getCourierMetaInfoResponse.rating) &&
        Objects.equals(this.earnings, getCourierMetaInfoResponse.earnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courierId, courierType, regions, workingHours, rating, earnings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCourierMetaInfoResponse {\n");
    
    sb.append("    courierId: ").append(toIndentedString(courierId)).append("\n");
    sb.append("    courierType: ").append(toIndentedString(courierType)).append("\n");
    sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
    sb.append("    workingHours: ").append(toIndentedString(workingHours)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    earnings: ").append(toIndentedString(earnings)).append("\n");
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

