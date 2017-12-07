package org.fenixedu.bennu.papyrus.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import pt.ist.papyrus.PapyrusClient;
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
    public InputStream render(InputStream template, JsonObject payload) {
        return render(template, payload, defaultSettings);
    }

    public InputStream render(InputStream template, JsonObject payload, PapyrusSettings settings) {
        return papyrusClient.liveRender(template, payload, settings);
    }
}
