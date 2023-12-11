package example.tests;

import example.note.NoteLogic;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * тесты на класс NoteLogic
 */
public class Test1 extends TestCase {

    @Test
    public void testAddCommand() {
        NoteLogic noteLogic = new NoteLogic();
        String response = noteLogic.handleMessage("/add Test Note");
        Assert.assertEquals("Note added!", response);
        Assert.assertEquals("Your notes:\n" +
                        "1. Test Note",
                noteLogic.handleMessage("/notes"));
    }

    @Test
    public void testHandleMessageNotesCommand() {
        NoteLogic noteLogic = new NoteLogic();
        noteLogic.handleMessage("/add Test Note");
        Assert.assertEquals("Your notes:\n" +
                        "1. Test Note",
                noteLogic.handleMessage("/notes"));

    }

    @Test
    public void testHandleMessageEditCommand() {
        NoteLogic noteLogic = new NoteLogic();
        noteLogic.handleMessage("/add Test Note");
        String response = noteLogic.handleMessage("/edit 1 New Text");
        Assert.assertEquals("Note edited!", response);
        Assert.assertEquals("Your notes:\n" +
                        "1. New Text",
                noteLogic.handleMessage("/notes"));
    }

    @Test
    public void testHandleMessageDeleteCommand() {
        NoteLogic noteLogic = new NoteLogic();
        noteLogic.handleMessage("/add Delete Note");
        noteLogic.handleMessage("/del Delete note");
        Assert.assertEquals("Your notes:\n", noteLogic.handleMessage("/notes"));
    }

}
