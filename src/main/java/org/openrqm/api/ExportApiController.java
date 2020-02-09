/*
 * openrqm-server
 * SPDX-License-Identifier: GPL-2.0-only
 * Copyright (C) 2019 Marcel Jaehn
 */
package org.openrqm.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import java.io.FileInputStream;
import java.util.List;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.logging.Level;
import javax.validation.Valid;
import org.openrqm.export.PdfExporter;
import org.openrqm.mapper.DocumentRowMapper;
import org.openrqm.mapper.ElementRowMapper;
import org.openrqm.model.RQMDocument;
import org.openrqm.model.RQMElement;
import org.openrqm.model.RQMElements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExportApiController implements ExportApi {

    private static final Logger logger = LoggerFactory.getLogger(ExportApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ExportApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    public ResponseEntity<Resource> exportDocument(@ApiParam(value = "The document to export") @Valid @RequestParam(value = "documentId", required = false) Long documentId) {
        logger.info("Gettings elements from database");
        RQMElements elements = new RQMElements();
        try {
            List<RQMElement> elementsList = jdbcTemplate.query("SELECT * FROM element WHERE document_id = ? ORDER BY rank;", new Object[] { documentId } , new ElementRowMapper());
            elements.addAll(elementsList); //TODO: improve this, we are touching elements twice here
        } catch (DataAccessException ex) {
            logger.error(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("Retrieved elements from database");
        
        logger.info("Starting export");
        Resource pdfExportResource;
        try {
            PdfExporter pdfExporter = new PdfExporter();
            pdfExportResource = pdfExporter.export(null, elements, "template", "export");
            logger.info("Finished export successful");
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (pdfExportResource != null && pdfExportResource.exists()) {
            return new ResponseEntity<>(pdfExportResource, HttpStatus.OK);
        } else {
            logger.error("No exported document can be returned");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}