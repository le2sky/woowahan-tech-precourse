package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.repository.LottoMachineRepository;
import lotto.repository.UserRepository;

import java.util.List;

public class ProduceLottoService {

    public List<Lotto> produce(Money money) {
        User user = UserRepository.find();
        LottoMachine lottoMachine = LottoMachineRepository.find();
        user.chargeMoney(money);
        user.buy(lottoMachine);

        return user.showLottos();
    }


}
