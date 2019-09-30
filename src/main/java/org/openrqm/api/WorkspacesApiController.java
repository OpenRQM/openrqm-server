package org.openrqm.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.openrqm.mapper.WorkspaceRowMapper;
import org.openrqm.model.RQMWorkspace;
import org.openrqm.model.RQMWorkspaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class WorkspacesApiController implements WorkspacesApi {
    private static final Logger logger = LoggerFactory.getLogger(WorkspacesApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkspacesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<RQMWorkspaces> getWorkspaces() {
        try {
            List<RQMWorkspace> workspacesList = jdbcTemplate.query("SELECT * FROM workspace", new WorkspaceRowMapper());
            RQMWorkspaces workspaces = new RQMWorkspaces();
            workspaces.addAll(workspacesList); //TODO: improve this, we are touching elements twice here
            return new ResponseEntity<>(workspaces, HttpStatus.OK);
        } catch (DataAccessException ex) {
            logger.error(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



    
