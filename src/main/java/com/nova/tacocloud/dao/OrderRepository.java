package com.nova.tacocloud.dao;

import com.nova.tacocloud.domain.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);
}
