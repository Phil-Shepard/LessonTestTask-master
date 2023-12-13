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
        botLogic.processCommand(user, Constants.COMMAND_TEST);
        assertEquals(State.TEST, user.getState());
        assertEquals("Вычислите степень: 10^2", fakeBot.getMessages().get(0));
    }

    /**
     * Тест на команду notify
     */
    @Test
    public void testNotify() throws InterruptedException {
        FakeBot fakeBot  = new FakeBot();
        BotLogic botLogic = new BotLogic(fakeBot);
        User user = new User(1L);
        user.setState(State.SET_NOTIFY_TEXT);
        botLogic.processCommand(user, "Первое напоминание");
        assertNotNull(user.getNotification());
        user.setState(State.SET_NOTIFY_DELAY);
        botLogic.processCommand(user, "1");
        Thread.sleep(2000);
        assertEquals("Сработало напоминание: 'Первое напоминание'", fakeBot.getMessages().get(2));
    }

    /**
     * Тест на команду repeat
     */
    @Test
    public void testRepeat() {
        FakeBot fakeBot = new FakeBot();
        BotLogic botLogic = new BotLogic(fakeBot);
        User user = new User(1L);
        user.setState(State.REPEAT);
        botLogic.processCommand(user, Constants.COMMAND_REPEAT);
        assertEquals(State.REPEAT, user.getState());
        assertEquals("Нет вопросов для повторения", fakeBot.getMessages().get(0));
    }
}
