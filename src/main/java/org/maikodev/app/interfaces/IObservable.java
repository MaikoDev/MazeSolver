package org.maikodev.app.interfaces;

import java.awt.event.ActionListener;

public interface IObservable {
    void addActionListener(ActionListener listener);
    void removeActionListener(ActionListener listener);
    ActionListener[] getActionListeners();
}
