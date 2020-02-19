package challenges.flow;

import flow.*;

public class EmailAdapter implements IAdapter<IAction>, IEvent<String> {
    private String valueEmail;

    public EmailAdapter() {
        this.valueEmail = "";
    }

    public EmailAdapter(String valueEmail) {
        this.valueEmail = valueEmail;
    }

    @Override
    public IEvent adapt(IAction iAction) throws AdapterException, ActionException {
        String value = (String) iAction.execute();
        return new EmailAdapter(value);
    }

    @Override
    public String trigger() throws EventException, ActionException {
        return "MSG:" + valueEmail;
    }
}
