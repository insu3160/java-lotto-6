package lotto.view;

import java.util.List;
import lotto.enums.LottoStatus;
import lotto.model.LottoResult;
import lotto.service.LottoDto;

public class OutputView {
    public static final String WINNING_STATISTICS = "당첨 통계";

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void displayLottos(List<LottoDto> lottoDtos) {
        printEmptyLine();
        System.out.println(lottoDtos.size() + "개 구매하셨습니다.");
        for (int i = 0; i < lottoDtos.size(); i++) {
            System.out.println(lottoDtos.get(i).numbers());
        }
        printEmptyLine();
    }

    public static void displayResult(LottoResult lottoResult) {
        printEmptyLine();
        System.out.println(WINNING_STATISTICS);
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.statusCount(LottoStatus.FIFTH));
        System.out.println("4개 일치 (50,000원) - " + lottoResult.statusCount(LottoStatus.FOURTH));
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.statusCount(LottoStatus.THIRD));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.statusCount(LottoStatus.SECOND));
        System.out.println("6개 일치, 보너스 볼 일치 (2,000,000,000원) - " + lottoResult.statusCount(LottoStatus.FIRST));
        System.out.println("총 수익률은 " + lottoResult.caculateProfitRate() + "입니다.");
    }

    public static void printEmptyLine() {
        System.out.println();
    }


}
