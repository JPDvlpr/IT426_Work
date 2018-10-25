package controller;

import model.DBNotes;
import model.INotesData;

public class NoteAppController {

    private INotesData model;

    public NoteAppController() {

        model = new DBNotes();
    }

    public boolean handleNewQuote(String quote, String author) {
        if (isEmpty(quote) || author == null) {
            return false;
        }

        model.addQuote(quote, author);
        return true;
    }

    private boolean isEmpty(String value) {
        return value == null || value.equals("");
    }
}
