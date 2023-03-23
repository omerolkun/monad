package com.example.application.views.personel;


import com.example.application.data.entity.Personel;
import com.example.application.data.service.PersonelService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;

import java.awt.*;

@Route(value = "personels")
@PageTitle("Personel Table")
public class PersonelView extends VerticalLayout {
    Grid <Personel> grid = new Grid<>(Personel.class) ;
    TextField filterText = new TextField();
    PersonelService personelService;


    public PersonelView(PersonelService personelService){
        this.personelService = personelService;
        addClassName("personel-view");
        setSizeFull();
        configureGrid();
        getToolBar();

        add(getToolBar(), grid);
        add(getContent());
        updateList();

    }

    private Component getContent(){
        HorizontalLayout content = new HorizontalLayout(grid);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }
    private void configureGrid(){
        grid.addClassNames("personel-grid");
        grid.setSizeFull();
        grid.setColumns("TCKNO", "ad", "soyad");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolBar(){
        filterText.setPlaceholder("filter by name");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e-> updateList());

        HorizontalLayout toolbar = new HorizontalLayout(filterText);
        toolbar.addClassName("toolbar");
        return toolbar;
    }


    private void updateList(){
        grid.setItems(personelService.getAllPersonels(filterText.getValue()));
        System.out.println("-------------\n");
        System.out.println(personelService.getAllPersonels(filterText.getValue()));
        System.out.println("-------------\n");

    }



}
