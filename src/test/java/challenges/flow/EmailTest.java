package challenges.flow;

import flow.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class EmailTest {
  private Engine engine;

  @Test
  public void testRun_AdapterIsCompliantWithProtocol_AppHasHelloMessage() throws Exception {
    IAgent user = new UserAgent();
    Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
    adapters.put("EMAIL", new EmailAdapter());

    EmailApp app = new EmailApp();
    Engine engine = new Engine(user, adapters, app);
    engine.run();
    Assert.assertEquals("hello", app.popMessage());
  }

  @Test(expected = EmptyFlowException.class)
  public void testRun_FlowIsEmpty_ThrowEmptyFlowException() throws Exception {
    engine = new Engine(mock(IAgent.class), mock(Map.class), mock(IApp.class));
    engine.run();
  }

  @Test(expected = AdapterNotFoundException.class)
  public void testRun_AdapterDoesNotExist_ThrowAdapterNotFoundException() throws Exception {
    IAgent user = new UserAgent();
    engine = new Engine(user, mock(Map.class), mock(IApp.class));
    engine.run();
  }
}
