package org.fenixedu.bennu.papyrus.domain;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
public class SignatureFieldSettings {
    private final int llx;
    private final int lly;
    private final int width;
    private final int height;
    private final String name;
    private final int page;

    public SignatureFieldSettings(int llx, int lly, int width, int height, String name, int page) {
        this.llx = llx;
        this.lly = lly;
        this.width = width;
        this.height = height;
        this.name = name;
        this.page = page;
    }

    public int getLlx() {
        return llx;
    }

    public int getLly() {
        return lly;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }
}
