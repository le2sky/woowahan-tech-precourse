package lotto.service;

import lotto.domain.RaffleMachine;
import lotto.domain.User;
import lotto.repository.RaffleMachineRepository;
import lotto.repository.UserRepository;

import java.util.List;

public class DrawLottoService {

    public void draw() {
        RaffleMachine raffleMachine = RaffleMachineRepository.find();
        User user = UserRepository.find();
        user.draw(raffleMachine);
    }

    public void decideAnswer(List<Integer> answer, int bonus) {
        RaffleMachine raffleMachine = RaffleMachineRepository.find();
        raffleMachine.decideAnswer(answer, bonus);
    }
}
