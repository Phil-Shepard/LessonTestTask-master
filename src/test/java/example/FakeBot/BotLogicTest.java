package example.FakeBot;

import example.bot.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


/**
 * Класс тестов, проверяющих логику BotLogic
 */
public class BotLogicTest extends TestCase {

    /**
     * Тест на команду /test
     */
    @Test
    public void testProcessCommandTest() {
        FakeBot fakeBot = new FakeBot();
        BotLogic botLogic = new BotLogic(fakeBot);
        User user = new User(1L);
        botLogic.processCommand(user, "/test");
        assertEquals(State.TEST, user.getState());

        assertEquals("Вычислите степень: 10^2", fakeBot.getMessages().get(0));
    }

    /**
     * Тест на команду notify
     */
    @Test
    public void testNotify() {
        FakeBot fakeBot = new FakeBot();
        BotLogic botLogic = new BotLogic(fakeBot);
        User user = new User(1L);
        botLogic.processCommand(user, "/notify");
        Assert.assertEquals("Введите текст напоминания", fakeBot.getMessages().get(0));
    }

    /**
     * Тест на команду repeat
     */
    @Test
    public void testRepeat() {
        FakeBot fakeBot = new FakeBot();
        BotLogic botLogic = new BotLogic(fakeBot);
        User user = new User(1L);
        botLogic.processCommand(user, "/repeat");
        Assert.assertEquals("Нет вопросов для повторения", fakeBot.getMessages().get(0));
    }
}
