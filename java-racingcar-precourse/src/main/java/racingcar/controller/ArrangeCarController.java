package racingcar.controller;

import racingcar.service.ArrangeCarService;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrangeCarController {

    private final ArrangeCarService arrangeCarService;
    private final InputView inputView;

    public ArrangeCarController() {
        this.arrangeCarService = new ArrangeCarService();
        this.inputView = new InputView();
    }


    public void arrange() {
        String names = inputView.readCarNames();
        arrangeCarService.arrange(Arrays.stream(names.split(",")).collect(Collectors.toList()));
    }
}
