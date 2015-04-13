package com.ankamagames.wakfu.client.ui.dialog;

import java.util.*;
import com.ankamagames.xulor2.property.*;
import com.ankamagames.xulor2.core.renderer.condition.*;
import com.ankamagames.xulor2.util.alignment.*;
import com.ankamagames.xulor2.util.*;
import com.ankamagames.xulor2.layout.*;
import com.ankamagames.xulor2.core.*;
import com.ankamagames.xulor2.event.listener.*;
import com.ankamagames.xulor2.decorator.*;
import com.ankamagames.xulor2.component.*;
import com.ankamagames.xulor2.appearance.*;

public class MinimapDialog implements BasicElementFactory
{
    private Stack<ElementMap> elementMaps;
    private Environment env;
    
    public MinimapDialog() {
        super();
        this.elementMaps = new Stack<ElementMap>();
    }
    
    @Override
    public BasicElement getElement(final Environment env, final ElementMap item) {
        this.env = env;
        this.elementMaps.push(item);
        final ElementMap elementMap = this.elementMaps.peek();
        final String id = "window";
        final Window element = new Window();
        element.onCheckOut();
        element.setElementMap(elementMap);
        if (elementMap != null && id != null) {
            elementMap.add(id, element);
        }
        element.setNonBlocking(true);
        element.setPack(true);
        element.onAttributesInitialized();
        final PropertyElement checkOut = PropertyElement.checkOut();
        checkOut.setElementMap(elementMap);
        checkOut.setAttribute("visible");
        checkOut.setName("miniMap");
        checkOut.setField("isMapAvailable");
        element.addBasicElement(checkOut);
        checkOut.onAttributesInitialized();
        final ConditionResult element2 = new ConditionResult();
        element2.onCheckOut();
        element2.setElementMap(elementMap);
        checkOut.addBasicElement(element2);
        element2.onAttributesInitialized();
        final AndCondition element3 = new AndCondition();
        element3.onCheckOut();
        element3.setElementMap(elementMap);
        element2.addBasicElement(element3);
        element3.onAttributesInitialized();
        final TrueCondition element4 = new TrueCondition();
        element4.onCheckOut();
        element4.setElementMap(elementMap);
        element3.addBasicElement(element4);
        element4.onAttributesInitialized();
        element4.onChildrenAdded();
        final TrueCondition element5 = new TrueCondition();
        element5.onCheckOut();
        element5.setElementMap(elementMap);
        element3.addBasicElement(element5);
        element5.onAttributesInitialized();
        final PropertyElement checkOut2 = PropertyElement.checkOut();
        checkOut2.setElementMap(elementMap);
        checkOut2.setName("gamePreferences");
        checkOut2.setField("minimapEnable");
        checkOut2.setAttribute("comparedValue");
        element5.addBasicElement(checkOut2);
        checkOut2.onAttributesInitialized();
        checkOut2.onChildrenAdded();
        element5.onChildrenAdded();
        final FalseCondition element6 = new FalseCondition();
        element6.onCheckOut();
        element6.setElementMap(elementMap);
        element3.addBasicElement(element6);
        element6.onAttributesInitialized();
        final PropertyElement checkOut3 = PropertyElement.checkOut();
        checkOut3.setElementMap(elementMap);
        checkOut3.setName("isInFight");
        checkOut3.setAttribute("comparedValue");
        element6.addBasicElement(checkOut3);
        checkOut3.onAttributesInitialized();
        checkOut3.onChildrenAdded();
        element6.onChildrenAdded();
        element3.onChildrenAdded();
        element2.onChildrenAdded();
        checkOut.onChildrenAdded();
        final DecoratorAppearance appearance = element.getAppearance();
        appearance.setElementMap(elementMap);
        appearance.setShape(WidgetShape.RECTANGLE);
        element.addBasicElement(appearance);
        appearance.onAttributesInitialized();
        appearance.onChildrenAdded();
        final StaticLayoutData element7 = new StaticLayoutData();
        element7.onCheckOut();
        element7.setElementMap(elementMap);
        element7.setAlign(Alignment17.NORTH_EAST);
        element7.setXOffset(-10);
        element7.setYOffset(-85);
        element7.setSize(new Dimension(-2, -2));
        element7.setInitValue(true);
        element.addBasicElement(element7);
        element7.onAttributesInitialized();
        element7.onChildrenAdded();
        final StaticLayout element8 = new StaticLayout();
        element8.onCheckOut();
        element8.setAdaptToContentSize(true);
        element.addBasicElement(element8);
        element8.onAttributesInitialized();
        element8.onChildrenAdded();
        final Container checkOut4 = Container.checkOut();
        checkOut4.setElementMap(elementMap);
        checkOut4.setNeedsScissor(true);
        element.addBasicElement(checkOut4);
        checkOut4.onAttributesInitialized();
        final StaticLayoutData element9 = new StaticLayoutData();
        element9.onCheckOut();
        element9.setElementMap(elementMap);
        element9.setSize(new Dimension(130, 130));
        element9.setX(13);
        element9.setY(10);
        checkOut4.addBasicElement(element9);
        element9.onAttributesInitialized();
        element9.onChildrenAdded();
        final String id2 = "navigator";
        final MapNavigator mapNavigator = new MapNavigator();
        mapNavigator.onCheckOut();
        mapNavigator.setElementMap(elementMap);
        if (elementMap != null && id2 != null) {
            elementMap.add(id2, mapNavigator);
        }
        mapNavigator.setNeedsScissor(true);
        mapNavigator.setEnableTooltip(false);
        mapNavigator.setLandMarkZoom(0.75f);
        mapNavigator.setMaxZoom(0.065f);
        mapNavigator.setMinZoom(0.065f);
        mapNavigator.setIsoMap(true);
        mapNavigator.setCursorType(CursorFactory.CursorType.DEFAULT);
        final ItemOverListener onItemOver = new ItemOverListener();
        onItemOver.setCallBackFunc("wakfu.controlCenter:onMiniMapItemOver");
        mapNavigator.setOnItemOver(onItemOver);
        final ItemOutListener onItemOut = new ItemOutListener();
        onItemOut.setCallBackFunc("wakfu.controlCenter:onMiniMapItemOut");
        mapNavigator.setOnItemOut(onItemOut);
        checkOut4.addBasicElement(mapNavigator);
        mapNavigator.onAttributesInitialized();
        final DecoratorAppearance appearance2 = mapNavigator.getAppearance();
        appearance2.setElementMap(elementMap);
        mapNavigator.addBasicElement(appearance2);
        appearance2.onAttributesInitialized();
        final PlainBackground element10 = new PlainBackground();
        element10.onCheckOut();
        element10.setElementMap(elementMap);
        appearance2.addBasicElement(element10);
        element10.onAttributesInitialized();
        final PropertyElement checkOut5 = PropertyElement.checkOut();
        checkOut5.setElementMap(elementMap);
        checkOut5.setAttribute("color");
        checkOut5.setName("miniMap");
        checkOut5.setField("bgColor");
        element10.addBasicElement(checkOut5);
        checkOut5.onAttributesInitialized();
        checkOut5.onChildrenAdded();
        element10.onChildrenAdded();
        appearance2.onChildrenAdded();
        final PropertyElement checkOut6 = PropertyElement.checkOut();
        checkOut6.setElementMap(elementMap);
        checkOut6.setAttribute("mapPath");
        checkOut6.setName("miniMap");
        checkOut6.setField("map");
        mapNavigator.addBasicElement(checkOut6);
        checkOut6.onAttributesInitialized();
        checkOut6.onChildrenAdded();
        final PropertyElement checkOut7 = PropertyElement.checkOut();
        checkOut7.setElementMap(elementMap);
        checkOut7.setAttribute("content");
        checkOut7.setName("map");
        checkOut7.setField("landmarks/points");
        mapNavigator.addBasicElement(checkOut7);
        checkOut7.onAttributesInitialized();
        checkOut7.onChildrenAdded();
        final PropertyElement checkOut8 = PropertyElement.checkOut();
        checkOut8.setElementMap(elementMap);
        checkOut8.setAttribute("compassContent");
        checkOut8.setName("map");
        checkOut8.setField("landmarks/compass");
        mapNavigator.addBasicElement(checkOut8);
        checkOut8.onAttributesInitialized();
        checkOut8.onChildrenAdded();
        final PropertyElement checkOut9 = PropertyElement.checkOut();
        checkOut9.setElementMap(elementMap);
        checkOut9.setAttribute("isoCenterX");
        checkOut9.setName("miniMap");
        checkOut9.setField("centerX");
        mapNavigator.addBasicElement(checkOut9);
        checkOut9.onAttributesInitialized();
        checkOut9.onChildrenAdded();
        final PropertyElement checkOut10 = PropertyElement.checkOut();
        checkOut10.setElementMap(elementMap);
        checkOut10.setAttribute("isoCenterY");
        checkOut10.setName("miniMap");
        checkOut10.setField("centerY");
        mapNavigator.addBasicElement(checkOut10);
        checkOut10.onAttributesInitialized();
        checkOut10.onChildrenAdded();
        final PropertyElement checkOut11 = PropertyElement.checkOut();
        checkOut11.setElementMap(elementMap);
        checkOut11.setAttribute("isoCenterZ");
        checkOut11.setName("miniMap");
        checkOut11.setField("centerZ");
        mapNavigator.addBasicElement(checkOut11);
        checkOut11.onAttributesInitialized();
        checkOut11.onChildrenAdded();
        final PropertyElement checkOut12 = PropertyElement.checkOut();
        checkOut12.setElementMap(elementMap);
        checkOut12.setAttribute("mapId");
        checkOut12.setName("miniMap");
        checkOut12.setField("mapId");
        mapNavigator.addBasicElement(checkOut12);
        checkOut12.onAttributesInitialized();
        checkOut12.onChildrenAdded();
        mapNavigator.onChildrenAdded();
        checkOut4.onChildrenAdded();
        final Container checkOut13 = Container.checkOut();
        checkOut13.setElementMap(elementMap);
        checkOut13.setStyle("minimapShadow");
        element.addBasicElement(checkOut13);
        checkOut13.onAttributesInitialized();
        final StaticLayoutData element11 = new StaticLayoutData();
        element11.onCheckOut();
        element11.setElementMap(elementMap);
        element11.setSize(new Dimension(130, 130));
        element11.setX(13);
        element11.setY(10);
        checkOut13.addBasicElement(element11);
        element11.onAttributesInitialized();
        element11.onChildrenAdded();
        checkOut13.onChildrenAdded();
        final String id3 = "background";
        final Container checkOut14 = Container.checkOut();
        checkOut14.setElementMap(elementMap);
        if (elementMap != null && id3 != null) {
            elementMap.add(id3, checkOut14);
        }
        checkOut14.setStyle("minimapDecorator");
        element.addBasicElement(checkOut14);
        checkOut14.onAttributesInitialized();
        final StaticLayoutData element12 = new StaticLayoutData();
        element12.onCheckOut();
        element12.setElementMap(elementMap);
        element12.setSize(new Dimension(150, 150));
        checkOut14.addBasicElement(element12);
        element12.onAttributesInitialized();
        element12.onChildrenAdded();
        checkOut14.onChildrenAdded();
        final WindowMovePoint element13 = new WindowMovePoint();
        element13.onCheckOut();
        element13.setElementMap(elementMap);
        element.addBasicElement(element13);
        element13.onAttributesInitialized();
        final DecoratorAppearance appearance3 = element13.getAppearance();
        appearance3.setElementMap(elementMap);
        appearance3.setShape(WidgetShape.RECTANGLE);
        element13.addBasicElement(appearance3);
        appearance3.onAttributesInitialized();
        appearance3.onChildrenAdded();
        final StaticLayoutData element14 = new StaticLayoutData();
        element14.onCheckOut();
        element14.setElementMap(elementMap);
        element14.setAlign(Alignment17.SOUTH);
        element14.setSize(new Dimension(150, 15));
        element14.setYOffset(5);
        element13.addBasicElement(element14);
        element14.onAttributesInitialized();
        element14.onChildrenAdded();
        element13.onChildrenAdded();
        final WindowMovePoint element15 = new WindowMovePoint();
        element15.onCheckOut();
        element15.setElementMap(elementMap);
        element.addBasicElement(element15);
        element15.onAttributesInitialized();
        final DecoratorAppearance appearance4 = element15.getAppearance();
        appearance4.setElementMap(elementMap);
        appearance4.setShape(WidgetShape.RECTANGLE);
        element15.addBasicElement(appearance4);
        appearance4.onAttributesInitialized();
        appearance4.onChildrenAdded();
        final StaticLayoutData element16 = new StaticLayoutData();
        element16.onCheckOut();
        element16.setElementMap(elementMap);
        element16.setAlign(Alignment17.NORTH);
        element16.setSize(new Dimension(150, 15));
        element16.setYOffset(-5);
        element15.addBasicElement(element16);
        element16.onAttributesInitialized();
        element16.onChildrenAdded();
        final StaticLayout element17 = new StaticLayout();
        element17.onCheckOut();
        element15.addBasicElement(element17);
        element17.onAttributesInitialized();
        element17.onChildrenAdded();
        element15.onChildrenAdded();
        final WindowMovePoint element18 = new WindowMovePoint();
        element18.onCheckOut();
        element18.setElementMap(elementMap);
        element.addBasicElement(element18);
        element18.onAttributesInitialized();
        final DecoratorAppearance appearance5 = element18.getAppearance();
        appearance5.setElementMap(elementMap);
        appearance5.setShape(WidgetShape.RECTANGLE);
        element18.addBasicElement(appearance5);
        appearance5.onAttributesInitialized();
        appearance5.onChildrenAdded();
        final StaticLayoutData element19 = new StaticLayoutData();
        element19.onCheckOut();
        element19.setElementMap(elementMap);
        element19.setAlign(Alignment17.EAST);
        element19.setSize(new Dimension(15, 150));
        element19.setXOffset(-5);
        element18.addBasicElement(element19);
        element19.onAttributesInitialized();
        element19.onChildrenAdded();
        final StaticLayout element20 = new StaticLayout();
        element20.onCheckOut();
        element18.addBasicElement(element20);
        element20.onAttributesInitialized();
        element20.onChildrenAdded();
        element18.onChildrenAdded();
        final WindowMovePoint element21 = new WindowMovePoint();
        element21.onCheckOut();
        element21.setElementMap(elementMap);
        element.addBasicElement(element21);
        element21.onAttributesInitialized();
        final DecoratorAppearance appearance6 = element21.getAppearance();
        appearance6.setElementMap(elementMap);
        appearance6.setShape(WidgetShape.RECTANGLE);
        element21.addBasicElement(appearance6);
        appearance6.onAttributesInitialized();
        appearance6.onChildrenAdded();
        final StaticLayoutData element22 = new StaticLayoutData();
        element22.onCheckOut();
        element22.setElementMap(elementMap);
        element22.setAlign(Alignment17.WEST);
        element22.setSize(new Dimension(15, 150));
        element22.setXOffset(5);
        element21.addBasicElement(element22);
        element22.onAttributesInitialized();
        element22.onChildrenAdded();
        final StaticLayout element23 = new StaticLayout();
        element23.onCheckOut();
        element21.addBasicElement(element23);
        element23.onAttributesInitialized();
        element23.onChildrenAdded();
        element21.onChildrenAdded();
        element.onChildrenAdded();
        return element;
    }
}