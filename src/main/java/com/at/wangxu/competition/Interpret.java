package com.at.wangxu.competition;

/**
 * 5617. 设计 Goal 解析器
 */
public class Interpret {
    public String interpret(String command) {
        StringBuilder stringBuilder = new StringBuilder();
        while (command.length() > 0 ) {
            if (command.indexOf("G") == 0) {
                stringBuilder.append("G");
                command = command.substring(1);
            }else if (command.indexOf("()") == 0) {
                stringBuilder.append("o");
                command = command.substring(2);
            }else {
                stringBuilder.append("al");
                command = command.substring(4);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Interpret interpret = new Interpret();
        System.out.println(interpret.interpret("G()(al)"));
        System.out.println(interpret.interpret("G()()()()(al)"));
        System.out.println(interpret.interpret("(al)G(al)()()G"));
    }
}
