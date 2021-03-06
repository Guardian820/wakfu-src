package com.ankamagames.wakfu.client.ui.theme;

import java.util.*;
import com.ankamagames.xulor2.component.*;
import com.ankamagames.xulor2.core.*;
import com.ankamagames.framework.graphics.image.*;
import com.ankamagames.xulor2.*;
import com.ankamagames.xulor2.appearance.*;

public class TextViewStyled14 implements StyleSetter
{
    private DocumentParser doc;
    private Stack<ElementMap> elementMaps;
    
    public TextViewStyled14() {
        super();
        this.elementMaps = new Stack<ElementMap>();
    }
    
    @Override
    public void applyStyle(final ElementMap item, final DocumentParser doc, final Widget widget) {
        this.doc = doc;
        this.elementMaps.push(item);
        final ElementMap elementMap = this.elementMaps.peek();
        final DecoratorAppearance appearance = widget.getAppearance();
        appearance.setElementMap(elementMap);
        widget.addBasicElement(appearance);
        appearance.onAttributesInitialized();
        final String id = "mecanicBlueColor";
        final ColorElement checkOut = ColorElement.checkOut();
        checkOut.setElementMap(elementMap);
        if (elementMap != null && id != null) {
            elementMap.add(id, checkOut);
        }
        checkOut.setColor(new Color(0.32f, 0.39f, 0.42f, 1.0f));
        appearance.addBasicElement(checkOut);
        checkOut.onAttributesInitialized();
        checkOut.onChildrenAdded();
        final FontElement checkOut2 = FontElement.checkOut();
        checkOut2.setRenderer(Xulor.getInstance().getDocumentParser().getFont("styledLightFont14"));
        checkOut2.setElementMap(elementMap);
        appearance.addBasicElement(checkOut2);
        checkOut2.onAttributesInitialized();
        checkOut2.onChildrenAdded();
        appearance.onChildrenAdded();
    }
}
