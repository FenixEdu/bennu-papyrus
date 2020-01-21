package org.fenixedu.bennu.papyrus.service;

import java.io.InputStream;
import java.util.Locale;

import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import pt.ist.papyrus.PapyrusClient;
import pt.ist.papyrus.PapyrusClientException;
import pt.ist.papyrus.PapyrusSettings;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */

@Service
public class PapyrusPdfRendererService implements PdfRendererService {

    private PapyrusClient papyrusClient;
    private PapyrusSettings defaultSettings;

    @Autowired
    public PapyrusPdfRendererService(PapyrusClient papyrusClient, PapyrusSettings defaultSettings) {
        this.papyrusClient = papyrusClient;
        this.defaultSettings = defaultSettings;
    }

    @Override
    public InputStream render(InputStream template, JsonObject payload) throws PapyrusClientException {
        return render(template, payload, defaultSettings);
    }

    @Override
    public InputStream render(InputStream template, JsonObject payload, PapyrusSettings settings) throws PapyrusClientException {
        return papyrusClient.liveRender(template, payload, settings);
    }

    @Override
    public InputStream render(String templateId, Locale locale, JsonObject payload) throws PapyrusClientException {
        return papyrusClient.render(templateId, locale, payload);
    }

    public JsonArray list() throws PapyrusClientException {
        return papyrusClient.list();
    }

    public JsonObject view(String templateId) throws PapyrusClientException {
        return papyrusClient.view(templateId);
    }

}
