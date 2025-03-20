package com.vaadin.testbenchexample;


import com.vaadin.flow.component.listbox.testbench.ListBoxElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element("vaadin-select-overlay")
public class VaadinSelectOverlayView extends TestBenchElement {

    protected ListBoxElement gender() {
        return $(ListBoxElement.class).first();
    }


}