package org.fenixedu.bennu.papyrus.service;

import java.io.InputStream;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
public interface PdfTemplateResolver {

    InputStream resolve(String templateName) throws UnresolvableTemplateException;
}
