package com.at.interview;

public class LoadSequence {
    public static void main(String[] args){
        parent parent=new child();
        parent parent2=new child();
    }
}
class child extends parent{
    static {
        System.out.println("child static code");
    }
    {
        System.out.println("child code block");
    }

    public child() {
        System.out.println("child construct");
    }

    @Override
    public String toString() {
        return "child{}";
    }
}
class parent{
    static {
        System.out.println("parent static code");
    }
    {
        System.out.println("parent code block");
    }

    public parent() {
        System.out.println("parent construct");
    }
}