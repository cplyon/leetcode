fun main() {

    var prices = listOf(7, 1, 5, 3, 6, 4)
    println(maxProfit_nsquared(prices))
    println(maxProfit_linear(prices))
    println(maxProfit2(prices))

}


fun maxProfit_nsquared(prices: List<Int>): Int {
    var buy = 0
    var sell = 0
    var bestProfit = 0

    while (buy < prices.size) {
        while (sell < prices.size) {
            bestProfit = Math.max(prices[sell] - prices[buy], bestProfit)
            sell++
        }
        buy++
        sell = buy
    }
    
    return bestProfit
}


fun maxProfit_linear(prices: List<Int>): Int {
    var buy = 0
    var sell = 0
    var bestProfit = 0

    for (i in 1 until prices.size) {
        if (prices[i] <= prices[buy]) {
            buy = i
            sell = Math.max(buy, sell)
        }
        if (prices[i] >= prices[sell]) {
            sell = i
        }
        bestProfit = Math.max(prices[sell] - prices[buy], bestProfit)
    }
    
    return bestProfit
}


fun maxProfit2(prices: List<Int>): Int {
    var buy = 0
    var sell = 0
    var bestProfit = 0
    var maxProfit = 0

    for (i in 1 until prices.size) {
        if (prices[i] <= prices[buy]) {
            buy = i
            sell = Math.max(buy, sell)
        }
        if (prices[i] >= prices[sell]) {
            sell = i
        }
        if (bestProfit < prices[sell] - prices[buy]) {
            maxProfit += prices[sell] - prices[buy]
            buy = sell
            bestProfit = 0
        }
    }    
    return maxProfit
}