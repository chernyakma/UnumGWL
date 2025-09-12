package com.vaadin.testbenchexample;

import com.vaadin.flow.component.combobox.testbench.ComboBoxElement;
import com.vaadin.flow.component.formlayout.testbench.FormLayoutElement;
import com.vaadin.flow.component.html.testbench.InputTextElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;


    @Element( "quick-search" )
public class QuickSearchView extends TestBenchElement {

        protected InputTextElement searchByPolicy() {
            return $( TestBenchElement.class ).id("content").$( ComboBoxElement.class ).first().$( TextFieldElement.class ).id( "input" ).$(InputTextElement.class).first();
        }
}

