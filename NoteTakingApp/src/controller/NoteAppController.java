package controller;

import model.DBNotes;
import model.INotesData;

public class NoteAppController {

    private INotesData model;
    private String[] noteData;

    public NoteAppController() {

        model = new DBNotes();
    }

    public boolean handleNewNote(String type, String body, String other) {
        switch (type){
            case "quote":
                if (isEmpty(body) || isEmpty(other)) {
                    return false;
                }
                model.addQuote(body, other);
                return true;
        }
        return false;
    }

    private boolean isEmpty(String value) {
        return value == null || value.equals("");
    }
}
