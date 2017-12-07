package org.fenixedu.bennu.papyrus.domain;

import java.util.Locale;
import java.util.Optional;

import org.fenixedu.bennu.core.domain.Bennu;
import org.fenixedu.commons.i18n.LocalizedString;

import com.google.gson.Gson;

import pt.ist.papyrus.PapyrusSettings;

public class PapyrusTemplate extends PapyrusTemplate_Base {

    protected PapyrusTemplate() {
        super();
    }

    protected void init(String name, LocalizedString displayName, String templateHtml, Locale locale,
                           SignatureFieldSettings signatureFieldSettings, PapyrusSettings printSettings) {
        setBennuPapyrusTemplates(Bennu.getInstance());
        setName(name);
        setDisplayName(displayName);
        setTemplateHtml(templateHtml);
        setLocale(locale);
        setSignatureFieldsSettings(signatureFieldSettings);
        setPrintSettings(printSettings);
    }

    public PapyrusTemplate(String name, LocalizedString displayName, String templateHtml, Locale locale,
                              SignatureFieldSettings signatureFieldSettings, PapyrusSettings printSettings) {
        init(name, displayName, templateHtml, locale, signatureFieldSettings, printSettings);
    }

    public void setSignatureFieldsSettings(SignatureFieldSettings settings) {
        setSignatureFieldSettingsElement(new Gson().toJsonTree(settings));
    }

    public SignatureFieldSettings getSignatureFieldsSettings() {
        return new Gson().fromJson(getSignatureFieldSettingsElement(), SignatureFieldSettings.class);
    }

    public void setPrintSettings(PapyrusSettings settings) {
        setPrintSettingsElement(new Gson().toJsonTree(settings));
    }

    public PapyrusSettings getPrintSettings() {
        return new Gson().fromJson(getPrintSettingsElement(), PapyrusSettings.class);
    }

    protected void disconnect() {
        setBennuPapyrusTemplates(null);
    }

    public void delete() {
        disconnect();
        super.deleteDomainObject();
    }

    public static Optional<? extends PapyrusTemplate> findByNameAndLocale(String name, Locale locale) {
        return Bennu.getInstance().getPapyrusTemplateSet().stream()
                   .filter(template -> template.getName().equals(name) && template.getLocale().equals(locale)).findAny();
    }

}
