package challenges.flow;

import flow.ActionException;
import flow.AgentException;
import flow.IAction;
import flow.IAgent;

import java.util.Arrays;
import java.util.List;

public class UserAgent implements IAgent, IAction<String> {
    private String messages;

    public UserAgent(){
        this.messages = "";
    }

    public UserAgent(String messages){
        this.messages = messages;
    }

    @Override
    public List<IAction> act() throws AgentException {
        List<IAction> lstUser = Arrays.asList((IAction) new UserAgent("hello"));
        return lstUser;
    }

    @Override
    public String execute() throws ActionException {
        return messages;
    }

    @Override
    public String getType() {
        return "EMAIL";
    }
}
