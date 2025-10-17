package org.fenixedu.bennu.papyrus.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */

@Service
public class ITextQRCodeGenerator implements QRCodeGenerator {

    @Override
    public byte[] generate(String identifier, int width, int height) throws QRCodeGenerationException {
        try {
            return org.fenixedu.commons.pdf.ITextQRCodeGenerator.generate(identifier, width, height);
        } catch (IOException e) {
            throw new QRCodeGenerationException("Error while generating QR code for identifier " + identifier, e);
        }
    }

}
