
package com.yusufeker.javaMailApp;

public class UndoRedo_Edit {

    mailApp app;

    public UndoRedo_Edit(mailApp app) {
        this.app = app;
    }

    public void undo() {
        app.undoManager.undo();
    }

    public void redo() {
        app.undoManager.redo();
    }

}
