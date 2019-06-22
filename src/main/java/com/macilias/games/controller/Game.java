package com.macilias.games.controller;

import com.macilias.games.model.Choice;

public interface Game {

    int choose(Choice c);

    String getScore();
}
