package com.sun.tools.xjc.model;

import java.util.Collections;
import java.util.List;

import javax.activation.MimeType;

import com.sun.xml.bind.v2.model.core.ID;
import com.sun.xml.xsom.XSComponent;

import org.xml.sax.Locator;

/**
 * @author Kohsuke Kawaguchi
 */
abstract class CSingleTypePropertyInfo extends CPropertyInfo {
    protected final TypeUse type;

    protected CSingleTypePropertyInfo(String name, TypeUse type, XSComponent source, CCustomizations customizations, Locator locator) {
        super(name, type.isCollection(), source, customizations, locator);
        this.type = type;
    }

    public final ID id() {
        return type.idUse();
    }

    public final MimeType getExpectedMimeType() {
        return type.getExpectedMimeType();
    }

    public final List<? extends CTypeInfo> ref() {
        return Collections.singletonList(getTarget());
    }

    public final CNonElement getTarget() {
        CNonElement r = (CNonElement)type.getInfo();
        assert r!=null;
        return r;
    }

    public final CAdapter getAdapter() {
        return type.getAdapterUse();
    }

    public final CSingleTypePropertyInfo getSource() {
        return this;
    }
}