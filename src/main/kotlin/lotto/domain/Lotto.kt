package lotto.domain

import lotto.error.ErrorMessage.LOTTO_COUNT_ERROR
import lotto.error.ErrorMessage.LOTTO_DUPLICATION_ERROR

class Lotto(val lotto: List<LottoNumber>) {

    init {
        require(lotto.size == LOTTO_NUMBER_COUNT) { LOTTO_COUNT_ERROR.message }
        require(lotto.distinct().size == LOTTO_NUMBER_COUNT) { LOTTO_DUPLICATION_ERROR.message }
    }

    fun countMatchingNumbers(jackpotNumbers: Lotto): Int {
        return lotto.count { jackpotNumbers.lotto.contains(it) }
    }

    fun checkBonusNumberMatch(bonusNumber: LottoNumber): Boolean {
        return lotto.contains(bonusNumber)
    }

    override fun toString(): String {
        return "Lotto(lotto=$lotto)"
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
