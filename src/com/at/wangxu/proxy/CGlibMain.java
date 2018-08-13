package com.at.wangxu.proxy;

public class CGlibMain {
    public static void main(String[] args){
        BookFacadeImplCGlib bookFacade=new BookFacadeImplCGlib();
        BookFacadeCglib cglib=new BookFacadeCglib();
        BookFacadeImplCGlib bookFacadeImplCGlib= (BookFacadeImplCGlib) cglib.getInstance(bookFacade);
        bookFacadeImplCGlib.addBook();
    }
}
