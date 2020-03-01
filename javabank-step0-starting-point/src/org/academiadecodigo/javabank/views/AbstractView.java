package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstractView implements View {

    protected Prompt prompt;
    protected Bank bank;

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
