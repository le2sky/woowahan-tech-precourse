package lotto.service;

import lotto.domain.LottoHistory;
import lotto.domain.Revenue;
import lotto.domain.User;
import lotto.repository.UserRepository;

import java.util.List;

public class DisplayResultService {

    public Revenue calculateRevenue() {
        User user = UserRepository.find();
        return user.calculateRevenue();
    }

    public List<LottoHistory> showHistories() {
        User user = UserRepository.find();
        return user.getHistories();
    }
}
