package org.openrqm.api;

import org.openrqm.model.RQMElement;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-12T19:15:09.451Z")

@Api(value = "element", description = "the element API")
public interface ElementApi {

    @ApiOperation(value = "", nickname = "elementPatch", notes = "", tags = { "element", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Updating element successfull") })
    @RequestMapping(value = "/element", method = RequestMethod.PATCH)
    ResponseEntity<Void> elementPatch(
            @ApiParam(value = "The element to update") @Valid @RequestBody RQMElement element);

    @ApiOperation(value = "", nickname = "elementPost", notes = "", tags = { "element", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Adding new element successfull") })
    @RequestMapping(value = "/element", method = RequestMethod.POST)
    ResponseEntity<Void> elementPost(@ApiParam(value = "The element to create") @Valid @RequestBody RQMElement element);

    @ApiOperation(value = "", nickname = "elementPut", notes = "", tags = { "element", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Updating element successfull") })
    @RequestMapping(value = "/element", method = RequestMethod.PUT)
    ResponseEntity<Void> elementPut(@ApiParam(value = "The element to update") @Valid @RequestBody RQMElement element);

}