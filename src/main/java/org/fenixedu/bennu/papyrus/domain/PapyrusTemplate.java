package org.fenixedu.bennu.papyrus.domain;

import com.google.gson.Gson;
import org.fenixedu.bennu.core.domain.Bennu;
import org.fenixedu.commons.i18n.LocalizedString;
import pt.ist.papyrus.PapyrusSettings;

import java.util.Locale;
import java.util.Optional;

public class PapyrusTemplate extends PapyrusTemplate_Base {

    protected PapyrusTemplate() {
        super();
    }

    public PapyrusTemplate(
            String teamId,
            String name,
            LocalizedString displayName,
            String templateHtml,
            Locale locale,
            SignatureFieldSettings signatureFieldSettings,
            PapyrusSettings printSettings
    ) {
        init(teamId, name, displayName, templateHtml, locale, signatureFieldSettings, printSettings);
    }

    public static Optional<? extends PapyrusTemplate> findByNameAndLocale(String name, Locale locale) {
        return Bennu.getInstance()
                .getPapyrusTemplateSet()
                .stream()
                .filter(template -> template.getName().equals(name) && template.getLocale()
                        .getLanguage()
                        .equals(locale.getLanguage()))
                .findAny();
    }

    protected void init(
            String teamId,
            String name,
            LocalizedString displayName,
            String templateHtml,
            Locale locale,
            SignatureFieldSettings signatureFieldSettings,
            PapyrusSettings printSettings
    ) {
        setBennuPapyrusTemplates(Bennu.getInstance());
        setTeamId(teamId);
        setName(name);
        setDisplayName(displayName);
        setTemplateHtml(templateHtml);
        setLocale(locale);
        setSignatureFieldsSettings(signatureFieldSettings);
        setPrintSettings(printSettings);
    }

    public SignatureFieldSettings getSignatureFieldsSettings() {
        return new Gson().fromJson(getSignatureFieldSettingsElement(), SignatureFieldSettings.class);
    }

    public void setSignatureFieldsSettings(SignatureFieldSettings settings) {
        setSignatureFieldSettingsElement(new Gson().toJsonTree(settings));
    }

    public PapyrusSettings getPrintSettings() {
        return new Gson().fromJson(getPrintSettingsElement(), PapyrusSettings.class);
    }

    public void setPrintSettings(PapyrusSettings settings) {
        setPrintSettingsElement(new Gson().toJsonTree(settings));
    }

    protected void disconnect() {
        setBennuPapyrusTemplates(null);
    }

    public void delete() {
        disconnect();
        super.deleteDomainObject();
    }

}
