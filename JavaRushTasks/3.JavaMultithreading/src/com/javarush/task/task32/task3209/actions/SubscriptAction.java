package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

// Отвечает за стиль текста "Подстрочный знак".
public class SubscriptAction extends StyledEditorKit.StyledTextAction {
    public SubscriptAction() {
        super("Подстрочный знак");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
