package com.example.duan1.presenter;

import com.example.duan1.inteface.MHChao_Interface;

public class MHChao_Presenter {
    private MHChao_Interface MHChao_Interface;

    public MHChao_Presenter(MHChao_Interface MHChao_Interface) {
        this.MHChao_Interface = MHChao_Interface;
    }

    public void nextScreen() {
        MHChao_Interface.nextScreen();
    }
}
