package org.fenixedu.bennu.papyrus.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import com.google.common.io.ByteStreams;
import com.google.gson.JsonObject;
import pt.ist.papyrus.PapyrusClientException;
import pt.ist.papyrus.PapyrusSettings;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
public interface PdfRendererService {

    InputStream render(InputStream template, JsonObject payload) throws PapyrusClientException;

    InputStream render(InputStream template, JsonObject payload, PapyrusSettings settings) throws PapyrusClientException;

    InputStream render(String templateId, Locale locale, JsonObject payload) throws PapyrusClientException;

    default byte[] renderToByteArray(InputStream template, JsonObject payload) throws PdfRenderingException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ByteStreams.copy(render(template, payload), baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new PdfRenderingException("Error while rendering pdf", e);
        }
    }

    default byte[] renderToByteArray(InputStream template, JsonObject payload, PapyrusSettings papyrusSettings) throws PdfRenderingException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ByteStreams.copy(render(template, payload, papyrusSettings), baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new PdfRenderingException("Error while rendering pdf", e);
        }
    }

    default byte[] renderToByteArray(String templateId, Locale locale, JsonObject payload) throws PdfRenderingException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ByteStreams.copy(render(templateId, locale, payload), baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new PdfRenderingException("Error while rendering pdf", e);
        }
    }
}
