package org.fenixedu.bennu.papyrus.service;

import com.google.common.io.ByteStreams;
import com.google.gson.JsonObject;
import pt.ist.papyrus.PapyrusClientException;
import pt.ist.papyrus.PapyrusSettings;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
public interface PdfRendererService {

    InputStream render(String teamId, InputStream template, JsonObject payload) throws PapyrusClientException;

    InputStream render(
            String teamId, InputStream template, JsonObject payload, PapyrusSettings settings
    ) throws PapyrusClientException;

    InputStream render(
            String teamId, String templateId, Locale locale, JsonObject payload
    ) throws PapyrusClientException;

    default byte[] renderToByteArray(
            String teamId, InputStream template, JsonObject payload
    ) throws PdfRenderingException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ByteStreams.copy(render(teamId, template, payload), baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new PdfRenderingException("Error while rendering pdf", e);
        }
    }

    default byte[] renderToByteArray(
            String teamId, InputStream template, JsonObject payload, PapyrusSettings papyrusSettings
    ) throws PdfRenderingException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ByteStreams.copy(render(teamId, template, payload, papyrusSettings), baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new PdfRenderingException("Error while rendering pdf", e);
        }
    }

    default byte[] renderToByteArray(
            String teamId, String templateId, Locale locale, JsonObject payload
    ) throws PdfRenderingException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ByteStreams.copy(render(teamId, templateId, locale, payload), baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new PdfRenderingException("Error while rendering pdf", e);
        }
    }
}
