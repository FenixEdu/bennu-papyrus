package org.fenixedu.bennu.papyrus.service;

import com.itextpdf.barcodes.BarcodeQRCode;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */

@Service
public class ITextQRCodeGenerator implements QRCodeGenerator {

    @Override
    public byte[] generate(String identifier, int width, int height) throws QRCodeGenerationException {
        try (ByteArrayOutputStream bytes = new ByteArrayOutputStream()) {
            final BarcodeQRCode barcodeQRCode = new BarcodeQRCode(identifier);
            final Image image = barcodeQRCode.createAwtImage(Color.BLACK, Color.WHITE)
                    .getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage buffer = new BufferedImage(image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_RGB
            );
            buffer.getGraphics().drawImage(image, 0, 0, null);
            ImageIO.write(buffer, "png", bytes);
            return bytes.toByteArray();
        } catch (IOException e) {
            throw new QRCodeGenerationException("Error while generating qr code for identifier " + identifier, e);
        }
    }

}
