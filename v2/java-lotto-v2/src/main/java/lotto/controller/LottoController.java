package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoHistory;
import lotto.domain.Money;
import lotto.domain.Revenue;
import lotto.service.DisplayResultService;
import lotto.service.DrawLottoService;
import lotto.service.ProduceLottoService;
import lotto.service.SeedDataSourceService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final SeedDataSourceService seedDataSourceService;
    private final ProduceLottoService produceLottoService;
    private final DrawLottoService drawLottoService;
    private final DisplayResultService displayResultService;

    private final InputView inputView;
    private final OutputView outputView;


    public LottoController() {
        this.seedDataSourceService = new SeedDataSourceService();
        this.produceLottoService = new ProduceLottoService();
        this.drawLottoService = new DrawLottoService();
        this.displayResultService = new DisplayResultService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        seedDataSourceService.seeding();
    }

    public void produceLotto() {
        String read = inputView.readInvestment();
        Money money = new Money(Integer.parseInt(read));
        List<Lotto> result = produceLottoService.produce(money);
        outputView.printProducedLotto(result);
    }

    public void drawLotto() {
        String readAnswer = inputView.readAnswer();
        List<Integer> answer = Arrays.stream(readAnswer.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int bonus = Integer.parseInt(inputView.readBonus());

        drawLottoService.decideAnswer(answer, bonus);
        drawLottoService.draw();
    }

    public void showResult() {
        List<LottoHistory> lottoHistories = displayResultService.showHistories();
        Revenue revenue = displayResultService.calculateRevenue();

        outputView.printHistories(lottoHistories);
        outputView.printRevenue(revenue);
    }

}
