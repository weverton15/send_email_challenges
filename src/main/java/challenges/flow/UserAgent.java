package challenges.flow;

import flow.ActionException;
import flow.AgentException;
import flow.IAction;
import flow.IAgent;

import java.util.ArrayList;
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
        List<IAction> lstUser = new ArrayList<IAction>();
        lstUser.add(new UserAgent("hello"));
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
