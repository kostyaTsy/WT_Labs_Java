package by.bsuir.task.server.command.impl;

import by.bsuir.task.server.model.Client;
import by.bsuir.task.server.command.Command;
import by.bsuir.task.server.command.exception.CommandException;
import by.bsuir.task.server.model.AuthType;
import by.bsuir.task.server.service.ServiceFactory;

import java.util.List;

public class ViewCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) == AuthType.UNAUTH)
            return "Should be authenticated";

        var clients = ServiceFactory.getInstance().getClientService().getAll();
        return toOutput(clients);
    }

    private static String toOutput(List<Client> clients) {
        var resultBuilder = new StringBuilder();
        resultBuilder.append("[\n");
        for (var _case : clients) {
            resultBuilder.append("\t").append(_case.toString()).append("\n");
        }
        resultBuilder.append("]");
        return resultBuilder.toString();
    }
}
