package de.mokkapps.gamenews.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.mokkapps.gamenews.api.model.CompleteOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * CompleteOrderRequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

public class CompleteOrderRequestDto  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("complete_info")
  
  private List<CompleteOrder> completeInfo = new ArrayList<CompleteOrder>();

  public CompleteOrderRequestDto completeInfo(List<CompleteOrder> completeInfo) {
    this.completeInfo = completeInfo;
    return this;
  }

  public CompleteOrderRequestDto addCompleteInfoItem(CompleteOrder completeInfoItem) {
    this.completeInfo.add(completeInfoItem);
    return this;
  }

  /**
   * Get completeInfo
   * @return completeInfo
  */
  @ApiModelProperty(required = true, value = "")
  public List<CompleteOrder> getCompleteInfo() {
    return completeInfo;
  }

  public void setCompleteInfo(List<CompleteOrder> completeInfo) {
    this.completeInfo = completeInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

