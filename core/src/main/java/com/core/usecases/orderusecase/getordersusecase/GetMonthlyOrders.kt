package com.core.usecases.orderusecase.getordersusecase

import com.core.data.repository.OrderRepository
import com.core.domain.order.OrderDetails

class GetMonthlyOrders(private var orderRepository: OrderRepository) {
    fun invoke(): List<OrderDetails>? {
        return orderRepository.getOrdersForRetailerMonthlySubscription()
    }
}