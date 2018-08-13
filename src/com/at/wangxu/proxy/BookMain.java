package com.at.wangxu.proxy;

public class BookMain {
    public static void main(String[] args){
        BookFacadeImpl bookFacadeImpl=new BookFacadeImpl();
        BookFacadeProxy bookFacadeProxy=new BookFacadeProxy();
        BookFacade bookFacade= (BookFacade) bookFacadeProxy.bind(bookFacadeImpl);
        bookFacade.addBook();
    }
}
