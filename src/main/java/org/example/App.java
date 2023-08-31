package org.example;


import org.example.app.model.User;
import org.example.app.service.UserService;
import org.example.dao.Helper.PrintHelper;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();

        PrintHelper.printClassList(userService.findAll());


    }


}
