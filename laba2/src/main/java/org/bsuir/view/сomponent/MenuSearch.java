package org.bsuir.view.сomponent;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class MenuSearch extends Pane {
    private final int WIDTH, HEIGHT;

    public MenuSearch(Pane card, int width, int height){
        WIDTH = width;
        HEIGHT = height;
        card.setMinSize(width, height);
        this.getChildren().add(card);
    }

    public void setCard(Pane newCard){
        this.getChildren().clear();
        newCard.setMinSize(WIDTH, HEIGHT);
        this.getChildren().add(newCard);
    }

    public Node getCard(){
        return this.getChildren().get(0);
    }
}
