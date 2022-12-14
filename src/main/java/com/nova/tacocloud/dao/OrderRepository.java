package com.nova.tacocloud.dao;

import com.nova.tacocloud.domain.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<TacoOrder, Long> {

}
