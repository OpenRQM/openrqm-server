package org.openrqm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * RQMWorkspace
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-12T19:15:09.451Z")

public class RQMWorkspace {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("workspace_id")
  private Long workspaceId = null;

  public RQMWorkspace id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * 
   * @return id
   **/
  @ApiModelProperty(value = "")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RQMWorkspace name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * 
   * @return name
   **/
  @ApiModelProperty(value = "")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RQMWorkspace workspaceId(Long workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

  /**
   * Get workspaceId
   * 
   * @return workspaceId
   **/
  @ApiModelProperty(value = "")

  public Long getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(Long workspaceId) {
    this.workspaceId = workspaceId;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RQMWorkspace rqMWorkspace = (RQMWorkspace) o;
    return Objects.equals(this.id, rqMWorkspace.id) && Objects.equals(this.name, rqMWorkspace.name)
        && Objects.equals(this.workspaceId, rqMWorkspace.workspaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, workspaceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RQMWorkspace {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
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