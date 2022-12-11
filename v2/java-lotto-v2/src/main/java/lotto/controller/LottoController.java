package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.ProduceLottoService;
import lotto.service.SeedDataSourceService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final SeedDataSourceService seedDataSourceService;
    private final ProduceLottoService produceLottoService;
    private final InputView inputView;
    private final OutputView outputView;


    public LottoController() {
        this.seedDataSourceService = new SeedDataSourceService();
        this.produceLottoService = new ProduceLottoService();
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
}
