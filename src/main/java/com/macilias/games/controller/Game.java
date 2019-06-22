package com.macilias.games.controller;

import com.macilias.games.model.Choice;
import com.macilias.games.model.Varriant;

public interface Game {

    int choose(Choice c, Varriant v);

    String getScore();
}
