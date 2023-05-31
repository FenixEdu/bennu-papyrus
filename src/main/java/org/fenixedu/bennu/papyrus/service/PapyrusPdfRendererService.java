package org.fenixedu.bennu.papyrus.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ist.papyrus.PapyrusClient;
import pt.ist.papyrus.PapyrusClientException;
import pt.ist.papyrus.PapyrusSettings;

import java.io.InputStream;
import java.util.Locale;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */

@Service
public class PapyrusPdfRendererService implements PdfRendererService {

    private final PapyrusClient papyrusClient;
    private final PapyrusSettings defaultSettings;

    @Autowired
    public PapyrusPdfRendererService(PapyrusClient papyrusClient, PapyrusSettings defaultSettings) {
        this.papyrusClient = papyrusClient;
        this.defaultSettings = defaultSettings;
    }

    @Override
    public InputStream render(String teamId, InputStream template, JsonObject payload) throws PapyrusClientException {
        return render(teamId, template, payload, defaultSettings);
    }

    @Override
    public InputStream render(
            String teamId, InputStream template, JsonObject payload, PapyrusSettings settings
    ) throws PapyrusClientException {
        return papyrusClient.liveRender(teamId, template, payload, settings);
    }

    @Override
    public InputStream render(
            String teamId, String templateId, Locale locale, JsonObject payload
    ) throws PapyrusClientException {
        return papyrusClient.render(teamId, templateId, locale, payload);
    }

    public JsonArray list(String teamId) throws PapyrusClientException {
        return papyrusClient.list(teamId);
    }

    public JsonObject view(String teamId, String templateId) throws PapyrusClientException {
        return papyrusClient.view(teamId, templateId);
    }

}
